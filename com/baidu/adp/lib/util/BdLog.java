package com.baidu.adp.lib.util;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes9.dex */
public class BdLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "BaiduLog";
    public static String LogFilter_classNameStartsWith;
    public static ArrayList<String> logPackage;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-321455124, "Lcom/baidu/adp/lib/util/BdLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-321455124, "Lcom/baidu/adp/lib/util/BdLog;");
                return;
            }
        }
        logPackage = new ArrayList<>();
    }

    public BdLog() {
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

    public static void addLogPackage(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || logPackage.contains(str)) {
            return;
        }
        logPackage.add(str);
    }

    public static String createMsg(boolean z, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), str, str2, str3})) == null) {
            if (isDebugMode()) {
                String str4 = LogFilter_classNameStartsWith;
                if (str4 == null || str3.startsWith(str4)) {
                    if (!z || isLogable(str)) {
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

    public static void d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, str2, str3) == null) {
            createMsg(true, str, str2, str3);
        }
    }

    public static int detailException(String str, Throwable th, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, null, str, th, z)) == null) ? detailException(str, th, null, null, null, z) : invokeLLZ.intValue;
    }

    public static void e(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, str3) == null) {
            createMsg(false, str, str2, str3);
        }
    }

    public static void i(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, str, str2, str3) == null) {
            createMsg(true, str, str2, str3);
        }
    }

    public static boolean isDebugMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            if (BdBaseApplication.getInst() == null) {
                return false;
            }
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public static boolean isLogable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            boolean z = false;
            if (logPackage.size() == 0) {
                return false;
            }
            Iterator<String> it = logPackage.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next())) {
                    z = true;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static int printLog(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65556, null, i2, str)) == null) {
            if (isDebugMode()) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace.length < 5) {
                    return -1;
                }
                StackTraceElement stackTraceElement = stackTrace[4];
                String methodName = stackTraceElement.getMethodName();
                String className = stackTraceElement.getClassName();
                if (i2 <= 1 || isLogable(className)) {
                    if (i2 == 0) {
                        e(className, methodName, str);
                        return 0;
                    } else if (i2 == 1) {
                        w(className, methodName, str);
                        return 0;
                    } else if (i2 == 2) {
                        i(className, methodName, str);
                        return 0;
                    } else if (i2 == 3) {
                        d(className, methodName, str);
                        return 0;
                    } else {
                        v(className, methodName, str);
                        return 0;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeIL.intValue;
    }

    public static void reportException(Exception exc, String str, String str2, Map<String, String> map) {
        ExceptionHandler exceptionHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65557, null, exc, str, str2, map) == null) || (exceptionHandler = (ExceptionHandler) ServiceManager.getService(ExceptionHandler.SERVICE_REFERENCE)) == null) {
            return;
        }
        exceptionHandler.onException(exc, str, str2, map);
    }

    public static void setClassNameStartWithLogFilter(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, str) == null) {
            LogFilter_classNameStartsWith = str;
        }
    }

    public static void v(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65560, null, str, str2, str3) == null) {
            createMsg(true, str, str2, str3);
        }
    }

    public static void w(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65562, null, str, str2, str3) == null) {
            createMsg(false, str, str2, str3);
        }
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? printLog(3, str) : invokeL.intValue;
    }

    public static int detailException(Throwable th, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, th, z)) == null) ? detailException(null, th, null, null, null, z) : invokeLZ.intValue;
    }

    public static int e(Throwable th, String str, String str2, Map<String, String> map, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{th, str, str2, map, Boolean.valueOf(z)})) == null) {
            if ((th instanceof Exception) && !isDebugMode() && !z) {
                reportException((Exception) th, str, str2, map);
            }
            return printLog(0, th.getMessage());
        }
        return invokeCommon.intValue;
    }

    public static int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) ? printLog(2, str) : invokeL.intValue;
    }

    public static int v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) ? printLog(4, str) : invokeL.intValue;
    }

    public static int w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) ? printLog(1, str) : invokeL.intValue;
    }

    public static int detailException(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, th)) == null) ? detailException(str, th, null, null, null, false) : invokeLL.intValue;
    }

    public static int detailException(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, th)) == null) ? detailException(null, th, null, null, null, false) : invokeL.intValue;
    }

    public static int detailException(String str, Throwable th, String str2, String str3, Map<String, String> map, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, th, str2, str3, map, Boolean.valueOf(z)})) == null) {
            if ((th instanceof Exception) && !isDebugMode() && !z) {
                reportException((Exception) th, str2, str3, map);
            }
            if (isDebugMode() && th != null) {
                th.getMessage();
                return printLog(0, th.getMessage());
            } else if (str == null || str.length() <= 0) {
                return -1;
            } else {
                return printLog(0, str);
            }
        }
        return invokeCommon.intValue;
    }

    public static int e(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, th)) == null) ? e(th, null, null, null, false) : invokeL.intValue;
    }

    public static int e(Throwable th, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65550, null, th, z)) == null) ? e(th, null, null, null, z) : invokeLZ.intValue;
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? printLog(0, str) : invokeL.intValue;
    }
}
