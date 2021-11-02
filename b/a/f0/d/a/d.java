package b.a.f0.d.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f2889a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2890b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2891c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-85295730, "Lb/a/f0/d/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-85295730, "Lb/a/f0/d/a/d;");
                return;
            }
        }
        int max = Math.max(200, b.a.f0.a.b.a.f2781a.get().t());
        f2889a = max;
        f2890b = max;
        f2891c = max;
        String str = "static initializer: " + f2889a + " " + f2890b;
    }
}
