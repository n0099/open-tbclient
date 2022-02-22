package c.a.s0.a.h0.l.g.o;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.d2.e;
import c.a.s0.a.h0.l.g.d;
import c.a.s0.a.h0.l.g.h;
import c.a.s0.a.h0.l.g.j;
import c.a.s0.a.h0.l.g.o.a;
import c.a.s0.a.h0.u.g;
import c.a.s0.a.k;
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
public class c implements c.a.s0.a.h0.l.g.b<c.a.s0.a.h0.l.g.a>, j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile b a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f6869b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<c.a.s0.a.o0.d.b> f6870c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d<c.a.s0.a.h0.l.g.a>> f6871d;

    /* renamed from: e  reason: collision with root package name */
    public b f6872e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f6873f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f6874g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f6875h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6876i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f6877j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1955509968, "Lc/a/s0/a/h0/l/g/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1955509968, "Lc/a/s0/a/h0/l/g/o/c;");
                return;
            }
        }
        k = k.a;
        l = c.a.s0.a.h0.o.e.a.l() == 1;
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
        this.f6870c = new LinkedList<>();
        this.f6871d = new LinkedList();
        this.f6877j = new Object();
        this.f6873f = false;
        this.f6874g = false;
        this.f6876i = false;
        this.f6875h = false;
    }

    @Override // c.a.s0.a.h0.l.g.b
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (k) {
                String str2 = "get a prefetch event - " + cVar;
            }
            if (!this.f6873f) {
                boolean z = k;
                return;
            }
            c.a.s0.a.e0.d.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo != null) {
                String str3 = pMSAppInfo.appId;
                if (!TextUtils.isEmpty(str3)) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    if (this.f6874g) {
                        e a0 = e.a0();
                        if (a0 != null && TextUtils.equals(str3, a0.getAppId())) {
                            c.a.s0.a.e0.d.i(PrefetchEvent.MODULE, "prefetch after app start");
                            this.f6872e.r(str, cVar, pMSAppInfo);
                            return;
                        }
                        boolean z2 = k;
                        return;
                    }
                    synchronized (this.f6877j) {
                        if (this.f6874g) {
                            return;
                        }
                        if (this.f6869b == null || this.f6869b.w(pMSAppInfo, cVar)) {
                            m(this.f6869b);
                            this.f6869b = l(false, this.f6876i);
                        }
                        this.f6869b.r(str, cVar, pMSAppInfo);
                        return;
                    }
                }
            }
            boolean z3 = k;
        }
    }

    @Override // c.a.s0.a.h0.l.g.c
    public void c(d<c.a.s0.a.h0.l.g.a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.f6877j) {
            if (this.f6874g) {
                boolean z = k;
                dVar.a(this.f6875h, this.f6872e);
                return;
            }
            if (!this.f6871d.contains(dVar)) {
                this.f6871d.add(dVar);
            }
        }
    }

    @Override // c.a.s0.a.h0.l.g.b
    public void d(c.a.s0.a.o0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || this.f6874g) {
            return;
        }
        synchronized (this.f6877j) {
            this.f6870c.add(bVar);
        }
    }

    @Override // c.a.s0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // c.a.s0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6874g : invokeV.booleanValue;
    }

    @Override // c.a.s0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6873f : invokeV.booleanValue;
    }

    @Override // c.a.s0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f6876i : invokeV.booleanValue;
    }

    @Override // c.a.s0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (this.a == null) {
                synchronized (this.f6877j) {
                    if (this.a == null) {
                        this.f6876i = z;
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
            b bVar2 = bVar == this.f6869b ? this.a : this.f6869b;
            this.a = bVar;
            m(bVar2);
            this.f6869b = null;
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
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.f6870c.isEmpty() && this.f6874g) {
            synchronized (this.f6877j) {
                Iterator<c.a.s0.a.o0.d.b> it = this.f6870c.iterator();
                while (it.hasNext()) {
                    c.a.s0.a.o0.d.b next = it.next();
                    if (k) {
                        String str = "dispatchPendingEvents event: " + next.a;
                    }
                    g.U().U0(next);
                }
                this.f6870c.clear();
            }
        }
    }

    public final void o(boolean z, b bVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), bVar, pMSAppInfo}) == null) {
            this.f6875h = z;
            this.f6872e = bVar;
            bVar.p(pMSAppInfo);
            this.f6874g = true;
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

    @Override // c.a.s0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f6873f = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.a.h0.l.g.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: p */
    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.f6874g) {
                if (k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f6872e;
        }
        return (b) invokeV.objValue;
    }

    public final void q(boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048593, this, z, bVar) == null) || this.f6871d.size() <= 0) {
            return;
        }
        synchronized (this.f6877j) {
            for (d<c.a.s0.a.h0.l.g.a> dVar : this.f6871d) {
                dVar.a(z, bVar);
            }
            this.f6871d.clear();
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
    @Override // c.a.s0.a.h0.l.g.c
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
            if ((pMSAppInfo == null || !this.f6873f) && k) {
                Log.getStackTraceString(new Exception("currentAppInfo can not be null， and should call startApp after preload finished"));
            }
            if (k) {
                String str = "real start a swan app - " + pMSAppInfo;
                String str2 = "is default master ready - " + this.f6873f;
            }
            if (this.f6874g) {
                return this.f6872e;
            }
            synchronized (this.f6877j) {
                if (!this.f6874g) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    boolean z = true;
                    if (this.f6869b != null && this.f6869b.n() && pMSAppInfo != null) {
                        if (this.f6869b.w(pMSAppInfo, null)) {
                            bVar = this.a;
                            z = false;
                            o(z, bVar, pMSAppInfo);
                        } else {
                            if (this.f6869b.j()) {
                                bVar = this.f6869b;
                            } else {
                                a.C0402a c0402a = new a.C0402a(pMSAppInfo.appKey, pMSAppInfo.versionCode);
                                boolean f2 = a.c().f(c0402a);
                                boolean g2 = a.c().g(c0402a);
                                boolean e2 = a.c().e();
                                if (k) {
                                    r0 = "app - " + c0402a + ", is loaded - " + f2;
                                    r0 = "app - " + c0402a + ", is loading - " + g2;
                                    r0 = "has loading app now - " + e2;
                                }
                                if (e2 && !g2) {
                                    if (f2 && l) {
                                        bVar = z ? this.f6869b : this.a;
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
                String str4 = "final master id - " + this.f6872e.i().c();
            }
            return this.f6872e;
        }
        return (b) invokeL.objValue;
    }

    @Override // c.a.s0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = k;
            this.f6873f = false;
            this.f6874g = false;
            this.f6876i = false;
            this.f6875h = false;
            m(this.a);
            m(this.f6869b);
            this.a = null;
            this.f6869b = null;
            this.f6872e = null;
            synchronized (this.f6877j) {
                this.f6870c.clear();
                this.f6871d.clear();
            }
            c.a.s0.a.h0.l.g.e.c();
            h.b().d();
            a.c().a();
        }
    }
}
