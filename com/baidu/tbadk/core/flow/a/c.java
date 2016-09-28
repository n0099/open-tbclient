package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int Xc;
    private int Xd;
    private int Xe;
    private int Xf;
    private int Xg;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cr(int i) {
        this.Xc = i;
    }

    public int tH() {
        return this.Xc;
    }

    public int tI() {
        return this.Xd;
    }

    public final void cs(int i) {
        this.Xd = i;
    }

    public final void setSpacing(int i) {
        this.Xe = i;
    }

    public final void ct(int i) {
        this.Xf = i;
    }

    public void cu(int i) {
        this.Xg = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.Xe > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.Xe));
            }
            if (this.Xc > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.Xc));
            }
            if (this.Xd > 0) {
                indicatorView.setSelector(resources.getDrawable(this.Xd));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.Xf > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.Xf);
                }
                if (this.Xg > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.Xg);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
