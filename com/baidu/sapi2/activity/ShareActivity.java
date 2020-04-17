package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.f.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.share.m;
import com.baidu.sapi2.share.p;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ShareActivity extends BaseActivity {
    private static final String r = "share_fail_reason";
    private static final String s = "share_account";
    private String t = "0";
    private p u = new p();
    private WebAuthListener v;
    private String w;

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        SapiAccount currentAccount = SapiContext.getInstance(this).getCurrentAccount();
        if (currentAccount == null) {
            this.u.setResultCode(p.l);
            g();
            return;
        }
        currentAccount.app = SapiUtils.getAppName(this);
        SapiStatUtil.statShareV2OauthSuc();
        if (this.t.equals("1")) {
            SapiStatUtil.statShareV2ActiveLoginSuc();
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable(s, currentAccount);
        bundle.putInt(m.f, SapiAccountManager.VERSION_CODE);
        bundle.putString("PKG", getPackageName());
        if (SapiContext.getInstance(this).shareLivingunameEnable()) {
            bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance(this).getV2FaceLivingUnames());
        }
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        final boolean z = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        WebLoginDTO.Config config = new WebLoginDTO.Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        SapiAccount currentAccount = SapiContext.getInstance(this).getCurrentAccount();
        if (currentAccount != null) {
            webLoginDTO.encryptedId = currentAccount.uid;
            webLoginDTO.preSetUname = currentAccount.displayname;
        }
        this.v = new WebAuthListener() { // from class: com.baidu.sapi2.activity.ShareActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
                ShareActivity.this.u.setResultCode(p.g);
                ShareActivity.this.u.setResultMsg(String.format(p.a, ShareActivity.this.w));
                ShareActivity.this.g();
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
                LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
                if (loginStatusChangeCallback != null) {
                    loginStatusChangeCallback.onChange();
                }
            }
        };
        PassportSDK.getInstance().startLogin(this, this.v, webLoginDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        this.u.setResultCode(p.g);
        this.u.setResultMsg(String.format(p.a, this.w));
        g();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        super.finish();
        SapiStatUtil.statShareV2Invoke(this.t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            if (f()) {
                SapiStatUtil.statShareV2Oauth();
                if (e()) {
                    init();
                    setupViews();
                }
            }
        } catch (Throwable th) {
            reportWebviewError(th);
            this.u.setResultCode(p.l);
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.ShareActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                ShareActivity.this.j();
                return false;
            }
        });
        JSONObject jSONObject = new JSONObject();
        SapiAccount currentAccount = SapiContext.getInstance(this).getCurrentAccount();
        try {
            jSONObject.put(BaseJsonData.TAG_ERRNO, "0");
            String[] pkgIconAndName = SapiUtils.getPkgIconAndName(this, getPackageName());
            jSONObject.put("currentAPPLogo", pkgIconAndName[0]);
            jSONObject.put("currentAPPName", pkgIconAndName[1]);
            this.w = pkgIconAndName[1];
            String[] pkgIconAndName2 = SapiUtils.getPkgIconAndName(this, getCallingPackage());
            jSONObject.put("originAPPLogo", pkgIconAndName2[0]);
            jSONObject.put("originAPPName", pkgIconAndName2[1]);
            if (currentAccount == null) {
                this.t = "1";
            } else {
                jSONObject.put("displayName", currentAccount.displayname);
            }
            jSONObject.put("portrait", getIntent().getStringExtra("android.intent.extra.TEXT"));
            jSONObject.put("session_id", getIntent().getStringExtra(m.b));
            jSONObject.put("trace_id", getIntent().getStringExtra(m.a));
        } catch (Exception e) {
            Log.e(e);
        }
        SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams = new SapiJsCallBacks.ShareV2LoginParams() { // from class: com.baidu.sapi2.activity.ShareActivity.2
            @Override // com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams
            public void onError() {
                if (!ShareActivity.this.t.equals("1")) {
                    ShareActivity.this.t = "2";
                }
                ShareActivity.this.i();
            }

            @Override // com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams
            public void onSuccess() {
                ShareActivity.this.h();
            }
        };
        shareV2LoginParams.pageParams = jSONObject;
        this.sapiWebView.setShareV2LoginParams(shareV2LoginParams);
        this.sapiWebView.loadShareV2Login();
    }

    private boolean e() {
        String callingPackage = getCallingPackage();
        if (TextUtils.isEmpty(callingPackage)) {
            this.u.setResultCode(p.h);
            g();
            return false;
        } else if (new m().a(this, callingPackage)) {
            return true;
        } else {
            this.u.setResultCode(p.h);
            g();
            return false;
        }
    }

    private boolean f() {
        if (SapiAccountManager.getInstance().getConfignation() == null && SapiAccountManager.getReceiveShareListener() != null) {
            SapiAccountManager.getReceiveShareListener().onReceiveShare();
        }
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            Log.e("pass sdk have not been initialized", new Object[0]);
            this.u.setResultCode(p.k);
            g();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SapiStatUtil.statShareV2OtherFail(this.u.getResultCode());
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(r, this.u.getResultMsg());
        intent.putExtras(bundle);
        setResult(-100, intent);
        finish();
    }
}
