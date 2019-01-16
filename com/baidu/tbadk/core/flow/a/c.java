package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int ayn;
    private int ayo;
    private int ayp;
    private int ayq;
    private int ayr;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void ds(int i) {
        this.ayn = i;
    }

    public int Cl() {
        return this.ayn;
    }

    public int Cm() {
        return this.ayo;
    }

    public final void dt(int i) {
        this.ayo = i;
    }

    public final void setSpacing(int i) {
        this.ayp = i;
    }

    public final void du(int i) {
        this.ayq = i;
    }

    public void dv(int i) {
        this.ayr = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.ayp > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.ayp));
            }
            if (this.ayn > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.ayn));
            }
            if (this.ayo > 0) {
                indicatorView.setSelector(resources.getDrawable(this.ayo));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.ayq > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.ayq);
                }
                if (this.ayr > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.ayr);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
