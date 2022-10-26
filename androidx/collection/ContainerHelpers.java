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

    public static int idealByteArraySize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            for (int i2 = 4; i2 < 32; i2++) {
                int i3 = (1 << i2) - 12;
                if (i <= i3) {
                    return i3;
                }
            }
            return i;
        }
        return invokeI.intValue;
    }

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int binarySearch(int[] iArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, iArr, i, i2)) == null) {
            int i3 = i - 1;
            int i4 = 0;
            while (i4 <= i3) {
                int i5 = (i4 + i3) >>> 1;
                int i6 = iArr[i5];
                if (i6 < i2) {
                    i4 = i5 + 1;
                } else if (i6 > i2) {
                    i3 = i5 - 1;
                } else {
                    return i5;
                }
            }
            return ~i4;
        }
        return invokeLII.intValue;
    }

    public static int binarySearch(long[] jArr, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{jArr, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            int i2 = i - 1;
            int i3 = 0;
            while (i3 <= i2) {
                int i4 = (i3 + i2) >>> 1;
                int i5 = (jArr[i4] > j ? 1 : (jArr[i4] == j ? 0 : -1));
                if (i5 < 0) {
                    i3 = i4 + 1;
                } else if (i5 > 0) {
                    i2 = i4 - 1;
                } else {
                    return i4;
                }
            }
            return ~i3;
        }
        return invokeCommon.intValue;
    }

    public static boolean equal(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, obj2)) == null) {
            if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static int idealIntArraySize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            return idealByteArraySize(i * 4) / 4;
        }
        return invokeI.intValue;
    }

    public static int idealLongArraySize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            return idealByteArraySize(i * 8) / 8;
        }
        return invokeI.intValue;
    }
}
