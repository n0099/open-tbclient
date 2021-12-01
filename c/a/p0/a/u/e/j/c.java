package c.a.p0.a.u.e.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f2.f.o0.g;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.h0.t.a;
import c.a.p0.a.h2.c.i;
import c.a.p0.a.h2.c.j.b;
import c.a.p0.a.n2.n;
import c.a.p0.a.u1.h;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.p0.a.u.e.j.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f8297g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.h0.g.m.a f8298f;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8299e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.g1.f f8300f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f8301g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.m1.b f8302h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8303i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f8304j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ c f8305k;

        public a(c cVar, String str, c.a.p0.a.g1.f fVar, g gVar, c.a.p0.a.m1.b bVar, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, fVar, gVar, bVar, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8305k = cVar;
            this.f8299e = str;
            this.f8300f = fVar;
            this.f8301g = gVar;
            this.f8302h = bVar;
            this.f8303i = str2;
            this.f8304j = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.h2.c.d.h(iVar)) {
                    this.f8305k.C(this.f8300f, this.f8301g, this.f8302h, this.f8303i, this.f8304j, this.f8299e);
                } else {
                    this.f8305k.d(this.f8299e, new c.a.p0.a.u.h.b(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.g1.f f8306e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8307f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.m1.b f8308g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8309h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8310i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f8311j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ c f8312k;

        /* loaded from: classes.dex */
        public class a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.p0.a.d2.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Activity f8313b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f8314c;

            public a(b bVar, c.a.p0.a.d2.e eVar, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, eVar, activity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8314c = bVar;
                this.a = eVar;
                this.f8313b = activity;
            }

            @Override // c.a.p0.a.f2.f.o0.g.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    c.a.p0.a.u1.i.d(this.f8314c.f8309h);
                    c.a.p0.a.e0.d.i("NavigateToApi", "check pages success");
                    n.F(true, this.a.X().T());
                    this.f8314c.f8306e.n();
                    a.e f2 = c.a.p0.a.h0.t.a.f(this.f8313b, c.a.p0.a.h0.t.f.a.c(this.f8314c.f8308g.f6799e));
                    List<String> g2 = c.a.p0.a.f2.f.o0.a.g(this.f8314c.f8310i);
                    c cVar = this.f8314c.f8312k;
                    c.a.p0.a.d2.e eVar = this.a;
                    String c2 = f2.a.c();
                    b bVar = this.f8314c;
                    c.a.p0.a.f2.f.o0.a.m(cVar, eVar, c2, bVar.f8308g.f6799e, g2, bVar.f8307f);
                    b bVar2 = this.f8314c;
                    bVar2.f8312k.K(f2, bVar2.f8308g, bVar2.f8310i, bVar2.f8309h, bVar2.f8311j);
                }
            }

            @Override // c.a.p0.a.f2.f.o0.g.e
            public void b(int i2, c.a.p0.a.u2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    c.a.p0.a.e0.d.c("NavigateToApi", "check pages failed");
                    n.F(false, this.a.X().T());
                    this.f8314c.f8306e.n();
                    b bVar = this.f8314c;
                    c.a.p0.a.f2.f.o0.a.k(bVar.f8312k, bVar.f8307f);
                    c.a.p0.a.n2.i.j(this.f8314c.f8308g, aVar);
                }
            }
        }

        public b(c cVar, c.a.p0.a.g1.f fVar, String str, c.a.p0.a.m1.b bVar, String str2, c.a.p0.a.h0.g.g gVar, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar, str, bVar, str2, gVar, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8312k = cVar;
            this.f8306e = fVar;
            this.f8307f = str;
            this.f8308g = bVar;
            this.f8309h = str2;
            this.f8310i = gVar;
            this.f8311j = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f8306e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    c.a.p0.a.d2.e L = c.a.p0.a.d2.e.L();
                    if (L == null) {
                        this.f8312k.d(this.f8307f, new c.a.p0.a.u.h.b(1001, "swan app is null"));
                        c.a.p0.a.n2.i.i(this.f8308g);
                        return;
                    }
                    this.f8306e.t();
                    c.a.p0.a.f2.f.o0.g.g(L, this.f8308g, "", new a(this, L, activity), this.f8309h);
                    return;
                }
                this.f8312k.d(this.f8307f, new c.a.p0.a.u.h.b(1001, "swan activity is null"));
                c.a.p0.a.n2.i.i(this.f8308g);
            }
        }
    }

    /* renamed from: c.a.p0.a.u.e.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0487c implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8315b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.m1.b f8316c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.g f8317d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8318e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f8319f;

        public C0487c(c cVar, a.e eVar, String str, c.a.p0.a.m1.b bVar, c.a.p0.a.h0.g.g gVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, eVar, str, bVar, gVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8319f = cVar;
            this.a = eVar;
            this.f8315b = str;
            this.f8316c = bVar;
            this.f8317d = gVar;
            this.f8318e = str2;
        }

        @Override // c.a.p0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.u1.i.e(this.a, this.f8315b);
                this.f8319f.E(this.a.a, this.f8316c, this.f8317d, this.f8315b, this.f8318e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f8320e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.m1.b f8321f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.g f8322g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8323h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8324i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f8325j;

        public d(c cVar, c.a.p0.a.p.e.b bVar, c.a.p0.a.m1.b bVar2, c.a.p0.a.h0.g.g gVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar, bVar2, gVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8325j = cVar;
            this.f8320e = bVar;
            this.f8321f = bVar2;
            this.f8322g = gVar;
            this.f8323h = str;
            this.f8324i = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8325j.D(this.f8320e, this.f8321f, this.f8322g, this.f8323h, this.f8324i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.p0.a.h0.g.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.h0.g.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8326b;

        public e(c cVar, c.a.p0.a.h0.g.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8326b = cVar;
            this.a = fVar;
        }

        @Override // c.a.p0.a.h0.g.m.a, c.a.p0.a.h0.g.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.f8326b.f8298f != null) {
                    this.a.S2(this.f8326b.f8298f);
                }
            }
        }

        @Override // c.a.p0.a.h0.g.m.a, c.a.p0.a.h0.g.m.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c2 = c.a.p0.a.c2.b.a.c(this.a);
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                c.a.p0.a.c2.b.a.h(this.a);
            }
        }

        @Override // c.a.p0.a.h0.g.m.a, c.a.p0.a.h0.g.m.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c2 = c.a.p0.a.c2.b.a.c(this.a);
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                c.a.p0.a.c2.b.a.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1123352120, "Lc/a/p0/a/u/e/j/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1123352120, "Lc/a/p0/a/u/e/j/c;");
                return;
            }
        }
        f8297g = c.a.p0.a.c1.a.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(c.a.p0.a.g1.f fVar, c.a.p0.a.h0.g.g gVar, c.a.p0.a.m1.b bVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{fVar, gVar, bVar, str, str2, str3}) == null) {
            q0.a0(new b(this, fVar, str3, bVar, str, gVar, str2));
        }
    }

    public final void D(c.a.p0.a.p.e.b bVar, c.a.p0.a.m1.b bVar2, c.a.p0.a.h0.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(bVar, bVar2, gVar, str);
            } else {
                G(bVar, bVar2, gVar, str);
            }
        }
    }

    public final void E(c.a.p0.a.p.e.b bVar, c.a.p0.a.m1.b bVar2, c.a.p0.a.h0.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bVar2, gVar, str, str2) == null) {
            if (q0.O()) {
                D(bVar, bVar2, gVar, str, str2);
            } else {
                q0.a0(new d(this, bVar, bVar2, gVar, str, str2));
            }
        }
    }

    public final void F(c.a.p0.a.p.e.b bVar, c.a.p0.a.m1.b bVar2, c.a.p0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        c.a.p0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.p0.a.g1.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.p0.a.f2.f.o0.a.e(bVar, bVar2, str);
        c.a.p0.a.u1.i.c(9, str);
        c.a.p0.a.h0.g.f.T3(q0.n());
        g.b k2 = gVar.i("showModalPage").k("normal", bVar2);
        if ((gVar.m() instanceof c.a.p0.a.h0.g.f) && (fVar = (c.a.p0.a.h0.g.f) gVar.m()) != null) {
            fVar.H0 = true;
            k2.b();
            if (gVar.k() > 1) {
                fVar.y3().setBackgroundColor(0);
            } else {
                fVar.H0 = false;
            }
            fVar.A2(false);
            c.a.p0.a.h0.g.m.a aVar = this.f8298f;
            if (aVar != null) {
                fVar.S2(aVar);
            }
            e eVar = new e(this, fVar);
            this.f8298f = eVar;
            fVar.o2(eVar);
            View c2 = c.a.p0.a.c2.b.a.c(fVar);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            c.a.p0.a.c2.b.a.h(fVar);
            PullToRefreshBaseWebView j0 = bVar.j0();
            if (j0 != null) {
                j0.setIsPreventPullToRefresh(true);
            }
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.p0.a.u1.i.a(str, bVar2);
        }
    }

    public final void G(c.a.p0.a.p.e.b bVar, c.a.p0.a.m1.b bVar2, c.a.p0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.p0.a.g1.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.p0.a.f2.f.o0.a.e(bVar, bVar2, str);
        c.a.p0.a.u1.i.c(0, str);
        if (gVar.k() < f8297g) {
            c.a.p0.a.h0.g.f.T3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(c.a.p0.a.h0.g.g.f5496g, c.a.p0.a.h0.g.g.f5498i);
            i2.k("normal", bVar2).b();
            c.a.p0.a.z2.g.c(gVar, getContext());
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.p0.a.u1.i.a(str, bVar2);
            return;
        }
        c.a.p0.a.u.e.j.d.A(gVar, bVar2, str, true);
    }

    public c.a.p0.a.u.h.b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final c.a.p0.a.u.h.b I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            c.a.p0.a.d2.e a0 = c.a.p0.a.d2.e.a0();
            if (a0 == null) {
                return new c.a.p0.a.u.h.b(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            c.a.p0.a.u1.i.b(uuid);
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = c.a.p0.a.f2.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    c.a.p0.a.e0.d.c("NavigateToApi", "url is null");
                    return new c.a.p0.a.u.h.b(202, "url is null");
                }
                c.a.p0.a.g1.f U = c.a.p0.a.g1.f.U();
                c.a.p0.a.h0.g.g V = U.V();
                if (V == null) {
                    c.a.p0.a.e0.d.c("NavigateToApi", "manager is null");
                    return new c.a.p0.a.u.h.b(1001, "manager is null");
                }
                c.a.p0.a.m1.b e2 = c.a.p0.a.m1.b.e(p, U.z());
                e2.f6803i = str2;
                e2.f6804j = uuid;
                c.a.p0.a.n2.i.g(e2);
                if (!q0.b(U.r(), e2, false)) {
                    String str4 = "page params error : path=" + e2.f6799e + " ; routePath=" + e2.f6802h;
                    c.a.p0.a.e0.d.c("NavigateToApi", str4);
                    c.a.p0.a.n2.i.i(e2);
                    return new c.a.p0.a.u.h.b(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(e2.f6802h) && c.a.p0.a.d2.e.L() != null) {
                    c.a.p0.a.d2.e.L().K0(optString, e2.f6802h);
                }
                String optString2 = jSONObject.optString("startTime");
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    c.a.p0.a.e0.d.c("NavigateToApi", "cb is empty");
                    c.a.p0.a.n2.i.i(e2);
                    return new c.a.p0.a.u.h.b(202, "cb is empty");
                } else if (c.a.p0.a.f2.f.f0.d.b().a(e2)) {
                    c.a.p0.a.f2.f.f0.d.b().i(str3, e2);
                    c.a.p0.a.e0.d.c("NavigateToApi", "access to this page is prohibited");
                    return new c.a.p0.a.u.h.b(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        a0.d0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, e2, uuid, str2));
                    } else {
                        C(U, V, e2, uuid, str2, optString3);
                    }
                    return c.a.p0.a.u.h.b.f();
                }
            }
            return bVar;
        }
        return (c.a.p0.a.u.h.b) invokeLLL.objValue;
    }

    public c.a.p0.a.u.h.b J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void K(a.e eVar, c.a.p0.a.m1.b bVar, c.a.p0.a.h0.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, bVar, gVar, str, str2) == null) {
            boolean z = eVar != null && eVar.f5990b;
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            c.a.p0.a.h0.t.a.q(eVar, new C0487c(this, eVar, str, bVar, gVar, str2));
        }
    }

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
