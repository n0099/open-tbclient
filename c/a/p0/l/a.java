package c.a.p0.l;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.un.i1;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bArr, bArr2)) == null) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance(i1.f57242c);
                byte[] bArr3 = new byte[16];
                for (int i2 = 0; i2 < 16; i2++) {
                    bArr3[i2] = 0;
                }
                cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                byte[] doFinal = cipher.doFinal(bArr2);
                byte[] e2 = g.e(bArr2);
                byte[] bArr4 = new byte[doFinal.length + e2.length];
                System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
                System.arraycopy(e2, 0, bArr4, doFinal.length, e2.length);
                return bArr4;
            } catch (Throwable th) {
                c.d(th);
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, bArr, bArr2, z)) == null) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance(i1.f57242c);
                byte[] bArr3 = new byte[16];
                for (int i2 = 0; i2 < 16; i2++) {
                    bArr3[i2] = 0;
                }
                cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                if (z) {
                    byte[] bArr4 = new byte[bArr2.length - 16];
                    System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
                    bArr2 = bArr4;
                }
                return cipher.doFinal(bArr2);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (byte[]) invokeLLZ.objValue;
    }
}
