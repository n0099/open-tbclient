package com.baidu.poly.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.AuthWidgetForCashierActivity;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.protobuf.CodedInputStream;
import com.repackage.e91;
import com.repackage.f91;
import com.repackage.h91;
import com.repackage.i91;
import com.repackage.l91;
import com.repackage.n91;
import com.repackage.o91;
import com.repackage.p71;
import com.repackage.p91;
import com.repackage.q81;
import com.repackage.q91;
import com.repackage.s71;
import com.repackage.t91;
import com.repackage.w91;
import com.repackage.y91;
import com.repackage.z81;
/* loaded from: classes2.dex */
public class PolyActivity extends Activity implements ChannelListView.m, t91 {
    public static /* synthetic */ Interceptable $ic;
    public static IChannelPay d;
    public static IChannelAuth e;
    public static w91 f;
    public static Activity g;
    public static p71.c h;
    public static boolean i;
    public static PolyActivity j;
    public transient /* synthetic */ FieldHolder $fh;
    public ChannelListView a;
    public Bundle b;
    public n91 c;

    /* loaded from: classes2.dex */
    public class a extends y91.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        /* renamed from: com.baidu.poly.widget.PolyActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0125a implements y91.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0125a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.repackage.y91.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.a.a.a != null) {
                        this.a.a.a.k0();
                        this.a.a.a.Y();
                    }
                }
            }
        }

        public a(PolyActivity polyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = polyActivity;
        }

        @Override // com.repackage.y91.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "我知道了" : (String) invokeV.objValue;
        }

        @Override // com.repackage.y91.e
        public y91.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new C0125a(this) : (y91.f) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends y91.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        /* loaded from: classes2.dex */
        public class a implements y91.f {
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

