package b.a.w.j;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f30206a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f30207b;

    /* renamed from: c  reason: collision with root package name */
    public static String f30208c;

    /* renamed from: d  reason: collision with root package name */
    public static ArrayList<String> f30209d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-788426722, "Lb/a/w/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-788426722, "Lb/a/w/j/a;");
                return;
            }
        }
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            l(appInfoService.isDebug());
        }
        f30206a = a.class.getName();
        f30207b = false;
        f30208c = null;
        f30209d = new ArrayList<>();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(boolean z, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), str, str2, str3})) == null) {
            if (i()) {
                String str4 = f30208c;
                if (str4 == null || str3.startsWith(str4)) {
                    if (!z || j(str)) {
                        StringBuffer stringBuffer = new StringBuffer(100);
                        stringBuffer.append(str);
                        stringBuffer.append(":");
                        stringBuffer.append(str2);
                        stringBuffer.append(":");
                        stringBuffer.append(str3);
                        return stringBuffer.toString();
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public static void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, str3) == null) {
            a(true, str, str2, str3);
        }
    }

    public static int c(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            if (!i() || th == null) {
                return -1;
            }
            th.getMessage();
            return k(0, th.getMessage());
        }
        return invokeL.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? k(0, str) : invokeL.intValue;
    }

    public static int e(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, th)) == null) ? k(0, th.getMessage()) : invokeL.intValue;
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, str3) == null) {
            a(false, str, str2, str3);
        }
    }

    public static int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? k(2, str) : invokeL.intValue;
    }

    public static void h(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, str2, str3) == null) {
            a(true, str, str2, str3);
        }
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f30207b : invokeV.booleanValue;
    }

    public static boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            boolean z = false;
            if (f30209d.size() == 0) {
                return false;
            }
            Iterator<String> it = f30209d.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next())) {
                    z = true;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static int k(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65548, null, i2, str)) == null) {
            if (i()) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace.length < 5) {
                    return -1;
                }
                StackTraceElement stackTraceElement = stackTrace[4];
                String methodName = stackTraceElement.getMethodName();
                String className = stackTraceElement.getClassName();
                if (i2 <= 1 || j(className)) {
                    if (i2 == 0) {
                        f(className, methodName, str);
                        return 0;
                    } else if (i2 == 1) {
                        n(className, methodName, str);
                        return 0;
                    } else if (i2 == 2) {
                        h(className, methodName, str);
                        return 0;
                    } else if (i2 == 3) {
                        b(className, methodName, str);
                        return 0;
                    } else {
                        m(className, methodName, str);
                        return 0;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeIL.intValue;
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            f30207b = z;
        }
    }

    public static void m(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, str, str2, str3) == null) {
            a(true, str, str2, str3);
        }
    }

    public static void n(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, str3) == null) {
            a(false, str, str2, str3);
        }
    }
}
