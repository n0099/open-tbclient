package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.i0.a.d;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class SwanAppScrollView extends ScrollView {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f11235f = k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public int f11236e;

    public SwanAppScrollView(Context context) {
        super(context);
        this.f11236e = -1;
    }

    private int getLimitHeight() {
        int i2 = getContext().getResources().getDisplayMetrics().heightPixels;
        if (2 == getContext().getResources().getConfiguration().orientation) {
            i2 = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.aiapps_dialog_message_margin_bottom);
        return ((i2 - (dimensionPixelSize * 2)) - getContext().getResources().getDimensionPixelSize(d.aiapps_dialog_title_height)) - getContext().getResources().getDimensionPixelSize(d.aiapps_dialog_btns_height);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (f11235f) {
            Log.d("BoxScrollView", "onLayout( " + z + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i5 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (f11235f) {
            Log.d("BoxScrollView", "onMeasure( " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + SmallTailInfo.EMOTION_SUFFIX);
        }
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = this.f11236e;
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
        this.f11236e = i2;
    }

    public SwanAppScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11236e = -1;
    }

    public SwanAppScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11236e = -1;
    }
}
