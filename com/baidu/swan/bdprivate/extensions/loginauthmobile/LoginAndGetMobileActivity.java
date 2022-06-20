package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kz2;
import com.repackage.md3;
import com.repackage.ph3;
import com.repackage.qh3;
import com.repackage.rh3;
import com.repackage.tc3;
import com.repackage.zi2;
/* loaded from: classes2.dex */
public class LoginAndGetMobileActivity extends FragmentActivity implements SwanAppLoginAndGetMobileDialog.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public String b;
    public boolean c;
    public SwanAppLoginAndGetMobileDialog d;
    public QuickLoginInfo e;
    public String f;
    public String g;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginAndGetMobileActivity a;

        public a(LoginAndGetMobileActivity loginAndGetMobileActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginAndGetMobileActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loginAndGetMobileActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LoginAndGetMobileActivity loginAndGetMobileActivity = this.a;
                tc3.a(loginAndGetMobileActivity, loginAndGetMobileActivity.getWindow().getDecorView().getWindowToken());
            }
        }
    }

    public LoginAndGetMobileActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = "";
        this.c = false;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.b
    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.finish();
            if (this.d instanceof SwanAppPhoneLoginDialog) {
                tc3.a(this, getWindow().getDecorView().getWindowToken());
            }
            overridePendingTransition(0, R.anim.obfuscated_res_0x7f010094);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            r0();
            s0();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            int c0 = md3.c0(this);
            super.onCreate(bundle);
            md3.g(this, c0);
            getWindow().addFlags(256);
            getWindow().addFlags(512);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags &= -1025;
            getWindow().setAttributes(attributes);
            setContentView(R.layout.obfuscated_res_0x7f0d00b7);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.b = extras.getString("app_name", "");
                this.e = (QuickLoginInfo) extras.getParcelable("quick_login_info");
                this.f = extras.getString("launch_from");
                this.g = extras.getString("appid");
            }
            this.c = zi2.M().a();
            o0();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.d instanceof SwanAppPhoneLoginDialog) {
                md3.e0(new a(this));
            }
            super.onPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean a2 = zi2.M().a();
            if (this.c != a2) {
                SwanAppLoginAndGetMobileDialog swanAppLoginAndGetMobileDialog = this.d;
                if (swanAppLoginAndGetMobileDialog != null) {
                    swanAppLoginAndGetMobileDialog.v1(a2);
                }
                this.c = a2;
            }
            super.onResume();
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.b
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            ph3.a().onResult(i);
            if (i != 0) {
                kz2.f(this, R.string.obfuscated_res_0x7f0f12df).H(true);
            } else {
                finish();
            }
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091abd);
            this.a = linearLayout;
            linearLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060b0f));
            this.a.getBackground().mutate().setAlpha(0);
        }
    }

    public final void s0() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.d = rh3.a(this.b, this.c, this.e, this.f, this.g);
            QuickLoginInfo quickLoginInfo = this.e;
            if (quickLoginInfo == null || !quickLoginInfo.supportQuickLogin) {
                str = "swan_phone_login";
                str2 = "telLogin";
            } else {
                str = "swan_quick_login";
                str2 = "quickLogin";
            }
            this.d.x1(this);
            this.d.A1(this);
            this.d.show(getSupportFragmentManager(), str);
            qh3.a("show", str2, null, this.f, this.g);
        }
    }
}
