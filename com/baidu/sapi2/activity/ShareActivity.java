package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.d.a.a;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareResult;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShareActivity extends BaseActivity {
    private static final String SHARE_ACCOUNT = "share_account";
    private static final String SHARE_FAIL_REASON = "share_fail_reason";
    private String currentAppName;
    private String loginStatusFlag = "0";
    private ShareResult shareResult = new ShareResult();
    private WebAuthListener webAuthListener;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            if (checkSapiInit()) {
                SapiStatUtil.statShareV2Oauth();
                if (checkCallingPermission()) {
                    init();
                    setupViews();
                }
            }
        } catch (Throwable th) {
            reportWebviewError(th);
            this.shareResult.setResultCode(ShareResult.ERROR_CODE_SYS_ERROR);
            loginFail();
        }
    }

    private boolean checkCallingPermission() {
        String callingPackage = getCallingPackage();
        if (TextUtils.isEmpty(callingPackage)) {
            this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_SIGN_ERROR);
            loginFail();
            return false;
        } else if (!new ShareCallPacking().checkPkgSign(this, callingPackage)) {
            this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_SIGN_ERROR);
            loginFail();
            return false;
        } else {
            return true;
        }
    }

    private boolean checkSapiInit() {
        if (SapiAccountManager.getInstance().getConfignation() == null && SapiAccountManager.getReceiveShareListener() != null) {
            SapiAccountManager.getReceiveShareListener().onReceiveShare();
        }
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            Log.e("pass sdk have not been initialized", new Object[0]);
            this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_SDK_NOT_INIT);
            loginFail();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pressBack() {
        if (this.sapiWebView != null && this.sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_CANCLE);
        this.shareResult.setResultMsg(String.format(ShareResult.ERROR_MSG_REASON_CANCLE, this.currentAppName));
        loginFail();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        pressBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        pressBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.ShareActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                ShareActivity.this.pressBack();
                return false;
            }
        });
        JSONObject jSONObject = new JSONObject();
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        try {
            jSONObject.put("errno", "0");
            String[] pkgIconAndName = SapiUtils.getPkgIconAndName(this, getPackageName());
            jSONObject.put("currentAPPLogo", pkgIconAndName[0]);
            jSONObject.put("currentAPPName", pkgIconAndName[1]);
            this.currentAppName = pkgIconAndName[1];
            String[] pkgIconAndName2 = SapiUtils.getPkgIconAndName(this, getCallingPackage());
            jSONObject.put("originAPPLogo", pkgIconAndName2[0]);
            jSONObject.put("originAPPName", pkgIconAndName2[1]);
            if (session == null) {
                this.loginStatusFlag = "1";
            } else {
                jSONObject.put("displayName", session.displayname);
            }
            jSONObject.put("portrait", getIntent().getStringExtra("android.intent.extra.TEXT"));
            jSONObject.put(LogConfig.LOG_SESSION_ID, getIntent().getStringExtra(ShareCallPacking.EXTRA_SESSION_ID));
            jSONObject.put("trace_id", getIntent().getStringExtra(ShareCallPacking.EXTRA_TRACE_ID));
        } catch (Exception e) {
            Log.e(e);
        }
        SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams = new SapiJsCallBacks.ShareV2LoginParams() { // from class: com.baidu.sapi2.activity.ShareActivity.2
            @Override // com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams
            public void onSuccess() {
                ShareActivity.this.loginSuccess();
            }

            @Override // com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams
            public void onError() {
                if (!ShareActivity.this.loginStatusFlag.equals("1")) {
                    ShareActivity.this.loginStatusFlag = "2";
                }
                ShareActivity.this.openLogin();
            }
        };
        shareV2LoginParams.pageParams = jSONObject;
        this.sapiWebView.setShareV2LoginParams(shareV2LoginParams);
        this.sapiWebView.loadShareV2Login();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openLogin() {
        final boolean z = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        WebLoginDTO.Config config = new WebLoginDTO.Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            webLoginDTO.encryptedId = session.uid;
            webLoginDTO.preSetUname = session.displayname;
        }
        this.webAuthListener = new WebAuthListener() { // from class: com.baidu.sapi2.activity.ShareActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
                if (ShareActivity.this.sapiWebView != null) {
                    ShareActivity.this.sapiWebView.reload();
                }
                LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
                if (loginStatusChangeCallback != null) {
                    loginStatusChangeCallback.onChange();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
                ShareActivity.this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_CANCLE);
                ShareActivity.this.shareResult.setResultMsg(String.format(ShareResult.ERROR_MSG_REASON_CANCLE, ShareActivity.this.currentAppName));
                ShareActivity.this.loginFail();
            }
        };
        PassportSDK.getInstance().startLogin(this, this.webAuthListener, webLoginDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginSuccess() {
        SapiAccount currentAccount = SapiContext.getInstance(this).getCurrentAccount();
        if (currentAccount == null) {
            this.shareResult.setResultCode(ShareResult.ERROR_CODE_SYS_ERROR);
            loginFail();
            return;
        }
        currentAccount.app = SapiUtils.getAppName(this);
        SapiStatUtil.statShareV2OauthSuc();
        if (this.loginStatusFlag.equals("1")) {
            SapiStatUtil.statShareV2ActiveLoginSuc();
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SHARE_ACCOUNT, currentAccount);
        bundle.putInt(ShareCallPacking.EXTRA_SDK_VERSION, SapiAccountManager.VERSION_CODE);
        bundle.putString("PKG", getPackageName());
        if (SapiContext.getInstance(this).shareLivingunameEnable()) {
            bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance(this).getV2FaceLivingUnames());
        }
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginFail() {
        SapiStatUtil.statShareV2OtherFail(this.shareResult.getResultCode());
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(SHARE_FAIL_REASON, this.shareResult.getResultMsg());
        intent.putExtras(bundle);
        setResult(-100, intent);
        finish();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        super.finish();
        SapiStatUtil.statShareV2Invoke(this.loginStatusFlag);
    }
}
