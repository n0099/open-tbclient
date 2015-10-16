package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int XD;
    private int XE;
    private int XF;
    private int XG;
    private int XH;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setDrawableId(int i) {
        this.XD = i;
    }

    public int tm() {
        return this.XD;
    }

    public int getSelectedId() {
        return this.XE;
    }

    public final void bX(int i) {
        this.XE = i;
    }

    public final void setSpacing(int i) {
        this.XF = i;
    }

    public final void bY(int i) {
        this.XG = i;
    }

    public void bZ(int i) {
        this.XH = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.XF > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.XF));
            }
            if (this.XD > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.XD));
            }
            if (this.XE > 0) {
                indicatorView.setSelector(resources.getDrawable(this.XE));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.XG > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.XG);
                }
                if (this.XH > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.XH);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
