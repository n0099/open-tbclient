package com.baidu.swan.gamecenter.appmanager.install;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import d.b.h0.a.i2.c0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.v;
import d.b.h0.f.b;
import d.b.h0.f.d;
import d.b.h0.f.e;
import d.b.h0.f.f.h.c;
import org.json.JSONObject;
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
            c.a(InstallAntiBlockingActivity.this.mPackageName, TextUtils.equals(InstallAntiBlockingActivity.this.mType, "authorize") ? "authorizeClick" : "continueClick", "success", null, new d.b.h0.f.f.h.a(InstallAntiBlockingActivity.this.mUbcParams));
            InstallAntiBlockingActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int V = k0.V(this);
        super.onCreate(bundle);
        k0.h(this, V);
        d.b.h0.f.f.e.a.s();
        setContentView(e.aiapps_install_guide_layout);
        Intent intent = getIntent();
        if (intent != null) {
            this.mType = intent.getStringExtra("type");
            this.mPackageName = intent.getStringExtra("packageName");
            this.mUbcParams = v.b(intent.getStringExtra(KEY_UBC_PARAMS));
        }
        ImageView imageView = (ImageView) findViewById(d.install_guide_image);
        View findViewById = findViewById(d.install_guide_layout);
        if (TextUtils.equals(this.mType, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(b.aiapps_install_image_height));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(d.install_guide_image_mask).setVisibility(0);
            imageView.setImageResource(d.b.h0.f.c.aiapps_install_guide_request);
            findViewById(d.install_guide_bg_mask).setBackgroundResource(d.b.h0.f.a.aiapps_install_guide_mask);
            d.b.h0.f.f.e.a.o();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(b.aiapps_install_guide_image_height));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(d.install_guide_image_mask).setVisibility(8);
            if (c0.j()) {
                imageView.setImageResource(d.b.h0.f.c.aiapps_install_guide_emui);
            } else if (c0.k()) {
                imageView.setImageResource(d.b.h0.f.c.aiapps_install_guide_miui);
            } else if (c0.m()) {
                imageView.setImageResource(d.b.h0.f.c.aiapps_install_guide_vivo);
            } else {
                imageView.setImageResource(d.b.h0.f.c.aiapps_install_guide_default);
            }
            findViewById(d.install_guide_bg_mask).setBackgroundResource(d.b.h0.f.a.aiapps_anti_block_mask);
            d.b.h0.f.f.e.a.p();
        }
        findViewById.setOnClickListener(new a());
        c.a(this.mPackageName, this.mType, "success", null, new d.b.h0.f.f.h.a(this.mUbcParams));
    }
}
