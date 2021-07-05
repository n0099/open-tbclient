package com.alipay.sdk.encrypt;

import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f1882a = 128;

    /* renamed from: b  reason: collision with root package name */
    public static final int f1883b = 64;

    /* renamed from: c  reason: collision with root package name */
    public static final int f1884c = 24;

    /* renamed from: d  reason: collision with root package name */
    public static final int f1885d = 8;

    /* renamed from: e  reason: collision with root package name */
    public static final int f1886e = 16;

    /* renamed from: f  reason: collision with root package name */
    public static final int f1887f = 4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f1888g = -128;

    /* renamed from: h  reason: collision with root package name */
    public static final char f1889h = '=';

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f1890i;
    public static final char[] j;
    public transient /* synthetic */ FieldHolder $fh;

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
        f1890i = new byte[128];
        j = new char[64];
        int i4 = 0;
        for (int i5 = 0; i5 < 128; i5++) {
            f1890i[i5] = -1;
        }
        for (int i6 = 90; i6 >= 65; i6--) {
            f1890i[i6] = (byte) (i6 - 65);
        }
        int i7 = 122;
        while (true) {
            i2 = 26;
            if (i7 < 97) {
                break;
            }
            f1890i[i7] = (byte) ((i7 - 97) + 26);
            i7--;
        }
        int i8 = 57;
        while (true) {
            i3 = 52;
            if (i8 < 48) {
                break;
            }
            f1890i[i8] = (byte) ((i8 - 48) + 52);
            i8--;
        }
        byte[] bArr = f1890i;
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
        cArr[63] = '/';
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

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            int length = bArr.length * 8;
            if (length == 0) {
                return "";
            }
            int i2 = length % 24;
            int i3 = length / 24;
            char[] cArr = new char[(i2 != 0 ? i3 + 1 : i3) * 4];
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i4 < i3) {
                int i7 = i5 + 1;
                byte b2 = bArr[i5];
                int i8 = i7 + 1;
                byte b3 = bArr[i7];
                int i9 = i8 + 1;
                byte b4 = bArr[i8];
                byte b5 = (byte) (b3 & 15);
                byte b6 = (byte) (b2 & 3);
                int i10 = b2 & ByteCompanionObject.MIN_VALUE;
                int i11 = b2 >> 2;
                if (i10 != 0) {
                    i11 ^= 192;
                }
                byte b7 = (byte) i11;
                int i12 = b3 & ByteCompanionObject.MIN_VALUE;
                int i13 = b3 >> 4;
                if (i12 != 0) {
                    i13 ^= 240;
                }
                byte b8 = (byte) i13;
                int i14 = (b4 & ByteCompanionObject.MIN_VALUE) == 0 ? b4 >> 6 : (b4 >> 6) ^ GDiffPatcher.COPY_INT_UBYTE;
                int i15 = i6 + 1;
                char[] cArr2 = j;
                cArr[i6] = cArr2[b7];
                int i16 = i15 + 1;
                cArr[i15] = cArr2[(b6 << 4) | b8];
                int i17 = i16 + 1;
                cArr[i16] = cArr2[(b5 << 2) | ((byte) i14)];
                cArr[i17] = cArr2[b4 & 63];
                i4++;
                i6 = i17 + 1;
                i5 = i9;
            }
            if (i2 == 8) {
                byte b9 = bArr[i5];
                byte b10 = (byte) (b9 & 3);
                int i18 = b9 & ByteCompanionObject.MIN_VALUE;
                int i19 = b9 >> 2;
                if (i18 != 0) {
                    i19 ^= 192;
                }
                int i20 = i6 + 1;
                char[] cArr3 = j;
                cArr[i6] = cArr3[(byte) i19];
                int i21 = i20 + 1;
                cArr[i20] = cArr3[b10 << 4];
                cArr[i21] = f1889h;
                cArr[i21 + 1] = f1889h;
            } else if (i2 == 16) {
                byte b11 = bArr[i5];
                byte b12 = bArr[i5 + 1];
                byte b13 = (byte) (b12 & 15);
                byte b14 = (byte) (b11 & 3);
                int i22 = b11 & ByteCompanionObject.MIN_VALUE;
                int i23 = b11 >> 2;
                if (i22 != 0) {
                    i23 ^= 192;
                }
                byte b15 = (byte) i23;
                int i24 = b12 & ByteCompanionObject.MIN_VALUE;
                int i25 = b12 >> 4;
                if (i24 != 0) {
                    i25 ^= 240;
                }
                int i26 = i6 + 1;
                char[] cArr4 = j;
                cArr[i6] = cArr4[b15];
                int i27 = i26 + 1;
                cArr[i26] = cArr4[((byte) i25) | (b14 << 4)];
                cArr[i27] = cArr4[b13 << 2];
                cArr[i27 + 1] = f1889h;
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t' : invokeCommon.booleanValue;
    }

    public static boolean b(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 == '=' : invokeCommon.booleanValue;
    }

    public static boolean c(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 < 128 && f1890i[c2] != -1 : invokeCommon.booleanValue;
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
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
                                byte[] bArr2 = f1890i;
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
                    byte[] bArr3 = f1890i;
                    byte b6 = bArr3[c6];
                    byte b7 = bArr3[c7];
                    int i14 = i13 + 1;
                    char c8 = charArray[i13];
                    char c9 = charArray[i14];
                    if (c(c8) && c(c9)) {
                        byte[] bArr4 = f1890i;
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
                        byte b10 = f1890i[c8];
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
                if (!a(cArr[i3])) {
                    cArr[i2] = cArr[i3];
                    i2++;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }
}
