package c.a.p0.a.h0.l.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a1.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
    public c.a.p0.a.h0.l.a f6097a;

    /* renamed from: b  reason: collision with root package name */
    public final List<j> f6098b;

    /* renamed from: c  reason: collision with root package name */
    public volatile PMSAppInfo f6099c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PrefetchEvent.c f6100d;

    /* renamed from: e  reason: collision with root package name */
    public volatile i f6101e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f6102f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f6103g;

    /* renamed from: h  reason: collision with root package name */
    public long f6104h;

    /* renamed from: i  reason: collision with root package name */
    public long f6105i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f6106j;

    /* renamed from: c.a.p0.a.h0.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0222a extends c.a.p0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6107a;

        public C0222a(a aVar) {
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
            this.f6107a = aVar;
        }

        @Override // c.a.p0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (a.k) {
                    String str2 = "prepareMaster finish. url: " + str;
                }
                this.f6107a.f6103g = true;
                this.f6107a.f6105i = System.currentTimeMillis();
                this.f6107a.o();
                if (a.k) {
                    String str3 = "createBlankOne cost - " + this.f6107a.f() + "ms";
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f6108a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent.c f6109b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f6110c;

        public b(a aVar, PMSAppInfo pMSAppInfo, PrefetchEvent.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, pMSAppInfo, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6110c = aVar;
            this.f6108a = pMSAppInfo;
            this.f6109b = cVar;
        }

        @Override // c.a.p0.a.h0.l.g.j
        public void onReady() {
            c.a.p0.a.h0.l.a i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.f6110c.i()) == null || i2.g() == null || i2.g().isDestroyed()) {
                return;
            }
            this.f6110c.q(this.f6108a);
            c.a.p0.a.o0.a.a(i2.g(), this.f6109b);
            c.a.p0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch master finish - " + this.f6109b.toString());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(947043445, "Lc/a/p0/a/h0/l/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(947043445, "Lc/a/p0/a/h0/l/g/a;");
                return;
            }
        }
        k = c.a.p0.a.k.f7085a;
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
        this.f6098b = new ArrayList();
        this.f6106j = z2;
        this.f6102f = z;
        e();
    }

    public synchronized void c(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            synchronized (this) {
                if (jVar == null) {
                    return;
                }
                if (this.f6103g) {
                    boolean z = k;
                    jVar.onReady();
                    return;
                }
                if (!this.f6098b.contains(jVar)) {
                    this.f6098b.add(jVar);
                }
            }
        }
    }

    public void d(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
            this.f6099c = pMSAppInfo;
            h.b().c(this);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (k) {
                String str = "start create a blank preload master manager, is default - " + this.f6102f + ",is v8 - " + this.f6106j;
            }
            this.f6104h = System.currentTimeMillis();
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            this.f6097a = c.a.p0.a.h0.u.g.N().t0(this.f6106j, new C0222a(this));
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str2 = "create a new master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
        }
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6105i - this.f6104h : invokeV.longValue;
    }

    public PMSAppInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6099c : (PMSAppInfo) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f6099c != null) {
                return this.f6099c.appId;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public c.a.p0.a.h0.l.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6097a : (c.a.p0.a.h0.l.a) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6101e != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f6102f : invokeV.booleanValue;
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
                c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
                str = Q != null ? Q.J().e("dynamicLibPath", null) : null;
            } else {
                str = cVar.h().get("dynamicLibPath");
            }
            String str2 = cVar2.h().get("dynamicLibPath");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f6103g : invokeV.booleanValue;
    }

    public final synchronized void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (k) {
                    String str = "notifyAllReady, callback size " + this.f6098b.size();
                }
                for (j jVar : this.f6098b) {
                    if (jVar != null) {
                        jVar.onReady();
                    }
                }
                this.f6098b.clear();
            }
        }
    }

    public void p(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pMSAppInfo) == null) {
            d(pMSAppInfo);
            this.f6101e = null;
            this.f6100d = null;
        }
    }

    public void q(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pMSAppInfo) == null) {
            v(pMSAppInfo);
            c.a.p0.a.h0.q.a.e(pMSAppInfo.appId);
        }
    }

    public void r(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, cVar, pMSAppInfo) == null) {
            if (cVar == null) {
                boolean z = k;
            } else if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                if (this.f6097a == null) {
                    boolean z2 = k;
                } else if (l() && this.f6099c == null) {
                    boolean z3 = k;
                } else if (k(cVar, pMSAppInfo)) {
                } else {
                    d(pMSAppInfo);
                    s(cVar);
                    t(cVar, pMSAppInfo);
                    u(cVar, pMSAppInfo);
                }
            } else {
                boolean z4 = k;
            }
        }
    }

    public void s(PrefetchEvent.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.f6100d = cVar;
            if (k) {
                String str = "fire prefetch event name - " + cVar.f7803a;
            }
        }
    }

    public final void t(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, cVar, pMSAppInfo) == null) && cVar.i()) {
            this.f6101e = new i();
            this.f6101e.f6120a = pMSAppInfo.appId;
            this.f6101e.f6121b = pMSAppInfo;
            this.f6101e.f6122c = cVar;
        }
    }

    public void u(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, cVar, pMSAppInfo) == null) {
            c(new b(this, pMSAppInfo, cVar));
            if (k) {
                String str = "fire prefetch event - " + pMSAppInfo.appId + ", version -" + pMSAppInfo.versionCode;
            }
        }
    }

    public void v(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) {
            c.a.p0.a.h0.l.a aVar = this.f6097a;
            if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || aVar == null) {
                return;
            }
            boolean z = k;
            c.a.p0.a.h0.f.a g2 = aVar.g();
            String str = e.C0114e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)).getPath() + File.separator;
            if (g2 instanceof c.a.p0.a.l0.a) {
                ((c.a.p0.a.l0.a) g2).C0(c.a.p0.a.h0.d.a.a("appjs", str));
            } else if (g2 instanceof NgWebView) {
                ((NgWebView) g2).getSettings().setCodeCacheSetting(c.a.p0.a.h0.d.b.a("appjs", str));
            }
        }
    }
}
