package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int dXg;
    private int dXh;
    private int dXi;
    private int dXj;
    private int dXk;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void lB(int i) {
        this.dXg = i;
    }

    public int aZo() {
        return this.dXg;
    }

    public int aZp() {
        return this.dXh;
    }

    public final void lC(int i) {
        this.dXh = i;
    }

    public final void setSpacing(int i) {
        this.dXi = i;
    }

    public final void lD(int i) {
        this.dXj = i;
    }

    public void lE(int i) {
        this.dXk = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.dXi > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.dXi));
            }
            if (this.dXg > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.dXg));
            }
            if (this.dXh > 0) {
                indicatorView.setSelector(resources.getDrawable(this.dXh));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.dXj > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.dXj);
                }
                if (this.dXk > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.dXk);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
