package c.a.q0.a.h0.l.g.o;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.d2.e;
import c.a.q0.a.h0.l.g.d;
import c.a.q0.a.h0.l.g.h;
import c.a.q0.a.h0.l.g.j;
import c.a.q0.a.h0.l.g.o.a;
import c.a.q0.a.h0.u.g;
import c.a.q0.a.k;
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
public class c implements c.a.q0.a.h0.l.g.b<c.a.q0.a.h0.l.g.a>, j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f6035k;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile b a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f6036b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<c.a.q0.a.o0.d.b> f6037c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d<c.a.q0.a.h0.l.g.a>> f6038d;

    /* renamed from: e  reason: collision with root package name */
    public b f6039e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f6040f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f6041g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f6042h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6043i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f6044j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-934441614, "Lc/a/q0/a/h0/l/g/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-934441614, "Lc/a/q0/a/h0/l/g/o/c;");
                return;
            }
        }
        f6035k = k.a;
        l = c.a.q0.a.h0.o.e.a.l() == 1;
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
        this.f6037c = new LinkedList<>();
        this.f6038d = new LinkedList();
        this.f6044j = new Object();
        this.f6040f = false;
        this.f6041g = false;
        this.f6043i = false;
        this.f6042h = false;
    }

    @Override // c.a.q0.a.h0.l.g.b
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (f6035k) {
                String str2 = "get a prefetch event - " + cVar;
            }
            if (!this.f6040f) {
                boolean z = f6035k;
                return;
            }
            c.a.q0.a.e0.d.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo != null) {
                String str3 = pMSAppInfo.appId;
                if (!TextUtils.isEmpty(str3)) {
                    if (f6035k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    if (this.f6041g) {
                        e a0 = e.a0();
                        if (a0 != null && TextUtils.equals(str3, a0.getAppId())) {
                            c.a.q0.a.e0.d.i(PrefetchEvent.MODULE, "prefetch after app start");
                            this.f6039e.r(str, cVar, pMSAppInfo);
                            return;
                        }
                        boolean z2 = f6035k;
                        return;
                    }
                    synchronized (this.f6044j) {
                        if (this.f6041g) {
                            return;
                        }
                        if (this.f6036b == null || this.f6036b.w(pMSAppInfo, cVar)) {
                            m(this.f6036b);
                            this.f6036b = l(false, this.f6043i);
                        }
                        this.f6036b.r(str, cVar, pMSAppInfo);
                        return;
                    }
                }
            }
            boolean z3 = f6035k;
        }
    }

    @Override // c.a.q0.a.h0.l.g.c
    public void c(d<c.a.q0.a.h0.l.g.a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.f6044j) {
            if (this.f6041g) {
                boolean z = f6035k;
                dVar.a(this.f6042h, this.f6039e);
                return;
            }
            if (!this.f6038d.contains(dVar)) {
                this.f6038d.add(dVar);
            }
        }
    }

    @Override // c.a.q0.a.h0.l.g.b
    public void d(c.a.q0.a.o0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || this.f6041g) {
            return;
        }
        synchronized (this.f6044j) {
            this.f6037c.add(bVar);
        }
    }

    @Override // c.a.q0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // c.a.q0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6041g : invokeV.booleanValue;
    }

    @Override // c.a.q0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6040f : invokeV.booleanValue;
    }

    @Override // c.a.q0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f6043i : invokeV.booleanValue;
    }

    @Override // c.a.q0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (this.a == null) {
                synchronized (this.f6044j) {
                    if (this.a == null) {
                        this.f6043i = z;
                        this.a = l(true, z);
                        this.a.c(this);
                        this.a.c(jVar);
                        return;
                    }
                }
            }
            boolean z2 = f6035k;
            if (this.a != null) {
                this.a.c(jVar);
            }
        }
    }

    public final void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            b bVar2 = bVar == this.f6036b ? this.a : this.f6036b;
            this.a = bVar;
            m(bVar2);
            this.f6036b = null;
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
        if (f6035k) {
            String str = "master destroy, id - " + bVar.i().c() + ", isReady - " + bVar.n() + ", is Default - " + bVar.l();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.f6037c.isEmpty() && this.f6041g) {
            synchronized (this.f6044j) {
                Iterator<c.a.q0.a.o0.d.b> it = this.f6037c.iterator();
                while (it.hasNext()) {
                    c.a.q0.a.o0.d.b next = it.next();
                    if (f6035k) {
                        String str = "dispatchPendingEvents event: " + next.a;
                    }
                    g.U().U0(next);
                }
                this.f6037c.clear();
            }
        }
    }

    public final void o(boolean z, b bVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), bVar, pMSAppInfo}) == null) {
            this.f6042h = z;
            this.f6039e = bVar;
            bVar.p(pMSAppInfo);
            this.f6041g = true;
            n();
            k(bVar);
            long currentTimeMillis = f6035k ? System.currentTimeMillis() : 0L;
            if (f6035k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            q(z, bVar);
            a.c().a();
        }
    }

    @Override // c.a.q0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f6040f = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.a.h0.l.g.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: p */
    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.f6041g) {
                if (f6035k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f6039e;
        }
        return (b) invokeV.objValue;
    }

    public final void q(boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048593, this, z, bVar) == null) || this.f6038d.size() <= 0) {
            return;
        }
        synchronized (this.f6044j) {
            for (d<c.a.q0.a.h0.l.g.a> dVar : this.f6038d) {
                dVar.a(z, bVar);
            }
            this.f6038d.clear();
        }
        if (f6035k) {
            String str = "is hit prefetch env - " + z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0104, code lost:
        if (r7 == false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0108 A[Catch: all -> 0x0150, TryCatch #0 {, blocks: (B:23:0x0053, B:25:0x0057, B:27:0x005b, B:28:0x0064, B:30:0x006a, B:34:0x0076, B:36:0x007f, B:58:0x0111, B:37:0x0083, B:39:0x008b, B:40:0x008f, B:42:0x00b4, B:47:0x00fb, B:54:0x0108, B:55:0x010b, B:56:0x010e, B:59:0x0114), top: B:72:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010b A[Catch: all -> 0x0150, TryCatch #0 {, blocks: (B:23:0x0053, B:25:0x0057, B:27:0x005b, B:28:0x0064, B:30:0x006a, B:34:0x0076, B:36:0x007f, B:58:0x0111, B:37:0x0083, B:39:0x008b, B:40:0x008f, B:42:0x00b4, B:47:0x00fb, B:54:0x0108, B:55:0x010b, B:56:0x010e, B:59:0x0114), top: B:72:0x0053 }] */
    @Override // c.a.q0.a.h0.l.g.c
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, pMSAppInfo)) == null) {
            long currentTimeMillis = f6035k ? System.currentTimeMillis() : 0L;
            if ((pMSAppInfo == null || !this.f6040f) && f6035k) {
                Log.getStackTraceString(new Exception("currentAppInfo can not be null， and should call startApp after preload finished"));
            }
            if (f6035k) {
                String str = "real start a swan app - " + pMSAppInfo;
                String str2 = "is default master ready - " + this.f6040f;
            }
            if (this.f6041g) {
                return this.f6039e;
            }
            synchronized (this.f6044j) {
                if (!this.f6041g) {
                    if (f6035k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    boolean z = true;
                    if (this.f6036b != null && this.f6036b.n() && pMSAppInfo != null) {
                        if (this.f6036b.w(pMSAppInfo, null)) {
                            bVar = this.a;
                            z = false;
                            o(z, bVar, pMSAppInfo);
                        } else {
                            if (this.f6036b.j()) {
                                bVar = this.f6036b;
                            } else {
                                a.C0323a c0323a = new a.C0323a(pMSAppInfo.appKey, pMSAppInfo.versionCode);
                                boolean f2 = a.c().f(c0323a);
                                boolean g2 = a.c().g(c0323a);
                                boolean e2 = a.c().e();
                                if (f6035k) {
                                    r0 = "app - " + c0323a + ", is loaded - " + f2;
                                    r0 = "app - " + c0323a + ", is loading - " + g2;
                                    r0 = "has loading app now - " + e2;
                                }
                                if (e2 && !g2) {
                                    if (f2 && l) {
                                        bVar = z ? this.f6036b : this.a;
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
            if (f6035k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str3 = "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                String str4 = "final master id - " + this.f6039e.i().c();
            }
            return this.f6039e;
        }
        return (b) invokeL.objValue;
    }

    @Override // c.a.q0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = f6035k;
            this.f6040f = false;
            this.f6041g = false;
            this.f6043i = false;
            this.f6042h = false;
            m(this.a);
            m(this.f6036b);
            this.a = null;
            this.f6036b = null;
            this.f6039e = null;
            synchronized (this.f6044j) {
                this.f6037c.clear();
                this.f6038d.clear();
            }
            c.a.q0.a.h0.l.g.e.c();
            h.b().d();
            a.c().a();
        }
    }
}
