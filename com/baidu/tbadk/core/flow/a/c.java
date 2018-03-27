package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int aSB;
    private int aSC;
    private int aSD;
    private int aSE;
    private int aSF;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void fs(int i) {
        this.aSB = i;
    }

    public int Bp() {
        return this.aSB;
    }

    public int Bq() {
        return this.aSC;
    }

    public final void ft(int i) {
        this.aSC = i;
    }

    public final void setSpacing(int i) {
        this.aSD = i;
    }

    public final void fu(int i) {
        this.aSE = i;
    }

    public void fv(int i) {
        this.aSF = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.aSD > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.aSD));
            }
            if (this.aSB > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.aSB));
            }
            if (this.aSC > 0) {
                indicatorView.setSelector(resources.getDrawable(this.aSC));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.aSE > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.aSE);
                }
                if (this.aSF > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.aSF);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
