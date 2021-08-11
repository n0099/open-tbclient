package c.a.l0.l;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            byte[] bArr2 = new byte[256];
            for (int i2 = 0; i2 < 256; i2++) {
                bArr2[i2] = (byte) i2;
            }
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < 256; i5++) {
                i4 = ((bArr[i3] & 255) + (bArr2[i5] & 255) + i4) & 255;
                byte b2 = bArr2[i5];
                bArr2[i5] = bArr2[i4];
                bArr2[i4] = b2;
                i3 = (i3 + 1) % bArr.length;
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, bArr2)) == null) {
            if (bArr == null || bArr2 == null) {
                return null;
            }
            return d(bArr, bArr2);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, bArr2)) == null) {
            if (bArr == null || bArr2 == null) {
                return null;
            }
            return d(bArr, bArr2);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, bArr2)) == null) {
            byte[] a2 = a(bArr2);
            byte[] bArr3 = new byte[bArr.length];
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < bArr.length; i4++) {
                i2 = (i2 + 1) & 255;
                i3 = ((a2[i2] & 255) + i3) & 255;
                byte b2 = a2[i2];
                a2[i2] = a2[i3];
                a2[i3] = b2;
                bArr3[i4] = (byte) (a2[((a2[i2] & 255) + (a2[i3] & 255)) & 255] ^ bArr[i4]);
                bArr3[i4] = (byte) (bArr3[i4] ^ 42);
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }
}
