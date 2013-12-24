package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class bn extends ViewGroup.LayoutParams {
    public boolean a;
    public int b;
    float c;
    boolean d;
    int e;
    int f;

    public bn() {
        super(-1, -1);
        this.c = 0.0f;
    }

    public bn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] iArr;
        this.c = 0.0f;
        iArr = ViewPager.a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
