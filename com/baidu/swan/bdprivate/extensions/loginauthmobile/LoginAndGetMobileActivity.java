package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.w;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
/* loaded from: classes25.dex */
public class LoginAndGetMobileActivity extends FragmentActivity implements SwanAppLoginAndGetMobileDialog.a {
    private SwanAppLoginAndGetMobileDialog dNV;
    private QuickLoginInfo dNW;
    private String dNX;
    private String mAppId;
    protected LinearLayout mRootView;
    private String dNU = "";
    private boolean duG = false;

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        getWindow().addFlags(256);
        getWindow().addFlags(512);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags &= -1025;
        getWindow().setAttributes(attributes);
        setContentView(b.f.aiapps_login_getmobile_act_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.dNU = extras.getString("app_name", "");
            this.dNW = (QuickLoginInfo) extras.getParcelable("quick_login_info");
            this.dNX = extras.getString("launch_from");
            this.mAppId = extras.getString("appid");
        }
        this.duG = com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState();
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState();
        if (this.duG != nightModeSwitcherState) {
            if (this.dNV != null) {
                this.dNV.hv(nightModeSwitcherState);
            }
            this.duG = nightModeSwitcherState;
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.dNV instanceof SwanAppPhoneLoginDialog) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.LoginAndGetMobileActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    w.forceHiddenSoftInput(LoginAndGetMobileActivity.this, LoginAndGetMobileActivity.this.getWindow().getDecorView().getWindowToken());
                }
            });
        }
        super.onPause();
    }

    private void init() {
        aQK();
        aQL();
    }

    private void aQK() {
        this.mRootView = (LinearLayout) findViewById(b.e.root);
        this.mRootView.setBackgroundColor(getResources().getColor(b.C0513b.white));
        this.mRootView.getBackground().mutate().setAlpha(0);
    }

    private void aQL() {
        String str;
        String str2;
        this.dNV = e.a(this.dNU, this.duG, this.dNW, this.dNX, this.mAppId);
        if (this.dNW != null && this.dNW.supportQuickLogin) {
            str = "swan_quick_login";
            str2 = "quickLogin";
        } else {
            str = "swan_phone_login";
            str2 = "telLogin";
        }
        this.dNV.d(this);
        this.dNV.a(this);
        this.dNV.show(getSupportFragmentManager(), str);
        d.g("show", str2, null, this.dNX, this.mAppId);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.a
    public void lX(int i) {
        c.aQN().onResult(i);
        switch (i) {
            case 0:
                finish();
                return;
            default:
                com.baidu.swan.apps.res.widget.b.d.t(this, b.g.swanapp_login_fail).showToast(true);
                return;
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.a
    public void ht(boolean z) {
        if (z) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.dNV instanceof SwanAppPhoneLoginDialog) {
            w.forceHiddenSoftInput(this, getWindow().getDecorView().getWindowToken());
        }
        overridePendingTransition(0, b.a.login_get_mobile_act_exit);
    }
}
