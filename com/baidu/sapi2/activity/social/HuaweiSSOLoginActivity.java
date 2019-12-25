package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.i.a.a.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.utils.Log;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.hwid.HuaweiId;
import com.huawei.hms.support.api.hwid.HuaweiIdSignInOptions;
import com.huawei.hms.support.api.hwid.SignInHuaweiId;
import com.huawei.hms.support.api.hwid.SignInResult;
/* loaded from: classes4.dex */
public class HuaweiSSOLoginActivity extends BaseSSOLoginActivity {
    private static final int REQUEST_HMS_RESOLVE_ERROR = 1000;
    private static final int REQUEST_SIGN_IN_AUTH = 1003;
    private static final int REQUEST_SIGN_IN_CHECK_PASSWORD = 1005;
    private static final int REQUEST_SIGN_IN_UNLOGIN = 1002;
    private static final int SIGN_IN_NETWORK_CONTROL = 2007;
    public static final String TAG = "HuaweiSSOLoginActivity";
    private HuaweiApiClient client;
    private boolean mResolvingError = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSignInResult(SignInResult signInResult) {
        if (signInResult.isSuccess()) {
            SignInHuaweiId signInHuaweiId = signInResult.getSignInHuaweiId();
            Log.e(TAG, "account", signInHuaweiId.toString());
            loadSSOLogin(signInHuaweiId.getAccessToken());
            return;
        }
        Intent data = signInResult.getData();
        if (data == null) {
            onFail(signInResult.getStatus().getStatusCode(), getString(a.c.sapi_sdk_third_error_hw));
        } else if (signInResult.getStatus().getStatusCode() == 2001) {
            Log.i(TAG, "帐号未登录");
            startActivityForResult(data, 1002);
        } else if (signInResult.getStatus().getStatusCode() == 2002) {
            Log.i(TAG, "帐号已登录，需要用户授权");
            startActivityForResult(data, 1003);
        } else if (signInResult.getStatus().getStatusCode() == 2004) {
            startActivityForResult(data, 1005);
        } else if (signInResult.getStatus().getStatusCode() == 2007) {
            startActivityForResult(data, 2007);
        } else {
            onFail(signInResult.getStatus().getStatusCode(), getString(a.c.sapi_sdk_third_error_hw));
        }
    }

    private void loadSSOLogin(String str) {
        if (TextUtils.isEmpty(str)) {
            onFail(-204, getString(a.c.sapi_sdk_third_error_hw));
        } else if (this.sapiWebView != null) {
            this.sapiWebView.loadHuaWeiSSOLogin(str, getStatParamList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFail(int i, String str) {
        if (this.businessFrom == 2001) {
            Intent intent = new Intent();
            intent.putExtra("result_code", i);
            intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
            setResult(1002, intent);
        } else if (PassportSDK.getInstance().getWebAuthListener() != null) {
            this.webAuthResult.setResultCode(i);
            this.webAuthResult.setResultMsg(str);
            PassportSDK.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
            PassportSDK.getInstance().release();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signIn() {
        if (!this.client.isConnected()) {
            Log.i(TAG, "登录帐号失败，原因：HUAWEIApiClient未连接");
            this.client.connect(this);
            return;
        }
        HuaweiId.HuaweiIdApi.signIn(this, this.client).setResultCallback(new ResultCallback<SignInResult>() { // from class: com.baidu.sapi2.activity.social.HuaweiSSOLoginActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            public void onResult(SignInResult signInResult) {
                HuaweiSSOLoginActivity.this.handleSignInResult(signInResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            onFail(-202, getString(a.c.sapi_sdk_third_error_hw));
        } else if (i == 1002) {
            signIn();
        } else if (i != 1003) {
            if (i == 1005) {
                signIn();
            } else if (i == 2007) {
                handleSignInResult(HuaweiId.HuaweiIdApi.getSignInResultFromIntent(intent));
            }
        } else {
            Log.i(TAG, "用户已经授权");
            SignInResult signInResultFromIntent = HuaweiId.HuaweiIdApi.getSignInResultFromIntent(intent);
            if (signInResultFromIntent.isSuccess()) {
                SignInHuaweiId signInHuaweiId = signInResultFromIntent.getSignInHuaweiId();
                Log.i(TAG, "用户授权成功，直接返回帐号信息:" + signInHuaweiId.toString());
                loadSSOLogin(signInHuaweiId.getAccessToken());
                return;
            }
            onFail(signInResultFromIntent.getStatus().getStatusCode(), getString(a.c.sapi_sdk_third_error_hw));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        HuaweiApiClient huaweiApiClient = this.client;
        if (huaweiApiClient != null) {
            huaweiApiClient.disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.c.sapi_sdk_title_login_hw);
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = new HuaweiApiClient.ConnectionCallbacks() { // from class: com.baidu.sapi2.activity.social.HuaweiSSOLoginActivity.1
            public void onConnected() {
                Log.e(HuaweiSSOLoginActivity.TAG, "onConnected");
                HuaweiSSOLoginActivity.this.signIn();
            }

            public void onConnectionSuspended(int i) {
                Log.e(HuaweiSSOLoginActivity.TAG, "onConnectionSuspended");
                if (HuaweiSSOLoginActivity.this.isFinishing()) {
                    return;
                }
                HuaweiSSOLoginActivity.this.client.connect(HuaweiSSOLoginActivity.this);
            }
        };
        this.client = new HuaweiApiClient.Builder(this).addApi(HuaweiId.SIGN_IN_API, new HuaweiIdSignInOptions.Builder(HuaweiIdSignInOptions.DEFAULT_SIGN_IN).build()).addConnectionCallbacks(connectionCallbacks).addOnConnectionFailedListener(new HuaweiApiClient.OnConnectionFailedListener() { // from class: com.baidu.sapi2.activity.social.HuaweiSSOLoginActivity.2
            public void onConnectionFailed(ConnectionResult connectionResult) {
                Log.e(HuaweiSSOLoginActivity.TAG, "onConnectionFailed", Integer.valueOf(connectionResult.getErrorCode()));
                if (!HuaweiSSOLoginActivity.this.mResolvingError) {
                    if (!HuaweiApiAvailability.getInstance().isUserResolvableError(connectionResult.getErrorCode())) {
                        HuaweiSSOLoginActivity.this.onFail(connectionResult.getErrorCode(), HuaweiSSOLoginActivity.this.getString(a.c.sapi_sdk_third_error_hw));
                        return;
                    }
                    android.util.Log.e("hmssdk", "onConnectionFailed");
                    HuaweiSSOLoginActivity.this.mResolvingError = true;
                    HuaweiApiAvailability.getInstance().resolveError(HuaweiSSOLoginActivity.this, connectionResult.getErrorCode(), 1000);
                }
            }
        }).build();
        this.client.connect(this);
    }
}
