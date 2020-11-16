package com.baidu.live.pendantview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes4.dex */
public class PendantPriorityBottomView extends PendantPriorityView {
    public PendantPriorityBottomView(Context context) {
        this(context, null);
    }

    public PendantPriorityBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PendantPriorityBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getOrientation() == 1) {
            eS(i4 - i2);
        }
    }

    private void eS(int i) {
        boolean z;
        int i2;
        int paddingBottom = i - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            if (childAt == null) {
                boolean z3 = z2;
                i2 = paddingBottom + 0;
                z = z3;
            } else if (childAt.getVisibility() == 8) {
                z = z2;
                i2 = paddingBottom;
            } else if (z2) {
                childAt.layout(-1, -1, -1, -1);
                z = z2;
                i2 = paddingBottom;
            } else {
                int measuredHeight = childAt.getMeasuredHeight();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                int i4 = paddingBottom - layoutParams.bottomMargin;
                int i5 = i4 - measuredHeight;
                if (i4 <= paddingTop || i5 < paddingTop) {
                    childAt.layout(-1, -1, -1, -1);
                    z = true;
                    i2 = i4;
                } else {
                    childAt.layout(childAt.getLeft(), i5, childAt.getRight(), i4);
                    boolean z4 = z2;
                    i2 = i5 - layoutParams.topMargin;
                    z = z4;
                }
            }
            i3++;
            paddingBottom = i2;
            z2 = z;
        }
    }
}
