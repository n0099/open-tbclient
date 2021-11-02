package b.a.p0.h.o0;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.g1.f;
import b.a.p0.a.p.b.a.n;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view, b.a.p0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view, aVar)) == null) {
            n W = f.T().W();
            return W != null && W.c(view, aVar);
        }
        return invokeLL.booleanValue;
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            n W = f.T().W();
            if (W != null) {
                return W.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static void c(b.a.p0.a.w2.c cVar) {
        n W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, cVar) == null) || (W = f.T().W()) == null) {
            return;
        }
        W.e(cVar);
    }

    public static boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view)) == null) {
            n W = f.T().W();
            return W != null && W.removeView(view);
        }
        return invokeL.booleanValue;
    }

    public static void e(b.a.p0.a.w2.c cVar) {
        n W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar) == null) || (W = f.T().W()) == null) {
            return;
        }
        W.f(cVar);
    }

    public static boolean f(View view, b.a.p0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, view, aVar)) == null) {
            n W = f.T().W();
            return W != null && W.a(view, aVar);
        }
        return invokeLL.booleanValue;
    }
}
