package b.r.a.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a */
    public static final b f33694a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1855531385, "Lb/r/a/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1855531385, "Lb/r/a/a/f;");
                return;
            }
        }
        f33694a = new b(null);
    }

    /* JADX DEBUG: Method not inlined, still used in: [b.r.a.a.b.b():b.r.a.a.b] */
    public static /* synthetic */ b a() {
        return f33694a;
    }
}
