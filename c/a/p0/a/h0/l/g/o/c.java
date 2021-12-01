package c.a.p0.a.h0.l.g.o;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.e;
import c.a.p0.a.h0.l.g.d;
import c.a.p0.a.h0.l.g.h;
import c.a.p0.a.h0.l.g.j;
import c.a.p0.a.h0.l.g.o.a;
import c.a.p0.a.h0.u.g;
import c.a.p0.a.k;
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
public class c implements c.a.p0.a.h0.l.g.b<c.a.p0.a.h0.l.g.a>, j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f5726k;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile b a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f5727b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<c.a.p0.a.o0.d.b> f5728c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d<c.a.p0.a.h0.l.g.a>> f5729d;

    /* renamed from: e  reason: collision with root package name */
    public b f5730e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f5731f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f5732g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f5733h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5734i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f5735j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-423907437, "Lc/a/p0/a/h0/l/g/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-423907437, "Lc/a/p0/a/h0/l/g/o/c;");
                return;
            }
        }
        f5726k = k.a;
        l = c.a.p0.a.h0.o.e.a.l() == 1;
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
        this.f5728c = new LinkedList<>();
        this.f5729d = new LinkedList();
        this.f5735j = new Object();
        this.f5731f = false;
        this.f5732g = false;
        this.f5734i = false;
        this.f5733h = false;
    }

    @Override // c.a.p0.a.h0.l.g.b
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (f5726k) {
                String str2 = "get a prefetch event - " + cVar;
            }
            if (!this.f5731f) {
                boolean z = f5726k;
                return;
            }
            c.a.p0.a.e0.d.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo != null) {
                String str3 = pMSAppInfo.appId;
                if (!TextUtils.isEmpty(str3)) {
                    if (f5726k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    if (this.f5732g) {
                        e a0 = e.a0();
                        if (a0 != null && TextUtils.equals(str3, a0.getAppId())) {
                            c.a.p0.a.e0.d.i(PrefetchEvent.MODULE, "prefetch after app start");
                            this.f5730e.r(str, cVar, pMSAppInfo);
                            return;
                        }
                        boolean z2 = f5726k;
                        return;
                    }
                    synchronized (this.f5735j) {
                        if (this.f5732g) {
                            return;
                        }
                        if (this.f5727b == null || this.f5727b.w(pMSAppInfo, cVar)) {
                            m(this.f5727b);
                            this.f5727b = l(false, this.f5734i);
                        }
                        this.f5727b.r(str, cVar, pMSAppInfo);
                        return;
                    }
                }
            }
            boolean z3 = f5726k;
        }
    }

    @Override // c.a.p0.a.h0.l.g.c
    public void c(d<c.a.p0.a.h0.l.g.a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.f5735j) {
            if (this.f5732g) {
                boolean z = f5726k;
                dVar.a(this.f5733h, this.f5730e);
                return;
            }
            if (!this.f5729d.contains(dVar)) {
                this.f5729d.add(dVar);
            }
        }
    }

    @Override // c.a.p0.a.h0.l.g.b
    public void d(c.a.p0.a.o0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || this.f5732g) {
            return;
        }
        synchronized (this.f5735j) {
            this.f5728c.add(bVar);
        }
    }

    @Override // c.a.p0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5732g : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f5731f : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f5734i : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (this.a == null) {
                synchronized (this.f5735j) {
                    if (this.a == null) {
                        this.f5734i = z;
                        this.a = l(true, z);
                        this.a.c(this);
                        this.a.c(jVar);
                        return;
                    }
                }
            }
            boolean z2 = f5726k;
            if (this.a != null) {
                this.a.c(jVar);
            }
        }
    }

    public final void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            b bVar2 = bVar == this.f5727b ? this.a : this.f5727b;
            this.a = bVar;
            m(bVar2);
            this.f5727b = null;
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
        if (f5726k) {
            String str = "master destroy, id - " + bVar.i().c() + ", isReady - " + bVar.n() + ", is Default - " + bVar.l();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.f5728c.isEmpty() && this.f5732g) {
            synchronized (this.f5735j) {
                Iterator<c.a.p0.a.o0.d.b> it = this.f5728c.iterator();
                while (it.hasNext()) {
                    c.a.p0.a.o0.d.b next = it.next();
                    if (f5726k) {
                        String str = "dispatchPendingEvents event: " + next.a;
                    }
                    g.U().U0(next);
                }
                this.f5728c.clear();
            }
        }
    }

    public final void o(boolean z, b bVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), bVar, pMSAppInfo}) == null) {
            this.f5733h = z;
            this.f5730e = bVar;
            bVar.p(pMSAppInfo);
            this.f5732g = true;
            n();
            k(bVar);
            long currentTimeMillis = f5726k ? System.currentTimeMillis() : 0L;
            if (f5726k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            q(z, bVar);
            a.c().a();
        }
    }

    @Override // c.a.p0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f5731f = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.h0.l.g.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: p */
    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.f5732g) {
                if (f5726k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f5730e;
        }
        return (b) invokeV.objValue;
    }

    public final void q(boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048593, this, z, bVar) == null) || this.f5729d.size() <= 0) {
            return;
        }
        synchronized (this.f5735j) {
            for (d<c.a.p0.a.h0.l.g.a> dVar : this.f5729d) {
                dVar.a(z, bVar);
            }
            this.f5729d.clear();
        }
        if (f5726k) {
            String str = "is hit prefetch env - " + z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0104, code lost:
        if (r7 == false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0108 A[Catch: all -> 0x0150, TryCatch #0 {, blocks: (B:23:0x0053, B:25:0x0057, B:27:0x005b, B:28:0x0064, B:30:0x006a, B:34:0x0076, B:36:0x007f, B:58:0x0111, B:37:0x0083, B:39:0x008b, B:40:0x008f, B:42:0x00b4, B:47:0x00fb, B:54:0x0108, B:55:0x010b, B:56:0x010e, B:59:0x0114), top: B:72:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010b A[Catch: all -> 0x0150, TryCatch #0 {, blocks: (B:23:0x0053, B:25:0x0057, B:27:0x005b, B:28:0x0064, B:30:0x006a, B:34:0x0076, B:36:0x007f, B:58:0x0111, B:37:0x0083, B:39:0x008b, B:40:0x008f, B:42:0x00b4, B:47:0x00fb, B:54:0x0108, B:55:0x010b, B:56:0x010e, B:59:0x0114), top: B:72:0x0053 }] */
    @Override // c.a.p0.a.h0.l.g.c
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, pMSAppInfo)) == null) {
            long currentTimeMillis = f5726k ? System.currentTimeMillis() : 0L;
            if ((pMSAppInfo == null || !this.f5731f) && f5726k) {
                Log.getStackTraceString(new Exception("currentAppInfo can not be null， and should call startApp after preload finished"));
            }
            if (f5726k) {
                String str = "real start a swan app - " + pMSAppInfo;
                String str2 = "is default master ready - " + this.f5731f;
            }
            if (this.f5732g) {
                return this.f5730e;
            }
            synchronized (this.f5735j) {
                if (!this.f5732g) {
                    if (f5726k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    boolean z = true;
                    if (this.f5727b != null && this.f5727b.n() && pMSAppInfo != null) {
                        if (this.f5727b.w(pMSAppInfo, null)) {
                            bVar = this.a;
                            z = false;
                            o(z, bVar, pMSAppInfo);
                        } else {
                            if (this.f5727b.j()) {
                                bVar = this.f5727b;
                            } else {
                                a.C0289a c0289a = new a.C0289a(pMSAppInfo.appKey, pMSAppInfo.versionCode);
                                boolean f2 = a.c().f(c0289a);
                                boolean g2 = a.c().g(c0289a);
                                boolean e2 = a.c().e();
                                if (f5726k) {
                                    r0 = "app - " + c0289a + ", is loaded - " + f2;
                                    r0 = "app - " + c0289a + ", is loading - " + g2;
                                    r0 = "has loading app now - " + e2;
                                }
                                if (e2 && !g2) {
                                    if (f2 && l) {
                                        bVar = z ? this.f5727b : this.a;
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
            if (f5726k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str3 = "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                String str4 = "final master id - " + this.f5730e.i().c();
            }
            return this.f5730e;
        }
        return (b) invokeL.objValue;
    }

    @Override // c.a.p0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = f5726k;
            this.f5731f = false;
            this.f5732g = false;
            this.f5734i = false;
            this.f5733h = false;
            m(this.a);
            m(this.f5727b);
            this.a = null;
            this.f5727b = null;
            this.f5730e = null;
            synchronized (this.f5735j) {
                this.f5728c.clear();
                this.f5729d.clear();
            }
            c.a.p0.a.h0.l.g.e.c();
            h.b().d();
            a.c().a();
        }
    }
}
