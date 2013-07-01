package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class e extends ViewGroup.MarginLayoutParams {

    /* renamed from: a  reason: collision with root package name */
    public int f111a;
    float b;
    boolean c;
    boolean d;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] iArr;
        this.f111a = 0;
        iArr = DrawerLayout.f103a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.f111a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    public e(int i, int i2) {
        super(i, i2);
        this.f111a = 0;
    }

    public e(e eVar) {
        super((ViewGroup.MarginLayoutParams) eVar);
        this.f111a = 0;
        this.f111a = eVar.f111a;
    }

    public e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f111a = 0;
    }

    public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f111a = 0;
    }
}
