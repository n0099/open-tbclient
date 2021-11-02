package b.a.p0.a.h0.l.g.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.e;
import b.a.p0.a.h0.l.g.d;
import b.a.p0.a.h0.l.g.h;
import b.a.p0.a.h0.l.g.j;
import b.a.p0.a.h0.l.g.o.a;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
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
public class c implements b.a.p0.a.h0.l.g.b<b.a.p0.a.h0.l.g.a>, j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile b f5507a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f5508b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<b.a.p0.a.o0.d.a> f5509c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d<b.a.p0.a.h0.l.g.a>> f5510d;

    /* renamed from: e  reason: collision with root package name */
    public b f5511e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f5512f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f5513g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f5514h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5515i;
    public final Object j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-15083212, "Lb/a/p0/a/h0/l/g/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-15083212, "Lb/a/p0/a/h0/l/g/o/c;");
                return;
            }
        }
        k = k.f6397a;
        l = b.a.p0.a.h0.o.e.a.j() == 1;
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
        this.f5509c = new LinkedList<>();
        this.f5510d = new LinkedList();
        this.j = new Object();
        this.f5512f = false;
        this.f5513g = false;
        this.f5515i = false;
        this.f5514h = false;
    }

    @Override // b.a.p0.a.h0.l.g.c
    public void b(d<b.a.p0.a.h0.l.g.a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.j) {
            if (this.f5513g) {
                boolean z = k;
                dVar.a(this.f5514h, this.f5511e);
                return;
            }
            if (!this.f5510d.contains(dVar)) {
                this.f5510d.add(dVar);
            }
        }
    }

    @Override // b.a.p0.a.h0.l.g.b
    public void c(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, pMSAppInfo) == null) {
            if (k) {
                String str = "get a prefetch event - " + cVar;
            }
            if (!this.f5512f) {
                boolean z = k;
                return;
            }
            b.a.p0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo != null) {
                String str2 = pMSAppInfo.appId;
                if (!TextUtils.isEmpty(str2)) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    if (this.f5513g) {
                        e P = e.P();
                        if (P != null && TextUtils.equals(str2, P.getAppId())) {
                            b.a.p0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch after app start");
                            this.f5511e.r(cVar, pMSAppInfo);
                            return;
                        }
                        boolean z2 = k;
                        return;
                    }
                    synchronized (this.j) {
                        if (this.f5513g) {
                            return;
                        }
                        if (this.f5508b == null || this.f5508b.w(pMSAppInfo, cVar)) {
                            m(this.f5508b);
                            this.f5508b = l(false, this.f5515i);
                        }
                        this.f5508b.r(cVar, pMSAppInfo);
                        return;
                    }
                }
            }
            boolean z3 = k;
        }
    }

    @Override // b.a.p0.a.h0.l.g.b
    public void d(b.a.p0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null || this.f5513g) {
            return;
        }
        synchronized (this.j) {
            this.f5509c.add(aVar);
        }
    }

    @Override // b.a.p0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5507a != null : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5513g : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f5512f : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f5515i : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (this.f5507a == null) {
                synchronized (this.j) {
                    if (this.f5507a == null) {
                        this.f5515i = z;
                        this.f5507a = l(true, z);
                        this.f5507a.c(this);
                        this.f5507a.c(jVar);
                        return;
                    }
                }
            }
            boolean z2 = k;
            if (this.f5507a != null) {
                this.f5507a.c(jVar);
            }
        }
    }

    public final void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            b bVar2 = bVar == this.f5508b ? this.f5507a : this.f5508b;
            this.f5507a = bVar;
            m(bVar2);
            this.f5508b = null;
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
            String str = "master destroy, id - " + bVar.i().b() + ", isReady - " + bVar.n() + ", is Default - " + bVar.l();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.f5509c.isEmpty() && this.f5513g) {
            synchronized (this.j) {
                Iterator<b.a.p0.a.o0.d.a> it = this.f5509c.iterator();
                while (it.hasNext()) {
                    b.a.p0.a.o0.d.a next = it.next();
                    if (k) {
                        String str = "dispatchPendingEvents event: " + next.f7099a;
                    }
                    g.M().G0(next);
                }
                this.f5509c.clear();
            }
        }
    }

    public final void o(boolean z, b bVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), bVar, pMSAppInfo}) == null) {
            this.f5514h = z;
            this.f5511e = bVar;
            bVar.p(pMSAppInfo);
            this.f5513g = true;
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

    @Override // b.a.p0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f5512f = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.h0.l.g.c
    /* renamed from: p */
    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.f5513g) {
                if (k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f5511e;
        }
        return (b) invokeV.objValue;
    }

    public final void q(boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048593, this, z, bVar) == null) || this.f5510d.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (d<b.a.p0.a.h0.l.g.a> dVar : this.f5510d) {
                dVar.a(z, bVar);
            }
            this.f5510d.clear();
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
    @Override // b.a.p0.a.h0.l.g.c
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
            if ((pMSAppInfo == null || !this.f5512f) && k) {
                Log.getStackTraceString(new Exception("currentAppInfo can not be null， and should call startApp after preload finished"));
            }
            if (k) {
                String str = "real start a swan app - " + pMSAppInfo;
                String str2 = "is default master ready - " + this.f5512f;
            }
            if (this.f5513g) {
                return this.f5511e;
            }
            synchronized (this.j) {
                if (!this.f5513g) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    boolean z = true;
                    if (this.f5508b != null && this.f5508b.n() && pMSAppInfo != null) {
                        if (this.f5508b.w(pMSAppInfo, null)) {
                            bVar = this.f5507a;
                            z = false;
                            o(z, bVar, pMSAppInfo);
                        } else {
                            if (this.f5508b.j()) {
                                bVar = this.f5508b;
                            } else {
                                a.C0222a c0222a = new a.C0222a(pMSAppInfo.appKey, pMSAppInfo.versionCode);
                                boolean f2 = a.c().f(c0222a);
                                boolean g2 = a.c().g(c0222a);
                                boolean e2 = a.c().e();
                                if (k) {
                                    r0 = "app - " + c0222a + ", is loaded - " + f2;
                                    r0 = "app - " + c0222a + ", is loading - " + g2;
                                    r0 = "has loading app now - " + e2;
                                }
                                if (e2 && !g2) {
                                    if (f2 && l) {
                                        bVar = z ? this.f5508b : this.f5507a;
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
                    bVar = this.f5507a;
                    z = false;
                    o(z, bVar, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str3 = "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                String str4 = "final master id - " + this.f5511e.i().b();
            }
            return this.f5511e;
        }
        return (b) invokeL.objValue;
    }

    @Override // b.a.p0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = k;
            this.f5512f = false;
            this.f5513g = false;
            this.f5515i = false;
            this.f5514h = false;
            m(this.f5507a);
            m(this.f5508b);
            this.f5507a = null;
            this.f5508b = null;
            this.f5511e = null;
            synchronized (this.j) {
                this.f5509c.clear();
                this.f5510d.clear();
            }
            b.a.p0.a.h0.l.g.e.c();
            h.b().d();
            a.c().a();
        }
    }
}
