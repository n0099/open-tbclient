package c.a.u0.f3;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(c.a.t0.g0.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hVar)) == null) {
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(c.a.t0.g0.h hVar, View.OnClickListener onClickListener, Context context, View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{hVar, onClickListener, context, view, str, Boolean.valueOf(z)}) == null) || a(hVar) || context == null || view == null) {
            return;
        }
        if (hVar == null) {
            hVar = new c.a.t0.g0.h(context, onClickListener);
        }
        hVar.k(context.getResources().getDimensionPixelSize(c.a.u0.a3.b.tbds530));
        hVar.attachView(view, z);
        hVar.p();
        hVar.onChangeSkinType();
    }
}
