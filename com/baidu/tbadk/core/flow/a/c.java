package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int cWF;
    private int cWG;
    private int cWH;
    private int cWI;
    private int cWJ;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void kk(int i) {
        this.cWF = i;
    }

    public int aFg() {
        return this.cWF;
    }

    public int aFh() {
        return this.cWG;
    }

    public final void kl(int i) {
        this.cWG = i;
    }

    public final void setSpacing(int i) {
        this.cWH = i;
    }

    public final void km(int i) {
        this.cWI = i;
    }

    public void kn(int i) {
        this.cWJ = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.cWH > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.cWH));
            }
            if (this.cWF > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.cWF));
            }
            if (this.cWG > 0) {
                indicatorView.setSelector(resources.getDrawable(this.cWG));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.cWI > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.cWI);
                }
                if (this.cWJ > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.cWJ);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
