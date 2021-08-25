package c.d.b.e0.i;

import androidx.core.view.InputDeviceCompat;
import c.d.b.b0;
import c.d.b.m;
import c.d.b.r;
import c.d.b.s;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import okio.ByteString;
import org.apache.http.message.BasicHeaderValueFormatter;
/* loaded from: classes4.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1090464272, "Lc/d/b/e0/i/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1090464272, "Lc/d/b/e0/i/e;");
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, b0Var)) == null) ? a(b0Var.v()) : invokeL.longValue;
    }

    public static boolean c(b0 b0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, b0Var)) == null) {
            if (b0Var.D().f().equals("HEAD")) {
                return false;
            }
            int code = b0Var.code();
            return (((code >= 100 && code < 200) || code == 204 || code == 304) && b(b0Var) == -1 && !"chunked".equalsIgnoreCase(b0Var.s("Transfer-Encoding"))) ? false : true;
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
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, mVar, sVar, rVar) == null) || mVar == m.f32008a) {
            return;
        }
        List<c.d.b.l> f2 = c.d.b.l.f(sVar, rVar);
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
}
