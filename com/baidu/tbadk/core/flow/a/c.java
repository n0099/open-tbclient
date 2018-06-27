package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int amA;
    private int amB;
    private int amC;
    private int amD;
    private int amz;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cu(int i) {
        this.amz = i;
    }

    public int xH() {
        return this.amz;
    }

    public int xI() {
        return this.amA;
    }

    public final void cv(int i) {
        this.amA = i;
    }

    public final void setSpacing(int i) {
        this.amB = i;
    }

    public final void cw(int i) {
        this.amC = i;
    }

    public void cx(int i) {
        this.amD = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.amB > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.amB));
            }
            if (this.amz > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.amz));
            }
            if (this.amA > 0) {
                indicatorView.setSelector(resources.getDrawable(this.amA));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.amC > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.amC);
                }
                if (this.amD > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.amD);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
