package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
/* loaded from: classes7.dex */
public class GlorySSOLoginActivity extends BaseSSOLoginActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String p;
    public static final int q = 1002;
    public static final int r = 1003;
    public transient /* synthetic */ FieldHolder $fh;
    public HuaweiIdAuthService n;
    public HuaweiIdAuthParams o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1364052981, "Lcom/baidu/sapi2/activity/social/GlorySSOLoginActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1364052981, "Lcom/baidu/sapi2/activity/social/GlorySSOLoginActivity;");
                return;
            }
        }
        p = GlorySSOLoginActivity.class.getSimpleName();
    }

    public GlorySSOLoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, this, i2, str) == null) {
            if (((BaseSSOLoginActivity) this).f42535g == 2001) {
                Intent intent = new Intent();
                intent.putExtra("result_code", i2);
                intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
                setResult(1002, intent);
            } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                ((BaseSSOLoginActivity) this).f42536h.setResultCode(i2);
                ((BaseSSOLoginActivity) this).f42536h.setResultMsg(str);
                CoreViewRouter.getInstance().getWebAuthListener().onFailure(((BaseSSOLoginActivity) this).f42536h);
                CoreViewRouter.getInstance().release();
            }
            finish();
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                a(-204, getString(b.a.c0.a.j.a.sapi_sdk_third_error_glory));
                return;
            }
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView == null) {
                return;
            }
            sapiWebView.loadHuaWeiSSOLogin(str, c());
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            HuaweiIdAuthParams createParams = new HuaweiIdAuthParamsHelper(HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM).setIdToken().setAccessToken().createParams();
            this.o = createParams;
            HuaweiIdAuthService service = HuaweiIdAuthManager.getService(this, createParams);
            this.n = service;
            startActivityForResult(service.getSignInIntent(), 1002);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
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
                    a(-202, getString(b.a.c0.a.j.a.sapi_sdk_glory_login_fail));
                    String str2 = p;
                    Log.i(str2, "signIn get code failed: " + parseAuthResultFromIntent.getException().getStatusCode());
                    return;
                }
                a(-202, getString(b.a.c0.a.j.a.sapi_sdk_third_error_glory));
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
            a(-202, getString(b.a.c0.a.j.a.sapi_sdk_glory_login_fail));
            String str5 = p;
            Log.i(str5, "signIn failed: " + parseAuthResultFromIntent2.getException().getStatusCode());
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setupViews();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.setupViews();
            setTitleText(b.a.c0.a.j.a.sapi_sdk_title_login_glory);
            d();
        }
    }
}
