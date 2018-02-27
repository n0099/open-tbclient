package com.baidu.sapi2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.c.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class LoginActivity extends TitleActivity {
    public static final int BUSINESS_FROM_ACCOUNT_CENTER = 1;
    public static final String EXTRA_LOGIN_FINISH_AFTER_SUC = "extra_login_finish_after_suc";
    public static final String EXTRA_LOGIN_TYPE = "extra_login_type";
    public static final String EXTRA_PARAM_LOGIN_FROM_BUSINESS = "extra_from_account_center";
    public static final String EXTRA_PARAM_USERNAME = "username";
    private static final int REQUEST_CALL_SYSTEM_SMS = 2004;
    private static final int REQUEST_CODE_LOAD_EXTERNAL_WEBVIEW = 2005;
    private static final int REQUEST_FAST_REG = 2003;
    private static final int REQUEST_SOCIAL_LOGIN = 2001;
    private AuthorizationListener authorizationListener = new AuthorizationListener() { // from class: com.baidu.sapi2.activity.LoginActivity.1
        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            LoginActivity.this.loginSucces(accountType);
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            if (LoginActivity.this.businessType != 1) {
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
    private int businessType;
    private boolean finishActivityAfterSuc;
    private String loginType;
    private SapiWebView.SystemUpwardSmsCallback.Result result;
    private SapiWebView sapiWebView;
    private String userName;
    private WebAuthResult webAuthResult;

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.e.layout_sapi_sdk_webview_with_title_bar);
        init();
        setupViews();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity
    public void init() {
        super.init();
        this.webAuthResult = new WebAuthResult();
        this.webAuthResult.activity = this;
        this.finishActivityAfterSuc = getIntent().getBooleanExtra(EXTRA_LOGIN_FINISH_AFTER_SUC, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.back();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
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
    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity
    public void setupViews() {
        super.setupViews();
        configTitle();
        this.businessType = getIntent().getIntExtra(EXTRA_PARAM_LOGIN_FROM_BUSINESS, -1);
        this.userName = getIntent().getStringExtra("username");
        this.loginType = getIntent().getStringExtra(EXTRA_LOGIN_TYPE);
        this.sapiWebView = (SapiWebView) findViewById(a.d.sapi_webview);
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                LoginActivity.this.webAuthResult.setResultCode(-301);
                LoginActivity.this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
                LoginActivity.this.loginFail(LoginActivity.this.webAuthResult);
            }
        });
        this.sapiWebView.setAuthorizationListener(this.authorizationListener);
        this.sapiWebView.setSocialLoginHandler(new Handler() { // from class: com.baidu.sapi2.activity.LoginActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != SocialType.WEIXIN.getType()) {
                    PassportSDK.getInstance().getThirdPartyService().loadThirdPartyIndirect(LoginActivity.this, message.what, LoginActivity.this.businessType);
                    return;
                }
                LoginActivity.this.finish();
                if (PassportSDK.getInstance().getWebSocialLoginCallback() != null) {
                    PassportSDK.getInstance().getWebSocialLoginCallback().handleSocialLogin(message);
                }
                if (LoginActivity.this.businessType != 1) {
                    PassportSDK.getInstance().release();
                }
            }
        });
        this.sapiWebView.setFastRegHandler(new SapiWebView.FastRegHandler() { // from class: com.baidu.sapi2.activity.LoginActivity.4
            @Override // com.baidu.sapi2.SapiWebView.FastRegHandler
            public void handleFastReg() {
                Intent intent = new Intent(LoginActivity.this, FastRegActivity.class);
                intent.putExtra(FastRegActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
                LoginActivity.this.startActivityForResult(intent, 2003);
            }
        });
        this.sapiWebView.setLoadExternalWebViewCallback(new SapiWebView.LoadExternalWebViewCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.5
            @Override // com.baidu.sapi2.SapiWebView.LoadExternalWebViewCallback
            public void loadExternalWebview(SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult) {
                Intent intent = new Intent(LoginActivity.this, LoadExternalWebViewActivity.class);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, loadExternalWebViewResult.defaultTitle);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_URL, loadExternalWebViewResult.externalUrl);
                LoginActivity.this.startActivityForResult(intent, 2005);
            }
        });
        this.sapiWebView.setShareAccountClickCallback(new SapiWebView.ShareAccountClickCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.6
            @Override // com.baidu.sapi2.SapiWebView.ShareAccountClickCallback
            public void onClick(String str, String str2) {
                new ShareCallPacking().startLoginShareActivityForResult(LoginActivity.this, str, str2);
            }
        });
        this.sapiWebView.setSystemUpwardSmsCallback(new SapiWebView.SystemUpwardSmsCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.7
            @Override // com.baidu.sapi2.SapiWebView.SystemUpwardSmsCallback
            public void onResult(SapiWebView.SystemUpwardSmsCallback.Result result) {
                LoginActivity.this.result = result;
                if (result != null) {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + result.destination));
                    intent.putExtra("sms_body", result.content);
                    LoginActivity.this.startActivityForResult(intent, 2004);
                }
            }
        });
        WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
        List<NameValuePair> arrayList = webLoginDTO != null ? webLoginDTO.extraParams : new ArrayList<>();
        if (this.loginType != null && this.loginType.equals(WebLoginDTO.EXTRA_LOGIN_WITH_SMS)) {
            this.sapiWebView.loadLogin(1, arrayList);
            return;
        }
        if (!TextUtils.isEmpty(this.userName)) {
            arrayList.add(new BasicNameValuePair(SapiWebView.PARAMS_LOGIN_WITH_USER_NAME, this.userName));
        }
        this.sapiWebView.loadLogin(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginFail(WebAuthResult webAuthResult) {
        if (this.businessType == 1) {
            finish();
            return;
        }
        WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        if (webAuthListener != null) {
            webAuthListener.onFailure(webAuthResult);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginSucces(AccountType accountType) {
        if (this.businessType == 1) {
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            Intent intent = new Intent();
            intent.putExtra("bduss", session.bduss);
            setResult(-1, intent);
            if (this.finishActivityAfterSuc) {
                finish();
                return;
            }
            return;
        }
        WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        if (webAuthListener != null) {
            this.webAuthResult.accountType = accountType;
            this.webAuthResult.setResultCode(0);
            webAuthListener.onSuccess(this.webAuthResult);
        }
        if (this.finishActivityAfterSuc) {
            finish();
            PassportSDK.getInstance().release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        new ShareCallPacking().onLoginActivityActivityResult(this, new ShareCallPacking.ShareLoginCallBack() { // from class: com.baidu.sapi2.activity.LoginActivity.8
            @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
            public void onSuccess() {
                LoginActivity.this.loginSucces(AccountType.NORMAL);
            }
        }, i, i2, intent);
        this.sapiWebView.onAuthorizedResult(i, i2, intent);
        if (i == 2001) {
            if (i2 == 1001) {
                this.authorizationListener.onSuccess(SapiAccountManager.getInstance().getSession().getAccountType());
            }
            if (i2 == 1002) {
                this.authorizationListener.onFailed(intent.getIntExtra("result_code", -100), intent.getStringExtra("result_msg"));
            }
        } else if (i == 2003) {
            if (i2 == 1001) {
                this.authorizationListener.onSuccess();
            }
            if (i2 == 1002) {
                this.authorizationListener.onFailed(intent.getIntExtra("result_code", -100), intent.getStringExtra("result_msg"));
            }
        } else if (i == 2005) {
            if (i2 == -1) {
                if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE.equals(intent.getStringExtra("business"))) {
                    this.sapiWebView.preSetUserName(intent.getStringExtra("username"));
                    return;
                }
                int type = AccountType.UNKNOWN.getType();
                if (intent != null) {
                    type = intent.getIntExtra(GiftTabActivityConfig.ACCOUNT_TYPE, AccountType.UNKNOWN.getType());
                }
                loginSucces(AccountType.getAccountType(type));
            }
        } else if (i == 2004 && this.result != null) {
            this.result.onFinish();
        }
    }
}
