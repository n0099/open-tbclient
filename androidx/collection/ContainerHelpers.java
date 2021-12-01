package androidx.collection;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ContainerHelpers {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] EMPTY_INTS;
    public static final long[] EMPTY_LONGS;
    public static final Object[] EMPTY_OBJECTS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1943158848, "Landroidx/collection/ContainerHelpers;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1943158848, "Landroidx/collection/ContainerHelpers;");
                return;
            }
        }
        EMPTY_INTS = new int[0];
        EMPTY_LONGS = new long[0];
        EMPTY_OBJECTS = new Object[0];
    }

    public ContainerHelpers() {
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

    public static int binarySearch(int[] iArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, iArr, i2, i3)) == null) {
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

    public static boolean equal(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public static int idealByteArraySize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) {
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

    public static int idealIntArraySize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) ? idealByteArraySize(i2 * 4) / 4 : invokeI.intValue;
    }

    public static int idealLongArraySize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? idealByteArraySize(i2 * 8) / 8 : invokeI.intValue;
    }

    public static int binarySearch(long[] jArr, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{jArr, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            int i3 = i2 - 1;
            int i4 = 0;
            while (i4 <= i3) {
                int i5 = (i4 + i3) >>> 1;
                int i6 = (jArr[i5] > j2 ? 1 : (jArr[i5] == j2 ? 0 : -1));
                if (i6 < 0) {
                    i4 = i5 + 1;
                } else if (i6 <= 0) {
                    return i5;
                } else {
                    i3 = i5 - 1;
                }
            }
            return ~i4;
        }
        return invokeCommon.intValue;
    }
}
