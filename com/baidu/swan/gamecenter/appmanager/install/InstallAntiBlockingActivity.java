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
import com.repackage.ie3;
import com.repackage.ns3;
import com.repackage.te3;
import com.repackage.xs3;
import com.repackage.zd3;
import com.repackage.zs3;
import com.sina.weibo.sdk.share.BaseActivity;
import org.json.JSONObject;
@SuppressLint({BaseActivity.TAG})
/* loaded from: classes3.dex */
public class InstallAntiBlockingActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public JSONObject b;
    public String c;

    /* loaded from: classes3.dex */
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
                zs3.a(this.a.a, TextUtils.equals(this.a.c, "authorize") ? "authorizeClick" : "continueClick", "success", null, new xs3(this.a.b));
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
            int c0 = te3.c0(this);
            super.onCreate(bundle);
            te3.g(this, c0);
            ns3.t();
            setContentView(R.layout.obfuscated_res_0x7f0d00ae);
            Intent intent = getIntent();
            if (intent != null) {
                this.c = intent.getStringExtra("type");
                this.a = intent.getStringExtra("packageName");
                this.b = zd3.d(intent.getStringExtra("ubc_params"));
            }
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f21);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f090f23);
            if (TextUtils.equals(this.c, "authorize")) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07014d));
                layoutParams.gravity = 80;
                imageView.setLayoutParams(layoutParams);
                findViewById(R.id.obfuscated_res_0x7f090f22).setVisibility(0);
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017d);
                findViewById(R.id.obfuscated_res_0x7f090f1f).setBackgroundResource(R.color.obfuscated_res_0x7f0603c5);
                ns3.o();
            } else {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07014c));
                layoutParams2.gravity = 80;
                imageView.setLayoutParams(layoutParams2);
                findViewById(R.id.obfuscated_res_0x7f090f22).setVisibility(8);
                if (ie3.m()) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017b);
                } else if (ie3.n()) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017c);
                } else if (ie3.r()) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017e);
                } else {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017a);
                }
                findViewById(R.id.obfuscated_res_0x7f090f1f).setBackgroundResource(R.color.obfuscated_res_0x7f060394);
                ns3.p();
            }
            findViewById.setOnClickListener(new a(this));
            zs3.a(this.a, this.c, "success", null, new xs3(this.b));
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
