package c.a.p0.a.x.l.g;

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
    public final LinkedList<c.a.p0.a.e0.d.b> f8565b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d<a>> f8566c;

    /* renamed from: d  reason: collision with root package name */
    public k f8567d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f8568e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f8569f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f8570g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f8571h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8572i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f8573j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2037836504, "Lc/a/p0/a/x/l/g/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2037836504, "Lc/a/p0/a/x/l/g/l;");
                return;
            }
        }
        k = c.a.p0.a.a.a;
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
        this.f8565b = new LinkedList<>();
        this.f8566c = new LinkedList();
        this.a = new g(l);
        this.f8573j = new Object();
        this.f8568e = false;
        this.f8569f = false;
        this.f8570g = false;
        this.f8572i = false;
        this.f8571h = false;
    }

    @Override // c.a.p0.a.x.l.g.b
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (k) {
                String str2 = "get a prefetch event - " + cVar;
            }
            c.a.p0.a.u.d.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo == null) {
                boolean z = k;
                return;
            }
            String str3 = pMSAppInfo.appId;
            if (TextUtils.isEmpty(str3)) {
                boolean z2 = k;
            } else if (this.f8569f) {
                c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
                if (a0 == null) {
                    return;
                }
                if (TextUtils.equals(str3, a0.getAppId())) {
                    c.a.p0.a.u.d.i(PrefetchEvent.MODULE, "prefetch after app start");
                    this.f8567d.r(str, cVar, pMSAppInfo);
                    if (k) {
                        String str4 = "prefetch after app start - " + str3;
                        return;
                    }
                    return;
                }
                boolean z3 = k;
            } else if (!this.f8568e) {
                boolean z4 = k;
            } else {
                synchronized (this.f8573j) {
                    if (this.f8569f) {
                        return;
                    }
                    k d2 = this.a.d(str3);
                    if (d2 == null) {
                        d2 = k(false, this.f8572i);
                        this.a.f(d2);
                    }
                    if (d2.w(pMSAppInfo, cVar)) {
                        this.a.c(str3);
                        d2 = k(false, this.f8572i);
                        this.a.f(d2);
                    }
                    this.a.g(Collections.singletonList(d2));
                    d2.r(str, cVar, pMSAppInfo);
                }
            }
        }
    }

    @Override // c.a.p0.a.x.l.g.c
    public void c(d<a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.f8573j) {
            if (this.f8569f) {
                boolean z = k;
                dVar.a(this.f8571h, this.f8567d);
                return;
            }
            if (!this.f8566c.contains(dVar)) {
                this.f8566c.add(dVar);
            }
        }
    }

    @Override // c.a.p0.a.x.l.g.b
    public void d(c.a.p0.a.e0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || this.f8569f) {
            return;
        }
        synchronized (this.f8573j) {
            this.f8565b.add(bVar);
        }
    }

    @Override // c.a.p0.a.x.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f8570g : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f8569f : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f8568e : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f8572i : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (!this.f8570g) {
                synchronized (this.f8573j) {
                    if (!this.f8570g) {
                        this.f8572i = z;
                        k k2 = k(true, z);
                        k2.c(this);
                        k2.c(jVar);
                        this.a.f(k2);
                        this.f8570g = true;
                        return;
                    }
                }
            }
            boolean z2 = k;
            k d2 = this.f8569f ? this.f8567d : this.a.d("_default_id_");
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
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.f8565b.isEmpty() && this.f8569f) {
            synchronized (this.f8573j) {
                Iterator<c.a.p0.a.e0.d.b> it = this.f8565b.iterator();
                while (it.hasNext()) {
                    c.a.p0.a.e0.d.b next = it.next();
                    if (k) {
                        String str = "dispatchPendingEvents event: " + next.a;
                    }
                    c.a.p0.a.x.u.g.U().U0(next);
                }
                this.f8565b.clear();
            }
        }
    }

    public final void m(boolean z, k kVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), kVar, pMSAppInfo}) == null) {
            this.f8571h = z;
            this.f8567d = kVar;
            kVar.p(pMSAppInfo);
            this.f8569f = true;
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
    @Override // c.a.p0.a.x.l.g.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: n */
    public k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.f8569f) {
                if (k) {
                    String str = "master not final confirmed, has default - " + f();
                    Log.getStackTraceString(new RuntimeException("throw by debug"));
                    return null;
                }
                return null;
            }
            return this.f8567d;
        }
        return (k) invokeV.objValue;
    }

    public final void o(boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048590, this, z, kVar) == null) || this.f8566c.size() <= 0) {
            return;
        }
        synchronized (this.f8573j) {
            for (d<a> dVar : this.f8566c) {
                dVar.a(z, kVar);
            }
            this.f8566c.clear();
        }
        if (k) {
            String str = "is hit prefetch env - " + z;
        }
    }

    @Override // c.a.p0.a.x.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f8568e = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.x.l.g.c
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
            if (!this.f8568e && k) {
                throw new RuntimeException("should call startApp after preload finished");
            }
            String str2 = pMSAppInfo == null ? null : pMSAppInfo.appId;
            if (this.f8569f) {
                return this.f8567d;
            }
            synchronized (this.f8573j) {
                if (!this.f8569f) {
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
                String str4 = "final master id - " + this.f8567d.i().c();
            }
            return this.f8567d;
        }
        return (k) invokeL.objValue;
    }

    @Override // c.a.p0.a.x.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f8568e = false;
            this.f8569f = false;
            this.f8570g = false;
            this.f8572i = false;
            this.f8571h = false;
            this.f8567d = null;
            this.a.a(null);
            synchronized (this.f8573j) {
                this.f8565b.clear();
                this.f8566c.clear();
            }
            e.c();
            h.b().d();
        }
    }
}
