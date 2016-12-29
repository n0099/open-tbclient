package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int WU;
    private int WV;
    private int WW;
    private int WX;
    private int WY;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cu(int i) {
        this.WU = i;
    }

    public int tw() {
        return this.WU;
    }

    public int tx() {
        return this.WV;
    }

    public final void cv(int i) {
        this.WV = i;
    }

    public final void setSpacing(int i) {
        this.WW = i;
    }

    public final void cw(int i) {
        this.WX = i;
    }

    public void cx(int i) {
        this.WY = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.WW > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.WW));
            }
            if (this.WU > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.WU));
            }
            if (this.WV > 0) {
                indicatorView.setSelector(resources.getDrawable(this.WV));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.WX > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.WX);
                }
                if (this.WY > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.WY);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
