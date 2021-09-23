package c.a.p0.a.h0.l.g;

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

    /* renamed from: a  reason: collision with root package name */
    public final g f6123a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<c.a.p0.a.o0.d.a> f6124b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d<a>> f6125c;

    /* renamed from: d  reason: collision with root package name */
    public k f6126d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f6127e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f6128f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f6129g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f6130h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6131i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f6132j;

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
        k = c.a.p0.a.k.f7085a;
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
        this.f6124b = new LinkedList<>();
        this.f6125c = new LinkedList();
        this.f6123a = new g(l);
        this.f6132j = new Object();
        this.f6127e = false;
        this.f6128f = false;
        this.f6129g = false;
        this.f6131i = false;
        this.f6130h = false;
    }

    @Override // c.a.p0.a.h0.l.g.c
    public void b(d<a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.f6132j) {
            if (this.f6128f) {
                boolean z = k;
                dVar.a(this.f6130h, this.f6126d);
                return;
            }
            if (!this.f6125c.contains(dVar)) {
                this.f6125c.add(dVar);
            }
        }
    }

    @Override // c.a.p0.a.h0.l.g.b
    public void c(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, pMSAppInfo) == null) {
            if (k) {
                String str = "get a prefetch event - " + cVar;
            }
            c.a.p0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo == null) {
                boolean z = k;
                return;
            }
            String str2 = pMSAppInfo.appId;
            if (TextUtils.isEmpty(str2)) {
                boolean z2 = k;
            } else if (this.f6128f) {
                c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
                if (Q == null) {
                    return;
                }
                if (TextUtils.equals(str2, Q.getAppId())) {
                    c.a.p0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch after app start");
                    this.f6126d.r(cVar, pMSAppInfo);
                    if (k) {
                        String str3 = "prefetch after app start - " + str2;
                        return;
                    }
                    return;
                }
                boolean z3 = k;
            } else if (!this.f6127e) {
                boolean z4 = k;
            } else {
                synchronized (this.f6132j) {
                    if (this.f6128f) {
                        return;
                    }
                    k d2 = this.f6123a.d(str2);
                    if (d2 == null) {
                        d2 = k(false, this.f6131i);
                        this.f6123a.f(d2);
                    }
                    if (d2.w(pMSAppInfo, cVar)) {
                        this.f6123a.c(str2);
                        d2 = k(false, this.f6131i);
                        this.f6123a.f(d2);
                    }
                    this.f6123a.g(Collections.singletonList(d2));
                    d2.r(cVar, pMSAppInfo);
                }
            }
        }
    }

    @Override // c.a.p0.a.h0.l.g.b
    public void d(c.a.p0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null || this.f6128f) {
            return;
        }
        synchronized (this.f6132j) {
            this.f6124b.add(aVar);
        }
    }

    @Override // c.a.p0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6129g : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6128f : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6127e : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f6131i : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (!this.f6129g) {
                synchronized (this.f6132j) {
                    if (!this.f6129g) {
                        this.f6131i = z;
                        k k2 = k(true, z);
                        k2.c(this);
                        k2.c(jVar);
                        this.f6123a.f(k2);
                        this.f6129g = true;
                        return;
                    }
                }
            }
            boolean z2 = k;
            k d2 = this.f6128f ? this.f6126d : this.f6123a.d("_default_id_");
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
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.f6124b.isEmpty() && this.f6128f) {
            synchronized (this.f6132j) {
                Iterator<c.a.p0.a.o0.d.a> it = this.f6124b.iterator();
                while (it.hasNext()) {
                    c.a.p0.a.o0.d.a next = it.next();
                    if (k) {
                        String str = "dispatchPendingEvents event: " + next.f7803a;
                    }
                    c.a.p0.a.h0.u.g.N().H0(next);
                }
                this.f6124b.clear();
            }
        }
    }

    public final void m(boolean z, k kVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), kVar, pMSAppInfo}) == null) {
            this.f6130h = z;
            this.f6126d = kVar;
            kVar.p(pMSAppInfo);
            this.f6128f = true;
            l();
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            this.f6123a.a(Collections.singletonList(kVar));
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            o(z, kVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.h0.l.g.c
    /* renamed from: n */
    public k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.f6128f) {
                if (k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f6126d;
        }
        return (k) invokeV.objValue;
    }

    public final void o(boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048590, this, z, kVar) == null) || this.f6125c.size() <= 0) {
            return;
        }
        synchronized (this.f6132j) {
            for (d<a> dVar : this.f6125c) {
                dVar.a(z, kVar);
            }
            this.f6125c.clear();
        }
        if (k) {
            String str = "is hit prefetch env - " + z;
        }
    }

    @Override // c.a.p0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f6127e = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.h0.l.g.c
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
            if (!this.f6127e && k) {
                throw new RuntimeException("should call startApp after preload finished");
            }
            String str2 = pMSAppInfo == null ? null : pMSAppInfo.appId;
            if (this.f6128f) {
                return this.f6126d;
            }
            synchronized (this.f6132j) {
                if (!this.f6128f) {
                    boolean z = false;
                    if (!TextUtils.isEmpty(str2) && pMSAppInfo != null) {
                        d2 = this.f6123a.d(str2);
                        if (d2 == null || !d2.n() || d2.w(pMSAppInfo, null)) {
                            d2 = this.f6123a.d("_default_id_");
                        } else {
                            z = true;
                        }
                        m(z, d2, pMSAppInfo);
                    }
                    d2 = this.f6123a.d("_default_id_");
                    m(z, d2, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str3 = "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                String str4 = "final master id - " + this.f6126d.i().c();
            }
            return this.f6126d;
        }
        return (k) invokeL.objValue;
    }

    @Override // c.a.p0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f6127e = false;
            this.f6128f = false;
            this.f6129g = false;
            this.f6131i = false;
            this.f6130h = false;
            this.f6126d = null;
            this.f6123a.a(null);
            synchronized (this.f6132j) {
                this.f6124b.clear();
                this.f6125c.clear();
            }
            e.c();
            h.b().d();
        }
    }
}
