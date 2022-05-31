package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
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
import com.repackage.bd3;
import com.repackage.eh3;
import com.repackage.fh3;
import com.repackage.gh3;
import com.repackage.ic3;
import com.repackage.oi2;
import com.repackage.zy2;
/* loaded from: classes2.dex */
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
                ic3.a(loginAndGetMobileActivity, loginAndGetMobileActivity.getWindow().getDecorView().getWindowToken());
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
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091ac5);
            this.mRootView = linearLayout;
            linearLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060b12));
            this.mRootView.getBackground().mutate().setAlpha(0);
        }
    }

    private void showLoginDialog() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mGetMobileDialog = gh3.a(this.mAuthTip, this.mIsNightMode, this.mQuickLoginInfo, this.mLaunchFrom, this.mAppId);
            QuickLoginInfo quickLoginInfo = this.mQuickLoginInfo;
            if (quickLoginInfo == null || !quickLoginInfo.supportQuickLogin) {
                str = "swan_phone_login";
                str2 = "telLogin";
            } else {
                str = "swan_quick_login";
                str2 = "quickLogin";
            }
            this.mGetMobileDialog.K0(this);
            this.mGetMobileDialog.M0(this);
            this.mGetMobileDialog.show(getSupportFragmentManager(), str);
            fh3.a("show", str2, null, this.mLaunchFrom, this.mAppId);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            if (this.mGetMobileDialog instanceof SwanAppPhoneLoginDialog) {
                ic3.a(this, getWindow().getDecorView().getWindowToken());
            }
            overridePendingTransition(0, R.anim.obfuscated_res_0x7f010092);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int c0 = bd3.c0(this);
            super.onCreate(bundle);
            bd3.g(this, c0);
            getWindow().addFlags(256);
            getWindow().addFlags(512);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags &= -1025;
            getWindow().setAttributes(attributes);
            setContentView(R.layout.obfuscated_res_0x7f0d00b8);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.mAuthTip = extras.getString("app_name", "");
                this.mQuickLoginInfo = (QuickLoginInfo) extras.getParcelable("quick_login_info");
                this.mLaunchFrom = extras.getString("launch_from");
                this.mAppId = extras.getString("appid");
            }
            this.mIsNightMode = oi2.M().a();
            init();
            LogUtil.logActivity(this, "onCreate");
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
    public void onLoginResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            eh3.a().onResult(i);
            if (i != 0) {
                zy2.f(this, R.string.obfuscated_res_0x7f0f12d2).H(true);
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
                bd3.e0(new a(this));
            }
            super.onPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean a2 = oi2.M().a();
            if (this.mIsNightMode != a2) {
                SwanAppLoginAndGetMobileDialog swanAppLoginAndGetMobileDialog = this.mGetMobileDialog;
                if (swanAppLoginAndGetMobileDialog != null) {
                    swanAppLoginAndGetMobileDialog.I0(a2);
                }
                this.mIsNightMode = a2;
            }
            super.onResume();
        }
    }
}
