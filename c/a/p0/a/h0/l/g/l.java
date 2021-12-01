package c.a.p0.a.h0.l.g;

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

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f5688k;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;
    public final g a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<c.a.p0.a.o0.d.b> f5689b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d<a>> f5690c;

    /* renamed from: d  reason: collision with root package name */
    public k f5691d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5692e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f5693f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f5694g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f5695h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5696i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f5697j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(947043786, "Lc/a/p0/a/h0/l/g/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(947043786, "Lc/a/p0/a/h0/l/g/l;");
                return;
            }
        }
        f5688k = c.a.p0.a.k.a;
        l = 2;
    }

    public l() {
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
        this.f5689b = new LinkedList<>();
        this.f5690c = new LinkedList();
        this.a = new g(l);
        this.f5697j = new Object();
        this.f5692e = false;
        this.f5693f = false;
        this.f5694g = false;
        this.f5696i = false;
        this.f5695h = false;
    }

    @Override // c.a.p0.a.h0.l.g.b
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (f5688k) {
                String str2 = "get a prefetch event - " + cVar;
            }
            c.a.p0.a.e0.d.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo == null) {
                boolean z = f5688k;
                return;
            }
            String str3 = pMSAppInfo.appId;
            if (TextUtils.isEmpty(str3)) {
                boolean z2 = f5688k;
            } else if (this.f5693f) {
                c.a.p0.a.d2.e a0 = c.a.p0.a.d2.e.a0();
                if (a0 == null) {
                    return;
                }
                if (TextUtils.equals(str3, a0.getAppId())) {
                    c.a.p0.a.e0.d.i(PrefetchEvent.MODULE, "prefetch after app start");
                    this.f5691d.r(str, cVar, pMSAppInfo);
                    if (f5688k) {
                        String str4 = "prefetch after app start - " + str3;
                        return;
                    }
                    return;
                }
                boolean z3 = f5688k;
            } else if (!this.f5692e) {
                boolean z4 = f5688k;
            } else {
                synchronized (this.f5697j) {
                    if (this.f5693f) {
                        return;
                    }
                    k d2 = this.a.d(str3);
                    if (d2 == null) {
                        d2 = k(false, this.f5696i);
                        this.a.f(d2);
                    }
                    if (d2.w(pMSAppInfo, cVar)) {
                        this.a.c(str3);
                        d2 = k(false, this.f5696i);
                        this.a.f(d2);
                    }
                    this.a.g(Collections.singletonList(d2));
                    d2.r(str, cVar, pMSAppInfo);
                }
            }
        }
    }

    @Override // c.a.p0.a.h0.l.g.c
    public void c(d<a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.f5697j) {
            if (this.f5693f) {
                boolean z = f5688k;
                dVar.a(this.f5695h, this.f5691d);
                return;
            }
            if (!this.f5690c.contains(dVar)) {
                this.f5690c.add(dVar);
            }
        }
    }

    @Override // c.a.p0.a.h0.l.g.b
    public void d(c.a.p0.a.o0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || this.f5693f) {
            return;
        }
        synchronized (this.f5697j) {
            this.f5689b.add(bVar);
        }
    }

    @Override // c.a.p0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5694g : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5693f : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f5692e : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f5696i : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (!this.f5694g) {
                synchronized (this.f5697j) {
                    if (!this.f5694g) {
                        this.f5696i = z;
                        k k2 = k(true, z);
                        k2.c(this);
                        k2.c(jVar);
                        this.a.f(k2);
                        this.f5694g = true;
                        return;
                    }
                }
            }
            boolean z2 = f5688k;
            k d2 = this.f5693f ? this.f5691d : this.a.d("_default_id_");
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
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.f5689b.isEmpty() && this.f5693f) {
            synchronized (this.f5697j) {
                Iterator<c.a.p0.a.o0.d.b> it = this.f5689b.iterator();
                while (it.hasNext()) {
                    c.a.p0.a.o0.d.b next = it.next();
                    if (f5688k) {
                        String str = "dispatchPendingEvents event: " + next.a;
                    }
                    c.a.p0.a.h0.u.g.U().U0(next);
                }
                this.f5689b.clear();
            }
        }
    }

    public final void m(boolean z, k kVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), kVar, pMSAppInfo}) == null) {
            this.f5695h = z;
            this.f5691d = kVar;
            kVar.p(pMSAppInfo);
            this.f5693f = true;
            l();
            long currentTimeMillis = f5688k ? System.currentTimeMillis() : 0L;
            this.a.a(Collections.singletonList(kVar));
            if (f5688k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            o(z, kVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.h0.l.g.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: n */
    public k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.f5693f) {
                if (f5688k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f5691d;
        }
        return (k) invokeV.objValue;
    }

    public final void o(boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048590, this, z, kVar) == null) || this.f5690c.size() <= 0) {
            return;
        }
        synchronized (this.f5697j) {
            for (d<a> dVar : this.f5690c) {
                dVar.a(z, kVar);
            }
            this.f5690c.clear();
        }
        if (f5688k) {
            String str = "is hit prefetch env - " + z;
        }
    }

    @Override // c.a.p0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f5692e = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.h0.l.g.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: p */
    public k e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        k d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pMSAppInfo)) == null) {
            long currentTimeMillis = f5688k ? System.currentTimeMillis() : 0L;
            if (pMSAppInfo == null && f5688k) {
                Log.getStackTraceString(new Exception("currentAppInfo can not be null"));
            }
            if (f5688k) {
                String str = "real start a swan app - " + pMSAppInfo;
            }
            if (!this.f5692e && f5688k) {
                throw new RuntimeException("should call startApp after preload finished");
            }
            String str2 = pMSAppInfo == null ? null : pMSAppInfo.appId;
            if (this.f5693f) {
                return this.f5691d;
            }
            synchronized (this.f5697j) {
                if (!this.f5693f) {
                    boolean z = false;
                    if (!TextUtils.isEmpty(str2) && pMSAppInfo != null) {
                        d2 = this.a.d(str2);
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
            if (f5688k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str3 = "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                String str4 = "final master id - " + this.f5691d.i().c();
            }
            return this.f5691d;
        }
        return (k) invokeL.objValue;
    }

    @Override // c.a.p0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f5692e = false;
            this.f5693f = false;
            this.f5694g = false;
            this.f5696i = false;
            this.f5695h = false;
            this.f5691d = null;
            this.a.a(null);
            synchronized (this.f5697j) {
                this.f5689b.clear();
                this.f5690c.clear();
            }
            e.c();
            h.b().d();
        }
    }
}
