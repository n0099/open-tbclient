package c.i.b.a.e0.r;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.e0.r.e;
import c.i.b.a.i0.l;
import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f33388b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f33389c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final StringBuilder f33390a;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final String[] f33391e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f33392a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33393b;

        /* renamed from: c  reason: collision with root package name */
        public final String f33394c;

        /* renamed from: d  reason: collision with root package name */
        public final String[] f33395d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1171097440, "Lc/i/b/a/e0/r/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1171097440, "Lc/i/b/a/e0/r/f$a;");
                    return;
                }
            }
            f33391e = new String[0];
        }

        public a(String str, int i2, String str2, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2, strArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f33393b = i2;
            this.f33392a = str;
            this.f33394c = str2;
            this.f33395d = strArr;
        }

        public static a a(String str, int i2) {
            InterceptResult invokeLI;
            String str2;
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
                String trim = str.trim();
                if (trim.isEmpty()) {
                    return null;
                }
                int indexOf = trim.indexOf(" ");
                if (indexOf == -1) {
                    str2 = "";
                } else {
                    String trim2 = trim.substring(indexOf).trim();
                    trim = trim.substring(0, indexOf);
                    str2 = trim2;
                }
                String[] split = trim.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String str3 = split[0];
                if (split.length > 1) {
                    strArr = (String[]) Arrays.copyOfRange(split, 1, split.length);
                } else {
                    strArr = f33391e;
                }
                return new a(str3, i2, str2, strArr);
            }
            return (a) invokeLI.objValue;
        }

        public static a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new a("", 0, "", new String[0]) : (a) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements Comparable<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f33396e;

        /* renamed from: f  reason: collision with root package name */
        public final d f33397f;

        public b(int i2, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33396e = i2;
            this.f33397f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) ? this.f33396e - bVar.f33396e : invokeL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1190044099, "Lc/i/b/a/e0/r/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1190044099, "Lc/i/b/a/e0/r/f;");
                return;
            }
        }
        f33388b = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
        f33389c = Pattern.compile("(\\S+?):(\\S+)");
    }

    public f() {
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
        this.f33390a = new StringBuilder();
    }

    public static void a(String str, SpannableStringBuilder spannableStringBuilder) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, spannableStringBuilder) == null) {
            int hashCode = str.hashCode();
            if (hashCode == 3309) {
                if (str.equals("gt")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode == 3464) {
                if (str.equals("lt")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != 96708) {
                if (hashCode == 3374865 && str.equals("nbsp")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else {
                if (str.equals("amp")) {
                    c2 = 3;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                spannableStringBuilder.append(Typography.less);
            } else if (c2 == 1) {
                spannableStringBuilder.append(Typography.greater);
            } else if (c2 == 2) {
                spannableStringBuilder.append(' ');
            } else if (c2 != 3) {
                String str2 = "ignoring unsupported entity: '&" + str + ";'";
            } else {
                spannableStringBuilder.append(Typography.amp);
            }
        }
    }

    public static void b(String str, a aVar, SpannableStringBuilder spannableStringBuilder, List<d> list, List<b> list2) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, str, aVar, spannableStringBuilder, list, list2) == null) {
            int i2 = aVar.f33393b;
            int length = spannableStringBuilder.length();
            String str2 = aVar.f33392a;
            int hashCode = str2.hashCode();
            if (hashCode == 0) {
                if (str2.equals("")) {
                    c2 = 6;
                }
                c2 = 65535;
            } else if (hashCode == 105) {
                if (str2.equals("i")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode == 3314158) {
                if (str2.equals("lang")) {
                    c2 = 4;
                }
                c2 = 65535;
            } else if (hashCode == 98) {
                if (str2.equals("b")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode == 99) {
                if (str2.equals("c")) {
                    c2 = 3;
                }
                c2 = 65535;
            } else if (hashCode != 117) {
                if (hashCode == 118 && str2.equals("v")) {
                    c2 = 5;
                }
                c2 = 65535;
            } else {
                if (str2.equals("u")) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            switch (c2) {
                case 0:
                    spannableStringBuilder.setSpan(new StyleSpan(1), i2, length, 33);
                    break;
                case 1:
                    spannableStringBuilder.setSpan(new StyleSpan(2), i2, length, 33);
                    break;
                case 2:
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    return;
            }
            list2.clear();
            e(list, str, aVar, list2);
            int size = list2.size();
            for (int i3 = 0; i3 < size; i3++) {
                c(spannableStringBuilder, list2.get(i3).f33397f, i2, length);
            }
        }
    }

    public static void c(SpannableStringBuilder spannableStringBuilder, d dVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, spannableStringBuilder, dVar, i2, i3) == null) || dVar == null) {
            return;
        }
        if (dVar.g() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(dVar.g()), i2, i3, 33);
        }
        if (dVar.k()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, i3, 33);
        }
        if (dVar.l()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
        }
        if (dVar.j()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(dVar.b()), i2, i3, 33);
        }
        if (dVar.i()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(dVar.a()), i2, i3, 33);
        }
        if (dVar.c() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(dVar.c()), i2, i3, 33);
        }
        if (dVar.h() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(dVar.h()), i2, i3, 33);
        }
        int e2 = dVar.e();
        if (e2 == 1) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) dVar.d(), true), i2, i3, 33);
        } else if (e2 == 2) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.d()), i2, i3, 33);
        } else if (e2 != 3) {
        } else {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.d() / 100.0f), i2, i3, 33);
        }
    }

    public static int d(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, str, i2)) == null) {
            int indexOf = str.indexOf(62, i2);
            return indexOf == -1 ? str.length() : indexOf + 1;
        }
        return invokeLI.intValue;
    }

    public static void e(List<d> list, String str, a aVar, List<b> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, list, str, aVar, list2) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                d dVar = list.get(i2);
                int f2 = dVar.f(str, aVar.f33392a, aVar.f33395d, aVar.f33394c);
                if (f2 > 0) {
                    list2.add(new b(f2, dVar));
                }
            }
            Collections.sort(list2);
        }
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return null;
            }
            return trim.split("[ \\.]")[0];
        }
        return (String) invokeL.objValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == 98) {
                if (str.equals("b")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode == 99) {
                if (str.equals("c")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode == 105) {
                if (str.equals("i")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode == 3314158) {
                if (str.equals("lang")) {
                    c2 = 3;
                }
                c2 = 65535;
            } else if (hashCode != 117) {
                if (hashCode == 118 && str.equals("v")) {
                    c2 = 5;
                }
                c2 = 65535;
            } else {
                if (str.equals("u")) {
                    c2 = 4;
                }
                c2 = 65535;
            }
            return c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3 || c2 == 4 || c2 == 5;
        }
        return invokeL.booleanValue;
    }

    public static boolean i(String str, Matcher matcher, l lVar, e.b bVar, StringBuilder sb, List<d> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, matcher, lVar, bVar, sb, list})) != null) {
            return invokeCommon.booleanValue;
        }
        try {
            bVar.j(h.c(matcher.group(1)));
            bVar.d(h.c(matcher.group(2)));
            j(matcher.group(3), bVar);
            sb.setLength(0);
            while (true) {
                String k = lVar.k();
                if (!TextUtils.isEmpty(k)) {
                    if (sb.length() > 0) {
                        sb.append(StringUtils.LF);
                    }
                    sb.append(k.trim());
                } else {
                    k(str, sb.toString(), bVar, list);
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            String str2 = "Skipping cue with bad header: " + matcher.group();
            return false;
        }
    }

    public static void j(String str, e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, bVar) == null) {
            Matcher matcher = f33389c.matcher(str);
            while (matcher.find()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                try {
                    if ("line".equals(group)) {
                        l(group2, bVar);
                    } else if ("align".equals(group)) {
                        bVar.l(o(group2));
                    } else if ("position".equals(group)) {
                        n(group2, bVar);
                    } else if ("size".equals(group)) {
                        bVar.m(h.b(group2));
                    } else {
                        String str2 = "Unknown cue setting " + group + ":" + group2;
                    }
                } catch (NumberFormatException unused) {
                    String str3 = "Skipping bad cue setting: " + matcher.group();
                }
            }
        }
    }

    public static void k(String str, String str2, e.b bVar, List<d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65547, null, str, str2, bVar, list) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Stack stack = new Stack();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < str2.length()) {
                char charAt = str2.charAt(i2);
                if (charAt == '&') {
                    i2++;
                    int indexOf = str2.indexOf(59, i2);
                    int indexOf2 = str2.indexOf(32, i2);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf != -1) {
                        a(str2.substring(i2, indexOf), spannableStringBuilder);
                        if (indexOf == indexOf2) {
                            spannableStringBuilder.append(" ");
                        }
                        i2 = indexOf + 1;
                    } else {
                        spannableStringBuilder.append(charAt);
                    }
                } else if (charAt != '<') {
                    spannableStringBuilder.append(charAt);
                    i2++;
                } else {
                    int i3 = i2 + 1;
                    if (i3 < str2.length()) {
                        boolean z = str2.charAt(i3) == '/';
                        i3 = d(str2, i3);
                        int i4 = i3 - 2;
                        boolean z2 = str2.charAt(i4) == '/';
                        int i5 = i2 + (z ? 2 : 1);
                        if (!z2) {
                            i4 = i3 - 1;
                        }
                        String substring = str2.substring(i5, i4);
                        String f2 = f(substring);
                        if (f2 != null && g(f2)) {
                            if (z) {
                                while (!stack.isEmpty()) {
                                    a aVar = (a) stack.pop();
                                    b(str, aVar, spannableStringBuilder, list, arrayList);
                                    if (aVar.f33392a.equals(f2)) {
                                        break;
                                    }
                                }
                            } else if (!z2) {
                                stack.push(a.a(substring, spannableStringBuilder.length()));
                            }
                        }
                    }
                    i2 = i3;
                }
            }
            while (!stack.isEmpty()) {
                b(str, (a) stack.pop(), spannableStringBuilder, list, arrayList);
            }
            b(str, a.b(), spannableStringBuilder, list, arrayList);
            bVar.k(spannableStringBuilder);
        }
    }

    public static void l(String str, e.b bVar) throws NumberFormatException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, bVar) == null) {
            int indexOf = str.indexOf(44);
            if (indexOf != -1) {
                bVar.f(m(str.substring(indexOf + 1)));
                str = str.substring(0, indexOf);
            } else {
                bVar.f(Integer.MIN_VALUE);
            }
            if (str.endsWith("%")) {
                bVar.e(h.b(str));
                bVar.g(0);
                return;
            }
            int parseInt = Integer.parseInt(str);
            if (parseInt < 0) {
                parseInt--;
            }
            bVar.e(parseInt);
            bVar.g(1);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int m(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1074341483:
                    if (str.equals("middle")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100571:
                    if (str.equals("end")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 == 1 || c2 == 2) {
                    return 1;
                }
                if (c2 != 3) {
                    String str2 = "Invalid anchor value: " + str;
                    return Integer.MIN_VALUE;
                }
                return 2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void n(String str, e.b bVar) throws NumberFormatException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, bVar) == null) {
            int indexOf = str.indexOf(44);
            if (indexOf != -1) {
                bVar.i(m(str.substring(indexOf + 1)));
                str = str.substring(0, indexOf);
            } else {
                bVar.i(Integer.MIN_VALUE);
            }
            bVar.h(h.b(str));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Layout.Alignment o(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1074341483:
                    if (str.equals("middle")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100571:
                    if (str.equals("end")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 108511772:
                    if (str.equals(HorizontalTranslateLayout.RIGHT)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            if (c2 == 2 || c2 == 3) {
                return Layout.Alignment.ALIGN_CENTER;
            }
            if (c2 != 4 && c2 != 5) {
                String str2 = "Invalid alignment value: " + str;
                return null;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return (Layout.Alignment) invokeL.objValue;
    }

    public boolean h(l lVar, e.b bVar, List<d> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, lVar, bVar, list)) == null) {
            String k = lVar.k();
            if (k == null) {
                return false;
            }
            Matcher matcher = f33388b.matcher(k);
            if (matcher.matches()) {
                return i(null, matcher, lVar, bVar, this.f33390a, list);
            }
            String k2 = lVar.k();
            if (k2 == null) {
                return false;
            }
            Matcher matcher2 = f33388b.matcher(k2);
            if (matcher2.matches()) {
                return i(k.trim(), matcher2, lVar, bVar, this.f33390a, list);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
