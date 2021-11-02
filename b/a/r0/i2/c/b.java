package b.a.r0.i2.c;

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
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.SapiUtils;
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
/* loaded from: classes4.dex */
public class b implements b.a.r0.i2.c.a, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LoginDialogActivity f17952e;

    /* renamed from: f  reason: collision with root package name */
    public View f17953f;

    /* renamed from: g  reason: collision with root package name */
    public View f17954g;

    /* renamed from: h  reason: collision with root package name */
    public View f17955h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f17956i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public int u;
    public String v;
    public String w;

    /* loaded from: classes4.dex */
    public class a extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17957a;

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
            this.f17957a = bVar;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                this.f17957a.f17952e.closeLoadingDialog();
                this.f17957a.f17952e.showToast(String.format(this.f17957a.f17952e.getString(R.string.onekey_login_fail), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
                this.f17957a.f17952e.passLoginFail();
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
                this.f17957a.f17952e.passLoginSucc();
                this.f17957a.f17952e.addLoginSuccessLog(DialogLoginHelper.DIALOG_TYPE_ONE_KEY);
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
        this.u = 0;
        this.v = str;
        this.w = str3;
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
            this.u = 1;
        } else if (c2 != 1) {
            this.u = 3;
        } else {
            this.u = 2;
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

    @Override // b.a.r0.i2.c.a
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, loginDialogActivity, viewGroup) == null) {
            this.f17952e = loginDialogActivity;
            View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.onekey_login_dialog_activity_layout, viewGroup, true);
            this.f17953f = inflate.findViewById(R.id.dialog_background);
            this.f17954g = inflate.findViewById(R.id.dialog_layout);
            this.f17955h = inflate.findViewById(R.id.close_btn_layout);
            this.f17956i = (ImageView) inflate.findViewById(R.id.close_btn_view);
            this.j = (TextView) inflate.findViewById(R.id.dialog_title);
            this.k = (TextView) inflate.findViewById(R.id.dialog_subtitle);
            this.l = (TextView) inflate.findViewById(R.id.user_number);
            this.m = (TextView) inflate.findViewById(R.id.login_btn);
            this.n = (TextView) inflate.findViewById(R.id.other_login_btn);
            this.o = (TextView) inflate.findViewById(R.id.tip_1);
            this.p = (TextView) inflate.findViewById(R.id.operator_text);
            this.q = (TextView) inflate.findViewById(R.id.tip_2);
            this.r = (TextView) inflate.findViewById(R.id.agreement_text);
            this.s = (TextView) inflate.findViewById(R.id.tip_3);
            this.t = (TextView) inflate.findViewById(R.id.privacy_text);
            this.f17953f.setOnClickListener(this);
            this.f17955h.setOnClickListener(this);
            this.f17956i.setOnClickListener(this);
            this.f17954g.setOnClickListener(this);
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
            LoginDialogActivity loginDialogActivity = this.f17952e;
            new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.onekey_login_dialog_activity_agreement_text), SwanAppPhoneLoginDialog.PASS_ACCOUNT_AGREE, false).start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17952e.passLoginCancel();
            this.f17952e.finish();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.l.setText(this.v);
            f(this.u);
        }
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 == 1) {
                this.p.setText(R.string.onekey_login_dialog_activity_operator_1);
            } else if (i2 == 2) {
                this.p.setText(R.string.onekey_login_dialog_activity_operator_2);
            } else if (i2 != 3) {
            } else {
                this.p.setText(R.string.onekey_login_dialog_activity_operator_3);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f17952e.showLoading();
            PassportSDK passportSDK = PassportSDK.getInstance();
            LoginDialogActivity loginDialogActivity = this.f17952e;
            passportSDK.loadOneKeyLogin(loginDialogActivity, h(loginDialogActivity, this.w), new a(this));
        }
    }

    @Override // b.a.r0.i2.c.a
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
            int i2 = this.u;
            if (i2 == 1) {
                LoginDialogActivity loginDialogActivity = this.f17952e;
                new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.onekey_login_dialog_activity_operator_1), "https://ms.zzx9.cn/html/oauth/protocol2.html", false).start();
            } else if (i2 == 2) {
                LoginDialogActivity loginDialogActivity2 = this.f17952e;
                new TbWebViewActivityConfig(loginDialogActivity2, loginDialogActivity2.getResources().getString(R.string.onekey_login_dialog_activity_operator_2), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false).start();
            } else if (i2 != 3) {
            } else {
                LoginDialogActivity loginDialogActivity3 = this.f17952e;
                new TbWebViewActivityConfig(loginDialogActivity3, loginDialogActivity3.getResources().getString(R.string.onekey_login_dialog_activity_operator_3), "https://wap.cmpassport.com/resources/html/contract.html", false).start();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f17952e.finish();
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.f17952e, true);
            loginActivityConfig.setLoginListener(this.f17952e.getLoginListener());
            loginActivityConfig.start();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LoginDialogActivity loginDialogActivity = this.f17952e;
            new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.onekey_login_dialog_activity_privacy_text), "http://privacy.baidu.com/mdetail?id=288", false).start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            int id = view.getId();
            if (id != R.id.dialog_background && id != R.id.close_btn_layout && id != R.id.close_btn_view) {
                if (id == R.id.login_btn) {
                    g();
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
                } else if (id == R.id.other_login_btn) {
                    j();
                    return;
                } else {
                    return;
                }
            }
            d();
        }
    }

    @Override // b.a.r0.i2.c.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f17954g, R.drawable.nav_bg_corner_shape, i2);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f17956i, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.j);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.k);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(this.l);
            d4.v(R.color.CAM_X0105);
            d4.z(R.dimen.T_X03);
            d4.A(R.string.F_X02);
            b.a.q0.s.u.c d5 = b.a.q0.s.u.c.d(this.n);
            d5.v(R.color.CAM_X0107);
            d5.z(R.dimen.T_X07);
            d5.A(R.string.F_X01);
            b.a.q0.s.u.c d6 = b.a.q0.s.u.c.d(this.m);
            d6.v(R.color.CAM_X0101);
            d6.z(R.dimen.T_X05);
            d6.A(R.string.F_X01);
            d6.n(R.string.J_X01);
            d6.f(R.color.CAM_X0302);
            b.a.q0.s.u.c d7 = b.a.q0.s.u.c.d(this.o);
            d7.v(R.color.CAM_X0108);
            d7.z(R.dimen.tbds29);
            d7.A(R.string.F_X01);
            b.a.q0.s.u.c d8 = b.a.q0.s.u.c.d(this.q);
            d8.v(R.color.CAM_X0108);
            d8.z(R.dimen.tbds29);
            d8.A(R.string.F_X01);
            b.a.q0.s.u.c d9 = b.a.q0.s.u.c.d(this.s);
            d9.v(R.color.CAM_X0108);
            d9.z(R.dimen.tbds29);
            d9.A(R.string.F_X01);
            b.a.q0.s.u.c d10 = b.a.q0.s.u.c.d(this.p);
            d10.v(R.color.CAM_X0302);
            d10.z(R.dimen.tbds29);
            d10.A(R.string.F_X01);
            b.a.q0.s.u.c d11 = b.a.q0.s.u.c.d(this.r);
            d11.v(R.color.CAM_X0302);
            d11.z(R.dimen.tbds29);
            d11.A(R.string.F_X01);
            b.a.q0.s.u.c d12 = b.a.q0.s.u.c.d(this.t);
            d12.v(R.color.CAM_X0302);
            d12.z(R.dimen.tbds29);
            d12.A(R.string.F_X01);
        }
    }
}
