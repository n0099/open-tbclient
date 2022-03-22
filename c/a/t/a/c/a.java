package c.a.t.a.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f21272b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f21273c;

    /* renamed from: d  reason: collision with root package name */
    public static int f21274d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.t.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1578a implements b {
        public static /* synthetic */ Interceptable $ic;
        public static C1578a a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.t.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1579a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Timer f21275b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f21276c;

            /* renamed from: c.a.t.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C1580a extends TimerTask {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AtomicBoolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ RunnableC1579a f21277b;

                public C1580a(RunnableC1579a runnableC1579a, AtomicBoolean atomicBoolean) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC1579a, atomicBoolean};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f21277b = runnableC1579a;
                    this.a = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        c.a.t.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                        d dVar = this.f21277b.f21276c;
                        if (dVar != null) {
                            dVar.a(w0.i4, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                            a.f(true);
                            b c2 = a.c(a.f21272b);
                            RunnableC1579a runnableC1579a = this.f21277b;
                            c2.b(runnableC1579a.a, runnableC1579a.f21276c);
                        }
                        this.a.set(true);
                    }
                }
            }

            public RunnableC1579a(C1578a c1578a, String str, Timer timer, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1578a, str, timer, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.f21275b = timer;
                this.f21276c = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.t.a.h.e.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.a);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    this.f21275b.schedule(new C1580a(this, atomicBoolean), 10000L);
                    DnsHelper dnsHelper = new DnsHelper(a.f21272b);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    a.j(dnsHelper.getIpList(this.a));
                    List<String> list = a.f21273c;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    c.a.t.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f21273c);
                    String str = a.f21273c.get(0);
                    if (this.f21276c != null && !atomicBoolean.get()) {
                        this.f21276c.a(0, "ok", str);
                        if (a.f21273c.size() > 1) {
                            a.f21274d++;
                            a.f(false);
                        }
                    }
                    c.a.t.a.h.e.a("DNSUrlProvider", "bddns > return ip = " + str);
                    this.f21275b.cancel();
                }
            }
        }

        public C1578a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Context unused = a.f21272b = context.getApplicationContext();
            a.i();
        }

        public static synchronized C1578a c(Context context) {
            InterceptResult invokeL;
            C1578a c1578a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (C1578a.class) {
                    if (a == null) {
                        a = new C1578a(context);
                    }
                    c1578a = a;
                }
                return c1578a;
            }
            return (C1578a) invokeL.objValue;
        }

        @Override // c.a.t.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // c.a.t.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                try {
                    c.a.t.a.h.e.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                    if (a.f21273c != null && a.f21273c.size() > 0) {
                        if (a.f21274d < a.f21273c.size()) {
                            if (dVar != null) {
                                dVar.a(0, "ok", a.f21273c.get(a.f21274d));
                                c.a.t.a.h.e.a("DNSUrlProvider", "retry bddns > return ip = " + a.f21273c.get(a.f21274d));
                            }
                            a.f21274d++;
                            return;
                        }
                        a.f(true);
                        a.c(a.f21272b).b(str, dVar);
                        return;
                    }
                    c.a.t.a.g.a.a(a.f21272b).b(new RunnableC1579a(this, str, new Timer(), dVar));
                } catch (Throwable unused) {
                    c.a.t.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                    a.f(true);
                    a.c(a.f21272b).b(str, dVar);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str, boolean z);

        void b(String str, d dVar);
    }

    /* loaded from: classes3.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public static c a;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    if (a == null) {
                        a = new c();
                    }
                    cVar = a;
                }
                return cVar;
            }
            return (b) invokeV.objValue;
        }

        @Override // c.a.t.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // c.a.t.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                c.a.t.a.h.e.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
                if (dVar != null) {
                    a.i();
                    dVar.a(0, "ok", str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i, String str, String str2);
    }

    /* loaded from: classes3.dex */
    public static class e implements b {
        public static /* synthetic */ Interceptable $ic;
        public static e a;
        public transient /* synthetic */ FieldHolder $fh;

        public e(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Context unused = a.f21272b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            InterceptResult invokeL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (e.class) {
                    if (a == null) {
                        a = new e(context);
                    }
                    eVar = a;
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        @Override // c.a.t.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // c.a.t.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                c.a.t.a.h.e.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
                try {
                    c.a.t.a.f.d dVar2 = new c.a.t.a.f.d(a.f21272b);
                    dVar2.a(dVar);
                    c.a.t.a.f.c.e(dVar2, dVar2);
                } catch (Exception unused) {
                    a.f(true);
                    a.c(a.f21272b).b(str, dVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1469139317, "Lc/a/t/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1469139317, "Lc/a/t/a/c/a;");
                return;
            }
        }
        f21273c = Collections.synchronizedList(new ArrayList());
        f21274d = 0;
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            f21272b = context.getApplicationContext();
            int a2 = c.a.t.a.h.c.a(context);
            if (a2 != 1 && a2 != 2) {
                if (c.a.t.a.h.f.c(context) && a == 2) {
                    return C1578a.c(context);
                }
                if (a == 3) {
                    return e.c(context);
                }
                return c.c();
            }
            a = 0;
            return c.c();
        }
        return (b) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            List<String> list = f21273c;
            return list != null && f21274d <= list.size();
        }
        return invokeV.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
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
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65542, null, z)) == null) {
            if (z) {
                int a2 = c.a.t.a.h.c.a(f21272b);
                if (a2 != 1 && a2 != 2) {
                    int i = a;
                    if (i == 0) {
                        a = 2;
                    } else if (i == 2) {
                        a = 3;
                    } else if (i == 3) {
                        a = 0;
                    }
                } else {
                    a = 0;
                }
            }
            c.a.t.a.h.e.a("DNSUrlProvider", "try to connect ip, now policy =" + a);
            return a;
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
                f21274d = 0;
                f21273c.clear();
                a = 3;
            } catch (Exception e2) {
                c.a.t.a.h.e.c("DNSUrlProvider", "resetBdDns exception", e2);
            }
        }
    }

    public static void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            f21273c.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    if (e(list.get(i))) {
                        arrayList.add(list.get(i));
                    } else {
                        arrayList2.add(list.get(i));
                    }
                }
            }
            if (arrayList.size() + arrayList2.size() > 0) {
                int f2 = c.a.t.a.h.f.f(f21272b);
                c.a.t.a.h.e.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
                if (f2 == 1) {
                    f21273c.addAll(arrayList2);
                } else if (f2 == 2) {
                    f21273c.addAll(arrayList2);
                    f21273c.addAll(arrayList);
                } else if (f2 != 4) {
                    f21273c.addAll(arrayList);
                    f21273c.addAll(arrayList2);
                } else {
                    f21273c.addAll(arrayList);
                }
            }
        }
    }
}
