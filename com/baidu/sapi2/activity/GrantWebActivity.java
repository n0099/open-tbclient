package com.baidu.sapi2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import d.b.y.a.f;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class GrantWebActivity extends BaseActivity {
    public static final String u = GrantWebActivity.class.getSimpleName();
    public static final String v = "openapp";
    public static final String w = "/passport/grantweb";
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        boolean z;
        if (SapiAccountManager.getCheckUrlIsAvailablelister() != null) {
            if (TextUtils.isEmpty(this.r)) {
                this.r = this.q;
            }
            z = SapiAccountManager.getCheckUrlIsAvailablelister().onCheckUrlIsAvailable(this.r);
        } else {
            z = false;
        }
        String str = SapiAccountManager.getInstance().getConfignation().environment.getWap() + "/passport/login";
        HashMap hashMap = new HashMap();
        hashMap.put("client", "android");
        hashMap.put("clientfrom", "native");
        hashMap.put("suppcheck", "1");
        hashMap.put("adapter", "3");
        hashMap.put("channel_id", this.p);
        hashMap.put("wap_tpl", this.t);
        hashMap.put("tpl", SapiAccountManager.getInstance().getConfignation().tpl);
        hashMap.put("u", this.q);
        if (z && !"true".equals(this.s)) {
            hashMap.put("force", "false");
        } else {
            hashMap.put("force", "true");
        }
        String str2 = str + SapiUtils.mapToUrlParams(hashMap, false) + "#app_auth";
        Log.d(u, "url = " + str2);
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null) {
            sapiWebView.loadUrl(str2);
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        Uri data = getIntent().getData();
        if (data != null) {
            this.p = data.getQueryParameter("channel_id");
            this.q = data.getQueryParameter("u");
            this.r = data.getQueryParameter("nu");
            this.s = data.getQueryParameter("force");
            this.t = data.getQueryParameter("wap_tpl");
        }
        if (TextUtils.isEmpty(this.p)) {
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        b();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            if (d() && c()) {
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

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        b();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        String str = u;
        Log.d(str, this + " onNewIntent");
        if (SapiAccountManager.getInstance().isLogin() && !TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            e();
        } else {
            a(false);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null) {
            sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.GrantWebActivity.1
                @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
                public boolean onBack() {
                    GrantWebActivity.this.b();
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
                    Log.d(GrantWebActivity.u, "GrantWebPage login failed");
                    GrantWebActivity.this.finish();
                }

                @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                public void onSuccess(AccountType accountType) {
                    GrantWebActivity.this.e();
                    SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                }
            });
            this.sapiWebView.setGrantWebCallback(new SapiJsCallBacks.GrantWebCallback() { // from class: com.baidu.sapi2.activity.GrantWebActivity.4
                @Override // com.baidu.sapi2.SapiJsCallBacks.GrantWebCallback
                public void onGrant(int i) {
                    if (i == 0) {
                        Log.d(GrantWebActivity.u, "after grant web, then back to wap");
                        GrantWebActivity.this.finish();
                        return;
                    }
                    Log.d(GrantWebActivity.u, "after grant web, still stay in app");
                    if (SapiAccountManager.getCheckUrlIsAvailablelister() != null) {
                        if (TextUtils.isEmpty(GrantWebActivity.this.r)) {
                            GrantWebActivity grantWebActivity = GrantWebActivity.this;
                            grantWebActivity.r = grantWebActivity.q;
                        }
                        SapiAccountManager.getCheckUrlIsAvailablelister().handleWebPageUrl(GrantWebActivity.this.r);
                    }
                    GrantWebActivity.this.finish();
                }
            });
            this.sapiWebView.setCurrentAccountBdussExpiredCallback(new SapiJsCallBacks.CurrentAccountBdussExpiredCallback() { // from class: com.baidu.sapi2.activity.GrantWebActivity.5
                @Override // com.baidu.sapi2.SapiJsCallBacks.CurrentAccountBdussExpiredCallback
                public void onBdussExpired() {
                    GrantWebActivity.this.a(true);
                }
            });
        }
        if (SapiAccountManager.getInstance().isLogin() && !TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            e();
        } else {
            a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        StatService.onEvent("grant_web_cancel", new HashMap());
        finish();
    }

    private boolean c() {
        Uri data;
        Intent intent = getIntent();
        String scheme = intent.getScheme();
        if (!"android.intent.action.VIEW".equals(intent.getAction()) || (data = intent.getData()) == null) {
            return false;
        }
        String host = data.getHost();
        String path = data.getPath();
        String packageName = SapiAccountManager.getInstance().getConfignation().getContext().getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        return v.equals(scheme) && packageName.equals(host) && w.equals(path);
    }

    private boolean d() {
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            SapiAccountManager.getGlobalCallback().onNeedInitPassSdk();
        }
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            Log.e(Log.TAG, "pass sdk has not been initialized");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
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
        CoreViewRouter.getInstance().startLogin(this, new WebAuthListener() { // from class: com.baidu.sapi2.activity.GrantWebActivity.6
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
                GrantWebActivity.this.e();
                SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
            }
        }, webLoginDTO);
    }
}
