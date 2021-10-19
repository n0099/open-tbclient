package com.baidu.browser.core.util;

import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.PathUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes5.dex */
public final class BdLog {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f38591a = true;

    /* renamed from: b  reason: collision with root package name */
    public static FileOutputStream f38592b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f38593c;

    /* renamed from: d  reason: collision with root package name */
    public static String f38594d;

    /* renamed from: e  reason: collision with root package name */
    public static String f38595e;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class LogLevel {
        public static final /* synthetic */ LogLevel[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LogLevel DEBUG;
        public static final LogLevel ERROR;
        public static final LogLevel INFO;
        public static final LogLevel VERBOSE;
        public static final LogLevel WARN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1544099271, "Lcom/baidu/browser/core/util/BdLog$LogLevel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1544099271, "Lcom/baidu/browser/core/util/BdLog$LogLevel;");
                    return;
                }
            }
            DEBUG = new LogLevel("DEBUG", 0);
            ERROR = new LogLevel("ERROR", 1);
            INFO = new LogLevel("INFO", 2);
            VERBOSE = new LogLevel("VERBOSE", 3);
            LogLevel logLevel = new LogLevel("WARN", 4);
            WARN = logLevel;
            $VALUES = new LogLevel[]{DEBUG, ERROR, INFO, VERBOSE, logLevel};
        }

        public LogLevel(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static LogLevel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LogLevel) Enum.valueOf(LogLevel.class, str) : (LogLevel) invokeL.objValue;
        }

        public static LogLevel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LogLevel[]) $VALUES.clone() : (LogLevel[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38596a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1656223022, "Lcom/baidu/browser/core/util/BdLog$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1656223022, "Lcom/baidu/browser/core/util/BdLog$a;");
                    return;
                }
            }
            int[] iArr = new int[LogLevel.values().length];
            f38596a = iArr;
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38596a[LogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38596a[LogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38596a[LogLevel.VERBOSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38596a[LogLevel.WARN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-766990773, "Lcom/baidu/browser/core/util/BdLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-766990773, "Lcom/baidu/browser/core/util/BdLog;");
                return;
            }
        }
        f38594d = Environment.getExternalStorageDirectory() + File.separator + PathUtils.DIRCTORY_BAIDU + File.separator + "flyflow" + File.separator + TbConfig.TMP_LOG_DIR_NAME + File.separator;
        StringBuilder sb = new StringBuilder();
        sb.append(f38594d);
        sb.append("baiduliulanqi_log.txt");
        f38595e = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f38594d);
        sb2.append("baiduliulanqi_lasttime_log.txt");
        sb2.toString();
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
        }
    }

    public static void b(LogLevel logLevel, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, logLevel, str, str2, th) == null) {
            if (str2 == null) {
                str2 = "";
            }
            int i2 = a.f38596a[logLevel.ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3 || i2 != 4) {
            }
            if (f38593c) {
                d(str, str2);
            }
        }
    }

    public static void c(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, th) == null) {
            b(LogLevel.ERROR, "FlyFlow", str, th);
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) && Environment.getExternalStorageState().equals("mounted")) {
            try {
                File file = new File(f38594d);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (f38592b == null) {
                    f38592b = new FileOutputStream(f38595e);
                }
                f38592b.write((str + ZeusCrashHandler.NAME_SEPERATOR + str2).getBytes("UTF-8"));
                f38592b.write(StringUtils.LF.getBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f38591a : invokeV.booleanValue;
    }

    public static void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, null, z) == null) {
            f38591a = z;
        }
    }

    public static void g(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65543, null, str, str2, th) == null) && f38591a) {
            b(LogLevel.WARN, str, str2, th);
        }
    }
}
