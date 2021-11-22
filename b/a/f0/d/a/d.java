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
    public static final int f2982a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2983b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2984c;
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
        int max = Math.max(200, b.a.f0.a.b.a.f2874a.get().t());
        f2982a = max;
        f2983b = max;
        f2984c = max;
        String str = "static initializer: " + f2982a + " " + f2983b;
    }
}
