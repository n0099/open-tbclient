package c.r.a.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a */
    public static final b f35450a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2052044890, "Lc/r/a/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2052044890, "Lc/r/a/a/f;");
                return;
            }
        }
        f35450a = new b(null);
    }

    /* JADX DEBUG: Method not inlined, still used in: [c.r.a.a.b.b():c.r.a.a.b] */
    public static /* synthetic */ b a() {
        return f35450a;
    }
}
