package c.a.f0.d.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f3449a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3450b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3451c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-378698737, "Lc/a/f0/d/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-378698737, "Lc/a/f0/d/a/d;");
                return;
            }
        }
        int max = Math.max(200, c.a.f0.a.b.a.f3338a.get().u());
        f3449a = max;
        f3450b = max;
        f3451c = max;
        String str = "static initializer: " + f3449a + " " + f3450b;
    }
}
