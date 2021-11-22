package b.h.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, obj, obj2) == null) {
            if (obj == null) {
                throw new NullPointerException("null key in entry: null=" + obj2);
            } else if (obj2 != null) {
            } else {
                throw new NullPointerException("null value in entry: " + obj + "=null");
            }
        }
    }

    public static int b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, str)) == null) {
            if (i2 >= 0) {
                return i2;
            }
            throw new IllegalArgumentException(str + " cannot be negative but was: " + i2);
        }
        return invokeIL.intValue;
    }

    public static long c(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, str)) == null) {
            if (j >= 0) {
                return j;
            }
            throw new IllegalArgumentException(str + " cannot be negative but was: " + j);
        }
        return invokeJL.longValue;
    }

    public static void d(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65539, null, i2, str) == null) || i2 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " must be positive but was: " + i2);
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            b.h.d.a.n.x(z, "no calls to next() since the last call to remove()");
        }
    }
}
