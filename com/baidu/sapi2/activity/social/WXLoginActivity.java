package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.f.a.a.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.LoadingDialog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class WXLoginActivity extends BaseSSOLoginActivity {
    public static final String KEY_BASE_RESP_CODE = "code";
    public static final String KEY_BASE_RESP_ERROR_CODE = "error_code";
    public static final String KEY_BASE_RESP_STATE = "state";
    public static final String KEY_FROM_WX_AUTH = "from_wx_auth";
    public static final String TAG = "WXLoginActivity";
    private static int businessFrom;
    private static String mWxExtraJson;
    public String wxRespCode;
    public int wxRespErrorCode;
    public String wxRespState;

    private void handleWxResp() {
        this.businessFrom = businessFrom;
        this.extraJson = mWxExtraJson;
        mWxExtraJson = null;
        this.wxRespCode = getIntent().getStringExtra("code");
        this.wxRespState = getIntent().getStringExtra("state");
        this.wxRespErrorCode = getIntent().getIntExtra("error_code", -1);
        if (this.wxRespErrorCode == 0) {
            loadWeiXinSSOLoginInNA(this.wxRespCode, this.wxRespState);
        } else {
            handleBack(businessFrom);
        }
    }

    private void initView() {
        setupViews();
        setTitleText(a.c.sapi_sdk_title_login_wx);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        this.loadingDialog = new LoadingDialog.Builder(this).setMessage("授权微信账号登录中").setCancelable(false).setCancelOutside(false).createDialog();
        if (!this.loadingDialog.isShowing()) {
            this.loadingDialog.show();
        }
        this.sapiWebView.setWeixinHandler(new SapiWebView.WeixinHandler() { // from class: com.baidu.sapi2.activity.social.WXLoginActivity.1
            @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
            public void handleNotInstall() {
                Toast.makeText(WXLoginActivity.this, SapiWebView.DEFAULT_WEIXIN_NOT_INSTALL_ERROR, 1).show();
                WXLoginActivity.this.handleBack(WXLoginActivity.businessFrom);
            }

            @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
            public void handleServerError(String str) {
                Toast.makeText(WXLoginActivity.this, "服务错误", 1).show();
                WXLoginActivity.this.handleBack(WXLoginActivity.businessFrom);
            }

            @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
            public void onFinish() {
                WXLoginActivity.this.finish();
            }
        });
        if (!getIntent().getBooleanExtra(KEY_FROM_WX_AUTH, false)) {
            businessFrom = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
            mWxExtraJson = this.extraJson;
            this.sapiWebView.loadWeixinSSOLogin();
            return;
        }
        handleWxResp();
    }

    private void loadWeiXinSSOLoginInNA(String str, String str2) {
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
        httpClientWrap.get(this.sapiWebView.getWeiXinSSOLoginUrl(str, str2, false, arrayList), ((ThirdPartyService) PassportSDK.getInstance().getThirdPartyService()).getCookies(this, this.configuration), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.activity.social.WXLoginActivity.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                Log.d(WXLoginActivity.TAG, "onFailure error = " + th + " errorCode = " + i + " responseBody = " + str3);
                AuthorizationListener authorizationListener = WXLoginActivity.this.authorizationListener;
                if (authorizationListener != null) {
                    authorizationListener.onFailed(-100, "登录失败");
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str3, HashMap<String, String> hashMap) {
                Log.d(WXLoginActivity.TAG, "onSuccess statusCode = " + i + " responseBody = " + str3);
                if (str3 == null) {
                    AuthorizationListener authorizationListener = WXLoginActivity.this.authorizationListener;
                    if (authorizationListener != null) {
                        authorizationListener.onFailed(-100, "登录失败");
                        return;
                    }
                    return;
                }
                try {
                    WXLoginActivity.this.handleOpenApiAuthorizeResponse(SocialResponse.fromJSONObject(new JSONObject(str3)), hashMap);
                } catch (Throwable th) {
                    Log.e(th);
                    AuthorizationListener authorizationListener2 = WXLoginActivity.this.authorizationListener;
                    if (authorizationListener2 != null) {
                        authorizationListener2.onFailed(-100, "登录失败");
                    }
                }
            }
        });
    }

    private void setInvokeResult(int i, Intent intent) {
        if (SocialLoginBase.getWXinvokeCallback() != null) {
            SocialLoginBase.getWXinvokeCallback().onResult(i, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void handleBack(int i) {
        super.handleBack(i);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void setActivtyResult(int i) {
        super.setActivtyResult(i);
        setInvokeResult(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void setActivtyResult(int i, Intent intent) {
        super.setActivtyResult(i, intent);
        setInvokeResult(i, intent);
    }
}
