package c.a.u.a.c;

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
    public static Context f26239b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f26240c;

    /* renamed from: d  reason: collision with root package name */
    public static int f26241d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.u.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1581a implements b {
        public static /* synthetic */ Interceptable $ic;
        public static C1581a a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.u.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1582a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f26242e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f26243f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f26244g;

            /* renamed from: c.a.u.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C1583a extends TimerTask {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f26245e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ RunnableC1582a f26246f;

                public C1583a(RunnableC1582a runnableC1582a, AtomicBoolean atomicBoolean) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC1582a, atomicBoolean};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26246f = runnableC1582a;
                    this.f26245e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        c.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                        d dVar = this.f26246f.f26244g;
                        if (dVar != null) {
                            dVar.a(w0.i4, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                            a.f(true);
                            b c2 = a.c(a.f26239b);
                            RunnableC1582a runnableC1582a = this.f26246f;
                            c2.b(runnableC1582a.f26242e, runnableC1582a.f26244g);
                        }
                        this.f26245e.set(true);
                    }
                }
            }

            public RunnableC1582a(C1581a c1581a, String str, Timer timer, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1581a, str, timer, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26242e = str;
                this.f26243f = timer;
                this.f26244g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.u.a.h.e.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f26242e);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    this.f26243f.schedule(new C1583a(this, atomicBoolean), 10000L);
                    DnsHelper dnsHelper = new DnsHelper(a.f26239b);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    a.j(dnsHelper.getIpList(this.f26242e));
                    List<String> list = a.f26240c;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    c.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f26240c);
                    String str = a.f26240c.get(0);
                    if (this.f26244g != null && !atomicBoolean.get()) {
                        this.f26244g.a(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, str);
                        if (a.f26240c.size() > 1) {
                            a.f26241d++;
                            a.f(false);
                        }
                    }
                    c.a.u.a.h.e.a("DNSUrlProvider", "bddns > return ip = " + str);
                    this.f26243f.cancel();
                }
            }
        }

        public C1581a(Context context) {
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
            Context unused = a.f26239b = context.getApplicationContext();
            a.i();
        }

        public static synchronized C1581a c(Context context) {
            InterceptResult invokeL;
            C1581a c1581a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (C1581a.class) {
                    if (a == null) {
                        a = new C1581a(context);
                    }
                    c1581a = a;
                }
                return c1581a;
            }
            return (C1581a) invokeL.objValue;
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
                    if (a.f26240c != null && a.f26240c.size() > 0) {
                        if (a.f26241d < a.f26240c.size()) {
                            if (dVar != null) {
                                dVar.a(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, a.f26240c.get(a.f26241d));
                                c.a.u.a.h.e.a("DNSUrlProvider", "retry bddns > return ip = " + a.f26240c.get(a.f26241d));
                            }
                            a.f26241d++;
                            return;
                        }
                        a.f(true);
                        a.c(a.f26239b).b(str, dVar);
                        return;
                    }
                    c.a.u.a.g.a.a(a.f26239b).b(new RunnableC1582a(this, str, new Timer(), dVar));
                } catch (Throwable unused) {
                    c.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                    a.f(true);
                    a.c(a.f26239b).b(str, dVar);
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
            Context unused = a.f26239b = context.getApplicationContext();
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
                    c.a.u.a.f.d dVar2 = new c.a.u.a.f.d(a.f26239b);
                    dVar2.a(dVar);
                    c.a.u.a.f.c.e(dVar2, dVar2);
                } catch (Exception unused) {
                    a.f(true);
                    a.c(a.f26239b).b(str, dVar);
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
        f26240c = Collections.synchronizedList(new ArrayList());
        f26241d = 0;
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            f26239b = context.getApplicationContext();
            int a2 = c.a.u.a.h.c.a(context);
            if (a2 != 1 && a2 != 2) {
                if (c.a.u.a.h.f.c(context) && a == 2) {
                    return C1581a.c(context);
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
            List<String> list = f26240c;
            return list != null && f26241d <= list.size();
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
                int a2 = c.a.u.a.h.c.a(f26239b);
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
            c.a.u.a.h.e.a("DNSUrlProvider", "try to connect ip, now policy =" + a);
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
                f26241d = 0;
                f26240c.clear();
                a = 3;
            } catch (Exception e2) {
                c.a.u.a.h.e.c("DNSUrlProvider", "resetBdDns exception", e2);
            }
        }
    }

    public static void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            f26240c.clear();
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
                int f2 = c.a.u.a.h.f.f(f26239b);
                c.a.u.a.h.e.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
                if (f2 == 1) {
                    f26240c.addAll(arrayList2);
                } else if (f2 == 2) {
                    f26240c.addAll(arrayList2);
                    f26240c.addAll(arrayList);
                } else if (f2 != 4) {
                    f26240c.addAll(arrayList);
                    f26240c.addAll(arrayList2);
                } else {
                    f26240c.addAll(arrayList);
                }
            }
        }
    }
}
