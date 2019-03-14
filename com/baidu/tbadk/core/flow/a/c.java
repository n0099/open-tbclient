package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int bGi;
    private int bGj;
    private int bGk;
    private int bGl;
    private int bGm;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void gU(int i) {
        this.bGi = i;
    }

    public int abv() {
        return this.bGi;
    }

    public int abw() {
        return this.bGj;
    }

    public final void gV(int i) {
        this.bGj = i;
    }

    public final void setSpacing(int i) {
        this.bGk = i;
    }

    public final void gW(int i) {
        this.bGl = i;
    }

    public void gX(int i) {
        this.bGm = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.bGk > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.bGk));
            }
            if (this.bGi > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.bGi));
            }
            if (this.bGj > 0) {
                indicatorView.setSelector(resources.getDrawable(this.bGj));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.bGl > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.bGl);
                }
                if (this.bGm > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.bGm);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
