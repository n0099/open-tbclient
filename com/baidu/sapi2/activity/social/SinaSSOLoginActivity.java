package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.widget.RelativeLayout;
import android.widget.Toast;
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
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SinaSSOLoginActivity extends BaseSSOLoginActivity {
    private static final int SUCCESS_RESULTCODE = -1;
    private static final String TAG = "SinaSSOLoginActivity";
    private SsoHandler sinaSsoHandler;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSinaSSOLoginInNA(String str, String str2) {
        Log.d(TAG, "Current Thread:" + Thread.currentThread().getName());
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
        httpClientWrap.get(this.sapiWebView.getSinaSSOLoginUrl(arrayList, str, str2), ((ThirdPartyService) PassportSDK.getInstance().getThirdPartyService()).getCookies(this, this.configuration), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.activity.social.SinaSSOLoginActivity.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                Log.d(SinaSSOLoginActivity.TAG, "onFailure error = " + th + " errorCode = " + i + " responseBody = " + str3);
                AuthorizationListener authorizationListener = SinaSSOLoginActivity.this.authorizationListener;
                if (authorizationListener != null) {
                    authorizationListener.onFailed(-100, "登录失败");
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str3, HashMap<String, String> hashMap) {
                Log.d(SinaSSOLoginActivity.TAG, "onSuccess statusCode = " + i + " responseBody = " + str3);
                if (str3 == null) {
                    AuthorizationListener authorizationListener = SinaSSOLoginActivity.this.authorizationListener;
                    if (authorizationListener != null) {
                        authorizationListener.onFailed(-100, "登录失败");
                        return;
                    }
                    return;
                }
                try {
                    SinaSSOLoginActivity.this.handleOpenApiAuthorizeResponse(SocialResponse.fromJSONObject(new JSONObject(str3)), hashMap);
                } catch (Throwable th) {
                    Log.e(th);
                    AuthorizationListener authorizationListener2 = SinaSSOLoginActivity.this.authorizationListener;
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
        Log.d(TAG, "requestCode = " + i + " resultCode = " + i2 + " data = " + intent);
        this.loadingDialog.dismiss();
        if (i2 == -1) {
            this.loadingDialog = new LoadingDialog.Builder(this).setMessage("授权微博账号登录中").setCancelable(false).setCancelOutside(false).createDialog();
            if (!this.loadingDialog.isShowing()) {
                this.loadingDialog.show();
            }
        }
        super.onActivityResult(i, i2, intent);
        this.sinaSsoHandler.authorizeCallBack(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.c.sapi_sdk_title_login_sina);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        this.loadingDialog = new LoadingDialog.Builder(this).setMessage("").setCancelable(false).setCancelOutside(false).createDialog();
        if (!this.loadingDialog.isShowing()) {
            this.loadingDialog.show();
        }
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        WbSdk.install(this, new AuthInfo(this, confignation.sinaAppId, confignation.sinaRedirectUri, NotificationCompat.CATEGORY_EMAIL));
        this.sinaSsoHandler = new SsoHandler(this);
        this.sinaSsoHandler.authorize(new WbAuthListener() { // from class: com.baidu.sapi2.activity.social.SinaSSOLoginActivity.1
            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void cancel() {
                SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
                sinaSSOLoginActivity.handleBack(sinaSSOLoginActivity.businessFrom);
            }

            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
                Toast.makeText(SinaSSOLoginActivity.this, wbConnectErrorMessage.getErrorMessage(), 0).show();
            }

            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
                SinaSSOLoginActivity.this.loadSinaSSOLoginInNA(oauth2AccessToken.getToken(), oauth2AccessToken.getUid());
            }
        });
    }
}
