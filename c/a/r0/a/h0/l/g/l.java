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
    public static final boolean k;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;
    public final g a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<c.a.r0.a.o0.d.b> f6590b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d<a>> f6591c;

    /* renamed from: d  reason: collision with root package name */
    public k f6592d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f6593e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f6594f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f6595g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f6596h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6597i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f6598j;

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
        k = c.a.r0.a.k.a;
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
        this.f6590b = new LinkedList<>();
        this.f6591c = new LinkedList();
        this.a = new g(l);
        this.f6598j = new Object();
        this.f6593e = false;
        this.f6594f = false;
        this.f6595g = false;
        this.f6597i = false;
        this.f6596h = false;
    }

    @Override // c.a.r0.a.h0.l.g.b
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (k) {
                String str2 = "get a prefetch event - " + cVar;
            }
            c.a.r0.a.e0.d.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo == null) {
                boolean z = k;
                return;
            }
            String str3 = pMSAppInfo.appId;
            if (TextUtils.isEmpty(str3)) {
                boolean z2 = k;
            } else if (this.f6594f) {
                c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
                if (a0 == null) {
                    return;
                }
                if (TextUtils.equals(str3, a0.getAppId())) {
                    c.a.r0.a.e0.d.i(PrefetchEvent.MODULE, "prefetch after app start");
                    this.f6592d.r(str, cVar, pMSAppInfo);
                    if (k) {
                        String str4 = "prefetch after app start - " + str3;
                        return;
                    }
                    return;
                }
                boolean z3 = k;
            } else if (!this.f6593e) {
                boolean z4 = k;
            } else {
                synchronized (this.f6598j) {
                    if (this.f6594f) {
                        return;
                    }
                    k d2 = this.a.d(str3);
                    if (d2 == null) {
                        d2 = k(false, this.f6597i);
                        this.a.f(d2);
                    }
                    if (d2.w(pMSAppInfo, cVar)) {
                        this.a.c(str3);
                        d2 = k(false, this.f6597i);
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
        synchronized (this.f6598j) {
            if (this.f6594f) {
                boolean z = k;
                dVar.a(this.f6596h, this.f6592d);
                return;
            }
            if (!this.f6591c.contains(dVar)) {
                this.f6591c.add(dVar);
            }
        }
    }

    @Override // c.a.r0.a.h0.l.g.b
    public void d(c.a.r0.a.o0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || this.f6594f) {
            return;
        }
        synchronized (this.f6598j) {
            this.f6590b.add(bVar);
        }
    }

    @Override // c.a.r0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6595g : invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6594f : invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6593e : invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f6597i : invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (!this.f6595g) {
                synchronized (this.f6598j) {
                    if (!this.f6595g) {
                        this.f6597i = z;
                        k k2 = k(true, z);
                        k2.c(this);
                        k2.c(jVar);
                        this.a.f(k2);
                        this.f6595g = true;
                        return;
                    }
                }
            }
            boolean z2 = k;
            k d2 = this.f6594f ? this.f6592d : this.a.d("_default_id_");
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
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.f6590b.isEmpty() && this.f6594f) {
            synchronized (this.f6598j) {
                Iterator<c.a.r0.a.o0.d.b> it = this.f6590b.iterator();
                while (it.hasNext()) {
                    c.a.r0.a.o0.d.b next = it.next();
                    if (k) {
                        String str = "dispatchPendingEvents event: " + next.a;
                    }
                    c.a.r0.a.h0.u.g.U().U0(next);
                }
                this.f6590b.clear();
            }
        }
    }

    public final void m(boolean z, k kVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), kVar, pMSAppInfo}) == null) {
            this.f6596h = z;
            this.f6592d = kVar;
            kVar.p(pMSAppInfo);
            this.f6594f = true;
            l();
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            this.a.a(Collections.singletonList(kVar));
            if (k) {
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
            if (!this.f6594f) {
                if (k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f6592d;
        }
        return (k) invokeV.objValue;
    }

    public final void o(boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048590, this, z, kVar) == null) || this.f6591c.size() <= 0) {
            return;
        }
        synchronized (this.f6598j) {
            for (d<a> dVar : this.f6591c) {
                dVar.a(z, kVar);
            }
            this.f6591c.clear();
        }
        if (k) {
            String str = "is hit prefetch env - " + z;
        }
    }

    @Override // c.a.r0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f6593e = true;
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
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            if (pMSAppInfo == null && k) {
                Log.getStackTraceString(new Exception("currentAppInfo can not be null"));
            }
            if (k) {
                String str = "real start a swan app - " + pMSAppInfo;
            }
            if (!this.f6593e && k) {
                throw new RuntimeException("should call startApp after preload finished");
            }
            String str2 = pMSAppInfo == null ? null : pMSAppInfo.appId;
            if (this.f6594f) {
                return this.f6592d;
            }
            synchronized (this.f6598j) {
                if (!this.f6594f) {
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
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str3 = "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                String str4 = "final master id - " + this.f6592d.i().c();
            }
            return this.f6592d;
        }
        return (k) invokeL.objValue;
    }

    @Override // c.a.r0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f6593e = false;
            this.f6594f = false;
            this.f6595g = false;
            this.f6597i = false;
            this.f6596h = false;
            this.f6592d = null;
            this.a.a(null);
            synchronized (this.f6598j) {
                this.f6590b.clear();
                this.f6591c.clear();
            }
            e.c();
            h.b().d();
        }
    }
}
