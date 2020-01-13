package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int cSo;
    private int cSp;
    private int cSq;
    private int cSr;
    private int cSs;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void jT(int i) {
        this.cSo = i;
    }

    public int aCQ() {
        return this.cSo;
    }

    public int aCR() {
        return this.cSp;
    }

    public final void jU(int i) {
        this.cSp = i;
    }

    public final void setSpacing(int i) {
        this.cSq = i;
    }

    public final void jV(int i) {
        this.cSr = i;
    }

    public void jW(int i) {
        this.cSs = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.cSq > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.cSq));
            }
            if (this.cSo > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.cSo));
            }
            if (this.cSp > 0) {
                indicatorView.setSelector(resources.getDrawable(this.cSp));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.cSr > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.cSr);
                }
                if (this.cSs > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.cSs);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
