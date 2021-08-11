package c.a.u.a.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f29816a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f29817b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f29818c;

    /* renamed from: d  reason: collision with root package name */
    public static int f29819d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.u.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1391a implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C1391a f29820a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.u.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1392a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f29821e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f29822f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f29823g;

            /* renamed from: c.a.u.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C1393a extends TimerTask {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f29824e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ RunnableC1392a f29825f;

                public C1393a(RunnableC1392a runnableC1392a, AtomicBoolean atomicBoolean) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC1392a, atomicBoolean};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29825f = runnableC1392a;
                    this.f29824e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        c.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                        d dVar = this.f29825f.f29823g;
                        if (dVar != null) {
                            dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                            a.f(true);
                            b c2 = a.c(a.f29817b);
                            RunnableC1392a runnableC1392a = this.f29825f;
                            c2.b(runnableC1392a.f29821e, runnableC1392a.f29823g);
                        }
                        this.f29824e.set(true);
                    }
                }
            }

            public RunnableC1392a(C1391a c1391a, String str, Timer timer, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1391a, str, timer, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f29821e = str;
                this.f29822f = timer;
                this.f29823g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.u.a.h.e.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f29821e);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    this.f29822f.schedule(new C1393a(this, atomicBoolean), 10000L);
                    DnsHelper dnsHelper = new DnsHelper(a.f29817b);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    a.j(dnsHelper.getIpList(this.f29821e));
                    List<String> list = a.f29818c;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    c.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f29818c);
                    String str = a.f29818c.get(0);
                    if (this.f29823g != null && !atomicBoolean.get()) {
                        this.f29823g.a(0, "ok", str);
                        if (a.f29818c.size() > 1) {
                            a.f29819d++;
                            a.f(false);
                        }
                    }
                    c.a.u.a.h.e.a("DNSUrlProvider", "bddns > return ip = " + str);
                    this.f29822f.cancel();
                }
            }
        }

        public C1391a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Context unused = a.f29817b = context.getApplicationContext();
            a.i();
        }

        public static synchronized C1391a c(Context context) {
            InterceptResult invokeL;
            C1391a c1391a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (C1391a.class) {
                    if (f29820a == null) {
                        f29820a = new C1391a(context);
                    }
                    c1391a = f29820a;
                }
                return c1391a;
            }
            return (C1391a) invokeL.objValue;
        }

        @Override // c.a.u.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // c.a.u.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                try {
                    c.a.u.a.h.e.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                    if (a.f29818c != null && a.f29818c.size() > 0) {
                        if (a.f29819d < a.f29818c.size()) {
                            if (dVar != null) {
                                dVar.a(0, "ok", a.f29818c.get(a.f29819d));
                                c.a.u.a.h.e.a("DNSUrlProvider", "retry bddns > return ip = " + a.f29818c.get(a.f29819d));
                            }
                            a.f29819d++;
                            return;
                        }
                        a.f(true);
                        a.c(a.f29817b).b(str, dVar);
                        return;
                    }
                    c.a.u.a.g.a.a(a.f29817b).b(new RunnableC1392a(this, str, new Timer(), dVar));
                } catch (Throwable unused) {
                    c.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                    a.f(true);
                    a.c(a.f29817b).b(str, dVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(String str, boolean z);

        void b(String str, d dVar);
    }

    /* loaded from: classes4.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static c f29826a;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static synchronized b c() {
            InterceptResult invokeV;
            c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                synchronized (c.class) {
                    if (f29826a == null) {
                        f29826a = new c();
                    }
                    cVar = f29826a;
                }
                return cVar;
            }
            return (b) invokeV.objValue;
        }

        @Override // c.a.u.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // c.a.u.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                c.a.u.a.h.e.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
                if (dVar != null) {
                    a.i();
                    dVar.a(0, "ok", str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i2, String str, String str2);
    }

    /* loaded from: classes4.dex */
    public static class e implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static e f29827a;
        public transient /* synthetic */ FieldHolder $fh;

        public e(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Context unused = a.f29817b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            InterceptResult invokeL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (e.class) {
                    if (f29827a == null) {
                        f29827a = new e(context);
                    }
                    eVar = f29827a;
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        @Override // c.a.u.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // c.a.u.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                c.a.u.a.h.e.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
                try {
                    c.a.u.a.f.d dVar2 = new c.a.u.a.f.d(a.f29817b);
                    dVar2.a(dVar);
                    c.a.u.a.f.c.e(dVar2, dVar2);
                } catch (Exception unused) {
                    a.f(true);
                    a.c(a.f29817b).b(str, dVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1083017644, "Lc/a/u/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1083017644, "Lc/a/u/a/c/a;");
                return;
            }
        }
        f29818c = Collections.synchronizedList(new ArrayList());
        f29819d = 0;
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            f29817b = context.getApplicationContext();
            int a2 = c.a.u.a.h.c.a(context);
            if (a2 != 1 && a2 != 2) {
                if (c.a.u.a.h.f.c(context) && f29816a == 2) {
                    return C1391a.c(context);
                }
                if (f29816a == 3) {
                    return e.c(context);
                }
                return c.c();
            }
            f29816a = 0;
            return c.c();
        }
        return (b) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            List<String> list = f29818c;
            return list != null && f29819d <= list.size();
        }
        return invokeV.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (str == null || str.isEmpty()) {
                return false;
            }
            return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
        }
        return invokeL.booleanValue;
    }

    public static int f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, null, z)) == null) {
            if (z) {
                int a2 = c.a.u.a.h.c.a(f29817b);
                if (a2 != 1 && a2 != 2) {
                    int i2 = f29816a;
                    if (i2 == 0) {
                        f29816a = 2;
                    } else if (i2 == 2) {
                        f29816a = 3;
                    } else if (i2 == 3) {
                        f29816a = 0;
                    }
                } else {
                    f29816a = 0;
                }
            }
            c.a.u.a.h.e.a("DNSUrlProvider", "try to connect ip, now policy =" + f29816a);
            return f29816a;
        }
        return invokeZ.intValue;
    }

    public static void g(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            h(context, str, true);
        }
    }

    public static void h(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65544, null, context, str, z) == null) {
            i();
            c.c().a(str, true);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            try {
                f29819d = 0;
                f29818c.clear();
                f29816a = 3;
            } catch (Exception e2) {
                c.a.u.a.h.e.c("DNSUrlProvider", "resetBdDns exception", e2);
            }
        }
    }

    public static void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            f29818c.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (e(list.get(i2))) {
                        arrayList.add(list.get(i2));
                    } else {
                        arrayList2.add(list.get(i2));
                    }
                }
            }
            if (arrayList.size() + arrayList2.size() > 0) {
                int f2 = c.a.u.a.h.f.f(f29817b);
                c.a.u.a.h.e.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
                if (f2 == 1) {
                    f29818c.addAll(arrayList2);
                } else if (f2 == 2) {
                    f29818c.addAll(arrayList2);
                    f29818c.addAll(arrayList);
                } else if (f2 != 4) {
                    f29818c.addAll(arrayList);
                    f29818c.addAll(arrayList2);
                } else {
                    f29818c.addAll(arrayList);
                }
            }
        }
    }
}
