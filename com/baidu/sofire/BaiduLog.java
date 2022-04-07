package com.baidu.sofire;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
/* loaded from: classes2.dex */
public class BaiduLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALL = -1;
    public static int CURRENT_STATE = -1;
    public static final int DEBUG = 1;
    public static final int ERROR = 2;
    public static final int FILE_ONLY = 3;
    public static final int INFO = 0;
    public static final boolean LOG_ENABLE = false;
    public static ThreadLocal<StringBuilder> sLocalLogBuilder;
    public static int sLogCount;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1442469347, "Lcom/baidu/sofire/BaiduLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1442469347, "Lcom/baidu/sofire/BaiduLog;");
                return;
            }
        }
        sLocalLogBuilder = new ThreadLocal<>();
    }

    public BaiduLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getStackTraceString(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, th)) != null) {
            return (String) invokeL.objValue;
        }
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
            try {
            } catch (Throwable th3) {
                CommonMethods.handleNuLException(th3);
                return "";
            }
        }
        StringWriter stringWriter = null;
        try {
            StringWriter stringWriter2 = new StringWriter();
            try {
                th.printStackTrace(new PrintWriter(stringWriter2));
                String stringWriter3 = stringWriter2.toString();
                try {
                    stringWriter2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return stringWriter3;
            } catch (Throwable th4) {
                th = th4;
                stringWriter = stringWriter2;
                if (stringWriter != null) {
                    try {
                        stringWriter.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static void logD(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
        }
    }

    public static void logD(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, th) == null) {
        }
    }

    public static void logE(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
        }
    }

    public static void logE(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, th) == null) {
        }
    }

    public static void logI(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
        }
    }

    public static void logI(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, th) == null) {
        }
    }

    public static void logInternal(int i, String str) {
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65545, null, i, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                if (stackTrace.length < 3) {
                    printLog("sofire", i, str);
                    return;
                }
                String fileName = stackTrace[2].getFileName();
                if (fileName == null) {
                    printLog("sofire", i, str);
                    return;
                }
                int lineNumber = stackTrace[2].getLineNumber();
                String methodName = stackTrace[2].getMethodName();
                if (fileName.length() > 5) {
                    fileName = fileName.substring(0, fileName.length() - 5);
                }
                StringBuilder sb2 = sLocalLogBuilder.get();
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                    sLocalLogBuilder.set(sb2);
                }
                synchronized (sb2) {
                    sb2.setLength(0);
                    sb2.append(PreferencesUtil.LEFT_MOUNT);
                    sb2.append(sLogCount);
                    sb2.append("][");
                    sb2.append(fileName);
                    sb2.append(':');
                    sb2.append(lineNumber);
                    sb2.append(IStringUtil.EXTENSION_SEPARATOR);
                    sb2.append(methodName);
                    sb2.append("] ");
                    sb2.append(str);
                    sb = sb2.toString();
                    sLogCount++;
                }
                printLog("sofire", i, sb);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public static void printLog(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65546, null, str, i, str2) == null) {
            if (i == 0) {
                Log.i(str, str2);
            } else if (i == 1) {
                Log.d(str, str2);
            } else if (i != 2) {
            } else {
                Log.e(str, str2);
            }
        }
    }

    public static void printThrowable(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, th) == null) {
        }
    }
}
