package b.a.p0.a.h0.l.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.d;
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
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.h0.l.a f5719a;

    /* renamed from: b  reason: collision with root package name */
    public final List<j> f5720b;

    /* renamed from: c  reason: collision with root package name */
    public volatile PMSAppInfo f5721c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PrefetchEvent.c f5722d;

    /* renamed from: e  reason: collision with root package name */
    public volatile i f5723e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5724f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f5725g;

    /* renamed from: h  reason: collision with root package name */
    public long f5726h;

    /* renamed from: i  reason: collision with root package name */
    public long f5727i;
    public final boolean j;

    /* renamed from: b.a.p0.a.h0.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0228a extends b.a.p0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5728a;

        public C0228a(a aVar) {
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
            this.f5728a = aVar;
        }

        @Override // b.a.p0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (a.k) {
                    String str2 = "prepareMaster finish. url: " + str;
                }
                this.f5728a.f5725g = true;
                this.f5728a.f5727i = System.currentTimeMillis();
                this.f5728a.o();
                if (a.k) {
                    String str3 = "createBlankOne cost - " + this.f5728a.f() + "ms";
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5729a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f5730b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent.c f5731c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f5732d;

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
            this.f5732d = aVar;
            this.f5729a = str;
            this.f5730b = pMSAppInfo;
            this.f5731c = cVar;
        }

        @Override // b.a.p0.a.h0.l.g.j
        public void onReady() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.h0.l.a i2 = this.f5732d.i();
                if (i2 == null || i2.g() == null || i2.g().isDestroyed()) {
                    z = false;
                } else {
                    this.f5732d.q(this.f5729a, this.f5730b);
                    b.a.p0.a.o0.a.a(i2.g(), this.f5731c);
                    b.a.p0.a.e0.d.i(PrefetchEvent.MODULE, "prefetch master finish");
                    z = true;
                }
                b.a.p0.a.h0.o.j.d d2 = b.a.p0.a.h0.o.j.d.d();
                d2.b(this.f5729a, new UbcFlowEvent("prefetch_end"));
                d2.e(this.f5729a, z, false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1944115798, "Lb/a/p0/a/h0/l/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1944115798, "Lb/a/p0/a/h0/l/g/a;");
                return;
            }
        }
        k = b.a.p0.a.k.f6863a;
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
        this.f5720b = new ArrayList();
        this.j = z2;
        this.f5724f = z;
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
                if (this.f5725g) {
                    boolean z = k;
                    jVar.onReady();
                    return;
                }
                if (!this.f5720b.contains(jVar)) {
                    this.f5720b.add(jVar);
                }
            }
        }
    }

    public void d(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
            this.f5721c = pMSAppInfo;
            h.b().c(this);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (k) {
                String str = "start create a blank preload master manager, is default - " + this.f5724f + ",is v8 - " + this.j;
            }
            this.f5726h = System.currentTimeMillis();
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            this.f5719a = b.a.p0.a.h0.u.g.U().D0(this.j, new C0228a(this));
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str2 = "create a new master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
        }
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5727i - this.f5726h : invokeV.longValue;
    }

    public PMSAppInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5721c : (PMSAppInfo) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f5721c != null) {
                return this.f5721c.appId;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public b.a.p0.a.h0.l.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5719a : (b.a.p0.a.h0.l.a) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f5723e != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f5724f : invokeV.booleanValue;
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
                b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f5725g : invokeV.booleanValue;
    }

    public final synchronized void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (k) {
                    String str = "notifyAllReady, callback size " + this.f5720b.size();
                }
                for (j jVar : this.f5720b) {
                    if (jVar != null) {
                        jVar.onReady();
                    }
                }
                this.f5720b.clear();
            }
        }
    }

    public void p(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pMSAppInfo) == null) {
            d(pMSAppInfo);
            this.f5723e = null;
            this.f5722d = null;
        }
    }

    public void q(String str, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, pMSAppInfo) == null) {
            v(pMSAppInfo);
            b.a.p0.a.h0.q.a.c(str, pMSAppInfo.appId);
        }
    }

    public void r(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, cVar, pMSAppInfo) == null) {
            if (cVar == null) {
                boolean z = k;
            } else if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                if (this.f5719a == null) {
                    b.a.p0.a.e0.d.k("BasePreloadMasterManager", "mMasterManager not create yet, can not prefetch");
                } else if (l() && this.f5721c == null) {
                    b.a.p0.a.e0.d.k("BasePreloadMasterManager", "default blank master can not use to prefetch");
                } else if (k(cVar, pMSAppInfo)) {
                    b.a.p0.a.e0.d.k("BasePreloadMasterManager", "intercept before preload/prefetch");
                } else {
                    d(pMSAppInfo);
                    s(cVar);
                    t(cVar, pMSAppInfo);
                    u(str, cVar, pMSAppInfo);
                }
            } else {
                b.a.p0.a.e0.d.k("BasePreloadMasterManager", "prefetch currentAppInfo is empty");
            }
        }
    }

    public void s(PrefetchEvent.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.f5722d = cVar;
            if (k) {
                String str = "fire prefetch event name - " + cVar.f7439a;
            }
        }
    }

    public final void t(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, cVar, pMSAppInfo) == null) && cVar.u()) {
            this.f5723e = new i();
            this.f5723e.f5742a = pMSAppInfo.appId;
            this.f5723e.f5743b = pMSAppInfo;
            this.f5723e.f5744c = cVar;
        }
    }

    public void u(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, cVar, pMSAppInfo) == null) {
            c(new b(this, str, pMSAppInfo, cVar));
            if (k) {
                String str2 = "fire prefetch event - " + pMSAppInfo.appId + ", version -" + pMSAppInfo.versionCode;
            }
        }
    }

    public void v(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) {
            b.a.p0.a.h0.l.a aVar = this.f5719a;
            if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || aVar == null) {
                return;
            }
            boolean z = k;
            b.a.p0.a.h0.f.a g2 = aVar.g();
            String str = d.e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)).getPath() + File.separator;
            if (g2 instanceof b.a.p0.a.l0.a) {
                ((b.a.p0.a.l0.a) g2).D0(b.a.p0.a.h0.d.a.a("appjs", str));
            } else if (g2 instanceof NgWebView) {
                ((NgWebView) g2).getSettings().setCodeCacheSetting(b.a.p0.a.h0.d.b.a("appjs", str));
            }
        }
    }
}
