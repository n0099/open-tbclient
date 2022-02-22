package c.a.v.a.c;

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
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f26472b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f26473c;

    /* renamed from: d  reason: collision with root package name */
    public static int f26474d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.v.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1592a implements b {
        public static /* synthetic */ Interceptable $ic;
        public static C1592a a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.v.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1593a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f26475e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f26476f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f26477g;

            /* renamed from: c.a.v.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C1594a extends TimerTask {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f26478e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ RunnableC1593a f26479f;

                public C1594a(RunnableC1593a runnableC1593a, AtomicBoolean atomicBoolean) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC1593a, atomicBoolean};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26479f = runnableC1593a;
                    this.f26478e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        c.a.v.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                        d dVar = this.f26479f.f26477g;
                        if (dVar != null) {
                            dVar.a(w0.i4, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                            a.f(true);
                            b c2 = a.c(a.f26472b);
                            RunnableC1593a runnableC1593a = this.f26479f;
                            c2.b(runnableC1593a.f26475e, runnableC1593a.f26477g);
                        }
                        this.f26478e.set(true);
                    }
                }
            }

            public RunnableC1593a(C1592a c1592a, String str, Timer timer, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1592a, str, timer, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26475e = str;
                this.f26476f = timer;
                this.f26477g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.v.a.h.e.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f26475e);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    this.f26476f.schedule(new C1594a(this, atomicBoolean), 10000L);
                    DnsHelper dnsHelper = new DnsHelper(a.f26472b);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    a.j(dnsHelper.getIpList(this.f26475e));
                    List<String> list = a.f26473c;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    c.a.v.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f26473c);
                    String str = a.f26473c.get(0);
                    if (this.f26477g != null && !atomicBoolean.get()) {
                        this.f26477g.a(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, str);
                        if (a.f26473c.size() > 1) {
                            a.f26474d++;
                            a.f(false);
                        }
                    }
                    c.a.v.a.h.e.a("DNSUrlProvider", "bddns > return ip = " + str);
                    this.f26476f.cancel();
                }
            }
        }

        public C1592a(Context context) {
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
            Context unused = a.f26472b = context.getApplicationContext();
            a.i();
        }

        public static synchronized C1592a c(Context context) {
            InterceptResult invokeL;
            C1592a c1592a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (C1592a.class) {
                    if (a == null) {
                        a = new C1592a(context);
                    }
                    c1592a = a;
                }
                return c1592a;
            }
            return (C1592a) invokeL.objValue;
        }

        @Override // c.a.v.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // c.a.v.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                try {
                    c.a.v.a.h.e.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                    if (a.f26473c != null && a.f26473c.size() > 0) {
                        if (a.f26474d < a.f26473c.size()) {
                            if (dVar != null) {
                                dVar.a(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, a.f26473c.get(a.f26474d));
                                c.a.v.a.h.e.a("DNSUrlProvider", "retry bddns > return ip = " + a.f26473c.get(a.f26474d));
                            }
                            a.f26474d++;
                            return;
                        }
                        a.f(true);
                        a.c(a.f26472b).b(str, dVar);
                        return;
                    }
                    c.a.v.a.g.a.a(a.f26472b).b(new RunnableC1593a(this, str, new Timer(), dVar));
                } catch (Throwable unused) {
                    c.a.v.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                    a.f(true);
                    a.c(a.f26472b).b(str, dVar);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(String str, boolean z);

        void b(String str, d dVar);
    }

    /* loaded from: classes9.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public static c a;
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
                    if (a == null) {
                        a = new c();
                    }
                    cVar = a;
                }
                return cVar;
            }
            return (b) invokeV.objValue;
        }

        @Override // c.a.v.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // c.a.v.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                c.a.v.a.h.e.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
                if (dVar != null) {
                    a.i();
                    dVar.a(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, str);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a(int i2, String str, String str2);
    }

    /* loaded from: classes9.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Context unused = a.f26472b = context.getApplicationContext();
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

        @Override // c.a.v.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // c.a.v.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                c.a.v.a.h.e.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
                try {
                    c.a.v.a.f.d dVar2 = new c.a.v.a.f.d(a.f26472b);
                    dVar2.a(dVar);
                    c.a.v.a.f.c.e(dVar2, dVar2);
                } catch (Exception unused) {
                    a.f(true);
                    a.c(a.f26472b).b(str, dVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(659792691, "Lc/a/v/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(659792691, "Lc/a/v/a/c/a;");
                return;
            }
        }
        f26473c = Collections.synchronizedList(new ArrayList());
        f26474d = 0;
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            f26472b = context.getApplicationContext();
            int a2 = c.a.v.a.h.c.a(context);
            if (a2 != 1 && a2 != 2) {
                if (c.a.v.a.h.f.c(context) && a == 2) {
                    return C1592a.c(context);
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
            List<String> list = f26473c;
            return list != null && f26474d <= list.size();
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
                int a2 = c.a.v.a.h.c.a(f26472b);
                if (a2 != 1 && a2 != 2) {
                    int i2 = a;
                    if (i2 == 0) {
                        a = 2;
                    } else if (i2 == 2) {
                        a = 3;
                    } else if (i2 == 3) {
                        a = 0;
                    }
                } else {
                    a = 0;
                }
            }
            c.a.v.a.h.e.a("DNSUrlProvider", "try to connect ip, now policy =" + a);
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
                f26474d = 0;
                f26473c.clear();
                a = 3;
            } catch (Exception e2) {
                c.a.v.a.h.e.c("DNSUrlProvider", "resetBdDns exception", e2);
            }
        }
    }

    public static void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            f26473c.clear();
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
                int f2 = c.a.v.a.h.f.f(f26472b);
                c.a.v.a.h.e.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
                if (f2 == 1) {
                    f26473c.addAll(arrayList2);
                } else if (f2 == 2) {
                    f26473c.addAll(arrayList2);
                    f26473c.addAll(arrayList);
                } else if (f2 != 4) {
                    f26473c.addAll(arrayList);
                    f26473c.addAll(arrayList2);
                } else {
                    f26473c.addAll(arrayList);
                }
            }
        }
    }
}
