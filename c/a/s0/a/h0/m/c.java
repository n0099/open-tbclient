package c.a.s0.a.h0.m;

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
    public static final boolean f6878b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<c.a.s0.q.i.f, Set<InterfaceC0403c>> a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-541132983, "Lc/a/s0/a/h0/m/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-541132983, "Lc/a/s0/a/h0/m/c$b;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    /* renamed from: c.a.s0.a.h0.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0403c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, c.a.s0.a.u2.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1474295623, "Lc/a/s0/a/h0/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1474295623, "Lc/a/s0/a/h0/m/c;");
                return;
            }
        }
        f6878b = c.a.s0.a.k.a;
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (c) invokeV.objValue;
    }

    public synchronized void a(c.a.s0.q.i.f fVar, PMSDownloadType pMSDownloadType, c.a.s0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, fVar, pMSDownloadType, aVar) == null) {
            synchronized (this) {
                if (f6878b) {
                    String str = "downloadError:" + fVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType;
                }
                Set<InterfaceC0403c> set = this.a.get(fVar);
                if (set != null) {
                    for (InterfaceC0403c interfaceC0403c : set) {
                        if (interfaceC0403c != null) {
                            interfaceC0403c.b(pMSDownloadType, aVar);
                        }
                    }
                    this.a.remove(fVar);
                }
            }
        }
    }

    public synchronized void b(c.a.s0.q.i.f fVar, PMSDownloadType pMSDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, pMSDownloadType) == null) {
            synchronized (this) {
                if (f6878b) {
                    String str = "downloadSuccess:" + fVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType;
                }
                Set<InterfaceC0403c> set = this.a.get(fVar);
                if (set != null) {
                    for (InterfaceC0403c interfaceC0403c : set) {
                        if (interfaceC0403c != null) {
                            interfaceC0403c.a(pMSDownloadType);
                        }
                    }
                    this.a.remove(fVar);
                }
            }
        }
    }

    public synchronized void d(c.a.s0.q.i.f fVar, InterfaceC0403c interfaceC0403c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, interfaceC0403c) == null) {
            synchronized (this) {
                if (f6878b) {
                    String str = "registerResultListener:" + fVar;
                }
                if (fVar != null && interfaceC0403c != null) {
                    Set<InterfaceC0403c> set = this.a.get(fVar);
                    if (set != null) {
                        set.add(interfaceC0403c);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(interfaceC0403c);
                        this.a.put(fVar, hashSet);
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
        this.a = new HashMap<>();
    }
}
