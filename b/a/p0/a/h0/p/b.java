package b.a.p0.a.h0.p;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.a1.e;
import b.a.p0.a.c2.f.p0.c;
import b.a.p0.a.c2.f.p0.j;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import b.a.p0.a.r1.h;
import b.a.p0.a.u.e.j.d;
import b.a.p0.a.v2.d0;
import b.a.p0.a.v2.o0;
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
    public static final boolean f5712b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f5713a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.p0.a.h0.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0242b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f5714a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2058472907, "Lb/a/p0/a/h0/p/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2058472907, "Lb/a/p0/a/h0/p/b$b;");
                    return;
                }
            }
            f5714a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597670985, "Lb/a/p0/a/h0/p/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597670985, "Lb/a/p0/a/h0/p/b;");
                return;
            }
        }
        f5712b = k.f6397a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0242b.f5714a : (b) invokeV.objValue;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            boolean z = f5712b;
            d.g(swanAppConfigData);
            b.a.p0.a.h0.q.b.g().p(b.a.p0.a.a2.d.g().getAppId(), false);
            b.a.p0.a.l2.b.l().t();
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
    /* JADX WARN: Type inference failed for: r3v15, types: [b.a.p0.a.p.e.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull b.a.p0.a.h0.l.a aVar, @NonNull b.a.p0.a.p.e.b bVar, @NonNull b.a.p0.a.f1.e.b bVar2, @NonNull SwanAppConfigData swanAppConfigData, @Nullable e.g gVar, boolean z) {
        boolean z2;
        boolean G;
        Bundle O;
        boolean E;
        b.a.p0.a.h0.u.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, bVar, bVar2, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                boolean z3 = f5712b;
                if (this.f5713a) {
                    if (z) {
                        b.a.p0.a.h0.u.b.c(14);
                    }
                    return;
                }
                if (z) {
                    b.a.p0.a.h0.u.b.c(1);
                }
                String c2 = c.c(f.T(), bVar2, swanAppConfigData);
                String g2 = swanAppConfigData.g(c2);
                b.a.p0.a.h0.u.a aVar2 = new b.a.p0.a.h0.u.a();
                aVar2.f5799a = swanAppConfigData.m;
                if (gVar != null && !TextUtils.isEmpty(gVar.f3903a)) {
                    aVar2.f5800b = gVar.f3903a;
                } else {
                    aVar2.f5800b = e.C0109e.i(bVar2.G(), bVar2.s1()).getPath() + File.separator;
                }
                aVar2.f5801c = bVar.b();
                aVar2.f5802d = c2;
                aVar2.f5804f = String.valueOf(b.a.p0.a.e0.a.a());
                aVar2.f5805g = b.a.p0.a.h0.u.a.c(b.a.p0.a.a2.e.i(), c2);
                aVar2.f5807i = g2;
                if (!f5712b && !f.T().M()) {
                    z2 = false;
                    aVar2.f5806h = z2;
                    aVar2.j = bVar.J();
                    aVar2.l = b.a.p0.a.h0.u.e.b();
                    G = b.a.p0.a.u1.a.a.G();
                    if (G) {
                        aVar2.k = b.a.p0.a.e0.f.b.b();
                    }
                    O = bVar2.O();
                    if (O != null) {
                        String string = O.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            aVar2.f5803e = string;
                        }
                    }
                    if (f5712b) {
                        aVar2.toString();
                    }
                    h.o().C(new UbcFlowEvent("master_dispatch_start"));
                    b.a.p0.a.i2.a.d().i("master_dispatch_start");
                    aVar.C(aVar2);
                    g.M().G0(b.a.p0.a.h0.u.a.b(aVar2));
                    g.M().R0(aVar2.j);
                    E = b.a.p0.a.u1.a.a.E(bVar2.f0());
                    boolean n0 = bVar2.n0();
                    if (!E) {
                        b.a.p0.a.e0.f.e.d.d();
                        b.a.p0.a.e0.f.e.d.g().h("appready");
                    } else if (n0) {
                        b.a.p0.a.e0.f.d.d.e().f("appready");
                    }
                    b.a.p0.a.a2.n.g e2 = f.T().e(j.b(o0.f(c2)));
                    dVar = new b.a.p0.a.h0.u.d();
                    if (gVar == null && !TextUtils.isEmpty(gVar.f3903a)) {
                        dVar.f5810a = gVar.f3903a;
                    } else {
                        dVar.f5810a = e.C0109e.i(bVar2.G(), bVar2.s1()).getPath() + File.separator;
                    }
                    dVar.f5811b = c2;
                    dVar.f5813d = e2.f4010g;
                    dVar.f5812c = g2;
                    dVar.k = aVar2.f5805g;
                    dVar.f5814e = String.valueOf(bVar2.k0());
                    dVar.f5816g = z2;
                    dVar.f5818i = bVar.J();
                    dVar.m = true;
                    if (G) {
                        dVar.j = b.a.p0.a.e0.f.b.d();
                    }
                    if (!E) {
                        b.a.p0.a.e0.f.e.d.g().h("pageready");
                    } else if (n0) {
                        b.a.p0.a.e0.f.d.d.e().f("pageready");
                    }
                    if (f5712b) {
                        dVar.toString();
                    }
                    h.o().C(new UbcFlowEvent("slave_dispatch_start"));
                    b.a.p0.a.i2.a.d().i("slave_dispatch_start");
                    bVar.K(dVar);
                    d0.d();
                    bVar.s().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, c2);
                    bVar.Q(c2);
                    g.M().H0(bVar.b(), b.a.p0.a.h0.u.d.a(dVar));
                    b.a.p0.a.j2.e.F(bVar.b(), dVar.f5811b);
                    if (f5712b) {
                        String str = "app path: " + aVar2.f5800b;
                        String str2 = "webviewId: " + bVar.b();
                        String str3 = "pageUrl: " + c2;
                        String str4 = "pagePath: " + dVar.f5811b;
                        String str5 = "onReachBottomDistance: " + dVar.f5813d;
                        String str6 = "sConsole:" + dVar.f5814e;
                    }
                    a(swanAppConfigData);
                    this.f5713a = true;
                    e();
                }
                z2 = true;
                aVar2.f5806h = z2;
                aVar2.j = bVar.J();
                aVar2.l = b.a.p0.a.h0.u.e.b();
                G = b.a.p0.a.u1.a.a.G();
                if (G) {
                }
                O = bVar2.O();
                if (O != null) {
                }
                if (f5712b) {
                }
                h.o().C(new UbcFlowEvent("master_dispatch_start"));
                b.a.p0.a.i2.a.d().i("master_dispatch_start");
                aVar.C(aVar2);
                g.M().G0(b.a.p0.a.h0.u.a.b(aVar2));
                g.M().R0(aVar2.j);
                E = b.a.p0.a.u1.a.a.E(bVar2.f0());
                boolean n02 = bVar2.n0();
                if (!E) {
                }
                b.a.p0.a.a2.n.g e22 = f.T().e(j.b(o0.f(c2)));
                dVar = new b.a.p0.a.h0.u.d();
                if (gVar == null) {
                }
                dVar.f5810a = e.C0109e.i(bVar2.G(), bVar2.s1()).getPath() + File.separator;
                dVar.f5811b = c2;
                dVar.f5813d = e22.f4010g;
                dVar.f5812c = g2;
                dVar.k = aVar2.f5805g;
                dVar.f5814e = String.valueOf(bVar2.k0());
                dVar.f5816g = z2;
                dVar.f5818i = bVar.J();
                dVar.m = true;
                if (G) {
                }
                if (!E) {
                }
                if (f5712b) {
                }
                h.o().C(new UbcFlowEvent("slave_dispatch_start"));
                b.a.p0.a.i2.a.d().i("slave_dispatch_start");
                bVar.K(dVar);
                d0.d();
                bVar.s().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, c2);
                bVar.Q(c2);
                g.M().H0(bVar.b(), b.a.p0.a.h0.u.d.a(dVar));
                b.a.p0.a.j2.e.F(bVar.b(), dVar.f5811b);
                if (f5712b) {
                }
                a(swanAppConfigData);
                this.f5713a = true;
                e();
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f5713a = false;
            }
        }
    }

    public final void e() {
        int a2;
        b.a.p0.a.h0.l.a O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (a2 = b.a.p0.a.r1.l.b.a()) == 0 || (O = g.M().O()) == null) {
            return;
        }
        if (a2 < 0) {
            O.p(a2);
        } else if (a2 == 1) {
            O.p(-4);
        } else {
            O.p(-2);
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
        this.f5713a = false;
    }
}
