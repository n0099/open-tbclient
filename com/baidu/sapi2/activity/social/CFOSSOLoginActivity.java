package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.example.oauthsdk.CFOauth;
import com.example.oauthsdk.other.CFWebError;
import com.example.oauthsdk.widget.CFAuthCallback;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class CFOSSOLoginActivity extends BaseSSOLoginActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String n = "CFOSSOLoginActivity";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements CFAuthCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CFOSSOLoginActivity a;

        public a(CFOSSOLoginActivity cFOSSOLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cFOSSOLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cFOSSOLoginActivity;
        }

        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Log.e(CFOSSOLoginActivity.n, "用户取消授权");
                this.a.a(-301, "您已取消操作");
            }
        }

        public void onComplete(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                try {
                    String string = bundle.getString("code");
                    if (this.a.sapiWebView == null) {
                        this.a.a(-202, this.a.getString(R.string.obfuscated_res_0x7f0f1054));
                        return;
                    }
                    this.a.a(ParamsUtil.addExtras(ParamsUtil.getUrlCFOLogin(this.a.configuration, string), new HashMap()), "春风授权登录中");
                } catch (Exception unused) {
                    this.a.a(-205, "服务端数据异常，请稍后再试");
                }
            }
        }

        public void onError(CFWebError cFWebError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cFWebError) == null) {
                Log.e(CFOSSOLoginActivity.n, String.format("onError: [%s] %s", cFWebError.getErrorCode(), cFWebError.getMessage()));
                CFOSSOLoginActivity cFOSSOLoginActivity = this.a;
                cFOSSOLoginActivity.a(-202, cFOSSOLoginActivity.getString(R.string.obfuscated_res_0x7f0f1054));
            }
        }
    }

    public CFOSSOLoginActivity() {
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

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            CFOauth.getInstance().initCFOauth(this.configuration.cfoAppKey);
            if (this.configuration.cfoOpenDebugMode) {
                CFOauth.getInstance().openDebugMode();
            }
            CFOauth.getInstance().getCFAuthCode(this, new a(this));
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            setupViews();
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null) {
                sapiWebView.mIsCFProess = true;
            }
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.setupViews();
            setTitleText(R.string.obfuscated_res_0x7f0f1073);
            try {
                d();
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
