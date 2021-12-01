package c.a.p0.j.o;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.l0.g;
import c.a.p0.a.l0.h;
import c.a.p0.a.u1.h;
import c.a.p0.j.s.a;
import c.a.p0.j.t.a;
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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f10338h;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a.l0.a a;

    /* renamed from: b  reason: collision with root package name */
    public DuMixGameSurfaceView f10339b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.y.a f10340c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0667e f10341d;

    /* renamed from: e  reason: collision with root package name */
    public String f10342e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10343f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10344g;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f10345e;

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
            this.f10345e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10345e.r();
                this.f10345e.s();
                this.f10345e.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f10346e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f10347f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f10348g;

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
            this.f10348g = eVar;
            this.f10346e = cVar;
            this.f10347f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = e.f10338h;
                c.a.p0.j.d0.a.a aVar = this.f10346e.f10468c;
                c.a.p0.j.s.a aVar2 = aVar == null ? null : aVar.f10145f;
                a.C0679a f2 = c.a.p0.j.s.a.f(aVar2);
                if (f2.b()) {
                    SwanInspectorEndpoint.v().r(aVar2, this.f10348g.a, f2, this.f10347f);
                    return;
                }
                SwanInspectorEndpoint.v().w(f2);
                this.f10347f.run();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements V8ThreadDelegatePolicy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public DuMixGameSurfaceView f10349c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ V8Engine f10350e;

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
                this.f10350e = v8Engine;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean unused = e.f10338h;
                    this.f10350e.startEngineInternal();
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
            this.f10349c = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.f10349c.queueEvent(runnable);
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                this.f10349c.runOnGLThread(runnable);
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f10349c.getThread() : (Thread) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f10349c.clearOldEvents();
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(V8Engine v8Engine) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, v8Engine) == null) {
                boolean unused = e.f10338h;
                this.f10349c.runOnGLThread(new a(this, v8Engine));
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, j2) == null) {
                this.f10349c.queueEvent(runnable, j2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends c.a.p0.a.l0.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f10351b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f10352c;

        /* loaded from: classes5.dex */
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
            this.f10352c = eVar;
            this.a = str;
            this.f10351b = str2;
        }

        @Override // c.a.p0.a.l0.p.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10351b : (String) invokeV.objValue;
        }

        @Override // c.a.p0.a.l0.p.a, c.a.p0.a.l0.p.b
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.p0.j.e.c.a("gameframe", getInitBasePath()) : (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // c.a.p0.a.l0.p.a, c.a.p0.a.l0.p.b
        public void c(c.a.p0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                h.p("preload").F(new UbcFlowEvent("na_load_swan_game_js_end"));
                if (this.f10352c.f10341d != null) {
                    this.f10352c.f10341d.a(aVar);
                }
            }
        }

        @Override // c.a.p0.a.l0.p.a, c.a.p0.a.l0.p.b
        public void d(c.a.p0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                this.f10352c.f10340c.b(aVar, c.a.p0.a.c1.a.c());
                new c.a.p0.j.d.a().a(aVar, c.a.p0.a.c1.a.c());
                aVar.H0(new a(this));
                h.p("preload").F(new UbcFlowEvent("na_load_swan_game_js_start"));
            }
        }

        public final void f(JsCodeCacheResult jsCodeCacheResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, jsCodeCacheResult) == null) || jsCodeCacheResult == null) {
                return;
            }
            if (e.f10338h) {
                String str = "jsCodeCacheResult isCacheUsed:" + jsCodeCacheResult.isCacheUsed + " ,jsPath: " + jsCodeCacheResult.jsPath;
            }
            if (!jsCodeCacheResult.isCacheUsed || TextUtils.isEmpty(jsCodeCacheResult.jsPath)) {
                return;
            }
            File file = new File(jsCodeCacheResult.jsPath);
            try {
                if (TextUtils.isEmpty(getInitBasePath()) || !file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                    if (!TextUtils.isEmpty(this.f10352c.f10342e) && file.getCanonicalPath().startsWith(new File(this.f10352c.f10342e).getCanonicalPath())) {
                        this.f10352c.f10344g = true;
                    }
                } else {
                    this.f10352c.f10343f = true;
                }
            } catch (IOException e2) {
                if (e.f10338h) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // c.a.p0.a.l0.p.b
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (String) invokeV.objValue;
        }
    }

    /* renamed from: c.a.p0.j.o.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0667e {
        void a(c.a.p0.a.l0.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1101182172, "Lc/a/p0/j/o/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1101182172, "Lc/a/p0/j/o/e;");
                return;
            }
        }
        f10338h = k.a;
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
        this.f10340c = new c.a.p0.a.y.a();
        q(str, str2);
    }

    public void k(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.f10340c.a(activity);
        }
    }

    public final c.a.p0.a.l0.h l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h.b bVar = new h.b();
            bVar.c(2);
            bVar.b("master");
            return bVar.a();
        }
        return (c.a.p0.a.l0.h) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean z = f10338h;
            this.a.m0();
            if (this.f10339b.isAttachedToWindow()) {
                return;
            }
            boolean z2 = f10338h;
            this.f10339b.onDestroy();
        }
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.p0.j.e.c.b(this.f10343f, this.f10344g) : invokeV.intValue;
    }

    public c.a.p0.a.l0.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (c.a.p0.a.l0.a) invokeV.objValue;
    }

    public DuMixGameSurfaceView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f10339b : (DuMixGameSurfaceView) invokeV.objValue;
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            DuMixGameSurfaceView a2 = c.a.p0.j.q.b.b().a(AppRuntime.getAppContext());
            this.f10339b = a2;
            a2.setRenderMode(1);
            c.a.p0.a.l0.a b2 = g.b(l(), new d(this, str, str2), new c(this, this.f10339b));
            this.a = b2;
            b2.E0(c.a.p0.a.c1.a.c());
            this.f10339b.setV8Engine(this.a);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f10339b.updateGameCanvasSize();
            this.a.G0(new c.a.p0.a.l0.n.d());
            this.a.J0();
            this.a.F0();
            this.a.D0(c.a.p0.j.e.c.a("gamejs", this.f10342e));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && f10338h && c.a.p0.a.x1.a.a.f() && new File(c.a.p0.j.h.b.b(), c.a.p0.j.h.b.d()).exists()) {
            this.a.c0(c.a.p0.j.h.b.b().getAbsolutePath(), c.a.p0.j.h.b.d());
        }
    }

    public void t(a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.a)) {
            return;
        }
        this.f10342e = cVar.a;
        a aVar = new a(this);
        boolean z = f10338h;
        this.a.runOnJSThread(new b(this, cVar, aVar));
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean z = f10338h;
            HybridUbcFlow p = c.a.p0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
            p.F(new UbcFlowEvent("na_load_index_js_start"));
            this.a.dispatchEvent(new c.a.p0.j.x.c());
            this.a.c0(this.f10342e, "index.js");
            this.a.dispatchEvent(new c.a.p0.j.x.d());
            c.a.p0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("na_load_index_js_end"));
            boolean z2 = f10338h;
            this.a.A0();
            this.f10339b.notifySurfaceChanged();
        }
    }

    public void v(InterfaceC0667e interfaceC0667e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, interfaceC0667e) == null) {
            this.f10341d = interfaceC0667e;
        }
    }
}
