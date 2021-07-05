package com.airbnb.lottie;

import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class L {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DBG = false;
    public static final int MAX_DEPTH = 20;
    public static final String TAG = "LOTTIE";
    public static int depthPastMaxDepth;
    public static String[] sections;
    public static long[] startTimeNs;
    public static int traceDepth;
    public static boolean traceEnabled;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1200229194, "Lcom/airbnb/lottie/L;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1200229194, "Lcom/airbnb/lottie/L;");
        }
    }

    public L() {
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

    public static void beginSection(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && traceEnabled) {
            int i2 = traceDepth;
            if (i2 == 20) {
                depthPastMaxDepth++;
                return;
            }
            sections[i2] = str;
            startTimeNs[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            traceDepth++;
        }
    }

    public static float endSection(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int i2 = depthPastMaxDepth;
            if (i2 > 0) {
                depthPastMaxDepth = i2 - 1;
                return 0.0f;
            } else if (traceEnabled) {
                int i3 = traceDepth - 1;
                traceDepth = i3;
                if (i3 != -1) {
                    if (str.equals(sections[i3])) {
                        TraceCompat.endSection();
                        return ((float) (System.nanoTime() - startTimeNs[traceDepth])) / 1000000.0f;
                    }
                    throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + sections[traceDepth] + ".");
                }
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else {
                return 0.0f;
            }
        }
        return invokeL.floatValue;
    }

    public static void setTraceEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65540, null, z) == null) || traceEnabled == z) {
            return;
        }
        traceEnabled = z;
        if (z) {
            sections = new String[20];
            startTimeNs = new long[20];
        }
    }
}
