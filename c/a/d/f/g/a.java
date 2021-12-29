package c.a.d.f.g;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.adp.lib.guide.MaskView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static View a(LayoutInflater layoutInflater, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, layoutInflater, bVar)) == null) {
            View c2 = bVar.c(layoutInflater);
            MaskView.LayoutParams layoutParams = new MaskView.LayoutParams(-2, -2);
            layoutParams.f32197c = bVar.getXOffset();
            layoutParams.f32198d = bVar.getYOffset();
            layoutParams.a = bVar.a();
            layoutParams.f32196b = bVar.b();
            c2.setLayoutParams(layoutParams);
            return c2;
        }
        return (View) invokeLL.objValue;
    }

    public static Rect b(View view, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, view, i2, i3)) == null) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            Rect rect = new Rect();
            rect.set(iArr[0], iArr[1], iArr[0] + view.getMeasuredWidth(), iArr[1] + view.getMeasuredHeight());
            rect.offset(-i2, -i3);
            return rect;
        }
        return (Rect) invokeLII.objValue;
    }
}
