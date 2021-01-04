package com.baidu.live.pendantview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes11.dex */
public class PendantPriorityView extends LinearLayout {
    protected int byj;

    public PendantPriorityView(Context context) {
        this(context, null);
    }

    public PendantPriorityView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PendantPriorityView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.byj = 0;
        setOrientation(1);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        int V = V(view);
        if (V >= 0) {
            super.addView(view, V, layoutParams);
            if (view instanceof PendantChildView) {
                PendantChildView pendantChildView = (PendantChildView) view;
                if (this.byj >= 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pendantChildView.getLayoutParams();
                    if (layoutParams2 != null) {
                        int priority = pendantChildView.getPriority();
                        if (priority == 105 || priority == 0 || priority == 100 || priority == 20 || priority == 90) {
                            layoutParams2.bottomMargin = 0;
                        } else {
                            layoutParams2.bottomMargin = this.byj;
                        }
                    }
                    view.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setDefaultItemMargin(int i) {
        this.byj = i;
    }

    protected int V(View view) {
        return W(view);
    }

    private int W(View view) {
        if (!(view instanceof PendantChildView)) {
            return -1;
        }
        PendantChildView pendantChildView = (PendantChildView) view;
        int indexOfChild = indexOfChild(pendantChildView);
        if (indexOfChild < 0) {
            int childCount = getChildCount();
            int priority = pendantChildView.getPriority();
            for (int i = 0; i < childCount; i++) {
                if ((getChildAt(i) instanceof PendantChildView) && priority < ((PendantChildView) getChildAt(i)).getPriority()) {
                    return i;
                }
            }
            return childCount;
        }
        return indexOfChild;
    }
}
