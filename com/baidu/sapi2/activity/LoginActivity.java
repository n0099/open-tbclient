package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.g.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.m;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.social.WXInvokeCallback;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class LoginActivity extends BaseActivity {
    public static final String EXTRA_LOGIN_FINISH_AFTER_SUC = "extra_login_finish_after_suc";
    public static final String EXTRA_LOGIN_TYPE = "extra_login_type";
    public static final String EXTRA_PARAM_ENCRYPTED_UID = "encryptedUid";
    public static final String EXTRA_PARAM_EXTRAS_JSON = "extraJson";
    public static final String EXTRA_PARAM_USERNAME = "username";
    public static final int REQUEST_SOCIAL_LOGIN = 2001;
    private static final int r = 2004;
    private static final int s = 2005;
    public static boolean supportShareLogin = true;
    private String A;
    private List<PassNameValuePair> B;
    private SapiWebView.SystemUpwardSmsCallback.Result C;
    private SapiWebView sapiWebView;
    private boolean v;
    private int w;
    private String x;
    private String y;
    private String z;
    private boolean t = false;
    private WebAuthResult u = new WebAuthResult() { // from class: com.baidu.sapi2.activity.LoginActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            super.finishActivity();
            LoginActivity.this.b(true);
        }

        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity(boolean z) {
            super.finishActivity();
            LoginActivity.this.b(false);
        }
    };
    private AuthorizationListener D = new AuthorizationListener() { // from class: com.baidu.sapi2.activity.LoginActivity.2
        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            super.beforeSuccess(sapiAccount);
            WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                webAuthListener.beforeSuccess(sapiAccount);
            }
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            if (LoginActivity.this.w != 2003) {
                LoginActivity.this.u.setResultCode(i);
                LoginActivity.this.u.setResultMsg(str);
                LoginActivity loginActivity = LoginActivity.this;
                loginActivity.a(loginActivity.u);
                return;
            }
            LoginActivity.this.setResult(0);
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public boolean onForgetPwd() {
            LoginActivity.this.startActivity(new Intent(LoginActivity.this, ForgetPwdActivity.class));
            return true;
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            LoginActivity.this.a(accountType, false);
        }
    };

    private boolean e() {
        return this.w != 2003 && PassportSDK.getInstance().getWebBindWidgetDTO() == null && PassportSDK.getInstance().getAccountCenterDTO() == null;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    @TargetApi(5)
    public void finish() {
        super.finish();
        if (this.w == 2005) {
            startActivity(new Intent(this, GrantWebActivity.class));
        }
        SocialLoginBase.setWXLoginCallback(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getWebLoginDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.u.activity = this;
        this.v = getIntent().getBooleanExtra(EXTRA_LOGIN_FINISH_AFTER_SUC, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        SapiWebView.SystemUpwardSmsCallback.Result result;
        int intExtra;
        super.onActivityResult(i, i2, intent);
        new m().a(new m.a() { // from class: com.baidu.sapi2.activity.LoginActivity.8
            @Override // com.baidu.sapi2.share.m.a
            public void onSuccess() {
                LoginActivity.this.a(AccountType.NORMAL, false);
            }
        }, i, i2, intent, this.B);
        if ((i == 2001 && i2 == 1001) || this.t) {
            a((AccountType) null, true);
            this.t = false;
        } else if (i != 2005) {
            if (i != 2004 || (result = this.C) == null) {
                return;
            }
            result.onFinish();
        } else if (i2 == -1) {
            String str = "";
            String str2 = "";
            if (intent != null) {
                str = intent.getStringExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE);
                str2 = intent.getStringExtra("username");
            }
            if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_PRE_SET_UNAME.equals(str)) {
                this.sapiWebView.preSetUserName(str2);
            } else if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE.equals(str)) {
                this.u.isAccountFreeze = true;
            } else {
                if (intent == null) {
                    intExtra = AccountType.UNKNOWN.getType();
                } else {
                    intExtra = intent.getIntExtra("account_type", AccountType.UNKNOWN.getType());
                }
                a(AccountType.getAccountType(intExtra), false);
            }
        }
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
        this.u.setResultCode(-301);
        this.u.setResultMsg("您已取消操作");
        a(this.u);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.u.setResultCode(-202);
            this.u.setResultMsg("网络连接失败，请检查网络设置");
            a(this.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        this.sapiWebView.back();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        configTitle();
        WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
        this.B = webLoginDTO != null ? webLoginDTO.extraParams : new ArrayList<>();
        this.w = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.x = getIntent().getStringExtra("username");
        this.y = getIntent().getStringExtra(EXTRA_LOGIN_TYPE);
        this.z = getIntent().getStringExtra(EXTRA_PARAM_ENCRYPTED_UID);
        this.A = getIntent().getStringExtra("extraJson");
        this.sapiWebView = (SapiWebView) findViewById(a.e.sapi_webview);
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                LoginActivity.this.onClose();
            }
        });
        this.sapiWebView.setAuthorizationListener(this.D);
        this.sapiWebView.setSocialLoginHandler(new Handler() { // from class: com.baidu.sapi2.activity.LoginActivity.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                AbstractThirdPartyService thirdPartyService = PassportSDK.getInstance().getThirdPartyService();
                LoginActivity loginActivity = LoginActivity.this;
                thirdPartyService.loadThirdPartyLogin(loginActivity, (SocialType) message.obj, loginActivity.w, LoginActivity.this.A);
                SocialLoginBase.setWXLoginCallback(new WXInvokeCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.4.1
                    @Override // com.baidu.sapi2.social.WXInvokeCallback
                    public void onResult(int i, Intent intent) {
                        if (i == 1001) {
                            LoginActivity.this.t = true;
                        }
                    }
                });
            }
        });
        this.sapiWebView.setLoadExternalWebViewCallback(new SapiWebView.LoadExternalWebViewCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.5
            @Override // com.baidu.sapi2.SapiWebView.LoadExternalWebViewCallback
            public void loadExternalWebview(SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult) {
                Intent intent = new Intent(LoginActivity.this, LoadExternalWebViewActivity.class);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, loadExternalWebViewResult.defaultTitle);
                intent.putExtra("extra_external_url", loadExternalWebViewResult.externalUrl);
                LoginActivity.this.startActivityForResult(intent, 2005);
            }
        });
        if (supportShareLogin) {
            this.sapiWebView.setShareAccountClickCallback(new SapiWebView.ShareAccountClickCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.6
                @Override // com.baidu.sapi2.SapiWebView.ShareAccountClickCallback
                public void onClick(String str, String str2, String str3, String str4) {
                    m mVar = new m();
                    LoginActivity loginActivity = LoginActivity.this;
                    mVar.a(loginActivity, str, str2, str3, str4, loginActivity.B);
                }
            });
        }
        this.sapiWebView.setSystemUpwardSmsCallback(new SapiWebView.SystemUpwardSmsCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.7
            @Override // com.baidu.sapi2.SapiWebView.SystemUpwardSmsCallback
            public void onResult(SapiWebView.SystemUpwardSmsCallback.Result result) {
                LoginActivity.this.C = result;
                if (result != null) {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + result.destination));
                    intent.putExtra("sms_body", result.content);
                    if (intent.resolveActivity(LoginActivity.this.getPackageManager()) != null) {
                        LoginActivity.this.startActivityForResult(intent, 2004);
                        return;
                    }
                    LoginActivity loginActivity = LoginActivity.this;
                    Toast.makeText(loginActivity, loginActivity.getString(a.g.sapi_sdk_account_center_please_download_message_app), 1).show();
                }
            }
        });
        SapiJsCallBacks.JoinLoginParams joinLoginParams = new SapiJsCallBacks.JoinLoginParams();
        if (!TextUtils.isEmpty(this.z) && !TextUtils.isEmpty(this.x)) {
            WebLoginDTO webLoginDTO2 = webLoginDTO == null ? new WebLoginDTO() : webLoginDTO;
            webLoginDTO2.encryptedId = this.z;
            webLoginDTO2.preSetUname = this.x;
            webLoginDTO = webLoginDTO2;
        }
        if (webLoginDTO != null) {
            if ((!TextUtils.isEmpty(webLoginDTO.encryptedId) || !TextUtils.isEmpty(webLoginDTO.uid)) && !TextUtils.isEmpty(webLoginDTO.preSetUname)) {
                SapiJsCallBacks.DirectedLoginParams directedLoginParams = new SapiJsCallBacks.DirectedLoginParams();
                directedLoginParams.uid = webLoginDTO.uid;
                directedLoginParams.encryptedId = webLoginDTO.encryptedId;
                directedLoginParams.displayname = webLoginDTO.preSetUname;
                this.B.add(SapiWebView.EXTRA_SUPPORT_DIRECT_LOGIN);
                this.sapiWebView.setDirectedLoginParams(directedLoginParams);
            }
            if (WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
                this.B.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
            }
            SapiWebView sapiWebView = this.sapiWebView;
            sapiWebView.shareV2Disable = webLoginDTO.shareV2Disable;
            joinLoginParams.agreement = webLoginDTO.agreement;
            sapiWebView.setHideSuccessTip(webLoginDTO.hideSuccessTip);
            WebLoginDTO.Config config = webLoginDTO.config;
            if (config != null) {
                this.sapiWebView.supportTouchGuide = config.supportTouchGuide;
            }
        }
        if (!TextUtils.isEmpty(this.A)) {
            try {
                JSONObject jSONObject = new JSONObject(this.A);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.B.add(new PassNameValuePair(next, jSONObject.getString(next)));
                }
            } catch (JSONException e) {
                Log.e(e);
            }
        }
        if (WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.y)) {
            joinLoginParams.hasThirdAccount = true;
        } else {
            joinLoginParams.hasThirdAccount = false;
        }
        this.sapiWebView.setJoinLoingParams(joinLoginParams);
        if (!WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.y) && !WebLoginDTO.EXTRA_JOIN_LOGIN_WITHOUT_THIRD_ACCOUNT.equals(this.y)) {
            if (WebLoginDTO.EXTRA_LOGIN_WITH_SMS.equals(this.y)) {
                setTitleText(a.g.sapi_sdk_title_sms_login);
                this.sapiWebView.loadLogin(1, this.B);
                return;
            } else if (WebLoginDTO.EXTRA_LOGIN_WITH_NAME_PHONE_EMAIL.equals(this.y)) {
                this.sapiWebView.loadLogin(6, this.B);
                return;
            } else {
                if (!TextUtils.isEmpty(this.x)) {
                    this.B.add(new PassNameValuePair(SapiWebView.PARAMS_LOGIN_WITH_USER_NAME, this.x));
                }
                setTitleText(a.g.sapi_sdk_title_login);
                this.sapiWebView.loadLogin(this.B);
                return;
            }
        }
        this.sapiWebView.loadLogin(4, this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        finish();
        if (e() && z) {
            PassportSDK.getInstance().release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WebAuthResult webAuthResult) {
        if (this.w == 2003) {
            finish();
            return;
        }
        WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        if (webAuthListener != null) {
            webAuthListener.onFailure(webAuthResult);
        }
        finish();
        if (e()) {
            PassportSDK.getInstance().release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType, boolean z) {
        new b().a(b.a + SapiUtils.getLastLoginType());
        if (this.w == 2003) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            Intent intent = new Intent();
            intent.putExtra("bduss", currentAccount.bduss);
            setResult(-1, intent);
            if (this.v) {
                finish();
            }
        } else if (z) {
            finish();
            if (e()) {
                PassportSDK.getInstance().release();
            }
        } else {
            WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                WebAuthResult webAuthResult = this.u;
                webAuthResult.accountType = accountType;
                webAuthResult.setResultCode(0);
                webAuthListener.onSuccess(this.u);
            }
            if (this.v) {
                finish();
                if (e()) {
                    PassportSDK.getInstance().release();
                }
            }
        }
    }
}
