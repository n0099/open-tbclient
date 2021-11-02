package b.a.p0.o.a.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f11356a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object[] f11357b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(836543963, "Lb/a/p0/o/a/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(836543963, "Lb/a/p0/o/a/c/b;");
                return;
            }
        }
        f11356a = new int[0];
        f11357b = new Object[0];
    }

    public static int a(int[] iArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, iArr, i2, i3)) == null) {
            int i4 = i2 - 1;
            int i5 = 0;
            while (i5 <= i4) {
                int i6 = (i5 + i4) >>> 1;
                int i7 = iArr[i6];
                if (i7 < i3) {
                    i5 = i6 + 1;
                } else if (i7 <= i3) {
                    return i6;
                } else {
                    i4 = i6 - 1;
                }
            }
            return ~i5;
        }
        return invokeLII.intValue;
    }

    public static boolean b(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            for (int i3 = 4; i3 < 32; i3++) {
                int i4 = (1 << i3) - 12;
                if (i2 <= i4) {
                    return i4;
                }
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? c(i2 * 4) / 4 : invokeI.intValue;
    }
}
