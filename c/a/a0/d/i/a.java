package c.a.a0.d.i;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import c.a.a0.s.t;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(t tVar) {
        InterceptResult invokeL;
        t.b bVar;
        t.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tVar)) == null) {
            if (tVar == null) {
                return false;
            }
            return (TextUtils.isEmpty(tVar.f1590f) && TextUtils.isEmpty(tVar.f1588d) && ((bVar = tVar.f1591g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = tVar.f1592h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
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

    public static int c(float f2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (i != i2 && f2 > 0.0f) {
                if (f2 >= 1.0f) {
                    return i2;
                }
                int red = Color.red(i);
                int blue = Color.blue(i);
                int green = Color.green(i);
                int alpha = Color.alpha(i);
                return Color.argb((int) (alpha + (f2 * (Color.alpha(i2) - alpha))), (int) (red + ((Color.red(i2) - red) * f2)), (int) (green + ((Color.green(i2) - green) * f2)), (int) (blue + ((Color.blue(i2) - blue) * f2)));
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public static int d(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return ContextCompat.getColor(c.a.a0.h.a.b(), i);
            }
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException unused) {
                return ContextCompat.getColor(c.a.a0.h.a.b(), i);
            }
        }
        return invokeLI.intValue;
    }
}
