package com.baidu.sapi2.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
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
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareLoginModel;
import com.baidu.sapi2.share.ShareResultCallback;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.social.WXInvokeCallback;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.utils.CommonUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LoginActivity extends BaseActivity {
    public static final String E = "LoginActivity";
    public static final String EXTRA_LOGIN_FINISH_AFTER_SUC = "extra_login_finish_after_suc";
    public static final String EXTRA_LOGIN_TYPE = "extra_login_type";
    public static final String EXTRA_PARAM_ENCRYPTED_UID = "encryptedUid";
    public static final String EXTRA_PARAM_EXTRAS_JSON = "extraJson";
    public static final String EXTRA_PARAM_PAGE_LOGIN = "page_login";
    public static final String EXTRA_PARAM_THIRD_VERIFY_RESPONSE = "response";
    public static final String EXTRA_PARAM_USERNAME = "username";
    public static final int F = 2005;
    public static final int FIX_FLAG_WINDOW_IS_PARTIALLY_OBSCURED = 2;
    public static final String G = "floating_window_tag";
    public static final String H = "login_page_tag";
    public static final int REQUEST_SHARE_V2_LOGIN = 2020;
    public static final int REQUEST_SOCIAL_LOGIN = 2001;
    public static boolean supportShareLogin = true;
    public String A;
    public String B;
    public List<PassNameValuePair> C;
    public SapiWebView sapiWebView;
    public boolean u;
    public boolean v;
    public int w;
    public String x;
    public String y;
    public String z;
    public boolean t = false;
    public WebAuthResult webAuthResult = new WebAuthResult() { // from class: com.baidu.sapi2.activity.LoginActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity(boolean z) {
            super.finishActivity();
            LoginActivity.this.a(false);
        }

        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            super.finishActivity();
            LoginActivity.this.a(true);
        }
    };
    public boolean mNeedSetContentView = true;
    public AuthorizationListener D = new AuthorizationListener() { // from class: com.baidu.sapi2.activity.LoginActivity.2
        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            super.beforeSuccess(sapiAccount);
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                webAuthListener.beforeSuccess(sapiAccount);
            }
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            LoginActivity.this.a(accountType, false);
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            if (LoginActivity.this.w == 2003) {
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
    };

    @SuppressLint({"ClickableViewAccessibility"})
    private void a() {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && confignation != null && confignation.supportCheckFloatfLayer) {
            sapiWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.sapi2.activity.LoginActivity.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (LoginActivity.this.u) {
                        return false;
                    }
                    if (((motionEvent.getFlags() & 1) != 0 || (motionEvent.getFlags() & 2) != 0) && motionEvent.getAction() == 1) {
                        int height = LoginActivity.this.getWindowManager().getDefaultDisplay().getHeight();
                        Toast makeText = Toast.makeText(LoginActivity.this, "有悬浮窗遮挡，请注意信息安全！", 0);
                        makeText.setGravity(80, 0, (height / 2) - ((int) ((Resources.getSystem().getDisplayMetrics().density * 70.0f) + 0.5f)));
                        makeText.show();
                        LoginActivity.this.u = true;
                        StatService.onEvent(LoginActivity.G, new HashMap());
                    }
                    return false;
                }
            });
        }
    }

    private boolean b() {
        if (this.w == 2003 || CoreViewRouter.getInstance().getWebBindWidgetDTO() != null || CoreViewRouter.getInstance().getAccountCenterDTO() != null) {
            return false;
        }
        return true;
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

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getWebLoginDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.webAuthResult.activity = this;
        this.v = getIntent().getBooleanExtra(EXTRA_LOGIN_FINISH_AFTER_SUC, true);
    }

    public void lockScreenOrientation() {
        int i = Build.VERSION.SDK_INT;
        if (i < 28 && i > 25) {
            return;
        }
        setRequestedOrientation(1);
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

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.sapiWebView != null) {
            this.sapiWebView = null;
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        this.sapiWebView.back();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    public void loginFail(WebAuthResult webAuthResult) {
        if (this.w == 2003) {
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

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null) {
            return;
        }
        sapiWebView.mExcludeTypes = LoginTypes.SHARE;
        setTitleText(R.string.sapi_sdk_title_sms_login);
        this.sapiWebView.loadLogin(1, this.C);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType, boolean z) {
        PtokenStat ptokenStat = new PtokenStat();
        ptokenStat.onEvent(PtokenStat.LOGIN + SapiUtils.getLastLoginType());
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
            if (this.v) {
                finish();
                if (b()) {
                    CoreViewRouter.getInstance().release();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        finish();
        if (b() && z) {
            CoreViewRouter.getInstance().release();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        int intExtra;
        super.onActivityResult(i, i2, intent);
        new ShareCallPacking().onLoginActivityActivityResult(new ShareCallPacking.ShareLoginCallBack() { // from class: com.baidu.sapi2.activity.LoginActivity.10
            @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
            public void onSuccess() {
                LoginActivity.this.a(AccountType.NORMAL, false);
            }
        }, i, i2, intent, this.C, "pass");
        if ((i == 2001 && i2 == 1001) || this.t) {
            a((AccountType) null, true);
            this.t = false;
        } else if (i == 2005) {
            if (i2 == -1) {
                String str2 = "";
                if (intent == null) {
                    str = "";
                } else {
                    str2 = intent.getStringExtra("business_type");
                    str = intent.getStringExtra("username");
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
        } else if (i == 100004) {
            ShareLoginModel.getInstance().processShareResult(this, intent, new ShareResultCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.11
                @Override // com.baidu.sapi2.share.ShareResultCallback
                public void onResultAccount(SapiAccount sapiAccount) {
                    WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
                    if (sapiAccount == null) {
                        Toast.makeText(LoginActivity.this, "授权失败，请选择其他方式登录", 0).show();
                        WebLoginDTO webLoginDTO = new WebLoginDTO();
                        webLoginDTO.excludeTypes = LoginTypes.SHARE;
                        CoreViewRouter.getInstance().startLogin(webAuthListener, webLoginDTO);
                        return;
                    }
                    if (webAuthListener != null) {
                        WebAuthResult webAuthResult = new WebAuthResult();
                        webAuthResult.accountType = AccountType.NORMAL;
                        webAuthResult.setResultCode(0);
                        webAuthListener.onSuccess(webAuthResult);
                    }
                    LoginActivity.this.finish();
                    CoreViewRouter.getInstance().release();
                }
            });
        }
        if (i == 2001 && i2 == 4001) {
            a(intent);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        SapiWebView sapiWebView;
        super.onCreate(bundle);
        lockScreenOrientation();
        try {
            if (this.mNeedSetContentView) {
                setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            }
            init();
            setupViews();
            a();
            StatService.onEvent(H, new HashMap());
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation == null || !confignation.isAgreeDangerousProtocol()) {
                CommonUtil.showErrorNotice("需要同意隐私协议并同步pass");
            }
            if (getWebDTO() != null && (sapiWebView = this.sapiWebView) != null) {
                sapiWebView.mExcludeTypes = getWebDTO().excludeTypes;
            }
        } catch (Throwable th) {
            reportWebviewError(th);
            this.webAuthResult.setResultCode(-202);
            this.webAuthResult.setResultMsg("网络连接失败，请检查网络设置");
            loginFail(this.webAuthResult);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        List<PassNameValuePair> arrayList;
        String str;
        super.setupViews();
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        if (webLoginDTO != null) {
            arrayList = webLoginDTO.extraParams;
        } else {
            arrayList = new ArrayList<>();
        }
        this.C = arrayList;
        this.w = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.x = getIntent().getStringExtra("username");
        if (webLoginDTO != null) {
            str = webLoginDTO.preLoginName;
        } else {
            str = "";
        }
        this.y = str;
        this.z = getIntent().getStringExtra(EXTRA_LOGIN_TYPE);
        this.A = getIntent().getStringExtra(EXTRA_PARAM_ENCRYPTED_UID);
        this.B = getIntent().getStringExtra("extraJson");
        SapiWebView sapiWebView = (SapiWebView) findViewById(R.id.obfuscated_res_0x7f091fcc);
        this.sapiWebView = sapiWebView;
        sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.4
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                LoginActivity.this.onClose();
            }
        });
        this.sapiWebView.setAuthorizationListener(this.D);
        this.sapiWebView.setSocialLoginHandler(new Handler() { // from class: com.baidu.sapi2.activity.LoginActivity.5
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                AbstractThirdPartyService thirdPartyService = CoreViewRouter.getInstance().getThirdPartyService();
                if (thirdPartyService != null) {
                    LoginActivity loginActivity = LoginActivity.this;
                    thirdPartyService.loadThirdPartyLogin(loginActivity, (SocialType) message.obj, loginActivity.w, LoginActivity.this.B);
                    SocialLoginBase.setWXLoginCallback(new WXInvokeCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.5.1
                        @Override // com.baidu.sapi2.social.WXInvokeCallback
                        public void onResult(int i, Intent intent) {
                            if (i != 1001) {
                                return;
                            }
                            LoginActivity.this.t = true;
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
                intent.putExtra("page_from", LoginActivity.EXTRA_PARAM_PAGE_LOGIN);
                LoginActivity.this.startActivityForResult(intent, 2005);
            }
        });
        this.sapiWebView.loadHistoryLogin(new SapiWebView.HistoryLoginCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.7
            @Override // com.baidu.sapi2.SapiWebView.HistoryLoginCallback
            public void onSuccess() {
                if (LoginActivity.this.v) {
                    LoginActivity.this.finish();
                }
            }
        });
        if (supportShareLogin) {
            this.sapiWebView.setShareAccountClickCallback(new SapiWebView.ShareAccountClickCallback() { // from class: com.baidu.sapi2.activity.LoginActivity.8
                @Override // com.baidu.sapi2.SapiWebView.ShareAccountClickCallback
                public void onClick(String str2, String str3, String str4, String str5, String str6) {
                    ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_FROM_PKG, str2);
                    if (ShareLoginModel.getInstance().isMeetShareV4(LoginActivity.this, str2)) {
                        Log.d(LoginActivity.E, "openShareLogin: is meet share_v4");
                        ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_NEED_AUTH, "0");
                        ShareLoginModel.getInstance().openV4ShareLogin(LoginActivity.this, str2, "pass");
                        return;
                    }
                    Log.d(LoginActivity.E, "openShareLogin: is not share_v4");
                    ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_NEED_AUTH, "1");
                    ShareCallPacking shareCallPacking = new ShareCallPacking();
                    LoginActivity loginActivity = LoginActivity.this;
                    shareCallPacking.startLoginShareActivityForResult(loginActivity, str2, str3, str4, str5, loginActivity.C, str6, "pass");
                }
            });
        }
        this.sapiWebView.setIsForbidRecord(new SapiJsCallBacks.IsForbidRecordCallBack() { // from class: com.baidu.sapi2.activity.LoginActivity.9
            @Override // com.baidu.sapi2.SapiJsCallBacks.IsForbidRecordCallBack
            public void onForbidRecord(Boolean bool) {
                if (bool.booleanValue()) {
                    LoginActivity.this.getWindow().addFlags(8192);
                } else {
                    LoginActivity.this.getWindow().clearFlags(8192);
                }
            }
        });
        SapiJsCallBacks.JoinLoginParams joinLoginParams = new SapiJsCallBacks.JoinLoginParams();
        if (!TextUtils.isEmpty(this.A) && !TextUtils.isEmpty(this.x)) {
            if (webLoginDTO == null) {
                webLoginDTO = new WebLoginDTO();
            }
            webLoginDTO.encryptedId = this.A;
            webLoginDTO.preSetUname = this.x;
        }
        if (webLoginDTO != null) {
            if (!TextUtils.isEmpty(webLoginDTO.encryptedId) || !TextUtils.isEmpty(webLoginDTO.uid) || !TextUtils.isEmpty(webLoginDTO.preSetUname)) {
                SapiJsCallBacks.DirectedLoginParams directedLoginParams = new SapiJsCallBacks.DirectedLoginParams();
                directedLoginParams.uid = webLoginDTO.uid;
                directedLoginParams.encryptedId = webLoginDTO.encryptedId;
                directedLoginParams.displayname = webLoginDTO.preSetUname;
                this.C.add(SapiWebView.EXTRA_SUPPORT_DIRECT_LOGIN);
                this.sapiWebView.setDirectedLoginParams(directedLoginParams);
            }
            if (WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
                this.C.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
            }
            SapiWebView sapiWebView2 = this.sapiWebView;
            sapiWebView2.shareV2Disable = webLoginDTO.shareV2Disable;
            joinLoginParams.agreement = webLoginDTO.agreement;
            sapiWebView2.setHideSuccessTip(webLoginDTO.hideSuccessTip);
            WebLoginDTO.Config config = webLoginDTO.config;
            if (config != null) {
                this.sapiWebView.supportTouchGuide = config.supportTouchGuide;
            }
            this.C.add(new PassNameValuePair(SapiWebView.PARAMS_SCREEN_TYPE, String.valueOf(webLoginDTO.screenType)));
            this.C.add(new PassNameValuePair(SapiWebView.PARAMS_IS_ACCEPT_BROWSEMODE_AGREEMENT, String.valueOf(webLoginDTO.isAcceptBrowseModeAgreement)));
        }
        if (!TextUtils.isEmpty(this.B)) {
            try {
                JSONObject jSONObject = new JSONObject(this.B);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.C.add(new PassNameValuePair(next, jSONObject.getString(next)));
                }
            } catch (JSONException e) {
                Log.e(e);
            }
        }
        if (WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.z)) {
            joinLoginParams.hasThirdAccount = true;
        } else {
            joinLoginParams.hasThirdAccount = false;
        }
        this.sapiWebView.setJoinLoingParams(joinLoginParams);
        setNewLoginTitleAndSetStyleChangeCallBack();
        if (!WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.z) && !WebLoginDTO.EXTRA_JOIN_LOGIN_WITHOUT_THIRD_ACCOUNT.equals(this.z)) {
            if (WebLoginDTO.EXTRA_LOGIN_WITH_SMS.equals(this.z)) {
                setTitleText(R.string.sapi_sdk_title_sms_login);
                this.sapiWebView.loadLogin(1, this.C);
                return;
            } else if (WebLoginDTO.EXTRA_LOGIN_WITH_NAME_PHONE_EMAIL.equals(this.z)) {
                this.sapiWebView.loadLogin(6, this.C);
                return;
            } else if (WebLoginDTO.EXTRA_LOGIN_WITH_PRE_LOGIN_NAME.equals(this.z)) {
                if (!TextUtils.isEmpty(this.y)) {
                    this.C.add(new PassNameValuePair(SapiWebView.PARAMS_LOGIN_WITH_PRE_LOGIN_NAME, this.y));
                }
                this.sapiWebView.loadLogin(7, this.C);
                return;
            } else {
                if (!TextUtils.isEmpty(this.x)) {
                    this.C.add(new PassNameValuePair("loginUserName", this.x));
                }
                setTitleText(R.string.sapi_sdk_title_login);
                this.sapiWebView.loadLogin(this.C);
                return;
            }
        }
        this.sapiWebView.loadLogin(4, this.C);
    }
}
