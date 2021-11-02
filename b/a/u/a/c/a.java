package b.a.u.a.c;

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
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f28968a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f28969b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f28970c;

    /* renamed from: d  reason: collision with root package name */
    public static int f28971d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.u.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1398a implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C1398a f28972a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b.a.u.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1399a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f28973e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f28974f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f28975g;

            /* renamed from: b.a.u.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C1400a extends TimerTask {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f28976e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ RunnableC1399a f28977f;

                public C1400a(RunnableC1399a runnableC1399a, AtomicBoolean atomicBoolean) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC1399a, atomicBoolean};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f28977f = runnableC1399a;
                    this.f28976e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        b.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                        d dVar = this.f28977f.f28975g;
                        if (dVar != null) {
                            dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                            a.f(true);
                            b c2 = a.c(a.f28969b);
                            RunnableC1399a runnableC1399a = this.f28977f;
                            c2.b(runnableC1399a.f28973e, runnableC1399a.f28975g);
                        }
                        this.f28976e.set(true);
                    }
                }
            }

            public RunnableC1399a(C1398a c1398a, String str, Timer timer, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1398a, str, timer, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28973e = str;
                this.f28974f = timer;
                this.f28975g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.u.a.h.e.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f28973e);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    this.f28974f.schedule(new C1400a(this, atomicBoolean), 10000L);
                    DnsHelper dnsHelper = new DnsHelper(a.f28969b);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    a.j(dnsHelper.getIpList(this.f28973e));
                    List<String> list = a.f28970c;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    b.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f28970c);
                    String str = a.f28970c.get(0);
                    if (this.f28975g != null && !atomicBoolean.get()) {
                        this.f28975g.a(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, str);
                        if (a.f28970c.size() > 1) {
                            a.f28971d++;
                            a.f(false);
                        }
                    }
                    b.a.u.a.h.e.a("DNSUrlProvider", "bddns > return ip = " + str);
                    this.f28974f.cancel();
                }
            }
        }

        public C1398a(Context context) {
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
            Context unused = a.f28969b = context.getApplicationContext();
            a.i();
        }

        public static synchronized C1398a c(Context context) {
            InterceptResult invokeL;
            C1398a c1398a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (C1398a.class) {
                    if (f28972a == null) {
                        f28972a = new C1398a(context);
                    }
                    c1398a = f28972a;
                }
                return c1398a;
            }
            return (C1398a) invokeL.objValue;
        }

        @Override // b.a.u.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // b.a.u.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                try {
                    b.a.u.a.h.e.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                    if (a.f28970c != null && a.f28970c.size() > 0) {
                        if (a.f28971d < a.f28970c.size()) {
                            if (dVar != null) {
                                dVar.a(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, a.f28970c.get(a.f28971d));
                                b.a.u.a.h.e.a("DNSUrlProvider", "retry bddns > return ip = " + a.f28970c.get(a.f28971d));
                            }
                            a.f28971d++;
                            return;
                        }
                        a.f(true);
                        a.c(a.f28969b).b(str, dVar);
                        return;
                    }
                    b.a.u.a.g.a.a(a.f28969b).b(new RunnableC1399a(this, str, new Timer(), dVar));
                } catch (Throwable unused) {
                    b.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                    a.f(true);
                    a.c(a.f28969b).b(str, dVar);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(String str, boolean z);

        void b(String str, d dVar);
    }

    /* loaded from: classes6.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static c f28978a;
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
                    if (f28978a == null) {
                        f28978a = new c();
                    }
                    cVar = f28978a;
                }
                return cVar;
            }
            return (b) invokeV.objValue;
        }

        @Override // b.a.u.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // b.a.u.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                b.a.u.a.h.e.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
                if (dVar != null) {
                    a.i();
                    dVar.a(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(int i2, String str, String str2);
    }

    /* loaded from: classes6.dex */
    public static class e implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static e f28979a;
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
            Context unused = a.f28969b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            InterceptResult invokeL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (e.class) {
                    if (f28979a == null) {
                        f28979a = new e(context);
                    }
                    eVar = f28979a;
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        @Override // b.a.u.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // b.a.u.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                b.a.u.a.h.e.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
                try {
                    b.a.u.a.f.d dVar2 = new b.a.u.a.f.d(a.f28969b);
                    dVar2.a(dVar);
                    b.a.u.a.f.c.e(dVar2, dVar2);
                } catch (Exception unused) {
                    a.f(true);
                    a.c(a.f28969b).b(str, dVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1212100363, "Lb/a/u/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1212100363, "Lb/a/u/a/c/a;");
                return;
            }
        }
        f28970c = Collections.synchronizedList(new ArrayList());
        f28971d = 0;
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            f28969b = context.getApplicationContext();
            int a2 = b.a.u.a.h.c.a(context);
            if (a2 != 1 && a2 != 2) {
                if (b.a.u.a.h.f.c(context) && f28968a == 2) {
                    return C1398a.c(context);
                }
                if (f28968a == 3) {
                    return e.c(context);
                }
                return c.c();
            }
            f28968a = 0;
            return c.c();
        }
        return (b) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            List<String> list = f28970c;
            return list != null && f28971d <= list.size();
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
                int a2 = b.a.u.a.h.c.a(f28969b);
                if (a2 != 1 && a2 != 2) {
                    int i2 = f28968a;
                    if (i2 == 0) {
                        f28968a = 2;
                    } else if (i2 == 2) {
                        f28968a = 3;
                    } else if (i2 == 3) {
                        f28968a = 0;
                    }
                } else {
                    f28968a = 0;
                }
            }
            b.a.u.a.h.e.a("DNSUrlProvider", "try to connect ip, now policy =" + f28968a);
            return f28968a;
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
                f28971d = 0;
                f28970c.clear();
                f28968a = 3;
            } catch (Exception e2) {
                b.a.u.a.h.e.c("DNSUrlProvider", "resetBdDns exception", e2);
            }
        }
    }

    public static void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            f28970c.clear();
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
                int f2 = b.a.u.a.h.f.f(f28969b);
                b.a.u.a.h.e.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
                if (f2 == 1) {
                    f28970c.addAll(arrayList2);
                } else if (f2 == 2) {
                    f28970c.addAll(arrayList2);
                    f28970c.addAll(arrayList);
                } else if (f2 != 4) {
                    f28970c.addAll(arrayList);
                    f28970c.addAll(arrayList2);
                } else {
                    f28970c.addAll(arrayList);
                }
            }
        }
    }
}
