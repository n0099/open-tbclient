package c.a.r0.a.h0.l.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.a1.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f6712k;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.a.h0.l.a a;

    /* renamed from: b  reason: collision with root package name */
    public final List<j> f6713b;

    /* renamed from: c  reason: collision with root package name */
    public volatile PMSAppInfo f6714c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PrefetchEvent.c f6715d;

    /* renamed from: e  reason: collision with root package name */
    public volatile i f6716e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f6717f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f6718g;

    /* renamed from: h  reason: collision with root package name */
    public long f6719h;

    /* renamed from: i  reason: collision with root package name */
    public long f6720i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f6721j;

    /* renamed from: c.a.r0.a.h0.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0368a extends c.a.r0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0368a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.r0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (a.f6712k) {
                    String str2 = "prepareMaster finish. url: " + str;
                }
                this.a.f6718g = true;
                this.a.f6720i = System.currentTimeMillis();
                this.a.o();
                if (a.f6712k) {
                    String str3 = "createBlankOne cost - " + this.a.f() + "ms";
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f6722b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent.c f6723c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f6724d;

        public b(a aVar, String str, PMSAppInfo pMSAppInfo, PrefetchEvent.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, pMSAppInfo, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6724d = aVar;
            this.a = str;
            this.f6722b = pMSAppInfo;
            this.f6723c = cVar;
        }

        @Override // c.a.r0.a.h0.l.g.j
        public void onReady() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.h0.l.a i2 = this.f6724d.i();
                if (i2 == null || i2.g() == null || i2.g().isDestroyed()) {
                    z = false;
                } else {
                    this.f6724d.q(this.a, this.f6722b);
                    c.a.r0.a.o0.a.a(i2.g(), this.f6723c);
                    c.a.r0.a.e0.d.i(PrefetchEvent.MODULE, "prefetch master finish");
                    z = true;
                }
                c.a.r0.a.h0.o.j.d d2 = c.a.r0.a.h0.o.j.d.d();
                d2.b(this.a, new UbcFlowEvent("prefetch_end"));
                d2.e(this.a, z, false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-64073805, "Lc/a/r0/a/h0/l/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-64073805, "Lc/a/r0/a/h0/l/g/a;");
                return;
            }
        }
        f6712k = c.a.r0.a.k.a;
    }

    public a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6713b = new ArrayList();
        this.f6721j = z2;
        this.f6717f = z;
        if (!z) {
            h.b().c(this);
        }
        e();
    }

    public synchronized void c(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            synchronized (this) {
                if (jVar == null) {
                    return;
                }
                if (this.f6718g) {
                    boolean z = f6712k;
                    jVar.onReady();
                    return;
                }
                if (!this.f6713b.contains(jVar)) {
                    this.f6713b.add(jVar);
                }
            }
        }
    }

    public void d(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
            this.f6714c = pMSAppInfo;
            h.b().c(this);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (f6712k) {
                String str = "start create a blank preload master manager, is default - " + this.f6717f + ",is v8 - " + this.f6721j;
            }
            this.f6719h = System.currentTimeMillis();
            long currentTimeMillis = f6712k ? System.currentTimeMillis() : 0L;
            this.a = c.a.r0.a.h0.u.g.U().D0(this.f6721j, new C0368a(this));
            if (f6712k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str2 = "create a new master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
        }
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6720i - this.f6719h : invokeV.longValue;
    }

    public PMSAppInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6714c : (PMSAppInfo) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f6714c != null) {
                return this.f6714c.appId;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public c.a.r0.a.h0.l.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (c.a.r0.a.h0.l.a) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6716e != null : invokeV.booleanValue;
    }

    public boolean k(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, pMSAppInfo)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f6717f : invokeV.booleanValue;
    }

    public boolean m(PrefetchEvent.c cVar, PrefetchEvent.c cVar2) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, cVar, cVar2)) == null) {
            if (cVar2 == null) {
                return false;
            }
            if (cVar == null) {
                c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
                str = a0 != null ? a0.T().e("dynamicLibPath", null) : null;
            } else {
                str = cVar.t().get("dynamicLibPath");
            }
            String str2 = cVar2.t().get("dynamicLibPath");
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            return !TextUtils.equals(TextUtils.isEmpty(str2) ? null : str2, str);
        }
        return invokeLL.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f6718g : invokeV.booleanValue;
    }

    public final synchronized void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (f6712k) {
                    String str = "notifyAllReady, callback size " + this.f6713b.size();
                }
                for (j jVar : this.f6713b) {
                    if (jVar != null) {
                        jVar.onReady();
                    }
                }
                this.f6713b.clear();
            }
        }
    }

    public void p(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pMSAppInfo) == null) {
            d(pMSAppInfo);
            this.f6716e = null;
            this.f6715d = null;
        }
    }

    public void q(String str, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, pMSAppInfo) == null) {
            v(pMSAppInfo);
            c.a.r0.a.h0.q.a.c(str, pMSAppInfo.appId);
        }
    }

    public void r(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, cVar, pMSAppInfo) == null) {
            if (cVar == null) {
                boolean z = f6712k;
            } else if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                if (this.a == null) {
                    c.a.r0.a.e0.d.k("BasePreloadMasterManager", "mMasterManager not create yet, can not prefetch");
                } else if (l() && this.f6714c == null) {
                    c.a.r0.a.e0.d.k("BasePreloadMasterManager", "default blank master can not use to prefetch");
                } else if (k(cVar, pMSAppInfo)) {
                    c.a.r0.a.e0.d.k("BasePreloadMasterManager", "intercept before preload/prefetch");
                } else {
                    d(pMSAppInfo);
                    s(cVar);
                    t(cVar, pMSAppInfo);
                    u(str, cVar, pMSAppInfo);
                }
            } else {
                c.a.r0.a.e0.d.k("BasePreloadMasterManager", "prefetch currentAppInfo is empty");
            }
        }
    }

    public void s(PrefetchEvent.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.f6715d = cVar;
            if (f6712k) {
                String str = "fire prefetch event name - " + cVar.a;
            }
        }
    }

    public final void t(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, cVar, pMSAppInfo) == null) && cVar.u()) {
            this.f6716e = new i();
            this.f6716e.a = pMSAppInfo.appId;
            this.f6716e.f6730b = pMSAppInfo;
            this.f6716e.f6731c = cVar;
        }
    }

    public void u(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, cVar, pMSAppInfo) == null) {
            c(new b(this, str, pMSAppInfo, cVar));
            if (f6712k) {
                String str2 = "fire prefetch event - " + pMSAppInfo.appId + ", version -" + pMSAppInfo.versionCode;
            }
        }
    }

    public void v(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) {
            c.a.r0.a.h0.l.a aVar = this.a;
            if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || aVar == null) {
                return;
            }
            boolean z = f6712k;
            c.a.r0.a.h0.f.a g2 = aVar.g();
            String str = d.e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)).getPath() + File.separator;
            if (g2 instanceof c.a.r0.a.l0.a) {
                ((c.a.r0.a.l0.a) g2).D0(c.a.r0.a.h0.d.a.a("appjs", str));
            } else if (g2 instanceof NgWebView) {
                ((NgWebView) g2).getSettings().setCodeCacheSetting(c.a.r0.a.h0.d.b.a("appjs", str));
            }
        }
    }
}
