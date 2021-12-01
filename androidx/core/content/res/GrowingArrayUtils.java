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

    public GrowingArrayUtils() {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object[], java.lang.Object] */
    public static <T> T[] append(T[] tArr, int i2, T t) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, tArr, i2, t)) == null) {
            if (i2 + 1 > tArr.length) {
                ?? r0 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i2));
                System.arraycopy(tArr, 0, r0, 0, i2);
                tArr = r0;
            }
            tArr[i2] = t;
            return tArr;
        }
        return (T[]) ((Object[]) invokeLIL.objValue);
    }

    public static int growSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) {
            if (i2 <= 4) {
                return 8;
            }
            return i2 * 2;
        }
        return invokeI.intValue;
    }

    public static <T> T[] insert(T[] tArr, int i2, int i3, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{tArr, Integer.valueOf(i2), Integer.valueOf(i3), t})) == null) {
            if (i2 + 1 <= tArr.length) {
                System.arraycopy(tArr, i3, tArr, i3 + 1, i2 - i3);
                tArr[i3] = t;
                return tArr;
            }
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i2)));
            System.arraycopy(tArr, 0, tArr2, 0, i3);
            tArr2[i3] = t;
            System.arraycopy(tArr, i3, tArr2, i3 + 1, tArr.length - i3);
            return tArr2;
        }
        return (T[]) ((Object[]) invokeCommon.objValue);
    }

    public static int[] append(int[] iArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, iArr, i2, i3)) == null) {
            if (i2 + 1 > iArr.length) {
                int[] iArr2 = new int[growSize(i2)];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                iArr = iArr2;
            }
            iArr[i2] = i3;
            return iArr;
        }
        return (int[]) invokeLII.objValue;
    }

    public static int[] insert(int[] iArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65542, null, iArr, i2, i3, i4)) == null) {
            if (i2 + 1 <= iArr.length) {
                System.arraycopy(iArr, i3, iArr, i3 + 1, i2 - i3);
                iArr[i3] = i4;
                return iArr;
            }
            int[] iArr2 = new int[growSize(i2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            iArr2[i3] = i4;
            System.arraycopy(iArr, i3, iArr2, i3 + 1, iArr.length - i3);
            return iArr2;
        }
        return (int[]) invokeLIII.objValue;
    }

    public static long[] append(long[] jArr, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{jArr, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (i2 + 1 > jArr.length) {
                long[] jArr2 = new long[growSize(i2)];
                System.arraycopy(jArr, 0, jArr2, 0, i2);
                jArr = jArr2;
            }
            jArr[i2] = j2;
            return jArr;
        }
        return (long[]) invokeCommon.objValue;
    }

    public static boolean[] append(boolean[] zArr, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{zArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 + 1 > zArr.length) {
                boolean[] zArr2 = new boolean[growSize(i2)];
                System.arraycopy(zArr, 0, zArr2, 0, i2);
                zArr = zArr2;
            }
            zArr[i2] = z;
            return zArr;
        }
        return (boolean[]) invokeCommon.objValue;
    }

    public static long[] insert(long[] jArr, int i2, int i3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{jArr, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
            if (i2 + 1 <= jArr.length) {
                System.arraycopy(jArr, i3, jArr, i3 + 1, i2 - i3);
                jArr[i3] = j2;
                return jArr;
            }
            long[] jArr2 = new long[growSize(i2)];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            jArr2[i3] = j2;
            System.arraycopy(jArr, i3, jArr2, i3 + 1, jArr.length - i3);
            return jArr2;
        }
        return (long[]) invokeCommon.objValue;
    }

    public static boolean[] insert(boolean[] zArr, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{zArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (i2 + 1 <= zArr.length) {
                System.arraycopy(zArr, i3, zArr, i3 + 1, i2 - i3);
                zArr[i3] = z;
                return zArr;
            }
            boolean[] zArr2 = new boolean[growSize(i2)];
            System.arraycopy(zArr, 0, zArr2, 0, i3);
            zArr2[i3] = z;
            System.arraycopy(zArr, i3, zArr2, i3 + 1, zArr.length - i3);
            return zArr2;
        }
        return (boolean[]) invokeCommon.objValue;
    }
}
