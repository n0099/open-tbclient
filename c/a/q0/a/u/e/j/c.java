package c.a.q0.a.u.e.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.f2.f.o0.g;
import c.a.q0.a.h0.g.g;
import c.a.q0.a.h0.t.a;
import c.a.q0.a.h2.c.i;
import c.a.q0.a.h2.c.j.b;
import c.a.q0.a.n2.n;
import c.a.q0.a.u1.h;
import c.a.q0.a.z2.q0;
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
public class c extends c.a.q0.a.u.e.j.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f8606g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.a.h0.g.m.a f8607f;

    /* loaded from: classes.dex */
    public class a implements c.a.q0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8608e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.g1.f f8609f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f8610g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.m1.b f8611h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8612i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f8613j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ c f8614k;

        public a(c cVar, String str, c.a.q0.a.g1.f fVar, g gVar, c.a.q0.a.m1.b bVar, String str2, String str3) {
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
            this.f8614k = cVar;
            this.f8608e = str;
            this.f8609f = fVar;
            this.f8610g = gVar;
            this.f8611h = bVar;
            this.f8612i = str2;
            this.f8613j = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.q0.a.h2.c.d.h(iVar)) {
                    this.f8614k.C(this.f8609f, this.f8610g, this.f8611h, this.f8612i, this.f8613j, this.f8608e);
                } else {
                    this.f8614k.d(this.f8608e, new c.a.q0.a.u.h.b(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.g1.f f8615e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8616f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.m1.b f8617g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8618h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8619i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f8620j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ c f8621k;

        /* loaded from: classes.dex */
        public class a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.q0.a.d2.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Activity f8622b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f8623c;

            public a(b bVar, c.a.q0.a.d2.e eVar, Activity activity) {
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
                this.f8623c = bVar;
                this.a = eVar;
                this.f8622b = activity;
            }

            @Override // c.a.q0.a.f2.f.o0.g.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    c.a.q0.a.u1.i.d(this.f8623c.f8618h);
                    c.a.q0.a.e0.d.i("NavigateToApi", "check pages success");
                    n.F(true, this.a.X().T());
                    this.f8623c.f8615e.o();
                    a.e f2 = c.a.q0.a.h0.t.a.f(this.f8622b, c.a.q0.a.h0.t.f.a.c(this.f8623c.f8617g.f7108e));
                    List<String> g2 = c.a.q0.a.f2.f.o0.a.g(this.f8623c.f8619i);
                    c cVar = this.f8623c.f8621k;
                    c.a.q0.a.d2.e eVar = this.a;
                    String c2 = f2.a.c();
                    b bVar = this.f8623c;
                    c.a.q0.a.f2.f.o0.a.m(cVar, eVar, c2, bVar.f8617g.f7108e, g2, bVar.f8616f);
                    b bVar2 = this.f8623c;
                    bVar2.f8621k.K(f2, bVar2.f8617g, bVar2.f8619i, bVar2.f8618h, bVar2.f8620j);
                }
            }

            @Override // c.a.q0.a.f2.f.o0.g.e
            public void b(int i2, c.a.q0.a.u2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    c.a.q0.a.e0.d.c("NavigateToApi", "check pages failed");
                    n.F(false, this.a.X().T());
                    this.f8623c.f8615e.o();
                    b bVar = this.f8623c;
                    c.a.q0.a.f2.f.o0.a.k(bVar.f8621k, bVar.f8616f);
                    c.a.q0.a.n2.i.j(this.f8623c.f8617g, aVar);
                }
            }
        }

        public b(c cVar, c.a.q0.a.g1.f fVar, String str, c.a.q0.a.m1.b bVar, String str2, c.a.q0.a.h0.g.g gVar, String str3) {
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
            this.f8621k = cVar;
            this.f8615e = fVar;
            this.f8616f = str;
            this.f8617g = bVar;
            this.f8618h = str2;
            this.f8619i = gVar;
            this.f8620j = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f8615e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    c.a.q0.a.d2.e L = c.a.q0.a.d2.e.L();
                    if (L == null) {
                        this.f8621k.d(this.f8616f, new c.a.q0.a.u.h.b(1001, "swan app is null"));
                        c.a.q0.a.n2.i.i(this.f8617g);
                        return;
                    }
                    this.f8615e.a();
                    c.a.q0.a.f2.f.o0.g.g(L, this.f8617g, "", new a(this, L, activity), this.f8618h);
                    return;
                }
                this.f8621k.d(this.f8616f, new c.a.q0.a.u.h.b(1001, "swan activity is null"));
                c.a.q0.a.n2.i.i(this.f8617g);
            }
        }
    }

    /* renamed from: c.a.q0.a.u.e.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0521c implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8624b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.m1.b f8625c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.g.g f8626d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8627e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f8628f;

        public C0521c(c cVar, a.e eVar, String str, c.a.q0.a.m1.b bVar, c.a.q0.a.h0.g.g gVar, String str2) {
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
            this.f8628f = cVar;
            this.a = eVar;
            this.f8624b = str;
            this.f8625c = bVar;
            this.f8626d = gVar;
            this.f8627e = str2;
        }

        @Override // c.a.q0.a.h0.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.u1.i.e(this.a, this.f8624b);
                this.f8628f.E(this.a.a, this.f8625c, this.f8626d, this.f8624b, this.f8627e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.p.e.b f8629e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.m1.b f8630f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.g.g f8631g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8632h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8633i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f8634j;

        public d(c cVar, c.a.q0.a.p.e.b bVar, c.a.q0.a.m1.b bVar2, c.a.q0.a.h0.g.g gVar, String str, String str2) {
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
            this.f8634j = cVar;
            this.f8629e = bVar;
            this.f8630f = bVar2;
            this.f8631g = gVar;
            this.f8632h = str;
            this.f8633i = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8634j.D(this.f8629e, this.f8630f, this.f8631g, this.f8632h, this.f8633i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.q0.a.h0.g.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.a.h0.g.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8635b;

        public e(c cVar, c.a.q0.a.h0.g.f fVar) {
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
            this.f8635b = cVar;
            this.a = fVar;
        }

        @Override // c.a.q0.a.h0.g.m.a, c.a.q0.a.h0.g.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.f8635b.f8607f != null) {
                    this.a.S2(this.f8635b.f8607f);
                }
            }
        }

        @Override // c.a.q0.a.h0.g.m.a, c.a.q0.a.h0.g.m.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c2 = c.a.q0.a.c2.b.a.c(this.a);
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                c.a.q0.a.c2.b.a.h(this.a);
            }
        }

        @Override // c.a.q0.a.h0.g.m.a, c.a.q0.a.h0.g.m.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c2 = c.a.q0.a.c2.b.a.c(this.a);
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                c.a.q0.a.c2.b.a.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(829949113, "Lc/a/q0/a/u/e/j/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(829949113, "Lc/a/q0/a/u/e/j/c;");
                return;
            }
        }
        f8606g = c.a.q0.a.c1.a.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.q0.a.u.c.b bVar) {
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
                super((c.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(c.a.q0.a.g1.f fVar, c.a.q0.a.h0.g.g gVar, c.a.q0.a.m1.b bVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{fVar, gVar, bVar, str, str2, str3}) == null) {
            q0.a0(new b(this, fVar, str3, bVar, str, gVar, str2));
        }
    }

    public final void D(c.a.q0.a.p.e.b bVar, c.a.q0.a.m1.b bVar2, c.a.q0.a.h0.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(bVar, bVar2, gVar, str);
            } else {
                G(bVar, bVar2, gVar, str);
            }
        }
    }

    public final void E(c.a.q0.a.p.e.b bVar, c.a.q0.a.m1.b bVar2, c.a.q0.a.h0.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bVar2, gVar, str, str2) == null) {
            if (q0.O()) {
                D(bVar, bVar2, gVar, str, str2);
            } else {
                q0.a0(new d(this, bVar, bVar2, gVar, str, str2));
            }
        }
    }

    public final void F(c.a.q0.a.p.e.b bVar, c.a.q0.a.m1.b bVar2, c.a.q0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        c.a.q0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.q0.a.g1.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.q0.a.f2.f.o0.a.e(bVar, bVar2, str);
        c.a.q0.a.u1.i.c(9, str);
        c.a.q0.a.h0.g.f.T3(q0.n());
        g.b k2 = gVar.i("showModalPage").k("normal", bVar2);
        if ((gVar.m() instanceof c.a.q0.a.h0.g.f) && (fVar = (c.a.q0.a.h0.g.f) gVar.m()) != null) {
            fVar.H0 = true;
            k2.b();
            if (gVar.k() > 1) {
                fVar.y3().setBackgroundColor(0);
            } else {
                fVar.H0 = false;
            }
            fVar.A2(false);
            c.a.q0.a.h0.g.m.a aVar = this.f8607f;
            if (aVar != null) {
                fVar.S2(aVar);
            }
            e eVar = new e(this, fVar);
            this.f8607f = eVar;
            fVar.o2(eVar);
            View c2 = c.a.q0.a.c2.b.a.c(fVar);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            c.a.q0.a.c2.b.a.h(fVar);
            PullToRefreshBaseWebView j0 = bVar.j0();
            if (j0 != null) {
                j0.setIsPreventPullToRefresh(true);
            }
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.q0.a.u1.i.a(str, bVar2);
        }
    }

    public final void G(c.a.q0.a.p.e.b bVar, c.a.q0.a.m1.b bVar2, c.a.q0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.q0.a.g1.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.q0.a.f2.f.o0.a.e(bVar, bVar2, str);
        c.a.q0.a.u1.i.c(0, str);
        if (gVar.k() < f8606g) {
            c.a.q0.a.h0.g.f.T3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(c.a.q0.a.h0.g.g.f5805g, c.a.q0.a.h0.g.g.f5807i);
            i2.k("normal", bVar2).b();
            c.a.q0.a.z2.g.c(gVar, getContext());
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.q0.a.u1.i.a(str, bVar2);
            return;
        }
        c.a.q0.a.u.e.j.d.A(gVar, bVar2, str, true);
    }

    public c.a.q0.a.u.h.b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (c.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final c.a.q0.a.u.h.b I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
            if (a0 == null) {
                return new c.a.q0.a.u.h.b(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            c.a.q0.a.u1.i.b(uuid);
            Pair<c.a.q0.a.u.h.b, JSONObject> s = s(str);
            c.a.q0.a.u.h.b bVar = (c.a.q0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = c.a.q0.a.f2.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    c.a.q0.a.e0.d.c("NavigateToApi", "url is null");
                    return new c.a.q0.a.u.h.b(202, "url is null");
                }
                c.a.q0.a.g1.f U = c.a.q0.a.g1.f.U();
                c.a.q0.a.h0.g.g V = U.V();
                if (V == null) {
                    c.a.q0.a.e0.d.c("NavigateToApi", "manager is null");
                    return new c.a.q0.a.u.h.b(1001, "manager is null");
                }
                c.a.q0.a.m1.b e2 = c.a.q0.a.m1.b.e(p, U.z());
                e2.f7112i = str2;
                e2.f7113j = uuid;
                c.a.q0.a.n2.i.g(e2);
                if (!q0.b(U.s(), e2, false)) {
                    String str4 = "page params error : path=" + e2.f7108e + " ; routePath=" + e2.f7111h;
                    c.a.q0.a.e0.d.c("NavigateToApi", str4);
                    c.a.q0.a.n2.i.i(e2);
                    return new c.a.q0.a.u.h.b(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(e2.f7111h) && c.a.q0.a.d2.e.L() != null) {
                    c.a.q0.a.d2.e.L().K0(optString, e2.f7111h);
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
                    c.a.q0.a.e0.d.c("NavigateToApi", "cb is empty");
                    c.a.q0.a.n2.i.i(e2);
                    return new c.a.q0.a.u.h.b(202, "cb is empty");
                } else if (c.a.q0.a.f2.f.f0.d.b().a(e2)) {
                    c.a.q0.a.f2.f.f0.d.b().i(str3, e2);
                    c.a.q0.a.e0.d.c("NavigateToApi", "access to this page is prohibited");
                    return new c.a.q0.a.u.h.b(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        a0.d0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, e2, uuid, str2));
                    } else {
                        C(U, V, e2, uuid, str2, optString3);
                    }
                    return c.a.q0.a.u.h.b.f();
                }
            }
            return bVar;
        }
        return (c.a.q0.a.u.h.b) invokeLLL.objValue;
    }

    public c.a.q0.a.u.h.b J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (c.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final void K(a.e eVar, c.a.q0.a.m1.b bVar, c.a.q0.a.h0.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, bVar, gVar, str, str2) == null) {
            boolean z = eVar != null && eVar.f6299b;
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            c.a.q0.a.h0.t.a.q(eVar, new C0521c(this, eVar, str, bVar, gVar, str2));
        }
    }

    @Override // c.a.q0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
