package com.baidu.live.pendantview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes11.dex */
public class PendantfixBottomView extends PendantPriorityView {
    public PendantfixBottomView(Context context) {
        super(context);
    }

    public PendantfixBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PendantfixBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.live.pendantview.PendantPriorityView
    protected int V(View view) {
        if (!(view instanceof PendantChildView)) {
            return -1;
        }
        PendantChildView pendantChildView = (PendantChildView) view;
        int indexOfChild = indexOfChild(pendantChildView);
        if (indexOfChild < 0) {
            FixedLocation fixedlocation = pendantChildView.getFixedlocation();
            int childCount = getChildCount();
            int priority = pendantChildView.getPriority();
            if (fixedlocation != FixedLocation.NULL) {
                return 0;
            }
            for (int i = 0; i < childCount; i++) {
                if ((getChildAt(i) instanceof PendantChildView) && priority < ((PendantChildView) getChildAt(i)).getPriority()) {
                    return i;
                }
            }
            return childCount;
        }
        return indexOfChild;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getOrientation() == 1) {
            fq(i4 - i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void fq(int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int paddingBottom = i - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        boolean z2 = false;
        int i5 = 0;
        int i6 = paddingTop;
        int i7 = paddingBottom;
        int i8 = paddingBottom;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt == null) {
                i7 += 0;
                z = z2;
            } else if (childAt.getVisibility() == 8) {
                z = z2;
            } else if (z2) {
                childAt.layout(-1, -1, -1, -1);
                z = z2;
            } else {
                int measuredHeight = childAt.getMeasuredHeight();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                FixedLocation fixedlocation = ((PendantChildView) childAt).getFixedlocation();
                if (fixedlocation == FixedLocation.BOTTOM) {
                    i4 = i7 - layoutParams.bottomMargin;
                    i2 = i4 - measuredHeight;
                    i8 = ((i8 - layoutParams.topMargin) - layoutParams.bottomMargin) - measuredHeight;
                    if (i2 <= paddingTop) {
                        childAt.layout(-1, -1, -1, -1);
                        z = true;
                        i7 = i4;
                    } else {
                        i3 = i7;
                        childAt.layout(childAt.getLeft(), i2, childAt.getRight(), i3);
                        if (fixedlocation != FixedLocation.BOTTOM) {
                            i7 = (i4 - layoutParams.topMargin) - measuredHeight;
                            i8 = (i8 - layoutParams.topMargin) - measuredHeight;
                            z = z2;
                        } else if (fixedlocation == FixedLocation.TOP || fixedlocation == FixedLocation.NULL) {
                            i6 = layoutParams.bottomMargin + i6 + measuredHeight;
                            z = z2;
                            i7 = i4;
                        } else {
                            z = z2;
                            i7 = i4;
                        }
                    }
                } else {
                    if (fixedlocation == FixedLocation.TOP || fixedlocation == FixedLocation.NULL) {
                        i2 = i6 + layoutParams.topMargin;
                        i3 = i2 + measuredHeight + layoutParams.bottomMargin;
                        if (i3 >= i8) {
                            childAt.layout(-1, -1, -1, -1);
                            z = true;
                        } else {
                            i4 = i7;
                        }
                    } else {
                        i3 = i7;
                        i2 = i6;
                        i4 = i7;
                    }
                    childAt.layout(childAt.getLeft(), i2, childAt.getRight(), i3);
                    if (fixedlocation != FixedLocation.BOTTOM) {
                    }
                }
            }
            i5++;
            z2 = z;
        }
    }
}
