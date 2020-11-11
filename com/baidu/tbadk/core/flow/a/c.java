package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int eJB;
    private int eJC;
    private int eJD;
    private int eJE;
    private int eJF;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void oL(int i) {
        this.eJB = i;
    }

    public int bpF() {
        return this.eJB;
    }

    public int bpG() {
        return this.eJC;
    }

    public final void oM(int i) {
        this.eJC = i;
    }

    public final void setSpacing(int i) {
        this.eJD = i;
    }

    public final void oN(int i) {
        this.eJE = i;
    }

    public void oO(int i) {
        this.eJF = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.eJD > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.eJD));
            }
            if (this.eJB > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.eJB));
            }
            if (this.eJC > 0) {
                indicatorView.setSelector(resources.getDrawable(this.eJC));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.eJE > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.eJE);
                }
                if (this.eJF > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.eJF);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
