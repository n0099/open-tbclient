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
    private static final ThreadLocal<TypedValue> EL = new ThreadLocal<>();
    static final int[] lg = {-16842910};
    static final int[] FOCUSED_STATE_SET = {16842908};
    static final int[] WW = {16843518};
    static final int[] PRESSED_STATE_SET = {16842919};
    static final int[] jn = {16842912};
    static final int[] SELECTED_STATE_SET = {16842913};
    static final int[] WX = {-16842919, -16842908};
    static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] WY = new int[1];

    public static int n(Context context, int i) {
        WY[0] = i;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, WY);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList o(Context context, int i) {
        WY[0] = i;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, WY);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int p(Context context, int i) {
        ColorStateList o = o(context, i);
        if (o != null && o.isStateful()) {
            return o.getColorForState(lg, o.getDefaultColor());
        }
        TypedValue ev = ev();
        context.getTheme().resolveAttribute(16842803, ev, true);
        return a(context, i, ev.getFloat());
    }

    private static TypedValue ev() {
        TypedValue typedValue = EL.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            EL.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    static int a(Context context, int i, float f) {
        int n = n(context, i);
        return ColorUtils.setAlphaComponent(n, Math.round(Color.alpha(n) * f));
    }
}
