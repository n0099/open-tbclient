package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int Wk;
    private int Wl;
    private int Wm;
    private int Wn;
    private int Wo;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void ct(int i) {
        this.Wk = i;
    }

    public int tq() {
        return this.Wk;
    }

    public int tr() {
        return this.Wl;
    }

    public final void cu(int i) {
        this.Wl = i;
    }

    public final void setSpacing(int i) {
        this.Wm = i;
    }

    public final void cv(int i) {
        this.Wn = i;
    }

    public void cw(int i) {
        this.Wo = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.Wm > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.Wm));
            }
            if (this.Wk > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.Wk));
            }
            if (this.Wl > 0) {
                indicatorView.setSelector(resources.getDrawable(this.Wl));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.Wn > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.Wn);
                }
                if (this.Wo > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.Wo);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
