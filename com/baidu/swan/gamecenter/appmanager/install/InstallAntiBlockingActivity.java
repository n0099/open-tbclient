package com.baidu.swan.gamecenter.appmanager.install;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bv3;
import com.baidu.tieba.gh3;
import com.baidu.tieba.lv3;
import com.baidu.tieba.mg3;
import com.baidu.tieba.nv3;
import com.baidu.tieba.vg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
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
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (TextUtils.equals(this.a.c, "authorize")) {
                    str = "authorizeClick";
                } else {
                    str = "continueClick";
                }
                nv3.a(this.a.a, str, "success", null, new lv3(this.a.b));
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
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            int c0 = gh3.c0(this);
            super.onCreate(bundle);
            gh3.g(this, c0);
            bv3.t();
            setContentView(R.layout.obfuscated_res_0x7f0d00b1);
            Intent intent = getIntent();
            if (intent != null) {
                this.c = intent.getStringExtra("type");
                this.a = intent.getStringExtra("packageName");
                this.b = mg3.d(intent.getStringExtra("ubc_params"));
            }
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f31);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f090f33);
            if (TextUtils.equals(this.c, "authorize")) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07014d));
                layoutParams.gravity = 80;
                imageView.setLayoutParams(layoutParams);
                findViewById(R.id.obfuscated_res_0x7f090f32).setVisibility(0);
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017e);
                findViewById(R.id.obfuscated_res_0x7f090f2f).setBackgroundResource(R.color.obfuscated_res_0x7f0603c9);
                bv3.o();
            } else {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07014c));
                layoutParams2.gravity = 80;
                imageView.setLayoutParams(layoutParams2);
                findViewById(R.id.obfuscated_res_0x7f090f32).setVisibility(8);
                if (vg3.m()) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017c);
                } else if (vg3.n()) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017d);
                } else if (vg3.r()) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017f);
                } else {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017b);
                }
                findViewById(R.id.obfuscated_res_0x7f090f2f).setBackgroundResource(R.color.obfuscated_res_0x7f060398);
                bv3.p();
            }
            findViewById.setOnClickListener(new a(this));
            nv3.a(this.a, this.c, "success", null, new lv3(this.b));
        }
    }
}
