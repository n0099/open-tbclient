package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes2.dex */
public class c {
    private int egM;
    private int egN;
    private int egO;
    private int egP;
    private int egQ;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void nH(int i) {
        this.egM = i;
    }

    public int bhJ() {
        return this.egM;
    }

    public int bhK() {
        return this.egN;
    }

    public final void nI(int i) {
        this.egN = i;
    }

    public final void setSpacing(int i) {
        this.egO = i;
    }

    public final void nJ(int i) {
        this.egP = i;
    }

    public void nK(int i) {
        this.egQ = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.egO > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.egO));
            }
            if (this.egM > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.egM));
            }
            if (this.egN > 0) {
                indicatorView.setSelector(resources.getDrawable(this.egN));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.egP > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.egP);
                }
                if (this.egQ > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.egQ);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
