package b.c.b.e0.i;

import androidx.core.view.InputDeviceCompat;
import b.c.b.b0;
import b.c.b.m;
import b.c.b.r;
import b.c.b.s;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okio.ByteString;
import org.apache.http.message.BasicHeaderValueFormatter;
/* loaded from: classes6.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(999890094, "Lb/c/b/e0/i/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(999890094, "Lb/c/b/e0/i/e;");
                return;
            }
        }
        ByteString.encodeUtf8(BasicHeaderValueFormatter.UNSAFE_CHARS);
        ByteString.encodeUtf8("\t ,=");
    }

    public static long a(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rVar)) == null) ? h(rVar.c("Content-Length")) : invokeL.longValue;
    }

    public static long b(b0 b0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, b0Var)) == null) ? a(b0Var.j()) : invokeL.longValue;
    }

    public static boolean c(b0 b0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, b0Var)) == null) {
            if (b0Var.r().f().equals("HEAD")) {
                return false;
            }
            int code = b0Var.code();
            return (((code >= 100 && code < 200) || code == 204 || code == 304) && b(b0Var) == -1 && !"chunked".equalsIgnoreCase(b0Var.g("Transfer-Encoding"))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static int d(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public static void e(m mVar, s sVar, r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, mVar, sVar, rVar) == null) || mVar == m.f31399a) {
            return;
        }
        List<b.c.b.l> f2 = b.c.b.l.f(sVar, rVar);
        if (f2.isEmpty()) {
            return;
        }
        mVar.b(sVar, f2);
    }

    public static int f(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(AdIconUtil.BAIDU_LOGO_ID, null, str, i2, str2)) == null) {
            while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
                i2++;
            }
            return i2;
        }
        return invokeLIL.intValue;
    }

    public static int g(String str, int i2) {
        char charAt;
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i2)) == null) {
            while (i2 < str.length() && ((charAt = str.charAt(i2)) == ' ' || charAt == '\t')) {
                i2++;
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public static long h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str == null) {
                return -1L;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static Set<String> i(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, rVar)) == null) {
            Set<String> emptySet = Collections.emptySet();
            int g2 = rVar.g();
            for (int i2 = 0; i2 < g2; i2++) {
                if ("Vary".equalsIgnoreCase(rVar.e(i2))) {
                    String h2 = rVar.h(i2);
                    if (emptySet.isEmpty()) {
                        emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                    }
                    for (String str : h2.split(",")) {
                        emptySet.add(str.trim());
                    }
                }
            }
            return emptySet;
        }
        return (Set) invokeL.objValue;
    }

    public static r j(r rVar, r rVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, rVar, rVar2)) == null) {
            Set<String> i2 = i(rVar2);
            if (i2.isEmpty()) {
                return new r.a().d();
            }
            r.a aVar = new r.a();
            int g2 = rVar.g();
            for (int i3 = 0; i3 < g2; i3++) {
                String e2 = rVar.e(i3);
                if (i2.contains(e2)) {
                    aVar.a(e2, rVar.h(i3));
                }
            }
            return aVar.d();
        }
        return (r) invokeLL.objValue;
    }

    public static r k(b0 b0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, b0Var)) == null) ? j(b0Var.m().r().d(), b0Var.j()) : (r) invokeL.objValue;
    }
}
