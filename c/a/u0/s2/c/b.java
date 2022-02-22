package c.a.u0.s2.c;

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
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
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
/* loaded from: classes8.dex */
public class b implements c.a.u0.s2.c.a, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;

    /* renamed from: e  reason: collision with root package name */
    public LoginDialogActivity f21876e;

    /* renamed from: f  reason: collision with root package name */
    public View f21877f;

    /* renamed from: g  reason: collision with root package name */
    public View f21878g;

    /* renamed from: h  reason: collision with root package name */
    public View f21879h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f21880i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f21881j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public View o;
    public View p;
    public View q;
    public View r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public int z;

    /* loaded from: classes8.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.f21876e.closeLoadingDialog();
                this.a.f21876e.showToast(String.format(this.a.f21876e.getString(R.string.onekey_login_fail), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
                this.a.f21876e.passLoginFail();
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
                this.a.f21876e.passLoginSucc();
                this.a.f21876e.addLoginSuccessLog(DialogLoginHelper.DIALOG_TYPE_ONE_KEY);
            }
        }
    }

    /* renamed from: c.a.u0.s2.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1349b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SocialType f21882e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f21883f;

        public C1349b(b bVar, SocialType socialType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, socialType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21883f = bVar;
            this.f21882e = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
                this.f21883f.f21876e.showLoading();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                this.f21883f.f21876e.closeLoadingDialog();
                this.f21883f.f21876e.showToast(String.format(this.f21883f.f21876e.getString(R.string.third_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.f21883f.f21876e.passLoginFail();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                this.f21883f.f21876e.passLoginSucc();
                this.f21883f.f21876e.addLoginSuccessLog(this.f21882e.name().toLowerCase());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        char c2 = 0;
        this.z = 0;
        this.A = str;
        this.B = str3;
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
            this.z = 1;
        } else if (c2 != 1) {
            this.z = 3;
        } else {
            this.z = 2;
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

    @Override // c.a.u0.s2.c.a
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, loginDialogActivity, viewGroup) == null) {
            this.f21876e = loginDialogActivity;
            View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.onekey_login_dialog_activity_layout, viewGroup, true);
            this.f21877f = inflate.findViewById(R.id.dialog_background);
            this.f21878g = inflate.findViewById(R.id.dialog_layout);
            this.f21879h = inflate.findViewById(R.id.close_btn_layout);
            this.f21880i = (ImageView) inflate.findViewById(R.id.close_btn_view);
            this.f21881j = (TextView) inflate.findViewById(R.id.dialog_title);
            this.k = (TextView) inflate.findViewById(R.id.dialog_subtitle);
            this.l = (TextView) inflate.findViewById(R.id.user_number);
            this.m = (TextView) inflate.findViewById(R.id.login_btn);
            this.n = inflate.findViewById(R.id.qq_login_btn);
            this.o = inflate.findViewById(R.id.wechat_login_btn);
            this.p = inflate.findViewById(R.id.weibo_login_btn);
            this.q = inflate.findViewById(R.id.yy_login_btn);
            this.r = inflate.findViewById(R.id.more_login_btn);
            this.s = (TextView) inflate.findViewById(R.id.tip_1);
            this.t = (TextView) inflate.findViewById(R.id.operator_text);
            this.u = (TextView) inflate.findViewById(R.id.tip_2);
            this.v = (TextView) inflate.findViewById(R.id.agreement_text);
            this.w = (TextView) inflate.findViewById(R.id.tip_3);
            this.x = (TextView) inflate.findViewById(R.id.privacy_text);
            this.y = (TextView) inflate.findViewById(R.id.tip_4);
            this.f21877f.setOnClickListener(this);
            this.f21879h.setOnClickListener(this);
            this.f21880i.setOnClickListener(this);
            this.f21878g.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.v.setOnClickListener(this);
            this.x.setOnClickListener(this);
            e();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LoginDialogActivity loginDialogActivity = this.f21876e;
            new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.onekey_login_dialog_activity_agreement_text), SwanAppPhoneLoginDialog.PASS_ACCOUNT_AGREE, false).start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21876e.passLoginCancel();
            this.f21876e.finish();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.l.setText(this.A);
            f(this.z);
        }
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 == 1) {
                this.t.setText(R.string.onekey_login_dialog_activity_operator_1);
            } else if (i2 == 2) {
                this.t.setText(R.string.onekey_login_dialog_activity_operator_2);
            } else if (i2 != 3) {
            } else {
                this.t.setText(R.string.onekey_login_dialog_activity_operator_3);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f21876e.showLoading();
            PassportSDK passportSDK = PassportSDK.getInstance();
            LoginDialogActivity loginDialogActivity = this.f21876e;
            passportSDK.loadOneKeyLogin(loginDialogActivity, h(loginDialogActivity, this.B), new a(this));
        }
    }

    @Override // c.a.u0.s2.c.a
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
            int i2 = this.z;
            if (i2 == 1) {
                LoginDialogActivity loginDialogActivity = this.f21876e;
                new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.onekey_login_dialog_activity_operator_1), "https://ms.zzx9.cn/html/oauth/protocol2.html", false).start();
            } else if (i2 == 2) {
                LoginDialogActivity loginDialogActivity2 = this.f21876e;
                new TbWebViewActivityConfig(loginDialogActivity2, loginDialogActivity2.getResources().getString(R.string.onekey_login_dialog_activity_operator_2), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false).start();
            } else if (i2 != 3) {
            } else {
                LoginDialogActivity loginDialogActivity3 = this.f21876e;
                new TbWebViewActivityConfig(loginDialogActivity3, loginDialogActivity3.getResources().getString(R.string.onekey_login_dialog_activity_operator_3), "https://wap.cmpassport.com/resources/html/contract.html", false).start();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f21876e.finish();
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.f21876e, true);
            loginActivityConfig.setLoginListener(this.f21876e.getLoginListener());
            loginActivityConfig.setFrom(this.f21876e.getPreExtraPageKey());
            loginActivityConfig.setFromDialog("onkey_more");
            loginActivityConfig.start();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LoginDialogActivity loginDialogActivity = this.f21876e;
            new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.onekey_login_dialog_activity_privacy_text), "http://privacy.baidu.com/mdetail?id=288", false).start();
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
            PassportSDK.getInstance().loadThirdPartyLogin(new C1349b(this, socialType), socialType);
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
            if (id != R.id.dialog_background && id != R.id.close_btn_layout && id != R.id.close_btn_view) {
                if (id == R.id.login_btn) {
                    g();
                    return;
                } else if (id == R.id.qq_login_btn) {
                    l();
                    return;
                } else if (id == R.id.wechat_login_btn) {
                    n();
                    return;
                } else if (id == R.id.weibo_login_btn) {
                    o();
                    return;
                } else if (id == R.id.yy_login_btn) {
                    p();
                    return;
                } else if (id == R.id.more_login_btn) {
                    j();
                    return;
                } else if (id == R.id.operator_text) {
                    i();
                    return;
                } else if (id == R.id.agreement_text) {
                    c();
                    return;
                } else if (id == R.id.privacy_text) {
                    k();
                    return;
                } else {
                    return;
                }
            }
            d();
        }
    }

    @Override // c.a.u0.s2.c.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f21878g, R.drawable.nav_bg_corner_shape, i2);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21880i, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this.f21881j);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
            c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(this.k);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            c.a.t0.s.v.c d4 = c.a.t0.s.v.c.d(this.l);
            d4.v(R.color.CAM_X0105);
            d4.z(R.dimen.T_X03);
            d4.A(R.string.F_X02);
            c.a.t0.s.v.c d5 = c.a.t0.s.v.c.d(this.m);
            d5.v(R.color.CAM_X0101);
            d5.z(R.dimen.T_X05);
            d5.A(R.string.F_X01);
            d5.n(R.string.J_X01);
            d5.f(R.color.CAM_X0302);
            c.a.t0.s.v.c d6 = c.a.t0.s.v.c.d(this.s);
            d6.v(R.color.CAM_X0108);
            d6.z(R.dimen.T_X08);
            d6.A(R.string.F_X01);
            c.a.t0.s.v.c d7 = c.a.t0.s.v.c.d(this.u);
            d7.v(R.color.CAM_X0108);
            d7.z(R.dimen.T_X08);
            d7.A(R.string.F_X01);
            c.a.t0.s.v.c d8 = c.a.t0.s.v.c.d(this.w);
            d8.v(R.color.CAM_X0108);
            d8.z(R.dimen.T_X08);
            d8.A(R.string.F_X01);
            c.a.t0.s.v.c d9 = c.a.t0.s.v.c.d(this.y);
            d9.v(R.color.CAM_X0108);
            d9.z(R.dimen.T_X08);
            d9.A(R.string.F_X01);
            c.a.t0.s.v.c d10 = c.a.t0.s.v.c.d(this.t);
            d10.v(R.color.CAM_X0108);
            d10.z(R.dimen.T_X08);
            d10.A(R.string.F_X02);
            c.a.t0.s.v.c d11 = c.a.t0.s.v.c.d(this.v);
            d11.v(R.color.CAM_X0108);
            d11.z(R.dimen.T_X08);
            d11.A(R.string.F_X02);
            c.a.t0.s.v.c d12 = c.a.t0.s.v.c.d(this.x);
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
