package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int abi;
    private int abj;
    private int abk;
    private int abl;
    private int abm;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cr(int i) {
        this.abi = i;
    }

    public int tu() {
        return this.abi;
    }

    public int tv() {
        return this.abj;
    }

    public final void cs(int i) {
        this.abj = i;
    }

    public final void setSpacing(int i) {
        this.abk = i;
    }

    public final void ct(int i) {
        this.abl = i;
    }

    public void cu(int i) {
        this.abm = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.abk > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.abk));
            }
            if (this.abi > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.abi));
            }
            if (this.abj > 0) {
                indicatorView.setSelector(resources.getDrawable(this.abj));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.abl > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.abl);
                }
                if (this.abm > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.abm);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
