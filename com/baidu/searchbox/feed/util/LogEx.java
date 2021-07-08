package com.baidu.searchbox.feed.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.IllegalFormatException;
/* loaded from: classes2.dex */
public final class LogEx {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean ENABLE_LOG = true;
    public static final int LARGE_STRING_LIMIT = 1000;
    public static final String MESSAGE_IS_EMPTY = "LogEx method param(msg) is null";
    public transient /* synthetic */ FieldHolder $fh;

    public LogEx() {
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
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            println(3, str, str2);
        }
    }

    public static void debug(@NonNull String str, @Nullable String str2, @Nullable Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, objArr) == null) {
            if (str2 == null) {
                println(3, str, MESSAGE_IS_EMPTY);
                return;
            }
            try {
                str2 = String.format(str2, objArr);
            } catch (IllegalFormatException e2) {
                e2.printStackTrace();
            }
            println(3, str, str2);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            println(6, str, str2);
        }
    }

    public static void error(@NonNull String str, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, th) == null) {
            println(6, str, Log.getStackTraceString(th));
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            println(4, str, str2);
        }
    }

    public static void info(@NonNull String str, @Nullable String str2, @Nullable Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, str, str2, objArr) == null) {
            if (str2 == null) {
                println(4, str, MESSAGE_IS_EMPTY);
                return;
            }
            try {
                str2 = String.format(str2, objArr);
            } catch (IllegalFormatException e2) {
                e2.printStackTrace();
            }
            println(4, str, str2);
        }
    }

    public static void println(int i2, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65547, null, i2, str, str2) == null) || str == null) {
            return;
        }
        if (str2 != null) {
            str3 = PreferencesUtil.LEFT_MOUNT + Thread.currentThread().getName() + PreferencesUtil.RIGHT_MOUNT + str2;
        } else {
            str3 = MESSAGE_IS_EMPTY;
        }
        printlnLargeString(i2, str, str3);
    }

    public static void printlnLargeString(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65548, null, i2, str, str2) == null) {
            if (str2.length() > 1000) {
                Log.println(i2, str, str2.substring(0, 1000));
                printlnLargeString(i2, str, str2.substring(1000));
                return;
            }
            Log.println(i2, str, str2);
        }
    }

    public static void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) {
            println(2, str, str2);
        }
    }

    public static void verbose(@NonNull String str, @Nullable String str2, @Nullable Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, objArr) == null) {
            if (str2 == null) {
                println(2, str, MESSAGE_IS_EMPTY);
                return;
            }
            try {
                str2 = String.format(str2, objArr);
            } catch (IllegalFormatException e2) {
                e2.printStackTrace();
            }
            println(2, str, str2);
        }
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, str2) == null) {
            println(5, str, str2);
        }
    }

    public static void warn(@NonNull String str, @Nullable String str2, @Nullable Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, null, str, str2, objArr) == null) {
            if (str2 == null) {
                println(5, str, MESSAGE_IS_EMPTY);
                return;
            }
            try {
                str2 = String.format(str2, objArr);
            } catch (IllegalFormatException e2) {
                e2.printStackTrace();
            }
            println(5, str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, th) == null) {
            println(3, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, th) == null) {
            println(6, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }

    public static void error(@NonNull String str, @Nullable Throwable th, @Nullable String str2, @Nullable Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, str, th, str2, objArr) == null) {
            if (str2 == null) {
                println(6, str, "LogEx method param(msg) is null\n" + Log.getStackTraceString(th));
                return;
            }
            try {
                str2 = String.format(str2, objArr);
            } catch (IllegalFormatException e2) {
                e2.printStackTrace();
            }
            println(6, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }

    public static void i(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, str2, th) == null) {
            println(4, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }

    public static void v(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, str, str2, th) == null) {
            println(2, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, str, str2, th) == null) {
            println(5, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }
}
