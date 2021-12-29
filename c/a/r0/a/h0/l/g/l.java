package c.a.r0.a.h0.l.g;

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
    public static final boolean f6732k;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;
    public final g a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<c.a.r0.a.o0.d.b> f6733b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d<a>> f6734c;

    /* renamed from: d  reason: collision with root package name */
    public k f6735d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f6736e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f6737f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f6738g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f6739h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6740i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f6741j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-64073464, "Lc/a/r0/a/h0/l/g/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-64073464, "Lc/a/r0/a/h0/l/g/l;");
                return;
            }
        }
        f6732k = c.a.r0.a.k.a;
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
        this.f6733b = new LinkedList<>();
        this.f6734c = new LinkedList();
        this.a = new g(l);
        this.f6741j = new Object();
        this.f6736e = false;
        this.f6737f = false;
        this.f6738g = false;
        this.f6740i = false;
        this.f6739h = false;
    }

    @Override // c.a.r0.a.h0.l.g.b
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (f6732k) {
                String str2 = "get a prefetch event - " + cVar;
            }
            c.a.r0.a.e0.d.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo == null) {
                boolean z = f6732k;
                return;
            }
            String str3 = pMSAppInfo.appId;
            if (TextUtils.isEmpty(str3)) {
                boolean z2 = f6732k;
            } else if (this.f6737f) {
                c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
                if (a0 == null) {
                    return;
                }
                if (TextUtils.equals(str3, a0.getAppId())) {
                    c.a.r0.a.e0.d.i(PrefetchEvent.MODULE, "prefetch after app start");
                    this.f6735d.r(str, cVar, pMSAppInfo);
                    if (f6732k) {
                        String str4 = "prefetch after app start - " + str3;
                        return;
                    }
                    return;
                }
                boolean z3 = f6732k;
            } else if (!this.f6736e) {
                boolean z4 = f6732k;
            } else {
                synchronized (this.f6741j) {
                    if (this.f6737f) {
                        return;
                    }
                    k d2 = this.a.d(str3);
                    if (d2 == null) {
                        d2 = k(false, this.f6740i);
                        this.a.f(d2);
                    }
                    if (d2.w(pMSAppInfo, cVar)) {
                        this.a.c(str3);
                        d2 = k(false, this.f6740i);
                        this.a.f(d2);
                    }
                    this.a.g(Collections.singletonList(d2));
                    d2.r(str, cVar, pMSAppInfo);
                }
            }
        }
    }

    @Override // c.a.r0.a.h0.l.g.c
    public void c(d<a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.f6741j) {
            if (this.f6737f) {
                boolean z = f6732k;
                dVar.a(this.f6739h, this.f6735d);
                return;
            }
            if (!this.f6734c.contains(dVar)) {
                this.f6734c.add(dVar);
            }
        }
    }

    @Override // c.a.r0.a.h0.l.g.b
    public void d(c.a.r0.a.o0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || this.f6737f) {
            return;
        }
        synchronized (this.f6741j) {
            this.f6733b.add(bVar);
        }
    }

    @Override // c.a.r0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6738g : invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6737f : invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6736e : invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f6740i : invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (!this.f6738g) {
                synchronized (this.f6741j) {
                    if (!this.f6738g) {
                        this.f6740i = z;
                        k k2 = k(true, z);
                        k2.c(this);
                        k2.c(jVar);
                        this.a.f(k2);
                        this.f6738g = true;
                        return;
                    }
                }
            }
            boolean z2 = f6732k;
            k d2 = this.f6737f ? this.f6735d : this.a.d("_default_id_");
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
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.f6733b.isEmpty() && this.f6737f) {
            synchronized (this.f6741j) {
                Iterator<c.a.r0.a.o0.d.b> it = this.f6733b.iterator();
                while (it.hasNext()) {
                    c.a.r0.a.o0.d.b next = it.next();
                    if (f6732k) {
                        String str = "dispatchPendingEvents event: " + next.a;
                    }
                    c.a.r0.a.h0.u.g.U().U0(next);
                }
                this.f6733b.clear();
            }
        }
    }

    public final void m(boolean z, k kVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), kVar, pMSAppInfo}) == null) {
            this.f6739h = z;
            this.f6735d = kVar;
            kVar.p(pMSAppInfo);
            this.f6737f = true;
            l();
            long currentTimeMillis = f6732k ? System.currentTimeMillis() : 0L;
            this.a.a(Collections.singletonList(kVar));
            if (f6732k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            o(z, kVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.h0.l.g.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: n */
    public k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.f6737f) {
                if (f6732k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f6735d;
        }
        return (k) invokeV.objValue;
    }

    public final void o(boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048590, this, z, kVar) == null) || this.f6734c.size() <= 0) {
            return;
        }
        synchronized (this.f6741j) {
            for (d<a> dVar : this.f6734c) {
                dVar.a(z, kVar);
            }
            this.f6734c.clear();
        }
        if (f6732k) {
            String str = "is hit prefetch env - " + z;
        }
    }

    @Override // c.a.r0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f6736e = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.h0.l.g.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: p */
    public k e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        k d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pMSAppInfo)) == null) {
            long currentTimeMillis = f6732k ? System.currentTimeMillis() : 0L;
            if (pMSAppInfo == null && f6732k) {
                Log.getStackTraceString(new Exception("currentAppInfo can not be null"));
            }
            if (f6732k) {
                String str = "real start a swan app - " + pMSAppInfo;
            }
            if (!this.f6736e && f6732k) {
                throw new RuntimeException("should call startApp after preload finished");
            }
            String str2 = pMSAppInfo == null ? null : pMSAppInfo.appId;
            if (this.f6737f) {
                return this.f6735d;
            }
            synchronized (this.f6741j) {
                if (!this.f6737f) {
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
            if (f6732k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str3 = "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                String str4 = "final master id - " + this.f6735d.i().c();
            }
            return this.f6735d;
        }
        return (k) invokeL.objValue;
    }

    @Override // c.a.r0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f6736e = false;
            this.f6737f = false;
            this.f6738g = false;
            this.f6740i = false;
            this.f6739h = false;
            this.f6735d = null;
            this.a.a(null);
            synchronized (this.f6741j) {
                this.f6733b.clear();
                this.f6734c.clear();
            }
            e.c();
            h.b().d();
        }
    }
}
