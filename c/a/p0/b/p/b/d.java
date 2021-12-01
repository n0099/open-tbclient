package c.a.p0.b.p.b;

import android.text.TextUtils;
import c.a.p0.a.k;
import c.a.p0.a.n2.n;
import c.a.p0.a.n2.s.f;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1591805433, "Lc/a/p0/b/p/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1591805433, "Lc/a/p0/b/p/b/d;");
                return;
            }
        }
        a = k.a;
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, str5) == null) {
            f fVar = new f();
            fVar.a = "swan";
            fVar.f7113b = str;
            fVar.f7118g = str2;
            if (TextUtils.equals(str, "click")) {
                fVar.f7116e = str3;
            }
            fVar.f7117f = str5;
            fVar.a("source", str4);
            if (a) {
                String str6 = "staticLoginResult: event = " + fVar.f();
            }
            n.x("1372", fVar);
        }
    }
}
