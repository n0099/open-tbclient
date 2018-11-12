package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int auk;
    private int aul;
    private int aum;
    private int aun;
    private int auo;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void de(int i) {
        this.auk = i;
    }

    public int AU() {
        return this.auk;
    }

    public int AV() {
        return this.aul;
    }

    public final void df(int i) {
        this.aul = i;
    }

    public final void setSpacing(int i) {
        this.aum = i;
    }

    public final void dg(int i) {
        this.aun = i;
    }

    public void dh(int i) {
        this.auo = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.aum > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.aum));
            }
            if (this.auk > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.auk));
            }
            if (this.aul > 0) {
                indicatorView.setSelector(resources.getDrawable(this.aul));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.aun > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.aun);
                }
                if (this.auo > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.auo);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
