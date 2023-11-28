package com.baidu.swan.game.guide.install;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.tieba.bk3;
import com.baidu.tieba.hj3;
import com.baidu.tieba.qj3;
import com.baidu.tieba.zw3;
@SuppressLint({"BaseActivity"})
/* loaded from: classes4.dex */
public class GameNowInstallAntiBlockingActivity extends Activity {
    public String a;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TextUtils.equals(GameNowInstallAntiBlockingActivity.this.a, "authorize");
            GameNowInstallAntiBlockingActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = bk3.c0(this);
        super.onCreate(bundle);
        bk3.g(this, c0);
        zw3.q();
        setContentView(R.layout.obfuscated_res_0x7f0d00ba);
        Intent intent = getIntent();
        if (intent != null) {
            this.a = intent.getStringExtra("type");
            intent.getStringExtra("packageName");
            hj3.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911c5);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0911c7);
        if (TextUtils.equals(this.a, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070154));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(R.id.obfuscated_res_0x7f0911c6).setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019e);
            findViewById(R.id.obfuscated_res_0x7f0911c3).setBackgroundResource(R.color.obfuscated_res_0x7f06043e);
            zw3.n();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070153));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(R.id.obfuscated_res_0x7f0911c6).setVisibility(8);
            if (qj3.m()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019c);
            } else if (qj3.n()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019d);
            } else if (qj3.r()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019f);
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019b);
            }
            findViewById(R.id.obfuscated_res_0x7f0911c3).setBackgroundResource(R.color.obfuscated_res_0x7f06040c);
            zw3.o();
        }
        findViewById.setOnClickListener(new a());
    }
}
