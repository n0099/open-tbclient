package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int aSA;
    private int aSB;
    private int aSC;
    private int aSD;
    private int aSz;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void fs(int i) {
        this.aSz = i;
    }

    public int Bo() {
        return this.aSz;
    }

    public int Bp() {
        return this.aSA;
    }

    public final void ft(int i) {
        this.aSA = i;
    }

    public final void setSpacing(int i) {
        this.aSB = i;
    }

    public final void fu(int i) {
        this.aSC = i;
    }

    public void fv(int i) {
        this.aSD = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.aSB > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.aSB));
            }
            if (this.aSz > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.aSz));
            }
            if (this.aSA > 0) {
                indicatorView.setSelector(resources.getDrawable(this.aSA));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.aSC > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.aSC);
                }
                if (this.aSD > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.aSD);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
