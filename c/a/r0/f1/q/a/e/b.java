package c.a.r0.f1.q.a.e;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f12529b;

    /* renamed from: c  reason: collision with root package name */
    public static int[] f12530c;

    /* renamed from: d  reason: collision with root package name */
    public static int[] f12531d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(392308136, "Lc/a/r0/f1/q/a/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(392308136, "Lc/a/r0/f1/q/a/e/b;");
                return;
            }
        }
        a = new int[]{0, 31, 59, 90, 120, Opcodes.DCMPL, 181, w0.f57477h, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, 273, 304, 334, 365};
        f12529b = new int[]{8697535, 306771, 677704, 5580477, 861776, 890180, 4631225, 354893, 634178, 2404022, 306762, 6966718, 675154, 861510, 6116026, 742478, 879171, 2714935, 613195, 7642049, 300884, 674632, 5973436, 435536, 447557, 4905656, 177741, 612162, 2398135, 300874, 6703934, 870993, 959814, 5690554, 372046, 177732, 3749688, 601675, 8165055, 824659, 870984, 7185723, 742735, 354885, 4894137, 154957, 601410, 2921910, 693578, 8080061, 445009, 742726, 5593787, 318030, 678723, 3484600, 338764, 9082175, 955730, 436808, 7001404, 701775, 308805, 4871993, 677709, 337474, 4100917, 890185, 7711422, 354897, 617798, 5549755, 306511, 675139, 5056183, 861515, 9261759, 742482, 748103, 6909244, 613200, 301893, 4869049, 674637, 11216322, 435540, 447561, 7002685, 702033, 612166, 5543867, 300879, 412484, 3581239, 959818, 8827583, 371795, 702023, 5846716, 601680, 824901, 5065400, 870988, 894273, 2468534, 354889, 8039869, 154962, 601415, 6067642, 693582, 739907, 4937015, 709962, 9788095, 309843, 678728, 6630332, 338768, 693061, 4672185, 436812, 709953, 2415286, 308810, 6969149, 675409, 861766, 6198074, 873293, 371267, 3585335, 617803, 11841215, 306515, 675144, 7153084, 861519, 873028, 6138424, 744012, 355649, 2403766, 301898, 8014782, 674641, 697670, 5984954, 447054, 711234, 3496759, 603979, 8689601, 300883, 412488, 6726972, 959823, 436804, 4896312, 699980, 601666, 3970869, 824905, 8211133, 870993, 894277, 5614266, 354894, 683331, 4533943, 339275, 9082303, 693587, 739911, 7034171, 709967, 350789, 4873528, 678732, 338754, 3838902, 430921, 7809469, 436817, 709958, 5561018, 308814, 677699, 4532024, 861770, 9343806, 873042, 895559, 6731067, 355663, 306757, 4869817, 675148, 857409, 2986677};
        f12530c = new int[]{1887, 966732, 967231, 967733, 968265, 968766, 969297, 969798, 970298, 970829, 971330, 971830, 972362, 972863, 973395, 973896, 974397, 974928, 975428, 975929, 976461, 976962, 977462, 977994, 978494, 979026, 979526, 980026, 980558, 981059, 981559, 982091, 982593, 983124, 983624, 984124, 984656, 985157, 985656, 986189, 986690, 987191, 987722, 988222, 988753, 989254, 989754, 990286, 990788, 991288, 991819, 992319, 992851, 993352, 993851, 994383, 994885, 995385, 995917, 996418, 996918, 997450, 997949, 998481, 998982, 999483, 1000014, 1000515, 1001016, 1001548, 1002047, 1002578, 1003080, 1003580, 1004111, 1004613, 1005113, 1005645, 1006146, 1006645, 1007177, 1007678, 1008209, 1008710, 1009211, 1009743, 1010243, 1010743, 1011275, 1011775, 1012306, 1012807, 1013308, 1013840, 1014341, 1014841, 1015373, 1015874, 1016404, 1016905, 1017405, 1017937, 1018438, 1018939, 1019471, 1019972, 1020471, 1021002, 1021503, 1022035, 1022535, 1023036, 1023568, 1024069, 1024568, 1025100, 1025601, 1026102, 1026633, 1027133, 1027666, 1028167, 1028666, 1029198, 1029699, 1030199, 1030730, 1031231, 1031763, 1032264, 1032764, 1033296, 1033797, 1034297, 1034828, 1035329, 1035830, 1036362, 1036861, 1037393, 1037894, 1038394, 1038925, 1039427, 1039927, 1040459, 1040959, 1041491, 1041992, 1042492, 1043023, 1043524, 1044024, 1044556, 1045057, 1045558, 1046090, 1046590, 1047121, 1047622, 1048122, 1048654, 1049154, 1049655, 1050187, 1050689, 1051219, 1051720, 1052220, 1052751, 1053252, 1053752, 1054284, 1054786, 1055285, 1055817, 1056317, 1056849, 1057349, 1057850, 1058382, 1058883, 1059383, 1059915, 1060415, 1060947, 1061447, 1061947, 1062479, 1062981, 1063480, 1064012, 1064514, 1065014, 1065545, 1066045, 1066577, 1067078, 1067578, 1068110, 1068611, 1069112, 1069642, 1070142, 1070674, 1071175, 1071675, 1072207, 1072709, 1073209, 1073740, 1074241, 1074741, 1075273, 1075773, 1076305, 1076807, 1077308, 1077839, 1078340, 1078840, 1079372, 1079871, 1080403, 1080904};
        f12531d = new int[]{1887, 5780, 5802, 19157, 2742, 50359, 1198, 2646, 46378, 7466, 3412, 30122, 5482, 67949, 2396, 5294, 43597, 6732, 6954, 36181, 2772, 4954, 18781, 2396, 54427, 5274, 6730, 47781, 5800, 6868, 21210, 4790, 59703, 2350, 5270, 46667, 3402, 3496, 38325, 1388, 4782, 18735, 2350, 52374, 6804, 7498, 44457, 2906, 1388, 29294, 4700, 63789, 6442, 6804, 56138, 5802, 2772, 38235, FeatureCodes.FACE_MULTI, 4698, 22827, 5418, 63125, 3476, 5802, 43701, 2484, 5302, 27223, 2646, 70954, 7466, 3412, 54698, 5482, 2412, 38062, 5294, 2636, 32038, 6954, 60245, 2772, 4826, 43357, 2394, 5274, 39501, 6730, 72357, 5800, 5844, 53978, 4790, 2358, 38039, 5270, 87627, 3402, 3496, 54708, 5484, 4782, 43311, 2350, 3222, 27978, 7498, 68965, 2904, 5484, 45677, 4700, 6444, 39573, 6804, 6986, 19285, 2772, 62811, FeatureCodes.FACE_MULTI, 4698, 47403, 5418, 5780, 38570, 5546, 76469, 2420, 5302, 51799, 2646, 5414, 36501, 3412, 5546, 18869, 2412, 54446, 5276, 6732, 48422, 6822, 2900, 28010, 4826, 92509, 2394, 5274, 55883, 6730, 6820, 47956, 5812, 2778, 18779, 2358, 62615, 5270, 5450, 46757, 3492, 5556, 27318, 4718, 67887, 2350, 3222, 52554, 7498, 3428, 38252, 5468, 4700, 31022, 6444, 64149, 6804, 6986, 43861, 2772, 5338, 35421, 2650, 70955, 5418, 5780, 54954, 5546, 2740, 38074, 5302, 2646, 29991, 3366, 61011, 3412, 5546, 43445, 2412, 5294, 35406, 6732, 72998, 6820, 6996, 52586, 2778, 2396, 38045, 5274, 6698, 23333, 6820, 64338, 5812, 2746, 43355, 2358, 5270, 39499, 5450, 79525, 3492, 5548};
    }

    public static int a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65537, null, i2, i3, i4)) == null) ? (i2 & (((1 << i3) - 1) << i4)) >> i4 : invokeIII.intValue;
    }

    public static final int[] b(int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
            if (i2 >= 1900 && i2 <= 2099 && i3 >= 1 && i3 <= 12 && i4 >= 1 && i4 <= 30) {
                int[] iArr = f12529b;
                int i5 = i2 - 1900;
                int i6 = (iArr[i5] & 31) - 1;
                if (((iArr[i5] & 96) >> 5) == 2) {
                    i6 += 31;
                }
                for (int i7 = 1; i7 < i3; i7++) {
                    i6 = ((524288 >> (i7 + (-1))) & f12529b[i5]) == 0 ? i6 + 29 : i6 + 30;
                }
                int i8 = i6 + i4;
                int i9 = (f12529b[i5] & 15728640) >> 20;
                if (i9 != 0 && (i3 > i9 || (i3 == i9 && z))) {
                    i8 = ((524288 >> (i3 - 1)) & f12529b[i5]) == 0 ? i8 + 29 : i8 + 30;
                }
                if (i8 > 366 || (i2 % 4 != 0 && i8 > 365)) {
                    i2++;
                    i8 = i2 % 4 == 1 ? i8 - 366 : i8 - 365;
                }
                int[] iArr2 = new int[3];
                int i10 = 1;
                while (true) {
                    if (i10 >= 13) {
                        break;
                    }
                    int i11 = a[i10];
                    int i12 = i2 % 4;
                    if (i12 == 0 && i10 > 2) {
                        i11++;
                    }
                    if (i12 == 0 && i10 == 2 && i11 + 1 == i8) {
                        iArr2[1] = i10;
                        iArr2[2] = i8 - 31;
                        break;
                    } else if (i11 >= i8) {
                        iArr2[1] = i10;
                        int i13 = i10 - 1;
                        int i14 = a[i13];
                        if (i12 == 0 && i10 > 2) {
                            i14++;
                        }
                        if (i8 > i14) {
                            iArr2[2] = i8 - i14;
                        } else if (i8 != i14) {
                            iArr2[2] = i8;
                        } else if (i12 == 0 && i10 == 2) {
                            int[] iArr3 = a;
                            iArr2[2] = (iArr3[i10] - iArr3[i13]) + 1;
                        } else {
                            int[] iArr4 = a;
                            iArr2[2] = iArr4[i10] - iArr4[i13];
                        }
                    } else {
                        i10++;
                    }
                }
                iArr2[0] = i2;
                return iArr2;
            }
            throw new IllegalArgumentException("Illegal lunar date, must be like that:\n\tyear : 1900~2099\n\tmonth : 1~12\n\tday : 1~30");
        }
        return (int[]) invokeCommon.objValue;
    }

    public static long c(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65539, null, i2, i3, i4)) == null) {
            int i5 = (i3 + 9) % 12;
            int i6 = i2 - (i5 / 10);
            return (((i6 * 365) + (i6 / 4)) - (i6 / 100)) + (i6 / 400) + (((i5 * ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA) + 5) / 10) + (i4 - 1);
        }
        return invokeIII.longValue;
    }

    public static final int[] d(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3, i4)) == null) {
            int[] iArr = new int[4];
            int[] iArr2 = f12530c;
            int i5 = 0;
            int i6 = i2 - iArr2[0];
            if (iArr2[i6] > ((i2 << 9) | (i3 << 5) | i4)) {
                i6--;
            }
            int i7 = f12530c[i6];
            long c2 = c(i2, i3, i4) - c(a(i7, 12, 9), a(i7, 4, 5), a(i7, 5, 0));
            int i8 = f12531d[i6];
            int a2 = a(i8, 4, 13);
            int i9 = i6 + f12530c[0];
            long j2 = c2 + 1;
            int i10 = 1;
            for (int i11 = 0; i11 < 13; i11++) {
                long j3 = a(i8, 1, 12 - i11) == 1 ? 30 : 29;
                if (j2 <= j3) {
                    break;
                }
                i10++;
                j2 -= j3;
            }
            int i12 = (int) j2;
            iArr[0] = i9;
            iArr[1] = i10;
            if (a2 != 0 && i10 > a2) {
                iArr[1] = i10 - 1;
                if (i10 == a2 + 1) {
                    i5 = 1;
                }
            }
            iArr[2] = i12;
            iArr[3] = i5;
            return iArr;
        }
        return (int[]) invokeIII.objValue;
    }
}
