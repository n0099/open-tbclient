package c.a.p0.u2.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b implements c.a.p0.u2.c.a, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LoginDialogActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f18969b;

    /* renamed from: c  reason: collision with root package name */
    public View f18970c;

    /* renamed from: d  reason: collision with root package name */
    public View f18971d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f18972e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18973f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18974g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18975h;
    public TextView i;
    public View j;
    public View k;
    public View l;
    public View m;
    public View n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public int v;
    public String w;
    public String x;

    /* loaded from: classes2.dex */
    public class a extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                this.a.a.closeLoadingDialog();
                this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f0cc0), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
                this.a.a.passLoginFail();
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oneKeyLoginResult) == null) {
                this.a.a.passLoginSucc();
                this.a.a.addLoginSuccessLog(DialogLoginHelper.DIALOG_TYPE_ONE_KEY);
            }
        }
    }

    /* renamed from: c.a.p0.u2.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1433b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SocialType a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f18976b;

        public C1433b(b bVar, SocialType socialType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, socialType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18976b = bVar;
            this.a = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
                this.f18976b.a.showLoading();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                this.f18976b.a.closeLoadingDialog();
                this.f18976b.a.showToast(String.format(this.f18976b.a.getString(R.string.obfuscated_res_0x7f0f138e), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.f18976b.a.passLoginFail();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                this.f18976b.a.passLoginSucc();
                this.f18976b.a.addLoginSuccessLog(this.a.name().toLowerCase());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r7.equals(com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        char c2 = 0;
        this.v = 0;
        this.w = str;
        this.x = str3;
        int hashCode = str2.hashCode();
        if (hashCode == 2154) {
            if (str2.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 2161) {
            if (hashCode == 2162) {
            }
            c2 = 65535;
        } else {
            if (str2.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC)) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            this.v = 1;
        } else if (c2 != 1) {
            this.v = 3;
        } else {
            this.v = 2;
        }
    }

    public static String h(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, activity, str)) == null) {
            if (TextUtils.isEmpty(str) || str.length() <= 7) {
                return null;
            }
            String substring = str.substring(0, 8);
            String substring2 = str.substring(8, str.length());
            String upperCase = SapiUtils.getClientId(activity).toUpperCase();
            return substring + MD5Util.toMd5((substring2 + MD5Util.toMd5(upperCase.getBytes(), false)).getBytes(), false);
        }
        return (String) invokeLL.objValue;
    }

    @Override // c.a.p0.u2.c.a
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, loginDialogActivity, viewGroup) == null) {
            this.a = loginDialogActivity;
            View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.obfuscated_res_0x7f0d0649, viewGroup, true);
            this.f18969b = inflate.findViewById(R.id.obfuscated_res_0x7f090791);
            this.f18970c = inflate.findViewById(R.id.obfuscated_res_0x7f0907aa);
            this.f18971d = inflate.findViewById(R.id.obfuscated_res_0x7f090669);
            this.f18972e = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09066a);
            this.f18973f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0907b6);
            this.f18974g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0907b4);
            this.f18975h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0922c2);
            this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091336);
            this.j = inflate.findViewById(R.id.obfuscated_res_0x7f091990);
            this.k = inflate.findViewById(R.id.obfuscated_res_0x7f09245d);
            this.l = inflate.findViewById(R.id.obfuscated_res_0x7f092460);
            this.m = inflate.findViewById(R.id.obfuscated_res_0x7f0924cd);
            this.n = inflate.findViewById(R.id.obfuscated_res_0x7f09144a);
            this.o = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092006);
            this.p = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09160d);
            this.q = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092007);
            this.r = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090167);
            this.s = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092008);
            this.t = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918f7);
            this.u = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092009);
            this.f18969b.setOnClickListener(this);
            this.f18971d.setOnClickListener(this);
            this.f18972e.setOnClickListener(this);
            this.f18970c.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.t.setOnClickListener(this);
            e();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LoginDialogActivity loginDialogActivity = this.a;
            new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0cb7), "https://passport.baidu.com/static/passpc-account/html/protocal.html", false).start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.passLoginCancel();
            this.a.finish();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f18975h.setText(this.w);
            f(this.v);
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i == 1) {
                this.p.setText(R.string.obfuscated_res_0x7f0f0cb8);
            } else if (i == 2) {
                this.p.setText(R.string.obfuscated_res_0x7f0f0cb9);
            } else if (i != 3) {
            } else {
                this.p.setText(R.string.obfuscated_res_0x7f0f0cba);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.showLoading();
            PassportSDK passportSDK = PassportSDK.getInstance();
            LoginDialogActivity loginDialogActivity = this.a;
            passportSDK.loadOneKeyLogin(loginDialogActivity, h(loginDialogActivity, this.x), new a(this));
        }
    }

    @Override // c.a.p0.u2.c.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.v;
            if (i == 1) {
                LoginDialogActivity loginDialogActivity = this.a;
                new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0cb8), "https://ms.zzx9.cn/html/oauth/protocol2.html", false).start();
            } else if (i == 2) {
                LoginDialogActivity loginDialogActivity2 = this.a;
                new TbWebViewActivityConfig(loginDialogActivity2, loginDialogActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0cb9), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false).start();
            } else if (i != 3) {
            } else {
                LoginDialogActivity loginDialogActivity3 = this.a;
                new TbWebViewActivityConfig(loginDialogActivity3, loginDialogActivity3.getResources().getString(R.string.obfuscated_res_0x7f0f0cba), "https://wap.cmpassport.com/resources/html/contract.html", false).start();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.finish();
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.a, true);
            loginActivityConfig.setLoginListener(this.a.getLoginListener());
            loginActivityConfig.setFrom(this.a.getPreExtraPageKey());
            loginActivityConfig.setFromDialog("onkey_more");
            loginActivityConfig.start();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LoginDialogActivity loginDialogActivity = this.a;
            new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0cbb), "http://privacy.baidu.com/mdetail?id=288", false).start();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            m(SocialType.QQ_SSO);
        }
    }

    public final void m(SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, socialType) == null) {
            PassportSDK.getInstance().loadThirdPartyLogin(new C1433b(this, socialType), socialType);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            m(SocialType.WEIXIN);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            m(SocialType.SINA_WEIBO_SSO);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            int id = view.getId();
            if (id == R.id.obfuscated_res_0x7f090791 || id == R.id.obfuscated_res_0x7f090669 || id == R.id.obfuscated_res_0x7f09066a) {
                d();
            } else if (id == R.id.obfuscated_res_0x7f091336) {
                g();
            } else if (id == R.id.obfuscated_res_0x7f091990) {
                l();
            } else if (id == R.id.obfuscated_res_0x7f09245d) {
                n();
            } else if (id == R.id.obfuscated_res_0x7f092460) {
                o();
            } else if (id == R.id.obfuscated_res_0x7f0924cd) {
                p();
            } else if (id == R.id.obfuscated_res_0x7f09144a) {
                j();
            } else if (id == R.id.obfuscated_res_0x7f09160d) {
                i();
            } else if (id == R.id.obfuscated_res_0x7f090167) {
                c();
            } else if (id == R.id.obfuscated_res_0x7f0918f7) {
                k();
            }
        }
    }

    @Override // c.a.p0.u2.c.a
    public void onViewChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            SkinManager.setBackgroundResource(this.f18970c, R.drawable.nav_bg_corner_shape, i);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f18972e, R.drawable.obfuscated_res_0x7f0808f1, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f18973f);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.f18974g);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.f18975h);
            d4.v(R.color.CAM_X0105);
            d4.z(R.dimen.T_X03);
            d4.A(R.string.F_X02);
            c.a.o0.r.v.c d5 = c.a.o0.r.v.c.d(this.i);
            d5.v(R.color.CAM_X0101);
            d5.z(R.dimen.T_X05);
            d5.A(R.string.F_X01);
            d5.n(R.string.J_X01);
            d5.f(R.color.CAM_X0302);
            c.a.o0.r.v.c d6 = c.a.o0.r.v.c.d(this.o);
            d6.v(R.color.CAM_X0108);
            d6.z(R.dimen.T_X08);
            d6.A(R.string.F_X01);
            c.a.o0.r.v.c d7 = c.a.o0.r.v.c.d(this.q);
            d7.v(R.color.CAM_X0108);
            d7.z(R.dimen.T_X08);
            d7.A(R.string.F_X01);
            c.a.o0.r.v.c d8 = c.a.o0.r.v.c.d(this.s);
            d8.v(R.color.CAM_X0108);
            d8.z(R.dimen.T_X08);
            d8.A(R.string.F_X01);
            c.a.o0.r.v.c d9 = c.a.o0.r.v.c.d(this.u);
            d9.v(R.color.CAM_X0108);
            d9.z(R.dimen.T_X08);
            d9.A(R.string.F_X01);
            c.a.o0.r.v.c d10 = c.a.o0.r.v.c.d(this.p);
            d10.v(R.color.CAM_X0108);
            d10.z(R.dimen.T_X08);
            d10.A(R.string.F_X02);
            c.a.o0.r.v.c d11 = c.a.o0.r.v.c.d(this.r);
            d11.v(R.color.CAM_X0108);
            d11.z(R.dimen.T_X08);
            d11.A(R.string.F_X02);
            c.a.o0.r.v.c d12 = c.a.o0.r.v.c.d(this.t);
            d12.v(R.color.CAM_X0108);
            d12.z(R.dimen.T_X08);
            d12.A(R.string.F_X02);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            m(SocialType.YY);
        }
    }
}
