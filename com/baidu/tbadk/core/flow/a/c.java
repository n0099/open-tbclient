package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int abO;
    private int abP;
    private int abQ;
    private int abR;
    private int abS;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cs(int i) {
        this.abO = i;
    }

    public int ul() {
        return this.abO;
    }

    public int um() {
        return this.abP;
    }

    public final void ct(int i) {
        this.abP = i;
    }

    public final void setSpacing(int i) {
        this.abQ = i;
    }

    public final void cu(int i) {
        this.abR = i;
    }

    public void cv(int i) {
        this.abS = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.abQ > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.abQ));
            }
            if (this.abO > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.abO));
            }
            if (this.abP > 0) {
                indicatorView.setSelector(resources.getDrawable(this.abP));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.abR > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.abR);
                }
                if (this.abS > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.abS);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
