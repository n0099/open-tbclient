package c.a.n0.a.x.m;

import android.util.Log;
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
    public static final boolean f7242b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<c.a.n0.q.h.f, Set<InterfaceC0549c>> a;

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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1422531384, "Lc/a/n0/a/x/m/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1422531384, "Lc/a/n0/a/x/m/c$b;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    /* renamed from: c.a.n0.a.x.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0549c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, c.a.n0.a.k2.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622708602, "Lc/a/n0/a/x/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622708602, "Lc/a/n0/a/x/m/c;");
                return;
            }
        }
        f7242b = c.a.n0.a.a.a;
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (c) invokeV.objValue;
    }

    public synchronized void a(c.a.n0.q.h.f fVar, PMSDownloadType pMSDownloadType, c.a.n0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, fVar, pMSDownloadType, aVar) == null) {
            synchronized (this) {
                if (f7242b) {
                    Log.i("PMSDownloadRepeatSync", "downloadError:" + fVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<InterfaceC0549c> set = this.a.get(fVar);
                if (set != null) {
                    for (InterfaceC0549c interfaceC0549c : set) {
                        if (interfaceC0549c != null) {
                            interfaceC0549c.b(pMSDownloadType, aVar);
                        }
                    }
                    this.a.remove(fVar);
                }
            }
        }
    }

    public synchronized void b(c.a.n0.q.h.f fVar, PMSDownloadType pMSDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, pMSDownloadType) == null) {
            synchronized (this) {
                if (f7242b) {
                    Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + fVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<InterfaceC0549c> set = this.a.get(fVar);
                if (set != null) {
                    for (InterfaceC0549c interfaceC0549c : set) {
                        if (interfaceC0549c != null) {
                            interfaceC0549c.a(pMSDownloadType);
                        }
                    }
                    this.a.remove(fVar);
                }
            }
        }
    }

    public synchronized void d(c.a.n0.q.h.f fVar, InterfaceC0549c interfaceC0549c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, interfaceC0549c) == null) {
            synchronized (this) {
                if (f7242b) {
                    Log.i("PMSDownloadRepeatSync", "registerResultListener:" + fVar);
                }
                if (fVar != null && interfaceC0549c != null) {
                    Set<InterfaceC0549c> set = this.a.get(fVar);
                    if (set != null) {
                        set.add(interfaceC0549c);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(interfaceC0549c);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }
}
