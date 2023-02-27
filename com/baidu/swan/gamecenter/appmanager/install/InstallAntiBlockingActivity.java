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
import com.baidu.tieba.b14;
import com.baidu.tieba.gn3;
import com.baidu.tieba.l14;
import com.baidu.tieba.mm3;
import com.baidu.tieba.n14;
import com.baidu.tieba.vm3;
import org.json.JSONObject;
@SuppressLint({"BaseActivity"})
/* loaded from: classes3.dex */
public class InstallAntiBlockingActivity extends Activity {
    public String a;
    public JSONObject b;
    public String c;

    /* loaded from: classes3.dex */
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
            n14.a(InstallAntiBlockingActivity.this.a, str, "success", null, new l14(InstallAntiBlockingActivity.this.b));
            InstallAntiBlockingActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = gn3.c0(this);
        super.onCreate(bundle);
        gn3.g(this, c0);
        b14.t();
        setContentView(R.layout.obfuscated_res_0x7f0d00b2);
        Intent intent = getIntent();
        if (intent != null) {
            this.c = intent.getStringExtra("type");
            this.a = intent.getStringExtra("packageName");
            this.b = mm3.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091074);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091076);
        if (TextUtils.equals(this.c, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07014d));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(R.id.obfuscated_res_0x7f091075).setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017e);
            findViewById(R.id.obfuscated_res_0x7f091072).setBackgroundResource(R.color.obfuscated_res_0x7f060311);
            b14.o();
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
            b14.p();
        }
        findViewById.setOnClickListener(new a());
        n14.a(this.a, this.c, "success", null, new l14(this.b));
    }
}
