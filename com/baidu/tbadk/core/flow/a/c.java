package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int dJY;
    private int dJZ;
    private int dKa;
    private int dKb;
    private int dKc;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void kT(int i) {
        this.dJY = i;
    }

    public int aTw() {
        return this.dJY;
    }

    public int aTx() {
        return this.dJZ;
    }

    public final void kU(int i) {
        this.dJZ = i;
    }

    public final void setSpacing(int i) {
        this.dKa = i;
    }

    public final void kV(int i) {
        this.dKb = i;
    }

    public void kW(int i) {
        this.dKc = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.dKa > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.dKa));
            }
            if (this.dJY > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.dJY));
            }
            if (this.dJZ > 0) {
                indicatorView.setSelector(resources.getDrawable(this.dJZ));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.dKb > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.dKb);
                }
                if (this.dKc > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.dKc);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
