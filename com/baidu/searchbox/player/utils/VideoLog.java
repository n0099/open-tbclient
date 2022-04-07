package com.baidu.searchbox.player.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
/* loaded from: classes2.dex */
public abstract class VideoLog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int MAX_LOG_LEN;
    public final int TAG_MAX_LEN;

    public VideoLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG_MAX_LEN = 23;
        this.MAX_LOG_LEN = 4096;
    }

    private String getStackTraceString(@NonNull Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, th)) == null) {
            try {
                StringWriter stringWriter = new StringWriter(256);
                PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
                th.printStackTrace(printWriter);
                printWriter.flush();
                printWriter.close();
                return stringWriter.toString();
            } catch (Exception e) {
                String message = e.getMessage();
                return TextUtils.isEmpty(message) ? "unknown throwable by VideoLog.java" : message;
            }
        }
        return (String) invokeL.objValue;
    }

    public void d(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            doLog(3, str, str2, null);
        }
    }

    public void doLog(int i, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, str2, th}) == null) && isLoggable(i, str)) {
            if (TextUtils.isEmpty(str2)) {
                if (th == null) {
                    return;
                }
                str2 = getStackTraceString(th);
            } else if (th != null) {
                str2 = str2 + "\n" + getStackTraceString(th);
            }
            if (TextUtils.isEmpty(str)) {
                log(i, null, str2);
            } else if (str.length() > 23 && Build.VERSION.SDK_INT < 24) {
                log(i, str.substring(0, 23), str2);
            } else {
                log(i, str, str2);
            }
        }
    }

    public void e(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            doLog(6, str, str2, null);
        }
    }

    public void i(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            doLog(4, str, str2, null);
        }
    }

    public abstract boolean isLoggable(int i, @Nullable String str);

    public void log(int i, @Nullable String str, @NonNull String str2) {
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i, str, str2) == null) {
            if (str2.length() < 4096) {
                if (i == 7) {
                    Log.wtf(str, str2);
                    return;
                } else {
                    Log.println(i, str, str2);
                    return;
                }
            }
            int i2 = 0;
            int length = str2.length();
            while (i2 < length) {
                int indexOf = str2.indexOf(10, i2);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i2 + 4096);
                    String substring = str2.substring(i2, min);
                    if (i == 7) {
                        Log.wtf(str, substring);
                    } else {
                        Log.println(i, str, substring);
                    }
                    if (min >= indexOf) {
                        break;
                    }
                    i2 = min;
                }
                i2 = min + 1;
            }
        }
    }

    public void v(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
            doLog(2, str, str2, null);
        }
    }

    public void w(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            doLog(5, null, str, null);
        }
    }

    public void d(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            doLog(3, null, str, null);
        }
    }

    public void e(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            doLog(6, null, str, null);
        }
    }

    public void i(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            doLog(4, null, str, null);
        }
    }

    public void v(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            doLog(2, null, str, null);
        }
    }

    public void w(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            doLog(5, str, str2, null);
        }
    }

    public void d(@Nullable String str, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, th) == null) {
            doLog(3, null, str, th);
        }
    }

    public void e(@Nullable String str, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, th) == null) {
            doLog(6, null, str, th);
        }
    }

    public void i(@Nullable String str, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, th) == null) {
            doLog(4, null, str, th);
        }
    }

    public void v(@Nullable String str, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, th) == null) {
            doLog(2, null, str, th);
        }
    }

    public void w(@Nullable String str, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, th) == null) {
            doLog(5, null, str, th);
        }
    }
}
