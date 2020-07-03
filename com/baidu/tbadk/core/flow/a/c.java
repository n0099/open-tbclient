package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int dQO;
    private int dQP;
    private int dQQ;
    private int dQR;
    private int dQS;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void lh(int i) {
        this.dQO = i;
    }

    public int aVo() {
        return this.dQO;
    }

    public int aVp() {
        return this.dQP;
    }

    public final void li(int i) {
        this.dQP = i;
    }

    public final void setSpacing(int i) {
        this.dQQ = i;
    }

    public final void lj(int i) {
        this.dQR = i;
    }

    public void lk(int i) {
        this.dQS = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.dQQ > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.dQQ));
            }
            if (this.dQO > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.dQO));
            }
            if (this.dQP > 0) {
                indicatorView.setSelector(resources.getDrawable(this.dQP));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.dQR > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.dQR);
                }
                if (this.dQS > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.dQS);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
