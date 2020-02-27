package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int cWq;
    private int cWr;
    private int cWs;
    private int cWt;
    private int cWu;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void kk(int i) {
        this.cWq = i;
    }

    public int aFa() {
        return this.cWq;
    }

    public int aFb() {
        return this.cWr;
    }

    public final void kl(int i) {
        this.cWr = i;
    }

    public final void setSpacing(int i) {
        this.cWs = i;
    }

    public final void km(int i) {
        this.cWt = i;
    }

    public void kn(int i) {
        this.cWu = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.cWs > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.cWs));
            }
            if (this.cWq > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.cWq));
            }
            if (this.cWr > 0) {
                indicatorView.setSelector(resources.getDrawable(this.cWr));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.cWt > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.cWt);
                }
                if (this.cWu > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.cWu);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
