package b.a.p0.h.o;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.k;
import b.a.p0.a.r1.h;
import b.a.p0.a.v2.q0;
import b.a.p0.f.g;
import b.a.p0.h.o.e;
import b.a.p0.h.s.a;
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
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public static volatile c k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f10578a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f10579b;

    /* renamed from: c  reason: collision with root package name */
    public SwanCoreVersion f10580c;

    /* renamed from: d  reason: collision with root package name */
    public ExtensionCore f10581d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.h.o.e f10582e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f10583f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10584g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10585h;

    /* renamed from: i  reason: collision with root package name */
    public String f10586i;

    /* loaded from: classes4.dex */
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

        @Override // b.a.p0.h.o.c.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.j) {
                b.a.p0.a.z1.b.f.e f2 = b.a.p0.a.z1.b.f.e.f(AppRuntime.getAppContext(), g.aiapps_game_preload_core_runtime_end);
                f2.l(1);
                f2.F();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (b.a.p0.a.a2.e.i() != null) {
                    b.a.p0.a.v2.f.j(b.a.p0.a.a2.e.i().x());
                }
                AppRuntime.getAppContext().startActivity(addFlags);
            }
        }
    }

    /* renamed from: b.a.p0.h.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0577c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f10587a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f10588b;

        /* renamed from: b.a.p0.h.o.c$c$a */
        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0577c f10589e;

            public a(C0577c c0577c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0577c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10589e = c0577c;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10589e.f10588b.f10585h || this.f10589e.f10588b.f10582e == null || (activity = b.a.p0.a.g1.f.T().getActivity()) == null || activity.isFinishing() || activity.getSwanAppFragmentManager() == null) {
                    return;
                }
                if (c.j) {
                    String str = "loadAppJs start: " + this.f10589e.f10588b.f10586i;
                }
                this.f10589e.f10588b.f10582e.k(activity);
                this.f10589e.f10588b.f10582e.t(this.f10589e.f10587a);
                if (this.f10589e.f10588b.v()) {
                    this.f10589e.f10588b.F(activity);
                }
            }
        }

        public C0577c(c cVar, a.c cVar2) {
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
            this.f10588b = cVar;
            this.f10587a = cVar2;
        }

        @Override // b.a.p0.h.o.c.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.p("startup").C(new UbcFlowEvent("na_prepare_runtime_end"));
                q0.b0(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements e.InterfaceC0578e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f10590a;

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
            this.f10590a = cVar;
        }

        @Override // b.a.p0.h.o.e.InterfaceC0578e
        public void a(b.a.p0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                boolean unused = c.j;
                synchronized (this.f10590a.f10579b) {
                    this.f10590a.f10584g = true;
                    this.f10590a.w();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public interface f {
        void onReady();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865037529, "Lb/a/p0/h/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-865037529, "Lb/a/p0/h/o/c;");
                return;
            }
        }
        j = k.f6397a;
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
        this.f10578a = -1;
        this.f10579b = new Object();
        this.f10583f = new CopyOnWriteArrayList();
    }

    public static synchronized void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (c.class) {
                boolean z = j;
                if (k == null) {
                    return;
                }
                k.f10585h = true;
                if (k.f10582e != null) {
                    k.f10582e.m();
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
            synchronized (this.f10579b) {
                if (!this.f10584g && this.f10582e == null) {
                    K();
                    J();
                    String l = l();
                    if (TextUtils.isEmpty(l) || this.f10585h) {
                        return;
                    }
                    if (j) {
                        String str = "prepareMaster start: " + l;
                    }
                    b.a.p0.h.o.e eVar = new b.a.p0.h.o.e(l, "swan-game.js");
                    this.f10582e = eVar;
                    eVar.v(new d(this));
                }
            }
        }
    }

    public void B(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            boolean z = j;
            if (fVar != null && !this.f10583f.contains(fVar)) {
                this.f10583f.add(fVar);
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
                if (j) {
                    String str = "setExtensionCore: " + this.f10581d;
                }
                this.f10581d = extensionCore;
            } else if (j) {
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
            this.f10580c = swanCoreVersion;
            if (j) {
                String str = "setSwanCoreVersion: " + this.f10580c;
            }
        }
    }

    public void F(SwanAppActivity swanAppActivity) {
        b.a.p0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, swanAppActivity) == null) || swanAppActivity == null || swanAppActivity.isFinishing() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null) {
            return;
        }
        g.b h2 = swanAppFragmentManager.h();
        h2.n(0, 0);
        h2.f();
        h2.j(b.a.p0.h.n.a.m3());
        h2.b();
    }

    public void G(b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            ExtensionCore extensionCore = this.f10581d;
            if (extensionCore != null) {
                bVar.A0(extensionCore);
            } else {
                this.f10581d = bVar.N();
            }
        }
    }

    public void H() {
        b.a.p0.h.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eVar = this.f10582e) == null) {
            return;
        }
        eVar.o().E0();
    }

    public void I(b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            K();
            SwanCoreVersion swanCoreVersion = this.f10580c;
            if (swanCoreVersion != null) {
                bVar.W0(swanCoreVersion);
            }
            if (j) {
                String str = "syncSwanCore mSwanCoreVersion: " + this.f10580c;
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ExtensionCore extensionCore = this.f10581d;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                boolean z = j;
                D(b.a.p0.a.p0.b.c(1));
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanCoreVersion swanCoreVersion = this.f10580c;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                E(o());
            }
        }
    }

    public void h(Activity activity) {
        b.a.p0.h.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, activity) == null) || (eVar = this.f10582e) == null) {
            return;
        }
        eVar.k(activity);
    }

    public void i(JSEvent jSEvent) {
        b.a.p0.h.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jSEvent) == null) || (eVar = this.f10582e) == null) {
            return;
        }
        eVar.o().i0(jSEvent);
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            b.a.p0.h.o.e eVar = this.f10582e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f10581d : (ExtensionCore) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SwanCoreVersion swanCoreVersion = this.f10580c;
            return (swanCoreVersion == null || !swanCoreVersion.isAvailable()) ? "" : this.f10580c.swanCorePath;
        }
        return (String) invokeV.objValue;
    }

    public b.a.p0.a.l0.a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.a.p0.h.o.e eVar = this.f10582e;
            if (eVar != null) {
                return eVar.o();
            }
            return null;
        }
        return (b.a.p0.a.l0.a) invokeV.objValue;
    }

    public final SwanCoreVersion o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (b.a.p0.h.p.a.c.a("package")) {
                if (TextUtils.isEmpty(this.f10586i)) {
                    return null;
                }
                if (!new File(this.f10586i, "swan-game.js").exists()) {
                    q0.b0(new e(this));
                    return b.a.p0.a.m2.b.g(1);
                }
                SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
                swanCoreVersion.swanCorePath = this.f10586i;
                swanCoreVersion.swanCoreType = 2;
                return swanCoreVersion;
            } else if (!b.a.p0.h.p.a.c.a("normal") && !b.a.p0.a.u1.a.a.h()) {
                return b.a.p0.a.m2.b.g(1);
            } else {
                SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
                swanCoreVersion2.swanCorePath = b.a.p0.h.p.a.b.b().getAbsolutePath();
                swanCoreVersion2.swanCoreType = 2;
                boolean z = j;
                return swanCoreVersion2;
            }
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f10578a < 0) {
                b.a.p0.a.c1.a.Z().getSwitch("swan_game_preload", 0);
                this.f10578a = 0;
            }
            if (j) {
                String str = "getPreLoadABSwitch:" + this.f10578a;
            }
            return this.f10578a;
        }
        return invokeV.intValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.a.p0.a.c1.a.Z().getSwitch("swan_game_startup_improvement", false);
            if (j) {
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
            b.a.p0.h.o.e eVar = this.f10582e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f10580c : (SwanCoreVersion) invokeV.objValue;
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
            synchronized (this.f10579b) {
                z = this.f10584g && this.f10582e != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        DuMixGameSurfaceView r;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.f10585h || (r = r()) == null || r.getParent() != null) ? false : true : invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f10585h || this.f10583f.isEmpty() || !u()) {
            return;
        }
        for (f fVar : this.f10583f) {
            if (fVar != null) {
                fVar.onReady();
            }
        }
        this.f10583f.clear();
    }

    public void x(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            boolean z = j;
            if (cVar == null || TextUtils.isEmpty(cVar.f10740a)) {
                return;
            }
            this.f10586i = cVar.f10740a;
            h.p("startup").A("preload", u() ? "1" : "0");
            h.p("startup").C(new UbcFlowEvent("na_prepare_runtime_start"));
            boolean b2 = b.a.p0.a.h2.d.c().b();
            boolean b3 = b.a.p0.a.h2.d.b();
            if (b2 && b3) {
                B(new C0577c(this, cVar));
                if (this.f10582e != null) {
                    b.a.p0.h.y.e.b.b().f(this.f10582e.o(), cVar);
                    return;
                }
                return;
            }
            if (b.a.p0.a.a2.e.i() != null) {
                b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
                dVar.q(b.a.p0.a.j2.k.m(1));
                dVar.r(b.a.p0.a.a2.e.i().M());
                dVar.l("gameCoreRuntime", "loadv8Failed");
                b.a.p0.a.j2.k.L(dVar);
            }
            q0.b0(new b(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            boolean z = j;
            z(null);
        }
    }

    public void z(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, intent) == null) {
            if (j) {
                String str = "preloadCoreRuntime preloadScene:" + (intent != null ? intent.getStringExtra("bundle_key_preload_preload_scene") : null);
            }
            if (!u() && t(intent)) {
                boolean b2 = b.a.p0.a.h2.d.c().b();
                boolean b3 = b.a.p0.a.h2.d.b();
                if (b2 && b3) {
                    B(new a(this));
                }
            }
        }
    }
}
