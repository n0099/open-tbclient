package b.a.q0.t.j;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.j;
import b.a.e.f.r.k;
import b.a.q0.t.j.a;
import b.a.q0.t.j.d;
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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static g l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14864a;

    /* renamed from: b  reason: collision with root package name */
    public int f14865b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14866c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14867d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f14868e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14869f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f14870g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f14871h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14872i;
    public BDHttpDnsResult j;
    public final b.a.e.f.r.g k;

    /* loaded from: classes4.dex */
    public class a implements b.a.e.f.r.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f14873a;

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
            this.f14873a = gVar;
        }

        @Override // b.a.e.f.r.g
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // b.a.e.f.r.g
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if ((i2 == 2 || i2 == 9) && j.z()) {
                    g.d(this.f14873a);
                    if (UseHttpdnsSdkSwitch.isOn()) {
                        if (this.f14873a.f14871h == null || this.f14873a.f14871h.isEmpty()) {
                            this.f14873a.w();
                        } else {
                            this.f14873a.a();
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("retryiplist_");
                        stringBuffer.append(b.a.e.c.e.c.h.d());
                        if (this.f14873a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.f14873a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.f14873a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.f14873a.j.c());
                        }
                        b.a.e.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                        if (this.f14873a.f14864a >= 5) {
                            BdSocketLinkService.setAvailable(false);
                            this.f14873a.B();
                        }
                    } else if (this.f14873a.f14864a >= 5) {
                        b.a.e.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + b.a.e.c.e.c.h.d());
                        this.f14873a.C();
                    }
                }
            }
        }

        @Override // b.a.e.f.r.g
        public void c(b.a.e.f.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            }
        }

        @Override // b.a.e.f.r.g
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            }
        }

        @Override // b.a.e.f.r.g
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // b.a.e.f.r.g
        public void f(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            }
        }

        @Override // b.a.e.f.r.g
        public void g(int i2, b.a.e.f.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i2, cVar) == null) {
            }
        }

        @Override // b.a.e.f.r.g
        public void h(b.a.e.f.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            }
        }

        @Override // b.a.e.f.r.g
        public void i(b.a.e.f.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            }
        }

        @Override // b.a.e.f.r.g
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (this.f14873a.f14864a > 0) {
                        this.f14873a.f14872i = false;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("URL_");
                        stringBuffer.append(b.a.e.c.e.c.h.d());
                        if (this.f14873a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.f14873a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.f14873a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.f14873a.j.c());
                        }
                        b.a.e.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                    }
                } else if (this.f14873a.f14864a >= 5) {
                    b.a.e.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + b.a.e.c.e.c.h.d());
                    b.a.q0.t.j.a.f().l(b.a.e.c.e.c.h.d());
                    b.a.q0.t.j.a.f().k();
                }
                this.f14873a.f14864a = 0;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BDHttpDns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f14874a;

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
            this.f14874a = gVar;
        }

        @Override // com.baidu.bdhttpdns.BDHttpDns.a
        public void a(BDHttpDnsResult bDHttpDnsResult) {
            ArrayList<String> a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDHttpDnsResult) == null) {
                this.f14874a.f14872i = false;
                this.f14874a.j = bDHttpDnsResult;
                if (bDHttpDnsResult == null || (a2 = bDHttpDnsResult.a()) == null || a2.isEmpty()) {
                    return;
                }
                synchronized (this.f14874a.f14870g) {
                    this.f14874a.f14871h = a2;
                }
                this.f14874a.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f14875a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f14876b;

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
            this.f14876b = gVar;
            this.f14875a = str;
        }

        @Override // b.a.q0.t.j.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14876b.f14865b = 0;
                this.f14876b.f14868e = b.a.q0.t.j.a.f().g();
                if (this.f14876b.f14868e != null) {
                    this.f14876b.A(this.f14875a);
                } else {
                    this.f14876b.f14869f = false;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f14877a;

        /* loaded from: classes4.dex */
        public class a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f14878a;

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
                this.f14878a = dVar;
            }

            @Override // b.a.q0.t.j.a.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f14878a.f14877a.f14865b = 0;
                    this.f14878a.f14877a.f14868e = b.a.q0.t.j.a.f().g();
                    if (this.f14878a.f14877a.f14868e != null) {
                        this.f14878a.f14877a.A("change ip to reconnect with DNS' failed.");
                    } else {
                        this.f14878a.f14877a.f14869f = false;
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
            this.f14877a = gVar;
        }

        @Override // b.a.q0.t.j.d.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                b.a.q0.t.j.b.e().a(z ? 2 : 1);
                if (z) {
                    this.f14877a.f14868e = b.a.q0.t.j.a.f().g();
                    if (this.f14877a.f14868e != null) {
                        this.f14877a.A("change ip to reconnect with DNS' failed.");
                        return;
                    } else {
                        b.a.q0.t.j.a.f().m(new a(this));
                        return;
                    }
                }
                this.f14877a.f14869f = false;
                this.f14877a.D();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1965876285, "Lb/a/q0/t/j/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1965876285, "Lb/a/q0/t/j/g;");
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
        this.f14865b = 0;
        this.f14866c = false;
        this.f14867d = false;
        this.f14868e = null;
        this.f14869f = false;
        this.f14870g = new Object();
        this.f14871h = new ArrayList();
        this.f14872i = false;
        this.j = null;
        this.k = new a(this);
    }

    public static /* synthetic */ int d(g gVar) {
        int i2 = gVar.f14864a;
        gVar.f14864a = i2 + 1;
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
                if (!b.a.q0.t.j.a.f().i()) {
                    b.a.q0.t.j.a.f().m(new c(this, str));
                }
                b.a.e.c.e.c.h.h(TiebaIMConfig.url);
                BdSocketLinkService.setAvailable(false);
                D();
            } else if (u(x) == null) {
                D();
            } else {
                this.f14869f = false;
                BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
                b.a.e.c.e.c.h.h(x);
                BdSocketLinkService.init();
                BdSocketLinkService.startService(true, str);
                this.f14866c = true;
                this.f14865b++;
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NoNetworkView.updateUI();
            this.f14865b = 0;
            this.f14872i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f14869f) {
            return;
        }
        this.f14869f = true;
        if (this.f14866c) {
            this.f14866c = false;
            b.a.q0.t.j.b.e().d(TiebaIMConfig.url);
        }
        b.a.q0.t.j.b.e().b();
        if (!this.f14867d) {
            new b.a.q0.t.j.d("www.baidu.com", new d(this));
            this.f14867d = true;
            return;
        }
        A("change ip to reconnect with DNS' failed.");
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NoNetworkView.updateUI();
            this.f14867d = false;
            this.f14865b = 0;
            this.f14869f = false;
            this.f14866c = false;
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f14870g) {
                if (this.f14871h != null && !this.f14871h.isEmpty()) {
                    String remove = this.f14871h.remove(0);
                    if (!TextUtils.isEmpty(remove)) {
                        b.a.e.c.e.c.h.h("ws://" + remove + ":" + v(TiebaIMConfig.url));
                        BdSocketLinkService.init();
                    }
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f14872i) {
            return;
        }
        try {
            String u = u(TiebaIMConfig.url);
            if (b.a.e.f.p.k.isEmpty(u)) {
                B();
                return;
            }
            this.f14872i = true;
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
            List<String> list = this.f14868e;
            if (list == null || (i2 = this.f14865b) <= -1 || i2 >= list.size()) {
                return null;
            }
            return b.a.q0.t.j.a.f().g().get(this.f14865b);
        }
        return (String) invokeV.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.e.f.r.h.j().c(this.k);
        }
    }
}
