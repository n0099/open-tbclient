package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int egQ;
    private int egR;
    private int egS;
    private int egT;
    private int egU;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void nH(int i) {
        this.egQ = i;
    }

    public int bhJ() {
        return this.egQ;
    }

    public int bhK() {
        return this.egR;
    }

    public final void nI(int i) {
        this.egR = i;
    }

    public final void setSpacing(int i) {
        this.egS = i;
    }

    public final void nJ(int i) {
        this.egT = i;
    }

    public void nK(int i) {
        this.egU = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.egS > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.egS));
            }
            if (this.egQ > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.egQ));
            }
            if (this.egR > 0) {
                indicatorView.setSelector(resources.getDrawable(this.egR));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.egT > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.egT);
                }
                if (this.egU > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.egU);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
