package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int atA;
    private int atB;
    private int atx;
    private int aty;
    private int atz;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cQ(int i) {
        this.atx = i;
    }

    public int AN() {
        return this.atx;
    }

    public int AO() {
        return this.aty;
    }

    public final void cR(int i) {
        this.aty = i;
    }

    public final void setSpacing(int i) {
        this.atz = i;
    }

    public final void cS(int i) {
        this.atA = i;
    }

    public void cT(int i) {
        this.atB = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.atz > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.atz));
            }
            if (this.atx > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.atx));
            }
            if (this.aty > 0) {
                indicatorView.setSelector(resources.getDrawable(this.aty));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.atA > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.atA);
                }
                if (this.atB > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.atB);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
