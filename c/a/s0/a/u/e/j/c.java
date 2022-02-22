package c.a.s0.a.u.e.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.f2.f.o0.g;
import c.a.s0.a.h0.g.g;
import c.a.s0.a.h0.t.a;
import c.a.s0.a.h2.c.i;
import c.a.s0.a.h2.c.j.b;
import c.a.s0.a.n2.n;
import c.a.s0.a.u1.h;
import c.a.s0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
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
public class c extends c.a.s0.a.u.e.j.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f9380g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.a.h0.g.m.a f9381f;

    /* loaded from: classes.dex */
    public class a implements c.a.s0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9382e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.g1.f f9383f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f9384g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.m1.b f9385h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f9386i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f9387j;
        public final /* synthetic */ c k;

        public a(c cVar, String str, c.a.s0.a.g1.f fVar, g gVar, c.a.s0.a.m1.b bVar, String str2, String str3) {
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
            this.k = cVar;
            this.f9382e = str;
            this.f9383f = fVar;
            this.f9384g = gVar;
            this.f9385h = bVar;
            this.f9386i = str2;
            this.f9387j = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.s0.a.h2.c.d.h(iVar)) {
                    this.k.C(this.f9383f, this.f9384g, this.f9385h, this.f9386i, this.f9387j, this.f9382e);
                } else {
                    this.k.d(this.f9382e, new c.a.s0.a.u.h.b(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.g1.f f9388e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9389f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.m1.b f9390g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9391h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f9392i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f9393j;
        public final /* synthetic */ c k;

        /* loaded from: classes.dex */
        public class a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.s0.a.d2.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Activity f9394b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f9395c;

            public a(b bVar, c.a.s0.a.d2.e eVar, Activity activity) {
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
                this.f9395c = bVar;
                this.a = eVar;
                this.f9394b = activity;
            }

            @Override // c.a.s0.a.f2.f.o0.g.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    c.a.s0.a.u1.i.d(this.f9395c.f9391h);
                    c.a.s0.a.e0.d.i("NavigateToApi", "check pages success");
                    n.F(true, this.a.X().T());
                    this.f9395c.f9388e.o();
                    a.e f2 = c.a.s0.a.h0.t.a.f(this.f9394b, c.a.s0.a.h0.t.f.a.c(this.f9395c.f9390g.f7914e));
                    List<String> g2 = c.a.s0.a.f2.f.o0.a.g(this.f9395c.f9392i);
                    c cVar = this.f9395c.k;
                    c.a.s0.a.d2.e eVar = this.a;
                    String c2 = f2.a.c();
                    b bVar = this.f9395c;
                    c.a.s0.a.f2.f.o0.a.m(cVar, eVar, c2, bVar.f9390g.f7914e, g2, bVar.f9389f);
                    b bVar2 = this.f9395c;
                    bVar2.k.K(f2, bVar2.f9390g, bVar2.f9392i, bVar2.f9391h, bVar2.f9393j);
                }
            }

            @Override // c.a.s0.a.f2.f.o0.g.e
            public void c(int i2, c.a.s0.a.u2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    c.a.s0.a.e0.d.c("NavigateToApi", "check pages failed");
                    n.F(false, this.a.X().T());
                    this.f9395c.f9388e.o();
                    b bVar = this.f9395c;
                    c.a.s0.a.f2.f.o0.a.k(bVar.k, bVar.f9389f);
                    c.a.s0.a.n2.i.j(this.f9395c.f9390g, aVar);
                }
            }
        }

        public b(c cVar, c.a.s0.a.g1.f fVar, String str, c.a.s0.a.m1.b bVar, String str2, c.a.s0.a.h0.g.g gVar, String str3) {
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
            this.k = cVar;
            this.f9388e = fVar;
            this.f9389f = str;
            this.f9390g = bVar;
            this.f9391h = str2;
            this.f9392i = gVar;
            this.f9393j = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f9388e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    c.a.s0.a.d2.e L = c.a.s0.a.d2.e.L();
                    if (L == null) {
                        this.k.d(this.f9389f, new c.a.s0.a.u.h.b(1001, "swan app is null"));
                        c.a.s0.a.n2.i.i(this.f9390g);
                        return;
                    }
                    this.f9388e.a();
                    c.a.s0.a.f2.f.o0.g.g(L, this.f9390g, "", new a(this, L, activity), this.f9391h);
                    return;
                }
                this.k.d(this.f9389f, new c.a.s0.a.u.h.b(1001, "swan activity is null"));
                c.a.s0.a.n2.i.i(this.f9390g);
            }
        }
    }

    /* renamed from: c.a.s0.a.u.e.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0600c implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9396b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.m1.b f9397c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.g.g f9398d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9399e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f9400f;

        public C0600c(c cVar, a.e eVar, String str, c.a.s0.a.m1.b bVar, c.a.s0.a.h0.g.g gVar, String str2) {
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
            this.f9400f = cVar;
            this.a = eVar;
            this.f9396b = str;
            this.f9397c = bVar;
            this.f9398d = gVar;
            this.f9399e = str2;
        }

        @Override // c.a.s0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.u1.i.e(this.a, this.f9396b);
                this.f9400f.E(this.a.a, this.f9397c, this.f9398d, this.f9396b, this.f9399e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.p.e.b f9401e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.m1.b f9402f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.g.g f9403g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9404h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f9405i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f9406j;

        public d(c cVar, c.a.s0.a.p.e.b bVar, c.a.s0.a.m1.b bVar2, c.a.s0.a.h0.g.g gVar, String str, String str2) {
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
            this.f9406j = cVar;
            this.f9401e = bVar;
            this.f9402f = bVar2;
            this.f9403g = gVar;
            this.f9404h = str;
            this.f9405i = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9406j.D(this.f9401e, this.f9402f, this.f9403g, this.f9404h, this.f9405i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.s0.a.h0.g.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.s0.a.h0.g.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f9407b;

        public e(c cVar, c.a.s0.a.h0.g.f fVar) {
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
            this.f9407b = cVar;
            this.a = fVar;
        }

        @Override // c.a.s0.a.h0.g.m.a, c.a.s0.a.h0.g.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.f9407b.f9381f != null) {
                    this.a.L2(this.f9407b.f9381f);
                }
            }
        }

        @Override // c.a.s0.a.h0.g.m.a, c.a.s0.a.h0.g.m.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c2 = c.a.s0.a.c2.b.a.c(this.a);
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                c.a.s0.a.c2.b.a.h(this.a);
            }
        }

        @Override // c.a.s0.a.h0.g.m.a, c.a.s0.a.h0.g.m.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c2 = c.a.s0.a.c2.b.a.c(this.a);
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                c.a.s0.a.c2.b.a.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(243143099, "Lc/a/s0/a/u/e/j/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(243143099, "Lc/a/s0/a/u/e/j/c;");
                return;
            }
        }
        f9380g = c.a.s0.a.c1.a.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.s0.a.u.c.b bVar) {
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
                super((c.a.s0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(c.a.s0.a.g1.f fVar, c.a.s0.a.h0.g.g gVar, c.a.s0.a.m1.b bVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{fVar, gVar, bVar, str, str2, str3}) == null) {
            q0.a0(new b(this, fVar, str3, bVar, str, gVar, str2));
        }
    }

    public final void D(c.a.s0.a.p.e.b bVar, c.a.s0.a.m1.b bVar2, c.a.s0.a.h0.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(bVar, bVar2, gVar, str);
            } else {
                G(bVar, bVar2, gVar, str);
            }
        }
    }

    public final void E(c.a.s0.a.p.e.b bVar, c.a.s0.a.m1.b bVar2, c.a.s0.a.h0.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bVar2, gVar, str, str2) == null) {
            if (q0.O()) {
                D(bVar, bVar2, gVar, str, str2);
            } else {
                q0.a0(new d(this, bVar, bVar2, gVar, str, str2));
            }
        }
    }

    public final void F(c.a.s0.a.p.e.b bVar, c.a.s0.a.m1.b bVar2, c.a.s0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        c.a.s0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.s0.a.g1.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.s0.a.f2.f.o0.a.e(bVar, bVar2, str);
        c.a.s0.a.u1.i.c(9, str);
        c.a.s0.a.h0.g.f.M3(q0.n());
        g.b k = gVar.i("showModalPage").k("normal", bVar2);
        if ((gVar.m() instanceof c.a.s0.a.h0.g.f) && (fVar = (c.a.s0.a.h0.g.f) gVar.m()) != null) {
            fVar.H0 = true;
            k.b();
            if (gVar.k() > 1) {
                fVar.r3().setBackgroundColor(0);
            } else {
                fVar.H0 = false;
            }
            fVar.t2(false);
            c.a.s0.a.h0.g.m.a aVar = this.f9381f;
            if (aVar != null) {
                fVar.L2(aVar);
            }
            e eVar = new e(this, fVar);
            this.f9381f = eVar;
            fVar.h2(eVar);
            View c2 = c.a.s0.a.c2.b.a.c(fVar);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            c.a.s0.a.c2.b.a.h(fVar);
            PullToRefreshBaseWebView j0 = bVar.j0();
            if (j0 != null) {
                j0.setIsPreventPullToRefresh(true);
            }
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.s0.a.u1.i.a(str, bVar2);
        }
    }

    public final void G(c.a.s0.a.p.e.b bVar, c.a.s0.a.m1.b bVar2, c.a.s0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.s0.a.g1.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.s0.a.f2.f.o0.a.e(bVar, bVar2, str);
        c.a.s0.a.u1.i.c(0, str);
        if (gVar.k() < f9380g) {
            c.a.s0.a.h0.g.f.M3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(c.a.s0.a.h0.g.g.f6641g, c.a.s0.a.h0.g.g.f6643i);
            i2.k("normal", bVar2).b();
            c.a.s0.a.z2.g.c(gVar, getContext());
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.s0.a.u1.i.a(str, bVar2);
            return;
        }
        c.a.s0.a.u.e.j.d.A(gVar, bVar2, str, true);
    }

    public c.a.s0.a.u.h.b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    public final c.a.s0.a.u.h.b I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            c.a.s0.a.d2.e a0 = c.a.s0.a.d2.e.a0();
            if (a0 == null) {
                return new c.a.s0.a.u.h.b(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            c.a.s0.a.u1.i.b(uuid);
            Pair<c.a.s0.a.u.h.b, JSONObject> s = s(str);
            c.a.s0.a.u.h.b bVar = (c.a.s0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = c.a.s0.a.f2.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    c.a.s0.a.e0.d.c("NavigateToApi", "url is null");
                    return new c.a.s0.a.u.h.b(202, "url is null");
                }
                c.a.s0.a.g1.f U = c.a.s0.a.g1.f.U();
                c.a.s0.a.h0.g.g V = U.V();
                if (V == null) {
                    c.a.s0.a.e0.d.c("NavigateToApi", "manager is null");
                    return new c.a.s0.a.u.h.b(1001, "manager is null");
                }
                c.a.s0.a.m1.b e2 = c.a.s0.a.m1.b.e(p, U.z());
                e2.f7918i = str2;
                e2.f7919j = uuid;
                c.a.s0.a.n2.i.g(e2);
                if (!q0.b(U.s(), e2, false)) {
                    String str4 = "page params error : path=" + e2.f7914e + " ; routePath=" + e2.f7917h;
                    c.a.s0.a.e0.d.c("NavigateToApi", str4);
                    c.a.s0.a.n2.i.i(e2);
                    return new c.a.s0.a.u.h.b(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(e2.f7917h) && c.a.s0.a.d2.e.L() != null) {
                    c.a.s0.a.d2.e.L().K0(optString, e2.f7917h);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    c.a.s0.a.e0.d.c("NavigateToApi", "cb is empty");
                    c.a.s0.a.n2.i.i(e2);
                    return new c.a.s0.a.u.h.b(202, "cb is empty");
                } else if (c.a.s0.a.f2.f.f0.d.b().a(e2)) {
                    c.a.s0.a.f2.f.f0.d.b().i(str3, e2);
                    c.a.s0.a.e0.d.c("NavigateToApi", "access to this page is prohibited");
                    return new c.a.s0.a.u.h.b(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        a0.d0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, e2, uuid, str2));
                    } else {
                        C(U, V, e2, uuid, str2, optString3);
                    }
                    return c.a.s0.a.u.h.b.f();
                }
            }
            return bVar;
        }
        return (c.a.s0.a.u.h.b) invokeLLL.objValue;
    }

    public c.a.s0.a.u.h.b J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    public final void K(a.e eVar, c.a.s0.a.m1.b bVar, c.a.s0.a.h0.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, bVar, gVar, str, str2) == null) {
            boolean z = eVar != null && eVar.f7126b;
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            c.a.s0.a.h0.t.a.q(eVar, new C0600c(this, eVar, str, bVar, gVar, str2));
        }
    }

    @Override // c.a.s0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
