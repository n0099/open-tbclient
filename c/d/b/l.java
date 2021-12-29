package c.d.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
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
/* loaded from: classes9.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f28847j;

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f28848k;
    public static final Pattern l;
    public static final Pattern m;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f28849b;

    /* renamed from: c  reason: collision with root package name */
    public final long f28850c;

    /* renamed from: d  reason: collision with root package name */
    public final String f28851d;

    /* renamed from: e  reason: collision with root package name */
    public final String f28852e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f28853f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f28854g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f28855h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f28856i;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public String a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public String f28857b;

        /* renamed from: c  reason: collision with root package name */
        public long f28858c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public String f28859d;

        /* renamed from: e  reason: collision with root package name */
        public String f28860e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f28861f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f28862g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f28863h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f28864i;

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
            this.f28858c = HttpDate.MAX_DATE;
            this.f28860e = "/";
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
                    String c2 = c.d.b.e0.e.c(str);
                    if (c2 != null) {
                        this.f28859d = c2;
                        this.f28864i = z;
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
                        this.a = str;
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
                        this.f28857b = str;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1810732961, "Lc/d/b/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1810732961, "Lc/d/b/l;");
                return;
            }
        }
        f28847j = Pattern.compile("(\\d{2,4})[^\\d]*");
        f28848k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
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
        this.a = str;
        this.f28849b = str2;
        this.f28850c = j2;
        this.f28851d = str3;
        this.f28852e = str4;
        this.f28853f = z;
        this.f28854g = z2;
        this.f28856i = z3;
        this.f28855h = z4;
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
            return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !c.d.b.e0.e.I(str);
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j2), sVar, str})) == null) {
            int length = str.length();
            char c2 = ';';
            int m2 = c.d.b.e0.e.m(str, 0, length, ';');
            char c3 = com.alipay.sdk.encrypt.a.f31864h;
            int m3 = c.d.b.e0.e.m(str, 0, m2, com.alipay.sdk.encrypt.a.f31864h);
            if (m3 == m2) {
                return null;
            }
            String H = c.d.b.e0.e.H(str, 0, m3);
            if (H.isEmpty() || c.d.b.e0.e.w(H) != -1) {
                return null;
            }
            String H2 = c.d.b.e0.e.H(str, m3 + 1, m2);
            if (c.d.b.e0.e.w(H2) != -1) {
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
                int m4 = c.d.b.e0.e.m(str, i2, length, c2);
                int m5 = c.d.b.e0.e.m(str, i2, m4, c3);
                String H3 = c.d.b.e0.e.H(str, i2, m5);
                String H4 = m5 < m4 ? c.d.b.e0.e.H(str, m5 + 1, m4) : "";
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
                    c3 = com.alipay.sdk.encrypt.a.f31864h;
                }
                z4 = true;
                i2 = m4 + 1;
                c2 = ';';
                c3 = com.alipay.sdk.encrypt.a.f31864h;
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, sVar, str)) == null) ? d(System.currentTimeMillis(), sVar, str) : (l) invokeLL.objValue;
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
                String c2 = c.d.b.e0.e.c(str);
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
                } else if (i7 == -1 && matcher.usePattern(f28848k).matches()) {
                    i7 = f28848k.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i4 == -1 && matcher.usePattern(f28847j).matches()) {
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
                        GregorianCalendar gregorianCalendar = new GregorianCalendar(c.d.b.e0.e.f28542f);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof l) {
                l lVar = (l) obj;
                return lVar.a.equals(this.a) && lVar.f28849b.equals(this.f28849b) && lVar.f28851d.equals(this.f28851d) && lVar.f28852e.equals(this.f28852e) && lVar.f28850c == this.f28850c && lVar.f28853f == this.f28853f && lVar.f28854g == this.f28854g && lVar.f28855h == this.f28855h && lVar.f28856i == this.f28856i;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j2 = this.f28850c;
            return ((((((((((((((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.a.hashCode()) * 31) + this.f28849b.hashCode()) * 31) + this.f28851d.hashCode()) * 31) + this.f28852e.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f28853f ? 1 : 0)) * 31) + (!this.f28854g ? 1 : 0)) * 31) + (!this.f28855h ? 1 : 0)) * 31) + (!this.f28856i ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public String j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(com.alipay.sdk.encrypt.a.f31864h);
            sb.append(this.f28849b);
            if (this.f28855h) {
                if (this.f28850c == Long.MIN_VALUE) {
                    sb.append("; max-age=0");
                } else {
                    sb.append("; expires=");
                    sb.append(c.d.b.e0.i.d.a(new Date(this.f28850c)));
                }
            }
            if (!this.f28856i) {
                sb.append("; domain=");
                if (z) {
                    sb.append(".");
                }
                sb.append(this.f28851d);
            }
            sb.append("; path=");
            sb.append(this.f28852e);
            if (this.f28853f) {
                sb.append("; secure");
            }
            if (this.f28854g) {
                sb.append("; httponly");
            }
            return sb.toString();
        }
        return (String) invokeZ.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28849b : (String) invokeV.objValue;
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
        String str = aVar.a;
        if (str != null) {
            String str2 = aVar.f28857b;
            if (str2 != null) {
                String str3 = aVar.f28859d;
                if (str3 != null) {
                    this.a = str;
                    this.f28849b = str2;
                    this.f28850c = aVar.f28858c;
                    this.f28851d = str3;
                    this.f28852e = aVar.f28860e;
                    this.f28853f = aVar.f28861f;
                    this.f28854g = aVar.f28862g;
                    this.f28855h = aVar.f28863h;
                    this.f28856i = aVar.f28864i;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }
}
