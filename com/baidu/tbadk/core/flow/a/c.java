package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int acA;
    private int acB;
    private int acC;
    private int acD;
    private int acz;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cu(int i) {
        this.acz = i;
    }

    public int tC() {
        return this.acz;
    }

    public int tD() {
        return this.acA;
    }

    public final void cv(int i) {
        this.acA = i;
    }

    public final void setSpacing(int i) {
        this.acB = i;
    }

    public final void cw(int i) {
        this.acC = i;
    }

    public void cx(int i) {
        this.acD = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.acB > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.acB));
            }
            if (this.acz > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.acz));
            }
            if (this.acA > 0) {
                indicatorView.setSelector(resources.getDrawable(this.acA));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.acC > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.acC);
                }
                if (this.acD > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.acD);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
