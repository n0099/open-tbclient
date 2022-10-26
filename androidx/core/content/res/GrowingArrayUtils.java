package androidx.core.content.res;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
/* loaded from: classes.dex */
public final class GrowingArrayUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int growSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            if (i <= 4) {
                return 8;
            }
            return i * 2;
        }
        return invokeI.intValue;
    }

    public GrowingArrayUtils() {
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

    public static int[] append(int[] iArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, iArr, i, i2)) == null) {
            if (i + 1 > iArr.length) {
                int[] iArr2 = new int[growSize(i)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr = iArr2;
            }
            iArr[i] = i2;
            return iArr;
        }
        return (int[]) invokeLII.objValue;
    }

    public static long[] append(long[] jArr, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{jArr, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (i + 1 > jArr.length) {
                long[] jArr2 = new long[growSize(i)];
                System.arraycopy(jArr, 0, jArr2, 0, i);
                jArr = jArr2;
            }
            jArr[i] = j;
            return jArr;
        }
        return (long[]) invokeCommon.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object[], java.lang.Object] */
    public static <T> T[] append(T[] tArr, int i, T t) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, tArr, i, t)) == null) {
            if (i + 1 > tArr.length) {
                ?? r0 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i));
                System.arraycopy(tArr, 0, r0, 0, i);
                tArr = r0;
            }
            tArr[i] = t;
            return tArr;
        }
        return (T[]) ((Object[]) invokeLIL.objValue);
    }

    public static boolean[] append(boolean[] zArr, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{zArr, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i + 1 > zArr.length) {
                boolean[] zArr2 = new boolean[growSize(i)];
                System.arraycopy(zArr, 0, zArr2, 0, i);
                zArr = zArr2;
            }
            zArr[i] = z;
            return zArr;
        }
        return (boolean[]) invokeCommon.objValue;
    }

    public static int[] insert(int[] iArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65542, null, iArr, i, i2, i3)) == null) {
            if (i + 1 <= iArr.length) {
                System.arraycopy(iArr, i2, iArr, i2 + 1, i - i2);
                iArr[i2] = i3;
                return iArr;
            }
            int[] iArr2 = new int[growSize(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            iArr2[i2] = i3;
            System.arraycopy(iArr, i2, iArr2, i2 + 1, iArr.length - i2);
            return iArr2;
        }
        return (int[]) invokeLIII.objValue;
    }

    public static long[] insert(long[] jArr, int i, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{jArr, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (i + 1 <= jArr.length) {
                System.arraycopy(jArr, i2, jArr, i2 + 1, i - i2);
                jArr[i2] = j;
                return jArr;
            }
            long[] jArr2 = new long[growSize(i)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            jArr2[i2] = j;
            System.arraycopy(jArr, i2, jArr2, i2 + 1, jArr.length - i2);
            return jArr2;
        }
        return (long[]) invokeCommon.objValue;
    }

    public static <T> T[] insert(T[] tArr, int i, int i2, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{tArr, Integer.valueOf(i), Integer.valueOf(i2), t})) == null) {
            if (i + 1 <= tArr.length) {
                System.arraycopy(tArr, i2, tArr, i2 + 1, i - i2);
                tArr[i2] = t;
                return tArr;
            }
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i)));
            System.arraycopy(tArr, 0, tArr2, 0, i2);
            tArr2[i2] = t;
            System.arraycopy(tArr, i2, tArr2, i2 + 1, tArr.length - i2);
            return tArr2;
        }
        return (T[]) ((Object[]) invokeCommon.objValue);
    }

    public static boolean[] insert(boolean[] zArr, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{zArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i + 1 <= zArr.length) {
                System.arraycopy(zArr, i2, zArr, i2 + 1, i - i2);
                zArr[i2] = z;
                return zArr;
            }
            boolean[] zArr2 = new boolean[growSize(i)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            zArr2[i2] = z;
            System.arraycopy(zArr, i2, zArr2, i2 + 1, zArr.length - i2);
            return zArr2;
        }
        return (boolean[]) invokeCommon.objValue;
    }
}
