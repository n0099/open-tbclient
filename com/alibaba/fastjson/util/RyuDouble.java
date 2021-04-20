package com.alibaba.fastjson.util;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import java.lang.reflect.Array;
import java.math.BigInteger;
/* loaded from: classes.dex */
public final class RyuDouble {
    public static final int[][] POW5_SPLIT = (int[][]) Array.newInstance(int.class, 326, 4);
    public static final int[][] POW5_INV_SPLIT = (int[][]) Array.newInstance(int.class, QRScanCodeActivity.DIALOG_PROCESS_IMG_FAILED, 4);

    static {
        BigInteger subtract = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        BigInteger subtract2 = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        int i = 0;
        while (i < 326) {
            BigInteger pow = BigInteger.valueOf(5L).pow(i);
            int bitLength = pow.bitLength();
            int i2 = i == 0 ? 1 : (int) ((((i * 23219280) + 10000000) - 1) / 10000000);
            if (i2 == bitLength) {
                if (i < POW5_SPLIT.length) {
                    for (int i3 = 0; i3 < 4; i3++) {
                        POW5_SPLIT[i][i3] = pow.shiftRight(bitLength + OneKeyLoginResult.ONE_KEY_LOGIN_CODE_NOT_MEET_GRAY + ((3 - i3) * 31)).and(subtract).intValue();
                    }
                }
                if (i < POW5_INV_SPLIT.length) {
                    BigInteger add = BigInteger.ONE.shiftLeft(bitLength + Constants.METHOD_IM_FRIEND_GROUP_DROP).divide(pow).add(BigInteger.ONE);
                    for (int i4 = 0; i4 < 4; i4++) {
                        if (i4 == 0) {
                            POW5_INV_SPLIT[i][i4] = add.shiftRight((3 - i4) * 31).intValue();
                        } else {
                            POW5_INV_SPLIT[i][i4] = add.shiftRight((3 - i4) * 31).and(subtract2).intValue();
                        }
                    }
                }
                i++;
            } else {
                throw new IllegalStateException(bitLength + " != " + i2);
            }
        }
    }

    public static String toString(double d2) {
        char[] cArr = new char[24];
        return new String(cArr, 0, toString(d2, cArr, 0));
    }

