package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.w;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
/* loaded from: classes9.dex */
public class LoginAndGetMobileActivity extends FragmentActivity implements SwanAppLoginAndGetMobileDialog.a {
    private SwanAppLoginAndGetMobileDialog dWO;
    private QuickLoginInfo dWP;
    private String dWQ;
    private String mAppId;
    protected LinearLayout mRootView;
    private String dWN = "";
    private boolean dAP = false;

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
            this.dWN = extras.getString("app_name", "");
            this.dWP = (QuickLoginInfo) extras.getParcelable("quick_login_info");
            this.dWQ = extras.getString("launch_from");
            this.mAppId = extras.getString("appid");
        }
        this.dAP = com.baidu.swan.apps.t.a.aAN().alD();
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        boolean alD = com.baidu.swan.apps.t.a.aAN().alD();
        if (this.dAP != alD) {
            if (this.dWO != null) {
                this.dWO.hN(alD);
            }
            this.dAP = alD;
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.dWO instanceof SwanAppPhoneLoginDialog) {
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
        aTf();
        aTg();
    }

    private void aTf() {
        this.mRootView = (LinearLayout) findViewById(b.e.root);
        this.mRootView.setBackgroundColor(getResources().getColor(b.C0506b.white));
        this.mRootView.getBackground().mutate().setAlpha(0);
    }

    private void aTg() {
        String str;
        String str2;
        this.dWO = e.a(this.dWN, this.dAP, this.dWP, this.dWQ, this.mAppId);
        if (this.dWP != null && this.dWP.supportQuickLogin) {
            str = "swan_quick_login";
            str2 = "quickLogin";
        } else {
            str = "swan_phone_login";
            str2 = "telLogin";
        }
        this.dWO.a((FragmentActivity) this);
        this.dWO.a((SwanAppLoginAndGetMobileDialog.a) this);
        this.dWO.show(getSupportFragmentManager(), str);
        d.g("show", str2, null, this.dWQ, this.mAppId);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.a
    public void me(int i) {
        c.aTi().onResult(i);
        switch (i) {
            case 0:
                finish();
                return;
            default:
                com.baidu.swan.apps.res.widget.b.d.u(this, b.g.swanapp_login_fail).hf(true);
                return;
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.a
    public void hL(boolean z) {
        if (z) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.dWO instanceof SwanAppPhoneLoginDialog) {
            w.forceHiddenSoftInput(this, getWindow().getDecorView().getWindowToken());
        }
        overridePendingTransition(0, b.a.login_get_mobile_act_exit);
    }
}
