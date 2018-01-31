package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int aRg;
    private int aRh;
    private int aRi;
    private int aRj;
    private int aRk;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void fs(int i) {
        this.aRg = i;
    }

    public int AV() {
        return this.aRg;
    }

    public int AW() {
        return this.aRh;
    }

    public final void ft(int i) {
        this.aRh = i;
    }

    public final void setSpacing(int i) {
        this.aRi = i;
    }

    public final void fu(int i) {
        this.aRj = i;
    }

    public void fv(int i) {
        this.aRk = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.aRi > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.aRi));
            }
            if (this.aRg > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.aRg));
            }
            if (this.aRh > 0) {
                indicatorView.setSelector(resources.getDrawable(this.aRh));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.aRj > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.aRj);
                }
                if (this.aRk > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.aRk);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
