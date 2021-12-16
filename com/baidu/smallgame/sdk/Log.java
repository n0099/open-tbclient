package com.baidu.smallgame.sdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@NotProguard
/* loaded from: classes10.dex */
public final class Log {
    public static /* synthetic */ Interceptable $ic = null;
    public static String LOG_TAG = "MarioLog";
    public static boolean sDebugApk = false;
    public static int sMinLogLevel = 4;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-671977040, "Lcom/baidu/smallgame/sdk/Log;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-671977040, "Lcom/baidu/smallgame/sdk/Log;");
        }
    }

    public Log() {
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

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? printLog(3, LOG_TAG, str, null) : invokeL.intValue;
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? printLog(6, LOG_TAG, str, null) : invokeL.intValue;
    }

    public static String getStackTraceString(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, th)) == null) ? android.util.Log.getStackTraceString(th) : (String) invokeL.objValue;
    }

    public static int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? printLog(4, LOG_TAG, str, null) : invokeL.intValue;
    }

    public static boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? sDebugApk : invokeV.booleanValue;
    }

    public static boolean isLoggable(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, str, i2)) == null) ? i2 >= sMinLogLevel && android.util.Log.isLoggable(str, i2) : invokeLI.booleanValue;
    }

    public static int p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) ? printLog(6, LOG_TAG, str, null) : invokeL.intValue;
    }

    public static int printLog(int i2, String str, String str2, Throwable th) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Integer.valueOf(i2), str, str2, th})) == null) {
            if (i2 < sMinLogLevel) {
                return 0;
            }
            if (str == null) {
                str = LOG_TAG;
            }
            if (str2 == null) {
                str2 = "";
            }
            if (th != null) {
                str2 = str2 + '\n' + android.util.Log.getStackTraceString(th);
            }
            switch (i2) {
                case 2:
                    return android.util.Log.i(str, str2);
                case 3:
                    return android.util.Log.i(str, str2);
                case 4:
                    return android.util.Log.i(str, str2);
                case 5:
                    return android.util.Log.w(str, str2);
                case 6:
                case 7:
                    return android.util.Log.e(str, str2);
                default:
                    return android.util.Log.e(str, str2);
            }
        }
        return invokeCommon.intValue;
    }

    public static int printLogVargs(int i2, String str, String str2, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{Integer.valueOf(i2), str, str2, objArr})) == null) {
            if (i2 < sMinLogLevel) {
                return 0;
            }
            return printLog(i2, str, String.format(str2, objArr), null);
        }
        return invokeCommon.intValue;
    }

    public static void printStackTrace(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, th) == null) {
            if ((sMinLogLevel >= 6) && (th != null)) {
                th.printStackTrace();
            }
        }
    }

    public static void setMinLogLevel(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            String str = "ZeusSDK.ZeusMinLogLevel=" + i2 + ", sDebugApk=" + z;
            if (i2 < 2 || i2 > 7) {
                return;
            }
            sMinLogLevel = i2;
            sDebugApk = z;
        }
    }

    public static int v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) ? printLog(2, LOG_TAG, str, null) : invokeL.intValue;
    }

    public static int w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) ? printLog(5, LOG_TAG, str, null) : invokeL.intValue;
    }

    public static int wtf(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, str, str2)) == null) ? printLog(6, str, str2, null) : invokeLL.intValue;
    }

    public static int wtfStack(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, str, str2)) == null) ? printLog(6, str, str2, null) : invokeLL.intValue;
    }

    public static int d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) ? printLog(3, str, str2, null) : invokeLL.intValue;
    }

    public static int e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) ? printLog(6, str, str2, null) : invokeLL.intValue;
    }

    public static int i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) ? printLog(4, str, str2, null) : invokeLL.intValue;
    }

    public static int p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, str, str2)) == null) ? printLog(6, str, str2, null) : invokeLL.intValue;
    }

    public static int v(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, str, str2)) == null) ? printLog(2, str, str2, null) : invokeLL.intValue;
    }

    public static int w(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, str, str2)) == null) ? printLog(5, str, str2, null) : invokeLL.intValue;
    }

    public static int wtf(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, str, th)) == null) ? printLog(6, str, "", th) : invokeLL.intValue;
    }

    public static int d(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, th)) == null) ? printLog(3, str, str2, th) : invokeLLL.intValue;
    }

    public static int e(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, str, str2, th)) == null) ? printLog(6, str, str2, th) : invokeLLL.intValue;
    }

    public static int i(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, str, str2, th)) == null) ? printLog(4, str, str2, th) : invokeLLL.intValue;
    }

    public static int p(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, str, str2, th)) == null) ? printLog(6, str, str2, th) : invokeLLL.intValue;
    }

    public static int v(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65562, null, str, str2, th)) == null) ? printLog(2, str, str2, th) : invokeLLL.intValue;
    }

    public static int w(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65566, null, str, str2, th)) == null) ? printLog(5, str, str2, th) : invokeLLL.intValue;
    }

    public static int wtf(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65570, null, str, str2, th)) == null) ? printLog(6, str, str2, th) : invokeLLL.intValue;
    }

    public static int d(String str, String str2, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, str2, objArr)) == null) ? printLogVargs(3, str, str2, objArr) : invokeLLL.intValue;
    }

    public static int e(String str, String str2, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, str, str2, objArr)) == null) ? printLogVargs(6, str, str2, objArr) : invokeLLL.intValue;
    }

    public static int i(String str, String str2, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, str, str2, objArr)) == null) ? printLogVargs(4, str, str2, objArr) : invokeLLL.intValue;
    }

    public static int v(String str, String str2, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65563, null, str, str2, objArr)) == null) ? printLogVargs(2, str, str2, objArr) : invokeLLL.intValue;
    }

    public static int w(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, str, th)) == null) ? printLog(5, str, "", th) : invokeLL.intValue;
    }

    public static int w(String str, String str2, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65567, null, str, str2, objArr)) == null) ? printLogVargs(5, str, str2, objArr) : invokeLLL.intValue;
    }
}
