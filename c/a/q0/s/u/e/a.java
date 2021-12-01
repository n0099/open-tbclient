package c.a.q0.s.u.e;

import android.graphics.Paint;
import android.text.Spanned;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Paint.FontMetricsInt fontMetricsInt, int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, fontMetricsInt, i2) == null) || (i4 = (i3 = fontMetricsInt.descent) - fontMetricsInt.ascent) <= 0) {
            return;
        }
        int round = Math.round(i3 * ((i2 * 1.0f) / i4));
        fontMetricsInt.descent = round;
        fontMetricsInt.ascent = round - i2;
    }

    public static boolean b(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, charSequence)) == null) {
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                return ((EMTextView.a[]) spanned.getSpans(0, spanned.length(), EMTextView.a.class)).length > 0;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
