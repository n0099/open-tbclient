package com.baidu.searchbox.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes4.dex */
public class SpecificHeightViewPager extends ViewPager {
    public SpecificHeightViewPager(Context context) {
        super(context);
    }

    public SpecificHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private int measureHeight(int i, View view2) {
        int i2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            if (view2 != null) {
                i2 = view2.getMeasuredHeight();
            } else {
                i2 = 0;
            }
            if (mode == Integer.MIN_VALUE) {
                return Math.min(i2, size);
            }
            return i2;
        }
        return size;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        View childAt;
        super.onMeasure(i, i2);
        if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
            childAt.measure(i, i2);
            setMeasuredDimension(getMeasuredWidth(), measureHeight(i2, childAt));
        }
    }
}
