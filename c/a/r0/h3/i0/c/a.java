package c.a.r0.h3.i0.c;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.u.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) ? (int) ((i2 * 9.0d) / 16.0d) : invokeI.intValue;
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? (int) ((i2 * 16.0d) / 9.0d) : invokeI.intValue;
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? (int) ((i2 * 9.0d) / 16.0d) : invokeI.intValue;
    }

    public static String d(String str, String str2, float f2, TextPaint textPaint) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Float.valueOf(f2), textPaint})) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (textPaint == null) {
                textPaint = new TextPaint();
            }
            CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, f2 - textPaint.measureText(GlideException.IndentedAppendable.INDENT + str2), TextUtils.TruncateAt.END);
            if (ellipsize != null) {
                return ellipsize.toString() + GlideException.IndentedAppendable.INDENT + str2;
            }
            return str2;
        }
        return (String) invokeCommon.objValue;
    }

    public static Drawable e(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3, i4, i5)) == null) ? c.a.q0.s.u.a.D(c.a.q0.s.u.a.k(b.z(), i2), i3, i4, i5) : (Drawable) invokeIIII.objValue;
    }

    public static int f(float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (i2 != i3 && f2 > 0.0f) {
                if (f2 >= 1.0f) {
                    return i3;
                }
                int red = Color.red(i2);
                int green = Color.green(i2);
                int blue = Color.blue(i2);
                int alpha = Color.alpha(i2);
                return Color.argb((int) (alpha + (f2 * (Color.alpha(i3) - alpha))), (int) (red + ((Color.red(i3) - red) * f2)), (int) (green + ((Color.green(i3) - green) * f2)), (int) (blue + ((Color.blue(i3) - blue) * f2)));
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static int g(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i2)) == null) {
            try {
                return Color.parseColor(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                return i2;
            }
        }
        return invokeLI.intValue;
    }
}
