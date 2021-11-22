package b.a.p0.b.p.b;

import android.text.TextUtils;
import b.a.p0.a.k;
import b.a.p0.a.n2.n;
import b.a.p0.a.n2.s.f;
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
    public static final boolean f10045a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(84253624, "Lb/a/p0/b/p/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(84253624, "Lb/a/p0/b/p/b/d;");
                return;
            }
        }
        f10045a = k.f6863a;
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, str5) == null) {
            f fVar = new f();
            fVar.f7379a = "swan";
            fVar.f7380b = str;
            fVar.f7385g = str2;
            if (TextUtils.equals(str, PrefetchEvent.STATE_CLICK)) {
                fVar.f7383e = str3;
            }
            fVar.f7384f = str5;
            fVar.a("source", str4);
            if (f10045a) {
                String str6 = "staticLoginResult: event = " + fVar.f();
            }
            n.x("1372", fVar);
        }
    }
}
