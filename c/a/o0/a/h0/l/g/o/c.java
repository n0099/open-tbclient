package c.a.o0.a.h0.l.g.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.a2.e;
import c.a.o0.a.h0.l.g.d;
import c.a.o0.a.h0.l.g.h;
import c.a.o0.a.h0.l.g.j;
import c.a.o0.a.h0.l.g.o.a;
import c.a.o0.a.h0.u.g;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements c.a.o0.a.h0.l.g.b<c.a.o0.a.h0.l.g.a>, j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile b f6132a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f6133b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<c.a.o0.a.o0.d.a> f6134c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d<c.a.o0.a.h0.l.g.a>> f6135d;

    /* renamed from: e  reason: collision with root package name */
    public b f6136e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f6137f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f6138g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f6139h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6140i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f6141j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(86626740, "Lc/a/o0/a/h0/l/g/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(86626740, "Lc/a/o0/a/h0/l/g/o/c;");
                return;
            }
        }
        k = k.f7049a;
        l = c.a.o0.a.h0.o.e.a.j() == 1;
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
        this.f6134c = new LinkedList<>();
        this.f6135d = new LinkedList();
        this.f6141j = new Object();
        this.f6137f = false;
        this.f6138g = false;
        this.f6140i = false;
        this.f6139h = false;
    }

    @Override // c.a.o0.a.h0.l.g.c
    public void b(d<c.a.o0.a.h0.l.g.a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.f6141j) {
            if (this.f6138g) {
                boolean z = k;
                dVar.a(this.f6139h, this.f6136e);
                return;
            }
            if (!this.f6135d.contains(dVar)) {
                this.f6135d.add(dVar);
            }
        }
    }

    @Override // c.a.o0.a.h0.l.g.b
    public void c(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, pMSAppInfo) == null) {
            if (k) {
                String str = "get a prefetch event - " + cVar;
            }
            if (!this.f6137f) {
                boolean z = k;
                return;
            }
            c.a.o0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo != null) {
                String str2 = pMSAppInfo.appId;
                if (!TextUtils.isEmpty(str2)) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    if (this.f6138g) {
                        e Q = e.Q();
                        if (Q != null && TextUtils.equals(str2, Q.getAppId())) {
                            c.a.o0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch after app start");
                            this.f6136e.r(cVar, pMSAppInfo);
                            return;
                        }
                        boolean z2 = k;
                        return;
                    }
                    synchronized (this.f6141j) {
                        if (this.f6138g) {
                            return;
                        }
                        if (this.f6133b == null || this.f6133b.w(pMSAppInfo, cVar)) {
                            m(this.f6133b);
                            this.f6133b = l(false, this.f6140i);
                        }
                        this.f6133b.r(cVar, pMSAppInfo);
                        return;
                    }
                }
            }
            boolean z3 = k;
        }
    }

    @Override // c.a.o0.a.h0.l.g.b
    public void d(c.a.o0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null || this.f6138g) {
            return;
        }
        synchronized (this.f6141j) {
            this.f6134c.add(aVar);
        }
    }

    @Override // c.a.o0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6132a != null : invokeV.booleanValue;
    }

    @Override // c.a.o0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6138g : invokeV.booleanValue;
    }

    @Override // c.a.o0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6137f : invokeV.booleanValue;
    }

    @Override // c.a.o0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f6140i : invokeV.booleanValue;
    }

    @Override // c.a.o0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (this.f6132a == null) {
                synchronized (this.f6141j) {
                    if (this.f6132a == null) {
                        this.f6140i = z;
                        this.f6132a = l(true, z);
                        this.f6132a.c(this);
                        this.f6132a.c(jVar);
                        return;
                    }
                }
            }
            boolean z2 = k;
            if (this.f6132a != null) {
                this.f6132a.c(jVar);
            }
        }
    }

    public final void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            b bVar2 = bVar == this.f6133b ? this.f6132a : this.f6133b;
            this.f6132a = bVar;
            m(bVar2);
            this.f6133b = null;
        }
    }

    public b l(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            a.c().b(!z);
            return new b(z, z2);
        }
        return (b) invokeCommon.objValue;
    }

    public final void m(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) || bVar == null || bVar.i() == null) {
            return;
        }
        bVar.i().destroy();
        if (k) {
            String str = "master destroy, id - " + bVar.i().c() + ", isReady - " + bVar.n() + ", is Default - " + bVar.l();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.f6134c.isEmpty() && this.f6138g) {
            synchronized (this.f6141j) {
                Iterator<c.a.o0.a.o0.d.a> it = this.f6134c.iterator();
                while (it.hasNext()) {
                    c.a.o0.a.o0.d.a next = it.next();
                    if (k) {
                        String str = "dispatchPendingEvents event: " + next.f7767a;
                    }
                    g.N().H0(next);
                }
                this.f6134c.clear();
            }
        }
    }

    public final void o(boolean z, b bVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), bVar, pMSAppInfo}) == null) {
            this.f6139h = z;
            this.f6136e = bVar;
            bVar.p(pMSAppInfo);
            this.f6138g = true;
            n();
            k(bVar);
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            q(z, bVar);
            a.c().a();
        }
    }

    @Override // c.a.o0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f6137f = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.h0.l.g.c
    /* renamed from: p */
    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.f6138g) {
                if (k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f6136e;
        }
        return (b) invokeV.objValue;
    }

    public final void q(boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048593, this, z, bVar) == null) || this.f6135d.size() <= 0) {
            return;
        }
        synchronized (this.f6141j) {
            for (d<c.a.o0.a.h0.l.g.a> dVar : this.f6135d) {
                dVar.a(z, bVar);
            }
            this.f6135d.clear();
        }
        if (k) {
            String str = "is hit prefetch env - " + z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0104, code lost:
        if (r7 == false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0108 A[Catch: all -> 0x0150, TryCatch #0 {, blocks: (B:23:0x0053, B:25:0x0057, B:27:0x005b, B:28:0x0064, B:30:0x006a, B:34:0x0076, B:36:0x007f, B:58:0x0111, B:37:0x0083, B:39:0x008b, B:40:0x008f, B:42:0x00b4, B:47:0x00fb, B:54:0x0108, B:55:0x010b, B:56:0x010e, B:59:0x0114), top: B:72:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010b A[Catch: all -> 0x0150, TryCatch #0 {, blocks: (B:23:0x0053, B:25:0x0057, B:27:0x005b, B:28:0x0064, B:30:0x006a, B:34:0x0076, B:36:0x007f, B:58:0x0111, B:37:0x0083, B:39:0x008b, B:40:0x008f, B:42:0x00b4, B:47:0x00fb, B:54:0x0108, B:55:0x010b, B:56:0x010e, B:59:0x0114), top: B:72:0x0053 }] */
    @Override // c.a.o0.a.h0.l.g.c
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, pMSAppInfo)) == null) {
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            if ((pMSAppInfo == null || !this.f6137f) && k) {
                Log.getStackTraceString(new Exception("currentAppInfo can not be null， and should call startApp after preload finished"));
            }
            if (k) {
                String str = "real start a swan app - " + pMSAppInfo;
                String str2 = "is default master ready - " + this.f6137f;
            }
            if (this.f6138g) {
                return this.f6136e;
            }
            synchronized (this.f6141j) {
                if (!this.f6138g) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    boolean z = true;
                    if (this.f6133b != null && this.f6133b.n() && pMSAppInfo != null) {
                        if (this.f6133b.w(pMSAppInfo, null)) {
                            bVar = this.f6132a;
                            z = false;
                            o(z, bVar, pMSAppInfo);
                        } else {
                            if (this.f6133b.j()) {
                                bVar = this.f6133b;
                            } else {
                                a.C0225a c0225a = new a.C0225a(pMSAppInfo.appKey, pMSAppInfo.versionCode);
                                boolean f2 = a.c().f(c0225a);
                                boolean g2 = a.c().g(c0225a);
                                boolean e2 = a.c().e();
                                if (k) {
                                    r0 = "app - " + c0225a + ", is loaded - " + f2;
                                    r0 = "app - " + c0225a + ", is loading - " + g2;
                                    r0 = "has loading app now - " + e2;
                                }
                                if (e2 && !g2) {
                                    if (f2 && l) {
                                        bVar = z ? this.f6133b : this.f6132a;
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                }
                                if (z) {
                                }
                            }
                            o(z, bVar, pMSAppInfo);
                        }
                    }
                    bVar = this.f6132a;
                    z = false;
                    o(z, bVar, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str3 = "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                String str4 = "final master id - " + this.f6136e.i().c();
            }
            return this.f6136e;
        }
        return (b) invokeL.objValue;
    }

    @Override // c.a.o0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = k;
            this.f6137f = false;
            this.f6138g = false;
            this.f6140i = false;
            this.f6139h = false;
            m(this.f6132a);
            m(this.f6133b);
            this.f6132a = null;
            this.f6133b = null;
            this.f6136e = null;
            synchronized (this.f6141j) {
                this.f6134c.clear();
                this.f6135d.clear();
            }
            c.a.o0.a.h0.l.g.e.c();
            h.b().d();
            a.c().a();
        }
    }
}
