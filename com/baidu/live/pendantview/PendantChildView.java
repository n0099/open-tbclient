package com.baidu.live.pendantview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.pendantview.PendantParentView;
/* loaded from: classes10.dex */
public abstract class PendantChildView extends FrameLayout {
    protected PendantParentView.Model byt;
    protected int priority;

    public abstract PendantParentView.Position getHorizontalFullPosition();

    public abstract PendantParentView.Position getHorizontalPosition();

    public abstract int getPriority();

    public abstract PendantParentView.Position getVerticalBBChattingPosition();

    public abstract PendantParentView.Position getVerticalPkPosition();

    public abstract PendantParentView.Position getVerticalPosition();

    public PendantChildView(Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight = ((ViewGroup) getParent()).getMeasuredHeight();
        if (i4 > measuredHeight) {
            dR(measuredHeight + 10);
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    private void dR(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).layout(0, i, 0, i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(10000, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setMode(PendantParentView.Model model) {
        this.byt = model;
    }

    public FixedLocation getFixedlocation() {
        return FixedLocation.NULL;
    }
}
