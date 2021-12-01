package c.a.p0.a.h0.p;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.a1.d;
import c.a.p0.a.d2.d;
import c.a.p0.a.f2.f.o0.c;
import c.a.p0.a.f2.f.o0.j;
import c.a.p0.a.g1.f;
import c.a.p0.a.h0.u.g;
import c.a.p0.a.k;
import c.a.p0.a.u.e.i.e;
import c.a.p0.a.u1.h;
import c.a.p0.a.z2.d0;
import c.a.p0.a.z2.o0;
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
    public static final boolean f5925b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.p0.a.h0.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0310b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1061400554, "Lc/a/p0/a/h0/p/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1061400554, "Lc/a/p0/a/h0/p/b$b;");
                    return;
                }
            }
            a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1087136808, "Lc/a/p0/a/h0/p/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1087136808, "Lc/a/p0/a/h0/p/b;");
                return;
            }
        }
        f5925b = k.a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0310b.a : (b) invokeV.objValue;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            boolean z = f5925b;
            e.k(swanAppConfigData);
            c.a.p0.a.h0.q.b.k().x(d.J().getAppId(), false);
            c.a.p0.a.p2.b.l().t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1 A[Catch: all -> 0x0289, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00cd, B:40:0x00d9, B:41:0x00db, B:43:0x00df, B:44:0x00e2, B:46:0x0127, B:49:0x013f, B:51:0x0156, B:53:0x015e, B:55:0x0186, B:57:0x01a9, B:59:0x01b1, B:62:0x01c6, B:64:0x01ca, B:65:0x01cd, B:67:0x0212, B:68:0x027e, B:61:0x01bd, B:54:0x0163, B:48:0x0136, B:20:0x0048), top: B:77:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cd A[Catch: all -> 0x0289, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00cd, B:40:0x00d9, B:41:0x00db, B:43:0x00df, B:44:0x00e2, B:46:0x0127, B:49:0x013f, B:51:0x0156, B:53:0x015e, B:55:0x0186, B:57:0x01a9, B:59:0x01b1, B:62:0x01c6, B:64:0x01ca, B:65:0x01cd, B:67:0x0212, B:68:0x027e, B:61:0x01bd, B:54:0x0163, B:48:0x0136, B:20:0x0048), top: B:77:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00df A[Catch: all -> 0x0289, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00cd, B:40:0x00d9, B:41:0x00db, B:43:0x00df, B:44:0x00e2, B:46:0x0127, B:49:0x013f, B:51:0x0156, B:53:0x015e, B:55:0x0186, B:57:0x01a9, B:59:0x01b1, B:62:0x01c6, B:64:0x01ca, B:65:0x01cd, B:67:0x0212, B:68:0x027e, B:61:0x01bd, B:54:0x0163, B:48:0x0136, B:20:0x0048), top: B:77:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0127 A[Catch: all -> 0x0289, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00cd, B:40:0x00d9, B:41:0x00db, B:43:0x00df, B:44:0x00e2, B:46:0x0127, B:49:0x013f, B:51:0x0156, B:53:0x015e, B:55:0x0186, B:57:0x01a9, B:59:0x01b1, B:62:0x01c6, B:64:0x01ca, B:65:0x01cd, B:67:0x0212, B:68:0x027e, B:61:0x01bd, B:54:0x0163, B:48:0x0136, B:20:0x0048), top: B:77:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a9 A[Catch: all -> 0x0289, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00cd, B:40:0x00d9, B:41:0x00db, B:43:0x00df, B:44:0x00e2, B:46:0x0127, B:49:0x013f, B:51:0x0156, B:53:0x015e, B:55:0x0186, B:57:0x01a9, B:59:0x01b1, B:62:0x01c6, B:64:0x01ca, B:65:0x01cd, B:67:0x0212, B:68:0x027e, B:61:0x01bd, B:54:0x0163, B:48:0x0136, B:20:0x0048), top: B:77:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b1 A[Catch: all -> 0x0289, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00cd, B:40:0x00d9, B:41:0x00db, B:43:0x00df, B:44:0x00e2, B:46:0x0127, B:49:0x013f, B:51:0x0156, B:53:0x015e, B:55:0x0186, B:57:0x01a9, B:59:0x01b1, B:62:0x01c6, B:64:0x01ca, B:65:0x01cd, B:67:0x0212, B:68:0x027e, B:61:0x01bd, B:54:0x0163, B:48:0x0136, B:20:0x0048), top: B:77:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ca A[Catch: all -> 0x0289, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00cd, B:40:0x00d9, B:41:0x00db, B:43:0x00df, B:44:0x00e2, B:46:0x0127, B:49:0x013f, B:51:0x0156, B:53:0x015e, B:55:0x0186, B:57:0x01a9, B:59:0x01b1, B:62:0x01c6, B:64:0x01ca, B:65:0x01cd, B:67:0x0212, B:68:0x027e, B:61:0x01bd, B:54:0x0163, B:48:0x0136, B:20:0x0048), top: B:77:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0212 A[Catch: all -> 0x0289, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00cd, B:40:0x00d9, B:41:0x00db, B:43:0x00df, B:44:0x00e2, B:46:0x0127, B:49:0x013f, B:51:0x0156, B:53:0x015e, B:55:0x0186, B:57:0x01a9, B:59:0x01b1, B:62:0x01c6, B:64:0x01ca, B:65:0x01cd, B:67:0x0212, B:68:0x027e, B:61:0x01bd, B:54:0x0163, B:48:0x0136, B:20:0x0048), top: B:77:0x000d }] */
    /* JADX WARN: Type inference failed for: r3v15, types: [c.a.p0.a.p.e.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull c.a.p0.a.h0.l.a aVar, @NonNull c.a.p0.a.p.e.b bVar, @NonNull c.a.p0.a.f1.e.b bVar2, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        c.a.p0.a.h0.u.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, bVar, bVar2, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                boolean z3 = f5925b;
                if (this.a) {
                    if (z) {
                        c.a.p0.a.h0.u.b.c(14);
                    }
                    return;
                }
                if (z) {
                    c.a.p0.a.h0.u.b.c(1);
                }
                String d2 = c.d(f.U(), bVar2, swanAppConfigData);
                String h2 = swanAppConfigData.h(d2);
                c.a.p0.a.h0.u.a aVar2 = new c.a.p0.a.h0.u.a();
                aVar2.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    aVar2.f6010b = gVar.a;
                } else {
                    aVar2.f6010b = d.e.i(bVar2.H(), bVar2.v1()).getPath() + File.separator;
                }
                aVar2.f6011c = bVar.c();
                aVar2.f6012d = d2;
                aVar2.f6014f = String.valueOf(c.a.p0.a.e0.a.a());
                aVar2.f6015g = c.a.p0.a.h0.u.a.c(c.a.p0.a.d2.e.L(), d2);
                aVar2.f6017i = h2;
                if (!f5925b && !f.U().N()) {
                    z2 = false;
                    aVar2.f6016h = z2;
                    aVar2.f6018j = bVar.L();
                    aVar2.l = c.a.p0.a.h0.u.e.b();
                    f0 = bVar2.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        aVar2.m = f0.userActionApis;
                    }
                    H = c.a.p0.a.x1.a.a.H();
                    if (H) {
                        aVar2.f6019k = c.a.p0.a.e0.f.b.b();
                    }
                    P = bVar2.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            aVar2.f6013e = string;
                        }
                    }
                    if (f5925b) {
                        aVar2.toString();
                    }
                    h.o().F(new UbcFlowEvent("master_dispatch_start"));
                    c.a.p0.a.m2.a.d().i("master_dispatch_start");
                    aVar.E(aVar2);
                    g.U().U0(c.a.p0.a.h0.u.a.b(aVar2));
                    c.a.p0.a.c1.a.m0().a();
                    g.U().h1(aVar2.f6018j);
                    F = c.a.p0.a.x1.a.a.F(bVar2.g0());
                    boolean p0 = bVar2.p0();
                    if (!F) {
                        c.a.p0.a.e0.f.e.d.d();
                        c.a.p0.a.e0.f.e.d.g().h("appready");
                    } else if (p0) {
                        c.a.p0.a.e0.f.d.d.e().f("appready");
                    }
                    c.a.p0.a.d2.n.g e2 = f.U().e(j.b(o0.f(d2)));
                    dVar = new c.a.p0.a.h0.u.d();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        dVar.a = gVar.a;
                    } else {
                        dVar.a = d.e.i(bVar2.H(), bVar2.v1()).getPath() + File.separator;
                    }
                    dVar.f6021b = d2;
                    dVar.f6023d = e2.f4660g;
                    dVar.f6022c = h2;
                    dVar.f6030k = aVar2.f6015g;
                    dVar.f6024e = String.valueOf(bVar2.m0());
                    dVar.f6026g = z2;
                    dVar.f6028i = bVar.L();
                    dVar.m = true;
                    if (H) {
                        dVar.f6029j = c.a.p0.a.e0.f.b.d();
                    }
                    if (!F) {
                        c.a.p0.a.e0.f.e.d.g().h("pageready");
                    } else if (p0) {
                        c.a.p0.a.e0.f.d.d.e().f("pageready");
                    }
                    if (f5925b) {
                        dVar.toString();
                    }
                    h.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    c.a.p0.a.m2.a.d().i("slave_dispatch_start");
                    bVar.M(dVar);
                    d0.d();
                    bVar.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d2);
                    bVar.T(d2);
                    g.U().V0(bVar.c(), c.a.p0.a.h0.u.d.a(dVar));
                    c.a.p0.a.n2.e.F(bVar.c(), dVar.f6021b);
                    if (f5925b) {
                        String str = "app path: " + aVar2.f6010b;
                        String str2 = "webviewId: " + bVar.c();
                        String str3 = "pageUrl: " + d2;
                        String str4 = "pagePath: " + dVar.f6021b;
                        String str5 = "onReachBottomDistance: " + dVar.f6023d;
                        String str6 = "sConsole:" + dVar.f6024e;
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                aVar2.f6016h = z2;
                aVar2.f6018j = bVar.L();
                aVar2.l = c.a.p0.a.h0.u.e.b();
                f0 = bVar2.f0();
                if (f0 != null) {
                    aVar2.m = f0.userActionApis;
                }
                H = c.a.p0.a.x1.a.a.H();
                if (H) {
                }
                P = bVar2.P();
                if (P != null) {
                }
                if (f5925b) {
                }
                h.o().F(new UbcFlowEvent("master_dispatch_start"));
                c.a.p0.a.m2.a.d().i("master_dispatch_start");
                aVar.E(aVar2);
                g.U().U0(c.a.p0.a.h0.u.a.b(aVar2));
                c.a.p0.a.c1.a.m0().a();
                g.U().h1(aVar2.f6018j);
                F = c.a.p0.a.x1.a.a.F(bVar2.g0());
                boolean p02 = bVar2.p0();
                if (!F) {
                }
                c.a.p0.a.d2.n.g e22 = f.U().e(j.b(o0.f(d2)));
                dVar = new c.a.p0.a.h0.u.d();
                if (gVar == null) {
                }
                dVar.a = d.e.i(bVar2.H(), bVar2.v1()).getPath() + File.separator;
                dVar.f6021b = d2;
                dVar.f6023d = e22.f4660g;
                dVar.f6022c = h2;
                dVar.f6030k = aVar2.f6015g;
                dVar.f6024e = String.valueOf(bVar2.m0());
                dVar.f6026g = z2;
                dVar.f6028i = bVar.L();
                dVar.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (f5925b) {
                }
                h.o().F(new UbcFlowEvent("slave_dispatch_start"));
                c.a.p0.a.m2.a.d().i("slave_dispatch_start");
                bVar.M(dVar);
                d0.d();
                bVar.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d2);
                bVar.T(d2);
                g.U().V0(bVar.c(), c.a.p0.a.h0.u.d.a(dVar));
                c.a.p0.a.n2.e.F(bVar.c(), dVar.f6021b);
                if (f5925b) {
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
        c.a.p0.a.h0.l.a W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (b2 = c.a.p0.a.u1.l.b.b()) == 0 || (W = g.U().W()) == null) {
            return;
        }
        if (b2 < 0) {
            W.q(b2);
        } else if (b2 == 1) {
            W.q(-4);
        } else {
            W.q(-2);
        }
    }

    public b() {
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
        this.a = false;
    }
}
