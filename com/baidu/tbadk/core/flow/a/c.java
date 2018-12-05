package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int axK;
    private int axL;
    private int axM;
    private int axN;
    private int axO;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void ds(int i) {
        this.axK = i;
    }

    public int BY() {
        return this.axK;
    }

    public int BZ() {
        return this.axL;
    }

    public final void dt(int i) {
        this.axL = i;
    }

    public final void setSpacing(int i) {
        this.axM = i;
    }

    public final void du(int i) {
        this.axN = i;
    }

    public void dv(int i) {
        this.axO = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.axM > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.axM));
            }
            if (this.axK > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.axK));
            }
            if (this.axL > 0) {
                indicatorView.setSelector(resources.getDrawable(this.axL));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.axN > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.axN);
                }
                if (this.axO > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.axO);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
