package com.fwk.reader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SpalshActivity extends AppCompatActivity {

    @Bind(R.id.tv_skip)
    TextView mTvSkip;

    private boolean flag = false;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        ButterKnife.bind(this);

        this.runnable = new Runnable() {
            @Override
            public void run() {
                goHome();
            }
        };

        mTvSkip.postDelayed(runnable,3000);

        mTvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });
    }

    private void goHome(){
        if (!flag){
            flag = true;
            Intent intent = new Intent(SpalshActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag = true;
        mTvSkip.removeCallbacks(runnable);
        ButterKnife.unbind(this);
    }
}
