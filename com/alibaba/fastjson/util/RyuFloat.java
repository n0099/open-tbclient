package com.alibaba.fastjson.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes3.dex */
public final class RyuFloat {
    public static /* synthetic */ Interceptable $ic;
    public static final int[][] POW5_INV_SPLIT;
    public static final int[][] POW5_SPLIT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-514753474, "Lcom/alibaba/fastjson/util/RyuFloat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-514753474, "Lcom/alibaba/fastjson/util/RyuFloat;");
                return;
            }
        }
        POW5_SPLIT = new int[][]{new int[]{536870912, 0}, new int[]{671088640, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{1000000000, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, 1073741824}, new int[]{762939453, 268435456}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};
        POW5_INV_SPLIT = new int[][]{new int[]{268435456, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};
    }

    public RyuFloat() {
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

    public static String toString(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f2)) == null) {
            char[] cArr = new char[15];
            return new String(cArr, 0, toString(f2, cArr, 0));
        }
        return (String) invokeF.objValue;
    }

    public static int toString(float f2, char[] cArr, int i2) {
        InterceptResult invokeCommon;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        boolean z2;
        int i7;
        int i8;
        boolean z3;
        int i9;
        boolean z4;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), cArr, Integer.valueOf(i2)})) == null) {
            if (Float.isNaN(f2)) {
                int i15 = i2 + 1;
                cArr[i2] = 'N';
                int i16 = i15 + 1;
                cArr[i15] = 'a';
                i14 = i16 + 1;
                cArr[i16] = 'N';
            } else if (f2 == Float.POSITIVE_INFINITY) {
                int i17 = i2 + 1;
                cArr[i2] = 'I';
                int i18 = i17 + 1;
                cArr[i17] = 'n';
                int i19 = i18 + 1;
                cArr[i18] = 'f';
                int i20 = i19 + 1;
                cArr[i19] = 'i';
                int i21 = i20 + 1;
                cArr[i20] = 'n';
                int i22 = i21 + 1;
                cArr[i21] = 'i';
                int i23 = i22 + 1;
                cArr[i22] = 't';
                cArr[i23] = 'y';
                return (i23 + 1) - i2;
            } else if (f2 == Float.NEGATIVE_INFINITY) {
                int i24 = i2 + 1;
                cArr[i2] = SignatureImpl.SEP;
                int i25 = i24 + 1;
                cArr[i24] = 'I';
                int i26 = i25 + 1;
                cArr[i25] = 'n';
                int i27 = i26 + 1;
                cArr[i26] = 'f';
                int i28 = i27 + 1;
                cArr[i27] = 'i';
                int i29 = i28 + 1;
                cArr[i28] = 'n';
                int i30 = i29 + 1;
                cArr[i29] = 'i';
                int i31 = i30 + 1;
                cArr[i30] = 't';
                i14 = i31 + 1;
                cArr[i31] = 'y';
            } else {
                int floatToIntBits = Float.floatToIntBits(f2);
                if (floatToIntBits != 0) {
                    if (floatToIntBits == Integer.MIN_VALUE) {
                        int i32 = i2 + 1;
                        cArr[i2] = SignatureImpl.SEP;
                        int i33 = i32 + 1;
                        cArr[i32] = '0';
                        int i34 = i33 + 1;
                        cArr[i33] = '.';
                        cArr[i34] = '0';
                        return (i34 + 1) - i2;
                    }
                    int i35 = (floatToIntBits >> 23) & 255;
                    int i36 = 8388607 & floatToIntBits;
                    if (i35 == 0) {
                        i3 = -149;
                    } else {
                        i3 = (i35 - 127) - 23;
                        i36 |= 8388608;
                    }
                    boolean z5 = floatToIntBits < 0;
                    boolean z6 = (i36 & 1) == 0;
                    int i37 = i36 * 4;
                    int i38 = i37 + 2;
                    int i39 = i37 - ((((long) i36) != 8388608 || i35 <= 1) ? 2 : 1);
                    int i40 = i3 - 2;
                    if (i40 >= 0) {
                        i6 = (int) ((i40 * 3010299) / 10000000);
                        int i41 = i6 == 0 ? 1 : (int) ((((i6 * 23219280) + 10000000) - 1) / 10000000);
                        int i42 = (-i40) + i6;
                        int[][] iArr = POW5_INV_SPLIT;
                        long j2 = iArr[i6][0];
                        z = z6;
                        long j3 = iArr[i6][1];
                        long j4 = i37;
                        int i43 = (((i41 + 59) - 1) + i42) - 31;
                        i7 = (int) (((j4 * j2) + ((j4 * j3) >> 31)) >> i43);
                        long j5 = i38;
                        i8 = (int) (((j5 * j2) + ((j5 * j3) >> 31)) >> i43);
                        long j6 = i39;
                        i9 = (int) (((j2 * j6) + ((j6 * j3) >> 31)) >> i43);
                        if (i6 == 0 || (i8 - 1) / 10 > i9 / 10) {
                            i5 = 0;
                        } else {
                            int i44 = i6 - 1;
                            int i45 = (i42 - 1) + (((i44 == 0 ? 1 : (int) ((((i44 * 23219280) + 10000000) - 1) / 10000000)) + 59) - 1);
                            int[][] iArr2 = POW5_INV_SPLIT;
                            i5 = (int) ((((iArr2[i44][0] * j4) + ((iArr2[i44][1] * j4) >> 31)) >> (i45 - 31)) % 10);
                        }
                        int i46 = 0;
                        while (i38 > 0 && i38 % 5 == 0) {
                            i38 /= 5;
                            i46++;
                        }
                        int i47 = 0;
                        while (i37 > 0 && i37 % 5 == 0) {
                            i37 /= 5;
                            i47++;
                        }
                        int i48 = 0;
                        while (i39 > 0 && i39 % 5 == 0) {
                            i39 /= 5;
                            i48++;
                        }
                        z2 = i46 >= i6;
                        z4 = i47 >= i6;
                        z3 = i48 >= i6;
                    } else {
                        z = z6;
                        int i49 = -i40;
                        int i50 = (int) ((i49 * 6989700) / 10000000);
                        int i51 = i49 - i50;
                        int[][] iArr3 = POW5_SPLIT;
                        long j7 = iArr3[i51][0];
                        long j8 = iArr3[i51][1];
                        int i52 = (i50 - ((i51 == 0 ? 1 : (int) ((((i51 * 23219280) + 10000000) - 1) / 10000000)) - 61)) - 31;
                        long j9 = i37;
                        int i53 = (int) (((j9 * j7) + ((j9 * j8) >> 31)) >> i52);
                        long j10 = i38;
                        int i54 = (int) (((j10 * j7) + ((j10 * j8) >> 31)) >> i52);
                        long j11 = i39;
                        int i55 = (int) (((j11 * j7) + ((j11 * j8) >> 31)) >> i52);
                        if (i50 == 0 || (i54 - 1) / 10 > i55 / 10) {
                            i4 = i54;
                            i5 = 0;
                        } else {
                            int[][] iArr4 = POW5_SPLIT;
                            i4 = i54;
                            i5 = (int) ((((iArr4[i10][0] * j9) + ((j9 * iArr4[i10][1]) >> 31)) >> (((i50 - 1) - ((i51 + 1 == 0 ? 1 : (int) ((((i10 * 23219280) + 10000000) - 1) / 10000000)) - 61)) - 31)) % 10);
                        }
                        i6 = i50 + i40;
                        boolean z7 = 1 >= i50;
                        boolean z8 = i50 < 23 && (i37 & ((1 << (i50 + (-1))) - 1)) == 0;
                        boolean z9 = (i39 % 2 == 1 ? 0 : 1) >= i50;
                        z2 = z7;
                        i7 = i53;
                        i8 = i4;
                        boolean z10 = z8;
                        z3 = z9;
                        i9 = i55;
                        z4 = z10;
                    }
                    int i56 = 1000000000;
                    int i57 = 10;
                    while (i57 > 0 && i8 < i56) {
                        i56 /= 10;
                        i57--;
                    }
                    int i58 = (i6 + i57) - 1;
                    boolean z11 = i58 < -3 || i58 >= 7;
                    if (z2 && !z) {
                        i8--;
                    }
                    int i59 = 0;
                    while (true) {
                        int i60 = i8 / 10;
                        int i61 = i9 / 10;
                        if (i60 <= i61 || (i8 < 100 && z11)) {
                            break;
                        }
                        z3 &= i9 % 10 == 0;
                        i5 = i7 % 10;
                        i7 /= 10;
                        i59++;
                        i8 = i60;
                        i9 = i61;
                    }
                    if (z3 && z) {
                        while (i9 % 10 == 0 && (i8 >= 100 || !z11)) {
                            i8 /= 10;
                            i5 = i7 % 10;
                            i7 /= 10;
                            i9 /= 10;
                            i59++;
                        }
                    }
                    if (z4 && i5 == 5 && i7 % 2 == 0) {
                        i5 = 4;
                    }
                    int i62 = i7 + (((i7 != i9 || (z3 && z)) && i5 < 5) ? 0 : 1);
                    int i63 = i57 - i59;
                    if (z5) {
                        i11 = i2 + 1;
                        cArr[i2] = SignatureImpl.SEP;
                    } else {
                        i11 = i2;
                    }
                    if (z11) {
                        for (int i64 = 0; i64 < i63 - 1; i64++) {
                            int i65 = i62 % 10;
                            i62 /= 10;
                            cArr[(i11 + i63) - i64] = (char) (i65 + 48);
                        }
                        cArr[i11] = (char) ((i62 % 10) + 48);
                        cArr[i11 + 1] = '.';
                        int i66 = i11 + i63 + 1;
                        if (i63 == 1) {
                            cArr[i66] = '0';
                            i66++;
                        }
                        int i67 = i66 + 1;
                        cArr[i66] = 'E';
                        if (i58 < 0) {
                            cArr[i67] = SignatureImpl.SEP;
                            i58 = -i58;
                            i67++;
                        }
                        if (i58 >= 10) {
                            i13 = 48;
                            cArr[i67] = (char) ((i58 / 10) + 48);
                            i67++;
                        } else {
                            i13 = 48;
                        }
                        i12 = i67 + 1;
                        cArr[i67] = (char) ((i58 % 10) + i13);
                    } else {
                        int i68 = 48;
                        if (i58 < 0) {
                            int i69 = i11 + 1;
                            cArr[i11] = '0';
                            int i70 = i69 + 1;
                            cArr[i69] = '.';
                            int i71 = -1;
                            while (i71 > i58) {
                                cArr[i70] = '0';
                                i71--;
                                i70++;
                            }
                            int i72 = i70;
                            int i73 = 0;
                            while (i73 < i63) {
                                cArr[((i70 + i63) - i73) - 1] = (char) ((i62 % 10) + i68);
                                i62 /= 10;
                                i72++;
                                i73++;
                                i68 = 48;
                            }
                            i12 = i72;
                        } else {
                            int i74 = i58 + 1;
                            if (i74 >= i63) {
                                for (int i75 = 0; i75 < i63; i75++) {
                                    cArr[((i11 + i63) - i75) - 1] = (char) ((i62 % 10) + 48);
                                    i62 /= 10;
                                }
                                int i76 = i11 + i63;
                                while (i63 < i74) {
                                    cArr[i76] = '0';
                                    i63++;
                                    i76++;
                                }
                                int i77 = i76 + 1;
                                cArr[i76] = '.';
                                i12 = i77 + 1;
                                cArr[i77] = '0';
                            } else {
                                int i78 = i11 + 1;
                                for (int i79 = 0; i79 < i63; i79++) {
                                    if ((i63 - i79) - 1 == i58) {
                                        cArr[((i78 + i63) - i79) - 1] = '.';
                                        i78--;
                                    }
                                    cArr[((i78 + i63) - i79) - 1] = (char) ((i62 % 10) + 48);
                                    i62 /= 10;
                                }
                                i12 = i11 + i63 + 1;
                            }
                        }
                    }
                    return i12 - i2;
                }
                int i80 = i2 + 1;
                cArr[i2] = '0';
                int i81 = i80 + 1;
                cArr[i80] = '.';
                i14 = i81 + 1;
                cArr[i81] = '0';
            }
            return i14 - i2;
        }
        return invokeCommon.intValue;
    }
}
