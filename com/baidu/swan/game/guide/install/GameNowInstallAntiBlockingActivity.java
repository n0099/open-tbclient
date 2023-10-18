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
import com.baidu.tieba.hw3;
import com.baidu.tieba.jj3;
import com.baidu.tieba.pi3;
import com.baidu.tieba.yi3;
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
        int c0 = jj3.c0(this);
        super.onCreate(bundle);
        jj3.g(this, c0);
        hw3.q();
        setContentView(R.layout.obfuscated_res_0x7f0d00b7);
        Intent intent = getIntent();
        if (intent != null) {
            this.a = intent.getStringExtra("type");
            intent.getStringExtra("packageName");
            pi3.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09115f);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091161);
        if (TextUtils.equals(this.a, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070154));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(R.id.obfuscated_res_0x7f091160).setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080199);
            findViewById(R.id.obfuscated_res_0x7f09115d).setBackgroundResource(R.color.obfuscated_res_0x7f06043c);
            hw3.n();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070153));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(R.id.obfuscated_res_0x7f091160).setVisibility(8);
            if (yi3.m()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080197);
            } else if (yi3.n()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080198);
            } else if (yi3.r()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019a);
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080196);
            }
            findViewById(R.id.obfuscated_res_0x7f09115d).setBackgroundResource(R.color.obfuscated_res_0x7f06040a);
            hw3.o();
        }
        findViewById.setOnClickListener(new a());
    }
}
