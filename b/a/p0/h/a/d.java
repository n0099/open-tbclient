package b.a.p0.h.a;

import android.annotation.SuppressLint;
import android.view.View;
import b.a.p0.a.g1.f;
import b.a.p0.a.p.b.a.n;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view, b.a.p0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view, aVar)) == null) {
            n V = f.T().V();
            return V != null && V.c(view, aVar);
        }
        return invokeLL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            n V = f.T().V();
            return (V == null || !V.b() || V.h()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            n V = f.T().V();
            return V != null && V.d(view);
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view)) == null) {
            n V = f.T().V();
            if (V == null) {
                return false;
            }
            if (V.h()) {
                SwanAppActivity activity = f.T().getActivity();
                if (activity != null) {
                    activity.setRequestedOrientation(0);
                }
                V.g(false);
            }
            return V.removeView(view);
        }
        return invokeL.booleanValue;
    }
}