    public static int toString(double d2, char[] cArr, int i) {
        int i2;
        boolean z;
        boolean z2;
        long j;
        long j2;
        int i3;
        long j3;
        boolean z3;
        boolean z4;
        long j4;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z5;
        int i9;
        int i10;
        int i11;
        int i12;
        if (!Double.isNaN(d2)) {
            if (d2 == Double.POSITIVE_INFINITY) {
                int i13 = i + 1;
                cArr[i] = 'I';
                int i14 = i13 + 1;
                cArr[i13] = 'n';
                int i15 = i14 + 1;
                cArr[i14] = 'f';
                int i16 = i15 + 1;
                cArr[i15] = 'i';
                int i17 = i16 + 1;
                cArr[i16] = 'n';
                int i18 = i17 + 1;
                cArr[i17] = 'i';
                int i19 = i18 + 1;
                cArr[i18] = 't';
                i8 = i19 + 1;
                cArr[i19] = 'y';
            } else if (d2 == Double.NEGATIVE_INFINITY) {
                int i20 = i + 1;
                cArr[i] = '-';
                int i21 = i20 + 1;
                cArr[i20] = 'I';
                int i22 = i21 + 1;
                cArr[i21] = 'n';
                int i23 = i22 + 1;
                cArr[i22] = 'f';
                int i24 = i23 + 1;
                cArr[i23] = 'i';
                int i25 = i24 + 1;
                cArr[i24] = 'n';
                int i26 = i25 + 1;
                cArr[i25] = 'i';
                int i27 = i26 + 1;
                cArr[i26] = 't';
                i12 = i27 + 1;
                cArr[i27] = 'y';
            } else {
                long doubleToLongBits = Double.doubleToLongBits(d2);
                int i28 = (doubleToLongBits > 0L ? 1 : (doubleToLongBits == 0L ? 0 : -1));
                if (i28 == 0) {
                    int i29 = i + 1;
                    cArr[i] = '0';
                    int i30 = i29 + 1;
                    cArr[i29] = IStringUtil.EXTENSION_SEPARATOR;
                    i12 = i30 + 1;
                    cArr[i30] = '0';
                } else if (doubleToLongBits == Long.MIN_VALUE) {
                    int i31 = i + 1;
                    cArr[i] = '-';
                    int i32 = i31 + 1;
                    cArr[i31] = '0';
                    int i33 = i32 + 1;
                    cArr[i32] = IStringUtil.EXTENSION_SEPARATOR;
                    i8 = i33 + 1;
                    cArr[i33] = '0';
                } else {
                    int i34 = (int) ((doubleToLongBits >>> 52) & 2047);
                    long j5 = doubleToLongBits & 4503599627370495L;
                    if (i34 == 0) {
                        i2 = -1074;
                    } else {
                        i2 = (i34 - 1023) - 52;
                        j5 |= 4503599627370496L;
                    }
                    boolean z6 = i28 < 0;
                    boolean z7 = (j5 & 1) == 0;
                    long j6 = 4 * j5;
                    long j7 = j6 + 2;
                    int i35 = (j5 != 4503599627370496L || i34 <= 1) ? 1 : 0;
                    long j8 = (j6 - 1) - i35;
                    int i36 = i2 - 2;
                    int i37 = 3;
                    if (i36 >= 0) {
                        int max = Math.max(0, ((int) ((i36 * 3010299) / 10000000)) - 1);
                        int i38 = ((((-i36) + max) + (((max == 0 ? 1 : (int) ((((max * 23219280) + 10000000) - 1) / 10000000)) + 122) - 1)) - 93) - 21;
                        if (i38 >= 0) {
                            int[] iArr = POW5_INV_SPLIT[max];
                            long j9 = j6 >>> 31;
                            long j10 = j6 & 2147483647L;
                            z = z6;
                            long j11 = iArr[0] * j10;
                            long j12 = iArr[1] * j9;
                            long j13 = iArr[1] * j10;
                            boolean z8 = z7;
                            long j14 = ((((((((((((j10 * iArr[3]) >>> 31) + (iArr[2] * j10)) + (j9 * iArr[3])) >>> 31) + j13) + (iArr[2] * j9)) >>> 31) + j11) + j12) >>> 21) + ((iArr[0] * j9) << 10)) >>> i38;
                            long j15 = j7 >>> 31;
                            long j16 = j7 & 2147483647L;
                            long j17 = iArr[0] * j16;
                            long j18 = iArr[1] * j15;
                            long j19 = iArr[1] * j16;
                            z2 = z8;
                            long j20 = ((((((((((((j16 * iArr[3]) >>> 31) + (iArr[2] * j16)) + (j15 * iArr[3])) >>> 31) + j19) + (iArr[2] * j15)) >>> 31) + j17) + j18) >>> 21) + ((iArr[0] * j15) << 10)) >>> i38;
                            long j21 = j8 >>> 31;
                            long j22 = j8 & 2147483647L;
                            long j23 = iArr[0] * j22;
                            j3 = j20;
                            j2 = ((((((((((((j22 * iArr[3]) >>> 31) + (iArr[2] * j22)) + (j21 * iArr[3])) >>> 31) + (iArr[1] * j22)) + (iArr[2] * j21)) >>> 31) + j23) + (iArr[1] * j21)) >>> 21) + ((iArr[0] * j21) << 10)) >>> i38;
                            if (max <= 21) {
                                int i39 = ((j6 % 5) > 0L ? 1 : ((j6 % 5) == 0L ? 0 : -1));
                                if (i39 == 0) {
                                    if (i39 != 0) {
                                        i11 = 0;
                                    } else if (j6 % 25 != 0) {
                                        i11 = 1;
                                    } else if (j6 % 125 != 0) {
                                        i11 = 2;
                                    } else if (j6 % 625 != 0) {
                                        i11 = 3;
                                    } else {
                                        long j24 = j6 / 625;
                                        i11 = 4;
                                        for (long j25 = 0; j24 > j25 && j24 % 5 == j25; j25 = 0) {
                                            j24 /= 5;
                                            i11++;
                                        }
                                    }
                                    z4 = i11 >= max;
                                    z5 = false;
                                    j = j14;
                                    z3 = z5;
                                    i3 = max;
                                } else if (z2) {
                                    if (j8 % 5 != 0) {
                                        i10 = 0;
                                    } else if (j8 % 25 != 0) {
                                        i10 = 1;
                                    } else if (j8 % 125 != 0) {
                                        i10 = 2;
                                    } else if (j8 % 625 != 0) {
                                        i10 = 3;
                                    } else {
                                        long j26 = j8 / 625;
                                        i10 = 4;
                                        for (long j27 = 0; j26 > j27 && j26 % 5 == j27; j27 = 0) {
                                            j26 /= 5;
                                            i10++;
                                        }
                                    }
                                    if (i10 >= max) {
                                        z5 = true;
                                        z4 = false;
                                        j = j14;
                                        z3 = z5;
                                        i3 = max;
                                    }
                                } else {
                                    if (j7 % 5 != 0) {
                                        i9 = 0;
                                    } else if (j7 % 25 != 0) {
                                        i9 = 1;
                                    } else if (j7 % 125 != 0) {
                                        i9 = 2;
                                    } else if (j7 % 625 != 0) {
                                        i9 = 3;
                                    } else {
                                        long j28 = j7 / 625;
                                        i9 = 4;
                                        for (long j29 = 0; j28 > j29 && j28 % 5 == j29; j29 = 0) {
                                            j28 /= 5;
                                            i9++;
                                        }
                                    }
                                    if (i9 >= max) {
                                        j3--;
                                    }
                                }
                            }
                            z5 = false;
                            z4 = false;
                            j = j14;
                            z3 = z5;
                            i3 = max;
                        } else {
                            throw new IllegalArgumentException("" + i38);
                        }
                    } else {
                        z = z6;
                        z2 = z7;
                        int i40 = -i36;
                        int max2 = Math.max(0, ((int) ((i40 * 6989700) / 10000000)) - 1);
                        int i41 = i40 - max2;
                        int i42 = ((max2 - ((i41 == 0 ? 1 : (int) ((((i41 * 23219280) + 10000000) - 1) / 10000000)) + OneKeyLoginResult.ONE_KEY_LOGIN_CODE_NOT_MEET_GRAY)) - 93) - 21;
                        if (i42 >= 0) {
                            int[] iArr2 = POW5_SPLIT[i41];
                            long j30 = j6 >>> 31;
                            long j31 = j6 & 2147483647L;
                            long j32 = iArr2[0] * j30;
                            long j33 = iArr2[0] * j31;
                            long j34 = iArr2[1] * j30;
                            int i43 = i35;
                            long j35 = iArr2[1] * j31;
                            long j36 = iArr2[2] * j30;
                            long j37 = iArr2[2] * j31;
                            long j38 = j30 * iArr2[3];
                            long j39 = j7 >>> 31;
                            long j40 = j7 & 2147483647L;
                            long j41 = iArr2[0] * j40;
                            long j42 = iArr2[1] * j39;
                            j = ((((((((((((j31 * iArr2[3]) >>> 31) + j37) + j38) >>> 31) + j35) + j36) >>> 31) + j33) + j34) >>> 21) + (j32 << 10)) >>> i42;
                            long j43 = iArr2[1] * j40;
                            long j44 = ((((((((((((j40 * iArr2[3]) >>> 31) + (iArr2[2] * j40)) + (j39 * iArr2[3])) >>> 31) + j43) + (iArr2[2] * j39)) >>> 31) + j41) + j42) >>> 21) + ((iArr2[0] * j39) << 10)) >>> i42;
                            long j45 = j8 >>> 31;
                            long j46 = j8 & 2147483647L;
                            long j47 = iArr2[0] * j46;
                            j2 = ((((((((((((j46 * iArr2[3]) >>> 31) + (iArr2[2] * j46)) + (j45 * iArr2[3])) >>> 31) + (iArr2[1] * j46)) + (iArr2[2] * j45)) >>> 31) + j47) + (iArr2[1] * j45)) >>> 21) + ((iArr2[0] * j45) << 10)) >>> i42;
                            i3 = max2 + i36;
                            if (max2 <= 1) {
                                if (z2) {
                                    j3 = j44;
                                    z3 = i43 == 1;
                                } else {
                                    j3 = j44 - 1;
                                    z3 = false;
                                }
                                z4 = true;
                            } else if (max2 < 63) {
                                z4 = (j6 & ((1 << (max2 - 1)) - 1)) == 0;
                                j3 = j44;
                                z3 = false;
                            } else {
                                j3 = j44;
                                z3 = false;
                                z4 = false;
                            }
                        } else {
                            throw new IllegalArgumentException("" + i42);
                        }
                    }
                    if (j3 >= 1000000000000000000L) {
                        i37 = 19;
                    } else if (j3 >= 100000000000000000L) {
                        i37 = 18;
                    } else if (j3 >= 10000000000000000L) {
                        i37 = 17;
                    } else if (j3 >= 1000000000000000L) {
                        i37 = 16;
                    } else if (j3 >= 100000000000000L) {
                        i37 = 15;
                    } else if (j3 >= 10000000000000L) {
                        i37 = 14;
                    } else if (j3 >= 1000000000000L) {
                        i37 = 13;
                    } else if (j3 >= 100000000000L) {
                        i37 = 12;
                    } else if (j3 >= 10000000000L) {
                        i37 = 11;
                    } else if (j3 >= 1000000000) {
                        i37 = 10;
                    } else if (j3 >= 100000000) {
                        i37 = 9;
                    } else if (j3 >= 10000000) {
                        i37 = 8;
                    } else if (j3 >= 1000000) {
                        i37 = 7;
                    } else if (j3 >= 100000) {
                        i37 = 6;
                    } else if (j3 >= 10000) {
                        i37 = 5;
                    } else if (j3 >= 1000) {
                        i37 = 4;
                    } else if (j3 < 100) {
                        i37 = j3 >= 10 ? 2 : 1;
                    }
                    int i44 = (i3 + i37) - 1;
                    boolean z9 = i44 < -3 || i44 >= 7;
                    if (z3 || z4) {
                        boolean z10 = z4;
                        int i45 = 0;
                        int i46 = 0;
                        while (true) {
                            long j48 = j3 / 10;
                            long j49 = j2 / 10;
                            if (j48 <= j49 || (j3 < 100 && z9)) {
                                break;
                            }
                            z3 &= j2 % 10 == 0;
                            z10 &= i45 == 0;
                            i45 = (int) (j % 10);
                            j /= 10;
                            i46++;
                            j3 = j48;
                            j2 = j49;
                        }
                        if (z3 && z2) {
                            while (j2 % 10 == 0 && (j3 >= 100 || !z9)) {
                                z10 &= i45 == 0;
                                i45 = (int) (j % 10);
                                j3 /= 10;
                                j /= 10;
                                j2 /= 10;
                                i46++;
                            }
                        }
                        if (z10 && i45 == 5 && j % 2 == 0) {
                            i45 = 4;
                        }
                        j4 = j + (((j != j2 || (z3 && z2)) && i45 < 5) ? 0 : 1);
                        i4 = i46;
                    } else {
                        i4 = 0;
                        int i47 = 0;
                        while (true) {
                            long j50 = j3 / 10;
                            long j51 = j2 / 10;
                            if (j50 <= j51 || (j3 < 100 && z9)) {
                                break;
                            }
                            i47 = (int) (j % 10);
                            j /= 10;
                            i4++;
                            j3 = j50;
                            j2 = j51;
                        }
                        j4 = j + ((j == j2 || i47 >= 5) ? 1 : 0);
                    }
                    int i48 = i37 - i4;
                    if (z) {
                        i5 = i + 1;
                        cArr[i] = '-';
                    } else {
                        i5 = i;
                    }
                    if (!z9) {
                        char c2 = '0';
                        if (i44 < 0) {
                            int i49 = i5 + 1;
                            cArr[i5] = '0';
                            int i50 = i49 + 1;
                            cArr[i49] = IStringUtil.EXTENSION_SEPARATOR;
                            int i51 = -1;
                            while (i51 > i44) {
                                cArr[i50] = c2;
                                i51--;
                                i50++;
                                c2 = '0';
                            }
                            i6 = i50;
                            for (int i52 = 0; i52 < i48; i52++) {
                                cArr[((i50 + i48) - i52) - 1] = (char) ((j4 % 10) + 48);
                                j4 /= 10;
                                i6++;
                            }
                        } else {
                            int i53 = i44 + 1;
                            if (i53 >= i48) {
                                for (int i54 = 0; i54 < i48; i54++) {
                                    cArr[((i5 + i48) - i54) - 1] = (char) ((j4 % 10) + 48);
                                    j4 /= 10;
                                }
                                int i55 = i5 + i48;
                                while (i48 < i53) {
                                    cArr[i55] = '0';
                                    i48++;
                                    i55++;
                                }
                                int i56 = i55 + 1;
                                cArr[i55] = IStringUtil.EXTENSION_SEPARATOR;
                                i6 = i56 + 1;
                                cArr[i56] = '0';
                            } else {
                                int i57 = i5 + 1;
                                for (int i58 = 0; i58 < i48; i58++) {
                                    if ((i48 - i58) - 1 == i44) {
                                        cArr[((i57 + i48) - i58) - 1] = IStringUtil.EXTENSION_SEPARATOR;
                                        i57--;
                                    }
                                    cArr[((i57 + i48) - i58) - 1] = (char) ((j4 % 10) + 48);
                                    j4 /= 10;
                                }
                                i6 = i5 + i48 + 1;
                            }
                        }
                        return i6 - i;
                    }
                    for (int i59 = 0; i59 < i48 - 1; i59++) {
                        int i60 = (int) (j4 % 10);
                        j4 /= 10;
                        cArr[(i5 + i48) - i59] = (char) (i60 + 48);
                    }
                    cArr[i5] = (char) ((j4 % 10) + 48);
                    cArr[i5 + 1] = IStringUtil.EXTENSION_SEPARATOR;
                    int i61 = i5 + i48 + 1;
                    if (i48 == 1) {
                        cArr[i61] = '0';
                        i61++;
                    }
                    int i62 = i61 + 1;
                    cArr[i61] = 'E';
                    if (i44 < 0) {
                        cArr[i62] = '-';
                        i44 = -i44;
                        i62++;
                    }
                    if (i44 >= 100) {
                        int i63 = i62 + 1;
                        i7 = 48;
                        cArr[i62] = (char) ((i44 / 100) + 48);
                        i44 %= 100;
                        i62 = i63 + 1;
                        cArr[i63] = (char) ((i44 / 10) + 48);
                    } else {
                        i7 = 48;
                        if (i44 >= 10) {
                            cArr[i62] = (char) ((i44 / 10) + 48);
                            i62++;
                        }
                    }
                    i8 = i62 + 1;
                    cArr[i62] = (char) ((i44 % 10) + i7);
                }
            }
            return i8 - i;
        }
        int i64 = i + 1;
        cArr[i] = 'N';
        int i65 = i64 + 1;
        cArr[i64] = 'a';
        i12 = i65 + 1;
        cArr[i65] = 'N';
        return i12 - i;
    }
}
