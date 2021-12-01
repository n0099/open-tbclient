package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class TraceCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TraceCompat";
    public static Method sAsyncTraceBeginMethod;
    public static Method sAsyncTraceEndMethod;
    public static Method sIsTagEnabledMethod;
    public static Method sTraceCounterMethod;
    public static long sTraceTagApp;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1582039671, "Landroidx/core/os/TraceCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1582039671, "Landroidx/core/os/TraceCompat;");
                return;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 18 || i2 >= 29) {
            return;
        }
        try {
            sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            sTraceCounterMethod = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
        } catch (Exception unused) {
        }
    }

    public TraceCompat() {
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

    public static void beginAsyncSection(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, str, i2) == null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                Trace.beginAsyncSection(str, i2);
            } else if (i3 >= 18) {
                try {
                    sAsyncTraceBeginMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i2));
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void beginSection(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        Trace.beginSection(str);
    }

    public static void endAsyncSection(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2) == null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                Trace.endAsyncSection(str, i2);
            } else if (i3 >= 18) {
                try {
                    sAsyncTraceEndMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i2));
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void endSection() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        Trace.endSection();
    }

    public static boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                return Trace.isEnabled();
            }
            if (i2 >= 18) {
                try {
                    return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void setCounter(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, str, i2) == null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                Trace.setCounter(str, i2);
            } else if (i3 >= 18) {
                try {
                    sTraceCounterMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i2));
                } catch (Exception unused) {
                }
            }
        }
    }
}
