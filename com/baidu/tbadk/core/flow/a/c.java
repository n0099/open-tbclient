package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int ade;
    private int adf;
    private int adg;
    private int adh;
    private int adi;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cv(int i) {
        this.ade = i;
    }

    public int tL() {
        return this.ade;
    }

    public int tM() {
        return this.adf;
    }

    public final void cw(int i) {
        this.adf = i;
    }

    public final void setSpacing(int i) {
        this.adg = i;
    }

    public final void cx(int i) {
        this.adh = i;
    }

    public void cy(int i) {
        this.adi = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.adg > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.adg));
            }
            if (this.ade > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.ade));
            }
            if (this.adf > 0) {
                indicatorView.setSelector(resources.getDrawable(this.adf));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.adh > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.adh);
                }
                if (this.adi > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.adi);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
