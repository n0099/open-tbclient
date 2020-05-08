package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int dvU;
    private int dvV;
    private int dvW;
    private int dvX;
    private int dvY;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void kr(int i) {
        this.dvU = i;
    }

    public int aNs() {
        return this.dvU;
    }

    public int aNt() {
        return this.dvV;
    }

    public final void ks(int i) {
        this.dvV = i;
    }

    public final void setSpacing(int i) {
        this.dvW = i;
    }

    public final void kt(int i) {
        this.dvX = i;
    }

    public void ku(int i) {
        this.dvY = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.dvW > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.dvW));
            }
            if (this.dvU > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.dvU));
            }
            if (this.dvV > 0) {
                indicatorView.setSelector(resources.getDrawable(this.dvV));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.dvX > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.dvX);
                }
                if (this.dvY > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.dvY);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
