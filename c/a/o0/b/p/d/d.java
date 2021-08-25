package c.a.o0.b.p.d;

import android.text.TextUtils;
import c.a.o0.a.j2.p.f;
import c.a.o0.a.k;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10213a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-906150922, "Lc/a/o0/b/p/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-906150922, "Lc/a/o0/b/p/d/d;");
                return;
            }
        }
        f10213a = k.f7049a;
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, str5) == null) {
            f fVar = new f();
            fVar.f7035a = "swan";
            fVar.f7036b = str;
            fVar.f7041g = str2;
            if (TextUtils.equals(str, PrefetchEvent.STATE_CLICK)) {
                fVar.f7039e = str3;
            }
            fVar.f7040f = str5;
            fVar.a("source", str4);
            if (f10213a) {
                String str6 = "staticLoginResult: event = " + fVar.f();
            }
            c.a.o0.a.j2.k.u("1372", fVar);
        }
    }
}
