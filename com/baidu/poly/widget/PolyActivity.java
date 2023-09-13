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
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.sapi2.activity.AuthWidgetForCashierActivity;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.ci1;
import com.baidu.tieba.di1;
import com.baidu.tieba.fi1;
import com.baidu.tieba.gi1;
import com.baidu.tieba.ji1;
import com.baidu.tieba.li1;
import com.baidu.tieba.mg1;
import com.baidu.tieba.mi1;
import com.baidu.tieba.ni1;
import com.baidu.tieba.oh1;
import com.baidu.tieba.oi1;
import com.baidu.tieba.qg1;
import com.baidu.tieba.ri1;
import com.baidu.tieba.ui1;
import com.baidu.tieba.wi1;
import com.baidu.tieba.xh1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes3.dex */
public class PolyActivity extends Activity implements ChannelListView.m, ri1 {
    public static /* synthetic */ Interceptable $ic;
    public static IChannelPay d;
    public static IChannelAuth e;
    public static ui1 f;
    public static Activity g;
    public static mg1.c h;
    public static boolean i;
    public static PolyActivity j;
    public transient /* synthetic */ FieldHolder $fh;
    public ChannelListView a;
    public Bundle b;
    public li1 c;

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

    /* loaded from: classes3.dex */
    public class a extends wi1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        @Override // com.baidu.tieba.wi1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "我知道了" : (String) invokeV.objValue;
        }

        /* renamed from: com.baidu.poly.widget.PolyActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0128a implements wi1.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0128a(a aVar) {
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

            @Override // com.baidu.tieba.wi1.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.a.a.a != null) {
                        this.a.a.a.m0();
                        this.a.a.a.a0();
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

        @Override // com.baidu.tieba.wi1.e
        public wi1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new C0128a(this);
            }
            return (wi1.f) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends wi1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        @Override // com.baidu.tieba.wi1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "取消" : (String) invokeV.objValue;
        }

        /* loaded from: classes3.dex */
        public class a implements wi1.f {
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

            @Override // com.baidu.tieba.wi1.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.a.a.a != null) {
                        this.a.a.a.m0();
                        this.a.a.a.a0();
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

        @Override // com.baidu.tieba.wi1.e
        public wi1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new a(this);
            }
            return (wi1.f) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends wi1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li1 a;
        public final /* synthetic */ PolyActivity b;

        @Override // com.baidu.tieba.wi1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "去验证" : (String) invokeV.objValue;
        }

        /* loaded from: classes3.dex */
        public class a implements wi1.f {
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

            @Override // com.baidu.tieba.wi1.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    c cVar = this.a;
                    cVar.b.h(cVar.a);
                    dialog.dismiss();
                }
            }
        }

        public c(PolyActivity polyActivity, li1 li1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity, li1Var};
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
            this.a = li1Var;
        }

        @Override // com.baidu.tieba.wi1.e
        public wi1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new a(this);
            }
            return (wi1.f) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends wi1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        @Override // com.baidu.tieba.wi1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "取消" : (String) invokeV.objValue;
        }

        /* loaded from: classes3.dex */
        public class a implements wi1.f {
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

            @Override // com.baidu.tieba.wi1.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.a.a.a != null) {
                        this.a.a.a.m0();
                        this.a.a.a.a0();
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

        @Override // com.baidu.tieba.wi1.e
        public wi1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new a(this);
            }
            return (wi1.f) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends wi1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        @Override // com.baidu.tieba.wi1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "去验证" : (String) invokeV.objValue;
        }

        /* loaded from: classes3.dex */
        public class a implements wi1.f {
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

            @Override // com.baidu.tieba.wi1.f
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

        @Override // com.baidu.tieba.wi1.e
        public wi1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new a(this);
            }
            return (wi1.f) invokeV.objValue;
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
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && j != null) {
            if (h != null) {
                String a2 = di1.a(2, null, "repeat_pay_cancel");
                h.a(2, a2);
                xh1.j(2, a2, "0");
            }
            j.finish();
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
            xh1.f();
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
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1024);
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
            if (!channelListView.a0()) {
                super.onBackPressed();
            }
            gi1.g("PolyActivity onBackPressed");
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

    public final void h(li1 li1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, li1Var) == null) {
            Intent a2 = fi1.a(this);
            if (a2 != null) {
                a2.putExtra("EXTRA_PARAM_AUTH_ID", li1Var.a.a("authId"));
                startActivityForResult(a2, 100);
                return;
            }
            ChannelListView channelListView = this.a;
            if (channelListView != null) {
                channelListView.N(li1Var);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            j();
            i = true;
            j = this;
            xh1.k();
            super.onCreate(bundle);
            overridePendingTransition(0, 0);
            i();
            gi1.g("PolyActivity onCreate");
        }
    }

    public static void l(Context context, IChannelPay iChannelPay, mg1.c cVar, Bundle bundle) {
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
                gi1.g("!context instanceof Activity");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }

    public static void m(Context context, IChannelPay iChannelPay, IChannelAuth iChannelAuth, mg1.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, context, iChannelPay, iChannelAuth, cVar, bundle) == null) {
            e = iChannelAuth;
            if (context instanceof Activity) {
                g = (Activity) context;
            }
            oh1.a().c((Activity) context);
            l(context, iChannelPay, cVar, bundle);
        }
    }

    public static void n(Context context, IChannelPay iChannelPay, IChannelAuth iChannelAuth, ui1 ui1Var, mg1.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, iChannelPay, iChannelAuth, ui1Var, cVar, bundle}) == null) {
            f = ui1Var;
            m(context, iChannelPay, iChannelAuth, cVar, bundle);
        }
    }

    @Override // com.baidu.tieba.ri1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            wi1.d dVar = new wi1.d();
            dVar.e("账号风险提示");
            dVar.c("当前帐号存在比较高的风险，无法完成本次支付");
            dVar.d(new a(this));
            wi1 a2 = dVar.a(this);
            a2.setCancelable(false);
            a2.show();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.c == null) {
            return;
        }
        wi1.d dVar = new wi1.d();
        dVar.e("验证失败提示");
        dVar.c("身份证验证未通过，请通过验证后再继续支付");
        dVar.b(new d(this), new e(this));
        wi1 a2 = dVar.a(this);
        a2.setCancelable(false);
        a2.show();
    }

    @Override // com.baidu.tieba.ri1
    public void b(li1 li1Var) {
        qg1 qg1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, li1Var) == null) && this.a != null && li1Var != null && (qg1Var = li1Var.a) != null) {
            if (TextUtils.isEmpty(qg1Var.a("authId"))) {
                this.a.N(li1Var);
            } else if (fi1.a(this) == null) {
                this.a.N(li1Var);
            } else {
                this.c = li1Var;
                wi1.d dVar = new wi1.d();
                dVar.e("账号风险提示");
                dVar.c("当前账号存在风险，请完成本人身份验证后继续支付");
                dVar.b(new b(this), new c(this, li1Var));
                wi1 a2 = dVar.a(this);
                a2.setCancelable(false);
                a2.show();
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 200) {
                Bundle bundle = this.b;
                boolean z = false;
                if (bundle != null) {
                    String string = bundle.getString("panelType");
                    String string2 = this.b.getString("tradeType");
                    if (TextUtils.equals(string, HlsPlaylistParser.METHOD_NONE) && TextUtils.equals(string2, "DIRECTPAY")) {
                        z = true;
                    }
                }
                if (!z) {
                    if (i3 == -1) {
                        mi1.h().i(this, intent.getExtras(), this.a, true);
                        return;
                    }
                    ChannelListView channelListView = this.a;
                    if (channelListView != null) {
                        channelListView.d0(3, "pay canceled , back from H5. ", "1");
                    }
                }
            } else if (i2 == 100) {
                int intExtra = intent.getIntExtra(AuthWidgetForCashierActivity.w, -1);
                intent.getStringExtra(AuthWidgetForCashierActivity.x);
                if (intExtra != 0) {
                    k();
                    return;
                }
                ChannelListView channelListView2 = this.a;
                if (channelListView2 != null) {
                    channelListView2.N(this.c);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z && this.a == null && !isFinishing() && this.b != null) {
                ChannelListView channelListView = new ChannelListView(this);
                this.a = channelListView;
                setContentView(channelListView);
                this.a.setResultListener(h);
                this.a.setCloseListener(this);
                this.a.setChannelAuth(e);
                oi1 oi1Var = new oi1(new ni1(this, d), this);
                oi1Var.s(f);
                this.a.setWalletList(oi1Var);
                String string = this.b.getString("chosenChannel");
                String string2 = this.b.getString("panelType");
                String string3 = this.b.getString("tradeType");
                gi1.g("onWindowFocusChanged panelType=" + string2 + ", tradeType=" + string3);
                if (TextUtils.equals(string2, HlsPlaylistParser.METHOD_NONE) && TextUtils.equals(string3, "DIRECTPAY")) {
                    ci1.e(this.b);
                    this.a.S(ji1.b(this, this.b), string);
                } else if (TextUtils.equals(string2, HlsPlaylistParser.METHOD_NONE) && !TextUtils.isEmpty(string)) {
                    this.a.s0(ji1.b(this, this.b), string);
                } else {
                    this.a.l0(ji1.b(this, this.b));
                    this.a.n0();
                }
            }
        }
    }
}
