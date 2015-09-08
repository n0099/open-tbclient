package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int XJ;
    private int XK;
    private int XL;
    private int XM;
    private int XN;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setDrawableId(int i) {
        this.XJ = i;
    }

    public int tp() {
        return this.XJ;
    }

    public int getSelectedId() {
        return this.XK;
    }

    public final void bX(int i) {
        this.XK = i;
    }

    public final void setSpacing(int i) {
        this.XL = i;
    }

    public final void bY(int i) {
        this.XM = i;
    }

    public void bZ(int i) {
        this.XN = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.XL > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.XL));
            }
            if (this.XJ > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.XJ));
            }
            if (this.XK > 0) {
                indicatorView.setSelector(resources.getDrawable(this.XK));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.XM > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.XM);
                }
                if (this.XN > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.XN);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
