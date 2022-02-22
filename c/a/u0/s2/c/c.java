package c.a.u0.s2.c;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
/* loaded from: classes8.dex */
public class c implements c.a.u0.s2.c.a, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LoginDialogActivity f21884e;

    /* renamed from: f  reason: collision with root package name */
    public View f21885f;

    /* renamed from: g  reason: collision with root package name */
    public View f21886g;

    /* renamed from: h  reason: collision with root package name */
    public View f21887h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f21888i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f21889j;
    public TextView k;
    public View l;
    public TbImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public View q;
    public View r;
    public View s;
    public View t;
    public View u;
    public final ShareStorage.StorageModel v;

    /* loaded from: classes8.dex */
    public class a extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21890e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21890e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                this.f21890e.f21884e.showToast(String.format(this.f21890e.f21884e.getString(R.string.share_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.f21890e.f21884e.passLoginFail();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                this.f21890e.f21884e.passLoginSucc();
                this.f21890e.f21884e.addLoginSuccessLog(DialogLoginHelper.DIALOG_TYPE_SHARE);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SocialType f21891e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f21892f;

        public b(c cVar, SocialType socialType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, socialType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21892f = cVar;
            this.f21891e = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
                this.f21892f.f21884e.showLoading();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                this.f21892f.f21884e.closeLoadingDialog();
                this.f21892f.f21884e.showToast(String.format(this.f21892f.f21884e.getString(R.string.third_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.f21892f.f21884e.passLoginFail();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                this.f21892f.f21884e.passLoginSucc();
                this.f21892f.f21884e.addLoginSuccessLog(this.f21891e.name().toLowerCase());
            }
        }
    }

    public c(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = (ShareStorage.StorageModel) new Gson().fromJson(str, (Class<Object>) ShareStorage.StorageModel.class);
    }

    @Override // c.a.u0.s2.c.a
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, loginDialogActivity, viewGroup) == null) {
            this.f21884e = loginDialogActivity;
            View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.share_login_dialog_activity_layout, viewGroup, true);
            this.f21885f = inflate.findViewById(R.id.dialog_background);
            this.f21886g = inflate.findViewById(R.id.dialog_layout);
            this.f21887h = inflate.findViewById(R.id.close_btn_layout);
            this.f21888i = (ImageView) inflate.findViewById(R.id.close_btn_view);
            this.f21889j = (TextView) inflate.findViewById(R.id.dialog_title);
            this.k = (TextView) inflate.findViewById(R.id.dialog_subtitle);
            this.l = inflate.findViewById(R.id.user_info_layout);
            this.m = (TbImageView) inflate.findViewById(R.id.user_avatar);
            this.n = (TextView) inflate.findViewById(R.id.user_name);
            this.o = (TextView) inflate.findViewById(R.id.user_subtitle);
            this.p = (TextView) inflate.findViewById(R.id.login_btn);
            this.q = inflate.findViewById(R.id.qq_login_btn);
            this.r = inflate.findViewById(R.id.wechat_login_btn);
            this.s = inflate.findViewById(R.id.weibo_login_btn);
            this.t = inflate.findViewById(R.id.yy_login_btn);
            this.u = inflate.findViewById(R.id.more_login_btn);
            this.f21885f.setOnClickListener(this);
            this.f21887h.setOnClickListener(this);
            this.f21888i.setOnClickListener(this);
            this.f21886g.setOnClickListener(this);
            this.m.setIsRound(true);
            this.m.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.u.setOnClickListener(this);
            d();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21884e.passLoginCancel();
            this.f21884e.finish();
        }
    }

    public final void d() {
        ShareStorage.StorageModel storageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (storageModel = this.v) == null) {
            return;
        }
        this.m.startLoad(storageModel.url, 10, false);
        this.n.setText(this.v.displayname);
        this.o.setText(this.f21884e.getResources().getString(R.string.share_login_dialog_subtitle, this.v.app));
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.v == null) {
            return;
        }
        PassportSDK.getInstance().invokeV2ShareLogin(this.f21884e, new a(this), this.v);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f21884e.finish();
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.f21884e, true);
            loginActivityConfig.setLoginListener(this.f21884e.getLoginListener());
            loginActivityConfig.setFrom(this.f21884e.getPreExtraPageKey());
            loginActivityConfig.setFromDialog("share_more");
            loginActivityConfig.start();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h(SocialType.QQ_SSO);
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

    public final void h(SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, socialType) == null) {
            PassportSDK.getInstance().loadThirdPartyLogin(new b(this, socialType), socialType);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h(SocialType.WEIXIN);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h(SocialType.SINA_WEIBO_SSO);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h(SocialType.YY);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            int id = view.getId();
            if (id != R.id.dialog_background && id != R.id.close_btn_layout && id != R.id.close_btn_view) {
                if (id == R.id.login_btn) {
                    e();
                    return;
                } else if (id == R.id.qq_login_btn) {
                    g();
                    return;
                } else if (id == R.id.wechat_login_btn) {
                    i();
                    return;
                } else if (id == R.id.weibo_login_btn) {
                    j();
                    return;
                } else if (id == R.id.yy_login_btn) {
                    k();
                    return;
                } else if (id == R.id.more_login_btn) {
                    f();
                    return;
                } else {
                    return;
                }
            }
            c();
        }
    }

    @Override // c.a.u0.s2.c.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f21886g, R.drawable.nav_bg_corner_shape, i2);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21888i, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this.f21889j);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
            c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(this.k);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            c.a.t0.s.v.c d4 = c.a.t0.s.v.c.d(this.l);
            d4.n(R.string.J_X05);
            d4.f(R.color.CAM_X0204);
            c.a.t0.s.v.c d5 = c.a.t0.s.v.c.d(this.n);
            d5.v(R.color.CAM_X0105);
            d5.z(R.dimen.T_X05);
            d5.A(R.string.F_X02);
            c.a.t0.s.v.c d6 = c.a.t0.s.v.c.d(this.o);
            d6.v(R.color.CAM_X0108);
            d6.z(R.dimen.T_X08);
            d6.A(R.string.F_X01);
            c.a.t0.s.v.c d7 = c.a.t0.s.v.c.d(this.p);
            d7.v(R.color.CAM_X0101);
            d7.z(R.dimen.T_X05);
            d7.A(R.string.F_X01);
            d7.n(R.string.J_X01);
            d7.f(R.color.CAM_X0302);
        }
    }
}
