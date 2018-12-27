package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int axL;
    private int axM;
    private int axN;
    private int axO;
    private int axP;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void ds(int i) {
        this.axL = i;
    }

    public int BY() {
        return this.axL;
    }

    public int BZ() {
        return this.axM;
    }

    public final void dt(int i) {
        this.axM = i;
    }

    public final void setSpacing(int i) {
        this.axN = i;
    }

    public final void du(int i) {
        this.axO = i;
    }

    public void dv(int i) {
        this.axP = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.axN > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.axN));
            }
            if (this.axL > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.axL));
            }
            if (this.axM > 0) {
                indicatorView.setSelector(resources.getDrawable(this.axM));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.axO > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.axO);
                }
                if (this.axP > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.axP);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
