package com.baidu.clientupdate.b;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f4627a;

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f4628b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        int i2;
        int i3;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1147830356, "Lcom/baidu/clientupdate/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1147830356, "Lcom/baidu/clientupdate/b/a;");
                return;
            }
        }
        f4627a = new byte[128];
        f4628b = new char[64];
        int i4 = 0;
        for (int i5 = 0; i5 < 128; i5++) {
            f4627a[i5] = -1;
        }
        for (int i6 = 90; i6 >= 65; i6--) {
            f4627a[i6] = (byte) (i6 - 65);
        }
        int i7 = 122;
        while (true) {
            i2 = 26;
            if (i7 < 97) {
                break;
            }
            f4627a[i7] = (byte) ((i7 - 97) + 26);
            i7--;
        }
        int i8 = 57;
        while (true) {
            i3 = 52;
            if (i8 < 48) {
                break;
            }
            f4627a[i8] = (byte) ((i8 - 48) + 52);
            i8--;
        }
        byte[] bArr = f4627a;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i9 = 0; i9 <= 25; i9++) {
            f4628b[i9] = (char) (i9 + 65);
        }
        int i10 = 0;
        while (i2 <= 51) {
            f4628b[i2] = (char) (i10 + 97);
            i2++;
            i10++;
        }
        while (i3 <= 61) {
            f4628b[i3] = (char) (i4 + 48);
            i3++;
            i4++;
        }
        char[] cArr = f4628b;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    public static int a(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cArr)) == null) {
            if (cArr == null) {
                return 0;
            }
            int length = cArr.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!a(cArr[i3])) {
                    cArr[i2] = cArr[i3];
                    i2++;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static boolean a(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t' : invokeCommon.booleanValue;
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            char[] charArray = str.toCharArray();
            int a2 = a(charArray);
            if (a2 % 4 != 0) {
                return null;
            }
            int i2 = a2 / 4;
            if (i2 == 0) {
                return new byte[0];
            }
            byte[] bArr = new byte[i2 * 3];
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i2 - 1) {
                int i6 = i4 + 1;
                char c2 = charArray[i4];
                if (c(c2)) {
                    int i7 = i6 + 1;
                    char c3 = charArray[i6];
                    if (c(c3)) {
                        int i8 = i7 + 1;
                        char c4 = charArray[i7];
                        if (c(c4)) {
                            int i9 = i8 + 1;
                            char c5 = charArray[i8];
                            if (c(c5)) {
                                byte[] bArr2 = f4627a;
                                byte b2 = bArr2[c2];
                                byte b3 = bArr2[c3];
                                byte b4 = bArr2[c4];
                                byte b5 = bArr2[c5];
                                int i10 = i5 + 1;
                                bArr[i5] = (byte) ((b2 << 2) | (b3 >> 4));
                                int i11 = i10 + 1;
                                bArr[i10] = (byte) (((b3 & 15) << 4) | ((b4 >> 2) & 15));
                                i5 = i11 + 1;
                                bArr[i11] = (byte) ((b4 << 6) | b5);
                                i3++;
                                i4 = i9;
                            }
                        }
                    }
                }
                return null;
            }
            int i12 = i4 + 1;
            char c6 = charArray[i4];
            if (c(c6)) {
                int i13 = i12 + 1;
                char c7 = charArray[i12];
                if (c(c7)) {
                    byte[] bArr3 = f4627a;
                    byte b6 = bArr3[c6];
                    byte b7 = bArr3[c7];
                    int i14 = i13 + 1;
                    char c8 = charArray[i13];
                    char c9 = charArray[i14];
                    if (c(c8) && c(c9)) {
                        byte[] bArr4 = f4627a;
                        byte b8 = bArr4[c8];
                        byte b9 = bArr4[c9];
                        int i15 = i5 + 1;
                        bArr[i5] = (byte) ((b6 << 2) | (b7 >> 4));
                        bArr[i15] = (byte) (((b7 & 15) << 4) | ((b8 >> 2) & 15));
                        bArr[i15 + 1] = (byte) (b9 | (b8 << 6));
                        return bArr;
                    } else if (b(c8) && b(c9)) {
                        if ((b7 & 15) != 0) {
                            return null;
                        }
                        int i16 = i3 * 3;
                        byte[] bArr5 = new byte[i16 + 1];
                        System.arraycopy(bArr, 0, bArr5, 0, i16);
                        bArr5[i5] = (byte) ((b6 << 2) | (b7 >> 4));
                        return bArr5;
                    } else if (b(c8) || !b(c9)) {
                        return null;
                    } else {
                        byte b10 = f4627a[c8];
                        if ((b10 & 3) != 0) {
                            return null;
                        }
                        int i17 = i3 * 3;
                        byte[] bArr6 = new byte[i17 + 2];
                        System.arraycopy(bArr, 0, bArr6, 0, i17);
                        bArr6[i5] = (byte) ((b6 << 2) | (b7 >> 4));
                        bArr6[i5 + 1] = (byte) (((b10 >> 2) & 15) | ((b7 & 15) << 4));
                        return bArr6;
                    }
                }
                return null;
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean b(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 == '=' : invokeCommon.booleanValue;
    }

    public static boolean c(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 < 128 && f4627a[c2] != -1 : invokeCommon.booleanValue;
    }
}
