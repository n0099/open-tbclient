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
import com.baidu.tieba.e04;
import com.baidu.tieba.gn3;
import com.baidu.tieba.mm3;
import com.baidu.tieba.vm3;
@SuppressLint({"BaseActivity"})
/* loaded from: classes3.dex */
public class GameNowInstallAntiBlockingActivity extends Activity {
    public String a;

    /* loaded from: classes3.dex */
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
        int c0 = gn3.c0(this);
        super.onCreate(bundle);
        gn3.g(this, c0);
        e04.q();
        setContentView(R.layout.obfuscated_res_0x7f0d00b2);
        Intent intent = getIntent();
        if (intent != null) {
            this.a = intent.getStringExtra("type");
            intent.getStringExtra("packageName");
            mm3.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091074);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091076);
        if (TextUtils.equals(this.a, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07014d));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(R.id.obfuscated_res_0x7f091075).setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017e);
            findViewById(R.id.obfuscated_res_0x7f091072).setBackgroundResource(R.color.obfuscated_res_0x7f060311);
            e04.n();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07014c));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(R.id.obfuscated_res_0x7f091075).setVisibility(8);
            if (vm3.m()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017c);
            } else if (vm3.n()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017d);
            } else if (vm3.r()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017f);
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017b);
            }
            findViewById(R.id.obfuscated_res_0x7f091072).setBackgroundResource(R.color.obfuscated_res_0x7f0602e0);
            e04.o();
        }
        findViewById.setOnClickListener(new a());
    }
}
