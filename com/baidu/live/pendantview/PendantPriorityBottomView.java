package com.baidu.live.pendantview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes10.dex */
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
            dK(i4 - i2);
        }
    }

    private void dK(int i) {
        boolean z;
        int paddingBottom = i - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt == null) {
                paddingBottom += 0;
                z = z2;
            } else if (childAt.getVisibility() == 8) {
                z = z2;
            } else if (z2) {
                childAt.layout(-1, -1, -1, -1);
                Log.e("pendent_check", "==>>  child.layout(-1, -1, -1, -1)  hide view = " + childAt.toString());
                z = z2;
            } else {
                int measuredHeight = childAt.getMeasuredHeight();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                paddingBottom -= layoutParams.bottomMargin;
                int i3 = paddingBottom - measuredHeight;
                if (paddingBottom <= paddingTop || i3 < paddingTop) {
                    childAt.layout(-1, -1, -1, -1);
                    Log.e("pendent_check", "==>>  child.layout(-1, -1, -1, -1)  hide view = " + childAt.toString());
                    z = true;
                } else {
                    childAt.layout(childAt.getLeft(), i3, childAt.getRight(), paddingBottom);
                    paddingBottom = i3 - layoutParams.topMargin;
                    z = z2;
                }
            }
            i2++;
            z2 = z;
        }
    }
}
