package b.a.p0.a.o0.d;

import b.a.p0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7436a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f7437b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-780095363, "Lb/a/p0/a/o0/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-780095363, "Lb/a/p0/a/o0/d/a;");
                return;
            }
        }
        f7436a = k.f6863a;
        b.a.p0.a.c1.a.g0().getSwitch("swan_js_event_dispatch_opt", 0);
        f7437b = false;
        if (f7436a) {
            String str = "swan_js_event_dispatch_opt - " + f7437b;
        }
    }
}
