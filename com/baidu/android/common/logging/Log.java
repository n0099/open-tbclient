package com.baidu.android.common.logging;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class Log {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILE_LIMETE = 10485760;
    public static final int FILE_NUMBER = 2;
    public static Logger sFilelogger = null;
    public static boolean sLog2File = false;
    public static boolean sLogEnabled = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2061023107, "Lcom/baidu/android/common/logging/Log;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2061023107, "Lcom/baidu/android/common/logging/Log;");
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

    public static void d(String str, String str2) {
        Logger logger;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) && sLogEnabled) {
            if (sLog2File && (logger = sFilelogger) != null) {
                Level level = Level.INFO;
                logger.log(level, str + ": " + str2);
                return;
            }
            android.util.Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        Logger logger;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) && sLogEnabled) {
            if (sLog2File && (logger = sFilelogger) != null) {
                Level level = Level.SEVERE;
                logger.log(level, str + ": " + str2);
                return;
            }
            android.util.Log.e(str, str2);
        }
    }

    public static String getLogFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String processNameForPid = getProcessNameForPid(Process.myPid());
            if (TextUtils.isEmpty(processNameForPid)) {
                processNameForPid = "BaiduFileLog";
            }
            return processNameForPid.replace(':', '_');
        }
        return (String) invokeV.objValue;
    }

    public static String getProcessNameForPid(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
            String str = "/proc/" + i2 + "/cmdline";
            String str2 = "/proc/" + i2 + "/status";
            String str3 = "";
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(str)));
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    str3 = readLine.substring(0, readLine.indexOf(0));
                } else {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File(str2)));
                    String readLine2 = bufferedReader2.readLine();
                    while (true) {
                        if (readLine2 == null) {
                            break;
                        } else if (readLine2.startsWith("Name:")) {
                            int indexOf = readLine2.indexOf(TrackUI.SEPERATOR);
                            if (indexOf >= 0) {
                                str3 = readLine2.substring(indexOf + 1);
                            }
                        } else {
                            readLine2 = bufferedReader2.readLine();
                        }
                    }
                    bufferedReader = bufferedReader2;
                }
                bufferedReader.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return str3;
        }
        return (String) invokeI.objValue;
    }

    public static String getStackTraceString(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, th)) == null) {
            if (th == null) {
                return "";
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void i(String str, String str2) {
        Logger logger;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) && sLogEnabled) {
            if (sLog2File && (logger = sFilelogger) != null) {
                Level level = Level.INFO;
                logger.log(level, str + ": " + str2);
                return;
            }
            android.util.Log.i(str, str2);
        }
    }

    public static void setLog2File(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            sLog2File = z;
            if (z && sFilelogger == null) {
                String logFileName = getLogFileName();
                String absolutePath = new File(Environment.getExternalStorageDirectory(), logFileName).getAbsolutePath();
                try {
                    FileHandler fileHandler = new FileHandler(absolutePath + "_%g.log", 10485760, 2, true);
                    fileHandler.setFormatter(new SimpleFormatter());
                    Logger logger = Logger.getLogger(logFileName);
                    sFilelogger = logger;
                    logger.setLevel(Level.ALL);
                    sFilelogger.addHandler(fileHandler);
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (SecurityException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public static void setLogEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            sLogEnabled = z;
        }
    }

    public static void v(String str, String str2) {
        Logger logger;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) && sLogEnabled) {
            if (sLog2File && (logger = sFilelogger) != null) {
                Level level = Level.INFO;
                logger.log(level, str + ": " + str2);
                return;
            }
            android.util.Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        Logger logger;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65552, null, str, str2) == null) && sLogEnabled) {
            if (sLog2File && (logger = sFilelogger) != null) {
                Level level = Level.WARNING;
                logger.log(level, str + ": " + str2);
                return;
            }
            android.util.Log.w(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, th) == null) {
            d(str, str2 + '\n' + getStackTraceString(th));
        }
    }

    public static void e(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, th) == null) {
            e(str, getStackTraceString(th));
        }
    }

    public static void i(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, str, str2, th) == null) {
            i(str, str2 + '\n' + getStackTraceString(th));
        }
    }

    public static void v(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, th) == null) {
            v(str, str2 + '\n' + getStackTraceString(th));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, str, str2, th) == null) {
            w(str, str2 + '\n' + getStackTraceString(th));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, th) == null) {
            e(str, str2 + '\n' + getStackTraceString(th));
        }
    }
}
