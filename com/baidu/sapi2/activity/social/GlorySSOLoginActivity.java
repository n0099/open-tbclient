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
/* loaded from: classes2.dex */
public class GlorySSOLoginActivity extends BaseSSOLoginActivity {
    public static final String p = GlorySSOLoginActivity.class.getSimpleName();
    public static final int q = 1002;
    public static final int r = 1003;
    public HuaweiIdAuthService n;
    public HuaweiIdAuthParams o;

    private void a(int i2, String str) {
        if (((BaseSSOLoginActivity) this).f9811g == 2001) {
            Intent intent = new Intent();
            intent.putExtra("result_code", i2);
            intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
            setResult(1002, intent);
        } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
            ((BaseSSOLoginActivity) this).f9812h.setResultCode(i2);
            ((BaseSSOLoginActivity) this).f9812h.setResultMsg(str);
            CoreViewRouter.getInstance().getWebAuthListener().onFailure(((BaseSSOLoginActivity) this).f9812h);
            CoreViewRouter.getInstance().release();
        }
        finish();
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            a(-204, getString(d.a.a0.a.j.a.sapi_sdk_third_error_glory));
            return;
        }
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null) {
            return;
        }
        sapiWebView.loadHuaWeiSSOLogin(str, c());
    }

    private void d() {
        HuaweiIdAuthParams createParams = new HuaweiIdAuthParamsHelper(HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM).setIdToken().setAccessToken().createParams();
        this.o = createParams;
        HuaweiIdAuthService service = HuaweiIdAuthManager.getService(this, createParams);
        this.n = service;
        startActivityForResult(service.getSignInIntent(), 1002);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1002) {
            if (i2 == 1003) {
                Task parseAuthResultFromIntent = HuaweiIdAuthManager.parseAuthResultFromIntent(intent);
                if (parseAuthResultFromIntent.isSuccessful()) {
                    AuthHuaweiId authHuaweiId = (AuthHuaweiId) parseAuthResultFromIntent.getResult();
                    Log.i(p, "signIn get code success.");
                    String str = p;
                    Log.i(str, "ServerAuthCode: " + authHuaweiId.getAuthorizationCode());
                    b(authHuaweiId.getAuthorizationCode());
                    return;
                }
                a(-202, getString(d.a.a0.a.j.a.sapi_sdk_glory_login_fail));
                String str2 = p;
                Log.i(str2, "signIn get code failed: " + parseAuthResultFromIntent.getException().getStatusCode());
                return;
            }
            a(-202, getString(d.a.a0.a.j.a.sapi_sdk_third_error_glory));
            return;
        }
        Task parseAuthResultFromIntent2 = HuaweiIdAuthManager.parseAuthResultFromIntent(intent);
        if (parseAuthResultFromIntent2.isSuccessful()) {
            AuthHuaweiId authHuaweiId2 = (AuthHuaweiId) parseAuthResultFromIntent2.getResult();
            String str3 = p;
            Log.i(str3, authHuaweiId2.getDisplayName() + " signIn success ");
            String str4 = p;
            Log.i(str4, "AccessToken: " + authHuaweiId2.getAccessToken());
            b(authHuaweiId2.getAccessToken());
            return;
        }
        a(-202, getString(d.a.a0.a.j.a.sapi_sdk_glory_login_fail));
        String str5 = p;
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
        setTitleText(d.a.a0.a.j.a.sapi_sdk_title_login_glory);
        d();
    }
}
