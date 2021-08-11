package c.a.n0.h.o;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.h0.g.g;
import c.a.n0.a.k;
import c.a.n0.a.r1.h;
import c.a.n0.a.v2.q0;
import c.a.n0.f.g;
import c.a.n0.h.o.e;
import c.a.n0.h.s.a;
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
    public static final boolean f11102j;
    public static volatile c k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11103a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f11104b;

    /* renamed from: c  reason: collision with root package name */
    public SwanCoreVersion f11105c;

    /* renamed from: d  reason: collision with root package name */
    public ExtensionCore f11106d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.h.o.e f11107e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f11108f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11109g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11110h;

    /* renamed from: i  reason: collision with root package name */
    public String f11111i;

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

        @Override // c.a.n0.h.o.c.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.f11102j) {
                c.a.n0.a.z1.b.f.e f2 = c.a.n0.a.z1.b.f.e.f(AppRuntime.getAppContext(), g.aiapps_game_preload_core_runtime_end);
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
                if (c.a.n0.a.a2.e.i() != null) {
                    c.a.n0.a.v2.f.j(c.a.n0.a.a2.e.i().x());
                }
                AppRuntime.getAppContext().startActivity(addFlags);
            }
        }
    }

    /* renamed from: c.a.n0.h.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0572c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f11112a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f11113b;

        /* renamed from: c.a.n0.h.o.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0572c f11114e;

            public a(C0572c c0572c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0572c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11114e = c0572c;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11114e.f11113b.f11110h || this.f11114e.f11113b.f11107e == null || (activity = c.a.n0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.getSwanAppFragmentManager() == null) {
                    return;
                }
                if (c.f11102j) {
                    String str = "loadAppJs start: " + this.f11114e.f11113b.f11111i;
                }
                this.f11114e.f11113b.f11107e.k(activity);
                this.f11114e.f11113b.f11107e.t(this.f11114e.f11112a);
                if (this.f11114e.f11113b.v()) {
                    this.f11114e.f11113b.F(activity);
                }
            }
        }

        public C0572c(c cVar, a.c cVar2) {
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
            this.f11113b = cVar;
            this.f11112a = cVar2;
        }

        @Override // c.a.n0.h.o.c.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.p("startup").C(new UbcFlowEvent("na_prepare_runtime_end"));
                q0.b0(new a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements e.InterfaceC0573e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f11115a;

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
            this.f11115a = cVar;
        }

        @Override // c.a.n0.h.o.e.InterfaceC0573e
        public void a(c.a.n0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                boolean unused = c.f11102j;
                synchronized (this.f11115a.f11104b) {
                    this.f11115a.f11109g = true;
                    this.f11115a.w();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1838498906, "Lc/a/n0/h/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1838498906, "Lc/a/n0/h/o/c;");
                return;
            }
        }
        f11102j = k.f6803a;
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
        this.f11103a = -1;
        this.f11104b = new Object();
        this.f11108f = new CopyOnWriteArrayList();
    }

    public static synchronized void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (c.class) {
                boolean z = f11102j;
                if (k == null) {
                    return;
                }
                k.f11110h = true;
                if (k.f11107e != null) {
                    k.f11107e.m();
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
            synchronized (this.f11104b) {
                if (!this.f11109g && this.f11107e == null) {
                    K();
                    J();
                    String l = l();
                    if (TextUtils.isEmpty(l) || this.f11110h) {
                        return;
                    }
                    if (f11102j) {
                        String str = "prepareMaster start: " + l;
                    }
                    c.a.n0.h.o.e eVar = new c.a.n0.h.o.e(l, "swan-game.js");
                    this.f11107e = eVar;
                    eVar.v(new d(this));
                }
            }
        }
    }

    public void B(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            boolean z = f11102j;
            if (fVar != null && !this.f11108f.contains(fVar)) {
                this.f11108f.add(fVar);
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
                if (f11102j) {
                    String str = "setExtensionCore: " + this.f11106d;
                }
                this.f11106d = extensionCore;
            } else if (f11102j) {
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
            this.f11105c = swanCoreVersion;
            if (f11102j) {
                String str = "setSwanCoreVersion: " + this.f11105c;
            }
        }
    }

    public void F(SwanAppActivity swanAppActivity) {
        c.a.n0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, swanAppActivity) == null) || swanAppActivity == null || swanAppActivity.isFinishing() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null) {
            return;
        }
        g.b h2 = swanAppFragmentManager.h();
        h2.n(0, 0);
        h2.f();
        h2.j(c.a.n0.h.n.a.q3());
        h2.b();
    }

    public void G(c.a.n0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            ExtensionCore extensionCore = this.f11106d;
            if (extensionCore != null) {
                bVar.B0(extensionCore);
            } else {
                this.f11106d = bVar.O();
            }
        }
    }

    public void H() {
        c.a.n0.h.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eVar = this.f11107e) == null) {
            return;
        }
        eVar.o().E0();
    }

    public void I(c.a.n0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            K();
            SwanCoreVersion swanCoreVersion = this.f11105c;
            if (swanCoreVersion != null) {
                bVar.X0(swanCoreVersion);
            }
            if (f11102j) {
                String str = "syncSwanCore mSwanCoreVersion: " + this.f11105c;
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ExtensionCore extensionCore = this.f11106d;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                boolean z = f11102j;
                D(c.a.n0.a.p0.b.c(1));
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanCoreVersion swanCoreVersion = this.f11105c;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                E(o());
            }
        }
    }

    public void h(Activity activity) {
        c.a.n0.h.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, activity) == null) || (eVar = this.f11107e) == null) {
            return;
        }
        eVar.k(activity);
    }

    public void i(JSEvent jSEvent) {
        c.a.n0.h.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jSEvent) == null) || (eVar = this.f11107e) == null) {
            return;
        }
        eVar.o().S(jSEvent);
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.n0.h.o.e eVar = this.f11107e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f11106d : (ExtensionCore) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SwanCoreVersion swanCoreVersion = this.f11105c;
            return (swanCoreVersion == null || !swanCoreVersion.isAvailable()) ? "" : this.f11105c.swanCorePath;
        }
        return (String) invokeV.objValue;
    }

    public c.a.n0.a.l0.a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            c.a.n0.h.o.e eVar = this.f11107e;
            if (eVar != null) {
                return eVar.o();
            }
            return null;
        }
        return (c.a.n0.a.l0.a) invokeV.objValue;
    }

    public final SwanCoreVersion o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (c.a.n0.h.p.a.c.a(AsInstallService.SCHEME_PACKAGE_ADDED)) {
                if (TextUtils.isEmpty(this.f11111i)) {
                    return null;
                }
                if (!new File(this.f11111i, "swan-game.js").exists()) {
                    q0.b0(new e(this));
                    return c.a.n0.a.m2.b.g(1);
                }
                SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
                swanCoreVersion.swanCorePath = this.f11111i;
                swanCoreVersion.swanCoreType = 2;
                return swanCoreVersion;
            } else if (!c.a.n0.h.p.a.c.a("normal") && !c.a.n0.a.u1.a.a.h()) {
                return c.a.n0.a.m2.b.g(1);
            } else {
                SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
                swanCoreVersion2.swanCorePath = c.a.n0.h.p.a.b.b().getAbsolutePath();
                swanCoreVersion2.swanCoreType = 2;
                boolean z = f11102j;
                return swanCoreVersion2;
            }
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f11103a < 0) {
                c.a.n0.a.c1.a.Z().getSwitch("swan_game_preload", 0);
                this.f11103a = 0;
            }
            if (f11102j) {
                String str = "getPreLoadABSwitch:" + this.f11103a;
            }
            return this.f11103a;
        }
        return invokeV.intValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.n0.a.c1.a.Z().getSwitch("swan_game_startup_improvement", false);
            if (f11102j) {
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
            c.a.n0.h.o.e eVar = this.f11107e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f11105c : (SwanCoreVersion) invokeV.objValue;
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
            synchronized (this.f11104b) {
                z = this.f11109g && this.f11107e != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        DuMixGameSurfaceView r;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.f11110h || (r = r()) == null || r.getParent() != null) ? false : true : invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f11110h || this.f11108f.isEmpty() || !u()) {
            return;
        }
        for (f fVar : this.f11108f) {
            if (fVar != null) {
                fVar.onReady();
            }
        }
        this.f11108f.clear();
    }

    public void x(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            boolean z = f11102j;
            if (cVar == null || TextUtils.isEmpty(cVar.f11266a)) {
                return;
            }
            this.f11111i = cVar.f11266a;
            h.p("startup").A("preload", u() ? "1" : "0");
            h.p("startup").C(new UbcFlowEvent("na_prepare_runtime_start"));
            boolean b2 = c.a.n0.a.h2.d.c().b();
            boolean b3 = c.a.n0.a.h2.d.b();
            if (b2 && b3) {
                B(new C0572c(this, cVar));
                if (this.f11107e != null) {
                    c.a.n0.h.y.e.b.b().f(this.f11107e.o(), cVar);
                    return;
                }
                return;
            }
            if (c.a.n0.a.a2.e.i() != null) {
                c.a.n0.a.j2.p.d dVar = new c.a.n0.a.j2.p.d();
                dVar.q(c.a.n0.a.j2.k.m(1));
                dVar.r(c.a.n0.a.a2.e.i().N());
                dVar.l("gameCoreRuntime", "loadv8Failed");
                c.a.n0.a.j2.k.L(dVar);
            }
            q0.b0(new b(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            boolean z = f11102j;
            z(null);
        }
    }

    public void z(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, intent) == null) {
            if (f11102j) {
                String str = "preloadCoreRuntime preloadScene:" + (intent != null ? intent.getStringExtra("bundle_key_preload_preload_scene") : null);
            }
            if (!u() && t(intent)) {
                boolean b2 = c.a.n0.a.h2.d.c().b();
                boolean b3 = c.a.n0.a.h2.d.b();
                if (b2 && b3) {
                    B(new a(this));
                }
            }
        }
    }
}
