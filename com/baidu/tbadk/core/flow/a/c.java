package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int cSe;
    private int cSf;
    private int cSg;
    private int cSh;
    private int cSi;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void jT(int i) {
        this.cSe = i;
    }

    public int aCx() {
        return this.cSe;
    }

    public int aCy() {
        return this.cSf;
    }

    public final void jU(int i) {
        this.cSf = i;
    }

    public final void setSpacing(int i) {
        this.cSg = i;
    }

    public final void jV(int i) {
        this.cSh = i;
    }

    public void jW(int i) {
        this.cSi = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.cSg > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.cSg));
            }
            if (this.cSe > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.cSe));
            }
            if (this.cSf > 0) {
                indicatorView.setSelector(resources.getDrawable(this.cSf));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.cSh > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.cSh);
                }
                if (this.cSi > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.cSi);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
