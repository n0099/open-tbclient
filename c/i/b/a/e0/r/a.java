package c.i.b.a.e0.r;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.l;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f33578c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final l f33579a;

    /* renamed from: b  reason: collision with root package name */
    public final StringBuilder f33580b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1190044254, "Lc/i/b/a/e0/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1190044254, "Lc/i/b/a/e0/r/a;");
                return;
            }
        }
        f33578c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33579a = new l();
        this.f33580b = new StringBuilder();
    }

    public static boolean b(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, lVar)) != null) {
            return invokeL.booleanValue;
        }
        int c2 = lVar.c();
        int d2 = lVar.d();
        byte[] bArr = lVar.f33812a;
        if (c2 + 2 > d2) {
            return false;
        }
        int i2 = c2 + 1;
        if (bArr[c2] != 47) {
            return false;
        }
        int i3 = i2 + 1;
        if (bArr[i2] != 42) {
            return false;
        }
        while (true) {
            int i4 = i3 + 1;
            if (i4 < d2) {
                if (((char) bArr[i3]) == '*' && ((char) bArr[i4]) == '/') {
                    i3 = i4 + 1;
                    d2 = i3;
                } else {
                    i3 = i4;
                }
            } else {
                lVar.K(d2 - lVar.c());
                return true;
            }
        }
    }

    public static boolean c(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lVar)) == null) {
            char j2 = j(lVar, lVar.c());
            if (j2 == '\t' || j2 == '\n' || j2 == '\f' || j2 == '\r' || j2 == ' ') {
                lVar.K(1);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String e(l lVar, StringBuilder sb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, lVar, sb)) == null) {
            boolean z = false;
            sb.setLength(0);
            int c2 = lVar.c();
            int d2 = lVar.d();
            while (c2 < d2 && !z) {
                char c3 = (char) lVar.f33812a[c2];
                if ((c3 < 'A' || c3 > 'Z') && ((c3 < 'a' || c3 > 'z') && !((c3 >= '0' && c3 <= '9') || c3 == '#' || c3 == '-' || c3 == '.' || c3 == '_'))) {
                    z = true;
                } else {
                    c2++;
                    sb.append(c3);
                }
            }
            lVar.K(c2 - lVar.c());
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String f(l lVar, StringBuilder sb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, lVar, sb)) == null) {
            m(lVar);
            if (lVar.a() == 0) {
                return null;
            }
            String e2 = e(lVar, sb);
            if ("".equals(e2)) {
                return "" + ((char) lVar.x());
            }
            return e2;
        }
        return (String) invokeLL.objValue;
    }

    public static String g(l lVar, StringBuilder sb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, lVar, sb)) == null) {
            StringBuilder sb2 = new StringBuilder();
            boolean z = false;
            while (!z) {
                int c2 = lVar.c();
                String f2 = f(lVar, sb);
                if (f2 == null) {
                    return null;
                }
                if (!"}".equals(f2) && !";".equals(f2)) {
                    sb2.append(f2);
                } else {
                    lVar.J(c2);
                    z = true;
                }
            }
            return sb2.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String h(l lVar, StringBuilder sb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, lVar, sb)) == null) {
            m(lVar);
            if (lVar.a() >= 5 && "::cue".equals(lVar.u(5))) {
                int c2 = lVar.c();
                String f2 = f(lVar, sb);
                if (f2 == null) {
                    return null;
                }
                if (StringUtil.ARRAY_START.equals(f2)) {
                    lVar.J(c2);
                    return "";
                }
                String k = "(".equals(f2) ? k(lVar) : null;
                String f3 = f(lVar, sb);
                if (!SmallTailInfo.EMOTION_SUFFIX.equals(f3) || f3 == null) {
                    return null;
                }
                return k;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void i(l lVar, d dVar, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, lVar, dVar, sb) == null) {
            m(lVar);
            String e2 = e(lVar, sb);
            if (!"".equals(e2) && ":".equals(f(lVar, sb))) {
                m(lVar);
                String g2 = g(lVar, sb);
                if (g2 == null || "".equals(g2)) {
                    return;
                }
                int c2 = lVar.c();
                String f2 = f(lVar, sb);
                if (!";".equals(f2)) {
                    if (!"}".equals(f2)) {
                        return;
                    }
                    lVar.J(c2);
                }
                if ("color".equals(e2)) {
                    dVar.p(c.i.b.a.i0.d.c(g2));
                } else if ("background-color".equals(e2)) {
                    dVar.n(c.i.b.a.i0.d.c(g2));
                } else if ("text-decoration".equals(e2)) {
                    if ("underline".equals(g2)) {
                        dVar.w(true);
                    }
                } else if ("font-family".equals(e2)) {
                    dVar.q(g2);
                } else if ("font-weight".equals(e2)) {
                    if ("bold".equals(g2)) {
                        dVar.o(true);
                    }
                } else if ("font-style".equals(e2) && "italic".equals(g2)) {
                    dVar.r(true);
                }
            }
        }
    }

    public static char j(l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, lVar, i2)) == null) ? (char) lVar.f33812a[i2] : invokeLI.charValue;
    }

    public static String k(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, lVar)) == null) {
            int c2 = lVar.c();
            int d2 = lVar.d();
            boolean z = false;
            while (c2 < d2 && !z) {
                int i2 = c2 + 1;
                z = ((char) lVar.f33812a[c2]) == ')';
                c2 = i2;
            }
            return lVar.u((c2 - 1) - lVar.c()).trim();
        }
        return (String) invokeL.objValue;
    }

    public static void l(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, lVar) == null) {
            do {
            } while (!TextUtils.isEmpty(lVar.k()));
        }
    }

    public static void m(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, lVar) == null) {
            while (true) {
                for (boolean z = true; lVar.a() > 0 && z; z = false) {
                    if (!c(lVar) && !b(lVar)) {
                    }
                }
                return;
            }
        }
    }

    public final void a(d dVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, dVar, str) == null) || "".equals(str)) {
            return;
        }
        int indexOf = str.indexOf(91);
        if (indexOf != -1) {
            Matcher matcher = f33578c.matcher(str.substring(indexOf));
            if (matcher.matches()) {
                dVar.v(matcher.group(1));
            }
            str = str.substring(0, indexOf);
        }
        String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        String str2 = split[0];
        int indexOf2 = str2.indexOf(35);
        if (indexOf2 != -1) {
            dVar.u(str2.substring(0, indexOf2));
            dVar.t(str2.substring(indexOf2 + 1));
        } else {
            dVar.u(str2);
        }
        if (split.length > 1) {
            dVar.s((String[]) Arrays.copyOfRange(split, 1, split.length));
        }
    }

    public d d(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar)) == null) {
            this.f33580b.setLength(0);
            int c2 = lVar.c();
            l(lVar);
            this.f33579a.H(lVar.f33812a, lVar.c());
            this.f33579a.J(c2);
            String h2 = h(this.f33579a, this.f33580b);
            if (h2 == null || !StringUtil.ARRAY_START.equals(f(this.f33579a, this.f33580b))) {
                return null;
            }
            d dVar = new d();
            a(dVar, h2);
            String str = null;
            boolean z = false;
            while (!z) {
                int c3 = this.f33579a.c();
                str = f(this.f33579a, this.f33580b);
                boolean z2 = str == null || "}".equals(str);
                if (!z2) {
                    this.f33579a.J(c3);
                    i(this.f33579a, dVar, this.f33580b);
                }
                z = z2;
            }
            if ("}".equals(str)) {
                return dVar;
            }
            return null;
        }
        return (d) invokeL.objValue;
    }
}
