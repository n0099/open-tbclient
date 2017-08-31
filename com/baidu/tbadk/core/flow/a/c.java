package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int acm;
    private int acn;
    private int aco;
    private int acp;
    private int acq;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cv(int i) {
        this.acm = i;
    }

    public int tI() {
        return this.acm;
    }

    public int tJ() {
        return this.acn;
    }

    public final void cw(int i) {
        this.acn = i;
    }

    public final void setSpacing(int i) {
        this.aco = i;
    }

    public final void cx(int i) {
        this.acp = i;
    }

    public void cy(int i) {
        this.acq = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.aco > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.aco));
            }
            if (this.acm > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.acm));
            }
            if (this.acn > 0) {
                indicatorView.setSelector(resources.getDrawable(this.acn));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.acp > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.acp);
                }
                if (this.acq > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.acq);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
