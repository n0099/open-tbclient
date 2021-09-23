package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class FacebookSSOLoginActivity extends BaseSSOLoginActivity {
    public static /* synthetic */ Interceptable $ic;
    public static final String p;
    public transient /* synthetic */ FieldHolder $fh;
    public CallbackManager n;
    public LoginManager o;

    /* loaded from: classes5.dex */
    public class a implements FacebookCallback<LoginResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacebookSSOLoginActivity f44887a;

        public a(FacebookSSOLoginActivity facebookSSOLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facebookSSOLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44887a = facebookSSOLoginActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: a */
        public void onSuccess(LoginResult loginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, loginResult) == null) {
                Log.d(FacebookSSOLoginActivity.p, "facebook LoginManager login success");
                String token = loginResult.getAccessToken().getToken();
                String userId = loginResult.getAccessToken().getUserId();
                String applicationId = loginResult.getAccessToken().getApplicationId();
                String str = FacebookSSOLoginActivity.p;
                Log.d(str, "token = " + token);
                String str2 = FacebookSSOLoginActivity.p;
                Log.d(str2, "userId = " + userId);
                String str3 = FacebookSSOLoginActivity.p;
                Log.d(str3, "applicationId = " + applicationId);
                String urlBind = ParamsUtil.getUrlBind(this.f44887a.configuration, SocialType.FACEBOOK, token, userId, applicationId);
                HashMap hashMap = new HashMap();
                hashMap.put("supportGuestAccount", "1");
                String addExtras = ParamsUtil.addExtras(urlBind, hashMap);
                FacebookSSOLoginActivity facebookSSOLoginActivity = this.f44887a;
                facebookSSOLoginActivity.a(addExtras, facebookSSOLoginActivity.getString(c.a.c0.a.j.a.sapi_sdk_facebook_logging));
            }
        }

        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Log.d(FacebookSSOLoginActivity.p, "facebook LoginManager login cancel");
                FacebookSSOLoginActivity facebookSSOLoginActivity = this.f44887a;
                facebookSSOLoginActivity.a(((BaseSSOLoginActivity) facebookSSOLoginActivity).f44872g);
            }
        }

        public void onError(FacebookException facebookException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, facebookException) == null) {
                Log.d(FacebookSSOLoginActivity.p, "facebook LoginManager login error");
                FacebookSSOLoginActivity facebookSSOLoginActivity = this.f44887a;
                facebookSSOLoginActivity.a(((BaseSSOLoginActivity) facebookSSOLoginActivity).f44872g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1499497320, "Lcom/baidu/sapi2/activity/social/FacebookSSOLoginActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1499497320, "Lcom/baidu/sapi2/activity/social/FacebookSSOLoginActivity;");
                return;
            }
        }
        p = FacebookSSOLoginActivity.class.getSimpleName();
    }

    public FacebookSSOLoginActivity() {
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

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.n = CallbackManager.Factory.create();
            LoginManager loginManager = LoginManager.getInstance();
            this.o = loginManager;
            loginManager.setDefaultAudience(DefaultAudience.FRIENDS);
            this.o.setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK);
            this.o.setAuthType("rerequest");
            this.o.logInWithReadPermissions(this, Arrays.asList("public_profile"));
            LoginManager.getInstance().registerCallback(this.n, new a(this));
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            this.n.onActivityResult(i2, i3, intent);
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            e();
            setupViews();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.setupViews();
            setTitleText(c.a.c0.a.j.a.sapi_sdk_title_login_facebook);
            RelativeLayout relativeLayout = this.rootView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
        }
    }
}
