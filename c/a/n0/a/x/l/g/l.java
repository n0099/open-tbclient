package c.a.n0.a.x.l.g;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
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
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class l implements b<a>, j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;
    public final g a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<c.a.n0.a.e0.d.b> f7201b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d<a>> f7202c;

    /* renamed from: d  reason: collision with root package name */
    public k f7203d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f7204e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f7205f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f7206g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f7207h;
    public boolean i;
    public final Object j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1451030490, "Lc/a/n0/a/x/l/g/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1451030490, "Lc/a/n0/a/x/l/g/l;");
                return;
            }
        }
        k = c.a.n0.a.a.a;
        l = 2;
    }

    public l() {
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
        this.f7201b = new LinkedList<>();
        this.f7202c = new LinkedList();
        this.a = new g(l);
        this.j = new Object();
        this.f7204e = false;
        this.f7205f = false;
        this.f7206g = false;
        this.i = false;
        this.f7207h = false;
    }

    @Override // c.a.n0.a.x.l.g.b
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (k) {
                Log.i("SwanAppMasterProvider", "get a prefetch event - " + cVar);
            }
            c.a.n0.a.u.d.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo == null) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "prefetch currentAppInfo is empty");
                    return;
                }
                return;
            }
            String str2 = pMSAppInfo.appId;
            if (TextUtils.isEmpty(str2)) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "prefetch appId is empty");
                }
            } else if (this.f7205f) {
                c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
                if (a0 == null) {
                    return;
                }
                if (TextUtils.equals(str2, a0.getAppId())) {
                    c.a.n0.a.u.d.i(PrefetchEvent.MODULE, "prefetch after app start");
                    this.f7203d.r(str, cVar, pMSAppInfo);
                    if (k) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str2);
                    }
                } else if (k) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            } else if (!this.f7204e) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
                }
            } else {
                synchronized (this.j) {
                    if (this.f7205f) {
                        return;
                    }
                    k d2 = this.a.d(str2);
                    if (d2 == null) {
                        d2 = k(false, this.i);
                        this.a.f(d2);
                    }
                    if (d2.w(pMSAppInfo, cVar)) {
                        this.a.c(str2);
                        d2 = k(false, this.i);
                        this.a.f(d2);
                    }
                    this.a.g(Collections.singletonList(d2));
                    d2.r(str, cVar, pMSAppInfo);
                }
            }
        }
    }

    @Override // c.a.n0.a.x.l.g.c
    public void c(d<a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.j) {
            if (this.f7205f) {
                if (k) {
                    Log.d("SwanAppMasterProvider", "app already start , call back immediately");
                }
                dVar.a(this.f7207h, this.f7203d);
                return;
            }
            if (!this.f7202c.contains(dVar)) {
                this.f7202c.add(dVar);
            }
        }
    }

    @Override // c.a.n0.a.x.l.g.b
    public void d(c.a.n0.a.e0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || this.f7205f) {
            return;
        }
        synchronized (this.j) {
            this.f7201b.add(bVar);
        }
    }

    @Override // c.a.n0.a.x.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f7206g : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f7205f : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f7204e : invokeV.booleanValue;
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
            if (!this.f7206g) {
                synchronized (this.j) {
                    if (!this.f7206g) {
                        this.i = z;
                        k k2 = k(true, z);
                        k2.c(this);
                        k2.c(jVar);
                        this.a.f(k2);
                        this.f7206g = true;
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
            }
            k d2 = this.f7205f ? this.f7203d : this.a.d("_default_id_");
            if (d2 != null) {
                d2.c(jVar);
            }
        }
    }

    public k k(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new k(z, z2) : (k) invokeCommon.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.f7201b.isEmpty() && this.f7205f) {
            synchronized (this.j) {
                Iterator<c.a.n0.a.e0.d.b> it = this.f7201b.iterator();
                while (it.hasNext()) {
                    c.a.n0.a.e0.d.b next = it.next();
                    if (k) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.a);
                    }
                    c.a.n0.a.x.u.g.U().U0(next);
                }
                this.f7201b.clear();
            }
        }
    }

    public final void m(boolean z, k kVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), kVar, pMSAppInfo}) == null) {
            this.f7207h = z;
            this.f7203d = kVar;
            kVar.p(pMSAppInfo);
            this.f7205f = true;
            l();
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            this.a.a(Collections.singletonList(kVar));
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("SwanAppMasterProvider", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            o(z, kVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.x.l.g.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: n */
    public k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.f7205f) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + f());
                    Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
                    return null;
                }
                return null;
            }
            return this.f7203d;
        }
        return (k) invokeV.objValue;
    }

    public final void o(boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048590, this, z, kVar) == null) || this.f7202c.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (d<a> dVar : this.f7202c) {
                dVar.a(z, kVar);
            }
            this.f7202c.clear();
        }
        if (k) {
            Log.d("SwanAppMasterProvider", "is hit prefetch env - " + z);
        }
    }

    @Override // c.a.n0.a.x.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f7204e = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.x.l.g.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: p */
    public k e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        k d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pMSAppInfo)) == null) {
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            if (pMSAppInfo == null && k) {
                Log.e("SwanAppMasterProvider", Log.getStackTraceString(new Exception("currentAppInfo can not be null")));
            }
            if (k) {
                Log.w("SwanAppMasterProvider", "real start a swan app - " + pMSAppInfo);
            }
            if (!this.f7204e && k) {
                throw new RuntimeException("should call startApp after preload finished");
            }
            String str = pMSAppInfo == null ? null : pMSAppInfo.appId;
            if (this.f7205f) {
                return this.f7203d;
            }
            synchronized (this.j) {
                if (!this.f7205f) {
                    boolean z = false;
                    if (!TextUtils.isEmpty(str) && pMSAppInfo != null) {
                        d2 = this.a.d(str);
                        if (d2 == null || !d2.n() || d2.w(pMSAppInfo, null)) {
                            d2 = this.a.d("_default_id_");
                        } else {
                            z = true;
                        }
                        m(z, d2, pMSAppInfo);
                    }
                    d2 = this.a.d("_default_id_");
                    m(z, d2, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("SwanAppMasterProvider", "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                StringBuilder sb = new StringBuilder();
                sb.append("final master id - ");
                sb.append(this.f7203d.i().c());
                Log.i("SwanAppMasterProvider", sb.toString());
            }
            return this.f7203d;
        }
        return (k) invokeL.objValue;
    }

    @Override // c.a.n0.a.x.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f7204e = false;
            this.f7205f = false;
            this.f7206g = false;
            this.i = false;
            this.f7207h = false;
            this.f7203d = null;
            this.a.a(null);
            synchronized (this.j) {
                this.f7201b.clear();
                this.f7202c.clear();
            }
            e.c();
            h.b().d();
        }
    }
}
