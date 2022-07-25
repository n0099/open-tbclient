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
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "c";
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] b;
    public int[] c;
    public int[] d;

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
        this.b = new int[]{1732584193, -271733879, -1732584194, 271733878, -1009589776};
        this.c = new int[5];
        this.d = new int[80];
    }

    public static int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) ? (i >>> (32 - i2)) | (i << i2) : invokeII.intValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder("");
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            for (byte b : bArr) {
                String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.CHINA);
                if (upperCase.length() < 2) {
                    sb.append(0);
                }
                sb.append(upperCase);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
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
                    byte[] b = cVar.b(e.b(str2));
                    for (int i = 0; i < 20; i++) {
                        bArr3[i] = b[i];
                    }
                    length = 20;
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
                return cVar.b(a(bArr2, cVar.b(a(bArr, e.b(str)))));
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, bArr2)) == null) {
            byte[] bArr3 = new byte[bArr2.length + 64];
            for (int i = 0; i < 64; i++) {
                bArr3[i] = bArr[i];
            }
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                bArr3[i2 + 64] = bArr2[i2];
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    private byte[] b(byte[] bArr) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65542, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        System.arraycopy(this.b, 0, this.c, 0, 5);
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
        long j = length << 3;
        byte b = (byte) ((j >> 8) & 255);
        byte b2 = (byte) ((j >> 32) & 255);
        byte b3 = (byte) ((j >> 40) & 255);
        int i6 = i4 + 1;
        bArr2[i4] = (byte) (j >> 56);
        int i7 = i6 + 1;
        bArr2[i6] = (byte) (255 & (j >> 48));
        int i8 = i7 + 1;
        bArr2[i7] = b3;
        int i9 = i8 + 1;
        bArr2[i8] = b2;
        int i10 = i9 + 1;
        bArr2[i9] = (byte) ((j >> 24) & 255);
        int i11 = i10 + 1;
        bArr2[i10] = (byte) ((j >> 16) & 255);
        bArr2[i11] = b;
        bArr2[i11 + 1] = (byte) (j & 255);
        int i12 = i2 / 64;
        int i13 = 0;
        while (true) {
            if (i13 >= i12) {
                break;
            }
            for (int i14 = 0; i14 < 16; i14++) {
                int i15 = (i13 << 6) + (i14 << 2);
                this.d[i14] = (bArr2[i15 + 3] & 255) | ((bArr2[i15] & 255) << 24) | ((bArr2[i15 + 1] & 255) << 16) | ((bArr2[i15 + 2] & 255) << 8);
            }
            for (int i16 = 16; i16 <= 79; i16++) {
                int[] iArr = this.d;
                iArr[i16] = a(((iArr[i16 - 3] ^ iArr[i16 - 8]) ^ iArr[i16 - 14]) ^ iArr[i16 - 16], 1);
            }
            int[] iArr2 = new int[5];
            int i17 = 0;
            for (int i18 = 5; i17 < i18; i18 = 5) {
                iArr2[i17] = this.c[i17];
                i17++;
            }
            for (int i19 = 0; i19 <= 19; i19++) {
                int a2 = a(iArr2[0], 5);
                int i20 = iArr2[1];
                int i21 = iArr2[2];
                int i22 = iArr2[3];
                iArr2[4] = iArr2[3];
                iArr2[3] = iArr2[2];
                iArr2[2] = a(iArr2[1], 30);
                iArr2[1] = iArr2[0];
                iArr2[0] = a2 + ((i20 & i21) | ((~i20) & i22)) + iArr2[4] + this.d[i19] + 1518500249;
            }
            for (int i23 = 20; i23 <= 39; i23++) {
                iArr2[4] = iArr2[3];
                iArr2[3] = iArr2[2];
                iArr2[2] = a(iArr2[1], 30);
                iArr2[1] = iArr2[0];
                iArr2[0] = a(iArr2[0], 5) + ((iArr2[1] ^ iArr2[2]) ^ iArr2[3]) + iArr2[4] + this.d[i23] + 1859775393;
            }
            char c = 0;
            for (int i24 = 40; i24 <= 59; i24++) {
                int a3 = a(iArr2[c], 5);
                int i25 = iArr2[1];
                int i26 = iArr2[2];
                int i27 = iArr2[3];
                iArr2[4] = iArr2[3];
                iArr2[3] = iArr2[2];
                iArr2[2] = a(iArr2[1], 30);
                c = 0;
                iArr2[1] = iArr2[0];
                iArr2[0] = (((a3 + (((i25 & i26) | (i25 & i27)) | (i26 & i27))) + iArr2[4]) + this.d[i24]) - 1894007588;
            }
            int i28 = 60;
            while (i28 <= 79) {
                iArr2[4] = iArr2[3];
                iArr2[3] = iArr2[2];
                iArr2[2] = a(iArr2[1], 30);
                iArr2[1] = iArr2[0];
                iArr2[0] = (((a(iArr2[c], 5) + ((iArr2[1] ^ iArr2[2]) ^ iArr2[3])) + iArr2[4]) + this.d[i28]) - 899497514;
                i28++;
                c = 0;
            }
            for (int i29 = 0; i29 < 5; i29++) {
                int[] iArr3 = this.c;
                iArr3[i29] = iArr3[i29] + iArr2[i29];
            }
            int i30 = 0;
            while (true) {
                int[] iArr4 = this.d;
                if (i30 < iArr4.length) {
                    iArr4[i30] = 0;
                    i30++;
                }
            }
            i13++;
        }
        byte[] bArr3 = new byte[20];
        int i31 = 0;
        while (true) {
            int[] iArr5 = this.c;
            if (i31 >= iArr5.length) {
                return bArr3;
            }
            int i32 = iArr5[i31];
            int i33 = i31 << 2;
            bArr3[i33] = (byte) (i32 >>> 24);
            bArr3[i33 + 1] = (byte) (i32 >>> 16);
            bArr3[i33 + 2] = (byte) (i32 >>> 8);
            bArr3[i33 + 3] = (byte) i32;
            i31++;
        }
    }
}
