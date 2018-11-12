package com.baidu.sapi2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class LoginActivity extends BaseActivity {
    public static final String EXTRA_LOGIN_FINISH_AFTER_SUC = "extra_login_finish_after_suc";
    public static final String EXTRA_LOGIN_TYPE = "extra_login_type";
    public static final String EXTRA_PARAM_USERNAME = "username";
    private static final int REQUEST_CALL_SYSTEM_SMS = 2004;
    private static final int REQUEST_CODE_LOAD_EXTERNAL_WEBVIEW = 2005;
    private static final int REQUEST_FAST_REG = 2003;
    public static final int REQUEST_SOCIAL_LOGIN = 2001;
    public static boolean supportShareLogin = true;
    private int businessType;
    private boolean finishActivityAfterSuc;
    private String loginType;
    private SapiWebView.SystemUpwardSmsCallback.Result result;
    private SapiWebView sapiWebView;
    private String userName;
    private WebAuthResult webAuthResult = new WebAuthResult() { // from class: com.baidu.sapi2.activity.LoginActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            super.finishActivity();
            LoginActivity.this.finishActivity(true);
        }

        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity(boolean z) {
            super.finishActivity();
            LoginActivity.this.finishActivity(false);
        }
    };
    private AuthorizationListener authorizationListener = new AuthorizationListener() { // from class: com.baidu.sapi2.activity.LoginActivity.2
        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            LoginActivity.this.loginSucces(accountType, false);
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            if (LoginActivity.this.businessType != 2003) {
                LoginActivity.this.webAuthResult.setResultCode(i);
                LoginActivity.this.webAuthResult.setResultMsg(str);
                LoginActivity.this.loginFail(LoginActivity.this.webAuthResult);
                return;
            }
            LoginActivity.this.setResult(0);
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            super.beforeSuccess(sapiAccount);
            WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                webAuthListener.beforeSuccess(sapiAccount);
            }
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public boolean onForgetPwd() {
            LoginActivity.this.startActivity(new Intent(LoginActivity.this, ForgetPwdActivity.class));
            return true;
        }
    };

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.e.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.webAuthResult.setResultCode(-202);
            this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            loginFail(this.webAuthResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.webAuthResult.activity = this;
        this.finishActivityAfterSuc = getIntent().getBooleanExtra(EXTRA_LOGIN_FINISH_AFTER_SUC, true);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    protected SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getWebLoginDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.back();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        super.finish();
        SocialLoginBase.setWXLoginCallback(null);
        WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
        if (webLoginDTO != null && webLoginDTO.closeEnterAnimId != 0 && webLoginDTO.closeExitAnimId != 0) {
            overridePendingTransition(webLoginDTO.closeEnterAnimId, webLoginDTO.closeExitAnimId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        this.sapiWebView.back();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.webAuthResult.setResultCode(-301);
        this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        loginFail(this.webAuthResult);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        configTitle();
        WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
        this.businessType = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.userName = getIntent().getStringExtra("username");
        this.loginType = getIntent().getStringExtra(EXTRA_LOGIN_TYPE);
        this.sapiWebView = (SapiWebView) findViewById(a.d.sapi_webview);
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                LoginActivity.this.onClose();
            }
        });
        this.sapiWebView.setAuthorizationListener(this.authorizationListener);
        this.sapiWebView.setSocialLoginHandler(new AnonymousClass4());
        this.sapiWebView.setFastRegHandler(new SapiWebView.FastRegHandler() { // from class: com.baidu.sapi2.activity.LoginActivity.5
            @Override // com.baidu.sapi2.SapiWebView.FastRegHandler
            public void handleFastReg() {
                Intent intent = new Intent(LoginActivity.this, FastRegActivity.class);
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, LoginActivity.this.businessType);
                LoginActivity.this.startActivityForResult(intent, 2003);
            }
        });
        this.sapiWebView.setLoadExternalWebViewCallback(new SapiWebView.LoadExternalWebViewCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.6
            @Override // com.baidu.sapi2.SapiWebView.LoadExternalWebViewCallback
            public void loadExternalWebview(SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult) {
                Intent intent = new Intent(LoginActivity.this, LoadExternalWebViewActivity.class);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, loadExternalWebViewResult.defaultTitle);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_URL, loadExternalWebViewResult.externalUrl);
                LoginActivity.this.startActivityForResult(intent, 2005);
            }
        });
        if (supportShareLogin) {
            this.sapiWebView.setShareAccountClickCallback(new SapiWebView.ShareAccountClickCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.7
                @Override // com.baidu.sapi2.SapiWebView.ShareAccountClickCallback
                public void onClick(String str, String str2) {
                    new ShareCallPacking().startLoginShareActivityForResult(LoginActivity.this, str, str2);
                }
            });
        }
        this.sapiWebView.setSystemUpwardSmsCallback(new SapiWebView.SystemUpwardSmsCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.8
            @Override // com.baidu.sapi2.SapiWebView.SystemUpwardSmsCallback
            public void onResult(SapiWebView.SystemUpwardSmsCallback.Result result) {
                LoginActivity.this.result = result;
                if (result != null) {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + result.destination));
                    intent.putExtra("sms_body", result.content);
                    if (intent.resolveActivity(LoginActivity.this.getPackageManager()) != null) {
                        LoginActivity.this.startActivityForResult(intent, 2004);
                    } else {
                        Toast.makeText(LoginActivity.this, LoginActivity.this.getString(a.f.sapi_sdk_account_center_please_download_message_app), 1).show();
                    }
                }
            }
        });
        SapiJsCallBacks.JoinLoginParams joinLoginParams = new SapiJsCallBacks.JoinLoginParams();
        if (WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.loginType)) {
            joinLoginParams.hasThirdAccount = true;
        } else {
            joinLoginParams.hasThirdAccount = false;
        }
        joinLoginParams.agreement = webLoginDTO == null ? null : webLoginDTO.agreement;
        this.sapiWebView.setJoinLoingParams(joinLoginParams);
        this.sapiWebView.shareV2Disable = webLoginDTO == null ? false : webLoginDTO.shareV2Disable;
        List<NameValuePair> arrayList = webLoginDTO != null ? webLoginDTO.extraParams : new ArrayList<>();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            arrayList.add(new BasicNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
        }
        if (WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.loginType) || WebLoginDTO.EXTRA_JOIN_LOGIN_WITHOUT_THIRD_ACCOUNT.equals(this.loginType)) {
            this.sapiWebView.loadLogin(4, arrayList);
        } else if (WebLoginDTO.EXTRA_LOGIN_WITH_SMS.equals(this.loginType)) {
            setTitleText(a.f.sapi_sdk_title_sms_login);
            this.sapiWebView.loadLogin(1, arrayList);
        } else {
            if (!TextUtils.isEmpty(this.userName)) {
                arrayList.add(new BasicNameValuePair(SapiWebView.PARAMS_LOGIN_WITH_USER_NAME, this.userName));
            }
            setTitleText(a.f.sapi_sdk_title_login);
            this.sapiWebView.loadLogin(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.activity.LoginActivity$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass4 extends Handler {
        AnonymousClass4() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            PassportSDK.getInstance().getThirdPartyService().loadThirdPartyLogin(LoginActivity.this, (SocialType) message.obj, LoginActivity.this.businessType);
            SocialLoginBase.setWXLoginCallback(new SocialLoginBase.WXInvokeCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.4.1
                @Override // com.baidu.sapi2.social.SocialLoginBase.WXInvokeCallback
                public void onResult(final int i, Intent intent) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.activity.LoginActivity.4.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i == 1001) {
                                LoginActivity.this.loginSucces(SapiAccountManager.getInstance().getSession().getAccountType(), true);
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginFail(WebAuthResult webAuthResult) {
        if (this.businessType == 2003) {
            finish();
            return;
        }
        WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        if (webAuthListener != null) {
            webAuthListener.onFailure(webAuthResult);
        }
        finish();
        if (shouldPassSDKRelease()) {
            PassportSDK.getInstance().release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginSucces(AccountType accountType, boolean z) {
        if (this.businessType == 2003) {
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            Intent intent = new Intent();
            intent.putExtra("bduss", session.bduss);
            setResult(-1, intent);
            if (this.finishActivityAfterSuc) {
                finish();
            }
        } else if (z) {
            finish();
            if (shouldPassSDKRelease()) {
                PassportSDK.getInstance().release();
            }
        } else {
            WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                this.webAuthResult.accountType = accountType;
                this.webAuthResult.setResultCode(0);
                webAuthListener.onSuccess(this.webAuthResult);
            }
            if (this.finishActivityAfterSuc) {
                finish();
                if (shouldPassSDKRelease()) {
                    PassportSDK.getInstance().release();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        finish();
        if (shouldPassSDKRelease() && z) {
            PassportSDK.getInstance().release();
        }
    }

    private boolean shouldPassSDKRelease() {
        return this.businessType != 2003 && PassportSDK.getInstance().getWebBindWidgetDTO() == null && PassportSDK.getInstance().getAccountCenterDTO() == null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        new ShareCallPacking().onLoginActivityActivityResult(new ShareCallPacking.ShareLoginCallBack() { // from class: com.baidu.sapi2.activity.LoginActivity.9
            @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
            public void onSuccess() {
                LoginActivity.this.loginSucces(AccountType.NORMAL, false);
            }
        }, i, i2, intent);
        this.sapiWebView.onAuthorizedResult(i, i2, intent);
        if (i == 2001) {
            if (i2 == 1001) {
                loginSucces(SapiAccountManager.getInstance().getSession().getAccountType(), true);
            }
        } else if (i == 2003) {
            if (i2 == 1001) {
                this.authorizationListener.onSuccess(SapiAccountManager.getInstance().getSession().getAccountType());
            }
            if (i2 == 1002) {
                this.authorizationListener.onFailed(intent.getIntExtra("result_code", -100), intent.getStringExtra("result_msg"));
            }
        } else if (i == 2005) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE);
                if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_PRE_SET_UNAME.equals(stringExtra)) {
                    this.sapiWebView.preSetUserName(intent.getStringExtra("username"));
                } else if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE.equals(stringExtra)) {
                    this.webAuthResult.isAccountFreeze = true;
                } else {
                    int type = AccountType.UNKNOWN.getType();
                    if (intent != null) {
                        type = intent.getIntExtra(GiftTabActivityConfig.ACCOUNT_TYPE, AccountType.UNKNOWN.getType());
                    }
                    loginSucces(AccountType.getAccountType(type), false);
                }
            }
        } else if (i == 2004 && this.result != null) {
            this.result.onFinish();
        }
    }
}
