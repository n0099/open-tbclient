package com.baidu.poly.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.baidu.poly.b;
/* loaded from: classes6.dex */
public class MaxHeightScrollView extends ScrollView {
    private float cbV;

    public MaxHeightScrollView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.i.MaxHeightScrollView);
        this.cbV = obtainStyledAttributes.getFloat(b.i.MaxHeightScrollView_heightRatio, -1.0f);
        obtainStyledAttributes.recycle();
    }

    private int getScreenHeight() {
        return getContext().getResources().getDisplayMetrics().heightPixels;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.cbV > 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) Math.min(getScreenHeight() * this.cbV, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
