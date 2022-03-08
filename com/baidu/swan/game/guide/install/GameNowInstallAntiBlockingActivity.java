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
import c.a.p0.a.p2.f0;
import c.a.p0.a.p2.q0;
import c.a.p0.a.p2.w;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@SuppressLint({"BaseActivity"})
/* loaded from: classes5.dex */
public class GameNowInstallAntiBlockingActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TYPE = "type";
    public static final String KEY_UBC_PARAMS = "ubc_params";
    public static final String PARAM_PACKAGE_NAME = "packageName";
    public transient /* synthetic */ FieldHolder $fh;
    public String mPackageName;
    public String mType;
    public JSONObject mUbcParams;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameNowInstallAntiBlockingActivity f38377e;

        public a(GameNowInstallAntiBlockingActivity gameNowInstallAntiBlockingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameNowInstallAntiBlockingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38377e = gameNowInstallAntiBlockingActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TextUtils.equals(this.f38377e.mType, "authorize");
                this.f38377e.finish();
            }
        }
    }

    public GameNowInstallAntiBlockingActivity() {
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
            c.a.p0.h.b.g.a.q();
            setContentView(R.layout.aiapps_install_guide_layout);
            Intent intent = getIntent();
            if (intent != null) {
                this.mType = intent.getStringExtra("type");
                this.mPackageName = intent.getStringExtra("packageName");
                this.mUbcParams = w.d(intent.getStringExtra("ubc_params"));
            }
            ImageView imageView = (ImageView) findViewById(R.id.install_guide_image);
            View findViewById = findViewById(R.id.install_guide_layout);
            if (TextUtils.equals(this.mType, "authorize")) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.aiapps_install_image_height));
                layoutParams.gravity = 80;
                imageView.setLayoutParams(layoutParams);
                findViewById(R.id.install_guide_image_mask).setVisibility(0);
                imageView.setImageResource(R.drawable.aiapps_install_guide_request);
                findViewById(R.id.install_guide_bg_mask).setBackgroundResource(R.color.aiapps_install_guide_mask);
                c.a.p0.h.b.g.a.n();
            } else {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.aiapps_install_guide_image_height));
                layoutParams2.gravity = 80;
                imageView.setLayoutParams(layoutParams2);
                findViewById(R.id.install_guide_image_mask).setVisibility(8);
                if (f0.m()) {
                    imageView.setImageResource(R.drawable.aiapps_install_guide_emui);
                } else if (f0.n()) {
                    imageView.setImageResource(R.drawable.aiapps_install_guide_miui);
                } else if (f0.r()) {
                    imageView.setImageResource(R.drawable.aiapps_install_guide_vivo);
                } else {
                    imageView.setImageResource(R.drawable.aiapps_install_guide_default);
                }
                findViewById(R.id.install_guide_bg_mask).setBackgroundResource(R.color.aiapps_anti_block_mask);
                c.a.p0.h.b.g.a.o();
            }
            findViewById.setOnClickListener(new a(this));
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
