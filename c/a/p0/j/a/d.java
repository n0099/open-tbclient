package c.a.p0.j.a;

import android.annotation.SuppressLint;
import android.view.View;
import c.a.p0.a.f.b.a.n;
import c.a.p0.a.w0.f;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view, c.a.p0.a.c1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view, aVar)) == null) {
            n W = f.U().W();
            return W != null && W.c(view, aVar);
        }
        return invokeLL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            n W = f.U().W();
            return (W == null || !W.b() || W.h()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            n W = f.U().W();
            return W != null && W.d(view);
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view)) == null) {
            n W = f.U().W();
            if (W == null) {
                return false;
            }
            if (W.h()) {
                SwanAppActivity activity = f.U().getActivity();
                if (activity != null) {
                    activity.setRequestedOrientation(0);
                }
                W.g(false);
            }
            return W.removeView(view);
        }
        return invokeL.booleanValue;
    }
}
