package com.baidu.searchbox.player.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class BdVideoLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG_DEBUG = true;
    public static final boolean DEBUG_ERROR = true;
    public static final boolean DEBUG_EXCEPT = true;
    public static final boolean DEBUG_INFO = false;
    public static final boolean DEBUG_VERBOSE = false;
    public static final boolean DEBUG_WARN = true;
    public static final String LOG_TAG = "videoplayer";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.player.utils.BdVideoLog$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2070877073, "Lcom/baidu/searchbox/player/utils/BdVideoLog$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2070877073, "Lcom/baidu/searchbox/player/utils/BdVideoLog$1;");
                    return;
                }
            }
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel = iArr;
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel[LogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel[LogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel[LogLevel.VERBOSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel[LogLevel.WARN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1281531340, "Lcom/baidu/searchbox/player/utils/BdVideoLog$LogLevel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1281531340, "Lcom/baidu/searchbox/player/utils/BdVideoLog$LogLevel;");
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

    public BdVideoLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) && BDPlayerConfig.isDebug()) {
            doLog(LogLevel.DEBUG, str, str2, null);
        }
    }

    public static void doLog(LogLevel logLevel, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65540, null, logLevel, str, str2, th) == null) {
            int i2 = AnonymousClass1.$SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel[logLevel.ordinal()];
            if (i2 == 1) {
                if (th == null) {
                    Log.d(str, str2);
                } else {
                    Log.d(str, str2, th);
                }
            } else if (i2 == 2) {
                if (th == null) {
                    Log.e(str, str2);
                } else {
                    Log.e(str, str2, th);
                }
            } else if (i2 == 3) {
                if (th == null) {
                    Log.i(str, str2);
                } else {
                    Log.i(str, str2, th);
                }
            } else if (i2 == 4) {
                if (th == null) {
                    Log.v(str, str2);
                } else {
                    Log.v(str, str2, th);
                }
            } else if (i2 != 5) {
            } else {
                if (th == null) {
                    Log.w(str, str2);
                } else {
                    Log.w(str, str2, th);
                }
            }
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) && BDPlayerConfig.isDebug()) {
            doLog(LogLevel.ERROR, str, str2, null);
        }
    }

    public static void ex(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                e(str);
            }
            new Exception().printStackTrace();
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            BDPlayerConfig.isDebug();
        }
    }

    public static void logException(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, str, exc) == null) || exc == null) {
            return;
        }
        try {
            if (BDPlayerConfig.isDebug()) {
                exc.printStackTrace();
            }
            d(str, "========================= Exception Happened !!================================");
            d(str, exc.getMessage());
            for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                d(str, stackTraceElement.toString());
            }
            d(str, "========================= Exception Ended !!================================");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void printStackTrace(Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, exc) == null) && BDPlayerConfig.isDebug()) {
            exc.printStackTrace();
        }
    }

    public static void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) {
            BDPlayerConfig.isDebug();
        }
    }

    public static void w(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, str) == null) && BDPlayerConfig.isDebug()) {
            doLog(LogLevel.WARN, LOG_TAG, str, null);
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            BDPlayerConfig.isDebug();
        }
    }

    public static void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            BDPlayerConfig.isDebug();
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, str) == null) && BDPlayerConfig.isDebug()) {
            doLog(LogLevel.DEBUG, LOG_TAG, str, null);
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            doLog(LogLevel.ERROR, LOG_TAG, str, null);
        }
    }

    public static void i(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, th) == null) {
            BDPlayerConfig.isDebug();
        }
    }

    public static void v(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, th) == null) {
            BDPlayerConfig.isDebug();
        }
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65554, null, str, str2) == null) && BDPlayerConfig.isDebug()) {
            doLog(LogLevel.WARN, str, str2, null);
        }
    }

    public static void e(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, th) == null) {
            doLog(LogLevel.ERROR, LOG_TAG, str, th);
        }
    }

    public static void d(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, th) == null) && BDPlayerConfig.isDebug()) {
            doLog(LogLevel.DEBUG, LOG_TAG, str, th);
        }
    }

    public static void w(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65555, null, str, th) == null) && BDPlayerConfig.isDebug()) {
            doLog(LogLevel.WARN, LOG_TAG, str, th);
        }
    }
}
