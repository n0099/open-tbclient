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
    public static int f29837a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f29838b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f29839c;

    /* renamed from: d  reason: collision with root package name */
    public static int f29840d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.u.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1440a implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C1440a f29841a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b.a.u.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1441a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f29842e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f29843f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f29844g;

            /* renamed from: b.a.u.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C1442a extends TimerTask {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f29845e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ RunnableC1441a f29846f;

                public C1442a(RunnableC1441a runnableC1441a, AtomicBoolean atomicBoolean) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC1441a, atomicBoolean};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29846f = runnableC1441a;
                    this.f29845e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        b.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                        d dVar = this.f29846f.f29844g;
                        if (dVar != null) {
                            dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                            a.f(true);
                            b c2 = a.c(a.f29838b);
                            RunnableC1441a runnableC1441a = this.f29846f;
                            c2.b(runnableC1441a.f29842e, runnableC1441a.f29844g);
                        }
                        this.f29845e.set(true);
                    }
                }
            }

            public RunnableC1441a(C1440a c1440a, String str, Timer timer, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1440a, str, timer, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f29842e = str;
                this.f29843f = timer;
                this.f29844g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.u.a.h.e.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f29842e);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    this.f29843f.schedule(new C1442a(this, atomicBoolean), 10000L);
                    DnsHelper dnsHelper = new DnsHelper(a.f29838b);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    a.j(dnsHelper.getIpList(this.f29842e));
                    List<String> list = a.f29839c;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    b.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f29839c);
                    String str = a.f29839c.get(0);
                    if (this.f29844g != null && !atomicBoolean.get()) {
                        this.f29844g.a(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, str);
                        if (a.f29839c.size() > 1) {
                            a.f29840d++;
                            a.f(false);
                        }
                    }
                    b.a.u.a.h.e.a("DNSUrlProvider", "bddns > return ip = " + str);
                    this.f29843f.cancel();
                }
            }
        }

        public C1440a(Context context) {
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
            Context unused = a.f29838b = context.getApplicationContext();
            a.i();
        }

        public static synchronized C1440a c(Context context) {
            InterceptResult invokeL;
            C1440a c1440a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (C1440a.class) {
                    if (f29841a == null) {
                        f29841a = new C1440a(context);
                    }
                    c1440a = f29841a;
                }
                return c1440a;
            }
            return (C1440a) invokeL.objValue;
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
                    if (a.f29839c != null && a.f29839c.size() > 0) {
                        if (a.f29840d < a.f29839c.size()) {
                            if (dVar != null) {
                                dVar.a(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, a.f29839c.get(a.f29840d));
                                b.a.u.a.h.e.a("DNSUrlProvider", "retry bddns > return ip = " + a.f29839c.get(a.f29840d));
                            }
                            a.f29840d++;
                            return;
                        }
                        a.f(true);
                        a.c(a.f29838b).b(str, dVar);
                        return;
                    }
                    b.a.u.a.g.a.a(a.f29838b).b(new RunnableC1441a(this, str, new Timer(), dVar));
                } catch (Throwable unused) {
                    b.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                    a.f(true);
                    a.c(a.f29838b).b(str, dVar);
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
        public static c f29847a;
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
                    if (f29847a == null) {
                        f29847a = new c();
                    }
                    cVar = f29847a;
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
        public static e f29848a;
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
            Context unused = a.f29838b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            InterceptResult invokeL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (e.class) {
                    if (f29848a == null) {
                        f29848a = new e(context);
                    }
                    eVar = f29848a;
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
                    b.a.u.a.f.d dVar2 = new b.a.u.a.f.d(a.f29838b);
                    dVar2.a(dVar);
                    b.a.u.a.f.c.e(dVar2, dVar2);
                } catch (Exception unused) {
                    a.f(true);
                    a.c(a.f29838b).b(str, dVar);
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
        f29839c = Collections.synchronizedList(new ArrayList());
        f29840d = 0;
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            f29838b = context.getApplicationContext();
            int a2 = b.a.u.a.h.c.a(context);
            if (a2 != 1 && a2 != 2) {
                if (b.a.u.a.h.f.c(context) && f29837a == 2) {
                    return C1440a.c(context);
                }
                if (f29837a == 3) {
                    return e.c(context);
                }
                return c.c();
            }
            f29837a = 0;
            return c.c();
        }
        return (b) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            List<String> list = f29839c;
            return list != null && f29840d <= list.size();
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
                int a2 = b.a.u.a.h.c.a(f29838b);
                if (a2 != 1 && a2 != 2) {
                    int i2 = f29837a;
                    if (i2 == 0) {
                        f29837a = 2;
                    } else if (i2 == 2) {
                        f29837a = 3;
                    } else if (i2 == 3) {
                        f29837a = 0;
                    }
                } else {
                    f29837a = 0;
                }
            }
            b.a.u.a.h.e.a("DNSUrlProvider", "try to connect ip, now policy =" + f29837a);
            return f29837a;
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
                f29840d = 0;
                f29839c.clear();
                f29837a = 3;
            } catch (Exception e2) {
                b.a.u.a.h.e.c("DNSUrlProvider", "resetBdDns exception", e2);
            }
        }
    }

    public static void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            f29839c.clear();
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
                int f2 = b.a.u.a.h.f.f(f29838b);
                b.a.u.a.h.e.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
                if (f2 == 1) {
                    f29839c.addAll(arrayList2);
                } else if (f2 == 2) {
                    f29839c.addAll(arrayList2);
                    f29839c.addAll(arrayList);
                } else if (f2 != 4) {
                    f29839c.addAll(arrayList);
                    f29839c.addAll(arrayList2);
                } else {
                    f29839c.addAll(arrayList);
                }
            }
        }
    }
}
