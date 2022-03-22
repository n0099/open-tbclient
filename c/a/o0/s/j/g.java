package c.a.o0.s.j;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.r.k;
import c.a.o0.s.j.a;
import c.a.o0.s.j.d;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static g l;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f11426b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11427c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11428d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f11429e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11430f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f11431g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f11432h;
    public boolean i;
    public BDHttpDnsResult j;
    public final c.a.d.f.r.g k;

    /* loaded from: classes2.dex */
    public class a implements c.a.d.f.r.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.d.f.r.g
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.d.f.r.g
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if ((i == 2 || i == 9) && l.z()) {
                    g.d(this.a);
                    if (UseHttpdnsSdkSwitch.isOn()) {
                        if (this.a.f11432h == null || this.a.f11432h.isEmpty()) {
                            this.a.w();
                        } else {
                            this.a.a();
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("retryiplist_");
                        stringBuffer.append(c.a.d.c.e.c.h.d());
                        if (this.a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.a.j.c());
                        }
                        c.a.d.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                        if (this.a.a >= 5) {
                            BdSocketLinkService.setAvailable(false);
                            this.a.B();
                        }
                    } else if (this.a.a >= 5) {
                        c.a.d.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + c.a.d.c.e.c.h.d());
                        this.a.C();
                    }
                }
            }
        }

        @Override // c.a.d.f.r.g
        public void c(c.a.d.f.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            }
        }

        @Override // c.a.d.f.r.g
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            }
        }

        @Override // c.a.d.f.r.g
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // c.a.d.f.r.g
        public void f(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            }
        }

        @Override // c.a.d.f.r.g
        public void g(int i, c.a.d.f.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i, cVar) == null) {
            }
        }

        @Override // c.a.d.f.r.g
        public void h(c.a.d.f.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            }
        }

        @Override // c.a.d.f.r.g
        public void i(c.a.d.f.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            }
        }

        @Override // c.a.d.f.r.g
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (this.a.a > 0) {
                        this.a.i = false;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("URL_");
                        stringBuffer.append(c.a.d.c.e.c.h.d());
                        if (this.a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.a.j.c());
                        }
                        c.a.d.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                    }
                } else if (this.a.a >= 5) {
                    c.a.d.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + c.a.d.c.e.c.h.d());
                    c.a.o0.s.j.a.f().l(c.a.d.c.e.c.h.d());
                    c.a.o0.s.j.a.f().k();
                }
                this.a.a = 0;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements BDHttpDns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // com.baidu.bdhttpdns.BDHttpDns.a
        public void a(BDHttpDnsResult bDHttpDnsResult) {
            ArrayList<String> a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDHttpDnsResult) == null) {
                this.a.i = false;
                this.a.j = bDHttpDnsResult;
                if (bDHttpDnsResult == null || (a = bDHttpDnsResult.a()) == null || a.isEmpty()) {
                    return;
                }
                synchronized (this.a.f11431g) {
                    this.a.f11432h = a;
                }
                this.a.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f11433b;

        public c(g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11433b = gVar;
            this.a = str;
        }

        @Override // c.a.o0.s.j.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11433b.f11426b = 0;
                this.f11433b.f11429e = c.a.o0.s.j.a.f().g();
                if (this.f11433b.f11429e != null) {
                    this.f11433b.A(this.a);
                } else {
                    this.f11433b.f11430f = false;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* loaded from: classes2.dex */
        public class a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // c.a.o0.s.j.a.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.f11426b = 0;
                    this.a.a.f11429e = c.a.o0.s.j.a.f().g();
                    if (this.a.a.f11429e != null) {
                        this.a.a.A("change ip to reconnect with DNS' failed.");
                    } else {
                        this.a.a.f11430f = false;
                    }
                }
            }
        }

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.o0.s.j.d.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.o0.s.j.b.e().a(z ? 2 : 1);
                if (z) {
                    this.a.f11429e = c.a.o0.s.j.a.f().g();
                    if (this.a.f11429e != null) {
                        this.a.A("change ip to reconnect with DNS' failed.");
                        return;
                    } else {
                        c.a.o0.s.j.a.f().m(new a(this));
                        return;
                    }
                }
                this.a.f11430f = false;
                this.a.D();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(963785757, "Lc/a/o0/s/j/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(963785757, "Lc/a/o0/s/j/g;");
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11426b = 0;
        this.f11427c = false;
        this.f11428d = false;
        this.f11429e = null;
        this.f11430f = false;
        this.f11431g = new Object();
        this.f11432h = new ArrayList();
        this.i = false;
        this.j = null;
        this.k = new a(this);
    }

    public static /* synthetic */ int d(g gVar) {
        int i = gVar.a;
        gVar.a = i + 1;
        return i;
    }

    public static String u(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            if (str != null && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
                try {
                    return str.substring(5, lastIndexOf);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String v(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (str != null && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
                try {
                    return str.substring(lastIndexOf + 1);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static synchronized g y() {
        InterceptResult invokeV;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            synchronized (g.class) {
                if (l == null) {
                    synchronized (g.class) {
                        if (l == null) {
                            l = new g();
                        }
                    }
                }
                gVar = l;
            }
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            String x = x();
            if (x == null) {
                if (!c.a.o0.s.j.a.f().i()) {
                    c.a.o0.s.j.a.f().m(new c(this, str));
                }
                c.a.d.c.e.c.h.h(TiebaIMConfig.url);
                BdSocketLinkService.setAvailable(false);
                D();
            } else if (u(x) == null) {
                D();
            } else {
                this.f11430f = false;
                BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
                c.a.d.c.e.c.h.h(x);
                BdSocketLinkService.init();
                BdSocketLinkService.startService(true, str);
                this.f11427c = true;
                this.f11426b++;
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NoNetworkView.e();
            this.f11426b = 0;
            this.i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f11430f) {
            return;
        }
        this.f11430f = true;
        if (this.f11427c) {
            this.f11427c = false;
            c.a.o0.s.j.b.e().d(TiebaIMConfig.url);
        }
        c.a.o0.s.j.b.e().b();
        if (!this.f11428d) {
            new c.a.o0.s.j.d("www.baidu.com", new d(this));
            this.f11428d = true;
            return;
        }
        A("change ip to reconnect with DNS' failed.");
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NoNetworkView.e();
            this.f11428d = false;
            this.f11426b = 0;
            this.f11430f = false;
            this.f11427c = false;
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f11431g) {
                if (this.f11432h != null && !this.f11432h.isEmpty()) {
                    String remove = this.f11432h.remove(0);
                    if (!TextUtils.isEmpty(remove)) {
                        c.a.d.c.e.c.h.h("ws://" + remove + ":" + v(TiebaIMConfig.url));
                        BdSocketLinkService.init();
                    }
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.i) {
            return;
        }
        try {
            String u = u(TiebaIMConfig.url);
            if (m.isEmpty(u)) {
                B();
                return;
            }
            this.i = true;
            BDHttpDns.j(BdBaseApplication.getInst().getApplicationContext()).c(u, new b(this));
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final String x() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<String> list = this.f11429e;
            if (list == null || (i = this.f11426b) <= -1 || i >= list.size()) {
                return null;
            }
            return c.a.o0.s.j.a.f().g().get(this.f11426b);
        }
        return (String) invokeV.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.d.f.r.h.j().c(this.k);
        }
    }
}
