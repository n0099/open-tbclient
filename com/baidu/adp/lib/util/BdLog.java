package com.baidu.adp.lib.util;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
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
        String createMsg;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, str3) == null) || (createMsg = createMsg(true, str, str2, str3)) == null) {
            return;
        }
        Log.d(LOG_TAG, createMsg);
    }

    public static int detailException(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, th)) == null) {
            if (isDebugMode() && th != null) {
                Log.e(LOG_TAG, str, th);
            }
            return printLog(0, str);
        }
        return invokeLL.intValue;
    }

    public static void e(String str, String str2, String str3) {
        String createMsg;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, str, str2, str3) == null) || (createMsg = createMsg(false, str, str2, str3)) == null) {
            return;
        }
        Log.e(LOG_TAG, createMsg);
    }

    public static void i(String str, String str2, String str3) {
        String createMsg;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65548, null, str, str2, str3) == null) || (createMsg = createMsg(true, str, str2, str3)) == null) {
            return;
        }
        Log.i(LOG_TAG, createMsg);
    }

    public static boolean isDebugMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i2, str)) == null) {
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

    public static void setClassNameStartWithLogFilter(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            LogFilter_classNameStartsWith = str;
        }
    }

    public static void v(String str, String str2, String str3) {
        String createMsg;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65554, null, str, str2, str3) == null) || (createMsg = createMsg(true, str, str2, str3)) == null) {
            return;
        }
        Log.v(LOG_TAG, createMsg);
    }

    public static void w(String str, String str2, String str3) {
        String createMsg;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65556, null, str, str2, str3) == null) || (createMsg = createMsg(false, str, str2, str3)) == null) {
            return;
        }
        Log.w(LOG_TAG, createMsg);
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) ? printLog(3, str) : invokeL.intValue;
    }

    public static int e(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, th)) == null) ? printLog(0, th.getMessage()) : invokeL.intValue;
    }

    public static int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? printLog(2, str) : invokeL.intValue;
    }

    public static int v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) ? printLog(4, str) : invokeL.intValue;
    }

    public static int w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) ? printLog(1, str) : invokeL.intValue;
    }

    public static int detailException(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, th)) == null) {
            if (!isDebugMode() || th == null) {
                return -1;
            }
            Log.e(LOG_TAG, th.getMessage(), th);
            return printLog(0, th.getMessage());
        }
        return invokeL.intValue;
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? printLog(0, str) : invokeL.intValue;
    }
}
