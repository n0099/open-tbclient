package c.a.r0.a.p2.f;

import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f8548b;

    /* renamed from: c  reason: collision with root package name */
    public static final SparseIntArray f8549c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.p2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0507a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-87642537, "Lc/a/r0/a/p2/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-87642537, "Lc/a/r0/a/p2/f/a;");
                return;
            }
        }
        a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
        f8548b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");
        SparseIntArray sparseIntArray = new SparseIntArray();
        f8549c = sparseIntArray;
        sparseIntArray.put(d("jan"), 0);
        f8549c.put(d("feb"), 1);
        f8549c.put(d("mar"), 2);
        f8549c.put(d("apr"), 3);
        f8549c.put(d("may"), 4);
        f8549c.put(d("jun"), 5);
        f8549c.put(d("jul"), 6);
        f8549c.put(d("aug"), 7);
        f8549c.put(d("sep"), 8);
        f8549c.put(d("oct"), 9);
        f8549c.put(d("nov"), 10);
        f8549c.put(d("dec"), 11);
    }

    public static int a(@NonNull Matcher matcher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, matcher, i2)) == null) {
            try {
                String group = matcher.group(i2);
                if (TextUtils.isEmpty(group)) {
                    return -1;
                }
                if (group.length() == 2) {
                    return ((group.charAt(0) - '0') * 10) + (group.charAt(1) - '0');
                }
                return group.charAt(0) - '0';
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeLI.intValue;
    }

    public static int b(@NonNull Matcher matcher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, matcher, i2)) == null) {
            try {
                return f8549c.get(d(matcher.group(i2)), -1);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeLI.intValue;
    }

    public static int c(@NonNull Matcher matcher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, matcher, i2)) == null) {
            try {
                String group = matcher.group(i2);
                if (TextUtils.isEmpty(group)) {
                    return -1;
                }
                if (group.length() == 2) {
                    int charAt = ((group.charAt(0) - '0') * 10) + (group.charAt(1) - '0');
                    return charAt >= 70 ? charAt + 1900 : charAt + 2000;
                } else if (group.length() == 3) {
                    return ((group.charAt(0) - '0') * 100) + ((group.charAt(1) - '0') * 10) + (group.charAt(2) - '0') + 1900;
                } else {
                    if (group.length() == 4) {
                        return ((group.charAt(0) - '0') * 1000) + ((group.charAt(1) - '0') * 100) + ((group.charAt(2) - '0') * 10) + (group.charAt(3) - '0');
                    }
                    return 1970;
                }
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeLI.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int i2 = -1;
            if (!TextUtils.isEmpty(str) && str.length() >= 3) {
                for (int i3 = 0; i3 < 3; i3++) {
                    i2 += Character.toLowerCase(str.charAt(i3)) - 'a';
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static long e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1L;
            }
            b bVar = new b(null);
            Matcher matcher = a.matcher(str);
            if (matcher.find()) {
                bVar.f8551c = a(matcher, 1);
                bVar.f8550b = b(matcher, 2);
                bVar.a = c(matcher, 3);
                f(bVar, matcher, 4);
            } else {
                Matcher matcher2 = f8548b.matcher(str);
                if (!matcher2.find()) {
                    return -1L;
                }
                bVar.f8550b = b(matcher2, 1);
                bVar.f8551c = a(matcher2, 2);
                f(bVar, matcher2, 3);
                bVar.a = c(matcher2, 4);
            }
            if (bVar.a()) {
                return -1L;
            }
            if (bVar.a >= 2038) {
                bVar.a = SpeedStatsStampTable.INIT_MSG_SIX_STAMP_KEY;
                bVar.f8550b = 0;
                bVar.f8551c = 1;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            gregorianCalendar.set(bVar.a, bVar.f8550b, bVar.f8551c, bVar.f8552d, bVar.f8553e, bVar.f8554f);
            return gregorianCalendar.getTimeInMillis();
        }
        return invokeL.longValue;
    }

    public static void f(@NonNull b bVar, @NonNull Matcher matcher, int i2) {
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65542, null, bVar, matcher, i2) == null) {
            try {
                String group = matcher.group(i2);
                if (TextUtils.isEmpty(group)) {
                    return;
                }
                int charAt = group.charAt(0) - '0';
                if (group.charAt(1) != ':') {
                    i3 = 2;
                    charAt = (charAt * 10) + (group.charAt(1) - '0');
                } else {
                    i3 = 1;
                }
                bVar.f8552d = charAt;
                bVar.f8553e = ((group.charAt(i4) - '0') * 10) + (group.charAt(i5) - '0');
                int i6 = i3 + 1 + 1 + 1 + 1;
                bVar.f8554f = ((group.charAt(i6) - '0') * 10) + (group.charAt(i6 + 1) - '0');
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f8550b;

        /* renamed from: c  reason: collision with root package name */
        public int f8551c;

        /* renamed from: d  reason: collision with root package name */
        public int f8552d;

        /* renamed from: e  reason: collision with root package name */
        public int f8553e;

        /* renamed from: f  reason: collision with root package name */
        public int f8554f;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.f8550b = -1;
            this.f8551c = -1;
            this.f8552d = -1;
            this.f8553e = -1;
            this.f8554f = -1;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a == -1 || this.f8550b == -1 || this.f8551c == -1 || this.f8552d == -1 || this.f8553e == -1 || this.f8554f == -1 : invokeV.booleanValue;
        }

        public /* synthetic */ b(C0507a c0507a) {
            this();
        }
    }
}
