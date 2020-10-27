package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int eDM;
    private int eDN;
    private int eDO;
    private int eDP;
    private int eDQ;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void oB(int i) {
        this.eDM = i;
    }

    public int bnf() {
        return this.eDM;
    }

    public int bng() {
        return this.eDN;
    }

    public final void oC(int i) {
        this.eDN = i;
    }

    public final void setSpacing(int i) {
        this.eDO = i;
    }

    public final void oD(int i) {
        this.eDP = i;
    }

    public void oE(int i) {
        this.eDQ = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.eDO > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.eDO));
            }
            if (this.eDM > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.eDM));
            }
            if (this.eDN > 0) {
                indicatorView.setSelector(resources.getDrawable(this.eDN));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.eDP > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.eDP);
                }
                if (this.eDQ > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.eDQ);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
