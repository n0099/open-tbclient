package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int Tr;
    private int Ts;
    private int Tt;
    private int Tu;
    private int Tv;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void ce(int i) {
        this.Tr = i;
    }

    public int so() {
        return this.Tr;
    }

    public int sp() {
        return this.Ts;
    }

    public final void cf(int i) {
        this.Ts = i;
    }

    public final void setSpacing(int i) {
        this.Tt = i;
    }

    public final void cg(int i) {
        this.Tu = i;
    }

    public void ch(int i) {
        this.Tv = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.Tt > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.Tt));
            }
            if (this.Tr > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.Tr));
            }
            if (this.Ts > 0) {
                indicatorView.setSelector(resources.getDrawable(this.Ts));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.Tu > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.Tu);
                }
                if (this.Tv > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.Tv);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
