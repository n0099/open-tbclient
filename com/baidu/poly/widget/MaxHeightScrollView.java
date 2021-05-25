package com.baidu.poly.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import d.a.c0.d;
import d.a.c0.j;
/* loaded from: classes2.dex */
public class MaxHeightScrollView extends ScrollView {

    /* renamed from: e  reason: collision with root package name */
    public float f9294e;

    /* renamed from: f  reason: collision with root package name */
    public float f9295f;

    public MaxHeightScrollView(Context context) {
        this(context, null);
    }

    public final float a(float f2) {
        Resources resources = getContext().getResources();
        return (((resources.getDisplayMetrics().heightPixels * f2) - resources.getDimensionPixelSize(d.title_height)) - resources.getDimensionPixelSize(d.confirm_pay_button_height)) - resources.getDimensionPixelSize(d.confirm_pay_button_ver_margin);
    }

    public final void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.MaxHeightScrollView);
        this.f9294e = obtainStyledAttributes.getFloat(j.MaxHeightScrollView_maxHeightRatio, -1.0f);
        this.f9295f = obtainStyledAttributes.getFloat(j.MaxHeightScrollView_minHeightRatio, -1.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f9294e > 0.0f || this.f9295f > 0.0f) {
            int size = View.MeasureSpec.getSize(i3);
            float f2 = this.f9294e;
            if (f2 > 0.0f) {
                size = (int) Math.min(a(f2), size);
            }
            float f3 = this.f9295f;
            if (f3 > 0.0f) {
                size = (int) Math.max(a(f3), size);
            }
            i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet);
    }
}
