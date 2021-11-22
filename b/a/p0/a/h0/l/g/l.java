package b.a.p0.a.h0.l.g;

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

    /* renamed from: a  reason: collision with root package name */
    public final g f5745a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<b.a.p0.a.o0.d.b> f5746b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d<a>> f5747c;

    /* renamed from: d  reason: collision with root package name */
    public k f5748d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5749e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f5750f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f5751g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f5752h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5753i;
    public final Object j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1944116139, "Lb/a/p0/a/h0/l/g/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1944116139, "Lb/a/p0/a/h0/l/g/l;");
                return;
            }
        }
        k = b.a.p0.a.k.f6863a;
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
        this.f5746b = new LinkedList<>();
        this.f5747c = new LinkedList();
        this.f5745a = new g(l);
        this.j = new Object();
        this.f5749e = false;
        this.f5750f = false;
        this.f5751g = false;
        this.f5753i = false;
        this.f5752h = false;
    }

    @Override // b.a.p0.a.h0.l.g.b
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (k) {
                String str2 = "get a prefetch event - " + cVar;
            }
            b.a.p0.a.e0.d.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo == null) {
                boolean z = k;
                return;
            }
            String str3 = pMSAppInfo.appId;
            if (TextUtils.isEmpty(str3)) {
                boolean z2 = k;
            } else if (this.f5750f) {
                b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
                if (a0 == null) {
                    return;
                }
                if (TextUtils.equals(str3, a0.getAppId())) {
                    b.a.p0.a.e0.d.i(PrefetchEvent.MODULE, "prefetch after app start");
                    this.f5748d.r(str, cVar, pMSAppInfo);
                    if (k) {
                        String str4 = "prefetch after app start - " + str3;
                        return;
                    }
                    return;
                }
                boolean z3 = k;
            } else if (!this.f5749e) {
                boolean z4 = k;
            } else {
                synchronized (this.j) {
                    if (this.f5750f) {
                        return;
                    }
                    k d2 = this.f5745a.d(str3);
                    if (d2 == null) {
                        d2 = k(false, this.f5753i);
                        this.f5745a.f(d2);
                    }
                    if (d2.w(pMSAppInfo, cVar)) {
                        this.f5745a.c(str3);
                        d2 = k(false, this.f5753i);
                        this.f5745a.f(d2);
                    }
                    this.f5745a.g(Collections.singletonList(d2));
                    d2.r(str, cVar, pMSAppInfo);
                }
            }
        }
    }

    @Override // b.a.p0.a.h0.l.g.c
    public void c(d<a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.j) {
            if (this.f5750f) {
                boolean z = k;
                dVar.a(this.f5752h, this.f5748d);
                return;
            }
            if (!this.f5747c.contains(dVar)) {
                this.f5747c.add(dVar);
            }
        }
    }

    @Override // b.a.p0.a.h0.l.g.b
    public void d(b.a.p0.a.o0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || this.f5750f) {
            return;
        }
        synchronized (this.j) {
            this.f5746b.add(bVar);
        }
    }

    @Override // b.a.p0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5751g : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5750f : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f5749e : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f5753i : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (!this.f5751g) {
                synchronized (this.j) {
                    if (!this.f5751g) {
                        this.f5753i = z;
                        k k2 = k(true, z);
                        k2.c(this);
                        k2.c(jVar);
                        this.f5745a.f(k2);
                        this.f5751g = true;
                        return;
                    }
                }
            }
            boolean z2 = k;
            k d2 = this.f5750f ? this.f5748d : this.f5745a.d("_default_id_");
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
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.f5746b.isEmpty() && this.f5750f) {
            synchronized (this.j) {
                Iterator<b.a.p0.a.o0.d.b> it = this.f5746b.iterator();
                while (it.hasNext()) {
                    b.a.p0.a.o0.d.b next = it.next();
                    if (k) {
                        String str = "dispatchPendingEvents event: " + next.f7439a;
                    }
                    b.a.p0.a.h0.u.g.U().U0(next);
                }
                this.f5746b.clear();
            }
        }
    }

    public final void m(boolean z, k kVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), kVar, pMSAppInfo}) == null) {
            this.f5752h = z;
            this.f5748d = kVar;
            kVar.p(pMSAppInfo);
            this.f5750f = true;
            l();
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            this.f5745a.a(Collections.singletonList(kVar));
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            o(z, kVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.h0.l.g.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: n */
    public k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.f5750f) {
                if (k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f5748d;
        }
        return (k) invokeV.objValue;
    }

    public final void o(boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048590, this, z, kVar) == null) || this.f5747c.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (d<a> dVar : this.f5747c) {
                dVar.a(z, kVar);
            }
            this.f5747c.clear();
        }
        if (k) {
            String str = "is hit prefetch env - " + z;
        }
    }

    @Override // b.a.p0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f5749e = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.h0.l.g.c
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
            if (!this.f5749e && k) {
                throw new RuntimeException("should call startApp after preload finished");
            }
            String str2 = pMSAppInfo == null ? null : pMSAppInfo.appId;
            if (this.f5750f) {
                return this.f5748d;
            }
            synchronized (this.j) {
                if (!this.f5750f) {
                    boolean z = false;
                    if (!TextUtils.isEmpty(str2) && pMSAppInfo != null) {
                        d2 = this.f5745a.d(str2);
                        if (d2 == null || !d2.n() || d2.w(pMSAppInfo, null)) {
                            d2 = this.f5745a.d("_default_id_");
                        } else {
                            z = true;
                        }
                        m(z, d2, pMSAppInfo);
                    }
                    d2 = this.f5745a.d("_default_id_");
                    m(z, d2, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str3 = "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                String str4 = "final master id - " + this.f5748d.i().c();
            }
            return this.f5748d;
        }
        return (k) invokeL.objValue;
    }

    @Override // b.a.p0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f5749e = false;
            this.f5750f = false;
            this.f5751g = false;
            this.f5753i = false;
            this.f5752h = false;
            this.f5748d = null;
            this.f5745a.a(null);
            synchronized (this.j) {
                this.f5746b.clear();
                this.f5747c.clear();
            }
            e.c();
            h.b().d();
        }
    }
}
