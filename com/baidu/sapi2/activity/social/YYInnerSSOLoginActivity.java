package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class YYInnerSSOLoginActivity extends BaseSSOLoginActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String o = "accessCode";
    public transient /* synthetic */ FieldHolder $fh;
    public String n;

    public YYInnerSSOLoginActivity() {
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
            String stringExtra = getIntent().getStringExtra(o);
            this.n = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
                if (webAuthListener != null) {
                    WebAuthResult webAuthResult = new WebAuthResult();
                    webAuthResult.setResultCode(SapiErrorCode.ACCESS_CODE_EMPTY);
                    webAuthListener.onFailure(webAuthResult);
                }
                finish();
                return;
            }
            a(ParamsUtil.getUrlYYLogin(this.n, SapiAccountManager.getInstance().getConfignation()), "YY账号登录中");
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.setupViews();
            setTitleText("YY登录");
        }
    }
}
