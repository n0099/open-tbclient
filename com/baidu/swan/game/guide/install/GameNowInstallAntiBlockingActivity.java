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
import com.baidu.tieba.ap3;
import com.baidu.tieba.go3;
import com.baidu.tieba.po3;
import com.baidu.tieba.y14;
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
        int c0 = ap3.c0(this);
        super.onCreate(bundle);
        ap3.g(this, c0);
        y14.q();
        setContentView(R.layout.obfuscated_res_0x7f0d00ba);
        Intent intent = getIntent();
        if (intent != null) {
            this.a = intent.getStringExtra("type");
            intent.getStringExtra("packageName");
            go3.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091145);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091147);
        if (TextUtils.equals(this.a, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070156));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(R.id.obfuscated_res_0x7f091146).setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080199);
            findViewById(R.id.obfuscated_res_0x7f091143).setBackgroundResource(R.color.obfuscated_res_0x7f06043c);
            y14.n();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070155));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(R.id.obfuscated_res_0x7f091146).setVisibility(8);
            if (po3.m()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080197);
            } else if (po3.n()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080198);
            } else if (po3.r()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019a);
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080196);
            }
            findViewById(R.id.obfuscated_res_0x7f091143).setBackgroundResource(R.color.obfuscated_res_0x7f06040a);
            y14.o();
        }
        findViewById.setOnClickListener(new a());
    }
}
