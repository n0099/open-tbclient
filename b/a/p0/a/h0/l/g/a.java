package b.a.p0.a.h0.l.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
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
    public b.a.p0.a.h0.l.a f5439a;

    /* renamed from: b  reason: collision with root package name */
    public final List<j> f5440b;

    /* renamed from: c  reason: collision with root package name */
    public volatile PMSAppInfo f5441c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PrefetchEvent.c f5442d;

    /* renamed from: e  reason: collision with root package name */
    public volatile i f5443e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5444f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f5445g;

    /* renamed from: h  reason: collision with root package name */
    public long f5446h;

    /* renamed from: i  reason: collision with root package name */
    public long f5447i;
    public final boolean j;

    /* renamed from: b.a.p0.a.h0.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0217a extends b.a.p0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5448a;

        public C0217a(a aVar) {
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
            this.f5448a = aVar;
        }

        @Override // b.a.p0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (a.k) {
                    String str2 = "prepareMaster finish. url: " + str;
                }
                this.f5448a.f5445g = true;
                this.f5448a.f5447i = System.currentTimeMillis();
                this.f5448a.o();
                if (a.k) {
                    String str3 = "createBlankOne cost - " + this.f5448a.f() + "ms";
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f5449a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent.c f5450b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f5451c;

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
            this.f5451c = aVar;
            this.f5449a = pMSAppInfo;
            this.f5450b = cVar;
        }

        @Override // b.a.p0.a.h0.l.g.j
        public void onReady() {
            b.a.p0.a.h0.l.a i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.f5451c.i()) == null || i2.f() == null || i2.f().isDestroyed()) {
                return;
            }
            this.f5451c.q(this.f5449a);
            b.a.p0.a.o0.a.a(i2.f(), this.f5450b);
            b.a.p0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch master finish - " + this.f5450b.toString());
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
        k = b.a.p0.a.k.f6397a;
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
        this.f5440b = new ArrayList();
        this.j = z2;
        this.f5444f = z;
        e();
    }

    public synchronized void c(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            synchronized (this) {
                if (jVar == null) {
                    return;
                }
                if (this.f5445g) {
                    boolean z = k;
                    jVar.onReady();
                    return;
                }
                if (!this.f5440b.contains(jVar)) {
                    this.f5440b.add(jVar);
                }
            }
        }
    }

    public void d(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
            this.f5441c = pMSAppInfo;
            h.b().c(this);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (k) {
                String str = "start create a blank preload master manager, is default - " + this.f5444f + ",is v8 - " + this.j;
            }
            this.f5446h = System.currentTimeMillis();
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            this.f5439a = b.a.p0.a.h0.u.g.M().s0(this.j, new C0217a(this));
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str2 = "create a new master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
        }
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5447i - this.f5446h : invokeV.longValue;
    }

    public PMSAppInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5441c : (PMSAppInfo) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f5441c != null) {
                return this.f5441c.appId;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public b.a.p0.a.h0.l.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5439a : (b.a.p0.a.h0.l.a) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f5443e != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f5444f : invokeV.booleanValue;
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
                b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                str = P != null ? P.I().e("dynamicLibPath", null) : null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f5445g : invokeV.booleanValue;
    }

    public final synchronized void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (k) {
                    String str = "notifyAllReady, callback size " + this.f5440b.size();
                }
                for (j jVar : this.f5440b) {
                    if (jVar != null) {
                        jVar.onReady();
                    }
                }
                this.f5440b.clear();
            }
        }
    }

    public void p(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pMSAppInfo) == null) {
            d(pMSAppInfo);
            this.f5443e = null;
            this.f5442d = null;
        }
    }

    public void q(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pMSAppInfo) == null) {
            v(pMSAppInfo);
            b.a.p0.a.h0.q.a.e(pMSAppInfo.appId);
        }
    }

    public void r(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, cVar, pMSAppInfo) == null) {
            if (cVar == null) {
                boolean z = k;
            } else if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                if (this.f5439a == null) {
                    boolean z2 = k;
                } else if (l() && this.f5441c == null) {
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
            this.f5442d = cVar;
            if (k) {
                String str = "fire prefetch event name - " + cVar.f7099a;
            }
        }
    }

    public final void t(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, cVar, pMSAppInfo) == null) && cVar.i()) {
            this.f5443e = new i();
            this.f5443e.f5461a = pMSAppInfo.appId;
            this.f5443e.f5462b = pMSAppInfo;
            this.f5443e.f5463c = cVar;
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
            b.a.p0.a.h0.l.a aVar = this.f5439a;
            if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || aVar == null) {
                return;
            }
            boolean z = k;
            b.a.p0.a.h0.f.a f2 = aVar.f();
            String str = e.C0109e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)).getPath() + File.separator;
            if (f2 instanceof b.a.p0.a.l0.a) {
                ((b.a.p0.a.l0.a) f2).C0(b.a.p0.a.h0.d.a.a("appjs", str));
            } else if (f2 instanceof NgWebView) {
                ((NgWebView) f2).getSettings().setCodeCacheSetting(b.a.p0.a.h0.d.b.a("appjs", str));
            }
        }
    }
}
