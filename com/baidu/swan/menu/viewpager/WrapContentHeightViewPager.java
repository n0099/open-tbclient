package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes4.dex */
public class WrapContentHeightViewPager extends ViewPager {
    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final int measureHeight(int i, View view2) {
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
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            int childCount = getChildCount();
            View view2 = null;
            int i3 = -1;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != null) {
                    childAt.measure(i, i2);
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (measuredHeight > i3) {
                        view2 = childAt;
                        i3 = measuredHeight;
                    }
                }
            }
            if (view2 == null) {
                view2 = getChildAt(0);
            }
            if (view2 != null) {
                view2.measure(i, i2);
            }
            setMeasuredDimension(getMeasuredWidth(), measureHeight(i2, view2));
        }
    }
}
