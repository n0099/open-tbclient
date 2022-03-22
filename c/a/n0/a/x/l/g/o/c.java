package c.a.n0.a.x.l.g.o;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.t1.e;
import c.a.n0.a.x.l.g.d;
import c.a.n0.a.x.l.g.h;
import c.a.n0.a.x.l.g.j;
import c.a.n0.a.x.l.g.o.a;
import c.a.n0.a.x.u.g;
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
public class c implements c.a.n0.a.x.l.g.b<c.a.n0.a.x.l.g.a>, j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile b a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f7235b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<c.a.n0.a.e0.d.b> f7236c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d<c.a.n0.a.x.l.g.a>> f7237d;

    /* renamed from: e  reason: collision with root package name */
    public b f7238e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f7239f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f7240g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f7241h;
    public boolean i;
    public final Object j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1424151279, "Lc/a/n0/a/x/l/g/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1424151279, "Lc/a/n0/a/x/l/g/o/c;");
                return;
            }
        }
        k = c.a.n0.a.a.a;
        l = c.a.n0.a.x.o.e.a.l() == 1;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7236c = new LinkedList<>();
        this.f7237d = new LinkedList();
        this.j = new Object();
        this.f7239f = false;
        this.f7240g = false;
        this.i = false;
        this.f7241h = false;
    }

    @Override // c.a.n0.a.x.l.g.b
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (k) {
                Log.i("SwanAppMasterProviderMulti", "get a prefetch event - " + cVar);
            }
            if (!this.f7239f) {
                if (k) {
                    Log.w("SwanAppMasterProviderMulti", "can not prefetch before default mater ready");
                    return;
                }
                return;
            }
            c.a.n0.a.u.d.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo != null) {
                String str2 = pMSAppInfo.appId;
                if (!TextUtils.isEmpty(str2)) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    if (this.f7240g) {
                        e a0 = e.a0();
                        if (a0 != null && TextUtils.equals(str2, a0.getAppId())) {
                            c.a.n0.a.u.d.i(PrefetchEvent.MODULE, "prefetch after app start");
                            this.f7238e.r(str, cVar, pMSAppInfo);
                            return;
                        } else if (k) {
                            Log.w("SwanAppMasterProviderMulti", "can not prefetch after swan app start, only same app allowed");
                            return;
                        } else {
                            return;
                        }
                    }
                    synchronized (this.j) {
                        if (this.f7240g) {
                            return;
                        }
                        if (this.f7235b == null || this.f7235b.w(pMSAppInfo, cVar)) {
                            m(this.f7235b);
                            this.f7235b = l(false, this.i);
                        }
                        this.f7235b.r(str, cVar, pMSAppInfo);
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "prefetch currentAppInfo is empty or appId is empty");
            }
        }
    }

    @Override // c.a.n0.a.x.l.g.c
    public void c(d<c.a.n0.a.x.l.g.a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.j) {
            if (this.f7240g) {
                if (k) {
                    Log.d("SwanAppMasterProviderMulti", "app already start , call back immediately");
                }
                dVar.a(this.f7241h, this.f7238e);
                return;
            }
            if (!this.f7237d.contains(dVar)) {
                this.f7237d.add(dVar);
            }
        }
    }

    @Override // c.a.n0.a.x.l.g.b
    public void d(c.a.n0.a.e0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || this.f7240g) {
            return;
        }
        synchronized (this.j) {
            this.f7236c.add(bVar);
        }
    }

    @Override // c.a.n0.a.x.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f7240g : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f7239f : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (this.a == null) {
                synchronized (this.j) {
                    if (this.a == null) {
                        this.i = z;
                        this.a = l(true, z);
                        this.a.c(this);
                        this.a.c(jVar);
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "call prepareDefault repeat");
            }
            if (this.a != null) {
                this.a.c(jVar);
            }
        }
    }

    public final void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            b bVar2 = bVar == this.f7235b ? this.a : this.f7235b;
            this.a = bVar;
            m(bVar2);
            this.f7235b = null;
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
            Log.i("SwanAppMasterProviderMulti", "master destroy, id - " + bVar.i().c() + ", isReady - " + bVar.n() + ", is Default - " + bVar.l());
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.f7236c.isEmpty() && this.f7240g) {
            synchronized (this.j) {
                Iterator<c.a.n0.a.e0.d.b> it = this.f7236c.iterator();
                while (it.hasNext()) {
                    c.a.n0.a.e0.d.b next = it.next();
                    if (k) {
                        Log.d("SwanAppMasterProviderMulti", "dispatchPendingEvents event: " + next.a);
                    }
                    g.U().U0(next);
                }
                this.f7236c.clear();
            }
        }
    }

    public final void o(boolean z, b bVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), bVar, pMSAppInfo}) == null) {
            this.f7241h = z;
            this.f7238e = bVar;
            bVar.p(pMSAppInfo);
            this.f7240g = true;
            n();
            k(bVar);
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("SwanAppMasterProviderMulti", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            q(z, bVar);
            a.c().a();
        }
    }

    @Override // c.a.n0.a.x.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f7239f = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.x.l.g.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: p */
    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.f7240g) {
                if (k) {
                    Log.w("SwanAppMasterProviderMulti", "master not final confirmed, has default - " + f());
                    Log.w("SwanAppMasterProviderMulti", Log.getStackTraceString(new RuntimeException("throw by debug")));
                    return null;
                }
                return null;
            }
            return this.f7238e;
        }
        return (b) invokeV.objValue;
    }

    public final void q(boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048593, this, z, bVar) == null) || this.f7237d.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (d<c.a.n0.a.x.l.g.a> dVar : this.f7237d) {
                dVar.a(z, bVar);
            }
            this.f7237d.clear();
        }
        if (k) {
            Log.d("SwanAppMasterProviderMulti", "is hit prefetch env - " + z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0128, code lost:
        if (r7 == false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c A[Catch: all -> 0x0180, TryCatch #0 {, blocks: (B:23:0x0065, B:25:0x0069, B:27:0x006d, B:28:0x0076, B:30:0x007c, B:34:0x0088, B:36:0x0091, B:58:0x0135, B:37:0x0095, B:39:0x009d, B:40:0x00a1, B:42:0x00c6, B:47:0x011f, B:54:0x012c, B:55:0x012f, B:56:0x0132, B:59:0x0138), top: B:72:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012f A[Catch: all -> 0x0180, TryCatch #0 {, blocks: (B:23:0x0065, B:25:0x0069, B:27:0x006d, B:28:0x0076, B:30:0x007c, B:34:0x0088, B:36:0x0091, B:58:0x0135, B:37:0x0095, B:39:0x009d, B:40:0x00a1, B:42:0x00c6, B:47:0x011f, B:54:0x012c, B:55:0x012f, B:56:0x0132, B:59:0x0138), top: B:72:0x0065 }] */
    @Override // c.a.n0.a.x.l.g.c
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
            if ((pMSAppInfo == null || !this.f7239f) && k) {
                Log.e("SwanAppMasterProviderMulti", Log.getStackTraceString(new Exception("currentAppInfo can not be null， and should call startApp after preload finished")));
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "real start a swan app - " + pMSAppInfo);
                Log.w("SwanAppMasterProviderMulti", "is default master ready - " + this.f7239f);
            }
            if (this.f7240g) {
                return this.f7238e;
            }
            synchronized (this.j) {
                if (!this.f7240g) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    boolean z = true;
                    if (this.f7235b != null && this.f7235b.n() && pMSAppInfo != null) {
                        if (this.f7235b.w(pMSAppInfo, null)) {
                            bVar = this.a;
                            z = false;
                            o(z, bVar, pMSAppInfo);
                        } else {
                            if (this.f7235b.j()) {
                                bVar = this.f7235b;
                            } else {
                                a.C0548a c0548a = new a.C0548a(pMSAppInfo.appKey, pMSAppInfo.versionCode);
                                boolean f2 = a.c().f(c0548a);
                                boolean g2 = a.c().g(c0548a);
                                boolean e2 = a.c().e();
                                if (k) {
                                    Log.d("SwanAppMasterProviderMulti", "app - " + c0548a + ", is loaded - " + f2);
                                    Log.d("SwanAppMasterProviderMulti", "app - " + c0548a + ", is loading - " + g2);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("has loading app now - ");
                                    sb.append(e2);
                                    Log.d("SwanAppMasterProviderMulti", sb.toString());
                                }
                                if (e2 && !g2) {
                                    if (f2 && l) {
                                        bVar = z ? this.f7235b : this.a;
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
                Log.i("SwanAppMasterProviderMulti", "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("final master id - ");
                sb2.append(this.f7238e.i().c());
                Log.i("SwanAppMasterProviderMulti", sb2.toString());
            }
            return this.f7238e;
        }
        return (b) invokeL.objValue;
    }

    @Override // c.a.n0.a.x.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (k) {
                Log.d("SwanAppMasterProviderMulti", "release master provider");
            }
            this.f7239f = false;
            this.f7240g = false;
            this.i = false;
            this.f7241h = false;
            m(this.a);
            m(this.f7235b);
            this.a = null;
            this.f7235b = null;
            this.f7238e = null;
            synchronized (this.j) {
                this.f7236c.clear();
                this.f7237d.clear();
            }
            c.a.n0.a.x.l.g.e.c();
            h.b().d();
            a.c().a();
        }
    }
}
