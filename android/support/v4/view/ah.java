package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class ah extends ViewGroup.LayoutParams {
    public boolean a;
    public int b;

    public ah() {
        super(-1, -1);
    }

    public ah(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] iArr;
        iArr = ViewPager.a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.b = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
    }
}
