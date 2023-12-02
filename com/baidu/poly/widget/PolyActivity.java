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
import com.baidu.tieba.ae1;
import com.baidu.tieba.bd1;
import com.baidu.tieba.gd1;
import com.baidu.tieba.hd1;
import com.baidu.tieba.jd1;
import com.baidu.tieba.kd1;
import com.baidu.tieba.nd1;
import com.baidu.tieba.pd1;
import com.baidu.tieba.qb1;
import com.baidu.tieba.qd1;
import com.baidu.tieba.rd1;
import com.baidu.tieba.sc1;
import com.baidu.tieba.sd1;
import com.baidu.tieba.ub1;
import com.baidu.tieba.vd1;
import com.baidu.tieba.yd1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes3.dex */
public class PolyActivity extends Activity implements ChannelListView.m, vd1 {
    public static /* synthetic */ Interceptable $ic;
    public static IChannelPay d;
    public static IChannelAuth e;
    public static yd1 f;
    public static Activity g;
    public static qb1.c h;
    public static boolean i;
    public static PolyActivity j;
    public transient /* synthetic */ FieldHolder $fh;
    public ChannelListView a;
    public Bundle b;
    public pd1 c;

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
    public class a extends ae1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        @Override // com.baidu.tieba.ae1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "我知道了" : (String) invokeV.objValue;
        }

        /* renamed from: com.baidu.poly.widget.PolyActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0131a implements ae1.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0131a(a aVar) {
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

            @Override // com.baidu.tieba.ae1.f
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

        @Override // com.baidu.tieba.ae1.e
        public ae1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new C0131a(this);
            }
            return (ae1.f) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ae1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        @Override // com.baidu.tieba.ae1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "取消" : (String) invokeV.objValue;
        }

        /* loaded from: classes3.dex */
        public class a implements ae1.f {
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

            @Override // com.baidu.tieba.ae1.f
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

        @Override // com.baidu.tieba.ae1.e
        public ae1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new a(this);
            }
            return (ae1.f) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ae1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pd1 a;
        public final /* synthetic */ PolyActivity b;

        @Override // com.baidu.tieba.ae1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "去验证" : (String) invokeV.objValue;
        }

        /* loaded from: classes3.dex */
        public class a implements ae1.f {
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

            @Override // com.baidu.tieba.ae1.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    c cVar = this.a;
                    cVar.b.h(cVar.a);
                    dialog.dismiss();
                }
            }
        }

        public c(PolyActivity polyActivity, pd1 pd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity, pd1Var};
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
            this.a = pd1Var;
        }

        @Override // com.baidu.tieba.ae1.e
        public ae1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new a(this);
            }
            return (ae1.f) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ae1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        @Override // com.baidu.tieba.ae1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "取消" : (String) invokeV.objValue;
        }

        /* loaded from: classes3.dex */
        public class a implements ae1.f {
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

            @Override // com.baidu.tieba.ae1.f
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

        @Override // com.baidu.tieba.ae1.e
        public ae1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new a(this);
            }
            return (ae1.f) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ae1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        @Override // com.baidu.tieba.ae1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "去验证" : (String) invokeV.objValue;
        }

        /* loaded from: classes3.dex */
        public class a implements ae1.f {
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

            @Override // com.baidu.tieba.ae1.f
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

        @Override // com.baidu.tieba.ae1.e
        public ae1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new a(this);
            }
            return (ae1.f) invokeV.objValue;
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
                String a2 = hd1.a(2, null, "repeat_pay_cancel");
                h.a(2, a2);
                bd1.j(2, a2, "0");
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
            bd1.f();
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
            kd1.g("PolyActivity onBackPressed");
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

    public final void h(pd1 pd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pd1Var) == null) {
            Intent a2 = jd1.a(this);
            if (a2 != null) {
                a2.putExtra("EXTRA_PARAM_AUTH_ID", pd1Var.a.a("authId"));
                startActivityForResult(a2, 100);
                return;
            }
            ChannelListView channelListView = this.a;
            if (channelListView != null) {
                channelListView.O(pd1Var);
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
            bd1.k();
            super.onCreate(bundle);
            overridePendingTransition(0, 0);
            i();
            kd1.g("PolyActivity onCreate");
        }
    }

    public static void l(Context context, IChannelPay iChannelPay, qb1.c cVar, Bundle bundle) {
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
                kd1.g("!context instanceof Activity");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }

    public static void m(Context context, IChannelPay iChannelPay, IChannelAuth iChannelAuth, qb1.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, context, iChannelPay, iChannelAuth, cVar, bundle) == null) {
            e = iChannelAuth;
            if (context instanceof Activity) {
                g = (Activity) context;
            }
            sc1.a().c((Activity) context);
            l(context, iChannelPay, cVar, bundle);
        }
    }

    public static void n(Context context, IChannelPay iChannelPay, IChannelAuth iChannelAuth, yd1 yd1Var, qb1.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, iChannelPay, iChannelAuth, yd1Var, cVar, bundle}) == null) {
            f = yd1Var;
            m(context, iChannelPay, iChannelAuth, cVar, bundle);
        }
    }

    @Override // com.baidu.tieba.vd1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ae1.d dVar = new ae1.d();
            dVar.e("账号风险提示");
            dVar.c("当前帐号存在比较高的风险，无法完成本次支付");
            dVar.d(new a(this));
            ae1 a2 = dVar.a(this);
            a2.setCancelable(false);
            a2.show();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.c == null) {
            return;
        }
        ae1.d dVar = new ae1.d();
        dVar.e("验证失败提示");
        dVar.c("身份证验证未通过，请通过验证后再继续支付");
        dVar.b(new d(this), new e(this));
        ae1 a2 = dVar.a(this);
        a2.setCancelable(false);
        a2.show();
    }

    @Override // com.baidu.tieba.vd1
    public void b(pd1 pd1Var) {
        ub1 ub1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pd1Var) == null) && this.a != null && pd1Var != null && (ub1Var = pd1Var.a) != null) {
            if (TextUtils.isEmpty(ub1Var.a("authId"))) {
                this.a.O(pd1Var);
            } else if (jd1.a(this) == null) {
                this.a.O(pd1Var);
            } else {
                this.c = pd1Var;
                ae1.d dVar = new ae1.d();
                dVar.e("账号风险提示");
                dVar.c("当前账号存在风险，请完成本人身份验证后继续支付");
                dVar.b(new b(this), new c(this, pd1Var));
                ae1 a2 = dVar.a(this);
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
                        qd1.h().i(this, intent.getExtras(), this.a, true);
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
                    channelListView2.O(this.c);
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
                sd1 sd1Var = new sd1(new rd1(this, d), this);
                sd1Var.s(f);
                this.a.setWalletList(sd1Var);
                String string = this.b.getString("chosenChannel");
                String string2 = this.b.getString("panelType");
                String string3 = this.b.getString("tradeType");
                kd1.g("onWindowFocusChanged panelType=" + string2 + ", tradeType=" + string3);
                if (TextUtils.equals(string2, HlsPlaylistParser.METHOD_NONE) && TextUtils.equals(string3, "DIRECTPAY")) {
                    gd1.e(this.b);
                    this.a.T(nd1.b(this, this.b), string);
                } else if (TextUtils.equals(string2, HlsPlaylistParser.METHOD_NONE) && !TextUtils.isEmpty(string)) {
                    this.a.s0(nd1.b(this, this.b), string);
                } else {
                    this.a.l0(nd1.b(this, this.b));
                    this.a.n0();
                }
            }
        }
    }
}
