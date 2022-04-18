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
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.de3;
import com.repackage.hs3;
import com.repackage.jd3;
import com.repackage.js3;
import com.repackage.sd3;
import com.repackage.xr3;
import org.json.JSONObject;
@SuppressLint({"BaseActivity"})
/* loaded from: classes2.dex */
public class InstallAntiBlockingActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TYPE = "type";
    public static final String KEY_UBC_PARAMS = "ubc_params";
    public static final String PARAM_PACKAGE_NAME = "packageName";
    public transient /* synthetic */ FieldHolder $fh;
    public String mPackageName;
    public String mType;
    public JSONObject mUbcParams;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InstallAntiBlockingActivity a;

        public a(InstallAntiBlockingActivity installAntiBlockingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {installAntiBlockingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = installAntiBlockingActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                js3.a(this.a.mPackageName, TextUtils.equals(this.a.mType, "authorize") ? "authorizeClick" : "continueClick", "success", null, new hs3(this.a.mUbcParams));
                this.a.finish();
            }
        }
    }

    public InstallAntiBlockingActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            int c0 = de3.c0(this);
            super.onCreate(bundle);
            de3.g(this, c0);
            xr3.t();
            setContentView(R.layout.obfuscated_res_0x7f0d00b7);
            Intent intent = getIntent();
            if (intent != null) {
                this.mType = intent.getStringExtra("type");
                this.mPackageName = intent.getStringExtra("packageName");
                this.mUbcParams = jd3.d(intent.getStringExtra("ubc_params"));
            }
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f06);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f090f08);
            if (TextUtils.equals(this.mType, "authorize")) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07014f));
                layoutParams.gravity = 80;
                imageView.setLayoutParams(layoutParams);
                findViewById(R.id.obfuscated_res_0x7f090f07).setVisibility(0);
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017e);
                findViewById(R.id.obfuscated_res_0x7f090f04).setBackgroundResource(R.color.obfuscated_res_0x7f0603b0);
                xr3.o();
            } else {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07014e));
                layoutParams2.gravity = 80;
                imageView.setLayoutParams(layoutParams2);
                findViewById(R.id.obfuscated_res_0x7f090f07).setVisibility(8);
                if (sd3.m()) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017c);
                } else if (sd3.n()) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017d);
                } else if (sd3.r()) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017f);
                } else {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017b);
                }
                findViewById(R.id.obfuscated_res_0x7f090f04).setBackgroundResource(R.color.obfuscated_res_0x7f06037f);
                xr3.p();
            }
            findViewById.setOnClickListener(new a(this));
            js3.a(this.mPackageName, this.mType, "success", null, new hs3(this.mUbcParams));
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
