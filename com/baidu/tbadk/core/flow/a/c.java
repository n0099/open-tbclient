package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int acb;
    private int acc;
    private int acd;
    private int ace;
    private int acf;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cu(int i) {
        this.acb = i;
    }

    public int tv() {
        return this.acb;
    }

    public int tw() {
        return this.acc;
    }

    public final void cv(int i) {
        this.acc = i;
    }

    public final void setSpacing(int i) {
        this.acd = i;
    }

    public final void cw(int i) {
        this.ace = i;
    }

    public void cx(int i) {
        this.acf = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.acd > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.acd));
            }
            if (this.acb > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.acb));
            }
            if (this.acc > 0) {
                indicatorView.setSelector(resources.getDrawable(this.acc));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.ace > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.ace);
                }
                if (this.acf > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.acf);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
