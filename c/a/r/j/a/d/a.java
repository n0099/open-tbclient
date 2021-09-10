package c.a.r.j.a.d;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;
/* loaded from: classes3.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, byteBuffer, i2)) == null) ? byteBuffer.getShort(i2) & UShort.MAX_VALUE : invokeLI.intValue;
    }

    public static long b(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, byteBuffer)) == null) {
            k(byteBuffer);
            return i(byteBuffer, byteBuffer.position() + 16);
        }
        return invokeL.longValue;
    }

    public static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, randomAccessFile)) == null) {
            if (randomAccessFile.length() < 22) {
                return null;
            }
            Pair<ByteBuffer, Long> d2 = d(randomAccessFile, 0);
            return d2 != null ? d2 : d(randomAccessFile, 65535);
        }
        return (Pair) invokeL.objValue;
    }

    public static Pair<ByteBuffer, Long> d(RandomAccessFile randomAccessFile, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, randomAccessFile, i2)) == null) {
            if (i2 < 0 || i2 > 65535) {
                throw new IllegalArgumentException("maxCommentSize: " + i2);
            }
            long length = randomAccessFile.length();
            if (length < 22) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i2, length - 22)) + 22);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            long capacity = length - allocate.capacity();
            randomAccessFile.seek(capacity);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            int j2 = j(allocate);
            if (j2 == -1) {
                return null;
            }
            allocate.position(j2);
            ByteBuffer slice = allocate.slice();
            slice.order(ByteOrder.LITTLE_ENDIAN);
            return Pair.create(slice, Long.valueOf(capacity + j2));
        }
        return (Pair) invokeLI.objValue;
    }

    public static void e(ByteBuffer byteBuffer, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (j2 >= 0 && j2 <= 4294967295L) {
                byteBuffer.putInt(byteBuffer.position() + i2, (int) j2);
                return;
            }
            throw new IllegalArgumentException("uint32 value of out range: " + j2);
        }
    }

    public static void f(ByteBuffer byteBuffer, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, byteBuffer, j2) == null) {
            k(byteBuffer);
            e(byteBuffer, byteBuffer.position() + 16, j2);
        }
    }

    public static final boolean g(RandomAccessFile randomAccessFile, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(AdIconUtil.BAIDU_LOGO_ID, null, randomAccessFile, j2)) == null) {
            long j3 = j2 - 20;
            if (j3 < 0) {
                return false;
            }
            randomAccessFile.seek(j3);
            return randomAccessFile.readInt() == 1347094023;
        }
        return invokeLJ.booleanValue;
    }

    public static long h(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, byteBuffer)) == null) {
            k(byteBuffer);
            return i(byteBuffer, byteBuffer.position() + 12);
        }
        return invokeL.longValue;
    }

    public static long i(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, byteBuffer, i2)) == null) ? byteBuffer.getInt(i2) & 4294967295L : invokeLI.longValue;
    }

    public static int j(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, byteBuffer)) == null) {
            k(byteBuffer);
            int capacity = byteBuffer.capacity();
            if (capacity < 22) {
                return -1;
            }
            int i2 = capacity - 22;
            int min = Math.min(i2, 65535);
            for (int i3 = 0; i3 < min; i3++) {
                int i4 = i2 - i3;
                if (byteBuffer.getInt(i4) == 101010256 && a(byteBuffer, i4 + 20) == i3) {
                    return i4;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void k(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, byteBuffer) == null) && byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }
}
