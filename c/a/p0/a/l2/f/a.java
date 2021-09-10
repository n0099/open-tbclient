package c.a.p0.a.l2.f;

import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f7297a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f7298b;

    /* renamed from: c  reason: collision with root package name */
    public static final SparseIntArray f7299c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.l2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0288a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(399144597, "Lc/a/p0/a/l2/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(399144597, "Lc/a/p0/a/l2/f/a;");
                return;
            }
        }
        f7297a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
        f7298b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");
        SparseIntArray sparseIntArray = new SparseIntArray();
        f7299c = sparseIntArray;
        sparseIntArray.put(d("jan"), 0);
        f7299c.put(d("feb"), 1);
        f7299c.put(d("mar"), 2);
        f7299c.put(d("apr"), 3);
        f7299c.put(d("may"), 4);
        f7299c.put(d("jun"), 5);
        f7299c.put(d("jul"), 6);
        f7299c.put(d("aug"), 7);
        f7299c.put(d("sep"), 8);
        f7299c.put(d("oct"), 9);
        f7299c.put(d("nov"), 10);
        f7299c.put(d("dec"), 11);
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
                return f7299c.get(d(matcher.group(i2)), -1);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1L;
            }
            b bVar = new b(null);
            Matcher matcher = f7297a.matcher(str);
            if (matcher.find()) {
                bVar.f7302c = a(matcher, 1);
                bVar.f7301b = b(matcher, 2);
                bVar.f7300a = c(matcher, 3);
                f(bVar, matcher, 4);
            } else {
                Matcher matcher2 = f7298b.matcher(str);
                if (!matcher2.find()) {
                    return -1L;
                }
                bVar.f7301b = b(matcher2, 1);
                bVar.f7302c = a(matcher2, 2);
                f(bVar, matcher2, 3);
                bVar.f7300a = c(matcher2, 4);
            }
            if (bVar.a()) {
                return -1L;
            }
            if (bVar.f7300a >= 2038) {
                bVar.f7300a = SpeedStatsStampTable.INIT_MSG_SIX_STAMP_KEY;
                bVar.f7301b = 0;
                bVar.f7302c = 1;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            gregorianCalendar.set(bVar.f7300a, bVar.f7301b, bVar.f7302c, bVar.f7303d, bVar.f7304e, bVar.f7305f);
            return gregorianCalendar.getTimeInMillis();
        }
        return invokeL.longValue;
    }

    public static void f(@NonNull b bVar, @NonNull Matcher matcher, int i2) {
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, bVar, matcher, i2) == null) {
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
                bVar.f7303d = charAt;
                bVar.f7304e = ((group.charAt(i4) - '0') * 10) + (group.charAt(i5) - '0');
                int i6 = i3 + 1 + 1 + 1 + 1;
                bVar.f7305f = ((group.charAt(i6) - '0') * 10) + (group.charAt(i6 + 1) - '0');
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f7300a;

        /* renamed from: b  reason: collision with root package name */
        public int f7301b;

        /* renamed from: c  reason: collision with root package name */
        public int f7302c;

        /* renamed from: d  reason: collision with root package name */
        public int f7303d;

        /* renamed from: e  reason: collision with root package name */
        public int f7304e;

        /* renamed from: f  reason: collision with root package name */
        public int f7305f;

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
            this.f7300a = -1;
            this.f7301b = -1;
            this.f7302c = -1;
            this.f7303d = -1;
            this.f7304e = -1;
            this.f7305f = -1;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7300a == -1 || this.f7301b == -1 || this.f7302c == -1 || this.f7303d == -1 || this.f7304e == -1 || this.f7305f == -1 : invokeV.booleanValue;
        }

        public /* synthetic */ b(C0288a c0288a) {
            this();
        }
    }
}
