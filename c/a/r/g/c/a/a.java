package c.a.r.g.c.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f29319a;

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f29320b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f29321c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1058589215, "Lc/a/r/g/c/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1058589215, "Lc/a/r/g/c/a/a;");
                return;
            }
        }
        f29319a = "0123456789ABCDEF".toCharArray();
        f29320b = "0123456789abcdef".toCharArray();
        f29321c = new byte[128];
        for (int i2 = 0; i2 < 10; i2++) {
            byte[] bArr = f29321c;
            bArr[i2 + 48] = (byte) i2;
            byte b2 = (byte) (i2 + 10);
            bArr[i2 + 65] = b2;
            bArr[i2 + 97] = b2;
        }
    }

    public static char[] a(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, bArr, z)) == null) {
            char[] cArr = z ? f29319a : f29320b;
            char[] cArr2 = new char[bArr.length * 2];
            int i2 = 0;
            for (byte b2 : bArr) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b2 & 240) >>> 4];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b2 & 15];
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
