package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int eYQ;
    private int eZL;
    private int eZM;
    private int eZN;
    private int eZO;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void pR(int i) {
        this.eYQ = i;
    }

    public int buP() {
        return this.eYQ;
    }

    public int buQ() {
        return this.eZL;
    }

    public final void pS(int i) {
        this.eZL = i;
    }

    public final void setSpacing(int i) {
        this.eZM = i;
    }

    public final void pT(int i) {
        this.eZN = i;
    }

    public void pU(int i) {
        this.eZO = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.eZM > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.eZM));
            }
            if (this.eYQ > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.eYQ));
            }
            if (this.eZL > 0) {
                indicatorView.setSelector(resources.getDrawable(this.eZL));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.eZN > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.eZN);
                }
                if (this.eZO > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.eZO);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
