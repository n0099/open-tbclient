package c.a.d0.l0.b0;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.l0.j;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, Drawable drawable, PorterDuff.Mode mode, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65536, null, context, drawable, mode, i2) == null) || context == null || drawable == null) {
            return;
        }
        b(context, drawable, mode, i2, e(context));
    }

    public static void b(Context context, Drawable drawable, PorterDuff.Mode mode, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, drawable, mode, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || context == null || drawable == null) {
            return;
        }
        if (i2 >= 0 && i2 < 255) {
            i3 = Color.argb((Color.alpha(i3) * i2) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
        }
        drawable.setColorFilter(i3, mode);
    }

    public static void c(Context context, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, drawable) == null) {
            d(context, drawable, 255);
        }
    }

    public static void d(Context context, Drawable drawable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, context, drawable, i2) == null) {
            a(context, drawable, PorterDuff.Mode.SRC_ATOP, i2);
        }
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? context.getResources().getColor(j.nad_ui_cover_layer_color) : invokeL.intValue;
    }
}
