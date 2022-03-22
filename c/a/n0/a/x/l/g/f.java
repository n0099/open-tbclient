package c.a.n0.a.x.l.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1451030676, "Lc/a/n0/a/x/l/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1451030676, "Lc/a/n0/a/x/l/g/f;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static boolean a(c.a.n0.a.x.f.a aVar, String str) {
        InterceptResult invokeLL;
        c.a.n0.a.t1.e a0;
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, aVar, str)) == null) {
            if (a) {
                Log.d("MasterIsolationHelper", "JS CALL - " + str);
            }
            boolean z = false;
            if (c.a.n0.a.n1.a.a.D()) {
                return false;
            }
            if (aVar != null && !TextUtils.isEmpty(aVar.getContainerId())) {
                if (c.a.n0.a.x.l.g.n.a.i().k(aVar.getContainerId())) {
                    return true;
                }
                if (!c.a.n0.a.x.o.e.a.h()) {
                    return false;
                }
                String containerId = aVar.getContainerId();
                if (!e.a(containerId) || (a0 = c.a.n0.a.t1.e.a0()) == null || !b(aVar) || (a2 = h.b().a()) == null) {
                    return false;
                }
                String h2 = a2.h();
                if (TextUtils.isEmpty(h2)) {
                    return false;
                }
                z = (TextUtils.equals(a2.i().c(), aVar.getContainerId()) && TextUtils.equals(h2, a0.f6344b)) ? true : true;
                if (a && z) {
                    Log.w("MasterIsolationHelper", "master id - " + containerId + ",can not call API - " + str + ", intercept for preload/prefetch");
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(c.a.n0.a.x.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) ? (aVar instanceof c.a.n0.a.b0.a) && ((c.a.n0.a.b0.a) aVar).getInvokeSourceType() == 0 : invokeL.booleanValue;
    }
}
