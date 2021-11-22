package b.a.p0.a.u.e.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f2.f.o0.g;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.h0.t.a;
import b.a.p0.a.h2.c.i;
import b.a.p0.a.h2.c.j.b;
import b.a.p0.a.n2.n;
import b.a.p0.a.u1.h;
import b.a.p0.a.z2.q0;
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
public class c extends b.a.p0.a.u.e.j.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f8745g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.h0.g.m.a f8746f;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8747e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.g1.f f8748f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f8749g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f8750h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8751i;
        public final /* synthetic */ String j;
        public final /* synthetic */ c k;

        public a(c cVar, String str, b.a.p0.a.g1.f fVar, g gVar, b.a.p0.a.m1.b bVar, String str2, String str3) {
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
            this.f8747e = str;
            this.f8748f = fVar;
            this.f8749g = gVar;
            this.f8750h = bVar;
            this.f8751i = str2;
            this.j = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.h2.c.d.h(iVar)) {
                    this.k.C(this.f8748f, this.f8749g, this.f8750h, this.f8751i, this.j, this.f8747e);
                } else {
                    this.k.d(this.f8747e, new b.a.p0.a.u.h.b(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.g1.f f8752e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8753f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f8754g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8755h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8756i;
        public final /* synthetic */ String j;
        public final /* synthetic */ c k;

        /* loaded from: classes.dex */
        public class a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.d2.e f8757a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Activity f8758b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f8759c;

            public a(b bVar, b.a.p0.a.d2.e eVar, Activity activity) {
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
                this.f8759c = bVar;
                this.f8757a = eVar;
                this.f8758b = activity;
            }

            @Override // b.a.p0.a.f2.f.o0.g.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b.a.p0.a.u1.i.d(this.f8759c.f8755h);
                    b.a.p0.a.e0.d.i("NavigateToApi", "check pages success");
                    n.F(true, this.f8757a.X().T());
                    this.f8759c.f8752e.n();
                    a.e f2 = b.a.p0.a.h0.t.a.f(this.f8758b, b.a.p0.a.h0.t.f.a.c(this.f8759c.f8754g.f7014e));
                    List<String> g2 = b.a.p0.a.f2.f.o0.a.g(this.f8759c.f8756i);
                    c cVar = this.f8759c.k;
                    b.a.p0.a.d2.e eVar = this.f8757a;
                    String c2 = f2.f6108a.c();
                    b bVar = this.f8759c;
                    b.a.p0.a.f2.f.o0.a.m(cVar, eVar, c2, bVar.f8754g.f7014e, g2, bVar.f8753f);
                    b bVar2 = this.f8759c;
                    bVar2.k.K(f2, bVar2.f8754g, bVar2.f8756i, bVar2.f8755h, bVar2.j);
                }
            }

            @Override // b.a.p0.a.f2.f.o0.g.e
            public void b(int i2, b.a.p0.a.u2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    b.a.p0.a.e0.d.c("NavigateToApi", "check pages failed");
                    n.F(false, this.f8757a.X().T());
                    this.f8759c.f8752e.n();
                    b bVar = this.f8759c;
                    b.a.p0.a.f2.f.o0.a.k(bVar.k, bVar.f8753f);
                    b.a.p0.a.n2.i.j(this.f8759c.f8754g, aVar);
                }
            }
        }

        public b(c cVar, b.a.p0.a.g1.f fVar, String str, b.a.p0.a.m1.b bVar, String str2, b.a.p0.a.h0.g.g gVar, String str3) {
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
            this.f8752e = fVar;
            this.f8753f = str;
            this.f8754g = bVar;
            this.f8755h = str2;
            this.f8756i = gVar;
            this.j = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f8752e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
                    if (L == null) {
                        this.k.d(this.f8753f, new b.a.p0.a.u.h.b(1001, "swan app is null"));
                        b.a.p0.a.n2.i.i(this.f8754g);
                        return;
                    }
                    this.f8752e.t();
                    b.a.p0.a.f2.f.o0.g.g(L, this.f8754g, "", new a(this, L, activity), this.f8755h);
                    return;
                }
                this.k.d(this.f8753f, new b.a.p0.a.u.h.b(1001, "swan activity is null"));
                b.a.p0.a.n2.i.i(this.f8754g);
            }
        }
    }

    /* renamed from: b.a.p0.a.u.e.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0431c implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f8760a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8761b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f8762c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f8763d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8764e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f8765f;

        public C0431c(c cVar, a.e eVar, String str, b.a.p0.a.m1.b bVar, b.a.p0.a.h0.g.g gVar, String str2) {
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
            this.f8765f = cVar;
            this.f8760a = eVar;
            this.f8761b = str;
            this.f8762c = bVar;
            this.f8763d = gVar;
            this.f8764e = str2;
        }

        @Override // b.a.p0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.u1.i.e(this.f8760a, this.f8761b);
                this.f8765f.E(this.f8760a.f6108a, this.f8762c, this.f8763d, this.f8761b, this.f8764e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f8766e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m1.b f8767f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.g f8768g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8769h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8770i;
        public final /* synthetic */ c j;

        public d(c cVar, b.a.p0.a.p.e.b bVar, b.a.p0.a.m1.b bVar2, b.a.p0.a.h0.g.g gVar, String str, String str2) {
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
            this.j = cVar;
            this.f8766e = bVar;
            this.f8767f = bVar2;
            this.f8768g = gVar;
            this.f8769h = str;
            this.f8770i = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.D(this.f8766e, this.f8767f, this.f8768g, this.f8769h, this.f8770i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends b.a.p0.a.h0.g.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.f f8771a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8772b;

        public e(c cVar, b.a.p0.a.h0.g.f fVar) {
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
            this.f8772b = cVar;
            this.f8771a = fVar;
        }

        @Override // b.a.p0.a.h0.g.m.a, b.a.p0.a.h0.g.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.f8772b.f8746f != null) {
                    this.f8771a.O2(this.f8772b.f8746f);
                }
            }
        }

        @Override // b.a.p0.a.h0.g.m.a, b.a.p0.a.h0.g.m.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c2 = b.a.p0.a.c2.b.a.c(this.f8771a);
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                b.a.p0.a.c2.b.a.h(this.f8771a);
            }
        }

        @Override // b.a.p0.a.h0.g.m.a, b.a.p0.a.h0.g.m.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c2 = b.a.p0.a.c2.b.a.c(this.f8771a);
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                b.a.p0.a.c2.b.a.h(this.f8771a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229957577, "Lb/a/p0/a/u/e/j/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-229957577, "Lb/a/p0/a/u/e/j/c;");
                return;
            }
        }
        f8745g = b.a.p0.a.c1.a.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(b.a.p0.a.g1.f fVar, b.a.p0.a.h0.g.g gVar, b.a.p0.a.m1.b bVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{fVar, gVar, bVar, str, str2, str3}) == null) {
            q0.a0(new b(this, fVar, str3, bVar, str, gVar, str2));
        }
    }

    public final void D(b.a.p0.a.p.e.b bVar, b.a.p0.a.m1.b bVar2, b.a.p0.a.h0.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(bVar, bVar2, gVar, str);
            } else {
                G(bVar, bVar2, gVar, str);
            }
        }
    }

    public final void E(b.a.p0.a.p.e.b bVar, b.a.p0.a.m1.b bVar2, b.a.p0.a.h0.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bVar2, gVar, str, str2) == null) {
            if (q0.O()) {
                D(bVar, bVar2, gVar, str, str2);
            } else {
                q0.a0(new d(this, bVar, bVar2, gVar, str, str2));
            }
        }
    }

    public final void F(b.a.p0.a.p.e.b bVar, b.a.p0.a.m1.b bVar2, b.a.p0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        b.a.p0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, bVar, bVar2, gVar, str) == null) || (activity = b.a.p0.a.g1.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        b.a.p0.a.f2.f.o0.a.e(bVar, bVar2, str);
        b.a.p0.a.u1.i.c(9, str);
        b.a.p0.a.h0.g.f.P3(q0.n());
        g.b k = gVar.i("showModalPage").k("normal", bVar2);
        if ((gVar.m() instanceof b.a.p0.a.h0.g.f) && (fVar = (b.a.p0.a.h0.g.f) gVar.m()) != null) {
            fVar.G0 = true;
            k.b();
            if (gVar.k() > 1) {
                fVar.u3().setBackgroundColor(0);
            } else {
                fVar.G0 = false;
            }
            fVar.w2(false);
            b.a.p0.a.h0.g.m.a aVar = this.f8746f;
            if (aVar != null) {
                fVar.O2(aVar);
            }
            e eVar = new e(this, fVar);
            this.f8746f = eVar;
            fVar.k2(eVar);
            View c2 = b.a.p0.a.c2.b.a.c(fVar);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            b.a.p0.a.c2.b.a.h(fVar);
            PullToRefreshBaseWebView j0 = bVar.j0();
            if (j0 != null) {
                j0.setIsPreventPullToRefresh(true);
            }
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            b.a.p0.a.u1.i.a(str, bVar2);
        }
    }

    public final void G(b.a.p0.a.p.e.b bVar, b.a.p0.a.m1.b bVar2, b.a.p0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, bVar, bVar2, gVar, str) == null) || (activity = b.a.p0.a.g1.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        b.a.p0.a.f2.f.o0.a.e(bVar, bVar2, str);
        b.a.p0.a.u1.i.c(0, str);
        if (gVar.k() < f8745g) {
            b.a.p0.a.h0.g.f.P3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(b.a.p0.a.h0.g.g.f5478g, b.a.p0.a.h0.g.g.f5480i);
            i2.k("normal", bVar2).b();
            b.a.p0.a.z2.g.c(gVar, getContext());
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            b.a.p0.a.u1.i.a(str, bVar2);
            return;
        }
        b.a.p0.a.u.e.j.d.A(gVar, bVar2, str, true);
    }

    public b.a.p0.a.u.h.b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final b.a.p0.a.u.h.b I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            b.a.p0.a.u1.i.b(uuid);
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = b.a.p0.a.f2.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    b.a.p0.a.e0.d.c("NavigateToApi", "url is null");
                    return new b.a.p0.a.u.h.b(202, "url is null");
                }
                b.a.p0.a.g1.f U = b.a.p0.a.g1.f.U();
                b.a.p0.a.h0.g.g V = U.V();
                if (V == null) {
                    b.a.p0.a.e0.d.c("NavigateToApi", "manager is null");
                    return new b.a.p0.a.u.h.b(1001, "manager is null");
                }
                b.a.p0.a.m1.b e2 = b.a.p0.a.m1.b.e(p, U.z());
                e2.f7018i = str2;
                e2.j = uuid;
                b.a.p0.a.n2.i.g(e2);
                if (!q0.b(U.r(), e2, false)) {
                    String str4 = "page params error : path=" + e2.f7014e + " ; routePath=" + e2.f7017h;
                    b.a.p0.a.e0.d.c("NavigateToApi", str4);
                    b.a.p0.a.n2.i.i(e2);
                    return new b.a.p0.a.u.h.b(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(e2.f7017h) && b.a.p0.a.d2.e.L() != null) {
                    b.a.p0.a.d2.e.L().K0(optString, e2.f7017h);
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
                    b.a.p0.a.e0.d.c("NavigateToApi", "cb is empty");
                    b.a.p0.a.n2.i.i(e2);
                    return new b.a.p0.a.u.h.b(202, "cb is empty");
                } else if (b.a.p0.a.f2.f.f0.d.b().a(e2)) {
                    b.a.p0.a.f2.f.f0.d.b().i(str3, e2);
                    b.a.p0.a.e0.d.c("NavigateToApi", "access to this page is prohibited");
                    return new b.a.p0.a.u.h.b(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        a0.d0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, e2, uuid, str2));
                    } else {
                        C(U, V, e2, uuid, str2, optString3);
                    }
                    return b.a.p0.a.u.h.b.f();
                }
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeLLL.objValue;
    }

    public b.a.p0.a.u.h.b J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void K(a.e eVar, b.a.p0.a.m1.b bVar, b.a.p0.a.h0.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, bVar, gVar, str, str2) == null) {
            boolean z = eVar != null && eVar.f6109b;
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            b.a.p0.a.h0.t.a.q(eVar, new C0431c(this, eVar, str, bVar, gVar, str2));
        }
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
