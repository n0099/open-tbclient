package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.br9;
import com.repackage.cr9;
import com.repackage.dr9;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class YYSSOLoginActivity extends BaseSSOLoginActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String q = "YYSSOLoginActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public dr9 n;
    public String o;
    public br9 p;

    /* loaded from: classes2.dex */
    public class a implements br9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYSSOLoginActivity a;

        public a(YYSSOLoginActivity yYSSOLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYSSOLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYSSOLoginActivity;
        }

        @Override // com.repackage.br9
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Log.d(YYSSOLoginActivity.q, "YY授权登录 已取消");
                YYSSOLoginActivity yYSSOLoginActivity = this.a;
                yYSSOLoginActivity.a(((BaseSSOLoginActivity) yYSSOLoginActivity).g, -1000, AbstractThirdPartyService.RESULT_AUTH_CANCEL_MSG);
            }
        }

        @Override // com.repackage.br9
        public void onComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                Log.d(YYSSOLoginActivity.q, "onComplete " + jSONObject.toString());
                if (jSONObject != null) {
                    if (jSONObject.has("access_code")) {
                        this.a.o = jSONObject.optString("access_code");
                    } else if (jSONObject.has("token")) {
                        this.a.o = jSONObject.optString("token");
                    }
                }
                if (!TextUtils.isEmpty(this.a.o)) {
                    Log.d(YYSSOLoginActivity.q, "accessCode=" + this.a.o);
                    this.a.d();
                    return;
                }
                YYSSOLoginActivity yYSSOLoginActivity = this.a;
                yYSSOLoginActivity.a(((BaseSSOLoginActivity) yYSSOLoginActivity).g, -1, "未知错误");
            }
        }

        @Override // com.repackage.br9
        public void onError(cr9 cr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cr9Var) == null) {
                Log.d(YYSSOLoginActivity.q, "onError " + cr9Var.a + " " + cr9Var.b);
                YYSSOLoginActivity yYSSOLoginActivity = this.a;
                yYSSOLoginActivity.a(((BaseSSOLoginActivity) yYSSOLoginActivity).g, cr9Var.a, cr9Var.b);
            }
        }
    }

    public YYSSOLoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            a(ParamsUtil.getUrlYYLogin(this.o, SapiAccountManager.getInstance().getConfignation()), "授权YY账号登录中");
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            this.n.c(i, i2, intent, this.p);
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setupViews();
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation != null && !TextUtils.isEmpty(confignation.yyAppId)) {
                try {
                    dr9 b = dr9.b(getApplicationContext(), confignation.yyAppId);
                    this.n = b;
                    b.a(this, this.p);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            a(((BaseSSOLoginActivity) this).g, -10, AbstractThirdPartyService.RESULT_AUTH_UNSUPPORT_MSG);
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.setupViews();
            setTitleText("YY授权登录");
        }
    }
}
