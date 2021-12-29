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
import c.a.r0.a.z2.f0;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.w;
import c.a.r0.h.b;
import c.a.r0.h.d;
import c.a.r0.h.e;
import c.a.r0.h.f;
import c.a.r0.i.b.i.c;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@SuppressLint({"BaseActivity"})
/* loaded from: classes11.dex */
public class InstallAntiBlockingActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TYPE = "type";
    public static final String KEY_UBC_PARAMS = "ubc_params";
    public static final String PARAM_PACKAGE_NAME = "packageName";
    public transient /* synthetic */ FieldHolder $fh;
    public String mPackageName;
    public String mType;
    public JSONObject mUbcParams;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InstallAntiBlockingActivity f41140e;

        public a(InstallAntiBlockingActivity installAntiBlockingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {installAntiBlockingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41140e = installAntiBlockingActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a(this.f41140e.mPackageName, TextUtils.equals(this.f41140e.mType, "authorize") ? "authorizeClick" : "continueClick", "success", null, new c.a.r0.i.b.i.a(this.f41140e.mUbcParams));
                this.f41140e.finish();
            }
        }
    }

    public InstallAntiBlockingActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            int c0 = q0.c0(this);
            super.onCreate(bundle);
            q0.g(this, c0);
            c.a.r0.i.b.e.a.t();
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
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(c.a.r0.h.c.aiapps_install_image_height));
                layoutParams.gravity = 80;
                imageView.setLayoutParams(layoutParams);
                findViewById(e.install_guide_image_mask).setVisibility(0);
                imageView.setImageResource(d.aiapps_install_guide_request);
                findViewById(e.install_guide_bg_mask).setBackgroundResource(b.aiapps_install_guide_mask);
                c.a.r0.i.b.e.a.o();
            } else {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(c.a.r0.h.c.aiapps_install_guide_image_height));
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
                c.a.r0.i.b.e.a.p();
            }
            findViewById.setOnClickListener(new a(this));
            c.a(this.mPackageName, this.mType, "success", null, new c.a.r0.i.b.i.a(this.mUbcParams));
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
