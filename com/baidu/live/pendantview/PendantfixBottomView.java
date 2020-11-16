package com.baidu.live.pendantview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes4.dex */
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
            eS(i4 - i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eS(int i) {
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
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt == null) {
                paddingBottom += 0;
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
                    i3 = paddingBottom - layoutParams.bottomMargin;
                    int i8 = i3 - measuredHeight;
                    i7 = ((i7 - layoutParams.topMargin) - layoutParams.bottomMargin) - measuredHeight;
                    if (i8 <= paddingTop) {
                        childAt.layout(-1, -1, -1, -1);
                        z = true;
                        paddingBottom = i3;
                    } else {
                        int i9 = paddingBottom;
                        i4 = i8;
                        i2 = i9;
                        childAt.layout(childAt.getLeft(), i4, childAt.getRight(), i2);
                        if (fixedlocation != FixedLocation.BOTTOM) {
                            paddingBottom = (i3 - layoutParams.topMargin) - measuredHeight;
                            i7 = (i7 - layoutParams.topMargin) - measuredHeight;
                            z = z2;
                        } else if (fixedlocation == FixedLocation.TOP || fixedlocation == FixedLocation.NULL) {
                            i6 = layoutParams.bottomMargin + i6 + measuredHeight;
                            z = z2;
                            paddingBottom = i3;
                        } else {
                            z = z2;
                            paddingBottom = i3;
                        }
                    }
                } else {
                    if (fixedlocation == FixedLocation.TOP || fixedlocation == FixedLocation.NULL) {
                        int i10 = i6 + layoutParams.topMargin;
                        i2 = i10 + measuredHeight + layoutParams.bottomMargin;
                        if (i2 >= i7) {
                            childAt.layout(-1, -1, -1, -1);
                            z = true;
                        } else {
                            i3 = paddingBottom;
                            i4 = i10;
                        }
                    } else {
                        i2 = paddingBottom;
                        i3 = paddingBottom;
                        i4 = i6;
                    }
                    childAt.layout(childAt.getLeft(), i4, childAt.getRight(), i2);
                    if (fixedlocation != FixedLocation.BOTTOM) {
                    }
                }
            }
            i5++;
            z2 = z;
        }
    }
}
