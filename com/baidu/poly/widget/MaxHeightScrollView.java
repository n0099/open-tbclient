package com.baidu.poly.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.baidu.poly.b;
/* loaded from: classes2.dex */
public class MaxHeightScrollView extends ScrollView {
    private float ajg;

    public MaxHeightScrollView(Context context) {
        this(context, null);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttrs(context, attributeSet);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.e.MaxHeightScrollView);
        this.ajg = obtainStyledAttributes.getFloat(b.e.MaxHeightScrollView_heightRatio, 1.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) Math.min(getScreenHeight() * this.ajg, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE));
    }

    private int getScreenHeight() {
        return getContext().getResources().getDisplayMetrics().heightPixels;
    }
}
