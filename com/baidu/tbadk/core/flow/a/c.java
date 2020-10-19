package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int evn;
    private int evo;
    private int evp;
    private int evq;
    private int evr;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void oq(int i) {
        this.evn = i;
    }

    public int blm() {
        return this.evn;
    }

    public int bln() {
        return this.evo;
    }

    public final void or(int i) {
        this.evo = i;
    }

    public final void setSpacing(int i) {
        this.evp = i;
    }

    public final void os(int i) {
        this.evq = i;
    }

    public void ot(int i) {
        this.evr = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.evp > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.evp));
            }
            if (this.evn > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.evn));
            }
            if (this.evo > 0) {
                indicatorView.setSelector(resources.getDrawable(this.evo));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.evq > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.evq);
                }
                if (this.evr > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.evr);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
