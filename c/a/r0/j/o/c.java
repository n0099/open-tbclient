package c.a.r0.j.o;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.k;
import c.a.r0.a.n2.n;
import c.a.r0.a.u1.h;
import c.a.r0.a.z2.q0;
import c.a.r0.h.g;
import c.a.r0.j.o.e;
import c.a.r0.j.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f11368j;

    /* renamed from: k  reason: collision with root package name */
    public static volatile c f11369k;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f11370b;

    /* renamed from: c  reason: collision with root package name */
    public SwanCoreVersion f11371c;

    /* renamed from: d  reason: collision with root package name */
    public ExtensionCore f11372d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.j.o.e f11373e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f11374f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11375g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11376h;

    /* renamed from: i  reason: collision with root package name */
    public String f11377i;

    /* loaded from: classes6.dex */
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

        @Override // c.a.r0.j.o.c.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.f11368j) {
                c.a.r0.a.c2.b.f.e f2 = c.a.r0.a.c2.b.f.e.f(AppRuntime.getAppContext(), g.aiapps_game_preload_core_runtime_end);
                f2.l(1);
                f2.G();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (c.a.r0.a.d2.e.L() != null) {
                    c.a.r0.a.z2.f.j(c.a.r0.a.d2.e.L().x());
                }
                AppRuntime.getAppContext().startActivity(addFlags);
            }
        }
    }

    /* renamed from: c.a.r0.j.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0749c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f11378b;

        /* renamed from: c.a.r0.j.o.c$c$a */
        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0749c f11379e;

            public a(C0749c c0749c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0749c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11379e = c0749c;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11379e.f11378b.f11376h || this.f11379e.f11378b.f11373e == null || (activity = c.a.r0.a.g1.f.U().getActivity()) == null || activity.isFinishing() || activity.getSwanAppFragmentManager() == null) {
                    return;
                }
                if (c.f11368j) {
                    String str = "loadAppJs start: " + this.f11379e.f11378b.f11377i;
                }
                this.f11379e.f11378b.f11373e.k(activity);
                this.f11379e.f11378b.f11373e.t(this.f11379e.a);
                if (this.f11379e.f11378b.v()) {
                    this.f11379e.f11378b.F(activity);
                }
            }
        }

        public C0749c(c cVar, a.c cVar2) {
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
            this.f11378b = cVar;
            this.a = cVar2;
        }

        @Override // c.a.r0.j.o.c.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("na_prepare_runtime_end"));
                q0.e0(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements e.InterfaceC0751e {
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

        @Override // c.a.r0.j.o.e.InterfaceC0751e
        public void a(c.a.r0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                boolean unused = c.f11368j;
                synchronized (this.a.f11370b) {
                    this.a.f11375g = true;
                    this.a.w();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public interface f {
        void onReady();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-421123864, "Lc/a/r0/j/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-421123864, "Lc/a/r0/j/o/c;");
                return;
            }
        }
        f11368j = k.a;
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
        this.f11370b = new Object();
        this.f11374f = new CopyOnWriteArrayList();
    }

    public static synchronized void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (c.class) {
                boolean z = f11368j;
                if (f11369k == null) {
                    return;
                }
                f11369k.f11376h = true;
                if (f11369k.f11373e != null) {
                    f11369k.f11373e.m();
                }
                f11369k = null;
                m().y();
            }
        }
    }

    public static c m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f11369k == null) {
                synchronized (c.class) {
                    if (f11369k == null) {
                        f11369k = new c();
                    }
                }
            }
            return f11369k;
        }
        return (c) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.f11370b) {
                if (!this.f11375g && this.f11373e == null) {
                    K();
                    J();
                    String l = l();
                    if (TextUtils.isEmpty(l) || this.f11376h) {
                        return;
                    }
                    if (f11368j) {
                        String str = "prepareMaster start: " + l;
                    }
                    c.a.r0.j.o.e eVar = new c.a.r0.j.o.e(l, "swan-game.js");
                    this.f11373e = eVar;
                    eVar.v(new d(this));
                }
            }
        }
    }

    public void B(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            boolean z = f11368j;
            if (fVar != null && !this.f11374f.contains(fVar)) {
                this.f11374f.add(fVar);
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
                if (f11368j) {
                    String str = "setExtensionCore: " + this.f11372d;
                }
                this.f11372d = extensionCore;
            } else if (f11368j) {
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
            this.f11371c = swanCoreVersion;
            if (f11368j) {
                String str = "setSwanCoreVersion: " + this.f11371c;
            }
        }
    }

    public void F(SwanAppActivity swanAppActivity) {
        c.a.r0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, swanAppActivity) == null) || swanAppActivity == null || swanAppActivity.isFinishing() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null) {
            return;
        }
        g.b h2 = swanAppFragmentManager.h();
        h2.n(0, 0);
        h2.f();
        h2.j(c.a.r0.j.n.a.A3());
        h2.b();
    }

    public void G(c.a.r0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            ExtensionCore extensionCore = this.f11372d;
            if (extensionCore != null) {
                bVar.C0(extensionCore);
            } else {
                this.f11372d = bVar.O();
            }
        }
    }

    public void H() {
        c.a.r0.j.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eVar = this.f11373e) == null) {
            return;
        }
        eVar.o().F0();
    }

    public void I(c.a.r0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            K();
            SwanCoreVersion swanCoreVersion = this.f11371c;
            if (swanCoreVersion != null) {
                bVar.Z0(swanCoreVersion);
            }
            if (f11368j) {
                String str = "syncSwanCore mSwanCoreVersion: " + this.f11371c;
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ExtensionCore extensionCore = this.f11372d;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                boolean z = f11368j;
                D(c.a.r0.a.p0.b.c(1));
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanCoreVersion swanCoreVersion = this.f11371c;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                E(o());
            }
        }
    }

    public void h(Activity activity) {
        c.a.r0.j.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, activity) == null) || (eVar = this.f11373e) == null) {
            return;
        }
        eVar.k(activity);
    }

    public void i(JSEvent jSEvent) {
        c.a.r0.j.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jSEvent) == null) || (eVar = this.f11373e) == null) {
            return;
        }
        eVar.o().dispatchEvent(jSEvent);
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.r0.j.o.e eVar = this.f11373e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f11372d : (ExtensionCore) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SwanCoreVersion swanCoreVersion = this.f11371c;
            return (swanCoreVersion == null || !swanCoreVersion.isAvailable()) ? "" : this.f11371c.swanCorePath;
        }
        return (String) invokeV.objValue;
    }

    public c.a.r0.a.l0.a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            c.a.r0.j.o.e eVar = this.f11373e;
            if (eVar != null) {
                return eVar.o();
            }
            return null;
        }
        return (c.a.r0.a.l0.a) invokeV.objValue;
    }

    public final SwanCoreVersion o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (c.a.r0.j.p.a.c.a("package")) {
                if (TextUtils.isEmpty(this.f11377i)) {
                    return null;
                }
                if (!new File(this.f11377i, "swan-game.js").exists()) {
                    q0.e0(new e(this));
                    return c.a.r0.a.q2.b.g(1);
                }
                SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
                swanCoreVersion.swanCorePath = this.f11377i;
                swanCoreVersion.swanCoreType = 2;
                return swanCoreVersion;
            } else if (!c.a.r0.j.p.a.c.a("normal") && !c.a.r0.a.x1.a.a.h()) {
                return c.a.r0.a.q2.b.g(1);
            } else {
                SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
                swanCoreVersion2.swanCorePath = c.a.r0.j.p.a.b.b().getAbsolutePath();
                swanCoreVersion2.swanCoreType = 2;
                boolean z = f11368j;
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
                c.a.r0.a.c1.a.g0().getSwitch("swan_game_preload", 0);
                this.a = 0;
            }
            if (f11368j) {
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
            c.a.r0.a.c1.a.g0().getSwitch("swan_game_startup_improvement", false);
            if (f11368j) {
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
            c.a.r0.j.o.e eVar = this.f11373e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f11371c : (SwanCoreVersion) invokeV.objValue;
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
            synchronized (this.f11370b) {
                z = this.f11375g && this.f11373e != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        DuMixGameSurfaceView r;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.f11376h || (r = r()) == null || r.getParent() != null) ? false : true : invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f11376h || this.f11374f.isEmpty() || !u()) {
            return;
        }
        for (f fVar : this.f11374f) {
            if (fVar != null) {
                fVar.onReady();
            }
        }
        this.f11374f.clear();
    }

    public void x(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            boolean z = f11368j;
            if (cVar == null || TextUtils.isEmpty(cVar.a)) {
                return;
            }
            this.f11377i = cVar.a;
            h.p(NodeJS.STARTUP_SCRIPT_NAME).D("preload", u() ? "1" : "0");
            h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("na_prepare_runtime_start"));
            boolean b2 = c.a.r0.a.k2.d.c().b();
            boolean b3 = c.a.r0.a.k2.d.b();
            if (b2 && b3) {
                B(new C0749c(this, cVar));
                if (this.f11373e != null) {
                    c.a.r0.j.z.e.b.b().f(this.f11373e.o(), cVar);
                    return;
                }
                return;
            }
            if (c.a.r0.a.d2.e.L() != null) {
                c.a.r0.a.n2.s.d dVar = new c.a.r0.a.n2.s.d();
                dVar.q(n.n(1));
                dVar.r(c.a.r0.a.d2.e.L().X());
                dVar.l("gameCoreRuntime", "loadv8Failed");
                n.R(dVar);
            }
            q0.e0(new b(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            boolean z = f11368j;
            z(null);
        }
    }

    public void z(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, intent) == null) {
            if (f11368j) {
                String str = "preloadCoreRuntime preloadScene:" + (intent != null ? intent.getStringExtra("bundle_key_preload_preload_scene") : null);
            }
            if (!u() && t(intent)) {
                boolean b2 = c.a.r0.a.k2.d.c().b();
                boolean b3 = c.a.r0.a.k2.d.b();
                if (b2 && b3) {
                    B(new a(this));
                }
            }
        }
    }
}
