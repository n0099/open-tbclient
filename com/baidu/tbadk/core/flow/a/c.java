package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int eOR;
    private int ePM;
    private int ePN;
    private int ePO;
    private int ePP;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void pH(int i) {
        this.eOR = i;
    }

    public int bsm() {
        return this.eOR;
    }

    public int bsn() {
        return this.ePM;
    }

    public final void pI(int i) {
        this.ePM = i;
    }

    public final void setSpacing(int i) {
        this.ePN = i;
    }

    public final void pJ(int i) {
        this.ePO = i;
    }

    public void pK(int i) {
        this.ePP = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.ePN > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.ePN));
            }
            if (this.eOR > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.eOR));
            }
            if (this.ePM > 0) {
                indicatorView.setSelector(resources.getDrawable(this.ePM));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.ePO > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.ePO);
                }
                if (this.ePP > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.ePP);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
