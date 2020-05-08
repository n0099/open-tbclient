package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.f.a.a.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.LoadingDialog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import sdk.meizu.auth.MzAuthenticator;
import sdk.meizu.auth.OAuthError;
import sdk.meizu.auth.OAuthToken;
import sdk.meizu.auth.callback.ImplictCallback;
/* loaded from: classes6.dex */
public class MeizuSSOLoginActivity extends BaseSSOLoginActivity {
    private static final String TAG = "MeizuSSOLoginActivity";

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMeizuSSOLoginInNA(String str, String str2) {
        if (this.sapiWebView == null) {
            if (PassportSDK.getInstance().getWebAuthListener() != null) {
                this.webAuthResult.setResultCode(-202);
                this.webAuthResult.setResultMsg("网络连接失败，请检查网络设置");
                PassportSDK.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
            }
            PassportSDK.getInstance().release();
            finish();
            return;
        }
        HttpClientWrap httpClientWrap = new HttpClientWrap();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getStatParamList());
        PassNameValuePair sceneFromParam = getSceneFromParam();
        if (sceneFromParam != null) {
            arrayList.add(sceneFromParam);
        }
        arrayList.add(new PassNameValuePair("json", "1"));
        httpClientWrap.get(this.sapiWebView.getMeizuSSOLoginUrl(arrayList, str, str2), ((ThirdPartyService) PassportSDK.getInstance().getThirdPartyService()).getCookies(this, this.configuration), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.activity.social.MeizuSSOLoginActivity.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                Log.d(MeizuSSOLoginActivity.TAG, "onFailure error = " + th + " errorCode = " + i + " responseBody = " + str3);
                AuthorizationListener authorizationListener = MeizuSSOLoginActivity.this.authorizationListener;
                if (authorizationListener != null) {
                    authorizationListener.onFailed(-100, "登录失败");
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str3, HashMap<String, String> hashMap) {
                Log.d(MeizuSSOLoginActivity.TAG, "onSuccess statusCode = " + i + " responseBody = " + str3);
                if (str3 == null) {
                    AuthorizationListener authorizationListener = MeizuSSOLoginActivity.this.authorizationListener;
                    if (authorizationListener != null) {
                        authorizationListener.onFailed(-100, "登录失败");
                        return;
                    }
                    return;
                }
                try {
                    MeizuSSOLoginActivity.this.handleOpenApiAuthorizeResponse(SocialResponse.fromJSONObject(new JSONObject(str3)), hashMap);
                } catch (Throwable th) {
                    Log.e(th);
                    AuthorizationListener authorizationListener2 = MeizuSSOLoginActivity.this.authorizationListener;
                    if (authorizationListener2 != null) {
                        authorizationListener2.onFailed(-100, "登录失败");
                    }
                }
            }
        });
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.c.sapi_sdk_title_login_mz);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        this.loadingDialog = new LoadingDialog.Builder(this).setMessage("授权魅族账号登录中").setCancelable(false).setCancelOutside(false).createDialog();
        if (!this.loadingDialog.isShowing()) {
            this.loadingDialog.show();
        }
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        new MzAuthenticator(confignation.mzAppID, confignation.meizuRedirectUri).requestImplictAuth(this, "uc_basic_info", new ImplictCallback() { // from class: com.baidu.sapi2.activity.social.MeizuSSOLoginActivity.1
            public void onError(OAuthError oAuthError) {
                MeizuSSOLoginActivity meizuSSOLoginActivity = MeizuSSOLoginActivity.this;
                meizuSSOLoginActivity.handleBack(meizuSSOLoginActivity.businessFrom);
            }

            public void onGetToken(OAuthToken oAuthToken) {
                String accessToken = oAuthToken.getAccessToken();
                String openId = oAuthToken.getOpenId();
                if (!TextUtils.isEmpty(accessToken) && !TextUtils.isEmpty(openId)) {
                    MeizuSSOLoginActivity.this.loadMeizuSSOLoginInNA(accessToken, openId);
                    return;
                }
                MeizuSSOLoginActivity meizuSSOLoginActivity = MeizuSSOLoginActivity.this;
                meizuSSOLoginActivity.handleBack(meizuSSOLoginActivity.businessFrom);
            }
        });
    }
}
