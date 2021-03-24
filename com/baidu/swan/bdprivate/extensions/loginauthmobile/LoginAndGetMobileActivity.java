package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.w;
import d.b.g0.b.b;
import d.b.g0.b.c;
import d.b.g0.b.e;
import d.b.g0.b.f;
import d.b.g0.b.g;
import d.b.g0.b.m.d.d;
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
            w.a(loginAndGetMobileActivity, loginAndGetMobileActivity.getWindow().getDecorView().getWindowToken());
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
        this.mGetMobileDialog = d.b.g0.b.m.d.e.a(this.mAuthTip, this.mIsNightMode, this.mQuickLoginInfo, this.mLaunchFrom, this.mAppId);
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
        d.a("show", str2, null, this.mLaunchFrom, this.mAppId);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.mGetMobileDialog instanceof SwanAppPhoneLoginDialog) {
            w.a(this, getWindow().getDecorView().getWindowToken());
        }
        overridePendingTransition(0, b.login_get_mobile_act_exit);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int V = k0.V(this);
        super.onCreate(bundle);
        k0.h(this, V);
        getWindow().addFlags(256);
        getWindow().addFlags(512);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags &= -1025;
        getWindow().setAttributes(attributes);
        setContentView(f.aiapps_login_getmobile_act_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mAuthTip = extras.getString(DpStatConstants.KEY_APP_NAME, "");
            this.mQuickLoginInfo = (QuickLoginInfo) extras.getParcelable("quick_login_info");
            this.mLaunchFrom = extras.getString("launch_from");
            this.mAppId = extras.getString("appid");
        }
        this.mIsNightMode = d.b.g0.a.w0.a.z().a();
        init();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.b
    public void onDialogDismiss(boolean z) {
        if (z) {
            finish();
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.b
    public void onLoginResult(int i) {
        d.b.g0.b.m.d.c.a().onResult(i);
        if (i != 0) {
            d.b.g0.a.q1.b.f.d.e(this, g.swanapp_login_fail).D(true);
        } else {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.mGetMobileDialog instanceof SwanAppPhoneLoginDialog) {
            k0.X(new a());
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        boolean a2 = d.b.g0.a.w0.a.z().a();
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
