package com.baidu.sapi2.activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
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
import com.sina.weibo.sdk.constant.WBConstants;
import d.b.y.a.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OauthActivity extends BaseActivity {
    public static final String A = "extra_calling_app_id";
    public static final String B = "extra_oauth_result_json";
    public static final String C = "extra_redirect_url";
    public static final String D = "extra_scope";
    public static final String E = "extra_oauth_type";
    public static final String F = "extra_qr_code_url";
    public static final String G = "extra_oauth_sdk_version";
    public static final String H = "extra_pass_sdk_version";
    public static final String I = "extra_oauth_state";
    public static final String J = "2.0.0";
    public static final int K = -201;
    public static final int L = -202;
    public static final int M = -204;
    public static final int N = -205;
    public static final int O = -208;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public Dialog w;
    public int x = 0;
    public String y;
    public boolean z;

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.p = getCallingPackage();
        Intent intent = getIntent();
        this.q = intent.getStringExtra(A);
        this.r = intent.getStringExtra(C);
        this.s = intent.getStringExtra(D);
        this.x = intent.getIntExtra(E, 0);
        this.y = intent.getStringExtra(F);
        this.t = intent.getStringExtra(I);
        this.u = intent.getStringExtra(G);
        if (TextUtils.isEmpty(this.p) || TextUtils.isEmpty(this.q) || TextUtils.isEmpty(this.r) || TextUtils.isEmpty(this.s)) {
            setResult(0, a(-202));
            finish();
            this.z = true;
        }
        if (!TextUtils.isEmpty(this.y) && !a(this.y)) {
            setResult(0, a(-202));
            finish();
            this.z = true;
        }
        String stringExtra = intent.getStringExtra(H);
        this.v = stringExtra;
        if (TextUtils.isEmpty(stringExtra) || SapiUtils.versionCompareTo(this.v, "9.2.9.8") <= 0) {
            return;
        }
        setResult(0, a(O));
        finish();
        this.z = true;
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            if (b()) {
                init();
                if (this.z) {
                    return;
                }
                setupViews();
            }
        } catch (Throwable unused) {
            setResult(0, a(-201));
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        if (this.x == 1) {
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
            }, this.y, QrLoginAction.CANCEL.getName());
        }
        a();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.OauthActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                OauthActivity.this.a();
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
                OauthActivity.this.c();
                SapiAccountManager.getGlobalCallback().onLoginStatusChange();
            }
        });
        SapiJsCallBacks.BdOauthCallback bdOauthCallback = new SapiJsCallBacks.BdOauthCallback() { // from class: com.baidu.sapi2.activity.OauthActivity.5
            @Override // com.baidu.sapi2.SapiJsCallBacks.BdOauthCallback
            public void onCallback(String str) {
                Intent intent = new Intent();
                if (OauthActivity.this.x == 0) {
                    Map<String, String> urlParamsToMap = SapiUtils.urlParamsToMap(str.substring(str.indexOf("#") + 1, str.length()));
                    if (urlParamsToMap.containsKey("error")) {
                        OauthActivity oauthActivity = OauthActivity.this;
                        oauthActivity.setResult(0, oauthActivity.a(-204, urlParamsToMap.get("error")));
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("refreshToken", urlParamsToMap.get("refresh_token"));
                            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, urlParamsToMap.get("access_token"));
                            jSONObject.put("expiresIn", urlParamsToMap.get("expires_in"));
                            jSONObject.put("scope", urlParamsToMap.get("scope"));
                            jSONObject.put("extra", urlParamsToMap.get("extra"));
                            jSONObject.put("code", urlParamsToMap.get("code"));
                            jSONObject.put("state", urlParamsToMap.get("state"));
                            intent.putExtra(OauthActivity.B, jSONObject.toString());
                            OauthActivity.this.setResult(-1, intent);
                        } catch (JSONException e2) {
                            Log.e(e2);
                            OauthActivity oauthActivity2 = OauthActivity.this;
                            oauthActivity2.setResult(0, oauthActivity2.a(-201));
                        }
                    }
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str);
                        int optInt = jSONObject2.optInt("errNo");
                        jSONObject2.optInt("msg");
                        if (optInt != -301) {
                            if (optInt != 400021 && optInt != 400022) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, jSONObject2.optString("access_token"));
                                jSONObject3.put("openid", jSONObject2.optString("openid"));
                                jSONObject3.put("expiresIn", jSONObject2.optString("expires_in"));
                                jSONObject3.put("scope", OauthActivity.this.s);
                                jSONObject3.put("code", jSONObject2.optString("authorization_code"));
                                jSONObject2.put("state", jSONObject2.optString("state"));
                                intent.putExtra(OauthActivity.B, jSONObject3.toString());
                                OauthActivity.this.setResult(-1, intent);
                            }
                            OauthActivity.this.d();
                            return;
                        }
                        OauthActivity.this.setResult(0, OauthActivity.this.a(-205));
                        OauthActivity.this.finish();
                        return;
                    } catch (JSONException e3) {
                        Log.e(e3);
                        OauthActivity oauthActivity3 = OauthActivity.this;
                        oauthActivity3.setResult(0, oauthActivity3.a(-201));
                    }
                }
                OauthActivity.this.finish();
            }
        };
        SapiJsCallBacks.BdOauthLoginParams bdOauthLoginParams = new SapiJsCallBacks.BdOauthLoginParams();
        bdOauthLoginParams.callingPkg = this.p;
        bdOauthLoginParams.callingAppId = this.q;
        bdOauthLoginParams.redirectUrl = this.r;
        bdOauthLoginParams.callback = bdOauthCallback;
        this.sapiWebView.setBdOauthLoginParams(bdOauthLoginParams);
        if (SapiAccountManager.getInstance().isLogin() && !TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            c();
        } else {
            d();
        }
    }

    private boolean b() {
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            SapiAccountManager.getGlobalCallback().onNeedInitPassSdk();
        }
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            Log.e("pass sdk have not been initialized", new Object[0]);
            setResult(0, a(-201));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        SapiAccountManager.getInstance().getAccountService().generateSsoHash(new SsoHashCallback() { // from class: com.baidu.sapi2.activity.OauthActivity.7
            @Override // com.baidu.sapi2.callback.SsoHashCallback, com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                OauthActivity oauthActivity = OauthActivity.this;
                ViewUtility.dismissDialog(oauthActivity, oauthActivity.w);
            }

            @Override // com.baidu.sapi2.callback.SsoHashCallback, com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                OauthActivity oauthActivity = OauthActivity.this;
                oauthActivity.w = new LoadingDialog.Builder(oauthActivity).setMessage("正在加载中...").setCancelable(false).setCancelOutside(false).createDialog();
                if (OauthActivity.this.isFinishing() || OauthActivity.this.w.isShowing()) {
                    return;
                }
                OauthActivity.this.w.show();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(SsoHashResult ssoHashResult) {
                String str;
                HashMap hashMap = new HashMap();
                hashMap.put("client", "android");
                hashMap.put("clientfrom", "native");
                hashMap.put("suppcheck", "1");
                if (OauthActivity.this.x == 0) {
                    if (SapiUtils.versionCompareTo(OauthActivity.this.u, OauthActivity.J) >= 0) {
                        hashMap.put(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, "sso_auth_code");
                        hashMap.put("state", OauthActivity.this.t);
                    } else {
                        hashMap.put(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, "sso_token");
                    }
                    hashMap.put("display", "mobile");
                    hashMap.put("scope", OauthActivity.this.s);
                    hashMap.put("sso_hash", ssoHashResult.ssoHash);
                    hashMap.put("client_id", OauthActivity.this.q);
                    hashMap.put(WBConstants.AUTH_PARAMS_REDIRECT_URL, OauthActivity.this.r);
                    str = (SapiAccountManager.getInstance().getConfignation().environment.getDeviceUrl() + "/oauth/2.0/authorize") + SapiUtils.mapToUrlParams(hashMap, false);
                } else {
                    hashMap.put("oauth_sso_hash", ssoHashResult.ssoHash);
                    hashMap.put("oauth_redirect_uri", OauthActivity.this.r);
                    if (SapiUtils.versionCompareTo(OauthActivity.this.u, OauthActivity.J) >= 0) {
                        hashMap.put("getauthorizationcode", "1");
                    } else {
                        hashMap.put("getaccesstoken", "1");
                    }
                    str = OauthActivity.this.y + SapiUtils.mapToUrlParams(hashMap, true);
                }
                OauthActivity.this.sapiWebView.loadUrl(str);
            }
        }, this.p, this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        final boolean z = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        WebLoginDTO.Config config = new WebLoginDTO.Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        CoreViewRouter.getInstance().startLogin(this, new WebAuthListener() { // from class: com.baidu.sapi2.activity.OauthActivity.6
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
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                OauthActivity.this.c();
                SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
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
        String[] strArr = {Uri.decode(parse.getQueryParameter("sign")), Uri.decode(parse.getQueryParameter("client_id")), Uri.decode(parse.getQueryParameter("cmd")), Uri.decode(parse.getQueryParameter("tpl"))};
        for (int i = 0; i < 4; i++) {
            if (TextUtils.isEmpty(strArr[i])) {
                return false;
            }
        }
        String wap = SapiAccountManager.getInstance().getConfignation().getEnvironment().getWap();
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getScheme());
        sb.append("://");
        sb.append(parse.getHost());
        return wap.equals(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        setResult(0, a(-205));
        finish();
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
        } catch (JSONException e2) {
            Log.e(e2);
        }
        intent.putExtra(B, jSONObject.toString());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent a(int i) {
        return a(i, "");
    }
}
