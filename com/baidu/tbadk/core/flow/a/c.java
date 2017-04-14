package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int abN;
    private int abO;
    private int abP;
    private int abQ;
    private int abR;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cs(int i) {
        this.abN = i;
    }

    public int ul() {
        return this.abN;
    }

    public int um() {
        return this.abO;
    }

    public final void ct(int i) {
        this.abO = i;
    }

    public final void setSpacing(int i) {
        this.abP = i;
    }

    public final void cu(int i) {
        this.abQ = i;
    }

    public void cv(int i) {
        this.abR = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.abP > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.abP));
            }
            if (this.abN > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.abN));
            }
            if (this.abO > 0) {
                indicatorView.setSelector(resources.getDrawable(this.abO));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.abQ > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.abQ);
                }
                if (this.abR > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.abR);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
