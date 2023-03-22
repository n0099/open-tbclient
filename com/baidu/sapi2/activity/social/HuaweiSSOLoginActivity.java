package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.Log;
import com.baidu.tieba.R;
import com.baidu.tieba.nma;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
/* loaded from: classes2.dex */
public class HuaweiSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String p = HuaweiSSOLoginActivity.class.getSimpleName();
    public static final int q = 1002;
    public static final int r = 1003;
    public HuaweiIdAuthService n;
    public HuaweiIdAuthParams o;

    private void d() {
        HuaweiIdAuthParams createParams = new HuaweiIdAuthParamsHelper(HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM).setIdToken().setAccessToken().createParams();
        this.o = createParams;
        HuaweiIdAuthService service = HuaweiIdAuthManager.getService(this, createParams);
        this.n = service;
        startActivityForResult(service.getSignInIntent(), 1002);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(R.string.sapi_sdk_title_login_hw);
        try {
            d();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    private void a(int i, String str) {
        if (((BaseSSOLoginActivity) this).g == 2001) {
            Intent intent = new Intent();
            intent.putExtra("result_code", i);
            intent.putExtra("result_msg", str);
            setResult(1002, intent);
        } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
            ((BaseSSOLoginActivity) this).h.setResultCode(i);
            ((BaseSSOLoginActivity) this).h.setResultMsg(str);
            CoreViewRouter.getInstance().getWebAuthListener().onFailure(((BaseSSOLoginActivity) this).h);
            CoreViewRouter.getInstance().release();
        }
        finish();
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            a(-204, getString(R.string.sapi_sdk_third_error_hw));
            return;
        }
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null) {
            return;
        }
        sapiWebView.loadHuaWeiSSOLogin(str, c());
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1002) {
            nma parseAuthResultFromIntent = HuaweiIdAuthManager.parseAuthResultFromIntent(intent);
            if (parseAuthResultFromIntent.h()) {
                AuthHuaweiId authHuaweiId = (AuthHuaweiId) parseAuthResultFromIntent.e();
                String str = p;
                Log.i(str, authHuaweiId.getDisplayName() + " signIn success ");
                String str2 = p;
                Log.i(str2, "AccessToken: " + authHuaweiId.getAccessToken());
                b(authHuaweiId.getAccessToken());
                return;
            }
            a(-202, getString(R.string.sapi_sdk_huawei_login_fail));
            String str3 = p;
            Log.i(str3, "signIn failed: " + ((ApiException) parseAuthResultFromIntent.d()).getStatusCode());
        } else if (i == 1003) {
            nma parseAuthResultFromIntent2 = HuaweiIdAuthManager.parseAuthResultFromIntent(intent);
            if (parseAuthResultFromIntent2.h()) {
                AuthHuaweiId authHuaweiId2 = (AuthHuaweiId) parseAuthResultFromIntent2.e();
                Log.i(p, "signIn get code success.");
                String str4 = p;
                Log.i(str4, "ServerAuthCode: " + authHuaweiId2.getAuthorizationCode());
                b(authHuaweiId2.getAuthorizationCode());
                return;
            }
            a(-202, getString(R.string.sapi_sdk_huawei_login_fail));
            String str5 = p;
            Log.i(str5, "signIn get code failed: " + ((ApiException) parseAuthResultFromIntent2.d()).getStatusCode());
        } else {
            a(-202, getString(R.string.sapi_sdk_third_error_hw));
        }
    }
}
