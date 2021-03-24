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

    public final int a(int i, View view) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        return mode == Integer.MIN_VALUE ? Math.min(measuredHeight, size) : measuredHeight;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            int childCount = getChildCount();
            View view = null;
            int i3 = -1;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != null) {
                    childAt.measure(i, i2);
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (measuredHeight > i3) {
                        view = childAt;
                        i3 = measuredHeight;
                    }
                }
            }
            if (view == null) {
                view = getChildAt(0);
            }
            if (view != null) {
                view.measure(i, i2);
            }
            setMeasuredDimension(getMeasuredWidth(), a(i2, view));
        }
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
