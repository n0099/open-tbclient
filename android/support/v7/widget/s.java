package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class s {
    private static final ThreadLocal<TypedValue> ER = new ThreadLocal<>();
    static final int[] lg = {-16842910};
    static final int[] FOCUSED_STATE_SET = {16842908};
    static final int[] Xd = {16843518};
    static final int[] PRESSED_STATE_SET = {16842919};
    static final int[] jn = {16842912};
    static final int[] SELECTED_STATE_SET = {16842913};
    static final int[] Xe = {-16842919, -16842908};
    static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] Xf = new int[1];

    public static int m(Context context, int i) {
        Xf[0] = i;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, Xf);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList n(Context context, int i) {
        Xf[0] = i;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, Xf);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int o(Context context, int i) {
        ColorStateList n = n(context, i);
        if (n != null && n.isStateful()) {
            return n.getColorForState(lg, n.getDefaultColor());
        }
        TypedValue ev = ev();
        context.getTheme().resolveAttribute(16842803, ev, true);
        return a(context, i, ev.getFloat());
    }

    private static TypedValue ev() {
        TypedValue typedValue = ER.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            ER.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    static int a(Context context, int i, float f) {
        int m = m(context, i);
        return ColorUtils.setAlphaComponent(m, Math.round(Color.alpha(m) * f));
    }
}
