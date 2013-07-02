package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class e extends ViewGroup.MarginLayoutParams {
    public int a;
    float b;
    boolean c;
    boolean d;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] iArr;
        this.a = 0;
        iArr = DrawerLayout.a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    public e(int i, int i2) {
        super(i, i2);
        this.a = 0;
    }

    public e(e eVar) {
        super((ViewGroup.MarginLayoutParams) eVar);
        this.a = 0;
        this.a = eVar.a;
    }

    public e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.a = 0;
    }

    public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.a = 0;
    }
}
