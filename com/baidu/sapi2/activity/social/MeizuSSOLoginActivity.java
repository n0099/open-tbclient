package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import sdk.meizu.auth.MzAuthenticator;
import sdk.meizu.auth.OAuthError;
import sdk.meizu.auth.OAuthToken;
import sdk.meizu.auth.callback.ImplictCallback;
/* loaded from: classes2.dex */
public class MeizuSSOLoginActivity extends BaseSSOLoginActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a extends ImplictCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MeizuSSOLoginActivity a;

        public a(MeizuSSOLoginActivity meizuSSOLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {meizuSSOLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = meizuSSOLoginActivity;
        }

        public void onError(OAuthError oAuthError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oAuthError) == null) {
                MeizuSSOLoginActivity meizuSSOLoginActivity = this.a;
                meizuSSOLoginActivity.a(((BaseSSOLoginActivity) meizuSSOLoginActivity).g);
            }
        }

        public void onGetToken(OAuthToken oAuthToken) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oAuthToken) == null) {
                String accessToken = oAuthToken.getAccessToken();
                String openId = oAuthToken.getOpenId();
                if (!TextUtils.isEmpty(accessToken) && !TextUtils.isEmpty(openId)) {
                    this.a.a(ParamsUtil.getUrlBind(this.a.configuration, SocialType.MEIZU, accessToken, openId, null), "授权魅族帐号登录中");
                    return;
                }
                MeizuSSOLoginActivity meizuSSOLoginActivity = this.a;
                meizuSSOLoginActivity.a(((BaseSSOLoginActivity) meizuSSOLoginActivity).g);
            }
        }
    }

    public MeizuSSOLoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            setupViews();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.setupViews();
            setTitleText(R.string.obfuscated_res_0x7f0f1099);
            RelativeLayout relativeLayout = this.rootView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            try {
                new MzAuthenticator(this.configuration.mzAppID, this.configuration.meizuRedirectUri).requestImplictAuth(this, "uc_basic_info", new a(this));
            } catch (Exception e) {
                e.printStackTrace();
                finish();
            }
        }
    }
}
