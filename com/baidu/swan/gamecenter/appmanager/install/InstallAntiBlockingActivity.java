package com.baidu.swan.gamecenter.appmanager.install;

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
import com.baidu.tieba.ep3;
import com.baidu.tieba.k34;
import com.baidu.tieba.pp3;
import com.baidu.tieba.u34;
import com.baidu.tieba.vo3;
import com.baidu.tieba.w34;
import org.json.JSONObject;
@SuppressLint({"BaseActivity"})
/* loaded from: classes4.dex */
public class InstallAntiBlockingActivity extends Activity {
    public String a;
    public JSONObject b;
    public String c;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            if (TextUtils.equals(InstallAntiBlockingActivity.this.c, "authorize")) {
                str = "authorizeClick";
            } else {
                str = "continueClick";
            }
            w34.a(InstallAntiBlockingActivity.this.a, str, "success", null, new u34(InstallAntiBlockingActivity.this.b));
            InstallAntiBlockingActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = pp3.c0(this);
        super.onCreate(bundle);
        pp3.g(this, c0);
        k34.t();
        setContentView(R.layout.obfuscated_res_0x7f0d00b5);
        Intent intent = getIntent();
        if (intent != null) {
            this.c = intent.getStringExtra("type");
            this.a = intent.getStringExtra("packageName");
            this.b = vo3.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09112b);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f09112d);
        if (TextUtils.equals(this.c, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070154));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(R.id.obfuscated_res_0x7f09112c).setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080198);
            findViewById(R.id.obfuscated_res_0x7f091129).setBackgroundResource(R.color.obfuscated_res_0x7f060434);
            k34.o();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070153));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(R.id.obfuscated_res_0x7f09112c).setVisibility(8);
            if (ep3.m()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080196);
            } else if (ep3.n()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080197);
            } else if (ep3.r()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080199);
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080195);
            }
            findViewById(R.id.obfuscated_res_0x7f091129).setBackgroundResource(R.color.obfuscated_res_0x7f060402);
            k34.p();
        }
        findViewById.setOnClickListener(new a());
        w34.a(this.a, this.c, "success", null, new u34(this.b));
    }
}
