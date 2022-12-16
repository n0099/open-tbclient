package com.alipay.sdk.encrypt;

import androidx.core.view.InputDeviceCompat;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 128;
    public static final int b = 64;
    public static final int c = 24;
    public static final int d = 8;
    public static final int e = 16;
    public static final int f = 4;
    public static final int g = -128;
    public static final char h = '=';
    public static final byte[] i;
    public static final char[] j;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean b(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 == '=' : invokeCommon.booleanValue;
    }

    public static boolean c(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t' : invokeCommon.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        int i2;
        int i3;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1795807644, "Lcom/alipay/sdk/encrypt/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1795807644, "Lcom/alipay/sdk/encrypt/a;");
                return;
            }
        }
        i = new byte[128];
        j = new char[64];
        int i4 = 0;
        for (int i5 = 0; i5 < 128; i5++) {
            i[i5] = -1;
        }
        for (int i6 = 90; i6 >= 65; i6--) {
            i[i6] = (byte) (i6 - 65);
        }
        int i7 = 122;
        while (true) {
            i2 = 26;
            if (i7 < 97) {
                break;
            }
            i[i7] = (byte) ((i7 - 97) + 26);
            i7--;
        }
        int i8 = 57;
        while (true) {
            i3 = 52;
            if (i8 < 48) {
                break;
            }
            i[i8] = (byte) ((i8 - 48) + 52);
            i8--;
        }
        byte[] bArr = i;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i9 = 0; i9 <= 25; i9++) {
            j[i9] = (char) (i9 + 65);
        }
        int i10 = 0;
        while (i2 <= 51) {
            j[i2] = (char) (i10 + 97);
            i2++;
            i10++;
        }
        while (i3 <= 61) {
            j[i3] = (char) (i4 + 48);
            i3++;
            i4++;
        }
        char[] cArr = j;
        cArr[62] = '+';
        cArr[63] = WebvttCueParser.CHAR_SLASH;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cArr)) == null) {
            if (cArr == null) {
                return 0;
            }
            int length = cArr.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!c(cArr[i3])) {
                    cArr[i2] = cArr[i3];
                    i2++;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            int length = bArr.length * 8;
            if (length == 0) {
                return "";
            }
            int i4 = length % 24;
            int i5 = length / 24;
            if (i4 != 0) {
                i2 = i5 + 1;
            } else {
                i2 = i5;
            }
            char[] cArr = new char[i2 * 4];
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < i5) {
                int i9 = i7 + 1;
                byte b2 = bArr[i7];
                int i10 = i9 + 1;
                byte b3 = bArr[i9];
                int i11 = i10 + 1;
                byte b4 = bArr[i10];
                byte b5 = (byte) (b3 & 15);
                byte b6 = (byte) (b2 & 3);
                int i12 = b2 & Byte.MIN_VALUE;
                int i13 = b2 >> 2;
                if (i12 != 0) {
                    i13 ^= 192;
                }
                byte b7 = (byte) i13;
                int i14 = b3 & Byte.MIN_VALUE;
                int i15 = b3 >> 4;
                if (i14 != 0) {
                    i15 ^= 240;
                }
                byte b8 = (byte) i15;
                if ((b4 & Byte.MIN_VALUE) == 0) {
                    i3 = b4 >> 6;
                } else {
                    i3 = (b4 >> 6) ^ GDiffPatcher.COPY_INT_UBYTE;
                }
                int i16 = i8 + 1;
                char[] cArr2 = j;
                cArr[i8] = cArr2[b7];
                int i17 = i16 + 1;
                cArr[i16] = cArr2[(b6 << 4) | b8];
                int i18 = i17 + 1;
                cArr[i17] = cArr2[(b5 << 2) | ((byte) i3)];
                cArr[i18] = cArr2[b4 & 63];
                i6++;
                i8 = i18 + 1;
                i7 = i11;
            }
            if (i4 == 8) {
                byte b9 = bArr[i7];
                byte b10 = (byte) (b9 & 3);
                int i19 = b9 & Byte.MIN_VALUE;
                int i20 = b9 >> 2;
                if (i19 != 0) {
                    i20 ^= 192;
                }
                int i21 = i8 + 1;
                char[] cArr3 = j;
                cArr[i8] = cArr3[(byte) i20];
                int i22 = i21 + 1;
                cArr[i21] = cArr3[b10 << 4];
                cArr[i22] = h;
                cArr[i22 + 1] = h;
            } else if (i4 == 16) {
                byte b11 = bArr[i7];
                byte b12 = bArr[i7 + 1];
                byte b13 = (byte) (b12 & 15);
                byte b14 = (byte) (b11 & 3);
                int i23 = b11 & Byte.MIN_VALUE;
                int i24 = b11 >> 2;
                if (i23 != 0) {
                    i24 ^= 192;
                }
                byte b15 = (byte) i24;
                int i25 = b12 & Byte.MIN_VALUE;
                int i26 = b12 >> 4;
                if (i25 != 0) {
                    i26 ^= 240;
                }
                int i27 = i8 + 1;
                char[] cArr4 = j;
                cArr[i8] = cArr4[b15];
                int i28 = i27 + 1;
                cArr[i27] = cArr4[((byte) i26) | (b14 << 4)];
                cArr[i28] = cArr4[b13 << 2];
                cArr[i28 + 1] = h;
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 < 128 && i[c2] != -1) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
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
                if (a(c2)) {
                    int i7 = i6 + 1;
                    char c3 = charArray[i6];
                    if (a(c3)) {
                        int i8 = i7 + 1;
                        char c4 = charArray[i7];
                        if (a(c4)) {
                            int i9 = i8 + 1;
                            char c5 = charArray[i8];
                            if (a(c5)) {
                                byte[] bArr2 = i;
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
            if (!a(c6)) {
                return null;
            }
            int i13 = i12 + 1;
            char c7 = charArray[i12];
            if (!a(c7)) {
                return null;
            }
            byte[] bArr3 = i;
            byte b6 = bArr3[c6];
            byte b7 = bArr3[c7];
            int i14 = i13 + 1;
            char c8 = charArray[i13];
            char c9 = charArray[i14];
            if (a(c8) && a(c9)) {
                byte[] bArr4 = i;
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
                byte b10 = i[c8];
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
        return (byte[]) invokeL.objValue;
    }
}
