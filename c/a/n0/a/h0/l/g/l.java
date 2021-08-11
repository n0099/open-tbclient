package c.a.n0.a.h0.l.g;

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
    public final g f5841a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<c.a.n0.a.o0.d.a> f5842b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d<a>> f5843c;

    /* renamed from: d  reason: collision with root package name */
    public k f5844d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5845e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f5846f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f5847g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f5848h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5849i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f5850j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1958161036, "Lc/a/n0/a/h0/l/g/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1958161036, "Lc/a/n0/a/h0/l/g/l;");
                return;
            }
        }
        k = c.a.n0.a.k.f6803a;
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
        this.f5842b = new LinkedList<>();
        this.f5843c = new LinkedList();
        this.f5841a = new g(l);
        this.f5850j = new Object();
        this.f5845e = false;
        this.f5846f = false;
        this.f5847g = false;
        this.f5849i = false;
        this.f5848h = false;
    }

    @Override // c.a.n0.a.h0.l.g.c
    public void b(d<a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.f5850j) {
            if (this.f5846f) {
                boolean z = k;
                dVar.a(this.f5848h, this.f5844d);
                return;
            }
            if (!this.f5843c.contains(dVar)) {
                this.f5843c.add(dVar);
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
            c.a.n0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo == null) {
                boolean z = k;
                return;
            }
            String str2 = pMSAppInfo.appId;
            if (TextUtils.isEmpty(str2)) {
                boolean z2 = k;
            } else if (this.f5846f) {
                c.a.n0.a.a2.e Q = c.a.n0.a.a2.e.Q();
                if (Q == null) {
                    return;
                }
                if (TextUtils.equals(str2, Q.getAppId())) {
                    c.a.n0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch after app start");
                    this.f5844d.r(cVar, pMSAppInfo);
                    if (k) {
                        String str3 = "prefetch after app start - " + str2;
                        return;
                    }
                    return;
                }
                boolean z3 = k;
            } else if (!this.f5845e) {
                boolean z4 = k;
            } else {
                synchronized (this.f5850j) {
                    if (this.f5846f) {
                        return;
                    }
                    k d2 = this.f5841a.d(str2);
                    if (d2 == null) {
                        d2 = k(false, this.f5849i);
                        this.f5841a.f(d2);
                    }
                    if (d2.w(pMSAppInfo, cVar)) {
                        this.f5841a.c(str2);
                        d2 = k(false, this.f5849i);
                        this.f5841a.f(d2);
                    }
                    this.f5841a.g(Collections.singletonList(d2));
                    d2.r(cVar, pMSAppInfo);
                }
            }
        }
    }

    @Override // c.a.n0.a.h0.l.g.b
    public void d(c.a.n0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null || this.f5846f) {
            return;
        }
        synchronized (this.f5850j) {
            this.f5842b.add(aVar);
        }
    }

    @Override // c.a.n0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5847g : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5846f : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f5845e : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f5849i : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (!this.f5847g) {
                synchronized (this.f5850j) {
                    if (!this.f5847g) {
                        this.f5849i = z;
                        k k2 = k(true, z);
                        k2.c(this);
                        k2.c(jVar);
                        this.f5841a.f(k2);
                        this.f5847g = true;
                        return;
                    }
                }
            }
            boolean z2 = k;
            k d2 = this.f5846f ? this.f5844d : this.f5841a.d("_default_id_");
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
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.f5842b.isEmpty() && this.f5846f) {
            synchronized (this.f5850j) {
                Iterator<c.a.n0.a.o0.d.a> it = this.f5842b.iterator();
                while (it.hasNext()) {
                    c.a.n0.a.o0.d.a next = it.next();
                    if (k) {
                        String str = "dispatchPendingEvents event: " + next.f7521a;
                    }
                    c.a.n0.a.h0.u.g.N().H0(next);
                }
                this.f5842b.clear();
            }
        }
    }

    public final void m(boolean z, k kVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), kVar, pMSAppInfo}) == null) {
            this.f5848h = z;
            this.f5844d = kVar;
            kVar.p(pMSAppInfo);
            this.f5846f = true;
            l();
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            this.f5841a.a(Collections.singletonList(kVar));
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            o(z, kVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.h0.l.g.c
    /* renamed from: n */
    public k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.f5846f) {
                if (k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f5844d;
        }
        return (k) invokeV.objValue;
    }

    public final void o(boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048590, this, z, kVar) == null) || this.f5843c.size() <= 0) {
            return;
        }
        synchronized (this.f5850j) {
            for (d<a> dVar : this.f5843c) {
                dVar.a(z, kVar);
            }
            this.f5843c.clear();
        }
        if (k) {
            String str = "is hit prefetch env - " + z;
        }
    }

    @Override // c.a.n0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f5845e = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.h0.l.g.c
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
            if (!this.f5845e && k) {
                throw new RuntimeException("should call startApp after preload finished");
            }
            String str2 = pMSAppInfo == null ? null : pMSAppInfo.appId;
            if (this.f5846f) {
                return this.f5844d;
            }
            synchronized (this.f5850j) {
                if (!this.f5846f) {
                    boolean z = false;
                    if (!TextUtils.isEmpty(str2) && pMSAppInfo != null) {
                        d2 = this.f5841a.d(str2);
                        if (d2 == null || !d2.n() || d2.w(pMSAppInfo, null)) {
                            d2 = this.f5841a.d("_default_id_");
                        } else {
                            z = true;
                        }
                        m(z, d2, pMSAppInfo);
                    }
                    d2 = this.f5841a.d("_default_id_");
                    m(z, d2, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str3 = "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                String str4 = "final master id - " + this.f5844d.i().c();
            }
            return this.f5844d;
        }
        return (k) invokeL.objValue;
    }

    @Override // c.a.n0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f5845e = false;
            this.f5846f = false;
            this.f5847g = false;
            this.f5849i = false;
            this.f5848h = false;
            this.f5844d = null;
            this.f5841a.a(null);
            synchronized (this.f5850j) {
                this.f5842b.clear();
                this.f5843c.clear();
            }
            e.c();
            h.b().d();
        }
    }
}
