package c.a.t0.s2.z;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1136398484, "Lc/a/t0/s2/z/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1136398484, "Lc/a/t0/s2/z/g;");
                return;
            }
        }
        a = new SparseIntArray();
    }

    public static void a(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{smallTailInfo, textView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || smallTailInfo == null || textView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        int b2 = b(c.a.t0.s2.g.ds32);
        if (z2 && z3) {
            layoutParams.setMargins(b2, b(c.a.t0.s2.g.ds8), b2, b(c.a.t0.s2.g.ds18));
        } else if (z) {
            layoutParams.setMargins(0, b(c.a.t0.s2.g.ds8), 0, 0);
        } else if (!z2) {
            layoutParams.setMargins(b(c.a.t0.s2.g.ds102), b(c.a.t0.s2.g.ds8), b(c.a.t0.s2.g.ds34), b(c.a.t0.s2.g.ds14));
        } else {
            layoutParams.setMargins(b2, b(c.a.t0.s2.g.ds8), b2, b(c.a.t0.s2.g.ds14));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "icon");
        spannableStringBuilder.append((CharSequence) smallTailInfo.tailSpannable);
        Drawable drawable = SkinManager.getDrawable(c.a.t0.s2.h.icon_pb_tail);
        drawable.setBounds(0, 0, b2, b2);
        c.a.s0.g1.d dVar = new c.a.s0.g1.d(drawable);
        dVar.c(b(c.a.t0.s2.g.ds4));
        spannableStringBuilder.setSpan(dVar, 0, 4, 33);
        textView.setLayoutParams(layoutParams);
        textView.setText(spannableStringBuilder);
        textView.setTextColor(smallTailInfo.showColorId);
        textView.setVisibility(0);
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            int i3 = a.get(i2, -1);
            if (i3 == -1) {
                int f2 = n.f(TbadkCoreApplication.getInst().getContext(), i2);
                a.put(i2, f2);
                return f2;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public static void c(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{smallTailInfo, textView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || smallTailInfo == null || (spannableString = smallTailInfo.tailSpannable) == null || spannableString.length() == 0 || textView == null) {
            return;
        }
        smallTailInfo.updateShowInfo();
        a(smallTailInfo, textView, z, z2, z3);
    }
}
