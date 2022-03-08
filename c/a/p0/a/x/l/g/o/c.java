package c.a.p0.a.x.l.g.o;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.t1.e;
import c.a.p0.a.x.l.g.d;
import c.a.p0.a.x.l.g.h;
import c.a.p0.a.x.l.g.j;
import c.a.p0.a.x.l.g.o.a;
import c.a.p0.a.x.u.g;
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
public class c implements c.a.p0.a.x.l.g.b<c.a.p0.a.x.l.g.a>, j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile b a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f8602b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<c.a.p0.a.e0.d.b> f8603c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d<c.a.p0.a.x.l.g.a>> f8604d;

    /* renamed from: e  reason: collision with root package name */
    public b f8605e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f8606f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f8607g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f8608h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8609i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f8610j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(144287601, "Lc/a/p0/a/x/l/g/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(144287601, "Lc/a/p0/a/x/l/g/o/c;");
                return;
            }
        }
        k = c.a.p0.a.a.a;
        l = c.a.p0.a.x.o.e.a.l() == 1;
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
        this.f8603c = new LinkedList<>();
        this.f8604d = new LinkedList();
        this.f8610j = new Object();
        this.f8606f = false;
        this.f8607g = false;
        this.f8609i = false;
        this.f8608h = false;
    }

    @Override // c.a.p0.a.x.l.g.b
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (k) {
                String str2 = "get a prefetch event - " + cVar;
            }
            if (!this.f8606f) {
                boolean z = k;
                return;
            }
            c.a.p0.a.u.d.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo != null) {
                String str3 = pMSAppInfo.appId;
                if (!TextUtils.isEmpty(str3)) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    if (this.f8607g) {
                        e a0 = e.a0();
                        if (a0 != null && TextUtils.equals(str3, a0.getAppId())) {
                            c.a.p0.a.u.d.i(PrefetchEvent.MODULE, "prefetch after app start");
                            this.f8605e.r(str, cVar, pMSAppInfo);
                            return;
                        }
                        boolean z2 = k;
                        return;
                    }
                    synchronized (this.f8610j) {
                        if (this.f8607g) {
                            return;
                        }
                        if (this.f8602b == null || this.f8602b.w(pMSAppInfo, cVar)) {
                            m(this.f8602b);
                            this.f8602b = l(false, this.f8609i);
                        }
                        this.f8602b.r(str, cVar, pMSAppInfo);
                        return;
                    }
                }
            }
            boolean z3 = k;
        }
    }

    @Override // c.a.p0.a.x.l.g.c
    public void c(d<c.a.p0.a.x.l.g.a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.f8610j) {
            if (this.f8607g) {
                boolean z = k;
                dVar.a(this.f8608h, this.f8605e);
                return;
            }
            if (!this.f8604d.contains(dVar)) {
                this.f8604d.add(dVar);
            }
        }
    }

    @Override // c.a.p0.a.x.l.g.b
    public void d(c.a.p0.a.e0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || this.f8607g) {
            return;
        }
        synchronized (this.f8610j) {
            this.f8603c.add(bVar);
        }
    }

    @Override // c.a.p0.a.x.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f8607g : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f8606f : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f8609i : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (this.a == null) {
                synchronized (this.f8610j) {
                    if (this.a == null) {
                        this.f8609i = z;
                        this.a = l(true, z);
                        this.a.c(this);
                        this.a.c(jVar);
                        return;
                    }
                }
            }
            boolean z2 = k;
            if (this.a != null) {
                this.a.c(jVar);
            }
        }
    }

    public final void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            b bVar2 = bVar == this.f8602b ? this.a : this.f8602b;
            this.a = bVar;
            m(bVar2);
            this.f8602b = null;
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
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.f8603c.isEmpty() && this.f8607g) {
            synchronized (this.f8610j) {
                Iterator<c.a.p0.a.e0.d.b> it = this.f8603c.iterator();
                while (it.hasNext()) {
                    c.a.p0.a.e0.d.b next = it.next();
                    if (k) {
                        String str = "dispatchPendingEvents event: " + next.a;
                    }
                    g.U().U0(next);
                }
                this.f8603c.clear();
            }
        }
    }

    public final void o(boolean z, b bVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), bVar, pMSAppInfo}) == null) {
            this.f8608h = z;
            this.f8605e = bVar;
            bVar.p(pMSAppInfo);
            this.f8607g = true;
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

    @Override // c.a.p0.a.x.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f8606f = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.x.l.g.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: p */
    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.f8607g) {
                if (k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f8605e;
        }
        return (b) invokeV.objValue;
    }

    public final void q(boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048593, this, z, bVar) == null) || this.f8604d.size() <= 0) {
            return;
        }
        synchronized (this.f8610j) {
            for (d<c.a.p0.a.x.l.g.a> dVar : this.f8604d) {
                dVar.a(z, bVar);
            }
            this.f8604d.clear();
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
    @Override // c.a.p0.a.x.l.g.c
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
            if ((pMSAppInfo == null || !this.f8606f) && k) {
                Log.getStackTraceString(new Exception("currentAppInfo can not be null， and should call startApp after preload finished"));
            }
            if (k) {
                String str = "real start a swan app - " + pMSAppInfo;
                String str2 = "is default master ready - " + this.f8606f;
            }
            if (this.f8607g) {
                return this.f8605e;
            }
            synchronized (this.f8610j) {
                if (!this.f8607g) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    boolean z = true;
                    if (this.f8602b != null && this.f8602b.n() && pMSAppInfo != null) {
                        if (this.f8602b.w(pMSAppInfo, null)) {
                            bVar = this.a;
                            z = false;
                            o(z, bVar, pMSAppInfo);
                        } else {
                            if (this.f8602b.j()) {
                                bVar = this.f8602b;
                            } else {
                                a.C0556a c0556a = new a.C0556a(pMSAppInfo.appKey, pMSAppInfo.versionCode);
                                boolean f2 = a.c().f(c0556a);
                                boolean g2 = a.c().g(c0556a);
                                boolean e2 = a.c().e();
                                if (k) {
                                    r0 = "app - " + c0556a + ", is loaded - " + f2;
                                    r0 = "app - " + c0556a + ", is loading - " + g2;
                                    r0 = "has loading app now - " + e2;
                                }
                                if (e2 && !g2) {
                                    if (f2 && l) {
                                        bVar = z ? this.f8602b : this.a;
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
                    bVar = this.a;
                    z = false;
                    o(z, bVar, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str3 = "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                String str4 = "final master id - " + this.f8605e.i().c();
            }
            return this.f8605e;
        }
        return (b) invokeL.objValue;
    }

    @Override // c.a.p0.a.x.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = k;
            this.f8606f = false;
            this.f8607g = false;
            this.f8609i = false;
            this.f8608h = false;
            m(this.a);
            m(this.f8602b);
            this.a = null;
            this.f8602b = null;
            this.f8605e = null;
            synchronized (this.f8610j) {
                this.f8603c.clear();
                this.f8604d.clear();
            }
            c.a.p0.a.x.l.g.e.c();
            h.b().d();
            a.c().a();
        }
    }
}
