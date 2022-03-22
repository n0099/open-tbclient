package cn.com.chinatelecom.gateway.lib.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "c";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f23644b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f23645c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f23646d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1293574972, "Lcn/com/chinatelecom/gateway/lib/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1293574972, "Lcn/com/chinatelecom/gateway/lib/a/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23644b = new int[]{1732584193, -271733879, -1732584194, 271733878, -1009589776};
        this.f23645c = new int[5];
        this.f23646d = new int[80];
    }

    private int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, this, i, i2)) == null) ? (i >>> (32 - i2)) | (i << i2) : invokeII.intValue;
    }

    private int a(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65539, this, i, i2, i3)) == null) ? ((~i) & i3) | (i2 & i) : invokeIII.intValue;
    }

    private int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, bArr, i)) == null) ? (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) : invokeLI.intValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65541, this) != null) {
            return;
        }
        for (int i = 16; i <= 79; i++) {
            int[] iArr = this.f23646d;
            iArr[i] = a(((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16], 1);
        }
        int[] iArr2 = new int[5];
        for (int i2 = 0; i2 < 5; i2++) {
            iArr2[i2] = this.f23645c[i2];
        }
        for (int i3 = 0; i3 <= 19; i3++) {
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = a(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = a(iArr2[0], 5) + a(iArr2[1], iArr2[2], iArr2[3]) + iArr2[4] + this.f23646d[i3] + 1518500249;
        }
        for (int i4 = 20; i4 <= 39; i4++) {
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = a(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = a(iArr2[0], 5) + b(iArr2[1], iArr2[2], iArr2[3]) + iArr2[4] + this.f23646d[i4] + 1859775393;
        }
        for (int i5 = 40; i5 <= 59; i5++) {
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = a(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = (((a(iArr2[0], 5) + c(iArr2[1], iArr2[2], iArr2[3])) + iArr2[4]) + this.f23646d[i5]) - 1894007588;
        }
        for (int i6 = 60; i6 <= 79; i6++) {
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = a(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = (((a(iArr2[0], 5) + b(iArr2[1], iArr2[2], iArr2[3])) + iArr2[4]) + this.f23646d[i6]) - 899497514;
        }
        for (int i7 = 0; i7 < 5; i7++) {
            int[] iArr3 = this.f23645c;
            iArr3[i7] = iArr3[i7] + iArr2[i7];
        }
        int i8 = 0;
        while (true) {
            int[] iArr4 = this.f23646d;
            if (i8 >= iArr4.length) {
                return;
            }
            iArr4[i8] = 0;
            i8++;
        }
    }

    private void a(int i, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{Integer.valueOf(i), bArr, Integer.valueOf(i2)}) == null) {
            bArr[i2] = (byte) (i >>> 24);
            bArr[i2 + 1] = (byte) (i >>> 16);
            bArr[i2 + 2] = (byte) (i >>> 8);
            bArr[i2 + 3] = (byte) i;
        }
    }

    public static byte[] a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                CtAuth.info(a, "when getHmacSHA1,the key is null");
                return null;
            }
            try {
                byte[] bArr = new byte[64];
                byte[] bArr2 = new byte[64];
                byte[] bArr3 = new byte[64];
                int length = str2.length();
                c cVar = new c();
                if (str2.length() > 64) {
                    byte[] a2 = cVar.a(e.b(str2));
                    length = a2.length;
                    for (int i = 0; i < length; i++) {
                        bArr3[i] = a2[i];
                    }
                } else {
                    byte[] b2 = e.b(str2);
                    for (int i2 = 0; i2 < b2.length; i2++) {
                        bArr3[i2] = b2[i2];
                    }
                }
                while (length < 64) {
                    bArr3[length] = 0;
                    length++;
                }
                for (int i3 = 0; i3 < 64; i3++) {
                    bArr[i3] = (byte) (bArr3[i3] ^ 54);
                    bArr2[i3] = (byte) (bArr3[i3] ^ 92);
                }
                return cVar.a(a(bArr2, cVar.a(a(bArr, e.b(str)))));
            } catch (Throwable th) {
                CtAuth.warn(a, "getHmacSHA1 error", th);
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, bArr, bArr2)) == null) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr3[i] = bArr[i];
            }
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                bArr3[bArr.length + i2] = bArr2[i2];
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    private int b(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65545, this, i, i2, i3)) == null) ? (i ^ i2) ^ i3 : invokeIII.intValue;
    }

    public static String b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder("");
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            for (byte b2 : bArr) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.CHINA);
                if (upperCase.length() < 2) {
                    sb.append(0);
                }
                sb.append(upperCase);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private int c(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65547, this, i, i2, i3)) == null) ? (i & i3) | (i & i2) | (i2 & i3) : invokeIII.intValue;
    }

    private int c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, bArr)) == null) {
            int[] iArr = this.f23644b;
            System.arraycopy(iArr, 0, this.f23645c, 0, iArr.length);
            byte[] d2 = d(bArr);
            int length = d2.length / 64;
            for (int i = 0; i < length; i++) {
                for (int i2 = 0; i2 < 16; i2++) {
                    this.f23646d[i2] = a(d2, (i * 64) + (i2 * 4));
                }
                a();
            }
            return 20;
        }
        return invokeL.intValue;
    }

    private byte[] d(byte[] bArr) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, bArr)) == null) {
            int length = bArr.length;
            int i3 = length % 64;
            if (i3 < 56) {
                i = 55 - i3;
                i2 = (length - i3) + 64;
            } else if (i3 == 56) {
                i2 = length + 8 + 64;
                i = 63;
            } else {
                i = (63 - i3) + 56;
                i2 = ((length + 64) - i3) + 64;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            int i4 = length + 1;
            bArr2[length] = Byte.MIN_VALUE;
            int i5 = 0;
            while (i5 < i) {
                bArr2[i4] = 0;
                i5++;
                i4++;
            }
            long j = length * 8;
            byte b2 = (byte) ((j >> 8) & 255);
            byte b3 = (byte) ((j >> 16) & 255);
            byte b4 = (byte) ((j >> 24) & 255);
            byte b5 = (byte) ((j >> 32) & 255);
            byte b6 = (byte) ((j >> 40) & 255);
            byte b7 = (byte) (j >> 56);
            int i6 = i4 + 1;
            bArr2[i4] = b7;
            int i7 = i6 + 1;
            bArr2[i6] = (byte) (255 & (j >> 48));
            int i8 = i7 + 1;
            bArr2[i7] = b6;
            int i9 = i8 + 1;
            bArr2[i8] = b5;
            int i10 = i9 + 1;
            bArr2[i9] = b4;
            int i11 = i10 + 1;
            bArr2[i10] = b3;
            bArr2[i11] = b2;
            bArr2[i11 + 1] = (byte) (j & 255);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        c(bArr);
        byte[] bArr2 = new byte[20];
        int i = 0;
        while (true) {
            int[] iArr = this.f23645c;
            if (i >= iArr.length) {
                return bArr2;
            }
            a(iArr[i], bArr2, i * 4);
            i++;
        }
    }
}
