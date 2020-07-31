package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.w;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
/* loaded from: classes11.dex */
public class LoginAndGetMobileActivity extends FragmentActivity implements SwanAppLoginAndGetMobileDialog.a {
    private SwanAppLoginAndGetMobileDialog cWU;
    private QuickLoginInfo cWV;
    private String cWW;
    private String mAppId;
    protected LinearLayout mRootView;
    private String cWT = "";
    private boolean cDJ = false;

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int releaseFixedOrientation = al.releaseFixedOrientation(this);
        super.onCreate(bundle);
        al.fixedOrientation(this, releaseFixedOrientation);
        getWindow().addFlags(256);
        getWindow().addFlags(512);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags &= -1025;
        getWindow().setAttributes(attributes);
        setContentView(b.f.aiapps_login_getmobile_act_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.cWT = extras.getString("app_name", "");
            this.cWV = (QuickLoginInfo) extras.getParcelable("quick_login_info");
            this.cWW = extras.getString("launch_from");
            this.mAppId = extras.getString("appid");
        }
        this.cDJ = com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState();
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState();
        if (this.cDJ != nightModeSwitcherState) {
            if (this.cWU != null) {
                this.cWU.fT(nightModeSwitcherState);
            }
            this.cDJ = nightModeSwitcherState;
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.cWU instanceof SwanAppPhoneLoginDialog) {
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.LoginAndGetMobileActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    w.forceHiddenSoftInput(LoginAndGetMobileActivity.this, LoginAndGetMobileActivity.this.getWindow().getDecorView().getWindowToken());
                }
            });
        }
        super.onPause();
    }

    private void init() {
        ayq();
        ayr();
    }

    private void ayq() {
        this.mRootView = (LinearLayout) findViewById(b.e.root);
        this.mRootView.setBackgroundColor(getResources().getColor(b.C0422b.white));
        this.mRootView.getBackground().mutate().setAlpha(0);
    }

    private void ayr() {
        String str;
        String str2;
        this.cWU = e.a(this.cWT, this.cDJ, this.cWV, this.cWW, this.mAppId);
        if (this.cWV != null && this.cWV.supportQuickLogin) {
            str = "swan_quick_login";
            str2 = "quickLogin";
        } else {
            str = "swan_phone_login";
            str2 = "telLogin";
        }
        this.cWU.d(this);
        this.cWU.a(this);
        this.cWU.show(getSupportFragmentManager(), str);
        d.f("show", str2, null, this.cWW, this.mAppId);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.a
    public void is(int i) {
        c.ayt().onResult(i);
        switch (i) {
            case 0:
                finish();
                return;
            default:
                com.baidu.swan.apps.res.widget.b.d.k(this, b.g.swanapp_login_fail).showToast(true);
                return;
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.a
    public void fR(boolean z) {
        if (z) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.cWU instanceof SwanAppPhoneLoginDialog) {
            w.forceHiddenSoftInput(this, getWindow().getDecorView().getWindowToken());
        }
        overridePendingTransition(0, b.a.login_get_mobile_act_exit);
    }
}
