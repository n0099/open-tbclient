package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.utils.Log;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import d.b.x.a.j.a;
/* loaded from: classes2.dex */
public class HuaweiSSOLoginActivity extends BaseSSOLoginActivity {
    public static final int REQUEST_SIGN_IN_LOGIN = 1002;
    public static final int REQUEST_SIGN_IN_LOGIN_CODE = 1003;
    public static final String TAG = HuaweiSSOLoginActivity.class.getSimpleName();
    public HuaweiIdAuthService mAuthManager;
    public HuaweiIdAuthParams mAuthParam;

    private void loadSSOLogin(String str) {
        if (TextUtils.isEmpty(str)) {
            onFail(-204, getString(a.sapi_sdk_third_error_hw));
            return;
        }
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null) {
            return;
        }
        sapiWebView.loadHuaWeiSSOLogin(str, getStatParamList());
    }

    private void onFail(int i, String str) {
        if (this.businessFrom == 2001) {
            Intent intent = new Intent();
            intent.putExtra("result_code", i);
            intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
            setResult(1002, intent);
        } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
            this.webAuthResult.setResultCode(i);
            this.webAuthResult.setResultMsg(str);
            CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
            CoreViewRouter.getInstance().release();
        }
        finish();
    }

    private void signIn() {
        HuaweiIdAuthParams createParams = new HuaweiIdAuthParamsHelper(HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM).setIdToken().setAccessToken().createParams();
        this.mAuthParam = createParams;
        HuaweiIdAuthService service = HuaweiIdAuthManager.getService(this, createParams);
        this.mAuthManager = service;
        startActivityForResult(service.getSignInIntent(), 1002);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1002) {
            if (i == 1003) {
                Task parseAuthResultFromIntent = HuaweiIdAuthManager.parseAuthResultFromIntent(intent);
                if (parseAuthResultFromIntent.isSuccessful()) {
                    AuthHuaweiId authHuaweiId = (AuthHuaweiId) parseAuthResultFromIntent.getResult();
                    Log.i(TAG, "signIn get code success.");
                    String str = TAG;
                    Log.i(str, "ServerAuthCode: " + authHuaweiId.getAuthorizationCode());
                    loadSSOLogin(authHuaweiId.getAuthorizationCode());
                    return;
                }
                onFail(-202, getString(a.sapi_sdk_huawei_login_fail));
                String str2 = TAG;
                Log.i(str2, "signIn get code failed: " + parseAuthResultFromIntent.getException().getStatusCode());
                return;
            }
            onFail(-202, getString(a.sapi_sdk_third_error_hw));
            return;
        }
        Task parseAuthResultFromIntent2 = HuaweiIdAuthManager.parseAuthResultFromIntent(intent);
        if (parseAuthResultFromIntent2.isSuccessful()) {
            AuthHuaweiId authHuaweiId2 = (AuthHuaweiId) parseAuthResultFromIntent2.getResult();
            String str3 = TAG;
            Log.i(str3, authHuaweiId2.getDisplayName() + " signIn success ");
            String str4 = TAG;
            Log.i(str4, "AccessToken: " + authHuaweiId2.getAccessToken());
            loadSSOLogin(authHuaweiId2.getAccessToken());
            return;
        }
        onFail(-202, getString(a.sapi_sdk_huawei_login_fail));
        String str5 = TAG;
        Log.i(str5, "signIn failed: " + parseAuthResultFromIntent2.getException().getStatusCode());
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.sapi_sdk_title_login_hw);
        signIn();
    }
}
