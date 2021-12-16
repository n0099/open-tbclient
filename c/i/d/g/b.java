package c.i.d.g;

import c.i.d.a.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65536, null, j2)) == null) {
            n.h((j2 >> 8) == 0, "out of range: %s", j2);
            return (byte) j2;
        }
        return invokeJ.byteValue;
    }

    public static int b(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) ? c(b2) - c(b3) : invokeCommon.intValue;
    }

    public static int c(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b2)) == null) ? b2 & 255 : invokeB.intValue;
    }
}
