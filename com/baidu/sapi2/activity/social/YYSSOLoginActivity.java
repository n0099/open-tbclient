package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.r.b.b;
import c.r.b.c;
import c.r.b.d;
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
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YYSSOLoginActivity extends BaseSSOLoginActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String q = "YYSSOLoginActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public d n;
    public String o;
    public b p;

    /* loaded from: classes4.dex */
    public class a implements b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYSSOLoginActivity;
        }

        @Override // c.r.b.b
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Log.d(YYSSOLoginActivity.q, "YY授权登录 已取消");
                YYSSOLoginActivity yYSSOLoginActivity = this.a;
                yYSSOLoginActivity.a(((BaseSSOLoginActivity) yYSSOLoginActivity).f36710g, -1000, AbstractThirdPartyService.RESULT_AUTH_CANCEL_MSG);
            }
        }

        @Override // c.r.b.b
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
                yYSSOLoginActivity.a(((BaseSSOLoginActivity) yYSSOLoginActivity).f36710g, -1, "未知错误");
            }
        }

        @Override // c.r.b.b
        public void onError(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
                Log.d(YYSSOLoginActivity.q, "onError " + cVar.a + " " + cVar.f29191b);
                YYSSOLoginActivity yYSSOLoginActivity = this.a;
                yYSSOLoginActivity.a(((BaseSSOLoginActivity) yYSSOLoginActivity).f36710g, cVar.a, cVar.f29191b);
            }
        }
    }

    public YYSSOLoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            this.n.c(i2, i3, intent, this.p);
            super.onActivityResult(i2, i3, intent);
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
                    d b2 = d.b(getApplicationContext(), confignation.yyAppId);
                    this.n = b2;
                    b2.a(this, this.p);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            a(((BaseSSOLoginActivity) this).f36710g, -10, AbstractThirdPartyService.RESULT_AUTH_UNSUPPORT_MSG);
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
