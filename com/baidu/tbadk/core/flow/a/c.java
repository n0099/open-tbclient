package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int eXU;
    private int eYP;
    private int eYQ;
    private int eYR;
    private int eYS;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void oq(int i) {
        this.eXU = i;
    }

    public int brp() {
        return this.eXU;
    }

    public int brq() {
        return this.eYP;
    }

    public final void or(int i) {
        this.eYP = i;
    }

    public final void setSpacing(int i) {
        this.eYQ = i;
    }

    public final void os(int i) {
        this.eYR = i;
    }

    public void ot(int i) {
        this.eYS = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.eYQ > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.eYQ));
            }
            if (this.eXU > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.eXU));
            }
            if (this.eYP > 0) {
                indicatorView.setSelector(resources.getDrawable(this.eYP));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.eYR > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.eYR);
                }
                if (this.eYS > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.eYS);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
