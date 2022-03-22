package c.a.p0.u2.c;

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
/* loaded from: classes2.dex */
public class c implements c.a.p0.u2.c.a, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LoginDialogActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f18977b;

    /* renamed from: c  reason: collision with root package name */
    public View f18978c;

    /* renamed from: d  reason: collision with root package name */
    public View f18979d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f18980e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18981f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18982g;

    /* renamed from: h  reason: collision with root package name */
    public View f18983h;
    public TbImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public View n;
    public View o;
    public View p;
    public View q;
    public final ShareStorage.StorageModel r;

    /* loaded from: classes2.dex */
    public class a extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f111a), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.a.a.passLoginFail();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                this.a.a.passLoginSucc();
                this.a.a.addLoginSuccessLog(DialogLoginHelper.DIALOG_TYPE_SHARE);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SocialType a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f18984b;

        public b(c cVar, SocialType socialType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, socialType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18984b = cVar;
            this.a = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
                this.f18984b.a.showLoading();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                this.f18984b.a.closeLoadingDialog();
                this.f18984b.a.showToast(String.format(this.f18984b.a.getString(R.string.obfuscated_res_0x7f0f138e), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.f18984b.a.passLoginFail();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                this.f18984b.a.passLoginSucc();
                this.f18984b.a.addLoginSuccessLog(this.a.name().toLowerCase());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = (ShareStorage.StorageModel) new Gson().fromJson(str, (Class<Object>) ShareStorage.StorageModel.class);
    }

    @Override // c.a.p0.u2.c.a
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, loginDialogActivity, viewGroup) == null) {
            this.a = loginDialogActivity;
            View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.obfuscated_res_0x7f0d0774, viewGroup, true);
            this.f18977b = inflate.findViewById(R.id.obfuscated_res_0x7f090791);
            this.f18978c = inflate.findViewById(R.id.obfuscated_res_0x7f0907aa);
            this.f18979d = inflate.findViewById(R.id.obfuscated_res_0x7f090669);
            this.f18980e = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09066a);
            this.f18981f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0907b6);
            this.f18982g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0907b4);
            this.f18983h = inflate.findViewById(R.id.obfuscated_res_0x7f0922b0);
            this.i = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092296);
            this.j = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0922bb);
            this.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0922d6);
            this.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091336);
            this.m = inflate.findViewById(R.id.obfuscated_res_0x7f091990);
            this.n = inflate.findViewById(R.id.obfuscated_res_0x7f09245d);
            this.o = inflate.findViewById(R.id.obfuscated_res_0x7f092460);
            this.p = inflate.findViewById(R.id.obfuscated_res_0x7f0924cd);
            this.q = inflate.findViewById(R.id.obfuscated_res_0x7f09144a);
            this.f18977b.setOnClickListener(this);
            this.f18979d.setOnClickListener(this);
            this.f18980e.setOnClickListener(this);
            this.f18978c.setOnClickListener(this);
            this.i.setIsRound(true);
            this.i.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            d();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.passLoginCancel();
            this.a.finish();
        }
    }

    public final void d() {
        ShareStorage.StorageModel storageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (storageModel = this.r) == null) {
            return;
        }
        this.i.J(storageModel.url, 10, false);
        this.j.setText(this.r.displayname);
        this.k.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1119, this.r.app));
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.r == null) {
            return;
        }
        PassportSDK.getInstance().invokeV2ShareLogin(this.a, new a(this), this.r);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.finish();
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.a, true);
            loginActivityConfig.setLoginListener(this.a.getLoginListener());
            loginActivityConfig.setFrom(this.a.getPreExtraPageKey());
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

    @Override // c.a.p0.u2.c.a
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
            if (id == R.id.obfuscated_res_0x7f090791 || id == R.id.obfuscated_res_0x7f090669 || id == R.id.obfuscated_res_0x7f09066a) {
                c();
            } else if (id == R.id.obfuscated_res_0x7f091336) {
                e();
            } else if (id == R.id.obfuscated_res_0x7f091990) {
                g();
            } else if (id == R.id.obfuscated_res_0x7f09245d) {
                i();
            } else if (id == R.id.obfuscated_res_0x7f092460) {
                j();
            } else if (id == R.id.obfuscated_res_0x7f0924cd) {
                k();
            } else if (id == R.id.obfuscated_res_0x7f09144a) {
                f();
            }
        }
    }

    @Override // c.a.p0.u2.c.a
    public void onViewChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            SkinManager.setBackgroundResource(this.f18978c, R.drawable.nav_bg_corner_shape, i);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f18980e, R.drawable.obfuscated_res_0x7f0808f1, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f18981f);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.f18982g);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.f18983h);
            d4.n(R.string.J_X05);
            d4.f(R.color.CAM_X0204);
            c.a.o0.r.v.c d5 = c.a.o0.r.v.c.d(this.j);
            d5.v(R.color.CAM_X0105);
            d5.z(R.dimen.T_X05);
            d5.A(R.string.F_X02);
            c.a.o0.r.v.c d6 = c.a.o0.r.v.c.d(this.k);
            d6.v(R.color.CAM_X0108);
            d6.z(R.dimen.T_X08);
            d6.A(R.string.F_X01);
            c.a.o0.r.v.c d7 = c.a.o0.r.v.c.d(this.l);
            d7.v(R.color.CAM_X0101);
            d7.z(R.dimen.T_X05);
            d7.A(R.string.F_X01);
            d7.n(R.string.J_X01);
            d7.f(R.color.CAM_X0302);
        }
    }
}
