package com.baidu.poly.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import d.b.c0.j;
/* loaded from: classes2.dex */
public class MaxHeightScrollView extends ScrollView {

    /* renamed from: e  reason: collision with root package name */
    public float f10432e;

    public MaxHeightScrollView(Context context) {
        this(context, null);
    }

    private int getScreenHeight() {
        return getContext().getResources().getDisplayMetrics().heightPixels;
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.MaxHeightScrollView);
        this.f10432e = obtainStyledAttributes.getFloat(j.MaxHeightScrollView_heightRatio, -1.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f10432e > 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) Math.min(getScreenHeight() * this.f10432e, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
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
