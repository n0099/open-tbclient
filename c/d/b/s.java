package c.d.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import okio.Buffer;
/* loaded from: classes4.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final char[] f32024i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f32025a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32026b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32027c;

    /* renamed from: d  reason: collision with root package name */
    public final String f32028d;

    /* renamed from: e  reason: collision with root package name */
    public final int f32029e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f32030f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final String f32031g;

    /* renamed from: h  reason: collision with root package name */
    public final String f32032h;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public String f32033a;

        /* renamed from: b  reason: collision with root package name */
        public String f32034b;

        /* renamed from: c  reason: collision with root package name */
        public String f32035c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public String f32036d;

        /* renamed from: e  reason: collision with root package name */
        public int f32037e;

        /* renamed from: f  reason: collision with root package name */
        public final List<String> f32038f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public List<String> f32039g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public String f32040h;

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
            this.f32034b = "";
            this.f32035c = "";
            this.f32037e = -1;
            ArrayList arrayList = new ArrayList();
            this.f32038f = arrayList;
            arrayList.add("");
        }

        public static String b(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, str, i2, i3)) == null) ? c.d.b.e0.e.c(s.r(str, i2, i3, false)) : (String) invokeLII.objValue;
        }

        public static int i(String str, int i2, int i3) {
            InterceptResult invokeLII;
            int parseInt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, str, i2, i3)) == null) {
                try {
                    parseInt = Integer.parseInt(s.a(str, i2, i3, "", false, false, false, true, null));
                } catch (NumberFormatException unused) {
                }
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            }
            return invokeLII.intValue;
        }

        public static int m(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, str, i2, i3)) == null) {
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt == ':') {
                        return i2;
                    }
                    if (charAt == '[') {
                        do {
                            i2++;
                            if (i2 < i3) {
                            }
                        } while (str.charAt(i2) != ']');
                    }
                    i2++;
                }
                return i3;
            }
            return invokeLII.intValue;
        }

        public static int r(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, i3)) == null) {
                if (i3 - i2 < 2) {
                    return -1;
                }
                char charAt = str.charAt(i2);
                if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                    while (true) {
                        i2++;
                        if (i2 >= i3) {
                            break;
                        }
                        char charAt2 = str.charAt(i2);
                        if (charAt2 < 'a' || charAt2 > 'z') {
                            if (charAt2 < 'A' || charAt2 > 'Z') {
                                if (charAt2 < '0' || charAt2 > '9') {
                                    if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                        if (charAt2 == ':') {
                                            return i2;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
            }
            return invokeLII.intValue;
        }

        public static int s(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.AD_TEXT_ID, null, str, i2, i3)) == null) {
                int i4 = 0;
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i4++;
                    i2++;
                }
                return i4;
            }
            return invokeLII.intValue;
        }

        public s a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f32033a != null) {
                    if (this.f32036d != null) {
                        return new s(this);
                    }
                    throw new IllegalStateException("host == null");
                }
                throw new IllegalStateException("scheme == null");
            }
            return (s) invokeV.objValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.f32037e;
                return i2 != -1 ? i2 : s.d(this.f32033a);
            }
            return invokeV.intValue;
        }

        public a d(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f32039g = str != null ? s.y(s.b(str, " \"'<>#", true, false, true, true)) : null;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (str != null) {
                    String b2 = b(str, 0, str.length());
                    if (b2 != null) {
                        this.f32036d = b2;
                        return this;
                    }
                    throw new IllegalArgumentException("unexpected host: " + str);
                }
                throw new NullPointerException("host == null");
            }
            return (a) invokeL.objValue;
        }

        public final boolean f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? str.equals(".") || str.equalsIgnoreCase("%2e") : invokeL.booleanValue;
        }

        public final boolean g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e") : invokeL.booleanValue;
        }

        public a h(@Nullable s sVar, String str) {
            InterceptResult invokeLL;
            int r;
            int n;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sVar, str)) == null) {
                int D = c.d.b.e0.e.D(str, 0, str.length());
                int E = c.d.b.e0.e.E(str, D, str.length());
                if (r(str, D, E) != -1) {
                    if (str.regionMatches(true, D, UrlSchemaHelper.SCHEMA_TYPE_HTTPS, 0, 6)) {
                        this.f32033a = "https";
                        D += 6;
                    } else if (str.regionMatches(true, D, UrlSchemaHelper.SCHEMA_TYPE_HTTP, 0, 5)) {
                        this.f32033a = "http";
                        D += 5;
                    } else {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, r) + "'");
                    }
                } else if (sVar != null) {
                    this.f32033a = sVar.f32025a;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                int s = s(str, D, E);
                char c2 = '?';
                char c3 = '#';
                if (s < 2 && sVar != null && sVar.f32025a.equals(this.f32033a)) {
                    this.f32034b = sVar.j();
                    this.f32035c = sVar.f();
                    this.f32036d = sVar.f32028d;
                    this.f32037e = sVar.f32029e;
                    this.f32038f.clear();
                    this.f32038f.addAll(sVar.h());
                    if (D == E || str.charAt(D) == '#') {
                        d(sVar.i());
                    }
                } else {
                    int i3 = D + s;
                    boolean z = false;
                    boolean z2 = false;
                    while (true) {
                        n = c.d.b.e0.e.n(str, i3, E, "@/\\?#");
                        char charAt = n != E ? str.charAt(n) : (char) 65535;
                        if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                            break;
                        }
                        if (charAt == '@') {
                            if (!z) {
                                int m = c.d.b.e0.e.m(str, i3, n, ':');
                                i2 = n;
                                String a2 = s.a(str, i3, m, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                if (z2) {
                                    a2 = this.f32034b + "%40" + a2;
                                }
                                this.f32034b = a2;
                                if (m != i2) {
                                    this.f32035c = s.a(str, m + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i2 = n;
                                this.f32035c += "%40" + s.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            }
                            i3 = i2 + 1;
                        }
                        c2 = '?';
                        c3 = '#';
                    }
                    int m2 = m(str, i3, n);
                    int i4 = m2 + 1;
                    if (i4 < n) {
                        this.f32036d = b(str, i3, m2);
                        int i5 = i(str, i4, n);
                        this.f32037e = i5;
                        if (i5 == -1) {
                            throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i4, n) + '\"');
                        }
                    } else {
                        this.f32036d = b(str, i3, m2);
                        this.f32037e = s.d(this.f32033a);
                    }
                    if (this.f32036d == null) {
                        throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i3, m2) + '\"');
                    }
                    D = n;
                }
                int n2 = c.d.b.e0.e.n(str, D, E, "?#");
                p(str, D, n2);
                if (n2 < E && str.charAt(n2) == '?') {
                    int m3 = c.d.b.e0.e.m(str, n2, E, '#');
                    this.f32039g = s.y(s.a(str, n2 + 1, m3, " \"'<>#", true, false, true, true, null));
                    n2 = m3;
                }
                if (n2 < E && str.charAt(n2) == '#') {
                    this.f32040h = s.a(str, 1 + n2, E, "", true, false, false, false, null);
                }
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                if (str != null) {
                    this.f32035c = s.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                    return this;
                }
                throw new NullPointerException("password == null");
            }
            return (a) invokeL.objValue;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                List<String> list = this.f32038f;
                if (list.remove(list.size() - 1).isEmpty() && !this.f32038f.isEmpty()) {
                    List<String> list2 = this.f32038f;
                    list2.set(list2.size() - 1, "");
                    return;
                }
                this.f32038f.add("");
            }
        }

        public a l(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                if (i2 > 0 && i2 <= 65535) {
                    this.f32037e = i2;
                    return this;
                }
                throw new IllegalArgumentException("unexpected port: " + i2);
            }
            return (a) invokeI.objValue;
        }

        public final void n(String str, int i2, int i3, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                String a2 = s.a(str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, true, null);
                if (f(a2)) {
                    return;
                }
                if (g(a2)) {
                    k();
                    return;
                }
                List<String> list = this.f32038f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f32038f;
                    list2.set(list2.size() - 1, a2);
                } else {
                    this.f32038f.add(a2);
                }
                if (z) {
                    this.f32038f.add("");
                }
            }
        }

        public a o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                int size = this.f32038f.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f32038f.set(i2, s.b(this.f32038f.get(i2), "[]", true, true, false, true));
                }
                List<String> list = this.f32039g;
                if (list != null) {
                    int size2 = list.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        String str = this.f32039g.get(i3);
                        if (str != null) {
                            this.f32039g.set(i3, s.b(str, "\\^`{|}", true, true, true, true));
                        }
                    }
                }
                String str2 = this.f32040h;
                if (str2 != null) {
                    this.f32040h = s.b(str2, " \"#<>\\^`{|}", true, true, false, false);
                }
                return this;
            }
            return (a) invokeV.objValue;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0048 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0045 -> B:13:0x002d). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void p(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = c.d.b.s.a.$ic
                if (r0 != 0) goto L49
            L4:
                if (r12 != r13) goto L7
                return
            L7:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L22
                r1 = 92
                if (r0 != r1) goto L17
                goto L22
            L17:
                java.util.List<java.lang.String> r0 = r10.f32038f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L2d
            L22:
                java.util.List<java.lang.String> r0 = r10.f32038f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f32038f
                r0.add(r2)
                goto L45
            L2d:
                r6 = r12
                if (r6 >= r13) goto L48
                java.lang.String r12 = "/\\"
                int r12 = c.d.b.e0.e.n(r11, r6, r13, r12)
                if (r12 >= r13) goto L3a
                r0 = 1
                goto L3b
            L3a:
                r0 = 0
            L3b:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.n(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L2d
            L45:
                int r12 = r12 + 1
                goto L2d
            L48:
                return
            L49:
                r8 = r0
                r9 = 1048588(0x10000c, float:1.469385E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r8.invokeLII(r9, r10, r11, r12, r13)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c.d.b.s.a.p(java.lang.String, int, int):void");
        }

        public a q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                if (str != null) {
                    if (str.equalsIgnoreCase("http")) {
                        this.f32033a = "http";
                    } else if (str.equalsIgnoreCase("https")) {
                        this.f32033a = "https";
                    } else {
                        throw new IllegalArgumentException("unexpected scheme: " + str);
                    }
                    return this;
                }
                throw new NullPointerException("scheme == null");
            }
            return (a) invokeL.objValue;
        }

        public a t(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                if (str != null) {
                    this.f32034b = s.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                    return this;
                }
                throw new NullPointerException("username == null");
            }
            return (a) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                StringBuilder sb = new StringBuilder();
                String str = this.f32033a;
                if (str != null) {
                    sb.append(str);
                    sb.append("://");
                } else {
                    sb.append("//");
                }
                if (!this.f32034b.isEmpty() || !this.f32035c.isEmpty()) {
                    sb.append(this.f32034b);
                    if (!this.f32035c.isEmpty()) {
                        sb.append(':');
                        sb.append(this.f32035c);
                    }
                    sb.append('@');
                }
                String str2 = this.f32036d;
                if (str2 != null) {
                    if (str2.indexOf(58) != -1) {
                        sb.append('[');
                        sb.append(this.f32036d);
                        sb.append(']');
                    } else {
                        sb.append(this.f32036d);
                    }
                }
                if (this.f32037e != -1 || this.f32033a != null) {
                    int c2 = c();
                    String str3 = this.f32033a;
                    if (str3 == null || c2 != s.d(str3)) {
                        sb.append(':');
                        sb.append(c2);
                    }
                }
                s.q(sb, this.f32038f);
                if (this.f32039g != null) {
                    sb.append('?');
                    s.n(sb, this.f32039g);
                }
                if (this.f32040h != null) {
                    sb.append('#');
                    sb.append(this.f32040h);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1810732744, "Lc/d/b/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1810732744, "Lc/d/b/s;");
                return;
            }
        }
        f32024i = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public s(a aVar) {
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
        this.f32025a = aVar.f32033a;
        this.f32026b = s(aVar.f32034b, false);
        this.f32027c = s(aVar.f32035c, false);
        this.f32028d = aVar.f32036d;
        this.f32029e = aVar.c();
        t(aVar.f32038f, false);
        List<String> list = aVar.f32039g;
        this.f32030f = list != null ? t(list, true) : null;
        String str = aVar.f32040h;
        this.f32031g = str != null ? s(str, false) : null;
        this.f32032h = aVar.toString();
    }

    public static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), charset})) == null) {
            int i4 = i2;
            while (i4 < i3) {
                int codePointAt = str.codePointAt(i4);
                if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                    if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || v(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                        i4 += Character.charCount(codePointAt);
                    }
                }
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i2, i4);
                c(buffer, str, i4, i3, str2, z, z2, z3, z4, charset);
                return buffer.readUtf8();
            }
            return str.substring(i2, i3);
        }
        return (String) invokeCommon.objValue;
    }

    public static String b(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) ? a(str, 0, str.length(), str2, z, z2, z3, z4, null) : (String) invokeCommon.objValue;
    }

    public static void c(Buffer buffer, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{buffer, str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), charset}) == null) {
            Buffer buffer2 = null;
            while (i2 < i3) {
                int codePointAt = str.codePointAt(i2);
                if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                    if (codePointAt == 43 && z3) {
                        buffer.writeUtf8(z ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                    } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || v(str, i2, i3)))))) {
                        buffer.writeUtf8CodePoint(codePointAt);
                    } else {
                        if (buffer2 == null) {
                            buffer2 = new Buffer();
                        }
                        if (charset != null && !charset.equals(c.d.b.e0.e.f31655d)) {
                            buffer2.writeString(str, i2, Character.charCount(codePointAt) + i2, charset);
                        } else {
                            buffer2.writeUtf8CodePoint(codePointAt);
                        }
                        while (!buffer2.exhausted()) {
                            int readByte = buffer2.readByte() & 255;
                            buffer.writeByte(37);
                            buffer.writeByte((int) f32024i[(readByte >> 4) & 15]);
                            buffer.writeByte((int) f32024i[readByte & 15]);
                        }
                    }
                }
                i2 += Character.charCount(codePointAt);
            }
        }
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (str.equals("http")) {
                return 80;
            }
            if (str.equals("https")) {
                return Constants.SOCKET_PORT_SSL;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static s k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            a aVar = new a();
            aVar.h(null, str);
            return aVar.a();
        }
        return (s) invokeL.objValue;
    }

    public static void n(StringBuilder sb, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, sb, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                String str = list.get(i2);
                String str2 = list.get(i2 + 1);
                if (i2 > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append(com.alipay.sdk.encrypt.a.f35879h);
                    sb.append(str2);
                }
            }
        }
    }

    public static void q(StringBuilder sb, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, sb, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append('/');
                sb.append(list.get(i2));
            }
        }
    }

    public static String r(String str, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            for (int i4 = i2; i4 < i3; i4++) {
                char charAt = str.charAt(i4);
                if (charAt == '%' || (charAt == '+' && z)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i2, i4);
                    u(buffer, str, i4, i3, z);
                    return buffer.readUtf8();
                }
            }
            return str.substring(i2, i3);
        }
        return (String) invokeCommon.objValue;
    }

    public static String s(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, str, z)) == null) ? r(str, 0, str.length(), z) : (String) invokeLZ.objValue;
    }

    public static void u(Buffer buffer, String str, int i2, int i3, boolean z) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{buffer, str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            while (i2 < i3) {
                int codePointAt = str.codePointAt(i2);
                if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                    int j2 = c.d.b.e0.e.j(str.charAt(i2 + 1));
                    int j3 = c.d.b.e0.e.j(str.charAt(i4));
                    if (j2 != -1 && j3 != -1) {
                        buffer.writeByte((j2 << 4) + j3);
                        i2 = i4;
                    }
                    buffer.writeUtf8CodePoint(codePointAt);
                } else {
                    if (codePointAt == 43 && z) {
                        buffer.writeByte(32);
                    }
                    buffer.writeUtf8CodePoint(codePointAt);
                }
                i2 += Character.charCount(codePointAt);
            }
        }
    }

    public static boolean v(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65548, null, str, i2, i3)) == null) {
            int i4 = i2 + 2;
            return i4 < i3 && str.charAt(i2) == '%' && c.d.b.e0.e.j(str.charAt(i2 + 1)) != -1 && c.d.b.e0.e.j(str.charAt(i4)) != -1;
        }
        return invokeLII.booleanValue;
    }

    public static List<String> y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 <= str.length()) {
                int indexOf = str.indexOf(38, i2);
                if (indexOf == -1) {
                    indexOf = str.length();
                }
                int indexOf2 = str.indexOf(61, i2);
                if (indexOf2 != -1 && indexOf2 <= indexOf) {
                    arrayList.add(str.substring(i2, indexOf2));
                    arrayList.add(str.substring(indexOf2 + 1, indexOf));
                } else {
                    arrayList.add(str.substring(i2, indexOf));
                    arrayList.add(null);
                }
                i2 = indexOf + 1;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public s A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            a p = p(str);
            if (p != null) {
                return p.a();
            }
            return null;
        }
        return (s) invokeL.objValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32025a : (String) invokeV.objValue;
    }

    public URI C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a o = o();
            o.o();
            String aVar = o.toString();
            try {
                return new URI(aVar);
            } catch (URISyntaxException e2) {
                try {
                    return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
                } catch (Exception unused) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return (URI) invokeV.objValue;
    }

    public URL D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                return new URL(this.f32032h);
            } catch (MalformedURLException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (URL) invokeV.objValue;
    }

    @Nullable
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f32031g == null) {
                return null;
            }
            return this.f32032h.substring(this.f32032h.indexOf(35) + 1);
        }
        return (String) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? (obj instanceof s) && ((s) obj).f32032h.equals(this.f32032h) : invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f32027c.isEmpty()) {
                return "";
            }
            return this.f32032h.substring(this.f32032h.indexOf(58, this.f32025a.length() + 3) + 1, this.f32032h.indexOf(64));
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int indexOf = this.f32032h.indexOf(47, this.f32025a.length() + 3);
            String str = this.f32032h;
            return this.f32032h.substring(indexOf, c.d.b.e0.e.n(str, indexOf, str.length(), "?#"));
        }
        return (String) invokeV.objValue;
    }

    public List<String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int indexOf = this.f32032h.indexOf(47, this.f32025a.length() + 3);
            String str = this.f32032h;
            int n = c.d.b.e0.e.n(str, indexOf, str.length(), "?#");
            ArrayList arrayList = new ArrayList();
            while (indexOf < n) {
                int i2 = indexOf + 1;
                int m = c.d.b.e0.e.m(this.f32032h, i2, n, '/');
                arrayList.add(this.f32032h.substring(i2, m));
                indexOf = m;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32032h.hashCode() : invokeV.intValue;
    }

    @Nullable
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f32030f == null) {
                return null;
            }
            int indexOf = this.f32032h.indexOf(63) + 1;
            String str = this.f32032h;
            return this.f32032h.substring(indexOf, c.d.b.e0.e.m(str, indexOf, str.length(), '#'));
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f32026b.isEmpty()) {
                return "";
            }
            int length = this.f32025a.length() + 3;
            String str = this.f32032h;
            return this.f32032h.substring(length, c.d.b.e0.e.n(str, length, str.length(), ":@"));
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f32028d : (String) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f32025a.equals("https") : invokeV.booleanValue;
    }

    public a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            a aVar = new a();
            aVar.f32033a = this.f32025a;
            aVar.f32034b = j();
            aVar.f32035c = f();
            aVar.f32036d = this.f32028d;
            aVar.f32037e = this.f32029e != d(this.f32025a) ? this.f32029e : -1;
            aVar.f32038f.clear();
            aVar.f32038f.addAll(h());
            aVar.d(i());
            aVar.f32040h = e();
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    @Nullable
    public a p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            try {
                a aVar = new a();
                aVar.h(this, str);
                return aVar;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public final List<String> t(List<String> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, list, z)) == null) {
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                String str = list.get(i2);
                arrayList.add(str != null ? s(str, z) : null);
            }
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeLZ.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f32032h : (String) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f32029e : invokeV.intValue;
    }

    @Nullable
    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f32030f == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            n(sb, this.f32030f);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            a p = p("/...");
            p.t("");
            p.j("");
            return p.a().toString();
        }
        return (String) invokeV.objValue;
    }
}
