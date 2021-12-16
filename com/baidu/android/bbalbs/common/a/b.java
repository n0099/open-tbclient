package com.baidu.android.bbalbs.common.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1513323462, "Lcom/baidu/android/bbalbs/common/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1513323462, "Lcom/baidu/android/bbalbs/common/a/b;");
                return;
            }
        }
        a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    }

    public static String a(byte[] bArr, String str) throws UnsupportedEncodingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, str)) == null) {
            int length = (bArr.length * 4) / 3;
            byte[] bArr2 = new byte[length + (length / 76) + 3];
            int length2 = bArr.length - (bArr.length % 3);
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < length2; i4 += 3) {
                int i5 = i2 + 1;
                byte[] bArr3 = a;
                bArr2[i2] = bArr3[(bArr[i4] & 255) >> 2];
                int i6 = i5 + 1;
                int i7 = i4 + 1;
                bArr2[i5] = bArr3[((bArr[i4] & 3) << 4) | ((bArr[i7] & 255) >> 4)];
                int i8 = i6 + 1;
                int i9 = i4 + 2;
                bArr2[i6] = bArr3[((bArr[i7] & 15) << 2) | ((bArr[i9] & 255) >> 6)];
                i2 = i8 + 1;
                bArr2[i8] = bArr3[bArr[i9] & 63];
                if ((i2 - i3) % 76 == 0 && i2 != 0) {
                    bArr2[i2] = 10;
                    i3++;
                    i2++;
                }
            }
            int length3 = bArr.length % 3;
            if (length3 == 1) {
                int i10 = i2 + 1;
                byte[] bArr4 = a;
                bArr2[i2] = bArr4[(bArr[length2] & 255) >> 2];
                int i11 = i10 + 1;
                bArr2[i10] = bArr4[(bArr[length2] & 3) << 4];
                int i12 = i11 + 1;
                bArr2[i11] = 61;
                i2 = i12 + 1;
                bArr2[i12] = 61;
            } else if (length3 == 2) {
                int i13 = i2 + 1;
                byte[] bArr5 = a;
                bArr2[i2] = bArr5[(bArr[length2] & 255) >> 2];
                int i14 = i13 + 1;
                int i15 = length2 + 1;
                bArr2[i13] = bArr5[((bArr[i15] & 255) >> 4) | ((bArr[length2] & 3) << 4)];
                int i16 = i14 + 1;
                bArr2[i14] = bArr5[(bArr[i15] & 15) << 2];
                i2 = i16 + 1;
                bArr2[i16] = 61;
            }
            return new String(bArr2, 0, i2, str);
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? a(bArr, bArr.length) : (byte[]) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        byte b2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i2)) == null) {
            int i4 = (i2 / 4) * 3;
            if (i4 == 0) {
                return new byte[0];
            }
            byte[] bArr2 = new byte[i4];
            int i5 = i2;
            int i6 = 0;
            while (true) {
                byte b3 = bArr[i5 - 1];
                b2 = 10;
                if (b3 != 10 && b3 != 13 && b3 != 32 && b3 != 9) {
                    if (b3 != 61) {
                        break;
                    }
                    i6++;
                }
                i5--;
            }
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i7 < i5) {
                byte b4 = bArr[i7];
                if (b4 != b2 && b4 != 13 && b4 != 32 && b4 != 9) {
                    if (b4 >= 65 && b4 <= 90) {
                        i3 = b4 - 65;
                    } else if (b4 >= 97 && b4 <= 122) {
                        i3 = b4 - 71;
                    } else if (b4 >= 48 && b4 <= 57) {
                        i3 = b4 + 4;
                    } else if (b4 == 43) {
                        i3 = 62;
                    } else if (b4 != 47) {
                        return null;
                    } else {
                        i3 = 63;
                    }
                    i8 = ((byte) i3) | (i8 << 6);
                    if (i10 % 4 == 3) {
                        int i11 = i9 + 1;
                        bArr2[i9] = (byte) ((16711680 & i8) >> 16);
                        int i12 = i11 + 1;
                        bArr2[i11] = (byte) ((65280 & i8) >> 8);
                        bArr2[i12] = (byte) (i8 & 255);
                        i9 = i12 + 1;
                    }
                    i10++;
                }
                i7++;
                b2 = 10;
            }
            if (i6 > 0) {
                int i13 = i8 << (i6 * 6);
                int i14 = i9 + 1;
                bArr2[i9] = (byte) ((i13 & 16711680) >> 16);
                if (i6 == 1) {
                    i9 = i14 + 1;
                    bArr2[i14] = (byte) ((i13 & 65280) >> 8);
                } else {
                    i9 = i14;
                }
            }
            byte[] bArr3 = new byte[i9];
            System.arraycopy(bArr2, 0, bArr3, 0, i9);
            return bArr3;
        }
        return (byte[]) invokeLI.objValue;
    }
}
