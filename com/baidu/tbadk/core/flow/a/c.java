package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int cWr;
    private int cWs;
    private int cWt;
    private int cWu;
    private int cWv;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void kk(int i) {
        this.cWr = i;
    }

    public int aFc() {
        return this.cWr;
    }

    public int aFd() {
        return this.cWs;
    }

    public final void kl(int i) {
        this.cWs = i;
    }

    public final void setSpacing(int i) {
        this.cWt = i;
    }

    public final void km(int i) {
        this.cWu = i;
    }

    public void kn(int i) {
        this.cWv = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.cWt > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.cWt));
            }
            if (this.cWr > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.cWr));
            }
            if (this.cWs > 0) {
                indicatorView.setSelector(resources.getDrawable(this.cWs));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.cWu > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.cWu);
                }
                if (this.cWv > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.cWv);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
