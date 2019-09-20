package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int bPt;
    private int bPu;
    private int bPv;
    private int bPw;
    private int bPx;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void hN(int i) {
        this.bPt = i;
    }

    public int ahs() {
        return this.bPt;
    }

    public int aht() {
        return this.bPu;
    }

    public final void hO(int i) {
        this.bPu = i;
    }

    public final void setSpacing(int i) {
        this.bPv = i;
    }

    public final void hP(int i) {
        this.bPw = i;
    }

    public void hQ(int i) {
        this.bPx = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.bPv > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.bPv));
            }
            if (this.bPt > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.bPt));
            }
            if (this.bPu > 0) {
                indicatorView.setSelector(resources.getDrawable(this.bPu));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.bPw > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.bPw);
                }
                if (this.bPx > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.bPx);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
