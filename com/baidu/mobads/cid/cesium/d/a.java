package com.baidu.mobads.cid.cesium.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f42874a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-480609342, "Lcom/baidu/mobads/cid/cesium/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-480609342, "Lcom/baidu/mobads/cid/cesium/d/a;");
                return;
            }
        }
        f42874a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? a(bArr, bArr.length) : (byte[]) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        byte b2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i2)) == null) {
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
