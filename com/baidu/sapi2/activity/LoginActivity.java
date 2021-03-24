package com.baidu.sapi2.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JsPromptResult;
import android.widget.Toast;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.a;
import com.baidu.sapi2.share.c;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.social.WXInvokeCallback;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import d.b.a0.a.e;
import d.b.a0.a.f;
import d.b.a0.a.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LoginActivity extends BaseActivity {
    public static final int A = 2005;
    public static final String B = "floating_window_tag";
    public static final String C = "login_page_tag";
    public static final String EXTRA_LOGIN_FINISH_AFTER_SUC = "extra_login_finish_after_suc";
    public static final String EXTRA_LOGIN_TYPE = "extra_login_type";
    public static final String EXTRA_PARAM_ENCRYPTED_UID = "encryptedUid";
    public static final String EXTRA_PARAM_EXTRAS_JSON = "extraJson";
    public static final String EXTRA_PARAM_THIRD_VERIFY_RESPONSE = "response";
    public static final String EXTRA_PARAM_USERNAME = "username";
    public static final int FIX_FLAG_WINDOW_IS_PARTIALLY_OBSCURED = 2;
    public static final int REQUEST_SHARE_V2_LOGIN = 2020;
    public static final int REQUEST_SOCIAL_LOGIN = 2001;
    public static boolean supportShareLogin = true;
    public static final String z = "LoginActivity";
    public boolean q;
    public boolean r;
    public int s;
    public SapiWebView sapiWebView;
    public String t;
    public String u;
    public String v;
    public String w;
    public List<PassNameValuePair> x;
    public boolean p = false;
    public WebAuthResult webAuthResult = new WebAuthResult() { // from class: com.baidu.sapi2.activity.LoginActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            super.finishActivity();
            LoginActivity.this.a(true);
        }

        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity(boolean z2) {
            super.finishActivity();
            LoginActivity.this.a(false);
        }
    };
    public AuthorizationListener y = new AuthorizationListener() { // from class: com.baidu.sapi2.activity.LoginActivity.2
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
            if (LoginActivity.this.s == 2003) {
                LoginActivity.this.setResult(0);
                return;
            }
            LoginActivity.this.webAuthResult.setResultCode(i);
            LoginActivity.this.webAuthResult.setResultMsg(str);
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.loginFail(loginActivity.webAuthResult);
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
        if (this.s == 2005) {
            startActivity(new Intent(this, GrantWebActivity.class));
        }
        SocialLoginBase.setWXLoginCallback(null);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getWebLoginDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.webAuthResult.activity = this;
        this.r = getIntent().getBooleanExtra(EXTRA_LOGIN_FINISH_AFTER_SUC, true);
    }

    public void loginFail(WebAuthResult webAuthResult) {
        if (this.s == 2003) {
            finish();
            return;
        }
        WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
        if (webAuthListener != null) {
            webAuthListener.onFailure(webAuthResult);
        }
        finish();
        if (b()) {
            CoreViewRouter.getInstance().release();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        int intExtra;
        super.onActivityResult(i, i2, intent);
        new a().a(new a.b() { // from class: com.baidu.sapi2.activity.LoginActivity.8
            @Override // com.baidu.sapi2.share.a.b
            public void onSuccess() {
                LoginActivity.this.a(AccountType.NORMAL, false);
            }
        }, i, i2, intent, this.x, c.l);
        if ((i == 2001 && i2 == 1001) || this.p) {
            a((AccountType) null, true);
            this.p = false;
        } else if (i == 2005) {
            if (i2 == -1) {
                String str2 = "";
                if (intent != null) {
                    str2 = intent.getStringExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE);
                    str = intent.getStringExtra("username");
                } else {
                    str = "";
                }
                if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_PRE_SET_UNAME.equals(str2)) {
                    this.sapiWebView.preSetUserName(str);
                } else if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE.equals(str2)) {
                    this.webAuthResult.isAccountFreeze = true;
                } else {
                    if (intent == null) {
                        intExtra = AccountType.UNKNOWN.getType();
                    } else {
                        intExtra = intent.getIntExtra("account_type", AccountType.UNKNOWN.getType());
                    }
                    a(AccountType.getAccountType(intExtra), false);
                }
            }
        } else if (i == 2020) {
            a(AccountType.NORMAL, false);
        }
        if (i == 2001 && i2 == 3001) {
            a(intent);
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        this.sapiWebView.back();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.webAuthResult.setResultCode(-301);
        this.webAuthResult.setResultMsg("您已取消操作");
        loginFail(this.webAuthResult);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        SapiWebView sapiWebView;
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
            a();
            StatService.onEvent(C, new HashMap());
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation == null || !confignation.isAgreeDangerousProtocol()) {
                com.baidu.sapi2.utils.a.a("需要同意隐私协议并同步pass");
            }
            if (getWebDTO() == null || (sapiWebView = this.sapiWebView) == null) {
                return;
            }
            sapiWebView.mExcludeTypes = getWebDTO().excludeTypes;
        } catch (Throwable th) {
            reportWebviewError(th);
            this.webAuthResult.setResultCode(-202);
            this.webAuthResult.setResultMsg("网络连接失败，请检查网络设置");
            loginFail(this.webAuthResult);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.back();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        this.x = webLoginDTO != null ? webLoginDTO.extraParams : new ArrayList<>();
        this.s = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.t = getIntent().getStringExtra("username");
        this.u = getIntent().getStringExtra(EXTRA_LOGIN_TYPE);
        this.v = getIntent().getStringExtra(EXTRA_PARAM_ENCRYPTED_UID);
        this.w = getIntent().getStringExtra("extraJson");
        SapiWebView sapiWebView = (SapiWebView) findViewById(e.sapi_webview);
        this.sapiWebView = sapiWebView;
        sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.4
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                LoginActivity.this.onClose();
            }
        });
        this.sapiWebView.setAuthorizationListener(this.y);
        this.sapiWebView.setSocialLoginHandler(new Handler() { // from class: com.baidu.sapi2.activity.LoginActivity.5
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                AbstractThirdPartyService thirdPartyService = CoreViewRouter.getInstance().getThirdPartyService();
                if (thirdPartyService != null) {
                    LoginActivity loginActivity = LoginActivity.this;
                    thirdPartyService.loadThirdPartyLogin(loginActivity, (SocialType) message.obj, loginActivity.s, LoginActivity.this.w);
                    SocialLoginBase.setWXLoginCallback(new WXInvokeCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.5.1
                        @Override // com.baidu.sapi2.social.WXInvokeCallback
                        public void onResult(int i, Intent intent) {
                            if (i == 1001) {
                                LoginActivity.this.p = true;
                            }
                        }
                    });
                }
            }
        });
        this.sapiWebView.setLoadExternalWebViewCallback(new SapiWebView.LoadExternalWebViewCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.6
            @Override // com.baidu.sapi2.SapiWebView.LoadExternalWebViewCallback
            public void loadExternalWebview(SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult) {
                Intent intent = new Intent(LoginActivity.this, LoadExternalWebViewActivity.class);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, loadExternalWebViewResult.defaultTitle);
                intent.putExtra("extra_external_url", loadExternalWebViewResult.externalUrl);
                LoginActivity.this.startActivityForResult(intent, 2005);
            }
        });
        if (supportShareLogin) {
            this.sapiWebView.setShareAccountClickCallback(new SapiWebView.ShareAccountClickCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.7
                @Override // com.baidu.sapi2.SapiWebView.ShareAccountClickCallback
                public void onClick(String str, String str2, String str3, String str4, String str5) {
                    a aVar = new a();
                    LoginActivity loginActivity = LoginActivity.this;
                    aVar.a(loginActivity, str, str2, str3, str4, loginActivity.x, str5, c.l);
                }
            });
        }
        SapiJsCallBacks.JoinLoginParams joinLoginParams = new SapiJsCallBacks.JoinLoginParams();
        if (!TextUtils.isEmpty(this.v) && !TextUtils.isEmpty(this.t)) {
            if (webLoginDTO == null) {
                webLoginDTO = new WebLoginDTO();
            }
            webLoginDTO.encryptedId = this.v;
            webLoginDTO.preSetUname = this.t;
        }
        if (webLoginDTO != null) {
            if ((!TextUtils.isEmpty(webLoginDTO.encryptedId) || !TextUtils.isEmpty(webLoginDTO.uid)) && !TextUtils.isEmpty(webLoginDTO.preSetUname)) {
                SapiJsCallBacks.DirectedLoginParams directedLoginParams = new SapiJsCallBacks.DirectedLoginParams();
                directedLoginParams.uid = webLoginDTO.uid;
                directedLoginParams.encryptedId = webLoginDTO.encryptedId;
                directedLoginParams.displayname = webLoginDTO.preSetUname;
                this.x.add(SapiWebView.EXTRA_SUPPORT_DIRECT_LOGIN);
                this.sapiWebView.setDirectedLoginParams(directedLoginParams);
            }
            if (WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
                this.x.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
            }
            SapiWebView sapiWebView2 = this.sapiWebView;
            sapiWebView2.shareV2Disable = webLoginDTO.shareV2Disable;
            joinLoginParams.agreement = webLoginDTO.agreement;
            sapiWebView2.setHideSuccessTip(webLoginDTO.hideSuccessTip);
            WebLoginDTO.Config config = webLoginDTO.config;
            if (config != null) {
                this.sapiWebView.supportTouchGuide = config.supportTouchGuide;
            }
            this.x.add(new PassNameValuePair(SapiWebView.PARAMS_SCREEN_TYPE, String.valueOf(webLoginDTO.screenType)));
        }
        if (!TextUtils.isEmpty(this.w)) {
            try {
                JSONObject jSONObject = new JSONObject(this.w);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.x.add(new PassNameValuePair(next, jSONObject.getString(next)));
                }
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        if (WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.u)) {
            joinLoginParams.hasThirdAccount = true;
        } else {
            joinLoginParams.hasThirdAccount = false;
        }
        this.sapiWebView.setJoinLoingParams(joinLoginParams);
        setNewLoginTitleAndSetStyleChangeCallBack();
        if (!WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.u) && !WebLoginDTO.EXTRA_JOIN_LOGIN_WITHOUT_THIRD_ACCOUNT.equals(this.u)) {
            if (WebLoginDTO.EXTRA_LOGIN_WITH_SMS.equals(this.u)) {
                setTitleText(g.sapi_sdk_title_sms_login);
                this.sapiWebView.loadLogin(1, this.x);
                return;
            } else if (WebLoginDTO.EXTRA_LOGIN_WITH_NAME_PHONE_EMAIL.equals(this.u)) {
                this.sapiWebView.loadLogin(6, this.x);
                return;
            } else {
                if (!TextUtils.isEmpty(this.t)) {
                    this.x.add(new PassNameValuePair(SapiWebView.PARAMS_LOGIN_WITH_USER_NAME, this.t));
                }
                setTitleText(g.sapi_sdk_title_login);
                this.sapiWebView.loadLogin(this.x);
                return;
            }
        }
        this.sapiWebView.loadLogin(4, this.x);
    }

    private boolean b() {
        return this.s != 2003 && CoreViewRouter.getInstance().getWebBindWidgetDTO() == null && CoreViewRouter.getInstance().getAccountCenterDTO() == null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a() {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || confignation == null || !confignation.supportCheckFloatfLayer) {
            return;
        }
        sapiWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.sapi2.activity.LoginActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (LoginActivity.this.q) {
                    return false;
                }
                if (((motionEvent.getFlags() & 1) != 0 || (motionEvent.getFlags() & 2) != 0) && motionEvent.getAction() == 1) {
                    int height = LoginActivity.this.getWindowManager().getDefaultDisplay().getHeight();
                    Toast makeText = Toast.makeText(LoginActivity.this, "有悬浮窗遮挡，请注意信息安全！", 0);
                    makeText.setGravity(80, 0, (height / 2) - ((int) ((Resources.getSystem().getDisplayMetrics().density * 70.0f) + 0.5f)));
                    makeText.show();
                    LoginActivity.this.q = true;
                    StatService.onEvent(LoginActivity.B, new HashMap());
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType, boolean z2) {
        com.baidu.sapi2.utils.c cVar = new com.baidu.sapi2.utils.c();
        cVar.a(com.baidu.sapi2.utils.c.f11441a + SapiUtils.getLastLoginType());
        if (this.s == 2003) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            Intent intent = new Intent();
            intent.putExtra("bduss", currentAccount.bduss);
            setResult(-1, intent);
            if (this.r) {
                finish();
            }
        } else if (z2) {
            finish();
            if (b()) {
                CoreViewRouter.getInstance().release();
            }
        } else {
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                WebAuthResult webAuthResult = this.webAuthResult;
                webAuthResult.accountType = accountType;
                webAuthResult.setResultCode(0);
                webAuthListener.onSuccess(this.webAuthResult);
            }
            if (this.r) {
                finish();
                if (b()) {
                    CoreViewRouter.getInstance().release();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        finish();
        if (b() && z2) {
            CoreViewRouter.getInstance().release();
        }
    }

    private void a(Intent intent) {
        SapiJsCallBacks.CallBacks jsCallBacks;
        JsPromptResult promptResult;
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || (jsCallBacks = sapiWebView.getJsCallBacks()) == null || (promptResult = jsCallBacks.getPromptResult()) == null) {
            return;
        }
        if (intent == null) {
            promptResult.cancel();
            return;
        }
        try {
            promptResult.confirm(intent.getStringExtra("response"));
        } catch (Exception unused) {
            promptResult.cancel();
        }
    }
}
