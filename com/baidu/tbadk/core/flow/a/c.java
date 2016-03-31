package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int XM;
    private int XN;
    private int XO;
    private int XP;
    private int XQ;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void ct(int i) {
        this.XM = i;
    }

    public int uK() {
        return this.XM;
    }

    public int uL() {
        return this.XN;
    }

    public final void cu(int i) {
        this.XN = i;
    }

    public final void setSpacing(int i) {
        this.XO = i;
    }

    public final void cv(int i) {
        this.XP = i;
    }

    public void cw(int i) {
        this.XQ = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.XO > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.XO));
            }
            if (this.XM > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.XM));
            }
            if (this.XN > 0) {
                indicatorView.setSelector(resources.getDrawable(this.XN));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.XP > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.XP);
                }
                if (this.XQ > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.XQ);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
