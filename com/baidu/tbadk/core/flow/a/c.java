package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int ejf;
    private int ejg;
    private int ejh;
    private int eji;
    private int ejj;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void nT(int i) {
        this.ejf = i;
    }

    public int biD() {
        return this.ejf;
    }

    public int biE() {
        return this.ejg;
    }

    public final void nU(int i) {
        this.ejg = i;
    }

    public final void setSpacing(int i) {
        this.ejh = i;
    }

    public final void nV(int i) {
        this.eji = i;
    }

    public void nW(int i) {
        this.ejj = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.ejh > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.ejh));
            }
            if (this.ejf > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.ejf));
            }
            if (this.ejg > 0) {
                indicatorView.setSelector(resources.getDrawable(this.ejg));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.eji > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.eji);
                }
                if (this.ejj > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.ejj);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
