package com.baidu.sapi2.activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OauthActivity extends BaseActivity {
    private static final int BD_OAUTH_CODE_PARAMS_INVALID = -202;
    private static final int BD_OAUTH_CODE_RESPONSE_INVALID = -204;
    private static final int BD_OAUTH_CODE_UNKNOW_ERROR = -201;
    private static final int BD_OAUTH_CODE_USER_CANCEL = -205;
    private static final String EXTRA_CALLING_APP_ID = "extra_calling_app_id";
    private static final String EXTRA_OAUTH_RESULT_JSON = "extra_oauth_result_json";
    private static final String EXTRA_OAUTH_TYPE = "extra_oauth_type";
    private static final String EXTRA_QR_CODE_URL = "extra_qr_code_url";
    private static final String EXTRA_REDIRECT_URL = "extra_redirect_url";
    private static final String EXTRA_SCOPE = "extra_scope";
    private String callingAppId;
    private String callingPkg;
    private Dialog loadingDialog;
    private int oauthType = 0;
    private String qrCodeUrl;
    private String redirectUrl;
    private String scope;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            if (checkSapiInit()) {
                init();
                setupViews();
            }
        } catch (Throwable th) {
            setResult(0, buildFailureIntent(-201));
            finish();
        }
    }

    private boolean checkSapiInit() {
        if (SapiAccountManager.getInstance().getConfignation() == null && SapiAccountManager.getReceiveShareListener() != null) {
            SapiAccountManager.getReceiveShareListener().onReceiveShare();
        }
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            Log.e("pass sdk have not been initialized", new Object[0]);
            setResult(0, buildFailureIntent(-201));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.callingPkg = getCallingPackage();
        Intent intent = getIntent();
        this.callingAppId = intent.getStringExtra(EXTRA_CALLING_APP_ID);
        this.redirectUrl = intent.getStringExtra(EXTRA_REDIRECT_URL);
        this.scope = intent.getStringExtra(EXTRA_SCOPE);
        this.oauthType = intent.getIntExtra(EXTRA_OAUTH_TYPE, 0);
        this.qrCodeUrl = intent.getStringExtra(EXTRA_QR_CODE_URL);
        if (TextUtils.isEmpty(this.callingPkg) || TextUtils.isEmpty(this.callingAppId) || TextUtils.isEmpty(this.redirectUrl) || TextUtils.isEmpty(this.scope)) {
            setResult(0, buildFailureIntent(-202));
            finish();
        }
        if (!TextUtils.isEmpty(this.qrCodeUrl) && !isQrLoginSchema(this.qrCodeUrl)) {
            setResult(0, buildFailureIntent(-202));
            finish();
        }
    }

    private boolean isQrLoginSchema(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        parse.getHost();
        for (String str2 : new String[]{Uri.decode(parse.getQueryParameter("sign")), Uri.decode(parse.getQueryParameter("client_id")), Uri.decode(parse.getQueryParameter(IntentConfig.CMD)), Uri.decode(parse.getQueryParameter("tpl"))}) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
        }
        return SapiAccountManager.getInstance().getConfignation().getEnvironment().getWap().equals(new StringBuilder().append(parse.getScheme()).append("://").append(parse.getHost()).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void back() {
        if (this.sapiWebView != null && this.sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        setResult(0, buildFailureIntent(-205));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        if (this.oauthType == 1) {
            SapiAccountManager.getInstance().getAccountService().qrAppLogin(new SapiCallback<QrAppLoginResult>() { // from class: com.baidu.sapi2.activity.OauthActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(QrAppLoginResult qrAppLoginResult) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(QrAppLoginResult qrAppLoginResult) {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }
            }, this.qrCodeUrl, QrLoginAction.CANCEL.getName());
        }
        back();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.OauthActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                OauthActivity.this.back();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.OauthActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                OauthActivity.this.setResult(0, OauthActivity.this.buildFailureIntent(-205));
                OauthActivity.this.finish();
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.sapi2.activity.OauthActivity.4
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess() {
                super.onSuccess();
                OauthActivity.this.loadPage();
                LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
                if (loginStatusChangeCallback != null) {
                    loginStatusChangeCallback.onChange();
                }
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
            }
        });
        SapiJsCallBacks.BdOauthCallback bdOauthCallback = new SapiJsCallBacks.BdOauthCallback() { // from class: com.baidu.sapi2.activity.OauthActivity.5
            @Override // com.baidu.sapi2.SapiJsCallBacks.BdOauthCallback
            public void onCallback(String str) {
                Intent intent = new Intent();
                if (OauthActivity.this.oauthType == 0) {
                    Map<String, String> urlParamsToMap = SapiUtils.urlParamsToMap(str.substring(str.indexOf("#") + 1, str.length()));
                    if (urlParamsToMap.containsKey("error")) {
                        OauthActivity.this.setResult(0, OauthActivity.this.buildFailureIntent(-204, urlParamsToMap.get("error")));
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("refreshToken", urlParamsToMap.get(Oauth2AccessToken.KEY_REFRESH_TOKEN));
                            jSONObject.put("accessToken", urlParamsToMap.get("access_token"));
                            jSONObject.put("expiresIn", urlParamsToMap.get("expires_in"));
                            jSONObject.put("scope", urlParamsToMap.get("scope"));
                            jSONObject.put("extra", urlParamsToMap.get("extra"));
                            intent.putExtra(OauthActivity.EXTRA_OAUTH_RESULT_JSON, jSONObject.toString());
                            OauthActivity.this.setResult(-1, intent);
                        } catch (JSONException e) {
                            Log.e(e);
                            OauthActivity.this.setResult(0, OauthActivity.this.buildFailureIntent(-201));
                        }
                    }
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str);
                        int optInt = jSONObject2.optInt("errNo");
                        jSONObject2.optInt("msg");
                        if (optInt == 400021 || optInt == 400022) {
                            OauthActivity.this.login();
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("accessToken", jSONObject2.optString("access_token"));
                        jSONObject3.put("openid", jSONObject2.optString("openid"));
                        jSONObject3.put("expiresIn", jSONObject2.optString("expires_in"));
                        jSONObject3.put("scope", OauthActivity.this.scope);
                        intent.putExtra(OauthActivity.EXTRA_OAUTH_RESULT_JSON, jSONObject3.toString());
                        OauthActivity.this.setResult(-1, intent);
                    } catch (JSONException e2) {
                        Log.e(e2);
                        OauthActivity.this.setResult(0, OauthActivity.this.buildFailureIntent(-201));
                    }
                }
                OauthActivity.this.finish();
            }
        };
        SapiJsCallBacks.BdOauthLoginParams bdOauthLoginParams = new SapiJsCallBacks.BdOauthLoginParams();
        bdOauthLoginParams.callingPkg = this.callingPkg;
        bdOauthLoginParams.callingAppId = this.callingAppId;
        bdOauthLoginParams.redirectUrl = this.redirectUrl;
        bdOauthLoginParams.callback = bdOauthCallback;
        this.sapiWebView.setBdOauthLoginParams(bdOauthLoginParams);
        if (SapiAccountManager.getInstance().isLogin() && !TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            loadPage();
        } else {
            login();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        final boolean z = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        WebLoginDTO.Config config = new WebLoginDTO.Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        PassportSDK.getInstance().startLogin(this, new WebAuthListener() { // from class: com.baidu.sapi2.activity.OauthActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                OauthActivity.this.loadPage();
                LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
                if (loginStatusChangeCallback != null) {
                    loginStatusChangeCallback.onChange();
                }
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.sapi2.activity.OauthActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiUtils.hideSoftInput(OauthActivity.this);
                    }
                }, 300L);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                if (webAuthResult.getResultCode() == -301) {
                    OauthActivity.this.setResult(0, OauthActivity.this.buildFailureIntent(-205));
                    OauthActivity.this.finish();
                } else {
                    OauthActivity.this.setResult(0, OauthActivity.this.buildFailureIntent(-201));
                    OauthActivity.this.finish();
                }
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
            }
        }, webLoginDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPage() {
        SapiAccountManager.getInstance().getAccountService().generateSsoHash(new SsoHashCallback() { // from class: com.baidu.sapi2.activity.OauthActivity.7
            @Override // com.baidu.sapi2.callback.SsoHashCallback, com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                OauthActivity.this.loadingDialog = new LoadingDialog.Builder(OauthActivity.this).setMessage("正在加载中...").setCancelable(false).setCancelOutside(false).createDialog();
                if (!OauthActivity.this.isFinishing() && !OauthActivity.this.loadingDialog.isShowing()) {
                    OauthActivity.this.loadingDialog.show();
                }
            }

            @Override // com.baidu.sapi2.callback.SsoHashCallback, com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                ViewUtility.dismissDialog(OauthActivity.this, OauthActivity.this.loadingDialog);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(SsoHashResult ssoHashResult) {
                String str;
                HashMap hashMap = new HashMap();
                hashMap.put("client", "android");
                hashMap.put("clientfrom", "native");
                hashMap.put("suppcheck", "1");
                if (OauthActivity.this.oauthType == 0) {
                    hashMap.put(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, "sso_token");
                    hashMap.put("display", "mobile");
                    hashMap.put("scope", OauthActivity.this.scope);
                    hashMap.put("sso_hash", ssoHashResult.ssoHash);
                    hashMap.put("client_id", OauthActivity.this.callingAppId);
                    hashMap.put(WBConstants.AUTH_PARAMS_REDIRECT_URL, OauthActivity.this.redirectUrl);
                    str = SapiAccountManager.getInstance().getConfignation().environment.getDeviceUrl() + "/oauth/2.0/authorize";
                } else {
                    hashMap.put("oauth_sso_hash", ssoHashResult.ssoHash);
                    hashMap.put("oauth_redirect_uri", OauthActivity.this.redirectUrl);
                    hashMap.put("getaccesstoken", "1");
                    str = OauthActivity.this.qrCodeUrl;
                }
                OauthActivity.this.sapiWebView.loadUrl(str + SapiUtils.mapToUrlParams(hashMap));
            }
        }, this.callingPkg, this.callingAppId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent buildFailureIntent(int i, String str) {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("msg", str);
            }
        } catch (JSONException e) {
            Log.e(e);
        }
        intent.putExtra(EXTRA_OAUTH_RESULT_JSON, jSONObject.toString());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent buildFailureIntent(int i) {
        return buildFailureIntent(i, "");
    }
}
