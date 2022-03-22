package com.baidu.clientupdate.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f25244b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        int i;
        int i2;
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
        a = new byte[128];
        f25244b = new char[64];
        int i3 = 0;
        for (int i4 = 0; i4 < 128; i4++) {
            a[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            a[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            a[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            a[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = a;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i8 = 0; i8 <= 25; i8++) {
            f25244b[i8] = (char) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            f25244b[i] = (char) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            f25244b[i2] = (char) (i3 + 48);
            i2++;
            i3++;
        }
        char[] cArr = f25244b;
        cArr[62] = '+';
        cArr[63] = WebvttCueParser.CHAR_SLASH;
    }

    public static int a(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cArr)) == null) {
            if (cArr == null) {
                return 0;
            }
            int length = cArr.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (!a(cArr[i2])) {
                    cArr[i] = cArr[i2];
                    i++;
                }
            }
            return i;
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
            int i = a2 / 4;
            if (i == 0) {
                return new byte[0];
            }
            byte[] bArr = new byte[i * 3];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < i - 1) {
                int i5 = i3 + 1;
                char c2 = charArray[i3];
                if (c(c2)) {
                    int i6 = i5 + 1;
                    char c3 = charArray[i5];
                    if (c(c3)) {
                        int i7 = i6 + 1;
                        char c4 = charArray[i6];
                        if (c(c4)) {
                            int i8 = i7 + 1;
                            char c5 = charArray[i7];
                            if (c(c5)) {
                                byte[] bArr2 = a;
                                byte b2 = bArr2[c2];
                                byte b3 = bArr2[c3];
                                byte b4 = bArr2[c4];
                                byte b5 = bArr2[c5];
                                int i9 = i4 + 1;
                                bArr[i4] = (byte) ((b2 << 2) | (b3 >> 4));
                                int i10 = i9 + 1;
                                bArr[i9] = (byte) (((b3 & 15) << 4) | ((b4 >> 2) & 15));
                                i4 = i10 + 1;
                                bArr[i10] = (byte) ((b4 << 6) | b5);
                                i2++;
                                i3 = i8;
                            }
                        }
                    }
                }
                return null;
            }
            int i11 = i3 + 1;
            char c6 = charArray[i3];
            if (c(c6)) {
                int i12 = i11 + 1;
                char c7 = charArray[i11];
                if (c(c7)) {
                    byte[] bArr3 = a;
                    byte b6 = bArr3[c6];
                    byte b7 = bArr3[c7];
                    int i13 = i12 + 1;
                    char c8 = charArray[i12];
                    char c9 = charArray[i13];
                    if (c(c8) && c(c9)) {
                        byte[] bArr4 = a;
                        byte b8 = bArr4[c8];
                        byte b9 = bArr4[c9];
                        int i14 = i4 + 1;
                        bArr[i4] = (byte) ((b6 << 2) | (b7 >> 4));
                        bArr[i14] = (byte) (((b7 & 15) << 4) | ((b8 >> 2) & 15));
                        bArr[i14 + 1] = (byte) (b9 | (b8 << 6));
                        return bArr;
                    } else if (b(c8) && b(c9)) {
                        if ((b7 & 15) != 0) {
                            return null;
                        }
                        int i15 = i2 * 3;
                        byte[] bArr5 = new byte[i15 + 1];
                        System.arraycopy(bArr, 0, bArr5, 0, i15);
                        bArr5[i4] = (byte) ((b6 << 2) | (b7 >> 4));
                        return bArr5;
                    } else if (b(c8) || !b(c9)) {
                        return null;
                    } else {
                        byte b10 = a[c8];
                        if ((b10 & 3) != 0) {
                            return null;
                        }
                        int i16 = i2 * 3;
                        byte[] bArr6 = new byte[i16 + 2];
                        System.arraycopy(bArr, 0, bArr6, 0, i16);
                        bArr6[i4] = (byte) ((b6 << 2) | (b7 >> 4));
                        bArr6[i4 + 1] = (byte) (((b10 >> 2) & 15) | ((b7 & 15) << 4));
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 == '=' : invokeCommon.booleanValue;
    }

    public static boolean c(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 < 128 && a[c2] != -1 : invokeCommon.booleanValue;
    }
}
