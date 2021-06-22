package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.x;
import d.a.m0.b.b;
import d.a.m0.b.c;
import d.a.m0.b.e;
import d.a.m0.b.f;
import d.a.m0.b.g;
import d.a.m0.b.n.d.d;
/* loaded from: classes3.dex */
public class LoginAndGetMobileActivity extends FragmentActivity implements SwanAppLoginAndGetMobileDialog.b {
    public static final String TAG = "LoginAndGetMobileActivity";
    public String mAppId;
    public SwanAppLoginAndGetMobileDialog mGetMobileDialog;
    public String mLaunchFrom;
    public QuickLoginInfo mQuickLoginInfo;
    public LinearLayout mRootView;
    public String mAuthTip = "";
    public boolean mIsNightMode = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoginAndGetMobileActivity loginAndGetMobileActivity = LoginAndGetMobileActivity.this;
            x.a(loginAndGetMobileActivity, loginAndGetMobileActivity.getWindow().getDecorView().getWindowToken());
        }
    }

    private void init() {
        initRootView();
        showLoginDialog();
    }

    private void initRootView() {
        LinearLayout linearLayout = (LinearLayout) findViewById(e.root);
        this.mRootView = linearLayout;
        linearLayout.setBackgroundColor(getResources().getColor(c.white));
        this.mRootView.getBackground().mutate().setAlpha(0);
    }

    private void showLoginDialog() {
        String str;
        String str2;
        this.mGetMobileDialog = d.a.m0.b.n.d.e.a(this.mAuthTip, this.mIsNightMode, this.mQuickLoginInfo, this.mLaunchFrom, this.mAppId);
        QuickLoginInfo quickLoginInfo = this.mQuickLoginInfo;
        if (quickLoginInfo == null || !quickLoginInfo.supportQuickLogin) {
            str = "swan_phone_login";
            str2 = "telLogin";
        } else {
            str = "swan_quick_login";
            str2 = "quickLogin";
        }
        this.mGetMobileDialog.M0(this);
        this.mGetMobileDialog.O0(this);
        this.mGetMobileDialog.show(getSupportFragmentManager(), str);
        d.a("show", str2, null, this.mLaunchFrom, this.mAppId);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.mGetMobileDialog instanceof SwanAppPhoneLoginDialog) {
            x.a(this, getWindow().getDecorView().getWindowToken());
        }
        overridePendingTransition(0, b.login_get_mobile_act_exit);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int Z = q0.Z(this);
        super.onCreate(bundle);
        q0.g(this, Z);
        getWindow().addFlags(256);
        getWindow().addFlags(512);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags &= -1025;
        getWindow().setAttributes(attributes);
        setContentView(f.aiapps_login_getmobile_act_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mAuthTip = extras.getString("app_name", "");
            this.mQuickLoginInfo = (QuickLoginInfo) extras.getParcelable("quick_login_info");
            this.mLaunchFrom = extras.getString("launch_from");
            this.mAppId = extras.getString("appid");
        }
        this.mIsNightMode = d.a.m0.a.c1.a.H().a();
        init();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.b
    public void onDialogDismiss(boolean z) {
        if (z) {
            finish();
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.b
    public void onLoginResult(int i2) {
        d.a.m0.b.n.d.c.a().onResult(i2);
        if (i2 != 0) {
            d.a.m0.a.z1.b.f.e.f(this, g.swanapp_login_fail).G(true);
        } else {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.mGetMobileDialog instanceof SwanAppPhoneLoginDialog) {
            q0.b0(new a());
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        boolean a2 = d.a.m0.a.c1.a.H().a();
        if (this.mIsNightMode != a2) {
            SwanAppLoginAndGetMobileDialog swanAppLoginAndGetMobileDialog = this.mGetMobileDialog;
            if (swanAppLoginAndGetMobileDialog != null) {
                swanAppLoginAndGetMobileDialog.K0(a2);
            }
            this.mIsNightMode = a2;
        }
        super.onResume();
    }
}
