package com.baidu.sapi2.activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.i.a.a;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.log.LogConfig;
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
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class OauthActivity extends BaseActivity {
    private static final String A = "2.0.0";
    private static final int B = -201;
    private static final int C = -202;
    private static final int D = -204;
    private static final int E = -205;
    private static final int F = -208;
    private static final String r = "extra_calling_app_id";
    private static final String s = "extra_oauth_result_json";
    private static final String t = "extra_redirect_url";
    private static final String u = "extra_scope";
    private static final String v = "extra_oauth_type";
    private static final String w = "extra_qr_code_url";
    private static final String x = "extra_oauth_sdk_version";
    private static final String y = "extra_pass_sdk_version";
    private static final String z = "extra_oauth_state";
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private Dialog N;
    private int O = 0;
    private String P;
    private boolean Q;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.G = getCallingPackage();
        Intent intent = getIntent();
        this.H = intent.getStringExtra(r);
        this.I = intent.getStringExtra(t);
        this.J = intent.getStringExtra(u);
        this.O = intent.getIntExtra(v, 0);
        this.P = intent.getStringExtra(w);
        this.K = intent.getStringExtra(z);
        this.L = intent.getStringExtra(x);
        if (TextUtils.isEmpty(this.G) || TextUtils.isEmpty(this.H) || TextUtils.isEmpty(this.I) || TextUtils.isEmpty(this.J)) {
            setResult(0, a(-202));
            finish();
            this.Q = true;
        }
        if (!TextUtils.isEmpty(this.P) && !a(this.P)) {
            setResult(0, a(-202));
            finish();
            this.Q = true;
        }
        this.M = intent.getStringExtra(y);
        if (TextUtils.isEmpty(this.M) || SapiUtils.versionCompareTo(this.M, SapiAccountManager.VERSION_NAME) <= 0) {
            return;
        }
        setResult(0, a(F));
        finish();
        this.Q = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            if (f()) {
                init();
                if (!this.Q) {
                    setupViews();
                }
            }
        } catch (Throwable th) {
            setResult(0, a(-201));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        if (this.O == 1) {
            SapiAccountManager.getInstance().getAccountService().qrAppLogin(new SapiCallback<QrAppLoginResult>() { // from class: com.baidu.sapi2.activity.OauthActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(QrAppLoginResult qrAppLoginResult) {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(QrAppLoginResult qrAppLoginResult) {
                }
            }, this.P, QrLoginAction.CANCEL.getName());
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.OauthActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                OauthActivity.this.e();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.OauthActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                OauthActivity oauthActivity = OauthActivity.this;
                oauthActivity.setResult(0, oauthActivity.a(-205));
                OauthActivity.this.finish();
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.sapi2.activity.OauthActivity.4
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess() {
                OauthActivity.this.g();
                LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
                if (loginStatusChangeCallback != null) {
                    loginStatusChangeCallback.onChange();
                }
            }
        });
        SapiJsCallBacks.BdOauthCallback bdOauthCallback = new SapiJsCallBacks.BdOauthCallback() { // from class: com.baidu.sapi2.activity.OauthActivity.5
            @Override // com.baidu.sapi2.SapiJsCallBacks.BdOauthCallback
            public void onCallback(String str) {
                Intent intent = new Intent();
                if (OauthActivity.this.O == 0) {
                    Map<String, String> urlParamsToMap = SapiUtils.urlParamsToMap(str.substring(str.indexOf("#") + 1, str.length()));
                    if (urlParamsToMap.containsKey(BdStatsConstant.StatsType.ERROR)) {
                        OauthActivity oauthActivity = OauthActivity.this;
                        oauthActivity.setResult(0, oauthActivity.a(-204, urlParamsToMap.get(BdStatsConstant.StatsType.ERROR)));
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("refreshToken", urlParamsToMap.get(Oauth2AccessToken.KEY_REFRESH_TOKEN));
                            jSONObject.put("accessToken", urlParamsToMap.get("access_token"));
                            jSONObject.put("expiresIn", urlParamsToMap.get("expires_in"));
                            jSONObject.put("scope", urlParamsToMap.get("scope"));
                            jSONObject.put("extra", urlParamsToMap.get("extra"));
                            jSONObject.put("code", urlParamsToMap.get("code"));
                            jSONObject.put("state", urlParamsToMap.get("state"));
                            intent.putExtra(OauthActivity.s, jSONObject.toString());
                            OauthActivity.this.setResult(-1, intent);
                        } catch (JSONException e) {
                            Log.e(e);
                            OauthActivity oauthActivity2 = OauthActivity.this;
                            oauthActivity2.setResult(0, oauthActivity2.a(-201));
                        }
                    }
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str);
                        int optInt = jSONObject2.optInt("errNo");
                        jSONObject2.optInt("msg");
                        if (optInt == -301) {
                            OauthActivity.this.setResult(0, OauthActivity.this.a(-205));
                            OauthActivity.this.finish();
                            return;
                        } else if (optInt == 400021 || optInt == 400022) {
                            OauthActivity.this.h();
                            return;
                        } else {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("accessToken", jSONObject2.optString("access_token"));
                            jSONObject3.put("openid", jSONObject2.optString("openid"));
                            jSONObject3.put("expiresIn", jSONObject2.optString("expires_in"));
                            jSONObject3.put("scope", OauthActivity.this.J);
                            jSONObject3.put("code", jSONObject2.optString("authorization_code"));
                            jSONObject2.put("state", jSONObject2.optString("state"));
                            intent.putExtra(OauthActivity.s, jSONObject3.toString());
                            OauthActivity.this.setResult(-1, intent);
                        }
                    } catch (JSONException e2) {
                        Log.e(e2);
                        OauthActivity oauthActivity3 = OauthActivity.this;
                        oauthActivity3.setResult(0, oauthActivity3.a(-201));
                    }
                }
                OauthActivity.this.finish();
            }
        };
        SapiJsCallBacks.BdOauthLoginParams bdOauthLoginParams = new SapiJsCallBacks.BdOauthLoginParams();
        bdOauthLoginParams.callingPkg = this.G;
        bdOauthLoginParams.callingAppId = this.H;
        bdOauthLoginParams.redirectUrl = this.I;
        bdOauthLoginParams.callback = bdOauthCallback;
        this.sapiWebView.setBdOauthLoginParams(bdOauthLoginParams);
        if (SapiAccountManager.getInstance().isLogin() && !TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            g();
        } else {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        setResult(0, a(-205));
        finish();
    }

    private boolean f() {
        if (SapiAccountManager.getInstance().getConfignation() == null && SapiAccountManager.getReceiveShareListener() != null) {
            SapiAccountManager.getReceiveShareListener().onReceiveShare();
        }
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            Log.e("pass sdk have not been initialized", new Object[0]);
            setResult(0, a(-201));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SapiAccountManager.getInstance().getAccountService().generateSsoHash(new SsoHashCallback() { // from class: com.baidu.sapi2.activity.OauthActivity.7
            @Override // com.baidu.sapi2.callback.SsoHashCallback, com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                OauthActivity oauthActivity = OauthActivity.this;
                ViewUtility.dismissDialog(oauthActivity, oauthActivity.N);
            }

            @Override // com.baidu.sapi2.callback.SsoHashCallback, com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                OauthActivity oauthActivity = OauthActivity.this;
                oauthActivity.N = new LoadingDialog.Builder(oauthActivity).setMessage("正在加载中...").setCancelable(false).setCancelOutside(false).createDialog();
                if (OauthActivity.this.isFinishing() || OauthActivity.this.N.isShowing()) {
                    return;
                }
                OauthActivity.this.N.show();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(SsoHashResult ssoHashResult) {
                String str;
                HashMap hashMap = new HashMap();
                hashMap.put("client", PraiseDataPassUtil.KEY_FROM_OS);
                hashMap.put("clientfrom", "native");
                hashMap.put("suppcheck", "1");
                if (OauthActivity.this.O == 0) {
                    if (SapiUtils.versionCompareTo(OauthActivity.this.L, OauthActivity.A) >= 0) {
                        hashMap.put(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, "sso_auth_code");
                        hashMap.put("state", OauthActivity.this.K);
                    } else {
                        hashMap.put(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, "sso_token");
                    }
                    hashMap.put(LogConfig.KEY_DISPLAY, "mobile");
                    hashMap.put("scope", OauthActivity.this.J);
                    hashMap.put("sso_hash", ssoHashResult.ssoHash);
                    hashMap.put("client_id", OauthActivity.this.H);
                    hashMap.put(WBConstants.AUTH_PARAMS_REDIRECT_URL, OauthActivity.this.I);
                    str = (SapiAccountManager.getInstance().getConfignation().environment.getDeviceUrl() + "/oauth/2.0/authorize") + SapiUtils.mapToUrlParams(hashMap, false);
                } else {
                    hashMap.put("oauth_sso_hash", ssoHashResult.ssoHash);
                    hashMap.put("oauth_redirect_uri", OauthActivity.this.I);
                    if (SapiUtils.versionCompareTo(OauthActivity.this.L, OauthActivity.A) >= 0) {
                        hashMap.put("getauthorizationcode", "1");
                    } else {
                        hashMap.put("getaccesstoken", "1");
                    }
                    str = OauthActivity.this.P + SapiUtils.mapToUrlParams(hashMap, true);
                }
                OauthActivity.this.sapiWebView.loadUrl(str);
            }
        }, this.G, this.H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        final boolean z2 = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
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
            public void onFailure(WebAuthResult webAuthResult) {
                if (webAuthResult.getResultCode() == -301) {
                    OauthActivity oauthActivity = OauthActivity.this;
                    oauthActivity.setResult(0, oauthActivity.a(-205));
                    OauthActivity.this.finish();
                } else {
                    OauthActivity oauthActivity2 = OauthActivity.this;
                    oauthActivity2.setResult(0, oauthActivity2.a(-201));
                    OauthActivity.this.finish();
                }
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                OauthActivity.this.g();
                LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
                if (loginStatusChangeCallback != null) {
                    loginStatusChangeCallback.onChange();
                }
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.sapi2.activity.OauthActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiUtils.hideSoftInput(OauthActivity.this);
                    }
                }, 300L);
            }
        }, webLoginDTO);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        parse.getHost();
        for (String str2 : new String[]{Uri.decode(parse.getQueryParameter("sign")), Uri.decode(parse.getQueryParameter("client_id")), Uri.decode(parse.getQueryParameter("cmd")), Uri.decode(parse.getQueryParameter("tpl"))}) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
        }
        return SapiAccountManager.getInstance().getConfignation().getEnvironment().getWap().equals(new StringBuilder().append(parse.getScheme()).append("://").append(parse.getHost()).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent a(int i, String str) {
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
        intent.putExtra(s, jSONObject.toString());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent a(int i) {
        return a(i, "");
    }
}
