package c.a.r0.j2.p;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SparseIntArray f20751a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-141267890, "Lc/a/r0/j2/p/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-141267890, "Lc/a/r0/j2/p/h;");
                return;
            }
        }
        f20751a = new SparseIntArray();
    }

    public static void a(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{smallTailInfo, textView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || smallTailInfo == null || textView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        int b2 = b(R.dimen.ds32);
        if (z2 && z3) {
            layoutParams.setMargins(b2, b(R.dimen.ds8), b2, b(R.dimen.ds18));
        } else if (z) {
            layoutParams.setMargins(0, b(R.dimen.ds8), 0, 0);
        } else if (!z2) {
            layoutParams.setMargins(b(R.dimen.ds102), b(R.dimen.ds8), b(R.dimen.ds34), b(R.dimen.ds14));
        } else {
            layoutParams.setMargins(b2, b(R.dimen.ds8), b2, b(R.dimen.ds14));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "icon");
        spannableStringBuilder.append((CharSequence) smallTailInfo.tailSpannable);
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_pb_tail);
        drawable.setBounds(0, 0, b2, b2);
        c.a.q0.f1.d dVar = new c.a.q0.f1.d(drawable);
        dVar.c(b(R.dimen.ds4));
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
            int i3 = f20751a.get(i2, -1);
            if (i3 == -1) {
                int g2 = l.g(TbadkCoreApplication.getInst().getContext(), i2);
                f20751a.put(i2, g2);
                return g2;
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
