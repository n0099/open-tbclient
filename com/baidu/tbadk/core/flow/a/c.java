package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int alZ;
    private int ama;
    private int amb;
    private int amc;
    private int amd;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void ct(int i) {
        this.alZ = i;
    }

    public int xu() {
        return this.alZ;
    }

    public int xv() {
        return this.ama;
    }

    public final void cu(int i) {
        this.ama = i;
    }

    public final void setSpacing(int i) {
        this.amb = i;
    }

    public final void cv(int i) {
        this.amc = i;
    }

    public void cw(int i) {
        this.amd = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.amb > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.amb));
            }
            if (this.alZ > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.alZ));
            }
            if (this.ama > 0) {
                indicatorView.setSelector(resources.getDrawable(this.ama));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.amc > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.amc);
                }
                if (this.amd > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.amd);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
