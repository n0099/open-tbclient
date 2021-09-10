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
    public static int f30172a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f30173b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f30174c;

    /* renamed from: d  reason: collision with root package name */
    public static int f30175d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.u.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1397a implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C1397a f30176a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.u.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1398a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f30177e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f30178f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f30179g;

            /* renamed from: c.a.u.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C1399a extends TimerTask {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f30180e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ RunnableC1398a f30181f;

                public C1399a(RunnableC1398a runnableC1398a, AtomicBoolean atomicBoolean) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC1398a, atomicBoolean};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30181f = runnableC1398a;
                    this.f30180e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        c.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                        d dVar = this.f30181f.f30179g;
                        if (dVar != null) {
                            dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                            a.f(true);
                            b c2 = a.c(a.f30173b);
                            RunnableC1398a runnableC1398a = this.f30181f;
                            c2.b(runnableC1398a.f30177e, runnableC1398a.f30179g);
                        }
                        this.f30180e.set(true);
                    }
                }
            }

            public RunnableC1398a(C1397a c1397a, String str, Timer timer, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1397a, str, timer, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f30177e = str;
                this.f30178f = timer;
                this.f30179g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.u.a.h.e.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f30177e);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    this.f30178f.schedule(new C1399a(this, atomicBoolean), 10000L);
                    DnsHelper dnsHelper = new DnsHelper(a.f30173b);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    a.j(dnsHelper.getIpList(this.f30177e));
                    List<String> list = a.f30174c;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    c.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f30174c);
                    String str = a.f30174c.get(0);
                    if (this.f30179g != null && !atomicBoolean.get()) {
                        this.f30179g.a(0, "ok", str);
                        if (a.f30174c.size() > 1) {
                            a.f30175d++;
                            a.f(false);
                        }
                    }
                    c.a.u.a.h.e.a("DNSUrlProvider", "bddns > return ip = " + str);
                    this.f30178f.cancel();
                }
            }
        }

        public C1397a(Context context) {
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
            Context unused = a.f30173b = context.getApplicationContext();
            a.i();
        }

        public static synchronized C1397a c(Context context) {
            InterceptResult invokeL;
            C1397a c1397a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (C1397a.class) {
                    if (f30176a == null) {
                        f30176a = new C1397a(context);
                    }
                    c1397a = f30176a;
                }
                return c1397a;
            }
            return (C1397a) invokeL.objValue;
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
                    if (a.f30174c != null && a.f30174c.size() > 0) {
                        if (a.f30175d < a.f30174c.size()) {
                            if (dVar != null) {
                                dVar.a(0, "ok", a.f30174c.get(a.f30175d));
                                c.a.u.a.h.e.a("DNSUrlProvider", "retry bddns > return ip = " + a.f30174c.get(a.f30175d));
                            }
                            a.f30175d++;
                            return;
                        }
                        a.f(true);
                        a.c(a.f30173b).b(str, dVar);
                        return;
                    }
                    c.a.u.a.g.a.a(a.f30173b).b(new RunnableC1398a(this, str, new Timer(), dVar));
                } catch (Throwable unused) {
                    c.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                    a.f(true);
                    a.c(a.f30173b).b(str, dVar);
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
        public static c f30182a;
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
                    if (f30182a == null) {
                        f30182a = new c();
                    }
                    cVar = f30182a;
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
        public static e f30183a;
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
            Context unused = a.f30173b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            InterceptResult invokeL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (e.class) {
                    if (f30183a == null) {
                        f30183a = new e(context);
                    }
                    eVar = f30183a;
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
                    c.a.u.a.f.d dVar2 = new c.a.u.a.f.d(a.f30173b);
                    dVar2.a(dVar);
                    c.a.u.a.f.c.e(dVar2, dVar2);
                } catch (Exception unused) {
                    a.f(true);
                    a.c(a.f30173b).b(str, dVar);
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
        f30174c = Collections.synchronizedList(new ArrayList());
        f30175d = 0;
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            f30173b = context.getApplicationContext();
            int a2 = c.a.u.a.h.c.a(context);
            if (a2 != 1 && a2 != 2) {
                if (c.a.u.a.h.f.c(context) && f30172a == 2) {
                    return C1397a.c(context);
                }
                if (f30172a == 3) {
                    return e.c(context);
                }
                return c.c();
            }
            f30172a = 0;
            return c.c();
        }
        return (b) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            List<String> list = f30174c;
            return list != null && f30175d <= list.size();
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
                int a2 = c.a.u.a.h.c.a(f30173b);
                if (a2 != 1 && a2 != 2) {
                    int i2 = f30172a;
                    if (i2 == 0) {
                        f30172a = 2;
                    } else if (i2 == 2) {
                        f30172a = 3;
                    } else if (i2 == 3) {
                        f30172a = 0;
                    }
                } else {
                    f30172a = 0;
                }
            }
            c.a.u.a.h.e.a("DNSUrlProvider", "try to connect ip, now policy =" + f30172a);
            return f30172a;
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
                f30175d = 0;
                f30174c.clear();
                f30172a = 3;
            } catch (Exception e2) {
                c.a.u.a.h.e.c("DNSUrlProvider", "resetBdDns exception", e2);
            }
        }
    }

    public static void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            f30174c.clear();
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
                int f2 = c.a.u.a.h.f.f(f30173b);
                c.a.u.a.h.e.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
                if (f2 == 1) {
                    f30174c.addAll(arrayList2);
                } else if (f2 == 2) {
                    f30174c.addAll(arrayList2);
                    f30174c.addAll(arrayList);
                } else if (f2 != 4) {
                    f30174c.addAll(arrayList);
                    f30174c.addAll(arrayList2);
                } else {
                    f30174c.addAll(arrayList);
                }
            }
        }
    }
}
