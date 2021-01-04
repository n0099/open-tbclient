package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes5.dex */
public class WrapContentHeightViewPager extends ViewPager {
    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            int childCount = getChildCount();
            View view = null;
            int i4 = -1;
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    childAt.measure(i, i2);
                    i3 = childAt.getMeasuredHeight();
                    if (i3 > i4) {
                        i5++;
                        i4 = i3;
                        view = childAt;
                    }
                }
                i3 = i4;
                childAt = view;
                i5++;
                i4 = i3;
                view = childAt;
            }
            if (view == null) {
                view = getChildAt(0);
            }
            if (view != null) {
                view.measure(i, i2);
            }
            setMeasuredDimension(getMeasuredWidth(), c(i2, view));
        }
    }

    private int c(int i, View view) {
        int i2 = 0;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            if (view != null) {
                i2 = view.getMeasuredHeight();
            }
            return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
        }
        return size;
    }
}
