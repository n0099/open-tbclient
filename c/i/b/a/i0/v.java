package c.i.b.a.i0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class v {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f33838a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f33839b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f33840c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f33841d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f33842e;

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f33843f;

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f33844g;

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f33845h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f33846e;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33846e = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) ? new Thread(runnable, this.f33846e) : (Thread) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-717096396, "Lc/i/b/a/i0/v;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-717096396, "Lc/i/b/a/i0/v;");
                return;
            }
        }
        f33838a = (Build.VERSION.SDK_INT == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') ? 26 : Build.VERSION.SDK_INT;
        f33839b = Build.DEVICE;
        f33840c = Build.MANUFACTURER;
        f33841d = Build.MODEL;
        f33842e = f33839b + StringUtil.ARRAY_ELEMENT_SEPARATOR + f33841d + StringUtil.ARRAY_ELEMENT_SEPARATOR + f33840c + StringUtil.ARRAY_ELEMENT_SEPARATOR + f33838a;
        f33843f = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f33844g = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        Pattern.compile("%([A-Fa-f0-9]{2})");
        f33845h = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    }

    public static boolean A(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) {
            String scheme = uri.getScheme();
            return TextUtils.isEmpty(scheme) || scheme.equals("file");
        }
        return invokeL.booleanValue;
    }

    public static ExecutorService B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? Executors.newSingleThreadExecutor(new a(str)) : (ExecutorService) invokeL.objValue;
    }

    public static String C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return new Locale(str).getLanguage();
        }
        return (String) invokeL.objValue;
    }

    public static long D(String str) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            Matcher matcher = f33843f.matcher(str);
            if (matcher.matches()) {
                int i2 = 0;
                if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
                    i2 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                    if (matcher.group(11).equals("-")) {
                        i2 *= -1;
                    }
                }
                GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                gregorianCalendar.clear();
                gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
                if (!TextUtils.isEmpty(matcher.group(8))) {
                    gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
                }
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                return i2 != 0 ? timeInMillis - (i2 * 60000) : timeInMillis;
            }
            throw new ParserException("Invalid date/time format: " + str);
        }
        return invokeL.longValue;
    }

    public static long E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            Matcher matcher = f33844g.matcher(str);
            if (matcher.matches()) {
                boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
                String group = matcher.group(3);
                double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
                String group2 = matcher.group(5);
                double parseDouble2 = parseDouble + (group2 != null ? Double.parseDouble(group2) * 2629739.0d : 0.0d);
                String group3 = matcher.group(7);
                double parseDouble3 = parseDouble2 + (group3 != null ? Double.parseDouble(group3) * 86400.0d : 0.0d);
                String group4 = matcher.group(10);
                double parseDouble4 = parseDouble3 + (group4 != null ? Double.parseDouble(group4) * 3600.0d : 0.0d);
                String group5 = matcher.group(12);
                double parseDouble5 = parseDouble4 + (group5 != null ? Double.parseDouble(group5) * 60.0d : 0.0d);
                String group6 = matcher.group(14);
                long parseDouble6 = (long) ((parseDouble5 + (group6 != null ? Double.parseDouble(group6) : 0.0d)) * 1000.0d);
                return isEmpty ? -parseDouble6 : parseDouble6;
            }
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        return invokeL.longValue;
    }

    public static long F(long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
            int i2 = (j4 > j3 ? 1 : (j4 == j3 ? 0 : -1));
            if (i2 < 0 || j4 % j3 != 0) {
                return (i2 >= 0 || j3 % j4 != 0) ? (long) (j2 * (j3 / j4)) : j2 * (j3 / j4);
            }
            return j2 / (j4 / j3);
        }
        return invokeCommon.longValue;
    }

    public static long[] G(List<Long> list, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{list, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            int size = list.size();
            long[] jArr = new long[size];
            int i2 = 0;
            int i3 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
            if (i3 >= 0 && j3 % j2 == 0) {
                long j4 = j3 / j2;
                while (i2 < size) {
                    jArr[i2] = list.get(i2).longValue() / j4;
                    i2++;
                }
            } else if (i3 >= 0 || j2 % j3 != 0) {
                double d2 = j2 / j3;
                while (i2 < size) {
                    jArr[i2] = (long) (list.get(i2).longValue() * d2);
                    i2++;
                }
            } else {
                long j5 = j2 / j3;
                while (i2 < size) {
                    jArr[i2] = list.get(i2).longValue() * j5;
                    i2++;
                }
            }
            return jArr;
        }
        return (long[]) invokeCommon.objValue;
    }

    public static void H(long[] jArr, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{jArr, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            int i2 = 0;
            int i3 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
            if (i3 >= 0 && j3 % j2 == 0) {
                long j4 = j3 / j2;
                while (i2 < jArr.length) {
                    jArr[i2] = jArr[i2] / j4;
                    i2++;
                }
            } else if (i3 < 0 && j2 % j3 == 0) {
                long j5 = j2 / j3;
                while (i2 < jArr.length) {
                    jArr[i2] = jArr[i2] * j5;
                    i2++;
                }
            } else {
                double d2 = j2 / j3;
                while (i2 < jArr.length) {
                    jArr[i2] = (long) (jArr[i2] * d2);
                    i2++;
                }
            }
        }
    }

    public static int[] I(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, list)) == null) {
            if (list == null) {
                return null;
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = list.get(i2).intValue();
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static String J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return str.toLowerCase(Locale.US);
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, obj, obj2)) == null) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }
        return invokeLL.booleanValue;
    }

    public static int b(long[] jArr, long j2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{jArr, Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int binarySearch = Arrays.binarySearch(jArr, j2);
            if (binarySearch < 0) {
                i2 = ~binarySearch;
            } else {
                do {
                    binarySearch++;
                    if (binarySearch >= jArr.length) {
                        break;
                    }
                } while (jArr[binarySearch] == j2);
                i2 = z ? binarySearch - 1 : binarySearch;
            }
            return z2 ? Math.min(jArr.length - 1, i2) : i2;
        }
        return invokeCommon.intValue;
    }

    public static <T> int c(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{list, t, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int binarySearch = Collections.binarySearch(list, t);
            if (binarySearch < 0) {
                i2 = -(binarySearch + 2);
            } else {
                do {
                    binarySearch--;
                    if (binarySearch < 0) {
                        break;
                    }
                } while (list.get(binarySearch).compareTo(t) == 0);
                i2 = z ? binarySearch + 1 : binarySearch;
            }
            return z2 ? Math.max(0, i2) : i2;
        }
        return invokeCommon.intValue;
    }

    public static int d(int[] iArr, int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{iArr, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int binarySearch = Arrays.binarySearch(iArr, i2);
            if (binarySearch < 0) {
                i3 = -(binarySearch + 2);
            } else {
                do {
                    binarySearch--;
                    if (binarySearch < 0) {
                        break;
                    }
                } while (iArr[binarySearch] == i2);
                i3 = z ? binarySearch + 1 : binarySearch;
            }
            return z2 ? Math.max(0, i3) : i3;
        }
        return invokeCommon.intValue;
    }

    public static int e(long[] jArr, long j2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{jArr, Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int binarySearch = Arrays.binarySearch(jArr, j2);
            if (binarySearch < 0) {
                i2 = -(binarySearch + 2);
            } else {
                do {
                    binarySearch--;
                    if (binarySearch < 0) {
                        break;
                    }
                } while (jArr[binarySearch] == j2);
                i2 = z ? binarySearch + 1 : binarySearch;
            }
            return z2 ? Math.max(0, i2) : i2;
        }
        return invokeCommon.intValue;
    }

    public static int f(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65552, null, i2, i3)) == null) ? ((i2 + i3) - 1) / i3 : invokeII.intValue;
    }

    public static long g(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? ((j2 + j3) - 1) / j3 : invokeCommon.longValue;
    }

    public static void h(c.i.b.a.h0.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, eVar) == null) || eVar == null) {
            return;
        }
        try {
            eVar.close();
        } catch (IOException unused) {
        }
    }

    public static void i(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static float j(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? Math.max(f3, Math.min(f2, f4)) : invokeCommon.floatValue;
    }

    public static int k(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65557, null, i2, i3, i4)) == null) ? Math.max(i3, Math.min(i2, i4)) : invokeIII.intValue;
    }

    public static long l(long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) ? Math.max(j3, Math.min(j2, j4)) : invokeCommon.longValue;
    }

    public static int m(byte[] bArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65559, null, bArr, i2, i3, i4)) == null) {
            while (i2 < i3) {
                i4 = f33845h[((i4 >>> 24) ^ (bArr[i2] & 255)) & 255] ^ (i4 << 8);
                i2++;
            }
            return i4;
        }
        return invokeLIII.intValue;
    }

    public static byte[] n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String o(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, objArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < objArr.length; i2++) {
                sb.append(objArr[i2].getClass().getSimpleName());
                if (i2 < objArr.length - 1) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3 || i2 == 4) {
                            return 131072;
                        }
                        throw new IllegalStateException();
                    }
                    return 13107200;
                }
                return 3538944;
            }
            return 16777216;
        }
        return invokeI.intValue;
    }

    public static int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            int length = str.length();
            c.i.b.a.i0.a.a(length <= 4);
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 = (i2 << 8) | str.charAt(i3);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static int r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65564, null, i2)) == null) {
            if (i2 != 8) {
                if (i2 != 16) {
                    if (i2 != 24) {
                        return i2 != 32 ? 0 : 1073741824;
                    }
                    return Integer.MIN_VALUE;
                }
                return 2;
            }
            return 3;
        }
        return invokeI.intValue;
    }

    public static int s(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65565, null, i2, i3)) == null) {
            if (i2 != Integer.MIN_VALUE) {
                if (i2 != 1073741824) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            return i3;
                        }
                        throw new IllegalArgumentException();
                    }
                    return i3 * 2;
                }
                return i3 * 4;
            }
            return i3 * 3;
        }
        return invokeII.intValue;
    }

    public static int t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, null, i2)) == null) {
            if (i2 != 13) {
                switch (i2) {
                    case 2:
                        return 0;
                    case 3:
                        return 8;
                    case 4:
                        return 4;
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        return 5;
                    case 6:
                        return 2;
                    default:
                        return 3;
                }
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public static String u(StringBuilder sb, Formatter formatter, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65567, null, new Object[]{sb, formatter, Long.valueOf(j2)})) == null) {
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            long j3 = (j2 + 500) / 1000;
            long j4 = j3 % 60;
            long j5 = (j3 / 60) % 60;
            long j6 = j3 / 3600;
            sb.setLength(0);
            return j6 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)).toString() : formatter.format("%02d:%02d", Long.valueOf(j5), Long.valueOf(j4)).toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String v(Context context, String str) {
        String str2;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, context, str)) == null) {
            try {
                str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                str2 = "?";
            }
            return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.6.0";
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) ? str.getBytes(Charset.forName("UTF-8")) : (byte[]) invokeL.objValue;
    }

    public static int x(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, uri)) == null) {
            String path = uri.getPath();
            if (path == null) {
                return 3;
            }
            return y(path);
        }
        return invokeL.intValue;
    }

    public static int y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            String J = J(str);
            if (J.endsWith(".mpd")) {
                return 0;
            }
            if (J.endsWith(".m3u8")) {
                return 2;
            }
            return J.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?") ? 1 : 3;
        }
        return invokeL.intValue;
    }

    public static boolean z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65572, null, i2)) == null) ? i2 == 10 || i2 == 13 : invokeI.booleanValue;
    }
}
