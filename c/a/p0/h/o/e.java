package c.a.p0.h.o;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.l0.f;
import c.a.p0.a.l0.g;
import c.a.p0.a.r1.h;
import c.a.p0.h.r.a;
import c.a.p0.h.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11393h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.a.l0.a f11394a;

    /* renamed from: b  reason: collision with root package name */
    public DuMixGameSurfaceView f11395b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.y.a f11396c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0583e f11397d;

    /* renamed from: e  reason: collision with root package name */
    public String f11398e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11399f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11400g;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f11401e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11401e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11401e.r();
                this.f11401e.s();
                this.f11401e.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f11402e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f11403f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f11404g;

        public b(e eVar, a.c cVar, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, cVar, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11404g = eVar;
            this.f11402e = cVar;
            this.f11403f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = e.f11393h;
                c.a.p0.h.c0.a.a aVar = this.f11402e.f11542c;
                c.a.p0.h.r.a aVar2 = aVar == null ? null : aVar.f11122f;
                a.C0594a f2 = c.a.p0.h.r.a.f(aVar2);
                if (f2.b()) {
                    SwanInspectorEndpoint.v().r(aVar2, this.f11404g.f11394a, f2, this.f11403f);
                    return;
                }
                SwanInspectorEndpoint.v().w(f2);
                this.f11403f.run();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements V8ThreadDelegatePolicy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public DuMixGameSurfaceView f11405b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ V8Engine f11406e;

            public a(c cVar, V8Engine v8Engine) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, v8Engine};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11406e = v8Engine;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean unused = e.f11393h;
                    this.f11406e.startEngineInternal();
                }
            }
        }

        public c(e eVar, DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11405b = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.f11405b.queueEvent(runnable);
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                this.f11405b.runOnGLThread(runnable);
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11405b.getThread() : (Thread) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f11405b.clearOldEvents();
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(V8Engine v8Engine) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, v8Engine) == null) {
                boolean unused = e.f11393h;
                this.f11405b.runOnGLThread(new a(this, v8Engine));
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, j2) == null) {
                this.f11405b.queueEvent(runnable, j2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends c.a.p0.a.l0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f11407a;

        /* renamed from: b  reason: collision with root package name */
        public String f11408b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f11409c;

        /* loaded from: classes3.dex */
        public class a implements V8EngineConfiguration.JSCacheCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f11410a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11410a = dVar;
            }

            @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
            public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cacheInfo) == null) {
                    this.f11410a.f(cacheInfo);
                }
            }
        }

        public d(@NonNull e eVar, @NonNull String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11409c = eVar;
            this.f11407a = str;
            this.f11408b = str2;
        }

        @Override // c.a.p0.a.l0.n.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11408b : (String) invokeV.objValue;
        }

        @Override // c.a.p0.a.l0.n.a, c.a.p0.a.l0.n.b
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.p0.h.e.c.a("gameframe", getInitBasePath()) : (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // c.a.p0.a.l0.n.a, c.a.p0.a.l0.n.b
        public void c(c.a.p0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                h.p("preload").C(new UbcFlowEvent("na_load_swan_game_js_end"));
                if (this.f11409c.f11397d != null) {
                    this.f11409c.f11397d.a(aVar);
                }
            }
        }

        @Override // c.a.p0.a.l0.n.a, c.a.p0.a.l0.n.b
        public void d(c.a.p0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                this.f11409c.f11396c.b(aVar, c.a.p0.a.c1.a.b());
                new c.a.p0.h.d.a().a(aVar, c.a.p0.a.c1.a.b());
                aVar.B0(new a(this));
                h.p("preload").C(new UbcFlowEvent("na_load_swan_game_js_start"));
            }
        }

        public final void f(V8EngineConfiguration.CacheInfo cacheInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, cacheInfo) == null) || cacheInfo == null) {
                return;
            }
            if (e.f11393h) {
                String str = "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath;
            }
            if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                return;
            }
            File file = new File(cacheInfo.jsPath);
            try {
                if (TextUtils.isEmpty(getInitBasePath()) || !file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                    if (!TextUtils.isEmpty(this.f11409c.f11398e) && file.getCanonicalPath().startsWith(new File(this.f11409c.f11398e).getCanonicalPath())) {
                        this.f11409c.f11400g = true;
                    }
                } else {
                    this.f11409c.f11399f = true;
                }
            } catch (IOException e2) {
                if (e.f11393h) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // c.a.p0.a.l0.n.b
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f11407a : (String) invokeV.objValue;
        }
    }

    /* renamed from: c.a.p0.h.o.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0583e {
        void a(c.a.p0.a.l0.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1158440474, "Lc/a/p0/h/o/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1158440474, "Lc/a/p0/h/o/e;");
                return;
            }
        }
        f11393h = k.f7077a;
    }

    public e(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11396c = new c.a.p0.a.y.a();
        q(str, str2);
    }

    public void k(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.f11396c.a(activity);
        }
    }

    public final g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g.b bVar = new g.b();
            bVar.c(2);
            bVar.b("master");
            return bVar.a();
        }
        return (g) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean z = f11393h;
            this.f11394a.k0();
            if (this.f11395b.isAttachedToWindow()) {
                return;
            }
            boolean z2 = f11393h;
            this.f11395b.onDestroy();
        }
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.p0.h.e.c.b(this.f11399f, this.f11400g) : invokeV.intValue;
    }

    public c.a.p0.a.l0.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11394a : (c.a.p0.a.l0.a) invokeV.objValue;
    }

    public DuMixGameSurfaceView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f11395b : (DuMixGameSurfaceView) invokeV.objValue;
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            DuMixGameSurfaceView a2 = c.a.p0.h.q.b.b().a(AppRuntime.getAppContext());
            this.f11395b = a2;
            a2.setRenderMode(1);
            c.a.p0.a.l0.a c2 = f.c(l(), new d(this, str, str2), new c(this, this.f11395b));
            this.f11394a = c2;
            c2.D0(c.a.p0.a.c1.a.b());
            this.f11395b.setV8Engine(this.f11394a);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f11395b.updateGameCanvasSize();
            this.f11394a.F0(new c.a.p0.a.l0.m.d());
            this.f11394a.H0();
            this.f11394a.E0();
            this.f11394a.C0(c.a.p0.h.e.c.a("gamejs", this.f11398e));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && f11393h && c.a.p0.a.u1.a.a.f() && new File(c.a.p0.h.h.b.b(), c.a.p0.h.h.b.d()).exists()) {
            this.f11394a.a0(c.a.p0.h.h.b.b().getAbsolutePath(), c.a.p0.h.h.b.d());
        }
    }

    public void t(a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.f11540a)) {
            return;
        }
        this.f11398e = cVar.f11540a;
        a aVar = new a(this);
        boolean z = f11393h;
        this.f11394a.runOnJSThread(new b(this, cVar, aVar));
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean z = f11393h;
            HybridUbcFlow p = h.p("startup");
            p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
            p.C(new UbcFlowEvent("na_load_index_js_start"));
            this.f11394a.S(new c.a.p0.h.w.c());
            this.f11394a.a0(this.f11398e, "index.js");
            this.f11394a.S(new c.a.p0.h.w.d());
            h.p("startup").C(new UbcFlowEvent("na_load_index_js_end"));
            boolean z2 = f11393h;
            this.f11394a.y0();
            this.f11395b.notifySurfaceChanged();
        }
    }

    public void v(InterfaceC0583e interfaceC0583e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, interfaceC0583e) == null) {
            this.f11397d = interfaceC0583e;
        }
    }
}
