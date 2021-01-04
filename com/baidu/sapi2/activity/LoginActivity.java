package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.l.a.a;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.b;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.social.WXInvokeCallback;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LoginActivity extends BaseActivity {
    private static final int A = 2005;
    public static final String EXTRA_LOGIN_FINISH_AFTER_SUC = "extra_login_finish_after_suc";
    public static final String EXTRA_LOGIN_TYPE = "extra_login_type";
    public static final String EXTRA_PARAM_ENCRYPTED_UID = "encryptedUid";
    public static final String EXTRA_PARAM_EXTRAS_JSON = "extraJson";
    public static final String EXTRA_PARAM_USERNAME = "username";
    public static final int REQUEST_SOCIAL_LOGIN = 2001;
    public static boolean supportShareLogin = true;
    private SapiWebView q;
    private boolean s;
    private int t;
    private String u;
    private String v;
    private String w;
    private String x;
    private List<PassNameValuePair> y;
    private boolean p = false;
    private WebAuthResult r = new WebAuthResult() { // from class: com.baidu.sapi2.activity.LoginActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            super.finishActivity();
            LoginActivity.this.a(true);
        }

        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity(boolean z) {
            super.finishActivity();
            LoginActivity.this.a(false);
        }
    };
    private AuthorizationListener z = new AuthorizationListener() { // from class: com.baidu.sapi2.activity.LoginActivity.2
        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            super.beforeSuccess(sapiAccount);
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                webAuthListener.beforeSuccess(sapiAccount);
            }
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            if (LoginActivity.this.t != 2003) {
                LoginActivity.this.r.setResultCode(i);
                LoginActivity.this.r.setResultMsg(str);
                LoginActivity loginActivity = LoginActivity.this;
                loginActivity.a(loginActivity.r);
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

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    @TargetApi(5)
    public void finish() {
        super.finish();
        if (this.t == 2005) {
            startActivity(new Intent(this, GrantWebActivity.class));
        }
        SocialLoginBase.setWXLoginCallback(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getWebLoginDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.r.activity = this;
        this.s = getIntent().getBooleanExtra(EXTRA_LOGIN_FINISH_AFTER_SUC, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        int intExtra;
        super.onActivityResult(i, i2, intent);
        new b().a(new b.AbstractC0349b() { // from class: com.baidu.sapi2.activity.LoginActivity.7
            @Override // com.baidu.sapi2.share.b.AbstractC0349b
            public void onSuccess() {
                LoginActivity.this.a(AccountType.NORMAL, false);
            }
        }, i, i2, intent, this.y);
        if ((i == 2001 && i2 == 1001) || this.p) {
            a((AccountType) null, true);
            this.p = false;
        } else if (i == 2005 && i2 == -1) {
            String str = "";
            String str2 = "";
            if (intent != null) {
                str = intent.getStringExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE);
                str2 = intent.getStringExtra("username");
            }
            if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_PRE_SET_UNAME.equals(str)) {
                this.q.preSetUserName(str2);
            } else if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE.equals(str)) {
                this.r.isAccountFreeze = true;
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
        this.q.back();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.r.setResultCode(-301);
        this.r.setResultMsg("您已取消操作");
        a(this.r);
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
            this.r.setResultCode(-202);
            this.r.setResultMsg("网络连接失败，请检查网络设置");
            a(this.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        this.q.back();
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
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        this.y = webLoginDTO != null ? webLoginDTO.extraParams : new ArrayList<>();
        this.t = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.u = getIntent().getStringExtra("username");
        this.v = getIntent().getStringExtra(EXTRA_LOGIN_TYPE);
        this.w = getIntent().getStringExtra(EXTRA_PARAM_ENCRYPTED_UID);
        this.x = getIntent().getStringExtra("extraJson");
        this.q = (SapiWebView) findViewById(a.e.sapi_webview);
        this.q.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                LoginActivity.this.onClose();
            }
        });
        this.q.setAuthorizationListener(this.z);
        this.q.setSocialLoginHandler(new Handler() { // from class: com.baidu.sapi2.activity.LoginActivity.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                AbstractThirdPartyService thirdPartyService = CoreViewRouter.getInstance().getThirdPartyService();
                LoginActivity loginActivity = LoginActivity.this;
                thirdPartyService.loadThirdPartyLogin(loginActivity, (SocialType) message.obj, loginActivity.t, LoginActivity.this.x);
                SocialLoginBase.setWXLoginCallback(new WXInvokeCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.4.1
                    @Override // com.baidu.sapi2.social.WXInvokeCallback
                    public void onResult(int i, Intent intent) {
                        if (i == 1001) {
                            LoginActivity.this.p = true;
                        }
                    }
                });
            }
        });
        this.q.setLoadExternalWebViewCallback(new SapiWebView.LoadExternalWebViewCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.5
            @Override // com.baidu.sapi2.SapiWebView.LoadExternalWebViewCallback
            public void loadExternalWebview(SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult) {
                Intent intent = new Intent(LoginActivity.this, LoadExternalWebViewActivity.class);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, loadExternalWebViewResult.defaultTitle);
                intent.putExtra("extra_external_url", loadExternalWebViewResult.externalUrl);
                LoginActivity.this.startActivityForResult(intent, 2005);
            }
        });
        if (supportShareLogin) {
            this.q.setShareAccountClickCallback(new SapiWebView.ShareAccountClickCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.6
                @Override // com.baidu.sapi2.SapiWebView.ShareAccountClickCallback
                public void onClick(String str, String str2, String str3, String str4, String str5) {
                    b bVar = new b();
                    LoginActivity loginActivity = LoginActivity.this;
                    bVar.a(loginActivity, str, str2, str3, str4, loginActivity.y, str5);
                }
            });
        }
        SapiJsCallBacks.JoinLoginParams joinLoginParams = new SapiJsCallBacks.JoinLoginParams();
        if (!TextUtils.isEmpty(this.w) && !TextUtils.isEmpty(this.u)) {
            WebLoginDTO webLoginDTO2 = webLoginDTO == null ? new WebLoginDTO() : webLoginDTO;
            webLoginDTO2.encryptedId = this.w;
            webLoginDTO2.preSetUname = this.u;
            webLoginDTO = webLoginDTO2;
        }
        if (webLoginDTO != null) {
            if ((!TextUtils.isEmpty(webLoginDTO.encryptedId) || !TextUtils.isEmpty(webLoginDTO.uid)) && !TextUtils.isEmpty(webLoginDTO.preSetUname)) {
                SapiJsCallBacks.DirectedLoginParams directedLoginParams = new SapiJsCallBacks.DirectedLoginParams();
                directedLoginParams.uid = webLoginDTO.uid;
                directedLoginParams.encryptedId = webLoginDTO.encryptedId;
                directedLoginParams.displayname = webLoginDTO.preSetUname;
                this.y.add(SapiWebView.EXTRA_SUPPORT_DIRECT_LOGIN);
                this.q.setDirectedLoginParams(directedLoginParams);
            }
            if (WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
                this.y.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
            }
            SapiWebView sapiWebView = this.q;
            sapiWebView.shareV2Disable = webLoginDTO.shareV2Disable;
            joinLoginParams.agreement = webLoginDTO.agreement;
            sapiWebView.setHideSuccessTip(webLoginDTO.hideSuccessTip);
            WebLoginDTO.Config config = webLoginDTO.config;
            if (config != null) {
                this.q.supportTouchGuide = config.supportTouchGuide;
            }
        }
        if (!TextUtils.isEmpty(this.x)) {
            try {
                JSONObject jSONObject = new JSONObject(this.x);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.y.add(new PassNameValuePair(next, jSONObject.getString(next)));
                }
            } catch (JSONException e) {
                Log.e(e);
            }
        }
        if (WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.v)) {
            joinLoginParams.hasThirdAccount = true;
        } else {
            joinLoginParams.hasThirdAccount = false;
        }
        this.q.setJoinLoingParams(joinLoginParams);
        if (!WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.v) && !WebLoginDTO.EXTRA_JOIN_LOGIN_WITHOUT_THIRD_ACCOUNT.equals(this.v)) {
            if (WebLoginDTO.EXTRA_LOGIN_WITH_SMS.equals(this.v)) {
                setTitleText(a.g.sapi_sdk_title_sms_login);
                this.q.loadLogin(1, this.y);
                return;
            } else if (WebLoginDTO.EXTRA_LOGIN_WITH_NAME_PHONE_EMAIL.equals(this.v)) {
                this.q.loadLogin(6, this.y);
                return;
            } else {
                if (!TextUtils.isEmpty(this.u)) {
                    this.y.add(new PassNameValuePair(SapiWebView.PARAMS_LOGIN_WITH_USER_NAME, this.u));
                }
                setTitleText(a.g.sapi_sdk_title_login);
                this.q.loadLogin(this.y);
                return;
            }
        }
        this.q.loadLogin(4, this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WebAuthResult webAuthResult) {
        if (this.t == 2003) {
            finish();
            return;
        }
        WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
        if (webAuthListener != null) {
            webAuthListener.onFailure(webAuthResult);
        }
        finish();
        if (a()) {
            CoreViewRouter.getInstance().release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType, boolean z) {
        new com.baidu.sapi2.utils.b().a(com.baidu.sapi2.utils.b.f5379a + SapiUtils.getLastLoginType());
        if (this.t == 2003) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            Intent intent = new Intent();
            intent.putExtra("bduss", currentAccount.bduss);
            setResult(-1, intent);
            if (this.s) {
                finish();
            }
        } else if (z) {
            finish();
            if (a()) {
                CoreViewRouter.getInstance().release();
            }
        } else {
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                WebAuthResult webAuthResult = this.r;
                webAuthResult.accountType = accountType;
                webAuthResult.setResultCode(0);
                webAuthListener.onSuccess(this.r);
            }
            if (this.s) {
                finish();
                if (a()) {
                    CoreViewRouter.getInstance().release();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        finish();
        if (a() && z) {
            CoreViewRouter.getInstance().release();
        }
    }

    private boolean a() {
        return this.t != 2003 && CoreViewRouter.getInstance().getWebBindWidgetDTO() == null && CoreViewRouter.getInstance().getAccountCenterDTO() == null;
    }
}
