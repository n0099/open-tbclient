package c.a.j.l.b;

import android.graphics.Rect;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, view, view2, i2) == null) {
            b(view, view2, i2, i2, i2, i2);
        }
    }

    public static void b(View view, View view2, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{view, view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || view2 == null || view == null) {
            return;
        }
        if (view.getTouchDelegate() instanceof a) {
            ((a) view.getTouchDelegate()).b(view2, i2, i3, i4, i5);
        } else {
            view.setTouchDelegate(new a(view2, i2, i3, i4, i5, new Rect(0, 0, 0, 0)));
        }
    }
}
