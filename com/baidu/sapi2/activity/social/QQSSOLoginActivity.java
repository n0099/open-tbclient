package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class QQSSOLoginActivity extends QQOauthLoginActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String r = "QQSSOLoginActivity";
    public transient /* synthetic */ FieldHolder $fh;

    public QQSSOLoginActivity() {
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

    @Override // com.baidu.sapi2.activity.social.QQOauthLoginActivity, com.baidu.sapi2.a.a.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (((BaseSSOLoginActivity) this).f39193f) {
                b(3001);
                finish();
                return;
            }
            a(((BaseSSOLoginActivity) this).f39194g);
        }
    }

    @Override // com.baidu.sapi2.activity.social.QQOauthLoginActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (((BaseSSOLoginActivity) this).f39193f && i2 == 11101 && i3 == 0) {
                b(3001);
                finish();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.social.QQOauthLoginActivity, com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.setupViews();
            setTitleText("QQ帐号登录");
            RelativeLayout relativeLayout = this.rootView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.social.QQOauthLoginActivity, com.baidu.sapi2.a.a.a
    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            if (((BaseSSOLoginActivity) this).f39193f) {
                Intent intent = new Intent();
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, str);
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str2);
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_UNION_ID, str3);
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.QQ_SSO.getType()));
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, "qzone");
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().qqAppID);
                a(3001, intent);
                finish();
                return;
            }
            a(ParamsUtil.getUrlQQBind(this.configuration, str, str2, str3), "授权QQ账号登录中");
        }
    }
}
