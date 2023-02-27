package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.tieba.R;
import com.hihonor.cloudservice.common.ApiException;
import com.hihonor.cloudservice.support.account.HonorIdSignInManager;
import com.hihonor.cloudservice.support.account.request.SignInOptionBuilder;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.cloudservice.support.account.service.HonorIDSignInService;
import com.hihonor.cloudservice.tasks.OnFailureListener;
import com.hihonor.cloudservice.tasks.OnSuccessListener;
import com.hihonor.cloudservice.tasks.Task;
/* loaded from: classes2.dex */
public class HonorSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String o = HonorSSOLoginActivity.class.getSimpleName();
    public static final int p = 1002;
    public static final int q = 1003;
    public HonorIDSignInService n;

    /* loaded from: classes2.dex */
    public class a implements OnFailureListener {
        public a() {
        }

        public void onFailure(Exception exc) {
            if (exc instanceof ApiException) {
                String str = HonorSSOLoginActivity.o;
                Log.i(str, "silentSignIn failed : " + ((ApiException) exc).getStatusCode() + "," + exc.getMessage());
                HonorSSOLoginActivity.this.d();
                return;
            }
            String str2 = HonorSSOLoginActivity.o;
            Log.i(str2, "silentSignIn onFail :" + exc.getMessage());
            HonorSSOLoginActivity honorSSOLoginActivity = HonorSSOLoginActivity.this;
            honorSSOLoginActivity.a(-202, honorSSOLoginActivity.getString(R.string.sapi_sdk_glory_login_fail));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements OnSuccessListener<SignInAccountInfo> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: a */
        public void onSuccess(SignInAccountInfo signInAccountInfo) {
            if (signInAccountInfo != null && !TextUtils.isEmpty(signInAccountInfo.getAuthorizationCode())) {
                String str = HonorSSOLoginActivity.o;
                Log.i(str, "getAuthorizationCode: " + signInAccountInfo.getAuthorizationCode());
                HonorSSOLoginActivity.this.b(signInAccountInfo.getAuthorizationCode());
                return;
            }
            Log.i(HonorSSOLoginActivity.o, "doFrontLogin by accessToken is empty");
            HonorSSOLoginActivity.this.d();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(R.string.sapi_sdk_title_login_glory);
        try {
            e();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            a(-204, getString(R.string.sapi_sdk_third_error_glory));
        } else if (this.sapiWebView == null) {
        } else {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            this.sapiWebView.loadHonorSSOLogin(str, confignation.honorAppID, confignation.honorRedirectUri, c());
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            startActivityForResult(this.n.getSignInIntent(), 1002);
        } catch (Exception e) {
            String str = o;
            Log.i(str, "doFrontLogin Exception: " + e.getMessage());
            e.printStackTrace();
            a(-202, getString(R.string.sapi_sdk_glory_login_fail));
        }
    }

    private void e() {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && !TextUtils.isEmpty(confignation.honorAppID)) {
            if (SapiDeviceInfo.getOsSdkInt() < 19) {
                a(-10, AbstractThirdPartyService.RESULT_AUTH_UNSUPPORT_HONOR_LOWER_THAN_19_MSG);
                return;
            }
            HonorIDSignInService service = HonorIdSignInManager.getService(this, new SignInOptionBuilder(SignInOptions.DEFAULT_AUTH_REQUEST_PARAM).setClientId(confignation.honorAppID).createParams());
            this.n = service;
            service.silentSignIn().addOnSuccessListener(new b()).addOnFailureListener(new a());
            return;
        }
        a(-10, AbstractThirdPartyService.RESULT_AUTH_UNSUPPORT_HONOR_MSG);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1002) {
            Task parseAuthResultFromIntent = HonorIdSignInManager.parseAuthResultFromIntent(i2, intent);
            if (parseAuthResultFromIntent.isSuccessful()) {
                SignInAccountInfo signInAccountInfo = (SignInAccountInfo) parseAuthResultFromIntent.getResult();
                String str = o;
                Log.i(str, "getAuthorizationCode: " + signInAccountInfo.getAuthorizationCode());
                String str2 = o;
                Log.i(str2, "UnionId: " + signInAccountInfo.getUnionId());
                b(signInAccountInfo.getAuthorizationCode());
                return;
            }
            a(-202, getString(R.string.sapi_sdk_glory_login_fail));
            String str3 = o;
            Log.i(str3, "signIn failed: " + parseAuthResultFromIntent.getException().getStatusCode());
            return;
        }
        a(-202, getString(R.string.sapi_sdk_third_error_glory));
    }
}
