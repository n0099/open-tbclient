package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int acn;
    private int aco;
    private int acp;
    private int acq;
    private int acr;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cv(int i) {
        this.acn = i;
    }

    public int tC() {
        return this.acn;
    }

    public int tD() {
        return this.aco;
    }

    public final void cw(int i) {
        this.aco = i;
    }

    public final void setSpacing(int i) {
        this.acp = i;
    }

    public final void cx(int i) {
        this.acq = i;
    }

    public void cy(int i) {
        this.acr = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.acp > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.acp));
            }
            if (this.acn > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.acn));
            }
            if (this.aco > 0) {
                indicatorView.setSelector(resources.getDrawable(this.aco));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.acq > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.acq);
                }
                if (this.acr > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.acr);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
