package com.baidu.sapi2.activity.social;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.widget.RelativeLayout;
import com.baidu.f.a.a.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.LoadingDialog;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class FacebookSSOLoginActivity extends BaseSSOLoginActivity {
    private static final String TAG = "FacebookSSOLoginActivity";
    private CallbackManager callbackManager;
    private LoginManager loginManager;

    private void initFacebook() {
        this.callbackManager = CallbackManager.Factory.create();
        this.loginManager = LoginManager.getInstance();
        this.loginManager.setDefaultAudience(DefaultAudience.FRIENDS);
        this.loginManager.setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK);
        this.loginManager.setAuthType("rerequest");
        this.loginManager.logInWithReadPermissions(this, Arrays.asList(NotificationCompat.CATEGORY_EMAIL, "public_profile"));
        LoginManager.getInstance().registerCallback(this.callbackManager, new FacebookCallback<LoginResult>() { // from class: com.baidu.sapi2.activity.social.FacebookSSOLoginActivity.1
            public void onCancel() {
                Log.d(FacebookSSOLoginActivity.TAG, "facebook LoginManager login cancel");
                FacebookSSOLoginActivity facebookSSOLoginActivity = FacebookSSOLoginActivity.this;
                facebookSSOLoginActivity.handleBack(facebookSSOLoginActivity.businessFrom);
            }

            public void onError(FacebookException facebookException) {
                Log.d(FacebookSSOLoginActivity.TAG, "facebook LoginManager login error");
                facebookException.printStackTrace();
                FacebookSSOLoginActivity facebookSSOLoginActivity = FacebookSSOLoginActivity.this;
                facebookSSOLoginActivity.handleBack(facebookSSOLoginActivity.businessFrom);
            }

            /* JADX DEBUG: Method merged with bridge method */
            public void onSuccess(LoginResult loginResult) {
                Log.d(FacebookSSOLoginActivity.TAG, "facebook LoginManager login success");
                String token = loginResult.getAccessToken().getToken();
                String userId = loginResult.getAccessToken().getUserId();
                String applicationId = loginResult.getAccessToken().getApplicationId();
                Log.d(FacebookSSOLoginActivity.TAG, "token = " + token);
                Log.d(FacebookSSOLoginActivity.TAG, "userId = " + userId);
                Log.d(FacebookSSOLoginActivity.TAG, "applicationId = " + applicationId);
                FacebookSSOLoginActivity facebookSSOLoginActivity = FacebookSSOLoginActivity.this;
                facebookSSOLoginActivity.loadingDialog = new LoadingDialog.Builder(facebookSSOLoginActivity).setMessage("授权facebook账号登录中").setCancelable(false).setCancelOutside(false).createDialog();
                if (!FacebookSSOLoginActivity.this.loadingDialog.isShowing()) {
                    FacebookSSOLoginActivity.this.loadingDialog.show();
                }
                FacebookSSOLoginActivity.this.loadFacebookSSOLoginInNA(token, userId, applicationId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFacebookSSOLoginInNA(String str, String str2, String str3) {
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
        arrayList.add(new PassNameValuePair("supportGuestAccount", "1"));
        httpClientWrap.get(this.sapiWebView.getFacebookSSOLoginUrl(arrayList, str, str2, str3), ((ThirdPartyService) PassportSDK.getInstance().getThirdPartyService()).getCookies(this, this.configuration), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.activity.social.FacebookSSOLoginActivity.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str4) {
                Log.d(FacebookSSOLoginActivity.TAG, "onFailure error = " + th + " errorCode = " + i + " responseBody = " + str4);
                Dialog dialog = FacebookSSOLoginActivity.this.loadingDialog;
                if (dialog != null && dialog.isShowing()) {
                    FacebookSSOLoginActivity.this.loadingDialog.dismiss();
                }
                AuthorizationListener authorizationListener = FacebookSSOLoginActivity.this.authorizationListener;
                if (authorizationListener != null) {
                    authorizationListener.onFailed(-100, "登录失败");
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str4, HashMap<String, String> hashMap) {
                Log.d(FacebookSSOLoginActivity.TAG, "onSuccess statusCode = " + i + " responseBody = " + str4);
                Dialog dialog = FacebookSSOLoginActivity.this.loadingDialog;
                if (dialog != null && dialog.isShowing()) {
                    FacebookSSOLoginActivity.this.loadingDialog.dismiss();
                }
                if (str4 == null) {
                    AuthorizationListener authorizationListener = FacebookSSOLoginActivity.this.authorizationListener;
                    if (authorizationListener != null) {
                        authorizationListener.onFailed(-100, "登录失败");
                        return;
                    }
                    return;
                }
                try {
                    FacebookSSOLoginActivity.this.handleOpenApiAuthorizeResponse(SocialResponse.fromJSONObject(new JSONObject(str4)), hashMap);
                } catch (Throwable th) {
                    Log.e(th);
                    AuthorizationListener authorizationListener2 = FacebookSSOLoginActivity.this.authorizationListener;
                    if (authorizationListener2 != null) {
                        authorizationListener2.onFailed(-100, "登录失败");
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.callbackManager.onActivityResult(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.b.layout_sapi_sdk_webview_with_title_bar);
        initFacebook();
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.c.sapi_sdk_title_login_facebook);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }
}
