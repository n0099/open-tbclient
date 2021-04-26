package com.baidu.poly.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import d.a.a0.j;
/* loaded from: classes2.dex */
public class MaxHeightScrollView extends ScrollView {

    /* renamed from: e  reason: collision with root package name */
    public float f10358e;

    public MaxHeightScrollView(Context context) {
        this(context, null);
    }

    private int getScreenHeight() {
        return getContext().getResources().getDisplayMetrics().heightPixels;
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.MaxHeightScrollView);
        this.f10358e = obtainStyledAttributes.getFloat(j.MaxHeightScrollView_heightRatio, -1.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f10358e > 0.0f) {
            i3 = View.MeasureSpec.makeMeasureSpec((int) Math.min(getScreenHeight() * this.f10358e, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }
}
