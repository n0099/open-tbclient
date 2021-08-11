package c.a.n0.a.h0.l.g.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a2.e;
import c.a.n0.a.h0.l.g.d;
import c.a.n0.a.h0.l.g.h;
import c.a.n0.a.h0.l.g.j;
import c.a.n0.a.h0.l.g.o.a;
import c.a.n0.a.h0.u.g;
import c.a.n0.a.k;
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
public class c implements c.a.n0.a.h0.l.g.b<c.a.n0.a.h0.l.g.a>, j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile b f5886a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f5887b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<c.a.n0.a.o0.d.a> f5888c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d<c.a.n0.a.h0.l.g.a>> f5889d;

    /* renamed from: e  reason: collision with root package name */
    public b f5890e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f5891f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f5892g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f5893h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5894i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f5895j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(597160917, "Lc/a/n0/a/h0/l/g/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(597160917, "Lc/a/n0/a/h0/l/g/o/c;");
                return;
            }
        }
        k = k.f6803a;
        l = c.a.n0.a.h0.o.e.a.j() == 1;
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
        this.f5888c = new LinkedList<>();
        this.f5889d = new LinkedList();
        this.f5895j = new Object();
        this.f5891f = false;
        this.f5892g = false;
        this.f5894i = false;
        this.f5893h = false;
    }

    @Override // c.a.n0.a.h0.l.g.c
    public void b(d<c.a.n0.a.h0.l.g.a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.f5895j) {
            if (this.f5892g) {
                boolean z = k;
                dVar.a(this.f5893h, this.f5890e);
                return;
            }
            if (!this.f5889d.contains(dVar)) {
                this.f5889d.add(dVar);
            }
        }
    }

    @Override // c.a.n0.a.h0.l.g.b
    public void c(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, pMSAppInfo) == null) {
            if (k) {
                String str = "get a prefetch event - " + cVar;
            }
            if (!this.f5891f) {
                boolean z = k;
                return;
            }
            c.a.n0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo != null) {
                String str2 = pMSAppInfo.appId;
                if (!TextUtils.isEmpty(str2)) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    if (this.f5892g) {
                        e Q = e.Q();
                        if (Q != null && TextUtils.equals(str2, Q.getAppId())) {
                            c.a.n0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch after app start");
                            this.f5890e.r(cVar, pMSAppInfo);
                            return;
                        }
                        boolean z2 = k;
                        return;
                    }
                    synchronized (this.f5895j) {
                        if (this.f5892g) {
                            return;
                        }
                        if (this.f5887b == null || this.f5887b.w(pMSAppInfo, cVar)) {
                            m(this.f5887b);
                            this.f5887b = l(false, this.f5894i);
                        }
                        this.f5887b.r(cVar, pMSAppInfo);
                        return;
                    }
                }
            }
            boolean z3 = k;
        }
    }

    @Override // c.a.n0.a.h0.l.g.b
    public void d(c.a.n0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null || this.f5892g) {
            return;
        }
        synchronized (this.f5895j) {
            this.f5888c.add(aVar);
        }
    }

    @Override // c.a.n0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5886a != null : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5892g : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f5891f : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f5894i : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (this.f5886a == null) {
                synchronized (this.f5895j) {
                    if (this.f5886a == null) {
                        this.f5894i = z;
                        this.f5886a = l(true, z);
                        this.f5886a.c(this);
                        this.f5886a.c(jVar);
                        return;
                    }
                }
            }
            boolean z2 = k;
            if (this.f5886a != null) {
                this.f5886a.c(jVar);
            }
        }
    }

    public final void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            b bVar2 = bVar == this.f5887b ? this.f5886a : this.f5887b;
            this.f5886a = bVar;
            m(bVar2);
            this.f5887b = null;
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
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.f5888c.isEmpty() && this.f5892g) {
            synchronized (this.f5895j) {
                Iterator<c.a.n0.a.o0.d.a> it = this.f5888c.iterator();
                while (it.hasNext()) {
                    c.a.n0.a.o0.d.a next = it.next();
                    if (k) {
                        String str = "dispatchPendingEvents event: " + next.f7521a;
                    }
                    g.N().H0(next);
                }
                this.f5888c.clear();
            }
        }
    }

    public final void o(boolean z, b bVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), bVar, pMSAppInfo}) == null) {
            this.f5893h = z;
            this.f5890e = bVar;
            bVar.p(pMSAppInfo);
            this.f5892g = true;
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

    @Override // c.a.n0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f5891f = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.h0.l.g.c
    /* renamed from: p */
    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.f5892g) {
                if (k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f5890e;
        }
        return (b) invokeV.objValue;
    }

    public final void q(boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048593, this, z, bVar) == null) || this.f5889d.size() <= 0) {
            return;
        }
        synchronized (this.f5895j) {
            for (d<c.a.n0.a.h0.l.g.a> dVar : this.f5889d) {
                dVar.a(z, bVar);
            }
            this.f5889d.clear();
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
    @Override // c.a.n0.a.h0.l.g.c
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
            if ((pMSAppInfo == null || !this.f5891f) && k) {
                Log.getStackTraceString(new Exception("currentAppInfo can not be null， and should call startApp after preload finished"));
            }
            if (k) {
                String str = "real start a swan app - " + pMSAppInfo;
                String str2 = "is default master ready - " + this.f5891f;
            }
            if (this.f5892g) {
                return this.f5890e;
            }
            synchronized (this.f5895j) {
                if (!this.f5892g) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    boolean z = true;
                    if (this.f5887b != null && this.f5887b.n() && pMSAppInfo != null) {
                        if (this.f5887b.w(pMSAppInfo, null)) {
                            bVar = this.f5886a;
                            z = false;
                            o(z, bVar, pMSAppInfo);
                        } else {
                            if (this.f5887b.j()) {
                                bVar = this.f5887b;
                            } else {
                                a.C0217a c0217a = new a.C0217a(pMSAppInfo.appKey, pMSAppInfo.versionCode);
                                boolean f2 = a.c().f(c0217a);
                                boolean g2 = a.c().g(c0217a);
                                boolean e2 = a.c().e();
                                if (k) {
                                    r0 = "app - " + c0217a + ", is loaded - " + f2;
                                    r0 = "app - " + c0217a + ", is loading - " + g2;
                                    r0 = "has loading app now - " + e2;
                                }
                                if (e2 && !g2) {
                                    if (f2 && l) {
                                        bVar = z ? this.f5887b : this.f5886a;
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
                    bVar = this.f5886a;
                    z = false;
                    o(z, bVar, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str3 = "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                String str4 = "final master id - " + this.f5890e.i().c();
            }
            return this.f5890e;
        }
        return (b) invokeL.objValue;
    }

    @Override // c.a.n0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = k;
            this.f5891f = false;
            this.f5892g = false;
            this.f5894i = false;
            this.f5893h = false;
            m(this.f5886a);
            m(this.f5887b);
            this.f5886a = null;
            this.f5887b = null;
            this.f5890e = null;
            synchronized (this.f5895j) {
                this.f5888c.clear();
                this.f5889d.clear();
            }
            c.a.n0.a.h0.l.g.e.c();
            h.b().d();
            a.c().a();
        }
    }
}
