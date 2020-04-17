package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int dvQ;
    private int dvR;
    private int dvS;
    private int dvT;
    private int dvU;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void kr(int i) {
        this.dvQ = i;
    }

    public int aNu() {
        return this.dvQ;
    }

    public int aNv() {
        return this.dvR;
    }

    public final void ks(int i) {
        this.dvR = i;
    }

    public final void setSpacing(int i) {
        this.dvS = i;
    }

    public final void kt(int i) {
        this.dvT = i;
    }

    public void ku(int i) {
        this.dvU = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.dvS > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.dvS));
            }
            if (this.dvQ > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.dvQ));
            }
            if (this.dvR > 0) {
                indicatorView.setSelector(resources.getDrawable(this.dvR));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.dvT > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.dvT);
                }
                if (this.dvU > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.dvU);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
