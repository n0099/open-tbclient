package c.a.p0.h.o0;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.g1.f;
import c.a.p0.a.p.b.a.n;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view, c.a.p0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view, aVar)) == null) {
            n Y = f.V().Y();
            return Y != null && Y.c(view, aVar);
        }
        return invokeLL.booleanValue;
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            n Y = f.V().Y();
            if (Y != null) {
                return Y.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static void c(c.a.p0.a.w2.c cVar) {
        n Y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, cVar) == null) || (Y = f.V().Y()) == null) {
            return;
        }
        Y.e(cVar);
    }

    public static boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view)) == null) {
            n Y = f.V().Y();
            return Y != null && Y.removeView(view);
        }
        return invokeL.booleanValue;
    }

    public static void e(c.a.p0.a.w2.c cVar) {
        n Y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar) == null) || (Y = f.V().Y()) == null) {
            return;
        }
        Y.f(cVar);
    }

    public static boolean f(View view, c.a.p0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, view, aVar)) == null) {
            n Y = f.V().Y();
            return Y != null && Y.a(view, aVar);
        }
        return invokeLL.booleanValue;
    }
}
