package com.baidu.swan.bdprivate.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class ScrollView extends android.widget.ScrollView {
    public ScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    public final void a(Context context) {
    }

    @Override // android.widget.ScrollView
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
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
        int i5 = rect.top;
        if (i5 > i4 && rect.bottom > i4 && i5 > scrollY) {
            if (rect.height() > height) {
                i3 = rect.top - scrollY;
            } else {
                i3 = rect.bottom - i4;
            }
            return Math.min(i3 + 0, getChildAt(0).getBottom() - i4);
        }
        int i6 = rect.bottom;
        if (i6 >= scrollY || rect.top >= scrollY || i6 >= i4) {
            return 0;
        }
        if (rect.height() > height) {
            i2 = 0 - (i4 - rect.bottom);
        } else {
            i2 = 0 - (scrollY - rect.top);
        }
        return Math.max(i2, -getScrollY());
    }

    public ScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ScrollView(Context context) {
        super(context);
        a(context);
    }
}
