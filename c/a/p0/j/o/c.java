package c.a.p0.j.o;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.n;
import c.a.p0.a.k1.h;
import c.a.p0.a.p2.q0;
import c.a.p0.a.x.g.g;
import c.a.p0.j.o.e;
import c.a.p0.j.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f10581j;
    public static volatile c k;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f10582b;

    /* renamed from: c  reason: collision with root package name */
    public SwanCoreVersion f10583c;

    /* renamed from: d  reason: collision with root package name */
    public ExtensionCore f10584d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.j.o.e f10585e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f10586f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10587g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10588h;

    /* renamed from: i  reason: collision with root package name */
    public String f10589i;

    /* loaded from: classes2.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.j.o.c.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.f10581j) {
                c.a.p0.a.s1.b.f.e f2 = c.a.p0.a.s1.b.f.e.f(AppRuntime.getAppContext(), R.string.aiapps_game_preload_core_runtime_end);
                f2.l(1);
                f2.G();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Intent addFlags = new Intent().putExtra(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, SwanAppErrorActivity.TYPE_LOAD_V8_FAILED).setComponent(new ComponentName(AppRuntime.getAppContext(), SwanAppErrorActivity.class)).addFlags(268435456);
                if (c.a.p0.a.t1.e.L() != null) {
                    c.a.p0.a.p2.f.j(c.a.p0.a.t1.e.L().x());
                }
                AppRuntime.getAppContext().startActivity(addFlags);
            }
        }
    }

    /* renamed from: c.a.p0.j.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0723c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f10590b;

        /* renamed from: c.a.p0.j.o.c$c$a */
        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0723c f10591e;

            public a(C0723c c0723c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0723c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10591e = c0723c;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10591e.f10590b.f10588h || this.f10591e.f10590b.f10585e == null || (activity = c.a.p0.a.w0.f.U().getActivity()) == null || activity.isFinishing() || activity.getSwanAppFragmentManager() == null) {
                    return;
                }
                if (c.f10581j) {
                    String str = "loadAppJs start: " + this.f10591e.f10590b.f10589i;
                }
                this.f10591e.f10590b.f10585e.k(activity);
                this.f10591e.f10590b.f10585e.t(this.f10591e.a);
                if (this.f10591e.f10590b.v()) {
                    this.f10591e.f10590b.F(activity);
                }
            }
        }

        public C0723c(c cVar, a.c cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10590b = cVar;
            this.a = cVar2;
        }

        @Override // c.a.p0.j.o.c.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("na_prepare_runtime_end"));
                q0.e0(new a(this));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements e.InterfaceC0725e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.p0.j.o.e.InterfaceC0725e
        public void a(c.a.p0.a.b0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                boolean unused = c.f10581j;
                synchronized (this.a.f10582b) {
                    this.a.f10587g = true;
                    this.a.w();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast.makeText(AppRuntime.getAppContext(), (int) R.string.aiapps_debug_game_core_package_error, 1).show();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void onReady();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1101182234, "Lc/a/p0/j/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1101182234, "Lc/a/p0/j/o/c;");
                return;
            }
        }
        f10581j = c.a.p0.a.a.a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.f10582b = new Object();
        this.f10586f = new CopyOnWriteArrayList();
    }

    public static synchronized void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (c.class) {
                boolean z = f10581j;
                if (k == null) {
                    return;
                }
                k.f10588h = true;
                if (k.f10585e != null) {
                    k.f10585e.m();
                }
                k = null;
                m().y();
            }
        }
    }

    public static c m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (k == null) {
                synchronized (c.class) {
                    if (k == null) {
                        k = new c();
                    }
                }
            }
            return k;
        }
        return (c) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.f10582b) {
                if (!this.f10587g && this.f10585e == null) {
                    K();
                    J();
                    String l = l();
                    if (TextUtils.isEmpty(l) || this.f10588h) {
                        return;
                    }
                    if (f10581j) {
                        String str = "prepareMaster start: " + l;
                    }
                    c.a.p0.j.o.e eVar = new c.a.p0.j.o.e(l, "swan-game.js");
                    this.f10585e = eVar;
                    eVar.v(new d(this));
                }
            }
        }
    }

    public void B(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            boolean z = f10581j;
            if (fVar != null && !this.f10586f.contains(fVar)) {
                this.f10586f.add(fVar);
            }
            if (u()) {
                w();
            } else {
                A();
            }
        }
    }

    public void D(ExtensionCore extensionCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, extensionCore) == null) {
            if (extensionCore != null && extensionCore.isAvailable()) {
                if (f10581j) {
                    String str = "setExtensionCore: " + this.f10584d;
                }
                this.f10584d = extensionCore;
            } else if (f10581j) {
                StringBuilder sb = new StringBuilder();
                sb.append("setExtensionCore invalid: ");
                Object obj = extensionCore;
                if (extensionCore == null) {
                    obj = " null";
                }
                sb.append(obj);
                sb.toString();
            }
        }
    }

    public final void E(SwanCoreVersion swanCoreVersion) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, swanCoreVersion) == null) && swanCoreVersion != null && swanCoreVersion.isAvailable()) {
            this.f10583c = swanCoreVersion;
            if (f10581j) {
                String str = "setSwanCoreVersion: " + this.f10583c;
            }
        }
    }

    public void F(SwanAppActivity swanAppActivity) {
        g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, swanAppActivity) == null) || swanAppActivity == null || swanAppActivity.isFinishing() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null) {
            return;
        }
        g.b h2 = swanAppFragmentManager.h();
        h2.n(0, 0);
        h2.f();
        h2.j(c.a.p0.j.n.a.A3());
        h2.b();
    }

    public void G(c.a.p0.a.v0.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            ExtensionCore extensionCore = this.f10584d;
            if (extensionCore != null) {
                bVar.C0(extensionCore);
            } else {
                this.f10584d = bVar.O();
            }
        }
    }

    public void H() {
        c.a.p0.j.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eVar = this.f10585e) == null) {
            return;
        }
        eVar.o().F0();
    }

    public void I(c.a.p0.a.v0.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            K();
            SwanCoreVersion swanCoreVersion = this.f10583c;
            if (swanCoreVersion != null) {
                bVar.Z0(swanCoreVersion);
            }
            if (f10581j) {
                String str = "syncSwanCore mSwanCoreVersion: " + this.f10583c;
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ExtensionCore extensionCore = this.f10584d;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                boolean z = f10581j;
                D(c.a.p0.a.f0.b.c(1));
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanCoreVersion swanCoreVersion = this.f10583c;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                E(o());
            }
        }
    }

    public void h(Activity activity) {
        c.a.p0.j.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, activity) == null) || (eVar = this.f10585e) == null) {
            return;
        }
        eVar.k(activity);
    }

    public void i(JSEvent jSEvent) {
        c.a.p0.j.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jSEvent) == null) || (eVar = this.f10585e) == null) {
            return;
        }
        eVar.o().dispatchEvent(jSEvent);
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.p0.j.o.e eVar = this.f10585e;
            if (eVar != null) {
                return eVar.n();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public ExtensionCore k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f10584d : (ExtensionCore) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SwanCoreVersion swanCoreVersion = this.f10583c;
            return (swanCoreVersion == null || !swanCoreVersion.isAvailable()) ? "" : this.f10583c.swanCorePath;
        }
        return (String) invokeV.objValue;
    }

    public c.a.p0.a.b0.a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            c.a.p0.j.o.e eVar = this.f10585e;
            if (eVar != null) {
                return eVar.o();
            }
            return null;
        }
        return (c.a.p0.a.b0.a) invokeV.objValue;
    }

    public final SwanCoreVersion o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (c.a.p0.j.p.a.c.a("package")) {
                if (TextUtils.isEmpty(this.f10589i)) {
                    return null;
                }
                if (!new File(this.f10589i, "swan-game.js").exists()) {
                    q0.e0(new e(this));
                    return c.a.p0.a.g2.b.g(1);
                }
                SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
                swanCoreVersion.swanCorePath = this.f10589i;
                swanCoreVersion.swanCoreType = 2;
                return swanCoreVersion;
            } else if (!c.a.p0.j.p.a.c.a("normal") && !c.a.p0.a.n1.a.a.h()) {
                return c.a.p0.a.g2.b.g(1);
            } else {
                SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
                swanCoreVersion2.swanCorePath = c.a.p0.j.p.a.b.b().getAbsolutePath();
                swanCoreVersion2.swanCoreType = 2;
                boolean z = f10581j;
                return swanCoreVersion2;
            }
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.a < 0) {
                c.a.p0.a.s0.a.g0().getSwitch("swan_game_preload", 0);
                this.a = 0;
            }
            if (f10581j) {
                String str = "getPreLoadABSwitch:" + this.a;
            }
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.p0.a.s0.a.g0().getSwitch("swan_game_startup_improvement", false);
            if (f10581j) {
                String str = "getPushFragmentABSwitch:false";
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public DuMixGameSurfaceView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            c.a.p0.j.o.e eVar = this.f10585e;
            if (eVar != null) {
                return eVar.p();
            }
            return null;
        }
        return (DuMixGameSurfaceView) invokeV.objValue;
    }

    public SwanCoreVersion s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f10583c : (SwanCoreVersion) invokeV.objValue;
    }

    public final boolean t(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, intent)) == null) {
            int p = p();
            if (p != 1) {
                return p == 2 && intent == null;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this.f10582b) {
                z = this.f10587g && this.f10585e != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        DuMixGameSurfaceView r;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.f10588h || (r = r()) == null || r.getParent() != null) ? false : true : invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f10588h || this.f10586f.isEmpty() || !u()) {
            return;
        }
        for (f fVar : this.f10586f) {
            if (fVar != null) {
                fVar.onReady();
            }
        }
        this.f10586f.clear();
    }

    public void x(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            boolean z = f10581j;
            if (cVar == null || TextUtils.isEmpty(cVar.a)) {
                return;
            }
            this.f10589i = cVar.a;
            h.p(NodeJS.STARTUP_SCRIPT_NAME).D("preload", u() ? "1" : "0");
            h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("na_prepare_runtime_start"));
            boolean b2 = c.a.p0.a.a2.d.c().b();
            boolean b3 = c.a.p0.a.a2.d.b();
            if (b2 && b3) {
                B(new C0723c(this, cVar));
                if (this.f10585e != null) {
                    c.a.p0.j.z.e.b.b().f(this.f10585e.o(), cVar);
                    return;
                }
                return;
            }
            if (c.a.p0.a.t1.e.L() != null) {
                c.a.p0.a.d2.s.d dVar = new c.a.p0.a.d2.s.d();
                dVar.q(n.n(1));
                dVar.r(c.a.p0.a.t1.e.L().X());
                dVar.l("gameCoreRuntime", "loadv8Failed");
                n.R(dVar);
            }
            q0.e0(new b(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            boolean z = f10581j;
            z(null);
        }
    }

    public void z(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, intent) == null) {
            if (f10581j) {
                String str = "preloadCoreRuntime preloadScene:" + (intent != null ? intent.getStringExtra("bundle_key_preload_preload_scene") : null);
            }
            if (!u() && t(intent)) {
                boolean b2 = c.a.p0.a.a2.d.c().b();
                boolean b3 = c.a.p0.a.a2.d.b();
                if (b2 && b3) {
                    B(new a(this));
                }
            }
        }
    }
}
