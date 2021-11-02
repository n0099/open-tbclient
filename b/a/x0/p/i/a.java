package b.a.x0.p.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static double a(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, byteBuffer, i2)) == null) {
            if (byteBuffer == null || i2 == 0) {
                return 0.0d;
            }
            byteBuffer.position(i2);
            byteBuffer.flip();
            byte[] bArr = new byte[i2];
            byteBuffer.get(bArr);
            byteBuffer.position(i2);
            byteBuffer.flip();
            double d2 = 0.0d;
            for (int i3 = 0; i3 < i2; i3 += 2) {
                int i4 = (bArr[i3] & 255) + ((bArr[i3 + 1] & 255) << 8);
                if (i4 >= 32768) {
                    i4 = 65535 - i4;
                }
                d2 += i4 * i4;
            }
            double d3 = (d2 / i2) / 2.0d;
            return Math.abs(d3 > 0.0d ? Math.log10(d3) * 10.0d : 0.0d);
        }
        return invokeLI.doubleValue;
    }
}
