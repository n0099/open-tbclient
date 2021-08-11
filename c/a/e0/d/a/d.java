package c.a.e0.d.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f3148a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3149b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3150c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1428755726, "Lc/a/e0/d/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1428755726, "Lc/a/e0/d/a/d;");
                return;
            }
        }
        int max = Math.max(200, c.a.e0.a.b.a.f3041a.get().t());
        f3148a = max;
        f3149b = max;
        f3150c = max;
        String str = "static initializer: " + f3148a + " " + f3149b;
    }
}
