package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int cWs;
    private int cWt;
    private int cWu;
    private int cWv;
    private int cWw;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void kk(int i) {
        this.cWs = i;
    }

    public int aFc() {
        return this.cWs;
    }

    public int aFd() {
        return this.cWt;
    }

    public final void kl(int i) {
        this.cWt = i;
    }

    public final void setSpacing(int i) {
        this.cWu = i;
    }

    public final void km(int i) {
        this.cWv = i;
    }

    public void kn(int i) {
        this.cWw = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.cWu > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.cWu));
            }
            if (this.cWs > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.cWs));
            }
            if (this.cWt > 0) {
                indicatorView.setSelector(resources.getDrawable(this.cWt));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.cWv > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.cWv);
                }
                if (this.cWw > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.cWw);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
