package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class WXLoginActivity extends BaseSSOLoginActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String q;
    public static final String r = "from_wx_auth";
    public static final String s = "state";
    public static final String t = "code";
    public static final String u = "error_code";
    public static int v;
    public static String w;
    public static boolean x;
    public transient /* synthetic */ FieldHolder $fh;
    public String n;
    public String o;
    public int p;

    /* loaded from: classes2.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WXLoginActivity a;

        public a(WXLoginActivity wXLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wXLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wXLoginActivity;
        }

        @Override // com.baidu.sapi2.activity.social.WXLoginActivity.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast.makeText(this.a, "微信未安装", 1).show();
                this.a.a(WXLoginActivity.v);
            }
        }

        @Override // com.baidu.sapi2.activity.social.WXLoginActivity.b
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void onFinish();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-761459688, "Lcom/baidu/sapi2/activity/social/WXLoginActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-761459688, "Lcom/baidu/sapi2/activity/social/WXLoginActivity;");
                return;
            }
        }
        q = WXLoginActivity.class.getSimpleName();
    }

    public WXLoginActivity() {
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

    private void b(int i, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65539, this, i, intent) == null) || SocialLoginBase.getWXinvokeCallback() == null) {
            return;
        }
        SocialLoginBase.getWXinvokeCallback().onResult(i, intent);
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            ((BaseSSOLoginActivity) this).g = v;
            ((BaseSSOLoginActivity) this).e = w;
            ((BaseSSOLoginActivity) this).f = x;
            w = null;
            x = false;
            this.o = getIntent().getStringExtra("code");
            this.n = getIntent().getStringExtra("state");
            int intExtra = getIntent().getIntExtra("error_code", -1);
            this.p = intExtra;
            if (((BaseSSOLoginActivity) this).f) {
                Intent intent = new Intent();
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_AUTHORIZATION_CODE, this.o);
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.QQ_SSO.getType()));
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, ThirdPartyUtil.TYPE_WEIXIN);
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().wxAppID);
                a(3001, intent);
                finish();
            } else if (intExtra == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("wxRespCode", this.o);
                hashMap.put("wxRespState", this.n);
                StatService.onEventAutoStat("third_login_wx_result", hashMap);
                if (TextUtils.equals(ThirdPartyUtil.wxAuthCodeMap.get(this.o), this.n)) {
                    return;
                }
                ThirdPartyUtil.wxAuthCodeMap.put(this.o, this.n);
                a(ParamsUtil.getUrlWeixinBind(this.configuration, this.o, this.n, false), "授权微信帐号登录中");
            } else {
                a(v);
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            setupViews();
            setTitleText("微信帐号登录");
            RelativeLayout relativeLayout = this.rootView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            if (!getIntent().getBooleanExtra(r, false)) {
                v = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
                w = ((BaseSSOLoginActivity) this).e;
                x = ((BaseSSOLoginActivity) this).f;
                a(new a(this));
                return;
            }
            e();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.a(i);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            f();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void setPageAnim(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void a(int i, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, intent) == null) {
            super.a(i, intent);
            b(i, intent);
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.b(i);
            b(i, (Intent) null);
        }
    }

    private void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, bVar) == null) {
            try {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.configuration.context, this.configuration.wxAppID);
                if (!createWXAPI.isWXAppInstalled()) {
                    bVar.a();
                    return;
                }
                bVar.onFinish();
                SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                createWXAPI.sendReq(req);
            } catch (Exception e) {
                e.printStackTrace();
                finish();
            }
        }
    }
}
