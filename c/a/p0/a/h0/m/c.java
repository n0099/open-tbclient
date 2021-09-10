package c.a.p0.a.h0.m;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f6170b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<c.a.p0.n.h.e, Set<InterfaceC0228c>> f6171a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static c f6172a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(975542892, "Lc/a/p0/a/h0/m/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(975542892, "Lc/a/p0/a/h0/m/c$b;");
                    return;
                }
            }
            f6172a = new c(null);
        }
    }

    /* renamed from: c.a.p0.a.h0.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0228c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, c.a.p0.a.q2.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1087047466, "Lc/a/p0/a/h0/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1087047466, "Lc/a/p0/a/h0/m/c;");
                return;
            }
        }
        f6170b = c.a.p0.a.k.f7077a;
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f6172a : (c) invokeV.objValue;
    }

    public synchronized void a(c.a.p0.n.h.e eVar, PMSDownloadType pMSDownloadType, c.a.p0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, pMSDownloadType, aVar) == null) {
            synchronized (this) {
                if (f6170b) {
                    String str = "downloadError:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType;
                }
                Set<InterfaceC0228c> set = this.f6171a.get(eVar);
                if (set != null) {
                    for (InterfaceC0228c interfaceC0228c : set) {
                        if (interfaceC0228c != null) {
                            interfaceC0228c.b(pMSDownloadType, aVar);
                        }
                    }
                    this.f6171a.remove(eVar);
                }
            }
        }
    }

    public synchronized void b(c.a.p0.n.h.e eVar, PMSDownloadType pMSDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, pMSDownloadType) == null) {
            synchronized (this) {
                if (f6170b) {
                    String str = "downloadSuccess:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType;
                }
                Set<InterfaceC0228c> set = this.f6171a.get(eVar);
                if (set != null) {
                    for (InterfaceC0228c interfaceC0228c : set) {
                        if (interfaceC0228c != null) {
                            interfaceC0228c.a(pMSDownloadType);
                        }
                    }
                    this.f6171a.remove(eVar);
                }
            }
        }
    }

    public synchronized void d(c.a.p0.n.h.e eVar, InterfaceC0228c interfaceC0228c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, interfaceC0228c) == null) {
            synchronized (this) {
                if (f6170b) {
                    String str = "registerResultListener:" + eVar;
                }
                if (eVar != null && interfaceC0228c != null) {
                    Set<InterfaceC0228c> set = this.f6171a.get(eVar);
                    if (set != null) {
                        set.add(interfaceC0228c);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(interfaceC0228c);
                        this.f6171a.put(eVar, hashSet);
                    }
                }
            }
        }
    }

    public c() {
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
        this.f6171a = new HashMap<>();
    }
}
