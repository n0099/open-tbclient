package c.a.o0.a.h0.p;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.a.a1.e;
import c.a.o0.a.c2.f.p0.c;
import c.a.o0.a.c2.f.p0.j;
import c.a.o0.a.g1.f;
import c.a.o0.a.h0.u.g;
import c.a.o0.a.k;
import c.a.o0.a.r1.h;
import c.a.o0.a.u.e.j.d;
import c.a.o0.a.v2.d0;
import c.a.o0.a.v2.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
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
    public static final boolean f6343b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6344a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.o0.a.h0.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0245b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f6345a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1566959179, "Lc/a/o0/a/h0/p/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1566959179, "Lc/a/o0/a/h0/p/b$b;");
                    return;
                }
            }
            f6345a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(958054089, "Lc/a/o0/a/h0/p/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(958054089, "Lc/a/o0/a/h0/p/b;");
                return;
            }
        }
        f6343b = k.f7049a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0245b.f6345a : (b) invokeV.objValue;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            boolean z = f6343b;
            d.g(swanAppConfigData);
            c.a.o0.a.h0.q.b.g().p(c.a.o0.a.a2.d.g().getAppId(), false);
            c.a.o0.a.l2.b.l().t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00af A[Catch: all -> 0x0270, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:31:0x00b5, B:33:0x00bb, B:35:0x00c7, B:36:0x00c9, B:38:0x00cd, B:39:0x00d0, B:41:0x010e, B:44:0x0126, B:46:0x013d, B:48:0x0145, B:50:0x016d, B:52:0x0190, B:54:0x0198, B:57:0x01ad, B:59:0x01b1, B:60:0x01b4, B:62:0x01f9, B:63:0x0265, B:56:0x01a4, B:49:0x014a, B:43:0x011d, B:20:0x0048), top: B:72:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb A[Catch: all -> 0x0270, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:31:0x00b5, B:33:0x00bb, B:35:0x00c7, B:36:0x00c9, B:38:0x00cd, B:39:0x00d0, B:41:0x010e, B:44:0x0126, B:46:0x013d, B:48:0x0145, B:50:0x016d, B:52:0x0190, B:54:0x0198, B:57:0x01ad, B:59:0x01b1, B:60:0x01b4, B:62:0x01f9, B:63:0x0265, B:56:0x01a4, B:49:0x014a, B:43:0x011d, B:20:0x0048), top: B:72:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cd A[Catch: all -> 0x0270, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:31:0x00b5, B:33:0x00bb, B:35:0x00c7, B:36:0x00c9, B:38:0x00cd, B:39:0x00d0, B:41:0x010e, B:44:0x0126, B:46:0x013d, B:48:0x0145, B:50:0x016d, B:52:0x0190, B:54:0x0198, B:57:0x01ad, B:59:0x01b1, B:60:0x01b4, B:62:0x01f9, B:63:0x0265, B:56:0x01a4, B:49:0x014a, B:43:0x011d, B:20:0x0048), top: B:72:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010e A[Catch: all -> 0x0270, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:31:0x00b5, B:33:0x00bb, B:35:0x00c7, B:36:0x00c9, B:38:0x00cd, B:39:0x00d0, B:41:0x010e, B:44:0x0126, B:46:0x013d, B:48:0x0145, B:50:0x016d, B:52:0x0190, B:54:0x0198, B:57:0x01ad, B:59:0x01b1, B:60:0x01b4, B:62:0x01f9, B:63:0x0265, B:56:0x01a4, B:49:0x014a, B:43:0x011d, B:20:0x0048), top: B:72:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0190 A[Catch: all -> 0x0270, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:31:0x00b5, B:33:0x00bb, B:35:0x00c7, B:36:0x00c9, B:38:0x00cd, B:39:0x00d0, B:41:0x010e, B:44:0x0126, B:46:0x013d, B:48:0x0145, B:50:0x016d, B:52:0x0190, B:54:0x0198, B:57:0x01ad, B:59:0x01b1, B:60:0x01b4, B:62:0x01f9, B:63:0x0265, B:56:0x01a4, B:49:0x014a, B:43:0x011d, B:20:0x0048), top: B:72:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0198 A[Catch: all -> 0x0270, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:31:0x00b5, B:33:0x00bb, B:35:0x00c7, B:36:0x00c9, B:38:0x00cd, B:39:0x00d0, B:41:0x010e, B:44:0x0126, B:46:0x013d, B:48:0x0145, B:50:0x016d, B:52:0x0190, B:54:0x0198, B:57:0x01ad, B:59:0x01b1, B:60:0x01b4, B:62:0x01f9, B:63:0x0265, B:56:0x01a4, B:49:0x014a, B:43:0x011d, B:20:0x0048), top: B:72:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b1 A[Catch: all -> 0x0270, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:31:0x00b5, B:33:0x00bb, B:35:0x00c7, B:36:0x00c9, B:38:0x00cd, B:39:0x00d0, B:41:0x010e, B:44:0x0126, B:46:0x013d, B:48:0x0145, B:50:0x016d, B:52:0x0190, B:54:0x0198, B:57:0x01ad, B:59:0x01b1, B:60:0x01b4, B:62:0x01f9, B:63:0x0265, B:56:0x01a4, B:49:0x014a, B:43:0x011d, B:20:0x0048), top: B:72:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f9 A[Catch: all -> 0x0270, TryCatch #0 {, blocks: (B:6:0x000d, B:9:0x0015, B:14:0x001f, B:15:0x0022, B:17:0x003b, B:19:0x0043, B:21:0x006b, B:23:0x008d, B:28:0x009b, B:30:0x00af, B:31:0x00b5, B:33:0x00bb, B:35:0x00c7, B:36:0x00c9, B:38:0x00cd, B:39:0x00d0, B:41:0x010e, B:44:0x0126, B:46:0x013d, B:48:0x0145, B:50:0x016d, B:52:0x0190, B:54:0x0198, B:57:0x01ad, B:59:0x01b1, B:60:0x01b4, B:62:0x01f9, B:63:0x0265, B:56:0x01a4, B:49:0x014a, B:43:0x011d, B:20:0x0048), top: B:72:0x000d }] */
    /* JADX WARN: Type inference failed for: r3v15, types: [c.a.o0.a.p.e.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull c.a.o0.a.h0.l.a aVar, @NonNull c.a.o0.a.p.e.b bVar, @NonNull c.a.o0.a.f1.e.b bVar2, @NonNull SwanAppConfigData swanAppConfigData, @Nullable e.g gVar, boolean z) {
        boolean z2;
        boolean G;
        Bundle P;
        boolean E;
        c.a.o0.a.h0.u.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, bVar, bVar2, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                boolean z3 = f6343b;
                if (this.f6344a) {
                    if (z) {
                        c.a.o0.a.h0.u.b.c(14);
                    }
                    return;
                }
                if (z) {
                    c.a.o0.a.h0.u.b.c(1);
                }
                String c2 = c.c(f.V(), bVar2, swanAppConfigData);
                String g2 = swanAppConfigData.g(c2);
                c.a.o0.a.h0.u.a aVar2 = new c.a.o0.a.h0.u.a();
                aVar2.f6430a = swanAppConfigData.m;
                if (gVar != null && !TextUtils.isEmpty(gVar.f4470a)) {
                    aVar2.f6431b = gVar.f4470a;
                } else {
                    aVar2.f6431b = e.C0112e.i(bVar2.H(), bVar2.u1()).getPath() + File.separator;
                }
                aVar2.f6432c = bVar.c();
                aVar2.f6433d = c2;
                aVar2.f6435f = String.valueOf(c.a.o0.a.e0.a.a());
                aVar2.f6436g = c.a.o0.a.h0.u.a.c(c.a.o0.a.a2.e.i(), c2);
                aVar2.f6438i = g2;
                if (!f6343b && !f.V().O()) {
                    z2 = false;
                    aVar2.f6437h = z2;
                    aVar2.f6439j = bVar.K();
                    aVar2.l = c.a.o0.a.h0.u.e.b();
                    G = c.a.o0.a.u1.a.a.G();
                    if (G) {
                        aVar2.k = c.a.o0.a.e0.f.b.b();
                    }
                    P = bVar2.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            aVar2.f6434e = string;
                        }
                    }
                    if (f6343b) {
                        aVar2.toString();
                    }
                    h.o().C(new UbcFlowEvent("master_dispatch_start"));
                    c.a.o0.a.i2.a.d().i("master_dispatch_start");
                    aVar.E(aVar2);
                    g.N().H0(c.a.o0.a.h0.u.a.b(aVar2));
                    g.N().S0(aVar2.f6439j);
                    E = c.a.o0.a.u1.a.a.E(bVar2.g0());
                    boolean o0 = bVar2.o0();
                    if (!E) {
                        c.a.o0.a.e0.f.e.d.d();
                        c.a.o0.a.e0.f.e.d.g().h("appready");
                    } else if (o0) {
                        c.a.o0.a.e0.f.d.d.e().f("appready");
                    }
                    c.a.o0.a.a2.n.g e2 = f.V().e(j.b(o0.f(c2)));
                    dVar = new c.a.o0.a.h0.u.d();
                    if (gVar == null && !TextUtils.isEmpty(gVar.f4470a)) {
                        dVar.f6442a = gVar.f4470a;
                    } else {
                        dVar.f6442a = e.C0112e.i(bVar2.H(), bVar2.u1()).getPath() + File.separator;
                    }
                    dVar.f6443b = c2;
                    dVar.f6445d = e2.f4581g;
                    dVar.f6444c = g2;
                    dVar.k = aVar2.f6436g;
                    dVar.f6446e = String.valueOf(bVar2.l0());
                    dVar.f6448g = z2;
                    dVar.f6450i = bVar.K();
                    dVar.m = true;
                    if (G) {
                        dVar.f6451j = c.a.o0.a.e0.f.b.d();
                    }
                    if (!E) {
                        c.a.o0.a.e0.f.e.d.g().h("pageready");
                    } else if (o0) {
                        c.a.o0.a.e0.f.d.d.e().f("pageready");
                    }
                    if (f6343b) {
                        dVar.toString();
                    }
                    h.o().C(new UbcFlowEvent("slave_dispatch_start"));
                    c.a.o0.a.i2.a.d().i("slave_dispatch_start");
                    bVar.L(dVar);
                    d0.d();
                    bVar.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, c2);
                    bVar.R(c2);
                    g.N().I0(bVar.c(), c.a.o0.a.h0.u.d.a(dVar));
                    c.a.o0.a.j2.e.F(bVar.c(), dVar.f6443b);
                    if (f6343b) {
                        String str = "app path: " + aVar2.f6431b;
                        String str2 = "webviewId: " + bVar.c();
                        String str3 = "pageUrl: " + c2;
                        String str4 = "pagePath: " + dVar.f6443b;
                        String str5 = "onReachBottomDistance: " + dVar.f6445d;
                        String str6 = "sConsole:" + dVar.f6446e;
                    }
                    a(swanAppConfigData);
                    this.f6344a = true;
                    e();
                }
                z2 = true;
                aVar2.f6437h = z2;
                aVar2.f6439j = bVar.K();
                aVar2.l = c.a.o0.a.h0.u.e.b();
                G = c.a.o0.a.u1.a.a.G();
                if (G) {
                }
                P = bVar2.P();
                if (P != null) {
                }
                if (f6343b) {
                }
                h.o().C(new UbcFlowEvent("master_dispatch_start"));
                c.a.o0.a.i2.a.d().i("master_dispatch_start");
                aVar.E(aVar2);
                g.N().H0(c.a.o0.a.h0.u.a.b(aVar2));
                g.N().S0(aVar2.f6439j);
                E = c.a.o0.a.u1.a.a.E(bVar2.g0());
                boolean o02 = bVar2.o0();
                if (!E) {
                }
                c.a.o0.a.a2.n.g e22 = f.V().e(j.b(o0.f(c2)));
                dVar = new c.a.o0.a.h0.u.d();
                if (gVar == null) {
                }
                dVar.f6442a = e.C0112e.i(bVar2.H(), bVar2.u1()).getPath() + File.separator;
                dVar.f6443b = c2;
                dVar.f6445d = e22.f4581g;
                dVar.f6444c = g2;
                dVar.k = aVar2.f6436g;
                dVar.f6446e = String.valueOf(bVar2.l0());
                dVar.f6448g = z2;
                dVar.f6450i = bVar.K();
                dVar.m = true;
                if (G) {
                }
                if (!E) {
                }
                if (f6343b) {
                }
                h.o().C(new UbcFlowEvent("slave_dispatch_start"));
                c.a.o0.a.i2.a.d().i("slave_dispatch_start");
                bVar.L(dVar);
                d0.d();
                bVar.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, c2);
                bVar.R(c2);
                g.N().I0(bVar.c(), c.a.o0.a.h0.u.d.a(dVar));
                c.a.o0.a.j2.e.F(bVar.c(), dVar.f6443b);
                if (f6343b) {
                }
                a(swanAppConfigData);
                this.f6344a = true;
                e();
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f6344a = false;
            }
        }
    }

    public final void e() {
        int a2;
        c.a.o0.a.h0.l.a P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (a2 = c.a.o0.a.r1.l.b.a()) == 0 || (P = g.N().P()) == null) {
            return;
        }
        if (a2 < 0) {
            P.q(a2);
        } else if (a2 == 1) {
            P.q(-4);
        } else {
            P.q(-2);
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
        this.f6344a = false;
    }
}
