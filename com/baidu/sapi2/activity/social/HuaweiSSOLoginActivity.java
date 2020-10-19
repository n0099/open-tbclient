package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.k.a.a.a;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.utils.Log;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
/* loaded from: classes6.dex */
public class HuaweiSSOLoginActivity extends BaseSSOLoginActivity {
    public static final int REQUEST_SIGN_IN_LOGIN = 1002;
    public static final int REQUEST_SIGN_IN_LOGIN_CODE = 1003;
    public static final String TAG = HuaweiSSOLoginActivity.class.getSimpleName();
    private HuaweiIdAuthService mAuthManager;
    private HuaweiIdAuthParams mAuthParam;

    private void loadSSOLogin(String str) {
        if (TextUtils.isEmpty(str)) {
            onFail(-204, getString(a.c.sapi_sdk_third_error_hw));
        } else if (this.sapiWebView != null) {
            this.sapiWebView.loadHuaWeiSSOLogin(str, getStatParamList());
        }
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
        this.mAuthParam = new HuaweiIdAuthParamsHelper(HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM).setIdToken().setAccessToken().createParams();
        this.mAuthManager = HuaweiIdAuthManager.getService(this, this.mAuthParam);
        startActivityForResult(this.mAuthManager.getSignInIntent(), 1002);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1002) {
            Task parseAuthResultFromIntent = HuaweiIdAuthManager.parseAuthResultFromIntent(intent);
            if (parseAuthResultFromIntent.isSuccessful()) {
                AuthHuaweiId authHuaweiId = (AuthHuaweiId) parseAuthResultFromIntent.getResult();
                Log.i(TAG, authHuaweiId.getDisplayName() + " signIn success ");
                Log.i(TAG, "AccessToken: " + authHuaweiId.getAccessToken());
                loadSSOLogin(authHuaweiId.getAccessToken());
                return;
            }
            onFail(-202, getString(a.c.sapi_sdk_huawei_login_fail));
            Log.i(TAG, "signIn failed: " + parseAuthResultFromIntent.getException().getStatusCode());
        } else if (i == 1003) {
            Task parseAuthResultFromIntent2 = HuaweiIdAuthManager.parseAuthResultFromIntent(intent);
            if (parseAuthResultFromIntent2.isSuccessful()) {
                AuthHuaweiId authHuaweiId2 = (AuthHuaweiId) parseAuthResultFromIntent2.getResult();
                Log.i(TAG, "signIn get code success.");
                Log.i(TAG, "ServerAuthCode: " + authHuaweiId2.getAuthorizationCode());
                loadSSOLogin(authHuaweiId2.getAuthorizationCode());
                return;
            }
            onFail(-202, getString(a.c.sapi_sdk_huawei_login_fail));
            Log.i(TAG, "signIn get code failed: " + parseAuthResultFromIntent2.getException().getStatusCode());
        } else {
            onFail(-202, getString(a.c.sapi_sdk_third_error_hw));
        }
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
        setTitleText(a.c.sapi_sdk_title_login_hw);
        signIn();
    }
}
