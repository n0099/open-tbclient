package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int acO;
    private int acP;
    private int acQ;
    private int acR;
    private int acS;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cv(int i) {
        this.acO = i;
    }

    public int tC() {
        return this.acO;
    }

    public int tD() {
        return this.acP;
    }

    public final void cw(int i) {
        this.acP = i;
    }

    public final void setSpacing(int i) {
        this.acQ = i;
    }

    public final void cx(int i) {
        this.acR = i;
    }

    public void cy(int i) {
        this.acS = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.acQ > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.acQ));
            }
            if (this.acO > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.acO));
            }
            if (this.acP > 0) {
                indicatorView.setSelector(resources.getDrawable(this.acP));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.acR > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.acR);
                }
                if (this.acS > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.acS);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
