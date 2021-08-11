package c.a.n0.a.l0;

import androidx.annotation.NonNull;
import c.a.n0.a.k;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6913a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1215728235, "Lc/a/n0/a/l0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1215728235, "Lc/a/n0/a/l0/f;");
                return;
            }
        }
        f6913a = k.f6803a;
    }

    public static a a(g gVar, c.a.n0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, gVar, bVar, v8ThreadDelegatePolicy)) == null) {
            h b2 = b(gVar);
            a b3 = b2.b(gVar.a(), bVar, v8ThreadDelegatePolicy);
            b3.I0(b2.a());
            return b3;
        }
        return (a) invokeLLL.objValue;
    }

    @NonNull
    public static h b(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gVar)) == null) {
            int b2 = gVar.b();
            if (b2 != 1) {
                if (b2 != 2) {
                    if (b2 != 3) {
                        if (!f6913a) {
                            return new c.a.n0.a.m0.a();
                        }
                        throw new IllegalArgumentException("invalid model object:" + gVar);
                    }
                    return new c.a.n0.a.h0.k.e();
                }
                return c.a.n0.a.c1.b.b();
            }
            return new c.a.n0.a.m0.a();
        }
        return (h) invokeL.objValue;
    }

    public static a c(g gVar, c.a.n0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, gVar, bVar, v8ThreadDelegatePolicy)) == null) {
            a a2 = a(gVar, bVar, v8ThreadDelegatePolicy);
            a2.q0();
            return a2;
        }
        return (a) invokeLLL.objValue;
    }
}
