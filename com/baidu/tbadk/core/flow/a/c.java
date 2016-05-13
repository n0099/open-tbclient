package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int Ta;
    private int Tb;
    private int Tc;
    private int Td;
    private int Te;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cd(int i) {
        this.Ta = i;
    }

    public int sq() {
        return this.Ta;
    }

    public int sr() {
        return this.Tb;
    }

    public final void ce(int i) {
        this.Tb = i;
    }

    public final void setSpacing(int i) {
        this.Tc = i;
    }

    public final void cf(int i) {
        this.Td = i;
    }

    public void cg(int i) {
        this.Te = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.Tc > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.Tc));
            }
            if (this.Ta > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.Ta));
            }
            if (this.Tb > 0) {
                indicatorView.setSelector(resources.getDrawable(this.Tb));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.Td > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.Td);
                }
                if (this.Te > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.Te);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
