package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class GoogleSSOLoginActivity extends BaseSSOLoginActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String n = "GoogleSSOLoginActivity";
    public static final int o = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    public GoogleSSOLoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a(Task<GoogleSignInAccount> task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, task) == null) {
            try {
                b(((GoogleSignInAccount) task.getResult(ApiException.class)).getIdToken());
            } catch (ApiException e2) {
                int statusCode = e2.getStatusCode();
                String message = e2.getMessage();
                Log.d(n, "handleSignInResult exception code=" + statusCode + " msg=" + message);
                a(((BaseSSOLoginActivity) this).f44810g, statusCode, message);
            }
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            SapiConfiguration sapiConfiguration = this.configuration;
            String urlBind = ParamsUtil.getUrlBind(sapiConfiguration, SocialType.GOOGLE, "", "", sapiConfiguration.googleClientId);
            HashMap hashMap = new HashMap();
            hashMap.put("supportGuestAccount", "1");
            hashMap.put("id_token", str);
            a(ParamsUtil.addExtras(urlBind, hashMap), getString(c.a.c0.a.j.a.sapi_sdk_google_loging));
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
            String idToken = lastSignedInAccount != null ? lastSignedInAccount.getIdToken() : null;
            if (!TextUtils.isEmpty(idToken)) {
                b(idToken);
            } else {
                startActivityForResult(GoogleSignIn.getClient(this, e()).getSignInIntent(), 1000);
            }
        }
    }

    private GoogleSignInOptions e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(this.configuration.googleClientId).build() : (GoogleSignInOptions) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 1000) {
                a(GoogleSignIn.getSignedInAccountFromIntent(intent));
            }
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
            setTitleText(c.a.c0.a.j.a.sapi_sdk_title_login_google);
            d();
        }
    }
}
