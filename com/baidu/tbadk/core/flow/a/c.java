package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int aRd;
    private int aRe;
    private int aRf;
    private int aRg;
    private int aRh;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void fs(int i) {
        this.aRd = i;
    }

    public int AU() {
        return this.aRd;
    }

    public int AV() {
        return this.aRe;
    }

    public final void ft(int i) {
        this.aRe = i;
    }

    public final void setSpacing(int i) {
        this.aRf = i;
    }

    public final void fu(int i) {
        this.aRg = i;
    }

    public void fv(int i) {
        this.aRh = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.aRf > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.aRf));
            }
            if (this.aRd > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.aRd));
            }
            if (this.aRe > 0) {
                indicatorView.setSelector(resources.getDrawable(this.aRe));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.aRg > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.aRg);
                }
                if (this.aRh > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.aRh);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
