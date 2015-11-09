package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int XG;
    private int XH;
    private int XI;
    private int XJ;
    private int XK;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setDrawableId(int i) {
        this.XG = i;
    }

    public int tm() {
        return this.XG;
    }

    public int getSelectedId() {
        return this.XH;
    }

    public final void bX(int i) {
        this.XH = i;
    }

    public final void setSpacing(int i) {
        this.XI = i;
    }

    public final void bY(int i) {
        this.XJ = i;
    }

    public void bZ(int i) {
        this.XK = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.XI > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.XI));
            }
            if (this.XG > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.XG));
            }
            if (this.XH > 0) {
                indicatorView.setSelector(resources.getDrawable(this.XH));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.XJ > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.XJ);
                }
                if (this.XK > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.XK);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
