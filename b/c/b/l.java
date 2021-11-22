package b.c.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.http.HttpDate;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes6.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern j;
    public static final Pattern k;
    public static final Pattern l;
    public static final Pattern m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f31381a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31382b;

    /* renamed from: c  reason: collision with root package name */
    public final long f31383c;

    /* renamed from: d  reason: collision with root package name */
    public final String f31384d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31385e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f31386f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f31387g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f31388h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f31389i;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public String f31390a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public String f31391b;

        /* renamed from: c  reason: collision with root package name */
        public long f31392c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public String f31393d;

        /* renamed from: e  reason: collision with root package name */
        public String f31394e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31395f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f31396g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f31397h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f31398i;

        public a() {
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
            this.f31392c = HttpDate.MAX_DATE;
            this.f31394e = "/";
        }

        public l a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new l(this) : (l) invokeV.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                c(str, false);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a c(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
                if (str != null) {
                    String c2 = b.c.b.e0.e.c(str);
                    if (c2 != null) {
                        this.f31393d = c2;
                        this.f31398i = z;
                        return this;
                    }
                    throw new IllegalArgumentException("unexpected domain: " + str);
                }
                throw new NullPointerException("domain == null");
            }
            return (a) invokeLZ.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (str != null) {
                    if (str.trim().equals(str)) {
                        this.f31390a = str;
                        return this;
                    }
                    throw new IllegalArgumentException("name is not trimmed");
                }
                throw new NullPointerException("name == null");
            }
            return (a) invokeL.objValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (str != null) {
                    if (str.trim().equals(str)) {
                        this.f31391b = str;
                        return this;
                    }
                    throw new IllegalArgumentException("value is not trimmed");
                }
                throw new NullPointerException("value == null");
            }
            return (a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(712794849, "Lb/c/b/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(712794849, "Lb/c/b/l;");
                return;
            }
        }
        j = Pattern.compile("(\\d{2,4})[^\\d]*");
        k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        l = Pattern.compile("(\\d{1,2})[^\\d]*");
        m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    public l(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j2), str3, str4, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f31381a = str;
        this.f31382b = str2;
        this.f31383c = j2;
        this.f31384d = str3;
        this.f31385e = str4;
        this.f31386f = z;
        this.f31387g = z2;
        this.f31389i = z3;
        this.f31388h = z4;
    }

    public static int a(String str, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str.equals(str2)) {
                return true;
            }
            return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !b.c.b.e0.e.I(str);
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012c  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static l d(long j2, s sVar, String str) {
        InterceptResult invokeCommon;
        long j3;
        String l2;
        l lVar;
        String str2;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Long.valueOf(j2), sVar, str})) == null) {
            int length = str.length();
            char c2 = ';';
            int m2 = b.c.b.e0.e.m(str, 0, length, ';');
            char c3 = com.alipay.sdk.encrypt.a.f34958h;
            int m3 = b.c.b.e0.e.m(str, 0, m2, com.alipay.sdk.encrypt.a.f34958h);
            if (m3 == m2) {
                return null;
            }
            String H = b.c.b.e0.e.H(str, 0, m3);
            if (H.isEmpty() || b.c.b.e0.e.w(H) != -1) {
                return null;
            }
            String H2 = b.c.b.e0.e.H(str, m3 + 1, m2);
            if (b.c.b.e0.e.w(H2) != -1) {
                return null;
            }
            int i2 = m2 + 1;
            String str3 = null;
            String str4 = null;
            long j4 = -1;
            long j5 = 253402300799999L;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = true;
            boolean z4 = false;
            while (i2 < length) {
                int m4 = b.c.b.e0.e.m(str, i2, length, c2);
                int m5 = b.c.b.e0.e.m(str, i2, m4, c3);
                String H3 = b.c.b.e0.e.H(str, i2, m5);
                String H4 = m5 < m4 ? b.c.b.e0.e.H(str, m5 + 1, m4) : "";
                if (H3.equalsIgnoreCase("expires")) {
                    try {
                        j5 = h(H4, 0, H4.length());
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (H3.equalsIgnoreCase(ClientCookie.MAX_AGE_ATTR)) {
                    j4 = i(H4);
                } else {
                    if (H3.equalsIgnoreCase("domain")) {
                        str4 = g(H4);
                        z3 = false;
                    } else if (H3.equalsIgnoreCase("path")) {
                        str3 = H4;
                    } else if (H3.equalsIgnoreCase(ClientCookie.SECURE_ATTR)) {
                        z = true;
                    } else if (H3.equalsIgnoreCase("httponly")) {
                        z2 = true;
                    }
                    i2 = m4 + 1;
                    c2 = ';';
                    c3 = com.alipay.sdk.encrypt.a.f34958h;
                }
                z4 = true;
                i2 = m4 + 1;
                c2 = ';';
                c3 = com.alipay.sdk.encrypt.a.f34958h;
            }
            long j6 = Long.MIN_VALUE;
            if (j4 != Long.MIN_VALUE) {
                if (j4 != -1) {
                    j6 = j2 + (j4 <= 9223372036854775L ? j4 * 1000 : Long.MAX_VALUE);
                    if (j6 < j2 || j6 > HttpDate.MAX_DATE) {
                        j3 = 253402300799999L;
                    }
                } else {
                    j3 = j5;
                }
                l2 = sVar.l();
                if (str4 != null) {
                    str2 = l2;
                    lVar = null;
                } else if (!b(l2, str4)) {
                    return null;
                } else {
                    lVar = null;
                    str2 = str4;
                }
                if (l2.length() == str2.length() && PublicSuffixDatabase.c().d(str2) == null) {
                    return lVar;
                }
                if (str3 == null && str3.startsWith("/")) {
                    substring = str3;
                } else {
                    String g2 = sVar.g();
                    int lastIndexOf = g2.lastIndexOf(47);
                    substring = lastIndexOf != 0 ? g2.substring(0, lastIndexOf) : "/";
                }
                return new l(H, H2, j3, str2, substring, z, z2, z3, z4);
            }
            j3 = j6;
            l2 = sVar.l();
            if (str4 != null) {
            }
            if (l2.length() == str2.length()) {
            }
            if (str3 == null) {
            }
            String g22 = sVar.g();
            int lastIndexOf2 = g22.lastIndexOf(47);
            substring = lastIndexOf2 != 0 ? g22.substring(0, lastIndexOf2) : "/";
            return new l(H, H2, j3, str2, substring, z, z2, z3, z4);
        }
        return (l) invokeCommon.objValue;
    }

    @Nullable
    public static l e(s sVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, sVar, str)) == null) ? d(System.currentTimeMillis(), sVar, str) : (l) invokeLL.objValue;
    }

    public static List<l> f(s sVar, r rVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, sVar, rVar)) == null) {
            List<String> i2 = rVar.i("Set-Cookie");
            int size = i2.size();
            ArrayList arrayList = null;
            for (int i3 = 0; i3 < size; i3++) {
                l e2 = e(sVar, i2.get(i3));
                if (e2 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(e2);
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        }
        return (List) invokeLL.objValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (!str.endsWith(".")) {
                if (str.startsWith(".")) {
                    str = str.substring(1);
                }
                String c2 = b.c.b.e0.e.c(str);
                if (c2 != null) {
                    return c2;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        return (String) invokeL.objValue;
    }

    public static long h(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, str, i2, i3)) == null) {
            int a2 = a(str, i2, i3, false);
            Matcher matcher = m.matcher(str);
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            while (a2 < i3) {
                int a3 = a(str, a2 + 1, i3, true);
                matcher.region(a2, a3);
                if (i5 == -1 && matcher.usePattern(m).matches()) {
                    i5 = Integer.parseInt(matcher.group(1));
                    i8 = Integer.parseInt(matcher.group(2));
                    i9 = Integer.parseInt(matcher.group(3));
                } else if (i6 == -1 && matcher.usePattern(l).matches()) {
                    i6 = Integer.parseInt(matcher.group(1));
                } else if (i7 == -1 && matcher.usePattern(k).matches()) {
                    i7 = k.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i4 == -1 && matcher.usePattern(j).matches()) {
                    i4 = Integer.parseInt(matcher.group(1));
                }
                a2 = a(str, a3 + 1, i3, false);
            }
            if (i4 >= 70 && i4 <= 99) {
                i4 += 1900;
            }
            if (i4 >= 0 && i4 <= 69) {
                i4 += 2000;
            }
            if (i4 >= 1601) {
                if (i7 != -1) {
                    if (i6 < 1 || i6 > 31) {
                        throw new IllegalArgumentException();
                    }
                    if (i5 < 0 || i5 > 23) {
                        throw new IllegalArgumentException();
                    }
                    if (i8 < 0 || i8 > 59) {
                        throw new IllegalArgumentException();
                    }
                    if (i9 >= 0 && i9 <= 59) {
                        GregorianCalendar gregorianCalendar = new GregorianCalendar(b.c.b.e0.e.f31052f);
                        gregorianCalendar.setLenient(false);
                        gregorianCalendar.set(1, i4);
                        gregorianCalendar.set(2, i7 - 1);
                        gregorianCalendar.set(5, i6);
                        gregorianCalendar.set(11, i5);
                        gregorianCalendar.set(12, i8);
                        gregorianCalendar.set(13, i9);
                        gregorianCalendar.set(14, 0);
                        return gregorianCalendar.getTimeInMillis();
                    }
                    throw new IllegalArgumentException();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        return invokeLII.longValue;
    }

    public static long i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e2) {
                if (str.matches("-?\\d+")) {
                    return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e2;
            }
        }
        return invokeL.longValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31381a : (String) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof l) {
                l lVar = (l) obj;
                return lVar.f31381a.equals(this.f31381a) && lVar.f31382b.equals(this.f31382b) && lVar.f31384d.equals(this.f31384d) && lVar.f31385e.equals(this.f31385e) && lVar.f31383c == this.f31383c && lVar.f31386f == this.f31386f && lVar.f31387g == this.f31387g && lVar.f31388h == this.f31388h && lVar.f31389i == this.f31389i;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j2 = this.f31383c;
            return ((((((((((((((((527 + this.f31381a.hashCode()) * 31) + this.f31382b.hashCode()) * 31) + this.f31384d.hashCode()) * 31) + this.f31385e.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f31386f ? 1 : 0)) * 31) + (!this.f31387g ? 1 : 0)) * 31) + (!this.f31388h ? 1 : 0)) * 31) + (!this.f31389i ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public String j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f31381a);
            sb.append(com.alipay.sdk.encrypt.a.f34958h);
            sb.append(this.f31382b);
            if (this.f31388h) {
                if (this.f31383c == Long.MIN_VALUE) {
                    sb.append("; max-age=0");
                } else {
                    sb.append("; expires=");
                    sb.append(b.c.b.e0.i.d.a(new Date(this.f31383c)));
                }
            }
            if (!this.f31389i) {
                sb.append("; domain=");
                if (z) {
                    sb.append(".");
                }
                sb.append(this.f31384d);
            }
            sb.append("; path=");
            sb.append(this.f31385e);
            if (this.f31386f) {
                sb.append("; secure");
            }
            if (this.f31387g) {
                sb.append("; httponly");
            }
            return sb.toString();
        }
        return (String) invokeZ.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31382b : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? j(false) : (String) invokeV.objValue;
    }

    public l(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        String str = aVar.f31390a;
        if (str != null) {
            String str2 = aVar.f31391b;
            if (str2 != null) {
                String str3 = aVar.f31393d;
                if (str3 != null) {
                    this.f31381a = str;
                    this.f31382b = str2;
                    this.f31383c = aVar.f31392c;
                    this.f31384d = str3;
                    this.f31385e = aVar.f31394e;
                    this.f31386f = aVar.f31395f;
                    this.f31387g = aVar.f31396g;
                    this.f31388h = aVar.f31397h;
                    this.f31389i = aVar.f31398i;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }
}
