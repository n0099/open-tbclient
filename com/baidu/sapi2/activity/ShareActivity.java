package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.k.a.a;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.share.b;
import com.baidu.sapi2.share.d;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ShareActivity extends BaseActivity {
    private static final String u = "share_fail_reason";
    private static final String v = "share_account";
    private String p = "0";
    private d q = new d();
    private WebAuthListener r;
    private String s;
    private String t;

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        super.finish();
        SapiStatUtil.statShareV2Invoke(this.p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            if (b()) {
                SapiStatUtil.statShareV2Oauth();
                if (a()) {
                    init();
                    setupViews();
                }
            }
        } catch (Throwable th) {
            reportWebviewError(th);
            this.q.setResultCode(d.l);
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.ShareActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                ShareActivity.this.f();
                return false;
            }
        });
        JSONObject jSONObject = new JSONObject();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        try {
            jSONObject.put(BaseJsonData.TAG_ERRNO, "0");
            String[] pkgIconAndName = SapiUtils.getPkgIconAndName(this, getPackageName());
            jSONObject.put("currentAPPLogo", pkgIconAndName[0]);
            jSONObject.put("currentAPPName", pkgIconAndName[1]);
            this.s = pkgIconAndName[1];
            String[] pkgIconAndName2 = SapiUtils.getPkgIconAndName(this, getCallingPackage());
            jSONObject.put("originAPPLogo", pkgIconAndName2[0]);
            jSONObject.put("originAPPName", pkgIconAndName2[1]);
            if (currentAccount == null) {
                this.p = "1";
            } else {
                jSONObject.put("displayName", currentAccount.displayname);
            }
            jSONObject.put("portrait", getIntent().getStringExtra("android.intent.extra.TEXT"));
            jSONObject.put("session_id", getIntent().getStringExtra(b.b));
            jSONObject.put("trace_id", getIntent().getStringExtra(b.f3514a));
            this.t = getIntent().getStringExtra(b.c);
        } catch (Exception e) {
            Log.e(e);
        }
        SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams = new SapiJsCallBacks.ShareV2LoginParams() { // from class: com.baidu.sapi2.activity.ShareActivity.2
            @Override // com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams
            public void onError() {
                if (!ShareActivity.this.p.equals("1")) {
                    ShareActivity.this.p = "2";
                }
                ShareActivity.this.e();
            }

            @Override // com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams
            public void onSuccess() {
                ShareActivity.this.d();
            }
        };
        shareV2LoginParams.pageParams = jSONObject;
        this.sapiWebView.setShareV2LoginParams(shareV2LoginParams);
        this.sapiWebView.loadShareV2Login();
    }

    private boolean b() {
        if (SapiAccountManager.getInstance().getConfignation() == null && SapiAccountManager.getReceiveShareListener() != null) {
            SapiAccountManager.getReceiveShareListener().onReceiveShare();
        }
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            Log.e("pass sdk have not been initialized", new Object[0]);
            this.q.setResultCode(d.k);
            c();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        SapiStatUtil.statShareV2OtherFail(this.q.getResultCode());
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(u, this.q.getResultMsg());
        bundle.putString(b.c, this.t);
        intent.putExtras(bundle);
        setResult(-100, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            this.q.setResultCode(d.l);
            c();
            return;
        }
        currentAccount.app = SapiUtils.getAppName(this);
        SapiStatUtil.statShareV2OauthSuc();
        if (this.p.equals("1")) {
            SapiStatUtil.statShareV2ActiveLoginSuc();
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable(v, currentAccount);
        bundle.putInt(b.g, 249);
        bundle.putString("PKG", getPackageName());
        bundle.putString(b.c, this.t);
        if (SapiContext.getInstance().shareLivingunameEnable()) {
            bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance().getV2FaceLivingUnames());
        }
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        final boolean z = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        WebLoginDTO.Config config = new WebLoginDTO.Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount != null) {
            webLoginDTO.encryptedId = currentAccount.uid;
            webLoginDTO.preSetUname = currentAccount.displayname;
        }
        this.r = new WebAuthListener() { // from class: com.baidu.sapi2.activity.ShareActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
                ShareActivity.this.q.setResultCode(d.g);
                ShareActivity.this.q.setResultMsg(String.format(d.f3518a, ShareActivity.this.s));
                ShareActivity.this.c();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
                SapiWebView sapiWebView = ShareActivity.this.sapiWebView;
                if (sapiWebView != null) {
                    sapiWebView.reload();
                }
                LoginStatusChangeCallback loginStatusChangeCallback = CoreViewRouter.getLoginStatusChangeCallback();
                if (loginStatusChangeCallback != null) {
                    loginStatusChangeCallback.onChange();
                }
            }
        };
        CoreViewRouter.getInstance().startLogin(this, this.r, webLoginDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        this.q.setResultCode(d.g);
        this.q.setResultMsg(String.format(d.f3518a, this.s));
        c();
    }

    private boolean a() {
        String callingPackage = getCallingPackage();
        if (TextUtils.isEmpty(callingPackage)) {
            this.q.setResultCode(d.h);
            c();
            return false;
        } else if (new b().a(this, callingPackage)) {
            return true;
        } else {
            this.q.setResultCode(d.h);
            c();
            return false;
        }
    }
}
