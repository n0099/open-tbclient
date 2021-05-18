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
import d.a.i0.a.v2.f0;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.w;
import d.a.i0.f.b;
import d.a.i0.f.d;
import d.a.i0.f.e;
import d.a.i0.f.f;
import d.a.i0.g.c.i.c;
import org.json.JSONObject;
@SuppressLint({"BaseActivity"})
/* loaded from: classes3.dex */
public class InstallAntiBlockingActivity extends Activity {
    public static final String KEY_TYPE = "type";
    public static final String KEY_UBC_PARAMS = "ubc_params";
    public static final String PARAM_PACKAGE_NAME = "packageName";
    public String mPackageName;
    public String mType;
    public JSONObject mUbcParams;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a(InstallAntiBlockingActivity.this.mPackageName, TextUtils.equals(InstallAntiBlockingActivity.this.mType, "authorize") ? "authorizeClick" : "continueClick", "success", null, new d.a.i0.g.c.i.a(InstallAntiBlockingActivity.this.mUbcParams));
            InstallAntiBlockingActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int Z = q0.Z(this);
        super.onCreate(bundle);
        q0.g(this, Z);
        d.a.i0.g.c.e.a.t();
        setContentView(f.aiapps_install_guide_layout);
        Intent intent = getIntent();
        if (intent != null) {
            this.mType = intent.getStringExtra("type");
            this.mPackageName = intent.getStringExtra("packageName");
            this.mUbcParams = w.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(e.install_guide_image);
        View findViewById = findViewById(e.install_guide_layout);
        if (TextUtils.equals(this.mType, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(d.a.i0.f.c.aiapps_install_image_height));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(e.install_guide_image_mask).setVisibility(0);
            imageView.setImageResource(d.aiapps_install_guide_request);
            findViewById(e.install_guide_bg_mask).setBackgroundResource(b.aiapps_install_guide_mask);
            d.a.i0.g.c.e.a.o();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(d.a.i0.f.c.aiapps_install_guide_image_height));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(e.install_guide_image_mask).setVisibility(8);
            if (f0.m()) {
                imageView.setImageResource(d.aiapps_install_guide_emui);
            } else if (f0.n()) {
                imageView.setImageResource(d.aiapps_install_guide_miui);
            } else if (f0.r()) {
                imageView.setImageResource(d.aiapps_install_guide_vivo);
            } else {
                imageView.setImageResource(d.aiapps_install_guide_default);
            }
            findViewById(e.install_guide_bg_mask).setBackgroundResource(b.aiapps_anti_block_mask);
            d.a.i0.g.c.e.a.p();
        }
        findViewById.setOnClickListener(new a());
        c.a(this.mPackageName, this.mType, "success", null, new d.a.i0.g.c.i.a(this.mUbcParams));
    }
}
