package c.a.p.h.c.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f11785b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f11786c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1100540736, "Lc/a/p/h/c/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1100540736, "Lc/a/p/h/c/a/a;");
                return;
            }
        }
        a = "0123456789ABCDEF".toCharArray();
        f11785b = "0123456789abcdef".toCharArray();
        f11786c = new byte[128];
        for (int i = 0; i < 10; i++) {
            byte[] bArr = f11786c;
            bArr[i + 48] = (byte) i;
            byte b2 = (byte) (i + 10);
            bArr[i + 65] = b2;
            bArr[i + 97] = b2;
        }
    }

    public static char[] a(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, bArr, z)) == null) {
            char[] cArr = z ? a : f11785b;
            char[] cArr2 = new char[bArr.length * 2];
            int i = 0;
            for (byte b2 : bArr) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b2 & 240) >>> 4];
                i = i2 + 1;
                cArr2[i2] = cArr[b2 & 15];
            }
            return cArr2;
        }
        return (char[]) invokeLZ.objValue;
    }

    public static String b(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, bArr, z)) == null) ? new String(a(bArr, z)) : (String) invokeLZ.objValue;
    }
}
