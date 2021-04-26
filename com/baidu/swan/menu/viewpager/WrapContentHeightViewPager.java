package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes3.dex */
public class WrapContentHeightViewPager extends ViewPager {
    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    public final int a(int i2, View view) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        return mode == Integer.MIN_VALUE ? Math.min(measuredHeight, size) : measuredHeight;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (getChildCount() > 0) {
            int childCount = getChildCount();
            View view = null;
            int i4 = -1;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    childAt.measure(i2, i3);
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (measuredHeight > i4) {
                        view = childAt;
                        i4 = measuredHeight;
                    }
                }
            }
            if (view == null) {
                view = getChildAt(0);
            }
            if (view != null) {
                view.measure(i2, i3);
            }
            setMeasuredDimension(getMeasuredWidth(), a(i3, view));
        }
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
