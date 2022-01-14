package c.a.r0.j.o;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.a.l0.g;
import c.a.r0.a.l0.h;
import c.a.r0.a.u1.h;
import c.a.r0.j.s.a;
import c.a.r0.j.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsCodeCacheCallback;
import com.baidu.searchbox.v8engine.JsCodeCacheResult;
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
import com.kwad.v8.NodeJS;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11127h;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.a.l0.a a;

    /* renamed from: b  reason: collision with root package name */
    public DuMixGameSurfaceView f11128b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.a.y.a f11129c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0760e f11130d;

    /* renamed from: e  reason: collision with root package name */
    public String f11131e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11132f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11133g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f11134e;

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
            this.f11134e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11134e.r();
                this.f11134e.s();
                this.f11134e.u();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f11135e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f11136f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f11137g;

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
            this.f11137g = eVar;
            this.f11135e = cVar;
            this.f11136f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = e.f11127h;
                c.a.r0.j.d0.a.a aVar = this.f11135e.f11255c;
                c.a.r0.j.s.a aVar2 = aVar == null ? null : aVar.f10941f;
                a.C0772a f2 = c.a.r0.j.s.a.f(aVar2);
                if (f2.b()) {
                    SwanInspectorEndpoint.v().r(aVar2, this.f11137g.a, f2, this.f11136f);
                    return;
                }
                SwanInspectorEndpoint.v().w(f2);
                this.f11136f.run();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements V8ThreadDelegatePolicy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public DuMixGameSurfaceView f11138c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ V8Engine f11139e;

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
                this.f11139e = v8Engine;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean unused = e.f11127h;
                    this.f11139e.startEngineInternal();
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
            this.f11138c = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.f11138c.queueEvent(runnable);
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                this.f11138c.runOnGLThread(runnable);
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11138c.getThread() : (Thread) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f11138c.clearOldEvents();
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(V8Engine v8Engine) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, v8Engine) == null) {
                boolean unused = e.f11127h;
                this.f11138c.runOnGLThread(new a(this, v8Engine));
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, j2) == null) {
                this.f11138c.queueEvent(runnable, j2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends c.a.r0.a.l0.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f11140b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f11141c;

        /* loaded from: classes6.dex */
        public class a implements JsCodeCacheCallback {
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.searchbox.v8engine.JsCodeCacheCallback
            public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jsCodeCacheResult) == null) {
                    this.a.f(jsCodeCacheResult);
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
            this.f11141c = eVar;
            this.a = str;
            this.f11140b = str2;
        }

        @Override // c.a.r0.a.l0.p.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11140b : (String) invokeV.objValue;
        }

        @Override // c.a.r0.a.l0.p.a, c.a.r0.a.l0.p.b
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.r0.j.e.c.a("gameframe", getInitBasePath()) : (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // c.a.r0.a.l0.p.a, c.a.r0.a.l0.p.b
        public void c(c.a.r0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                h.p("preload").F(new UbcFlowEvent("na_load_swan_game_js_end"));
                if (this.f11141c.f11130d != null) {
                    this.f11141c.f11130d.a(aVar);
                }
            }
        }

        @Override // c.a.r0.a.l0.p.a, c.a.r0.a.l0.p.b
        public void d(c.a.r0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                this.f11141c.f11129c.b(aVar, c.a.r0.a.c1.a.c());
                new c.a.r0.j.d.a().a(aVar, c.a.r0.a.c1.a.c());
                aVar.H0(new a(this));
                h.p("preload").F(new UbcFlowEvent("na_load_swan_game_js_start"));
            }
        }

        public final void f(JsCodeCacheResult jsCodeCacheResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, jsCodeCacheResult) == null) || jsCodeCacheResult == null) {
                return;
            }
            if (e.f11127h) {
                String str = "jsCodeCacheResult isCacheUsed:" + jsCodeCacheResult.isCacheUsed + " ,jsPath: " + jsCodeCacheResult.jsPath;
            }
            if (!jsCodeCacheResult.isCacheUsed || TextUtils.isEmpty(jsCodeCacheResult.jsPath)) {
                return;
            }
            File file = new File(jsCodeCacheResult.jsPath);
            try {
                if (TextUtils.isEmpty(getInitBasePath()) || !file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                    if (!TextUtils.isEmpty(this.f11141c.f11131e) && file.getCanonicalPath().startsWith(new File(this.f11141c.f11131e).getCanonicalPath())) {
                        this.f11141c.f11133g = true;
                    }
                } else {
                    this.f11141c.f11132f = true;
                }
            } catch (IOException e2) {
                if (e.f11127h) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // c.a.r0.a.l0.p.b
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (String) invokeV.objValue;
        }
    }

    /* renamed from: c.a.r0.j.o.e$e  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0760e {
        void a(c.a.r0.a.l0.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-421123802, "Lc/a/r0/j/o/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-421123802, "Lc/a/r0/j/o/e;");
                return;
            }
        }
        f11127h = k.a;
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
        this.f11129c = new c.a.r0.a.y.a();
        q(str, str2);
    }

    public void k(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.f11129c.a(activity);
        }
    }

    public final c.a.r0.a.l0.h l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h.b bVar = new h.b();
            bVar.c(2);
            bVar.b("master");
            return bVar.a();
        }
        return (c.a.r0.a.l0.h) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean z = f11127h;
            this.a.m0();
            if (this.f11128b.isAttachedToWindow()) {
                return;
            }
            boolean z2 = f11127h;
            this.f11128b.onDestroy();
        }
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.r0.j.e.c.b(this.f11132f, this.f11133g) : invokeV.intValue;
    }

    public c.a.r0.a.l0.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (c.a.r0.a.l0.a) invokeV.objValue;
    }

    public DuMixGameSurfaceView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f11128b : (DuMixGameSurfaceView) invokeV.objValue;
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            DuMixGameSurfaceView a2 = c.a.r0.j.q.b.b().a(AppRuntime.getAppContext());
            this.f11128b = a2;
            a2.setRenderMode(1);
            c.a.r0.a.l0.a b2 = g.b(l(), new d(this, str, str2), new c(this, this.f11128b));
            this.a = b2;
            b2.E0(c.a.r0.a.c1.a.c());
            this.f11128b.setV8Engine(this.a);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f11128b.updateGameCanvasSize();
            this.a.G0(new c.a.r0.a.l0.n.d());
            this.a.J0();
            this.a.F0();
            this.a.D0(c.a.r0.j.e.c.a("gamejs", this.f11131e));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && f11127h && c.a.r0.a.x1.a.a.f() && new File(c.a.r0.j.h.b.b(), c.a.r0.j.h.b.d()).exists()) {
            this.a.c0(c.a.r0.j.h.b.b().getAbsolutePath(), c.a.r0.j.h.b.d());
        }
    }

    public void t(a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.a)) {
            return;
        }
        this.f11131e = cVar.a;
        a aVar = new a(this);
        boolean z = f11127h;
        this.a.runOnJSThread(new b(this, cVar, aVar));
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean z = f11127h;
            HybridUbcFlow p = c.a.r0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
            p.F(new UbcFlowEvent("na_load_index_js_start"));
            this.a.dispatchEvent(new c.a.r0.j.x.c());
            this.a.c0(this.f11131e, "index.js");
            this.a.dispatchEvent(new c.a.r0.j.x.d());
            c.a.r0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("na_load_index_js_end"));
            boolean z2 = f11127h;
            this.a.A0();
            this.f11128b.notifySurfaceChanged();
        }
    }

    public void v(InterfaceC0760e interfaceC0760e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, interfaceC0760e) == null) {
            this.f11130d = interfaceC0760e;
        }
    }
}
