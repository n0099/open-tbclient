package androidx.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes.dex */
public final class Preconditions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Preconditions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void checkArgument(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65537, null, z) != null) || z) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static int checkArgumentNonnegative(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            if (i >= 0) {
                return i;
            }
            throw new IllegalArgumentException();
        }
        return invokeI.intValue;
    }

    public static <T> T checkNotNull(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, t)) == null) {
            if (t != null) {
                return t;
            }
            throw null;
        }
        return (T) invokeL.objValue;
    }

    public static void checkState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            checkState(z, null);
        }
    }

    public static void checkArgument(boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(65538, null, z, obj) != null) || z) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static int checkArgumentNonnegative(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, null, i, str)) == null) {
            if (i >= 0) {
                return i;
            }
            throw new IllegalArgumentException(str);
        }
        return invokeIL.intValue;
    }

    public static <T> T checkNotNull(T t, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, t, obj)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(obj));
        }
        return (T) invokeLL.objValue;
    }

    public static void checkState(boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(65545, null, z, str) != null) || z) {
            return;
        }
        throw new IllegalStateException(str);
    }

    public static int checkArgumentInRange(int i, int i2, int i3, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str})) == null) {
            if (i >= i2) {
                if (i <= i3) {
                    return i;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        return invokeCommon.intValue;
    }
}
