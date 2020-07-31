package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.g.a.a.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.tencent.connect.UnionInfo;
import com.tencent.open.SocialOperation;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class QQSSOLoginActivity extends BaseSSOLoginActivity {
    private static final String DEFAULT_QQ_NOT_INSTALL_ERROR = "QQ未安装";
    private static final int SUCCESS_RESULTCODE = -1;
    private static final String TAG = "QQSSOLoginActivity";
    private IUiListener qqLoginListener;

    /* loaded from: classes14.dex */
    public interface QrCallback {
        void onFailure();

        void onSuccess(String str, String str2, String str3);
    }

    private void getQQSSOToken(final QrCallback qrCallback) {
        final Tencent createInstance = Tencent.createInstance(SapiAccountManager.getInstance().getConfignation().qqAppID, this);
        if (!SapiUtils.isAppInstalled(this, "com.tencent.mobileqq")) {
            Toast.makeText(this, DEFAULT_QQ_NOT_INSTALL_ERROR, 1).show();
            qrCallback.onFailure();
            return;
        }
        this.qqLoginListener = new IUiListener() { // from class: com.baidu.sapi2.activity.social.QQSSOLoginActivity.2
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                qrCallback.onFailure();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                if (obj == null) {
                    qrCallback.onFailure();
                    return;
                }
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() == 0) {
                    qrCallback.onFailure();
                    return;
                }
                try {
                    String string = jSONObject.getString("access_token");
                    String string2 = jSONObject.getString("expires_in");
                    String string3 = jSONObject.getString("openid");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                        createInstance.setAccessToken(string, string2);
                        createInstance.setOpenId(string3);
                        QQSSOLoginActivity.this.getQQUnionId(createInstance, qrCallback);
                    } else {
                        qrCallback.onFailure();
                    }
                } catch (Exception e) {
                    Log.e(e);
                    qrCallback.onFailure();
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                qrCallback.onFailure();
            }
        };
        createInstance.login(this, SchemeCollecter.CLASSIFY_ALL, this.qqLoginListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getQQUnionId(final Tencent tencent, final QrCallback qrCallback) {
        if (tencent != null && tencent.isSessionValid()) {
            new UnionInfo(this, tencent.getQQToken()).getUnionId(new IUiListener() { // from class: com.baidu.sapi2.activity.social.QQSSOLoginActivity.3
                @Override // com.tencent.tauth.IUiListener
                public void onCancel() {
                    qrCallback.onFailure();
                }

                @Override // com.tencent.tauth.IUiListener
                public void onComplete(Object obj) {
                    if (obj != null) {
                        qrCallback.onSuccess(tencent.getAccessToken(), tencent.getOpenId(), ((JSONObject) obj).optString(SocialOperation.GAME_UNION_ID));
                        return;
                    }
                    qrCallback.onFailure();
                }

                @Override // com.tencent.tauth.IUiListener
                public void onError(UiError uiError) {
                    qrCallback.onFailure();
                }
            });
            return;
        }
        qrCallback.onFailure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadQQSSOLoginInNA(String str, String str2, String str3) {
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
        httpClientWrap.get(this.sapiWebView.getQQSSOLoginUrl(arrayList, str, str2, str3), ((ThirdPartyService) PassportSDK.getInstance().getThirdPartyService()).getCookies(this, this.configuration), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.activity.social.QQSSOLoginActivity.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str4) {
                Log.d(QQSSOLoginActivity.TAG, "onFailure error = " + th + " errorCode = " + i + " responseBody = " + str4);
                AuthorizationListener authorizationListener = QQSSOLoginActivity.this.authorizationListener;
                if (authorizationListener != null) {
                    authorizationListener.onFailed(-100, "登录失败");
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str4, HashMap<String, String> hashMap) {
                Log.d(QQSSOLoginActivity.TAG, "onSuccess statusCode = " + i + " responseBody = " + str4);
                if (str4 == null) {
                    AuthorizationListener authorizationListener = QQSSOLoginActivity.this.authorizationListener;
                    if (authorizationListener != null) {
                        authorizationListener.onFailed(-100, "登录失败");
                        return;
                    }
                    return;
                }
                try {
                    QQSSOLoginActivity.this.handleOpenApiAuthorizeResponse(SocialResponse.fromJSONObject(new JSONObject(str4)), hashMap);
                } catch (Throwable th) {
                    Log.e(th);
                    AuthorizationListener authorizationListener2 = QQSSOLoginActivity.this.authorizationListener;
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
            this.loadingDialog = new LoadingDialog.Builder(this).setMessage("授权QQ账号登录中").setCancelable(false).setCancelOutside(false).createDialog();
            if (!this.loadingDialog.isShowing()) {
                this.loadingDialog.show();
            }
        }
        if (i == 11101 || i == 10102) {
            Tencent.onActivityResultData(i, i2, intent, this.qqLoginListener);
        }
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
        setTitleText(a.c.sapi_sdk_title_login_qq);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        this.loadingDialog = new LoadingDialog.Builder(this).setMessage("").setCancelable(false).setCancelOutside(false).createDialog();
        if (!this.loadingDialog.isShowing()) {
            this.loadingDialog.show();
        }
        getQQSSOToken(new QrCallback() { // from class: com.baidu.sapi2.activity.social.QQSSOLoginActivity.1
            @Override // com.baidu.sapi2.activity.social.QQSSOLoginActivity.QrCallback
            public void onFailure() {
                QQSSOLoginActivity qQSSOLoginActivity = QQSSOLoginActivity.this;
                qQSSOLoginActivity.handleBack(qQSSOLoginActivity.businessFrom);
            }

            @Override // com.baidu.sapi2.activity.social.QQSSOLoginActivity.QrCallback
            public void onSuccess(String str, String str2, String str3) {
                if (((SocialLoginBase) QQSSOLoginActivity.this).sapiWebView != null) {
                    QQSSOLoginActivity.this.loadQQSSOLoginInNA(str, str2, str3);
                }
            }
        });
    }
}
