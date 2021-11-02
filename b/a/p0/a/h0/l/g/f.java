package b.a.p0.a.h0.l.g;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5454a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1944115953, "Lb/a/p0/a/h0/l/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1944115953, "Lb/a/p0/a/h0/l/g/f;");
                return;
            }
        }
        f5454a = b.a.p0.a.k.f6397a;
    }

    public static boolean a(b.a.p0.a.h0.f.a aVar, String str) {
        InterceptResult invokeLL;
        b.a.p0.a.a2.e P;
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, aVar, str)) == null) {
            boolean z = false;
            if (b.a.p0.a.u1.a.a.C()) {
                return false;
            }
            if (aVar != null && !TextUtils.isEmpty(aVar.getContainerId())) {
                if (b.a.p0.a.h0.l.g.n.a.i().k(aVar.getContainerId())) {
                    return true;
                }
                if (!b.a.p0.a.h0.o.e.a.f()) {
                    return false;
                }
                String containerId = aVar.getContainerId();
                if (!e.a(containerId) || (P = b.a.p0.a.a2.e.P()) == null || !b(aVar) || (a2 = h.b().a()) == null) {
                    return false;
                }
                z = (TextUtils.equals(a2.i().b(), aVar.getContainerId()) && TextUtils.equals(a2.h(), P.f3961f)) ? true : true;
                if (f5454a && z) {
                    String str2 = "master id - " + containerId + ",can not call API - " + str + ", intercept for preload/prefetch";
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(b.a.p0.a.h0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) ? (aVar instanceof b.a.p0.a.l0.a) && ((b.a.p0.a.l0.a) aVar).getInvokeSourceType() == 0 : invokeL.booleanValue;
    }
}
