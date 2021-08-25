package c.a.o0.h.o;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.h0.g.g;
import c.a.o0.a.k;
import c.a.o0.a.r1.h;
import c.a.o0.a.v2.q0;
import c.a.o0.f.g;
import c.a.o0.h.o.e;
import c.a.o0.h.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f11348j;
    public static volatile c k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11349a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f11350b;

    /* renamed from: c  reason: collision with root package name */
    public SwanCoreVersion f11351c;

    /* renamed from: d  reason: collision with root package name */
    public ExtensionCore f11352d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.h.o.e f11353e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f11354f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11355g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11356h;

    /* renamed from: i  reason: collision with root package name */
    public String f11357i;

    /* loaded from: classes3.dex */
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

        @Override // c.a.o0.h.o.c.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.f11348j) {
                c.a.o0.a.z1.b.f.e f2 = c.a.o0.a.z1.b.f.e.f(AppRuntime.getAppContext(), g.aiapps_game_preload_core_runtime_end);
                f2.l(1);
                f2.F();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (c.a.o0.a.a2.e.i() != null) {
                    c.a.o0.a.v2.f.j(c.a.o0.a.a2.e.i().x());
                }
                AppRuntime.getAppContext().startActivity(addFlags);
            }
        }
    }

    /* renamed from: c.a.o0.h.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0580c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f11358a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f11359b;

        /* renamed from: c.a.o0.h.o.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0580c f11360e;

            public a(C0580c c0580c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0580c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11360e = c0580c;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11360e.f11359b.f11356h || this.f11360e.f11359b.f11353e == null || (activity = c.a.o0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.getSwanAppFragmentManager() == null) {
                    return;
                }
                if (c.f11348j) {
                    String str = "loadAppJs start: " + this.f11360e.f11359b.f11357i;
                }
                this.f11360e.f11359b.f11353e.k(activity);
                this.f11360e.f11359b.f11353e.t(this.f11360e.f11358a);
                if (this.f11360e.f11359b.v()) {
                    this.f11360e.f11359b.F(activity);
                }
            }
        }

        public C0580c(c cVar, a.c cVar2) {
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
            this.f11359b = cVar;
            this.f11358a = cVar2;
        }

        @Override // c.a.o0.h.o.c.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.p("startup").C(new UbcFlowEvent("na_prepare_runtime_end"));
                q0.b0(new a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements e.InterfaceC0581e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f11361a;

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
            this.f11361a = cVar;
        }

        @Override // c.a.o0.h.o.e.InterfaceC0581e
        public void a(c.a.o0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                boolean unused = c.f11348j;
                synchronized (this.f11361a.f11350b) {
                    this.f11361a.f11355g = true;
                    this.f11361a.w();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                Toast.makeText(AppRuntime.getAppContext(), g.aiapps_debug_game_core_package_error, 1).show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void onReady();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(649013927, "Lc/a/o0/h/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(649013927, "Lc/a/o0/h/o/c;");
                return;
            }
        }
        f11348j = k.f7049a;
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
        this.f11349a = -1;
        this.f11350b = new Object();
        this.f11354f = new CopyOnWriteArrayList();
    }

    public static synchronized void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (c.class) {
                boolean z = f11348j;
                if (k == null) {
                    return;
                }
                k.f11356h = true;
                if (k.f11353e != null) {
                    k.f11353e.m();
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
            synchronized (this.f11350b) {
                if (!this.f11355g && this.f11353e == null) {
                    K();
                    J();
                    String l = l();
                    if (TextUtils.isEmpty(l) || this.f11356h) {
                        return;
                    }
                    if (f11348j) {
                        String str = "prepareMaster start: " + l;
                    }
                    c.a.o0.h.o.e eVar = new c.a.o0.h.o.e(l, "swan-game.js");
                    this.f11353e = eVar;
                    eVar.v(new d(this));
                }
            }
        }
    }

    public void B(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            boolean z = f11348j;
            if (fVar != null && !this.f11354f.contains(fVar)) {
                this.f11354f.add(fVar);
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
                if (f11348j) {
                    String str = "setExtensionCore: " + this.f11352d;
                }
                this.f11352d = extensionCore;
            } else if (f11348j) {
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
            this.f11351c = swanCoreVersion;
            if (f11348j) {
                String str = "setSwanCoreVersion: " + this.f11351c;
            }
        }
    }

    public void F(SwanAppActivity swanAppActivity) {
        c.a.o0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, swanAppActivity) == null) || swanAppActivity == null || swanAppActivity.isFinishing() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null) {
            return;
        }
        g.b h2 = swanAppFragmentManager.h();
        h2.n(0, 0);
        h2.f();
        h2.j(c.a.o0.h.n.a.q3());
        h2.b();
    }

    public void G(c.a.o0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            ExtensionCore extensionCore = this.f11352d;
            if (extensionCore != null) {
                bVar.B0(extensionCore);
            } else {
                this.f11352d = bVar.O();
            }
        }
    }

    public void H() {
        c.a.o0.h.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eVar = this.f11353e) == null) {
            return;
        }
        eVar.o().E0();
    }

    public void I(c.a.o0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            K();
            SwanCoreVersion swanCoreVersion = this.f11351c;
            if (swanCoreVersion != null) {
                bVar.X0(swanCoreVersion);
            }
            if (f11348j) {
                String str = "syncSwanCore mSwanCoreVersion: " + this.f11351c;
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ExtensionCore extensionCore = this.f11352d;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                boolean z = f11348j;
                D(c.a.o0.a.p0.b.c(1));
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanCoreVersion swanCoreVersion = this.f11351c;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                E(o());
            }
        }
    }

    public void h(Activity activity) {
        c.a.o0.h.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, activity) == null) || (eVar = this.f11353e) == null) {
            return;
        }
        eVar.k(activity);
    }

    public void i(JSEvent jSEvent) {
        c.a.o0.h.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jSEvent) == null) || (eVar = this.f11353e) == null) {
            return;
        }
        eVar.o().S(jSEvent);
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.o0.h.o.e eVar = this.f11353e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f11352d : (ExtensionCore) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SwanCoreVersion swanCoreVersion = this.f11351c;
            return (swanCoreVersion == null || !swanCoreVersion.isAvailable()) ? "" : this.f11351c.swanCorePath;
        }
        return (String) invokeV.objValue;
    }

    public c.a.o0.a.l0.a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            c.a.o0.h.o.e eVar = this.f11353e;
            if (eVar != null) {
                return eVar.o();
            }
            return null;
        }
        return (c.a.o0.a.l0.a) invokeV.objValue;
    }

    public final SwanCoreVersion o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (c.a.o0.h.p.a.c.a(AsInstallService.SCHEME_PACKAGE_ADDED)) {
                if (TextUtils.isEmpty(this.f11357i)) {
                    return null;
                }
                if (!new File(this.f11357i, "swan-game.js").exists()) {
                    q0.b0(new e(this));
                    return c.a.o0.a.m2.b.g(1);
                }
                SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
                swanCoreVersion.swanCorePath = this.f11357i;
                swanCoreVersion.swanCoreType = 2;
                return swanCoreVersion;
            } else if (!c.a.o0.h.p.a.c.a("normal") && !c.a.o0.a.u1.a.a.h()) {
                return c.a.o0.a.m2.b.g(1);
            } else {
                SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
                swanCoreVersion2.swanCorePath = c.a.o0.h.p.a.b.b().getAbsolutePath();
                swanCoreVersion2.swanCoreType = 2;
                boolean z = f11348j;
                return swanCoreVersion2;
            }
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f11349a < 0) {
                c.a.o0.a.c1.a.Z().getSwitch("swan_game_preload", 0);
                this.f11349a = 0;
            }
            if (f11348j) {
                String str = "getPreLoadABSwitch:" + this.f11349a;
            }
            return this.f11349a;
        }
        return invokeV.intValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.o0.a.c1.a.Z().getSwitch("swan_game_startup_improvement", false);
            if (f11348j) {
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
            c.a.o0.h.o.e eVar = this.f11353e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f11351c : (SwanCoreVersion) invokeV.objValue;
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
            synchronized (this.f11350b) {
                z = this.f11355g && this.f11353e != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        DuMixGameSurfaceView r;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.f11356h || (r = r()) == null || r.getParent() != null) ? false : true : invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f11356h || this.f11354f.isEmpty() || !u()) {
            return;
        }
        for (f fVar : this.f11354f) {
            if (fVar != null) {
                fVar.onReady();
            }
        }
        this.f11354f.clear();
    }

    public void x(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            boolean z = f11348j;
            if (cVar == null || TextUtils.isEmpty(cVar.f11512a)) {
                return;
            }
            this.f11357i = cVar.f11512a;
            h.p("startup").A("preload", u() ? "1" : "0");
            h.p("startup").C(new UbcFlowEvent("na_prepare_runtime_start"));
            boolean b2 = c.a.o0.a.h2.d.c().b();
            boolean b3 = c.a.o0.a.h2.d.b();
            if (b2 && b3) {
                B(new C0580c(this, cVar));
                if (this.f11353e != null) {
                    c.a.o0.h.y.e.b.b().f(this.f11353e.o(), cVar);
                    return;
                }
                return;
            }
            if (c.a.o0.a.a2.e.i() != null) {
                c.a.o0.a.j2.p.d dVar = new c.a.o0.a.j2.p.d();
                dVar.q(c.a.o0.a.j2.k.m(1));
                dVar.r(c.a.o0.a.a2.e.i().N());
                dVar.l("gameCoreRuntime", "loadv8Failed");
                c.a.o0.a.j2.k.L(dVar);
            }
            q0.b0(new b(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            boolean z = f11348j;
            z(null);
        }
    }

    public void z(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, intent) == null) {
            if (f11348j) {
                String str = "preloadCoreRuntime preloadScene:" + (intent != null ? intent.getStringExtra("bundle_key_preload_preload_scene") : null);
            }
            if (!u() && t(intent)) {
                boolean b2 = c.a.o0.a.h2.d.c().b();
                boolean b3 = c.a.o0.a.h2.d.b();
                if (b2 && b3) {
                    B(new a(this));
                }
            }
        }
    }
}
