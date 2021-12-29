package c.a.r0.j.p0;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.g1.f;
import c.a.r0.a.p.b.a.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view, c.a.r0.a.m1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view, aVar)) == null) {
            n X = f.U().X();
            return X != null && X.c(view, aVar);
        }
        return invokeLL.booleanValue;
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            n X = f.U().X();
            if (X != null) {
                return X.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static void c(c.a.r0.a.a3.c cVar) {
        n X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, cVar) == null) || (X = f.U().X()) == null) {
            return;
        }
        X.e(cVar);
    }

    public static boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view)) == null) {
            n X = f.U().X();
            return X != null && X.removeView(view);
        }
        return invokeL.booleanValue;
    }

    public static void e(c.a.r0.a.a3.c cVar) {
        n X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar) == null) || (X = f.U().X()) == null) {
            return;
        }
        X.f(cVar);
    }

    public static boolean f(View view, c.a.r0.a.m1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view, aVar)) == null) {
            n X = f.U().X();
            return X != null && X.a(view, aVar);
        }
        return invokeLL.booleanValue;
    }
}
