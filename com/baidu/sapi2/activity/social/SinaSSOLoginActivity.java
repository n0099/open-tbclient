package com.baidu.sapi2.activity.social;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
/* loaded from: classes2.dex */
public class SinaSSOLoginActivity extends BaseSSOLoginActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String p;
    public static final int q = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public SsoHandler n;
    public WbAuthListener o;

    /* loaded from: classes2.dex */
    public class a implements WbAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SinaSSOLoginActivity a;

        public a(SinaSSOLoginActivity sinaSSOLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sinaSSOLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sinaSSOLoginActivity;
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SinaSSOLoginActivity sinaSSOLoginActivity = this.a;
                if (((BaseSSOLoginActivity) sinaSSOLoginActivity).f) {
                    sinaSSOLoginActivity.b(3001);
                    this.a.finish();
                    return;
                }
                sinaSSOLoginActivity.a(((BaseSSOLoginActivity) sinaSSOLoginActivity).g);
            }
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wbConnectErrorMessage) == null) {
                Toast.makeText(this.a, wbConnectErrorMessage.getErrorMessage(), 0).show();
                SinaSSOLoginActivity sinaSSOLoginActivity = this.a;
                if (((BaseSSOLoginActivity) sinaSSOLoginActivity).f) {
                    sinaSSOLoginActivity.b(3001);
                    this.a.finish();
                }
            }
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oauth2AccessToken) == null) {
                String token = oauth2AccessToken.getToken();
                String uid = oauth2AccessToken.getUid();
                String urlBind = ParamsUtil.getUrlBind(this.a.configuration, SocialType.SINA_WEIBO_SSO, token, uid, this.a.configuration.sinaAppId);
                SinaSSOLoginActivity sinaSSOLoginActivity = this.a;
                if (((BaseSSOLoginActivity) sinaSSOLoginActivity).f) {
                    Intent intent = new Intent();
                    intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, token);
                    intent.putExtra("userId", uid);
                    intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.SINA_WEIBO_SSO.getType()));
                    intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, "tsina");
                    intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().sinaAppId);
                    this.a.a(3001, intent);
                    this.a.finish();
                    return;
                }
                sinaSSOLoginActivity.a(urlBind, "授权微博帐号登录中");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(832982325, "Lcom/baidu/sapi2/activity/social/SinaSSOLoginActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(832982325, "Lcom/baidu/sapi2/activity/social/SinaSSOLoginActivity;");
                return;
            }
        }
        p = SinaSSOLoginActivity.class.getSimpleName();
    }

    public SinaSSOLoginActivity() {
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

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.o = null;
            super.finish();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, intent) == null) {
            String str = p;
            Log.d(str, "requestCode = " + i + " resultCode = " + i2 + " data = " + intent);
            super.onActivityResult(i, i2, intent);
            this.n.authorizeCallBack(i, i2, intent);
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                setupViews();
            } catch (Exception e) {
                e.printStackTrace();
                finish();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.setupViews();
            setTitleText(R.string.obfuscated_res_0x7f0f1078);
            RelativeLayout relativeLayout = this.rootView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            Context applicationContext = getApplicationContext();
            Context applicationContext2 = getApplicationContext();
            SapiConfiguration sapiConfiguration = this.configuration;
            WbSdk.install(applicationContext, new AuthInfo(applicationContext2, sapiConfiguration.sinaAppId, sapiConfiguration.sinaRedirectUri, "email"));
            this.n = new SsoHandler(this);
            a aVar = new a(this);
            this.o = aVar;
            this.n.authorize(aVar);
        }
    }
}
