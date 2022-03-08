package c.a.p0.a.k.e.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.n;
import c.a.p0.a.k1.h;
import c.a.p0.a.p2.q0;
import c.a.p0.a.v1.f.o0.g;
import c.a.p0.a.x.g.g;
import c.a.p0.a.x.t.a;
import c.a.p0.a.x1.c.i;
import c.a.p0.a.x1.c.j.b;
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
public class c extends c.a.p0.a.k.e.j.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f6108g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.x.g.m.a f6109f;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6110e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.w0.f f6111f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f6112g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f6113h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6114i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f6115j;
        public final /* synthetic */ c k;

        public a(c cVar, String str, c.a.p0.a.w0.f fVar, g gVar, c.a.p0.a.c1.b bVar, String str2, String str3) {
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
            this.f6110e = str;
            this.f6111f = fVar;
            this.f6112g = gVar;
            this.f6113h = bVar;
            this.f6114i = str2;
            this.f6115j = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.x1.c.d.h(iVar)) {
                    this.k.C(this.f6111f, this.f6112g, this.f6113h, this.f6114i, this.f6115j, this.f6110e);
                } else {
                    this.k.d(this.f6110e, new c.a.p0.a.k.h.b(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.w0.f f6116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6117f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f6118g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6119h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f6120i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f6121j;
        public final /* synthetic */ c k;

        /* loaded from: classes.dex */
        public class a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.p0.a.t1.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Activity f6122b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f6123c;

            public a(b bVar, c.a.p0.a.t1.e eVar, Activity activity) {
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
                this.f6123c = bVar;
                this.a = eVar;
                this.f6122b = activity;
            }

            @Override // c.a.p0.a.v1.f.o0.g.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    c.a.p0.a.k1.i.d(this.f6123c.f6119h);
                    c.a.p0.a.u.d.i("NavigateToApi", "check pages success");
                    n.F(true, this.a.X().T());
                    this.f6123c.f6116e.o();
                    a.e f2 = c.a.p0.a.x.t.a.f(this.f6122b, c.a.p0.a.x.t.f.a.c(this.f6123c.f6118g.f4642e));
                    List<String> g2 = c.a.p0.a.v1.f.o0.a.g(this.f6123c.f6120i);
                    c cVar = this.f6123c.k;
                    c.a.p0.a.t1.e eVar = this.a;
                    String c2 = f2.a.c();
                    b bVar = this.f6123c;
                    c.a.p0.a.v1.f.o0.a.m(cVar, eVar, c2, bVar.f6118g.f4642e, g2, bVar.f6117f);
                    b bVar2 = this.f6123c;
                    bVar2.k.K(f2, bVar2.f6118g, bVar2.f6120i, bVar2.f6119h, bVar2.f6121j);
                }
            }

            @Override // c.a.p0.a.v1.f.o0.g.e
            public void c(int i2, c.a.p0.a.k2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    c.a.p0.a.u.d.c("NavigateToApi", "check pages failed");
                    n.F(false, this.a.X().T());
                    this.f6123c.f6116e.o();
                    b bVar = this.f6123c;
                    c.a.p0.a.v1.f.o0.a.k(bVar.k, bVar.f6117f);
                    c.a.p0.a.d2.i.j(this.f6123c.f6118g, aVar);
                }
            }
        }

        public b(c cVar, c.a.p0.a.w0.f fVar, String str, c.a.p0.a.c1.b bVar, String str2, c.a.p0.a.x.g.g gVar, String str3) {
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
            this.f6116e = fVar;
            this.f6117f = str;
            this.f6118g = bVar;
            this.f6119h = str2;
            this.f6120i = gVar;
            this.f6121j = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f6116e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
                    if (L == null) {
                        this.k.d(this.f6117f, new c.a.p0.a.k.h.b(1001, "swan app is null"));
                        c.a.p0.a.d2.i.i(this.f6118g);
                        return;
                    }
                    this.f6116e.a();
                    c.a.p0.a.v1.f.o0.g.g(L, this.f6118g, "", new a(this, L, activity), this.f6119h);
                    return;
                }
                this.k.d(this.f6117f, new c.a.p0.a.k.h.b(1001, "swan activity is null"));
                c.a.p0.a.d2.i.i(this.f6118g);
            }
        }
    }

    /* renamed from: c.a.p0.a.k.e.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0357c implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6124b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f6125c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.g f6126d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6127e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f6128f;

        public C0357c(c cVar, a.e eVar, String str, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar, String str2) {
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
            this.f6128f = cVar;
            this.a = eVar;
            this.f6124b = str;
            this.f6125c = bVar;
            this.f6126d = gVar;
            this.f6127e = str2;
        }

        @Override // c.a.p0.a.x.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.k1.i.e(this.a, this.f6124b);
                this.f6128f.E(this.a.a, this.f6125c, this.f6126d, this.f6124b, this.f6127e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f.e.b f6129e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c1.b f6130f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.g f6131g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6132h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6133i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f6134j;

        public d(c cVar, c.a.p0.a.f.e.b bVar, c.a.p0.a.c1.b bVar2, c.a.p0.a.x.g.g gVar, String str, String str2) {
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
            this.f6134j = cVar;
            this.f6129e = bVar;
            this.f6130f = bVar2;
            this.f6131g = gVar;
            this.f6132h = str;
            this.f6133i = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6134j.D(this.f6129e, this.f6130f, this.f6131g, this.f6132h, this.f6133i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.p0.a.x.g.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.x.g.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f6135b;

        public e(c cVar, c.a.p0.a.x.g.f fVar) {
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
            this.f6135b = cVar;
            this.a = fVar;
        }

        @Override // c.a.p0.a.x.g.m.a, c.a.p0.a.x.g.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.f6135b.f6109f != null) {
                    this.a.L2(this.f6135b.f6109f);
                }
            }
        }

        @Override // c.a.p0.a.x.g.m.a, c.a.p0.a.x.g.m.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c2 = c.a.p0.a.s1.b.a.c(this.a);
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                c.a.p0.a.s1.b.a.h(this.a);
            }
        }

        @Override // c.a.p0.a.x.g.m.a, c.a.p0.a.x.g.m.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c2 = c.a.p0.a.s1.b.a.c(this.a);
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                c.a.p0.a.s1.b.a.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(875117954, "Lc/a/p0/a/k/e/j/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(875117954, "Lc/a/p0/a/k/e/j/c;");
                return;
            }
        }
        f6108g = c.a.p0.a.s0.a.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.p0.a.k.c.b bVar) {
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
                super((c.a.p0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(c.a.p0.a.w0.f fVar, c.a.p0.a.x.g.g gVar, c.a.p0.a.c1.b bVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{fVar, gVar, bVar, str, str2, str3}) == null) {
            q0.a0(new b(this, fVar, str3, bVar, str, gVar, str2));
        }
    }

    public final void D(c.a.p0.a.f.e.b bVar, c.a.p0.a.c1.b bVar2, c.a.p0.a.x.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(bVar, bVar2, gVar, str);
            } else {
                G(bVar, bVar2, gVar, str);
            }
        }
    }

    public final void E(c.a.p0.a.f.e.b bVar, c.a.p0.a.c1.b bVar2, c.a.p0.a.x.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bVar2, gVar, str, str2) == null) {
            if (q0.O()) {
                D(bVar, bVar2, gVar, str, str2);
            } else {
                q0.a0(new d(this, bVar, bVar2, gVar, str, str2));
            }
        }
    }

    public final void F(c.a.p0.a.f.e.b bVar, c.a.p0.a.c1.b bVar2, c.a.p0.a.x.g.g gVar, String str) {
        SwanAppActivity activity;
        c.a.p0.a.x.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.p0.a.w0.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.p0.a.v1.f.o0.a.e(bVar, bVar2, str);
        c.a.p0.a.k1.i.c(9, str);
        c.a.p0.a.x.g.f.M3(q0.n());
        g.b k = gVar.i("showModalPage").k("normal", bVar2);
        if ((gVar.m() instanceof c.a.p0.a.x.g.f) && (fVar = (c.a.p0.a.x.g.f) gVar.m()) != null) {
            fVar.H0 = true;
            k.b();
            if (gVar.k() > 1) {
                fVar.r3().setBackgroundColor(0);
            } else {
                fVar.H0 = false;
            }
            fVar.t2(false);
            c.a.p0.a.x.g.m.a aVar = this.f6109f;
            if (aVar != null) {
                fVar.L2(aVar);
            }
            e eVar = new e(this, fVar);
            this.f6109f = eVar;
            fVar.h2(eVar);
            View c2 = c.a.p0.a.s1.b.a.c(fVar);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            c.a.p0.a.s1.b.a.h(fVar);
            PullToRefreshBaseWebView j0 = bVar.j0();
            if (j0 != null) {
                j0.setIsPreventPullToRefresh(true);
            }
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.p0.a.k1.i.a(str, bVar2);
        }
    }

    public final void G(c.a.p0.a.f.e.b bVar, c.a.p0.a.c1.b bVar2, c.a.p0.a.x.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.p0.a.w0.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.p0.a.v1.f.o0.a.e(bVar, bVar2, str);
        c.a.p0.a.k1.i.c(0, str);
        if (gVar.k() < f6108g) {
            c.a.p0.a.x.g.f.M3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(c.a.p0.a.x.g.g.f8374g, c.a.p0.a.x.g.g.f8376i);
            i2.k("normal", bVar2).b();
            c.a.p0.a.p2.g.c(gVar, getContext());
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.p0.a.k1.i.a(str, bVar2);
            return;
        }
        c.a.p0.a.k.e.j.d.A(gVar, bVar2, str, true);
    }

    public c.a.p0.a.k.h.b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    public final c.a.p0.a.k.h.b I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null) {
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            c.a.p0.a.k1.i.b(uuid);
            Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
            c.a.p0.a.k.h.b bVar = (c.a.p0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = c.a.p0.a.v1.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    c.a.p0.a.u.d.c("NavigateToApi", "url is null");
                    return new c.a.p0.a.k.h.b(202, "url is null");
                }
                c.a.p0.a.w0.f U = c.a.p0.a.w0.f.U();
                c.a.p0.a.x.g.g V = U.V();
                if (V == null) {
                    c.a.p0.a.u.d.c("NavigateToApi", "manager is null");
                    return new c.a.p0.a.k.h.b(1001, "manager is null");
                }
                c.a.p0.a.c1.b e2 = c.a.p0.a.c1.b.e(p, U.z());
                e2.f4646i = str2;
                e2.f4647j = uuid;
                c.a.p0.a.d2.i.g(e2);
                if (!q0.b(U.s(), e2, false)) {
                    String str4 = "page params error : path=" + e2.f4642e + " ; routePath=" + e2.f4645h;
                    c.a.p0.a.u.d.c("NavigateToApi", str4);
                    c.a.p0.a.d2.i.i(e2);
                    return new c.a.p0.a.k.h.b(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(e2.f4645h) && c.a.p0.a.t1.e.L() != null) {
                    c.a.p0.a.t1.e.L().K0(optString, e2.f4645h);
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
                    c.a.p0.a.u.d.c("NavigateToApi", "cb is empty");
                    c.a.p0.a.d2.i.i(e2);
                    return new c.a.p0.a.k.h.b(202, "cb is empty");
                } else if (c.a.p0.a.v1.f.f0.d.b().a(e2)) {
                    c.a.p0.a.v1.f.f0.d.b().i(str3, e2);
                    c.a.p0.a.u.d.c("NavigateToApi", "access to this page is prohibited");
                    return new c.a.p0.a.k.h.b(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        a0.d0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, e2, uuid, str2));
                    } else {
                        C(U, V, e2, uuid, str2, optString3);
                    }
                    return c.a.p0.a.k.h.b.f();
                }
            }
            return bVar;
        }
        return (c.a.p0.a.k.h.b) invokeLLL.objValue;
    }

    public c.a.p0.a.k.h.b J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    public final void K(a.e eVar, c.a.p0.a.c1.b bVar, c.a.p0.a.x.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, bVar, gVar, str, str2) == null) {
            boolean z = eVar != null && eVar.f8859b;
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            c.a.p0.a.x.t.a.q(eVar, new C0357c(this, eVar, str, bVar, gVar, str2));
        }
    }

    @Override // c.a.p0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
