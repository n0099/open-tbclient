package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.h0.a.d;
import d.b.h0.a.k;
/* loaded from: classes3.dex */
public class SwanAppScrollView extends ScrollView {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f12186f = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public int f12187e;

    public SwanAppScrollView(Context context) {
        super(context);
        this.f12187e = -1;
    }

    private int getLimitHeight() {
        int i = getContext().getResources().getDisplayMetrics().heightPixels;
        if (2 == getContext().getResources().getConfiguration().orientation) {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.aiapps_dialog_message_margin_bottom);
        return ((i - (dimensionPixelSize * 2)) - getContext().getResources().getDimensionPixelSize(d.aiapps_dialog_title_height)) - getContext().getResources().getDimensionPixelSize(d.aiapps_dialog_btns_height);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (f12186f) {
            Log.d("BoxScrollView", "onLayout( " + z + StringUtil.ARRAY_ELEMENT_SEPARATOR + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (f12186f) {
            Log.d("BoxScrollView", "onMeasure( " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + SmallTailInfo.EMOTION_SUFFIX);
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int i3 = this.f12187e;
        if (i3 > 0) {
            size = Math.min(size, i3);
        }
        measureChildren(i, i2);
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

    public void setMaxHeight(int i) {
        this.f12187e = i;
    }

    public SwanAppScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12187e = -1;
    }

    public SwanAppScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12187e = -1;
    }
}
