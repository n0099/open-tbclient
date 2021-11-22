package b.a.q0.t.c;

import android.net.Uri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.dxmpay.wallet.core.Domains;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f14522a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f14523b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(806153918, "Lb/a/q0/t/c/c0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(806153918, "Lb/a/q0/t/c/c0;");
                return;
            }
        }
        f14522a = Arrays.asList(Domains.BAIDU, Domains.NUOMI, Domains.BAIFUBAO, ".hao123.com");
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (b.a.e.f.p.k.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (parse == null || !"file".equals(parse.getScheme()) || parse.getPath() == null || !parse.getPath().contains("bdtbNWCache")) {
                if (f14523b == null && (p = b.a.q0.s.e0.b.j().p("js_host_white_list", null)) != null) {
                    f14523b = b(p);
                }
                if (f14523b == null) {
                    f14523b = f14522a;
                }
                if (parse != null) {
                    String host = parse.getHost();
                    for (String str2 : f14523b) {
                        if (host.endsWith(str2)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static List<String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (b.a.e.f.p.k.isEmpty(str)) {
                return null;
            }
            return Arrays.asList(str.split(";"));
        }
        return (List) invokeL.objValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            if (str == null) {
                b.a.q0.s.e0.b.j().x("js_host_white_list", "");
            } else {
                b.a.q0.s.e0.b.j().x("js_host_white_list", str);
            }
            f14523b = b(str);
        }
    }
}
