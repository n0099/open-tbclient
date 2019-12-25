package com.baidu.android.ext.widget.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.baidu.android.common.ui.R;
/* loaded from: classes11.dex */
public class BoxScrollView extends ScrollView {
    private static final boolean DEBUG = false;
    private static final String TAG = "BoxScrollView";
    private int mMaxHeight;

    public BoxScrollView(Context context) {
        super(context);
        this.mMaxHeight = -1;
    }

    public BoxScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxHeight = -1;
    }

    public BoxScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxHeight = -1;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        if (this.mMaxHeight > 0) {
            size = Math.min(size, this.mMaxHeight);
        }
        measureChildren(i, i2);
        int measuredHeight = getChildAt(0).getMeasuredHeight();
        int measuredWidth = getChildAt(0).getMeasuredWidth();
        int min = measuredHeight > 0 ? Math.min(measuredHeight, size) : size;
        setMeasuredDimension(measuredWidth > 0 ? Math.min(measuredWidth, size2) : size2, getLimitHeight() < min ? getLimitHeight() : min);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    private int getLimitHeight() {
        int i = getContext().getResources().getDisplayMetrics().heightPixels;
        if (2 == getContext().getResources().getConfiguration().orientation) {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.dialog_message_margin_bottom);
        return ((i - (dimensionPixelSize * 2)) - getContext().getResources().getDimensionPixelSize(R.dimen.dialog_title_height)) - getContext().getResources().getDimensionPixelSize(R.dimen.dialog_btns_height);
    }

    public void setMaxHeight(int i) {
        this.mMaxHeight = i;
    }
}
