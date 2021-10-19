package c.a.q0.t.j;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.r.k;
import c.a.q0.t.j.a;
import c.a.q0.t.j.d;
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
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static g l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f15008a;

    /* renamed from: b  reason: collision with root package name */
    public int f15009b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15010c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f15011d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f15012e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15013f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f15014g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f15015h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15016i;

    /* renamed from: j  reason: collision with root package name */
    public BDHttpDnsResult f15017j;
    public final c.a.e.e.r.g k;

    /* loaded from: classes3.dex */
    public class a implements c.a.e.e.r.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f15018a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15018a = gVar;
        }

        @Override // c.a.e.e.r.g
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.e.e.r.g
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if ((i2 == 2 || i2 == 9) && j.z()) {
                    g.d(this.f15018a);
                    if (UseHttpdnsSdkSwitch.isOn()) {
                        if (this.f15018a.f15015h == null || this.f15018a.f15015h.isEmpty()) {
                            this.f15018a.w();
                        } else {
                            this.f15018a.a();
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("retryiplist_");
                        stringBuffer.append(c.a.e.c.e.c.h.d());
                        if (this.f15018a.f15017j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.f15018a.f15017j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.f15018a.f15017j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.f15018a.f15017j.c());
                        }
                        c.a.e.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                        if (this.f15018a.f15008a >= 5) {
                            BdSocketLinkService.setAvailable(false);
                            this.f15018a.B();
                        }
                    } else if (this.f15018a.f15008a >= 5) {
                        c.a.e.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + c.a.e.c.e.c.h.d());
                        this.f15018a.C();
                    }
                }
            }
        }

        @Override // c.a.e.e.r.g
        public void c(c.a.e.e.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            }
        }

        @Override // c.a.e.e.r.g
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            }
        }

        @Override // c.a.e.e.r.g
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // c.a.e.e.r.g
        public void f(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            }
        }

        @Override // c.a.e.e.r.g
        public void g(int i2, c.a.e.e.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i2, cVar) == null) {
            }
        }

        @Override // c.a.e.e.r.g
        public void h(c.a.e.e.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            }
        }

        @Override // c.a.e.e.r.g
        public void i(c.a.e.e.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            }
        }

        @Override // c.a.e.e.r.g
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (this.f15018a.f15008a > 0) {
                        this.f15018a.f15016i = false;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("URL_");
                        stringBuffer.append(c.a.e.c.e.c.h.d());
                        if (this.f15018a.f15017j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.f15018a.f15017j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.f15018a.f15017j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.f15018a.f15017j.c());
                        }
                        c.a.e.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                    }
                } else if (this.f15018a.f15008a >= 5) {
                    c.a.e.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + c.a.e.c.e.c.h.d());
                    c.a.q0.t.j.a.f().l(c.a.e.c.e.c.h.d());
                    c.a.q0.t.j.a.f().k();
                }
                this.f15018a.f15008a = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BDHttpDns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f15019a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15019a = gVar;
        }

        @Override // com.baidu.bdhttpdns.BDHttpDns.a
        public void a(BDHttpDnsResult bDHttpDnsResult) {
            ArrayList<String> a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDHttpDnsResult) == null) {
                this.f15019a.f15016i = false;
                this.f15019a.f15017j = bDHttpDnsResult;
                if (bDHttpDnsResult == null || (a2 = bDHttpDnsResult.a()) == null || a2.isEmpty()) {
                    return;
                }
                synchronized (this.f15019a.f15014g) {
                    this.f15019a.f15015h = a2;
                }
                this.f15019a.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f15020a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f15021b;

        public c(g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15021b = gVar;
            this.f15020a = str;
        }

        @Override // c.a.q0.t.j.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15021b.f15009b = 0;
                this.f15021b.f15012e = c.a.q0.t.j.a.f().g();
                if (this.f15021b.f15012e != null) {
                    this.f15021b.A(this.f15020a);
                } else {
                    this.f15021b.f15013f = false;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f15022a;

        /* loaded from: classes3.dex */
        public class a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f15023a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15023a = dVar;
            }

            @Override // c.a.q0.t.j.a.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f15023a.f15022a.f15009b = 0;
                    this.f15023a.f15022a.f15012e = c.a.q0.t.j.a.f().g();
                    if (this.f15023a.f15022a.f15012e != null) {
                        this.f15023a.f15022a.A("change ip to reconnect with DNS' failed.");
                    } else {
                        this.f15023a.f15022a.f15013f = false;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15022a = gVar;
        }

        @Override // c.a.q0.t.j.d.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.q0.t.j.b.e().a(z ? 2 : 1);
                if (z) {
                    this.f15022a.f15012e = c.a.q0.t.j.a.f().g();
                    if (this.f15022a.f15012e != null) {
                        this.f15022a.A("change ip to reconnect with DNS' failed.");
                        return;
                    } else {
                        c.a.q0.t.j.a.f().m(new a(this));
                        return;
                    }
                }
                this.f15022a.f15013f = false;
                this.f15022a.D();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1672473278, "Lc/a/q0/t/j/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1672473278, "Lc/a/q0/t/j/g;");
        }
    }

    public g() {
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
        this.f15009b = 0;
        this.f15010c = false;
        this.f15011d = false;
        this.f15012e = null;
        this.f15013f = false;
        this.f15014g = new Object();
        this.f15015h = new ArrayList();
        this.f15016i = false;
        this.f15017j = null;
        this.k = new a(this);
    }

    public static /* synthetic */ int d(g gVar) {
        int i2 = gVar.f15008a;
        gVar.f15008a = i2 + 1;
        return i2;
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
                if (!c.a.q0.t.j.a.f().i()) {
                    c.a.q0.t.j.a.f().m(new c(this, str));
                }
                c.a.e.c.e.c.h.h(TiebaIMConfig.url);
                BdSocketLinkService.setAvailable(false);
                D();
            } else if (u(x) == null) {
                D();
            } else {
                this.f15013f = false;
                BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
                c.a.e.c.e.c.h.h(x);
                BdSocketLinkService.init();
                BdSocketLinkService.startService(true, str);
                this.f15010c = true;
                this.f15009b++;
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NoNetworkView.updateUI();
            this.f15009b = 0;
            this.f15016i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f15013f) {
            return;
        }
        this.f15013f = true;
        if (this.f15010c) {
            this.f15010c = false;
            c.a.q0.t.j.b.e().d(TiebaIMConfig.url);
        }
        c.a.q0.t.j.b.e().b();
        if (!this.f15011d) {
            new c.a.q0.t.j.d("www.baidu.com", new d(this));
            this.f15011d = true;
            return;
        }
        A("change ip to reconnect with DNS' failed.");
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NoNetworkView.updateUI();
            this.f15011d = false;
            this.f15009b = 0;
            this.f15013f = false;
            this.f15010c = false;
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f15014g) {
                if (this.f15015h != null && !this.f15015h.isEmpty()) {
                    String remove = this.f15015h.remove(0);
                    if (!TextUtils.isEmpty(remove)) {
                        c.a.e.c.e.c.h.h("ws://" + remove + ":" + v(TiebaIMConfig.url));
                        BdSocketLinkService.init();
                    }
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f15016i) {
            return;
        }
        try {
            String u = u(TiebaIMConfig.url);
            if (c.a.e.e.p.k.isEmpty(u)) {
                B();
                return;
            }
            this.f15016i = true;
            BDHttpDns.j(BdBaseApplication.getInst().getApplicationContext()).c(u, new b(this));
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final String x() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<String> list = this.f15012e;
            if (list == null || (i2 = this.f15009b) <= -1 || i2 >= list.size()) {
                return null;
            }
            return c.a.q0.t.j.a.f().g().get(this.f15009b);
        }
        return (String) invokeV.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.e.e.r.h.j().c(this.k);
        }
    }
}
