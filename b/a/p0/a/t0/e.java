package b.a.p0.a.t0;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c a(SwanAppActivity swanAppActivity, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, eVar)) == null) {
            if (eVar == null || !eVar.e()) {
                return null;
            }
            int l = eVar.l();
            if (l != 0) {
                if (l != 1) {
                    return null;
                }
                return b.a.p0.a.c1.b.i().o(swanAppActivity, eVar.f3961f);
            }
            return new b.a.p0.a.t0.f.a(swanAppActivity, eVar.f3961f);
        }
        return (c) invokeLL.objValue;
    }
}
