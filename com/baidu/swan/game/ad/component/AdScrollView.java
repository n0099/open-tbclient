package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import d.a.l0.f.i.c;
/* loaded from: classes3.dex */
public class AdScrollView extends ScrollView {

    /* renamed from: e  reason: collision with root package name */
    public int f11527e;

    public AdScrollView(Context context) {
        super(context);
        this.f11527e = -1;
    }

    private int getLimitHeight() {
        int i2 = getContext().getResources().getDisplayMetrics().heightPixels;
        if (2 == getContext().getResources().getConfiguration().orientation) {
            i2 = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.swan_ad_dialog_message_margin_bottom);
        return ((i2 - (dimensionPixelSize * 2)) - getContext().getResources().getDimensionPixelSize(c.swan_ad_dialog_title_height)) - getContext().getResources().getDimensionPixelSize(c.swan_ad_dialog_btns_height);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = this.f11527e;
        if (i4 > 0) {
            size = Math.min(size, i4);
        }
        measureChildren(i2, i3);
        int measuredHeight = getChildAt(0).getMeasuredHeight();
        int measuredWidth = getChildAt(0).getMeasuredWidth();
        if (measuredHeight > 0) {
            size = Math.min(measuredHeight, size);
        }
        if (measuredWidth > 0) {
            size2 = Math.min(measuredWidth, size2);
        }
        if (getLimitHeight() < size) {
            size = getLimitHeight();
        }
        setMeasuredDimension(size2, size);
    }

    public void setMaxHeight(int i2) {
        this.f11527e = i2;
    }

    public AdScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11527e = -1;
    }

    public AdScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11527e = -1;
    }
}
