package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String o;
    public static final int p = 1002;
    public static final int q = 1003;
    public transient /* synthetic */ FieldHolder $fh;
    public HonorIDSignInService n;

    /* loaded from: classes2.dex */
    public class a implements OnFailureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HonorSSOLoginActivity a;

        public a(HonorSSOLoginActivity honorSSOLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {honorSSOLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = honorSSOLoginActivity;
        }

        public void onFailure(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (exc instanceof ApiException) {
                    String str = HonorSSOLoginActivity.o;
                    Log.i(str, "silentSignIn failed : " + ((ApiException) exc).getStatusCode() + "," + exc.getMessage());
                    this.a.d();
                    return;
                }
                String str2 = HonorSSOLoginActivity.o;
                Log.i(str2, "silentSignIn onFail :" + exc.getMessage());
                HonorSSOLoginActivity honorSSOLoginActivity = this.a;
                honorSSOLoginActivity.a(-202, honorSSOLoginActivity.getString(R.string.obfuscated_res_0x7f0f1060));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements OnSuccessListener<SignInAccountInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HonorSSOLoginActivity a;

        public b(HonorSSOLoginActivity honorSSOLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {honorSSOLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = honorSSOLoginActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: a */
        public void onSuccess(SignInAccountInfo signInAccountInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, signInAccountInfo) == null) {
                if (signInAccountInfo != null && !TextUtils.isEmpty(signInAccountInfo.getAuthorizationCode())) {
                    String str = HonorSSOLoginActivity.o;
                    Log.i(str, "getAuthorizationCode: " + signInAccountInfo.getAuthorizationCode());
                    this.a.b(signInAccountInfo.getAuthorizationCode());
                    return;
                }
                Log.i(HonorSSOLoginActivity.o, "doFrontLogin by accessToken is empty");
                this.a.d();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1291861148, "Lcom/baidu/sapi2/activity/social/HonorSSOLoginActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1291861148, "Lcom/baidu/sapi2/activity/social/HonorSSOLoginActivity;");
                return;
            }
        }
        o = HonorSSOLoginActivity.class.getSimpleName();
    }

    public HonorSSOLoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                a(-204, getString(R.string.obfuscated_res_0x7f0f106c));
            } else if (this.sapiWebView == null) {
            } else {
                SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
                this.sapiWebView.loadHonorSSOLogin(str, confignation.honorAppID, confignation.honorRedirectUri, c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                startActivityForResult(this.n.getSignInIntent(), 1002);
            } catch (Exception e) {
                String str = o;
                Log.i(str, "doFrontLogin Exception: " + e.getMessage());
                e.printStackTrace();
                a(-202, getString(R.string.obfuscated_res_0x7f0f1060));
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation != null && !TextUtils.isEmpty(confignation.honorAppID)) {
                if (SapiDeviceInfo.getOsSdkInt() < 19) {
                    a(-10, AbstractThirdPartyService.RESULT_AUTH_UNSUPPORT_HONOR_LOWER_THAN_19_MSG);
                    return;
                }
                HonorIDSignInService service = HonorIdSignInManager.getService(this, new SignInOptionBuilder(SignInOptions.DEFAULT_AUTH_REQUEST_PARAM).setClientId(confignation.honorAppID).createParams());
                this.n = service;
                service.silentSignIn().addOnSuccessListener(new b(this)).addOnFailureListener(new a(this));
                return;
            }
            a(-10, AbstractThirdPartyService.RESULT_AUTH_UNSUPPORT_HONOR_MSG);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
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
                a(-202, getString(R.string.obfuscated_res_0x7f0f1060));
                String str3 = o;
                Log.i(str3, "signIn failed: " + parseAuthResultFromIntent.getException().getStatusCode());
                return;
            }
            a(-202, getString(R.string.obfuscated_res_0x7f0f106c));
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
            setTitleText(R.string.obfuscated_res_0x7f0f1074);
            try {
                e();
            } catch (Exception e) {
                e.printStackTrace();
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, this, i, str) == null) {
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
    }
}
