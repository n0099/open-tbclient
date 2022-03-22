package c.a.n0.a.k.e.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.k1.h;
import c.a.n0.a.p2.q0;
import c.a.n0.a.v1.f.o0.g;
import c.a.n0.a.x.g.g;
import c.a.n0.a.x.t.a;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
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
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.k.e.j.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5136g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.a.x.g.m.a f5137f;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.w0.f f5138b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f5139c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f5140d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5141e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5142f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f5143g;

        public a(c cVar, String str, c.a.n0.a.w0.f fVar, g gVar, c.a.n0.a.c1.b bVar, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, fVar, gVar, bVar, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5143g = cVar;
            this.a = str;
            this.f5138b = fVar;
            this.f5139c = gVar;
            this.f5140d = bVar;
            this.f5141e = str2;
            this.f5142f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    this.f5143g.C(this.f5138b, this.f5139c, this.f5140d, this.f5141e, this.f5142f, this.a);
                } else {
                    this.f5143g.d(this.a, new c.a.n0.a.k.h.b(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.w0.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5144b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f5145c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5146d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f5147e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5148f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f5149g;

        /* loaded from: classes.dex */
        public class a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.t1.e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Activity f5150b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f5151c;

            public a(b bVar, c.a.n0.a.t1.e eVar, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, eVar, activity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5151c = bVar;
                this.a = eVar;
                this.f5150b = activity;
            }

            @Override // c.a.n0.a.v1.f.o0.g.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    c.a.n0.a.k1.i.d(this.f5151c.f5146d);
                    c.a.n0.a.u.d.i("NavigateToApi", "check pages success");
                    n.F(true, this.a.X().T());
                    this.f5151c.a.o();
                    a.e f2 = c.a.n0.a.x.t.a.f(this.f5150b, c.a.n0.a.x.t.f.a.c(this.f5151c.f5145c.a));
                    List<String> g2 = c.a.n0.a.v1.f.o0.a.g(this.f5151c.f5147e);
                    c cVar = this.f5151c.f5149g;
                    c.a.n0.a.t1.e eVar = this.a;
                    String c2 = f2.a.c();
                    b bVar = this.f5151c;
                    c.a.n0.a.v1.f.o0.a.m(cVar, eVar, c2, bVar.f5145c.a, g2, bVar.f5144b);
                    b bVar2 = this.f5151c;
                    bVar2.f5149g.K(f2, bVar2.f5145c, bVar2.f5147e, bVar2.f5146d, bVar2.f5148f);
                }
            }

            @Override // c.a.n0.a.v1.f.o0.g.e
            public void c(int i, c.a.n0.a.k2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, aVar) == null) {
                    c.a.n0.a.u.d.c("NavigateToApi", "check pages failed");
                    n.F(false, this.a.X().T());
                    this.f5151c.a.o();
                    b bVar = this.f5151c;
                    c.a.n0.a.v1.f.o0.a.k(bVar.f5149g, bVar.f5144b);
                    c.a.n0.a.d2.i.j(this.f5151c.f5145c, aVar);
                }
            }
        }

        public b(c cVar, c.a.n0.a.w0.f fVar, String str, c.a.n0.a.c1.b bVar, String str2, c.a.n0.a.x.g.g gVar, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar, str, bVar, str2, gVar, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5149g = cVar;
            this.a = fVar;
            this.f5144b = str;
            this.f5145c = bVar;
            this.f5146d = str2;
            this.f5147e = gVar;
            this.f5148f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
                    if (L == null) {
                        this.f5149g.d(this.f5144b, new c.a.n0.a.k.h.b(1001, "swan app is null"));
                        c.a.n0.a.d2.i.i(this.f5145c);
                        return;
                    }
                    this.a.a();
                    c.a.n0.a.v1.f.o0.g.g(L, this.f5145c, "", new a(this, L, activity), this.f5146d);
                    return;
                }
                this.f5149g.d(this.f5144b, new c.a.n0.a.k.h.b(1001, "swan activity is null"));
                c.a.n0.a.d2.i.i(this.f5145c);
            }
        }
    }

    /* renamed from: c.a.n0.a.k.e.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0345c implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5152b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f5153c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.g.g f5154d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5155e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f5156f;

        public C0345c(c cVar, a.e eVar, String str, c.a.n0.a.c1.b bVar, c.a.n0.a.x.g.g gVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, eVar, str, bVar, gVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5156f = cVar;
            this.a = eVar;
            this.f5152b = str;
            this.f5153c = bVar;
            this.f5154d = gVar;
            this.f5155e = str2;
        }

        @Override // c.a.n0.a.x.t.a.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.k1.i.e(this.a, this.f5152b);
                this.f5156f.E(this.a.a, this.f5153c, this.f5154d, this.f5152b, this.f5155e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.f.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.c1.b f5157b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.g.g f5158c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5159d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5160e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f5161f;

        public d(c cVar, c.a.n0.a.f.e.b bVar, c.a.n0.a.c1.b bVar2, c.a.n0.a.x.g.g gVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar, bVar2, gVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5161f = cVar;
            this.a = bVar;
            this.f5157b = bVar2;
            this.f5158c = gVar;
            this.f5159d = str;
            this.f5160e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5161f.D(this.a, this.f5157b, this.f5158c, this.f5159d, this.f5160e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.n0.a.x.g.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.x.g.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f5162b;

        public e(c cVar, c.a.n0.a.x.g.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5162b = cVar;
            this.a = fVar;
        }

        @Override // c.a.n0.a.x.g.m.a, c.a.n0.a.x.g.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.f5162b.f5137f != null) {
                    this.a.P2(this.f5162b.f5137f);
                }
            }
        }

        @Override // c.a.n0.a.x.g.m.a, c.a.n0.a.x.g.m.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c2 = c.a.n0.a.s1.b.a.c(this.a);
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                c.a.n0.a.s1.b.a.h(this.a);
            }
        }

        @Override // c.a.n0.a.x.g.m.a, c.a.n0.a.x.g.m.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c2 = c.a.n0.a.s1.b.a.c(this.a);
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                c.a.n0.a.s1.b.a.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1461923968, "Lc/a/n0/a/k/e/j/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1461923968, "Lc/a/n0/a/k/e/j/c;");
                return;
            }
        }
        f5136g = c.a.n0.a.s0.a.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(c.a.n0.a.w0.f fVar, c.a.n0.a.x.g.g gVar, c.a.n0.a.c1.b bVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{fVar, gVar, bVar, str, str2, str3}) == null) {
            q0.a0(new b(this, fVar, str3, bVar, str, gVar, str2));
        }
    }

    public final void D(c.a.n0.a.f.e.b bVar, c.a.n0.a.c1.b bVar2, c.a.n0.a.x.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(bVar, bVar2, gVar, str);
            } else {
                G(bVar, bVar2, gVar, str);
            }
        }
    }

    public final void E(c.a.n0.a.f.e.b bVar, c.a.n0.a.c1.b bVar2, c.a.n0.a.x.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bVar2, gVar, str, str2) == null) {
            if (q0.O()) {
                D(bVar, bVar2, gVar, str, str2);
            } else {
                q0.a0(new d(this, bVar, bVar2, gVar, str, str2));
            }
        }
    }

    public final void F(c.a.n0.a.f.e.b bVar, c.a.n0.a.c1.b bVar2, c.a.n0.a.x.g.g gVar, String str) {
        SwanAppActivity activity;
        c.a.n0.a.x.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.n0.a.w0.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.n0.a.v1.f.o0.a.e(bVar, bVar2, str);
        c.a.n0.a.k1.i.c(9, str);
        c.a.n0.a.x.g.f.Q3(q0.n());
        g.b k = gVar.i("showModalPage").k("normal", bVar2);
        if ((gVar.m() instanceof c.a.n0.a.x.g.f) && (fVar = (c.a.n0.a.x.g.f) gVar.m()) != null) {
            fVar.D0 = true;
            k.b();
            if (gVar.k() > 1) {
                fVar.v3().setBackgroundColor(0);
            } else {
                fVar.D0 = false;
            }
            fVar.x2(false);
            c.a.n0.a.x.g.m.a aVar = this.f5137f;
            if (aVar != null) {
                fVar.P2(aVar);
            }
            e eVar = new e(this, fVar);
            this.f5137f = eVar;
            fVar.l2(eVar);
            View c2 = c.a.n0.a.s1.b.a.c(fVar);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            c.a.n0.a.s1.b.a.h(fVar);
            PullToRefreshBaseWebView k0 = bVar.k0();
            if (k0 != null) {
                k0.setIsPreventPullToRefresh(true);
            }
            h.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.n0.a.k1.i.a(str, bVar2);
        }
    }

    public final void G(c.a.n0.a.f.e.b bVar, c.a.n0.a.c1.b bVar2, c.a.n0.a.x.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, bVar, bVar2, gVar, str) == null) || (activity = c.a.n0.a.w0.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        c.a.n0.a.v1.f.o0.a.e(bVar, bVar2, str);
        c.a.n0.a.k1.i.c(0, str);
        if (gVar.k() < f5136g) {
            c.a.n0.a.x.g.f.Q3(q0.n());
            g.b i = gVar.i("navigateTo");
            i.n(c.a.n0.a.x.g.g.f7048g, c.a.n0.a.x.g.g.i);
            i.k("normal", bVar2).b();
            c.a.n0.a.p2.g.c(gVar, getContext());
            h.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            c.a.n0.a.k1.i.a(str, bVar2);
            return;
        }
        c.a.n0.a.k.e.j.d.A(gVar, bVar2, str, true);
    }

    public c.a.n0.a.k.h.b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public final c.a.n0.a.k.h.b I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                return new c.a.n0.a.k.h.b(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            c.a.n0.a.k1.i.b(uuid);
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = c.a.n0.a.v1.f.o0.a.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    c.a.n0.a.u.d.c("NavigateToApi", "url is null");
                    return new c.a.n0.a.k.h.b(202, "url is null");
                }
                c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
                c.a.n0.a.x.g.g V = U.V();
                if (V == null) {
                    c.a.n0.a.u.d.c("NavigateToApi", "manager is null");
                    return new c.a.n0.a.k.h.b(1001, "manager is null");
                }
                c.a.n0.a.c1.b d2 = c.a.n0.a.c1.b.d(p, U.z());
                d2.f3950e = str2;
                d2.f3951f = uuid;
                c.a.n0.a.d2.i.g(d2);
                if (!q0.b(U.s(), d2, false)) {
                    String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.f3949d;
                    c.a.n0.a.u.d.c("NavigateToApi", str4);
                    c.a.n0.a.d2.i.i(d2);
                    return new c.a.n0.a.k.h.b(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.f3949d) && c.a.n0.a.t1.e.L() != null) {
                    c.a.n0.a.t1.e.L().K0(optString, d2.f3949d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = h.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    c.a.n0.a.u.d.c("NavigateToApi", "cb is empty");
                    c.a.n0.a.d2.i.i(d2);
                    return new c.a.n0.a.k.h.b(202, "cb is empty");
                } else if (c.a.n0.a.v1.f.f0.d.b().a(d2)) {
                    c.a.n0.a.v1.f.f0.d.b().i(str3, d2);
                    c.a.n0.a.u.d.c("NavigateToApi", "access to this page is prohibited");
                    return new c.a.n0.a.k.h.b(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        a0.d0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                    } else {
                        C(U, V, d2, uuid, str2, optString3);
                    }
                    return c.a.n0.a.k.h.b.f();
                }
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeLLL.objValue;
    }

    public c.a.n0.a.k.h.b J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public final void K(a.e eVar, c.a.n0.a.c1.b bVar, c.a.n0.a.x.g.g gVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, bVar, gVar, str, str2) == null) {
            boolean z = eVar != null && eVar.f7448b;
            HybridUbcFlow q = h.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            c.a.n0.a.x.t.a.q(eVar, new C0345c(this, eVar, str, bVar, gVar, str2));
        }
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
