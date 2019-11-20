package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int cfF;
    private int cfG;
    private int cfH;
    private int cfI;
    private int cfJ;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void ih(int i) {
        this.cfF = i;
    }

    public int aln() {
        return this.cfF;
    }

    public int alo() {
        return this.cfG;
    }

    public final void ii(int i) {
        this.cfG = i;
    }

    public final void setSpacing(int i) {
        this.cfH = i;
    }

    public final void ij(int i) {
        this.cfI = i;
    }

    public void ik(int i) {
        this.cfJ = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.cfH > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.cfH));
            }
            if (this.cfF > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.cfF));
            }
            if (this.cfG > 0) {
                indicatorView.setSelector(resources.getDrawable(this.cfG));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.cfI > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.cfI);
                }
                if (this.cfJ > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.cfJ);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
