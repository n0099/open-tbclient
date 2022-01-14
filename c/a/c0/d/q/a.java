package c.a.c0.d.q;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import c.a.c0.s.p;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(p pVar) {
        InterceptResult invokeL;
        p.b bVar;
        p.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pVar)) == null) {
            if (pVar == null) {
                return false;
            }
            return (TextUtils.isEmpty(pVar.f2270f) && TextUtils.isEmpty(pVar.f2268d) && ((bVar = pVar.f2271g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = pVar.f2272h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static String b(String str, String str2, float f2, TextPaint textPaint, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Float.valueOf(f2), textPaint, Float.valueOf(f3)})) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (textPaint == null) {
                textPaint = new TextPaint();
            }
            CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, f2 - (textPaint.measureText(GlideException.IndentedAppendable.INDENT) + f3), TextUtils.TruncateAt.END);
            if (ellipsize != null) {
                return ellipsize.toString() + GlideException.IndentedAppendable.INDENT + str2;
            }
            return str2;
        }
        return (String) invokeCommon.objValue;
    }

    public static int c(float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (i2 != i3 && f2 > 0.0f) {
                if (f2 >= 1.0f) {
                    return i3;
                }
                int red = Color.red(i2);
                int blue = Color.blue(i2);
                int green = Color.green(i2);
                int alpha = Color.alpha(i2);
                return Color.argb((int) (alpha + (f2 * (Color.alpha(i3) - alpha))), (int) (red + ((Color.red(i3) - red) * f2)), (int) (green + ((Color.green(i3) - green) * f2)), (int) (blue + ((Color.blue(i3) - blue) * f2)));
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static int d(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return ContextCompat.getColor(c.a.c0.h.a.b(), i2);
            }
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException unused) {
                return ContextCompat.getColor(c.a.c0.h.a.b(), i2);
            }
        }
        return invokeLI.intValue;
    }
}
