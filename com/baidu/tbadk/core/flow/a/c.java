package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int WP;
    private int WQ;
    private int WR;
    private int WS;
    private int WT;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cr(int i) {
        this.WP = i;
    }

    public int ts() {
        return this.WP;
    }

    public int tt() {
        return this.WQ;
    }

    public final void cs(int i) {
        this.WQ = i;
    }

    public final void setSpacing(int i) {
        this.WR = i;
    }

    public final void ct(int i) {
        this.WS = i;
    }

    public void cu(int i) {
        this.WT = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.WR > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.WR));
            }
            if (this.WP > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.WP));
            }
            if (this.WQ > 0) {
                indicatorView.setSelector(resources.getDrawable(this.WQ));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.WS > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.WS);
                }
                if (this.WT > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.WT);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