            @Override // com.repackage.y91.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.a.a.a != null) {
                        this.a.a.a.k0();
                        this.a.a.a.Y();
                    }
                }
            }
        }

        public b(PolyActivity polyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = polyActivity;
        }

        @Override // com.repackage.y91.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL : (String) invokeV.objValue;
        }

        @Override // com.repackage.y91.e
        public y91.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (y91.f) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends y91.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n91 a;
        public final /* synthetic */ PolyActivity b;

        /* loaded from: classes2.dex */
        public class a implements y91.f {
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

            @Override // com.repackage.y91.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    c cVar = this.a;
                    cVar.b.h(cVar.a);
                    dialog.dismiss();
                }
            }
        }

        public c(PolyActivity polyActivity, n91 n91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity, n91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = polyActivity;
            this.a = n91Var;
        }

        @Override // com.repackage.y91.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "去验证" : (String) invokeV.objValue;
        }

        @Override // com.repackage.y91.e
        public y91.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (y91.f) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d extends y91.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        /* loaded from: classes2.dex */
        public class a implements y91.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.repackage.y91.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.a.a.a != null) {
                        this.a.a.a.k0();
                        this.a.a.a.Y();
                    }
                }
            }
        }

        public d(PolyActivity polyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = polyActivity;
        }

        @Override // com.repackage.y91.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL : (String) invokeV.objValue;
        }

        @Override // com.repackage.y91.e
        public y91.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (y91.f) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e extends y91.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        /* loaded from: classes2.dex */
        public class a implements y91.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.repackage.y91.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    PolyActivity polyActivity = this.a.a;
                    polyActivity.h(polyActivity.c);
                    dialog.dismiss();
                }
            }
        }

        public e(PolyActivity polyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = polyActivity;
        }

        @Override // com.repackage.y91.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "去验证" : (String) invokeV.objValue;
        }

        @Override // com.repackage.y91.e
        public y91.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (y91.f) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1779253494, "Lcom/baidu/poly/widget/PolyActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1779253494, "Lcom/baidu/poly/widget/PolyActivity;");
        }
    }

    public PolyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || j == null) {
            return;
        }
        if (h != null) {
            String a2 = f91.a(2, null, "repeat_pay_cancel");
            h.a(2, a2);
            z81.j(2, a2, "0");
        }
        j.finish();
    }

    public static void l(Context context, IChannelPay iChannelPay, p71.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, context, iChannelPay, cVar, bundle) == null) {
            if (i) {
                g();
            }
            d = iChannelPay;
            h = cVar;
            Intent intent = new Intent(context, PolyActivity.class);
            intent.putExtra("pay_arguements", bundle);
            if (!(context instanceof Activity)) {
                i91.g("!context instanceof Activity");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }

    public static void m(Context context, IChannelPay iChannelPay, IChannelAuth iChannelAuth, p71.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, context, iChannelPay, iChannelAuth, cVar, bundle) == null) {
            e = iChannelAuth;
            if (context instanceof Activity) {
                g = (Activity) context;
            }
            q81.a().c((Activity) context);
            l(context, iChannelPay, cVar, bundle);
        }
    }

    public static void n(Context context, IChannelPay iChannelPay, IChannelAuth iChannelAuth, w91 w91Var, p71.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, iChannelPay, iChannelAuth, w91Var, cVar, bundle}) == null) {
            f = w91Var;
            m(context, iChannelPay, iChannelAuth, cVar, bundle);
        }
    }

    @Override // com.repackage.t91
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            y91.d dVar = new y91.d();
            dVar.e("账号风险提示");
            dVar.c("当前帐号存在比较高的风险，无法完成本次支付");
            dVar.d(new a(this));
            y91 a2 = dVar.a(this);
            a2.setCancelable(false);
            a2.show();
        }
    }

    @Override // com.repackage.t91
    public void b(n91 n91Var) {
        s71 s71Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n91Var) == null) || this.a == null || n91Var == null || (s71Var = n91Var.a) == null) {
            return;
        }
        if (TextUtils.isEmpty(s71Var.a("authId"))) {
            this.a.M(n91Var);
        } else if (h91.a(this) == null) {
            this.a.M(n91Var);
        } else {
            this.c = n91Var;
            y91.d dVar = new y91.d();
            dVar.e("账号风险提示");
            dVar.c("当前账号存在风险，请完成本人身份验证后继续支付");
            dVar.b(new b(this), new c(this, n91Var));
            y91 a2 = dVar.a(this);
            a2.setCancelable(false);
            a2.show();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = null;
            d = null;
            this.b = null;
            h = null;
            i = false;
            j = null;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.finish();
            overridePendingTransition(0, 0);
            f();
            z81.f();
        }
    }

    public final void h(n91 n91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, n91Var) == null) {
            Intent a2 = h91.a(this);
            if (a2 != null) {
                a2.putExtra("EXTRA_PARAM_AUTH_ID", n91Var.a.a("authId"));
                startActivityForResult(a2, 100);
                return;
            }
            ChannelListView channelListView = this.a;
            if (channelListView != null) {
                channelListView.M(n91Var);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b = getIntent().getBundleExtra("pay_arguements");
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        Window window = getWindow();
        window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.getDecorView().setSystemUiVisibility(1024);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.c == null) {
            return;
        }
        y91.d dVar = new y91.d();
        dVar.e("验证失败提示");
        dVar.c("身份证验证未通过，请通过验证后再继续支付");
        dVar.b(new d(this), new e(this));
        y91 a2 = dVar.a(this);
        a2.setCancelable(false);
        a2.show();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 != 200) {
                if (i2 == 100) {
                    int intExtra = intent.getIntExtra(AuthWidgetForCashierActivity.w, -1);
                    intent.getStringExtra(AuthWidgetForCashierActivity.x);
                    if (intExtra != 0) {
                        k();
                        return;
                    }
                    ChannelListView channelListView = this.a;
                    if (channelListView != null) {
                        channelListView.M(this.c);
                        return;
                    }
                    return;
                }
                return;
            }
            Bundle bundle = this.b;
            boolean z = false;
            if (bundle != null) {
                String string = bundle.getString("panelType");
                String string2 = this.b.getString("tradeType");
                if (TextUtils.equals(string, HlsPlaylistParser.METHOD_NONE) && TextUtils.equals(string2, "DIRECTPAY")) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            if (i3 == -1) {
                o91.h().i(this, intent.getExtras(), this.a, true);
                return;
            }
            ChannelListView channelListView2 = this.a;
            if (channelListView2 != null) {
                channelListView2.b0(3, "pay canceled , back from H5. ", "1");
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ChannelListView channelListView = this.a;
            if (channelListView == null) {
                super.onBackPressed();
                return;
            }
            if (!channelListView.Y()) {
                super.onBackPressed();
            }
            i91.g("PolyActivity onBackPressed");
        }
    }

    @Override // com.baidu.poly.widget.ChannelListView.m
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            j();
            i = true;
            j = this;
            z81.k();
            super.onCreate(bundle);
            overridePendingTransition(0, 0);
            i();
            i91.g("PolyActivity onCreate");
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            f();
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStop();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || this.a != null || isFinishing() || this.b == null) {
                return;
            }
            ChannelListView channelListView = new ChannelListView(this);
            this.a = channelListView;
            setContentView(channelListView);
            this.a.setResultListener(h);
            this.a.setCloseListener(this);
            this.a.setChannelAuth(e);
            q91 q91Var = new q91(new p91(this, d), this);
            q91Var.s(f);
            this.a.setWalletList(q91Var);
            String string = this.b.getString("chosenChannel");
            String string2 = this.b.getString("panelType");
            String string3 = this.b.getString("tradeType");
            i91.g("onWindowFocusChanged panelType=" + string2 + ", tradeType=" + string3);
            if (TextUtils.equals(string2, HlsPlaylistParser.METHOD_NONE) && TextUtils.equals(string3, "DIRECTPAY")) {
                e91.e(this.b);
                this.a.R(l91.b(this, this.b), string);
            } else if (TextUtils.equals(string2, HlsPlaylistParser.METHOD_NONE) && !TextUtils.isEmpty(string)) {
                this.a.q0(l91.b(this, this.b), string);
            } else {
                this.a.j0(l91.b(this, this.b));
                this.a.l0();
            }
        }
    }
}
