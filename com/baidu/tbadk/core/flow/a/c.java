package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int aRe;
    private int aRf;
    private int aRg;
    private int aRh;
    private int aRi;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void fu(int i) {
        this.aRe = i;
    }

    public int Bc() {
        return this.aRe;
    }

    public int Bd() {
        return this.aRf;
    }

    public final void fv(int i) {
        this.aRf = i;
    }

    public final void setSpacing(int i) {
        this.aRg = i;
    }

    public final void fw(int i) {
        this.aRh = i;
    }

    public void fx(int i) {
        this.aRi = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.aRg > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.aRg));
            }
            if (this.aRe > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.aRe));
            }
            if (this.aRf > 0) {
                indicatorView.setSelector(resources.getDrawable(this.aRf));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.aRh > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.aRh);
                }
                if (this.aRi > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.aRi);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
