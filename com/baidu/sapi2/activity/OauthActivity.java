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
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OauthActivity extends BaseActivity {
    public static final String E = "extra_calling_app_id";
    public static final String F = "extra_oauth_result_json";
    public static final String G = "extra_redirect_url";
    public static final String H = "extra_scope";
    public static final String I = "extra_oauth_type";
    public static final String J = "extra_qr_code_url";
    public static final String K = "extra_oauth_sdk_version";
    public static final String L = "extra_pass_sdk_version";
    public static final String M = "extra_oauth_state";
    public static final String N = "2.0.0";
    public static final int O = -201;
    public static final int P = -202;
    public static final int Q = -204;
    public static final int R = -205;
    public static final int S = -208;
    public Dialog A;
    public int B = 0;
    public String C;
    public boolean D;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

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
                ViewUtility.dismissDialog(oauthActivity, oauthActivity.A);
            }

            @Override // com.baidu.sapi2.callback.SsoHashCallback, com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                OauthActivity oauthActivity = OauthActivity.this;
                oauthActivity.A = new LoadingDialog.Builder(oauthActivity).setMessage("正在加载中...").setCancelable(false).setCancelOutside(false).createDialog();
                if (!OauthActivity.this.isFinishing() && !OauthActivity.this.A.isShowing()) {
                    OauthActivity.this.A.show();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(SsoHashResult ssoHashResult) {
                String str;
                HashMap hashMap = new HashMap();
                hashMap.put("client", "android");
                hashMap.put("clientfrom", "native");
                hashMap.put("suppcheck", "1");
                if (OauthActivity.this.B == 0) {
                    if (SapiUtils.versionCompareTo(OauthActivity.this.y, OauthActivity.N) >= 0) {
                        hashMap.put("response_type", "sso_auth_code");
                        hashMap.put("state", OauthActivity.this.x);
                    } else {
                        hashMap.put("response_type", "sso_token");
                    }
                    hashMap.put(CriusAttrConstants.DISPLAY, "mobile");
                    hashMap.put("scope", OauthActivity.this.w);
                    hashMap.put("sso_hash", ssoHashResult.ssoHash);
                    hashMap.put("client_id", OauthActivity.this.u);
                    hashMap.put("redirect_uri", OauthActivity.this.v);
                    str = (SapiAccountManager.getInstance().getConfignation().environment.getDeviceUrl() + "/oauth/2.0/authorize") + SapiUtils.mapToUrlParams(hashMap, false);
                } else {
                    hashMap.put("oauth_sso_hash", ssoHashResult.ssoHash);
                    hashMap.put("oauth_redirect_uri", OauthActivity.this.v);
                    if (SapiUtils.versionCompareTo(OauthActivity.this.y, OauthActivity.N) >= 0) {
                        hashMap.put("getauthorizationcode", "1");
                    } else {
                        hashMap.put("getaccesstoken", "1");
                    }
                    str = OauthActivity.this.C + SapiUtils.mapToUrlParams(hashMap, true);
                }
                SapiWebView sapiWebView = OauthActivity.this.sapiWebView;
                if (sapiWebView != null) {
                    sapiWebView.loadUrl(str);
                }
            }
        }, this.t, this.u);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        if (this.B == 1) {
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
            }, this.C, QrLoginAction.CANCEL.getName());
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent a(int i) {
        return a(i, "");
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
        intent.putExtra(F, jSONObject.toString());
        return intent;
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
        if (!wap.equals(parse.getScheme() + "://" + parse.getHost())) {
            return false;
        }
        return true;
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

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.t = getCallingPackage();
        Intent intent = getIntent();
        try {
            this.u = intent.getStringExtra(E);
            this.v = intent.getStringExtra(G);
            this.w = intent.getStringExtra(H);
            this.B = intent.getIntExtra(I, 0);
            this.C = intent.getStringExtra(J);
            this.x = intent.getStringExtra(M);
            this.y = intent.getStringExtra(K);
        } catch (Exception unused) {
            setResult(0, a(-202));
            finish();
        }
        if (TextUtils.isEmpty(this.t) || TextUtils.isEmpty(this.u) || TextUtils.isEmpty(this.v) || TextUtils.isEmpty(this.w)) {
            setResult(0, a(-202));
            finish();
            this.D = true;
        }
        if (!TextUtils.isEmpty(this.C) && !a(this.C)) {
            setResult(0, a(-202));
            finish();
            this.D = true;
        }
        String stringExtra = intent.getStringExtra(L);
        this.z = stringExtra;
        if (!TextUtils.isEmpty(stringExtra) && SapiUtils.versionCompareTo(this.z, "9.7.5") > 0) {
            setResult(0, a(-208));
            finish();
            this.D = true;
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            if (!b()) {
                return;
            }
            this.configuration = SapiAccountManager.getInstance().getConfignation();
            init();
            if (this.D) {
                return;
            }
            setupViews();
        } catch (Throwable unused) {
            setResult(0, a(-201));
            finish();
        }
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
                if (OauthActivity.this.B == 0) {
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
                            intent.putExtra(OauthActivity.F, jSONObject.toString());
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
                        }
                        if (optInt != 400021 && optInt != 400022) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, jSONObject2.optString("access_token"));
                            jSONObject3.put("openid", jSONObject2.optString("openid"));
                            jSONObject3.put("expiresIn", jSONObject2.optString("expires_in"));
                            jSONObject3.put("scope", OauthActivity.this.w);
                            jSONObject3.put("code", jSONObject2.optString("authorization_code"));
                            jSONObject2.put("state", jSONObject2.optString("state"));
                            intent.putExtra(OauthActivity.F, jSONObject3.toString());
                            OauthActivity.this.setResult(-1, intent);
                        }
                        OauthActivity.this.d();
                        return;
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
        bdOauthLoginParams.callingPkg = this.t;
        bdOauthLoginParams.callingAppId = this.u;
        bdOauthLoginParams.redirectUrl = this.v;
        bdOauthLoginParams.callback = bdOauthCallback;
        this.sapiWebView.setBdOauthLoginParams(bdOauthLoginParams);
        if (SapiAccountManager.getInstance().isLogin() && !TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            c();
        } else {
            d();
        }
    }
}
