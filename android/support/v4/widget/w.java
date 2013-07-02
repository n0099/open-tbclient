package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class w extends ViewGroup.MarginLayoutParams {
    private static final int[] e = {16843137};
    public float a;
    boolean b;
    boolean c;
    Paint d;

    public w() {
        super(-1, -1);
        this.a = 0.0f;
    }

    public w(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.a = 0.0f;
    }

    public w(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.a = 0.0f;
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e);
        this.a = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
    }
}
