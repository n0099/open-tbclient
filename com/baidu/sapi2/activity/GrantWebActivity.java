package com.baidu.sapi2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.f.a.a;
import com.baidu.fsg.base.statistics.h;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.t;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class GrantWebActivity extends BaseActivity {
    private static final String r = "GrantWebActivity";
    private static final String s = "openapp";
    private static final String t = "/passport/grantweb";
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        t.a("grant_web_cancel", new HashMap());
        finish();
    }

    private boolean f() {
        Uri data;
        Intent intent = getIntent();
        String scheme = intent.getScheme();
        if ("android.intent.action.VIEW".equals(intent.getAction()) && (data = intent.getData()) != null) {
            String host = data.getHost();
            String path = data.getPath();
            String packageName = SapiAccountManager.getInstance().getConfignation().getContext().getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                packageName = "";
            }
            if (s.equals(scheme) && packageName.equals(host) && t.equals(path)) {
                return true;
            }
        }
        return false;
    }

    private boolean g() {
        if (SapiAccountManager.getInstance().getConfignation() == null && SapiAccountManager.getReceiveShareListener() != null) {
            SapiAccountManager.getReceiveShareListener().onReceiveShare();
        }
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            Log.e(Log.TAG, "pass sdk has not been initialized");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        boolean z;
        if (SapiAccountManager.getCheckUrlIsAvailablelister() != null) {
            if (TextUtils.isEmpty(this.w)) {
                this.w = this.v;
            }
            z = SapiAccountManager.getCheckUrlIsAvailablelister().onCheckUrlIsAvailable(this.w);
        } else {
            z = false;
        }
        String str = SapiAccountManager.getInstance().getConfignation().environment.getWap() + "/passport/login";
        HashMap hashMap = new HashMap();
        hashMap.put("client", "android");
        hashMap.put("clientfrom", "native");
        hashMap.put("suppcheck", "1");
        hashMap.put("adapter", "3");
        hashMap.put(SharedPrefConfig.CHANNEL_ID, this.u);
        hashMap.put("wap_tpl", this.y);
        hashMap.put("tpl", SapiAccountManager.getInstance().getConfignation().tpl);
        hashMap.put("u", this.v);
        if (z && !"true".equals(this.x)) {
            hashMap.put("force", "false");
        } else {
            hashMap.put("force", "true");
        }
        String str2 = str + SapiUtils.mapToUrlParams(hashMap, false) + "#app_auth";
        Log.d(r, "url = " + str2);
        this.sapiWebView.loadUrl(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        Uri data = getIntent().getData();
        if (data != null) {
            this.u = data.getQueryParameter(SharedPrefConfig.CHANNEL_ID);
            this.v = data.getQueryParameter("u");
            this.w = data.getQueryParameter(h.f);
            this.x = data.getQueryParameter("force");
            this.y = data.getQueryParameter("wap_tpl");
        }
        if (TextUtils.isEmpty(this.u)) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            if (g() && f()) {
                init();
                setupViews();
                return;
            }
            finish();
        } catch (Throwable th) {
            Log.e(th);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        e();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        Log.d(r, this + " onNewIntent");
        if (SapiAccountManager.getInstance().isLogin() && !TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            h();
        } else {
            b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.GrantWebActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                GrantWebActivity.this.e();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.GrantWebActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                GrantWebActivity.this.finish();
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.sapi2.activity.GrantWebActivity.3
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                Log.d(GrantWebActivity.r, "GrantWebPage login failed");
                GrantWebActivity.this.finish();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess(AccountType accountType) {
                GrantWebActivity.this.h();
                LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
                if (loginStatusChangeCallback != null) {
                    loginStatusChangeCallback.onChange();
                }
            }
        });
        this.sapiWebView.setGrantWebCallback(new SapiJsCallBacks.GrantWebCallback() { // from class: com.baidu.sapi2.activity.GrantWebActivity.4
            @Override // com.baidu.sapi2.SapiJsCallBacks.GrantWebCallback
            public void onGrant(int i) {
                if (i == 0) {
                    Log.d(GrantWebActivity.r, "after grant web, then back to wap");
                    GrantWebActivity.this.finish();
                    return;
                }
                Log.d(GrantWebActivity.r, "after grant web, still stay in app");
                if (SapiAccountManager.getCheckUrlIsAvailablelister() != null) {
                    if (TextUtils.isEmpty(GrantWebActivity.this.w)) {
                        GrantWebActivity grantWebActivity = GrantWebActivity.this;
                        grantWebActivity.w = grantWebActivity.v;
                    }
                    SapiAccountManager.getCheckUrlIsAvailablelister().handleWebPageUrl(GrantWebActivity.this.w);
                }
                GrantWebActivity.this.finish();
            }
        });
        this.sapiWebView.setCurrentAccountBdussExpiredCallback(new SapiJsCallBacks.CurrentAccountBdussExpiredCallback() { // from class: com.baidu.sapi2.activity.GrantWebActivity.5
            @Override // com.baidu.sapi2.SapiJsCallBacks.CurrentAccountBdussExpiredCallback
            public void onBdussExpired() {
                GrantWebActivity.this.b(true);
            }
        });
        if (SapiAccountManager.getInstance().isLogin() && !TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            h();
        } else {
            b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        final boolean z2 = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        WebLoginDTO.Config config = new WebLoginDTO.Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        webLoginDTO.businessType = 2005;
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (z && currentAccount != null) {
            webLoginDTO.encryptedId = currentAccount.uid;
            webLoginDTO.preSetUname = currentAccount.displayname;
        }
        PassportSDK.getInstance().startLogin(this, new WebAuthListener() { // from class: com.baidu.sapi2.activity.GrantWebActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
                GrantWebActivity.this.finish();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                GrantWebActivity.this.h();
                LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
                if (loginStatusChangeCallback != null) {
                    loginStatusChangeCallback.onChange();
                }
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
            }
        }, webLoginDTO);
    }
}
