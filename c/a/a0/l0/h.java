package c.a.a0.l0;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view, View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, view, view2, i) == null) {
            b(view, view2, i, i, i, i);
        }
    }

    public static void b(View view, View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{view, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || view2 == null || view == null) {
            return;
        }
        if (view.getTouchDelegate() instanceof d) {
            ((d) view.getTouchDelegate()).a(view2, i, i2, i3, i4);
        } else {
            view.setTouchDelegate(new d(view2, i, i2, i3, i4));
        }
    }
}
