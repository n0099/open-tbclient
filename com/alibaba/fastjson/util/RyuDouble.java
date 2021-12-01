package com.alibaba.fastjson.util;

import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import com.google.android.material.slider.BasicLabelFormatter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes7.dex */
public final class RyuDouble {
    public static /* synthetic */ Interceptable $ic;
    public static final int[][] POW5_INV_SPLIT;
    public static final int[][] POW5_SPLIT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-461043829, "Lcom/alibaba/fastjson/util/RyuDouble;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-461043829, "Lcom/alibaba/fastjson/util/RyuDouble;");
                return;
            }
        }
        POW5_SPLIT = (int[][]) Array.newInstance(int.class, 326, 4);
        POW5_INV_SPLIT = (int[][]) Array.newInstance(int.class, QRScanCodeActivity.DIALOG_PROCESS_IMG_FAILED, 4);
        BigInteger subtract = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        BigInteger subtract2 = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        int i2 = 0;
        while (i2 < 326) {
            BigInteger pow = BigInteger.valueOf(5L).pow(i2);
            int bitLength = pow.bitLength();
            int i3 = i2 == 0 ? 1 : (int) ((((i2 * 23219280) + 10000000) - 1) / 10000000);
            if (i3 == bitLength) {
                if (i2 < POW5_SPLIT.length) {
                    for (int i4 = 0; i4 < 4; i4++) {
                        POW5_SPLIT[i2][i4] = pow.shiftRight(bitLength + OneKeyLoginResult.ONE_KEY_LOGIN_CODE_NOT_MEET_GRAY + ((3 - i4) * 31)).and(subtract).intValue();
                    }
                }
                if (i2 < POW5_INV_SPLIT.length) {
                    BigInteger add = BigInteger.ONE.shiftLeft(bitLength + 121).divide(pow).add(BigInteger.ONE);
                    for (int i5 = 0; i5 < 4; i5++) {
                        if (i5 == 0) {
                            POW5_INV_SPLIT[i2][i5] = add.shiftRight((3 - i5) * 31).intValue();
                        } else {
                            POW5_INV_SPLIT[i2][i5] = add.shiftRight((3 - i5) * 31).and(subtract2).intValue();
                        }
                    }
                }
                i2++;
            } else {
                throw new IllegalStateException(bitLength + " != " + i3);
            }
        }
    }

    public RyuDouble() {
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

    public static String toString(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Double.valueOf(d2)})) == null) {
            char[] cArr = new char[24];
            return new String(cArr, 0, toString(d2, cArr, 0));
        }
        return (String) invokeCommon.objValue;
    }

    public static int toString(double d2, char[] cArr, int i2) {
        InterceptResult invokeCommon;
        int i3;
        boolean z;
        boolean z2;
        long j2;
        long j3;
        int i4;
        long j4;
        boolean z3;
        boolean z4;
        long j5;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z5;
        int i10;
        int i11;
        int i12;
        int i13;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d2), cArr, Integer.valueOf(i2)})) == null) {
            if (!Double.isNaN(d2)) {
                if (d2 == Double.POSITIVE_INFINITY) {
                    int i14 = i2 + 1;
                    cArr[i2] = 'I';
                    int i15 = i14 + 1;
                    cArr[i14] = 'n';
                    int i16 = i15 + 1;
                    cArr[i15] = 'f';
                    int i17 = i16 + 1;
                    cArr[i16] = 'i';
                    int i18 = i17 + 1;
                    cArr[i17] = 'n';
                    int i19 = i18 + 1;
                    cArr[i18] = 'i';
                    int i20 = i19 + 1;
                    cArr[i19] = 't';
                    i9 = i20 + 1;
                    cArr[i20] = 'y';
                } else if (d2 == Double.NEGATIVE_INFINITY) {
                    int i21 = i2 + 1;
                    cArr[i2] = SignatureImpl.SEP;
                    int i22 = i21 + 1;
                    cArr[i21] = 'I';
                    int i23 = i22 + 1;
                    cArr[i22] = 'n';
                    int i24 = i23 + 1;
                    cArr[i23] = 'f';
                    int i25 = i24 + 1;
                    cArr[i24] = 'i';
                    int i26 = i25 + 1;
                    cArr[i25] = 'n';
                    int i27 = i26 + 1;
                    cArr[i26] = 'i';
                    int i28 = i27 + 1;
                    cArr[i27] = 't';
                    i13 = i28 + 1;
                    cArr[i28] = 'y';
                } else {
                    long doubleToLongBits = Double.doubleToLongBits(d2);
                    int i29 = (doubleToLongBits > 0L ? 1 : (doubleToLongBits == 0L ? 0 : -1));
                    if (i29 == 0) {
                        int i30 = i2 + 1;
                        cArr[i2] = '0';
                        int i31 = i30 + 1;
                        cArr[i30] = '.';
                        i13 = i31 + 1;
                        cArr[i31] = '0';
                    } else if (doubleToLongBits == Long.MIN_VALUE) {
                        int i32 = i2 + 1;
                        cArr[i2] = SignatureImpl.SEP;
                        int i33 = i32 + 1;
                        cArr[i32] = '0';
                        int i34 = i33 + 1;
                        cArr[i33] = '.';
                        i9 = i34 + 1;
                        cArr[i34] = '0';
                    } else {
                        int i35 = (int) ((doubleToLongBits >>> 52) & 2047);
                        long j6 = doubleToLongBits & 4503599627370495L;
                        if (i35 == 0) {
                            i3 = -1074;
                        } else {
                            i3 = (i35 - 1023) - 52;
                            j6 |= 4503599627370496L;
                        }
                        boolean z6 = i29 < 0;
                        boolean z7 = (j6 & 1) == 0;
                        long j7 = 4 * j6;
                        long j8 = j7 + 2;
                        int i36 = (j6 != 4503599627370496L || i35 <= 1) ? 1 : 0;
                        long j9 = (j7 - 1) - i36;
                        int i37 = i3 - 2;
                        int i38 = 3;
                        if (i37 >= 0) {
                            int max = Math.max(0, ((int) ((i37 * 3010299) / 10000000)) - 1);
                            int i39 = ((((-i37) + max) + (((max == 0 ? 1 : (int) ((((max * 23219280) + 10000000) - 1) / 10000000)) + 122) - 1)) - 93) - 21;
                            if (i39 >= 0) {
                                int[] iArr = POW5_INV_SPLIT[max];
                                long j10 = j7 >>> 31;
                                long j11 = j7 & 2147483647L;
                                z = z6;
                                long j12 = ((((((((((((j11 * iArr[3]) >>> 31) + (iArr[2] * j11)) + (j10 * iArr[3])) >>> 31) + (iArr[1] * j11)) + (iArr[2] * j10)) >>> 31) + (iArr[0] * j11)) + (iArr[1] * j10)) >>> 21) + ((iArr[0] * j10) << 10)) >>> i39;
                                long j13 = j8 >>> 31;
                                long j14 = j8 & 2147483647L;
                                z2 = z7;
                                long j15 = ((((((((((((j14 * iArr[3]) >>> 31) + (iArr[2] * j14)) + (j13 * iArr[3])) >>> 31) + (iArr[1] * j14)) + (iArr[2] * j13)) >>> 31) + (iArr[0] * j14)) + (iArr[1] * j13)) >>> 21) + ((iArr[0] * j13) << 10)) >>> i39;
                                long j16 = j9 >>> 31;
                                long j17 = j9 & 2147483647L;
                                j4 = j15;
                                j3 = ((((((((((((j17 * iArr[3]) >>> 31) + (iArr[2] * j17)) + (j16 * iArr[3])) >>> 31) + (iArr[1] * j17)) + (iArr[2] * j16)) >>> 31) + (iArr[0] * j17)) + (iArr[1] * j16)) >>> 21) + ((iArr[0] * j16) << 10)) >>> i39;
                                if (max <= 21) {
                                    int i40 = ((j7 % 5) > 0L ? 1 : ((j7 % 5) == 0L ? 0 : -1));
                                    if (i40 == 0) {
                                        if (i40 != 0) {
                                            i12 = 0;
                                        } else if (j7 % 25 != 0) {
                                            i12 = 1;
                                        } else if (j7 % 125 != 0) {
                                            i12 = 2;
                                        } else if (j7 % 625 != 0) {
                                            i12 = 3;
                                        } else {
                                            long j18 = j7 / 625;
                                            i12 = 4;
                                            for (long j19 = 0; j18 > j19 && j18 % 5 == j19; j19 = 0) {
                                                j18 /= 5;
                                                i12++;
                                            }
                                        }
                                        z4 = i12 >= max;
                                        z5 = false;
                                        j2 = j12;
                                        z3 = z5;
                                        i4 = max;
                                    } else if (z2) {
                                        if (j9 % 5 != 0) {
                                            i11 = 0;
                                        } else if (j9 % 25 != 0) {
                                            i11 = 1;
                                        } else if (j9 % 125 != 0) {
                                            i11 = 2;
                                        } else if (j9 % 625 != 0) {
                                            i11 = 3;
                                        } else {
                                            long j20 = j9 / 625;
                                            i11 = 4;
                                            for (long j21 = 0; j20 > j21 && j20 % 5 == j21; j21 = 0) {
                                                j20 /= 5;
                                                i11++;
                                            }
                                        }
                                        if (i11 >= max) {
                                            z5 = true;
                                            z4 = false;
                                            j2 = j12;
                                            z3 = z5;
                                            i4 = max;
                                        }
                                    } else {
                                        if (j8 % 5 != 0) {
                                            i10 = 0;
                                        } else if (j8 % 25 != 0) {
                                            i10 = 1;
                                        } else if (j8 % 125 != 0) {
                                            i10 = 2;
                                        } else if (j8 % 625 != 0) {
                                            i10 = 3;
                                        } else {
                                            long j22 = j8 / 625;
                                            i10 = 4;
                                            for (long j23 = 0; j22 > j23 && j22 % 5 == j23; j23 = 0) {
                                                j22 /= 5;
                                                i10++;
                                            }
                                        }
                                        if (i10 >= max) {
                                            j4--;
                                        }
                                    }
                                }
                                z5 = false;
                                z4 = false;
                                j2 = j12;
                                z3 = z5;
                                i4 = max;
                            } else {
                                throw new IllegalArgumentException("" + i39);
                            }
                        } else {
                            z = z6;
                            z2 = z7;
                            int i41 = -i37;
                            int max2 = Math.max(0, ((int) ((i41 * 6989700) / 10000000)) - 1);
                            int i42 = i41 - max2;
                            int i43 = ((max2 - ((i42 == 0 ? 1 : (int) ((((i42 * 23219280) + 10000000) - 1) / 10000000)) + OneKeyLoginResult.ONE_KEY_LOGIN_CODE_NOT_MEET_GRAY)) - 93) - 21;
                            if (i43 >= 0) {
                                int[] iArr2 = POW5_SPLIT[i42];
                                long j24 = j7 >>> 31;
                                long j25 = j7 & 2147483647L;
                                long j26 = iArr2[0] * j24;
                                long j27 = iArr2[0] * j25;
                                long j28 = iArr2[1] * j24;
                                int i44 = i36;
                                long j29 = iArr2[1] * j25;
                                long j30 = iArr2[2] * j24;
                                long j31 = iArr2[2] * j25;
                                long j32 = j24 * iArr2[3];
                                long j33 = j8 >>> 31;
                                long j34 = j8 & 2147483647L;
                                long j35 = iArr2[0] * j34;
                                long j36 = iArr2[1] * j33;
                                j2 = ((((((((((((j25 * iArr2[3]) >>> 31) + j31) + j32) >>> 31) + j29) + j30) >>> 31) + j27) + j28) >>> 21) + (j26 << 10)) >>> i43;
                                long j37 = ((((((((((((j34 * iArr2[3]) >>> 31) + (iArr2[2] * j34)) + (j33 * iArr2[3])) >>> 31) + (iArr2[1] * j34)) + (iArr2[2] * j33)) >>> 31) + j35) + j36) >>> 21) + ((iArr2[0] * j33) << 10)) >>> i43;
                                long j38 = j9 >>> 31;
                                long j39 = j9 & 2147483647L;
                                j3 = ((((((((((((j39 * iArr2[3]) >>> 31) + (iArr2[2] * j39)) + (j38 * iArr2[3])) >>> 31) + (iArr2[1] * j39)) + (iArr2[2] * j38)) >>> 31) + (iArr2[0] * j39)) + (iArr2[1] * j38)) >>> 21) + ((iArr2[0] * j38) << 10)) >>> i43;
                                i4 = max2 + i37;
                                if (max2 <= 1) {
                                    if (z2) {
                                        j4 = j37;
                                        z3 = i44 == 1;
                                    } else {
                                        j4 = j37 - 1;
                                        z3 = false;
                                    }
                                    z4 = true;
                                } else if (max2 < 63) {
                                    z4 = (j7 & ((1 << (max2 - 1)) - 1)) == 0;
                                    j4 = j37;
                                    z3 = false;
                                } else {
                                    j4 = j37;
                                    z3 = false;
                                    z4 = false;
                                }
                            } else {
                                throw new IllegalArgumentException("" + i43);
                            }
                        }
                        if (j4 >= 1000000000000000000L) {
                            i38 = 19;
                        } else if (j4 >= 100000000000000000L) {
                            i38 = 18;
                        } else if (j4 >= 10000000000000000L) {
                            i38 = 17;
                        } else if (j4 >= 1000000000000000L) {
                            i38 = 16;
                        } else if (j4 >= 100000000000000L) {
                            i38 = 15;
                        } else if (j4 >= 10000000000000L) {
                            i38 = 14;
                        } else if (j4 >= BasicLabelFormatter.TRILLION) {
                            i38 = 13;
                        } else if (j4 >= 100000000000L) {
                            i38 = 12;
                        } else if (j4 >= 10000000000L) {
                            i38 = 11;
                        } else if (j4 >= 1000000000) {
                            i38 = 10;
                        } else if (j4 >= 100000000) {
                            i38 = 9;
                        } else if (j4 >= 10000000) {
                            i38 = 8;
                        } else if (j4 >= 1000000) {
                            i38 = 7;
                        } else if (j4 >= 100000) {
                            i38 = 6;
                        } else if (j4 >= 10000) {
                            i38 = 5;
                        } else if (j4 >= 1000) {
                            i38 = 4;
                        } else if (j4 < 100) {
                            i38 = j4 >= 10 ? 2 : 1;
                        }
                        int i45 = (i4 + i38) - 1;
                        boolean z8 = i45 < -3 || i45 >= 7;
                        if (z3 || z4) {
                            boolean z9 = z4;
                            int i46 = 0;
                            int i47 = 0;
                            while (true) {
                                long j40 = j4 / 10;
                                long j41 = j3 / 10;
                                if (j40 <= j41 || (j4 < 100 && z8)) {
                                    break;
                                }
                                z3 &= j3 % 10 == 0;
                                z9 &= i46 == 0;
                                i46 = (int) (j2 % 10);
                                j2 /= 10;
                                i47++;
                                j4 = j40;
                                j3 = j41;
                            }
                            if (z3 && z2) {
                                while (j3 % 10 == 0 && (j4 >= 100 || !z8)) {
                                    z9 &= i46 == 0;
                                    i46 = (int) (j2 % 10);
                                    j4 /= 10;
                                    j2 /= 10;
                                    j3 /= 10;
                                    i47++;
                                }
                            }
                            if (z9 && i46 == 5 && j2 % 2 == 0) {
                                i46 = 4;
                            }
                            j5 = j2 + (((j2 != j3 || (z3 && z2)) && i46 < 5) ? 0 : 1);
                            i5 = i47;
                        } else {
                            i5 = 0;
                            int i48 = 0;
                            while (true) {
                                long j42 = j4 / 10;
                                long j43 = j3 / 10;
                                if (j42 <= j43 || (j4 < 100 && z8)) {
                                    break;
                                }
                                i48 = (int) (j2 % 10);
                                j2 /= 10;
                                i5++;
                                j4 = j42;
                                j3 = j43;
                            }
                            j5 = j2 + ((j2 == j3 || i48 >= 5) ? 1 : 0);
                        }
                        int i49 = i38 - i5;
                        if (z) {
                            i6 = i2 + 1;
                            cArr[i2] = SignatureImpl.SEP;
                        } else {
                            i6 = i2;
                        }
                        if (!z8) {
                            char c2 = '0';
                            if (i45 < 0) {
                                int i50 = i6 + 1;
                                cArr[i6] = '0';
                                int i51 = i50 + 1;
                                cArr[i50] = '.';
                                int i52 = -1;
                                while (i52 > i45) {
                                    cArr[i51] = c2;
                                    i52--;
                                    i51++;
                                    c2 = '0';
                                }
                                i7 = i51;
                                for (int i53 = 0; i53 < i49; i53++) {
                                    cArr[((i51 + i49) - i53) - 1] = (char) ((j5 % 10) + 48);
                                    j5 /= 10;
                                    i7++;
                                }
                            } else {
                                int i54 = i45 + 1;
                                if (i54 >= i49) {
                                    for (int i55 = 0; i55 < i49; i55++) {
                                        cArr[((i6 + i49) - i55) - 1] = (char) ((j5 % 10) + 48);
                                        j5 /= 10;
                                    }
                                    int i56 = i6 + i49;
                                    while (i49 < i54) {
                                        cArr[i56] = '0';
                                        i49++;
                                        i56++;
                                    }
                                    int i57 = i56 + 1;
                                    cArr[i56] = '.';
                                    i7 = i57 + 1;
                                    cArr[i57] = '0';
                                } else {
                                    int i58 = i6 + 1;
                                    for (int i59 = 0; i59 < i49; i59++) {
                                        if ((i49 - i59) - 1 == i45) {
                                            cArr[((i58 + i49) - i59) - 1] = '.';
                                            i58--;
                                        }
                                        cArr[((i58 + i49) - i59) - 1] = (char) ((j5 % 10) + 48);
                                        j5 /= 10;
                                    }
                                    i7 = i6 + i49 + 1;
                                }
                            }
                            return i7 - i2;
                        }
                        for (int i60 = 0; i60 < i49 - 1; i60++) {
                            int i61 = (int) (j5 % 10);
                            j5 /= 10;
                            cArr[(i6 + i49) - i60] = (char) (i61 + 48);
                        }
                        cArr[i6] = (char) ((j5 % 10) + 48);
                        cArr[i6 + 1] = '.';
                        int i62 = i6 + i49 + 1;
                        if (i49 == 1) {
                            cArr[i62] = '0';
                            i62++;
                        }
                        int i63 = i62 + 1;
                        cArr[i62] = 'E';
                        if (i45 < 0) {
                            cArr[i63] = SignatureImpl.SEP;
                            i45 = -i45;
                            i63++;
                        }
                        if (i45 >= 100) {
                            int i64 = i63 + 1;
                            i8 = 48;
                            cArr[i63] = (char) ((i45 / 100) + 48);
                            i45 %= 100;
                            i63 = i64 + 1;
                            cArr[i64] = (char) ((i45 / 10) + 48);
                        } else {
                            i8 = 48;
                            if (i45 >= 10) {
                                cArr[i63] = (char) ((i45 / 10) + 48);
                                i63++;
                            }
                        }
                        i9 = i63 + 1;
                        cArr[i63] = (char) ((i45 % 10) + i8);
                    }
                }
                return i9 - i2;
            }
            int i65 = i2 + 1;
            cArr[i2] = 'N';
            int i66 = i65 + 1;
            cArr[i65] = 'a';
            i13 = i66 + 1;
            cArr[i66] = 'N';
            return i13 - i2;
        }
        return invokeCommon.intValue;
    }
}
