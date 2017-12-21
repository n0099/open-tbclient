package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int acR;
    private int acS;
    private int acT;
    private int acU;
    private int acV;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cv(int i) {
        this.acR = i;
    }

    public int tC() {
        return this.acR;
    }

    public int tD() {
        return this.acS;
    }

    public final void cw(int i) {
        this.acS = i;
    }

    public final void setSpacing(int i) {
        this.acT = i;
    }

    public final void cx(int i) {
        this.acU = i;
    }

    public void cy(int i) {
        this.acV = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.acT > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.acT));
            }
            if (this.acR > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.acR));
            }
            if (this.acS > 0) {
                indicatorView.setSelector(resources.getDrawable(this.acS));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.acU > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.acU);
                }
                if (this.acV > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.acV);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
