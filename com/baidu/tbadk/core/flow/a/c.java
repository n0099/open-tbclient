package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int XB;
    private int XC;
    private int XD;
    private int XE;
    private int XF;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setDrawableId(int i) {
        this.XB = i;
    }

    public int tm() {
        return this.XB;
    }

    public int getSelectedId() {
        return this.XC;
    }

    public final void bX(int i) {
        this.XC = i;
    }

    public final void setSpacing(int i) {
        this.XD = i;
    }

    public final void bY(int i) {
        this.XE = i;
    }

    public void bZ(int i) {
        this.XF = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.XD > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.XD));
            }
            if (this.XB > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.XB));
            }
            if (this.XC > 0) {
                indicatorView.setSelector(resources.getDrawable(this.XC));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.XE > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.XE);
                }
                if (this.XF > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.XF);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
