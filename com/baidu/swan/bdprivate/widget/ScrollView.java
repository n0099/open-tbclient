package com.baidu.swan.bdprivate.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
/* loaded from: classes11.dex */
public class ScrollView extends android.widget.ScrollView {
    public ScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public ScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ScrollView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
    }

    @Override // android.widget.ScrollView
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int i;
        int i2;
        int i3;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i4 -= verticalFadingEdgeLength;
        }
        if (rect.top > i4 && rect.bottom > i4 && rect.top > scrollY) {
            if (rect.height() > height) {
                i3 = (rect.top - scrollY) + 0;
            } else {
                i3 = (rect.bottom - i4) + 0;
            }
            i = Math.min(i3, getChildAt(0).getBottom() - i4);
        } else if (rect.bottom >= scrollY || rect.top >= scrollY || rect.bottom >= i4) {
            i = 0;
        } else {
            if (rect.height() > height) {
                i2 = 0 - (i4 - rect.bottom);
            } else {
                i2 = 0 - (scrollY - rect.top);
            }
            i = Math.max(i2, -getScrollY());
        }
        return i;
    }
}
