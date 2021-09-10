package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import c.a.p0.a.v2.q0;
import c.a.p0.a.v2.x;
import c.a.p0.b.b;
import c.a.p0.b.c;
import c.a.p0.b.f;
import c.a.p0.b.g;
import c.a.p0.b.h;
import c.a.p0.b.p.d.d;
import c.a.p0.b.p.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class LoginAndGetMobileActivity extends FragmentActivity implements SwanAppLoginAndGetMobileDialog.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LoginAndGetMobileActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAppId;
    public String mAuthTip;
    public SwanAppLoginAndGetMobileDialog mGetMobileDialog;
    public boolean mIsNightMode;
    public String mLaunchFrom;
    public QuickLoginInfo mQuickLoginInfo;
    public LinearLayout mRootView;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LoginAndGetMobileActivity f46734e;

        public a(LoginAndGetMobileActivity loginAndGetMobileActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginAndGetMobileActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46734e = loginAndGetMobileActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LoginAndGetMobileActivity loginAndGetMobileActivity = this.f46734e;
                x.a(loginAndGetMobileActivity, loginAndGetMobileActivity.getWindow().getDecorView().getWindowToken());
            }
        }
    }

    public LoginAndGetMobileActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAuthTip = "";
        this.mIsNightMode = false;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            initRootView();
            showLoginDialog();
        }
    }

    private void initRootView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(f.root);
            this.mRootView = linearLayout;
            linearLayout.setBackgroundColor(getResources().getColor(c.white));
            this.mRootView.getBackground().mutate().setAlpha(0);
        }
    }

    private void showLoginDialog() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mGetMobileDialog = e.a(this.mAuthTip, this.mIsNightMode, this.mQuickLoginInfo, this.mLaunchFrom, this.mAppId);
            QuickLoginInfo quickLoginInfo = this.mQuickLoginInfo;
            if (quickLoginInfo == null || !quickLoginInfo.supportQuickLogin) {
                str = "swan_phone_login";
                str2 = "telLogin";
            } else {
                str = "swan_quick_login";
                str2 = "quickLogin";
            }
            this.mGetMobileDialog.setActivity(this);
            this.mGetMobileDialog.setLoginStatusCallback(this);
            this.mGetMobileDialog.show(getSupportFragmentManager(), str);
            d.a("show", str2, null, this.mLaunchFrom, this.mAppId);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            if (this.mGetMobileDialog instanceof SwanAppPhoneLoginDialog) {
                x.a(this, getWindow().getDecorView().getWindowToken());
            }
            overridePendingTransition(0, b.login_get_mobile_act_exit);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int Z = q0.Z(this);
            super.onCreate(bundle);
            q0.g(this, Z);
            getWindow().addFlags(256);
            getWindow().addFlags(512);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags &= -1025;
            getWindow().setAttributes(attributes);
            setContentView(g.aiapps_login_getmobile_act_layout);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.mAuthTip = extras.getString("app_name", "");
                this.mQuickLoginInfo = (QuickLoginInfo) extras.getParcelable("quick_login_info");
                this.mLaunchFrom = extras.getString("launch_from");
                this.mAppId = extras.getString("appid");
            }
            this.mIsNightMode = c.a.p0.a.c1.a.H().a();
            init();
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.b
    public void onDialogDismiss(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && z) {
            finish();
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.b
    public void onLoginResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            c.a.p0.b.p.d.c.a().onResult(i2);
            if (i2 != 0) {
                c.a.p0.a.z1.b.f.e.f(this, h.swanapp_login_fail).G(true);
            } else {
                finish();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.mGetMobileDialog instanceof SwanAppPhoneLoginDialog) {
                q0.b0(new a(this));
            }
            super.onPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean a2 = c.a.p0.a.c1.a.H().a();
            if (this.mIsNightMode != a2) {
                SwanAppLoginAndGetMobileDialog swanAppLoginAndGetMobileDialog = this.mGetMobileDialog;
                if (swanAppLoginAndGetMobileDialog != null) {
                    swanAppLoginAndGetMobileDialog.refreshUI(a2);
                }
                this.mIsNightMode = a2;
            }
            super.onResume();
        }
    }
}
