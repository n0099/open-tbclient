package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int abH;
    private int abI;
    private int abJ;
    private int abK;
    private int abL;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void ct(int i) {
        this.abH = i;
    }

    public int tB() {
        return this.abH;
    }

    public int tC() {
        return this.abI;
    }

    public final void cu(int i) {
        this.abI = i;
    }

    public final void setSpacing(int i) {
        this.abJ = i;
    }

    public final void cv(int i) {
        this.abK = i;
    }

    public void cw(int i) {
        this.abL = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.abJ > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.abJ));
            }
            if (this.abH > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.abH));
            }
            if (this.abI > 0) {
                indicatorView.setSelector(resources.getDrawable(this.abI));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.abK > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.abK);
                }
                if (this.abL > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.abL);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
