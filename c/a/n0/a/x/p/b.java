package c.a.n0.a.x.p;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.k.e.i.e;
import c.a.n0.a.k1.h;
import c.a.n0.a.p2.d0;
import c.a.n0.a.p2.o0;
import c.a.n0.a.q0.d;
import c.a.n0.a.t1.d;
import c.a.n0.a.v1.f.o0.c;
import c.a.n0.a.v1.f.o0.j;
import c.a.n0.a.w0.f;
import c.a.n0.a.x.u.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f7392b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.n0.a.x.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0569b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1336673722, "Lc/a/n0/a/x/p/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1336673722, "Lc/a/n0/a/x/p/b$b;");
                    return;
                }
            }
            a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622619260, "Lc/a/n0/a/x/p/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622619260, "Lc/a/n0/a/x/p/b;");
                return;
            }
        }
        f7392b = c.a.n0.a.a.a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0569b.a : (b) invokeV.objValue;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (f7392b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            e.k(swanAppConfigData);
            c.a.n0.a.x.q.b.k().x(d.J().getAppId(), false);
            c.a.n0.a.f2.b.l().t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ef A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013d A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01bf A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c7 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e0 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022e A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Type inference failed for: r3v15, types: [c.a.n0.a.f.e.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull c.a.n0.a.x.l.a aVar, @NonNull c.a.n0.a.f.e.b bVar, @NonNull c.a.n0.a.v0.e.b bVar2, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        c.a.n0.a.x.u.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, bVar, bVar2, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (f7392b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        c.a.n0.a.x.u.b.c(14);
                    }
                    return;
                }
                if (z) {
                    c.a.n0.a.x.u.b.c(1);
                }
                String d2 = c.d(f.U(), bVar2, swanAppConfigData);
                String h2 = swanAppConfigData.h(d2);
                c.a.n0.a.x.u.a aVar2 = new c.a.n0.a.x.u.a();
                aVar2.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    aVar2.f7466b = gVar.a;
                } else {
                    aVar2.f7466b = d.e.i(bVar2.H(), bVar2.v1()).getPath() + File.separator;
                }
                aVar2.f7467c = bVar.c();
                aVar2.f7468d = d2;
                aVar2.f7470f = String.valueOf(c.a.n0.a.u.a.a());
                aVar2.f7471g = c.a.n0.a.x.u.a.c(c.a.n0.a.t1.e.L(), d2);
                aVar2.i = h2;
                if (!f7392b && !f.U().N()) {
                    z2 = false;
                    aVar2.f7472h = z2;
                    aVar2.j = bVar.M();
                    aVar2.l = c.a.n0.a.x.u.e.b();
                    f0 = bVar2.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        aVar2.m = f0.userActionApis;
                    }
                    H = c.a.n0.a.n1.a.a.H();
                    if (H) {
                        aVar2.k = c.a.n0.a.u.f.b.b();
                    }
                    P = bVar2.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            aVar2.f7469e = string;
                        }
                    }
                    if (f7392b) {
                        Log.d("AppLaunchMessenger", aVar2.toString());
                    }
                    h.o().F(new UbcFlowEvent("master_dispatch_start"));
                    c.a.n0.a.c2.a.d().i("master_dispatch_start");
                    aVar.F(aVar2);
                    g.U().U0(c.a.n0.a.x.u.a.b(aVar2));
                    c.a.n0.a.s0.a.m0().a();
                    g.U().h1(aVar2.j);
                    F = c.a.n0.a.n1.a.a.F(bVar2.g0());
                    boolean p0 = bVar2.p0();
                    if (!F) {
                        c.a.n0.a.u.f.e.d.d();
                        c.a.n0.a.u.f.e.d.g().h("appready");
                    } else if (p0) {
                        c.a.n0.a.u.f.d.d.e().f("appready");
                    }
                    c.a.n0.a.t1.n.g f2 = f.U().f(j.b(o0.f(d2)));
                    dVar = new c.a.n0.a.x.u.d();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        dVar.a = gVar.a;
                    } else {
                        dVar.a = d.e.i(bVar2.H(), bVar2.v1()).getPath() + File.separator;
                    }
                    dVar.f7474b = d2;
                    dVar.f7476d = f2.f6384g;
                    dVar.f7475c = h2;
                    dVar.k = aVar2.f7471g;
                    dVar.f7477e = String.valueOf(bVar2.m0());
                    dVar.f7479g = z2;
                    dVar.i = bVar.M();
                    dVar.m = true;
                    if (H) {
                        dVar.j = c.a.n0.a.u.f.b.d();
                    }
                    if (!F) {
                        c.a.n0.a.u.f.e.d.g().h("pageready");
                    } else if (p0) {
                        c.a.n0.a.u.f.d.d.e().f("pageready");
                    }
                    if (f7392b) {
                        Log.d("AppLaunchMessenger", dVar.toString());
                    }
                    h.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    c.a.n0.a.c2.a.d().i("slave_dispatch_start");
                    bVar.N(dVar);
                    d0.d();
                    bVar.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d2);
                    bVar.U(d2);
                    g.U().V0(bVar.c(), c.a.n0.a.x.u.d.a(dVar));
                    c.a.n0.a.d2.e.F(bVar.c(), dVar.f7474b);
                    if (f7392b) {
                        Log.d("AppLaunchMessenger", "app path: " + aVar2.f7466b);
                        Log.d("AppLaunchMessenger", "webviewId: " + bVar.c());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d2);
                        Log.d("AppLaunchMessenger", "pagePath: " + dVar.f7474b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + dVar.f7476d);
                        Log.d("AppLaunchMessenger", "sConsole:" + dVar.f7477e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                aVar2.f7472h = z2;
                aVar2.j = bVar.M();
                aVar2.l = c.a.n0.a.x.u.e.b();
                f0 = bVar2.f0();
                if (f0 != null) {
                    aVar2.m = f0.userActionApis;
                }
                H = c.a.n0.a.n1.a.a.H();
                if (H) {
                }
                P = bVar2.P();
                if (P != null) {
                }
                if (f7392b) {
                }
                h.o().F(new UbcFlowEvent("master_dispatch_start"));
                c.a.n0.a.c2.a.d().i("master_dispatch_start");
                aVar.F(aVar2);
                g.U().U0(c.a.n0.a.x.u.a.b(aVar2));
                c.a.n0.a.s0.a.m0().a();
                g.U().h1(aVar2.j);
                F = c.a.n0.a.n1.a.a.F(bVar2.g0());
                boolean p02 = bVar2.p0();
                if (!F) {
                }
                c.a.n0.a.t1.n.g f22 = f.U().f(j.b(o0.f(d2)));
                dVar = new c.a.n0.a.x.u.d();
                if (gVar == null) {
                }
                dVar.a = d.e.i(bVar2.H(), bVar2.v1()).getPath() + File.separator;
                dVar.f7474b = d2;
                dVar.f7476d = f22.f6384g;
                dVar.f7475c = h2;
                dVar.k = aVar2.f7471g;
                dVar.f7477e = String.valueOf(bVar2.m0());
                dVar.f7479g = z2;
                dVar.i = bVar.M();
                dVar.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (f7392b) {
                }
                h.o().F(new UbcFlowEvent("slave_dispatch_start"));
                c.a.n0.a.c2.a.d().i("slave_dispatch_start");
                bVar.N(dVar);
                d0.d();
                bVar.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d2);
                bVar.U(d2);
                g.U().V0(bVar.c(), c.a.n0.a.x.u.d.a(dVar));
                c.a.n0.a.d2.e.F(bVar.c(), dVar.f7474b);
                if (f7392b) {
                }
                a(swanAppConfigData);
                this.a = true;
                e();
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public final void e() {
        int b2;
        c.a.n0.a.x.l.a W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (b2 = c.a.n0.a.k1.l.b.b()) == 0 || (W = g.U().W()) == null) {
            return;
        }
        if (b2 < 0) {
            W.r(b2);
        } else if (b2 == 1) {
            W.r(-4);
        } else {
            W.r(-2);
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
    }
}
