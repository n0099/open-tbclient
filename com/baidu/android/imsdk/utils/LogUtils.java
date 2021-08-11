package com.baidu.android.imsdk.utils;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public class LogUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static int LOG_LEVEL_D = 3;
    public static int LOG_LEVEL_E = 0;
    public static int LOG_LEVEL_I = 2;
    public static int LOG_LEVEL_V = 4;
    public static int LOG_LEVEL_W = 1;
    public static String TAG = "imsdk";
    public static boolean mIsWriteToFile = false;
    public static int mLoglevel = 3;
    public static Context sContext;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2054489769, "Lcom/baidu/android/imsdk/utils/LogUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2054489769, "Lcom/baidu/android/imsdk/utils/LogUtils;");
        }
    }

    public LogUtils() {
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

    public static String currentTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss   ").format(new Date(System.currentTimeMillis())) : (String) invokeV.objValue;
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_D) {
            if (mIsWriteToFile) {
                LogFile.getInstance(sContext).writeByte((currentTime() + str + ZeusCrashHandler.NAME_SEPERATOR + str2 + StringUtils.LF).getBytes());
                return;
            }
            String str3 = str + ZeusCrashHandler.NAME_SEPERATOR + str2;
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) && Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_E) {
            if (mIsWriteToFile) {
                LogFile.getInstance(sContext).writeByte((currentTime() + str + ZeusCrashHandler.NAME_SEPERATOR + str2 + StringUtils.LF).getBytes());
                return;
            }
            String str3 = str + ZeusCrashHandler.NAME_SEPERATOR + str2;
        }
    }

    public static void enter() {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) || !Constants.isDebugMode() || mLoglevel < LOG_LEVEL_D || (stackTrace = new Throwable().getStackTrace()) == null || 2 > stackTrace.length || (stackTraceElement = stackTrace[1]) == null) {
            return;
        }
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        d(className, "====>" + methodName);
    }

    public static String fileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new SimpleDateFormat("yyyyMMddHH").format(new Date(System.currentTimeMillis())) : (String) invokeV.objValue;
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) && Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_I) {
            if (mIsWriteToFile) {
                LogFile.getInstance(sContext).writeByte((currentTime() + str + ZeusCrashHandler.NAME_SEPERATOR + str2 + StringUtils.LF).getBytes());
                return;
            }
            String str3 = str + ZeusCrashHandler.NAME_SEPERATOR + str2;
        }
    }

    public static void init(Context context, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            mLoglevel = i2;
            mIsWriteToFile = z;
            sContext = context;
            LogFile.getInstance(context);
        }
    }

    public static void leave() {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, null) == null) || !Constants.isDebugMode() || mLoglevel < LOG_LEVEL_D || (stackTrace = new Throwable().getStackTrace()) == null || 2 > stackTrace.length || (stackTraceElement = stackTrace[1]) == null) {
            return;
        }
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        d(className, "<====" + methodName);
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) && Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_I) {
            if (mIsWriteToFile) {
                LogFile.getInstance(sContext).writeByte((currentTime() + str + ZeusCrashHandler.NAME_SEPERATOR + str2 + StringUtils.LF).getBytes());
                return;
            }
            String str3 = str + ZeusCrashHandler.NAME_SEPERATOR + str2;
        }
    }

    public static void e(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, th) == null) && Constants.isDebugMode() && mLoglevel >= LOG_LEVEL_E) {
            if (mIsWriteToFile) {
                LogFile.getInstance(sContext).writeByte((currentTime() + str + ZeusCrashHandler.NAME_SEPERATOR + str2 + StringUtils.LF).getBytes());
                return;
            }
            String str3 = str + ZeusCrashHandler.NAME_SEPERATOR + str2;
        }
    }

    public static void enter(String str) {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, str) == null) || !Constants.isDebugMode() || mLoglevel < LOG_LEVEL_D || (stackTrace = new Throwable().getStackTrace()) == null || 2 > stackTrace.length || (stackTraceElement = stackTrace[1]) == null) {
            return;
        }
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        d(className, str + "====>" + methodName);
    }

    public static void leave(String str) {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, str) == null) || !Constants.isDebugMode() || mLoglevel < LOG_LEVEL_D || (stackTrace = new Throwable().getStackTrace()) == null || 2 > stackTrace.length || (stackTraceElement = stackTrace[1]) == null) {
            return;
        }
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        d(className, str + "<====" + methodName);
    }
}
