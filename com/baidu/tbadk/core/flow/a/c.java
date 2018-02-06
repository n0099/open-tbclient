package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int aSK;
    private int aSL;
    private int aSM;
    private int aSN;
    private int aSO;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void fs(int i) {
        this.aSK = i;
    }

    public int Bo() {
        return this.aSK;
    }

    public int Bp() {
        return this.aSL;
    }

    public final void ft(int i) {
        this.aSL = i;
    }

    public final void setSpacing(int i) {
        this.aSM = i;
    }

    public final void fu(int i) {
        this.aSN = i;
    }

    public void fv(int i) {
        this.aSO = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.aSM > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.aSM));
            }
            if (this.aSK > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.aSK));
            }
            if (this.aSL > 0) {
                indicatorView.setSelector(resources.getDrawable(this.aSL));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.aSN > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.aSN);
                }
                if (this.aSO > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.aSO);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
