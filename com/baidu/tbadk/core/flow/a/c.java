package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int abA;
    private int abB;
    private int abC;
    private int aby;
    private int abz;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cp(int i) {
        this.aby = i;
    }

    public int tN() {
        return this.aby;
    }

    public int tO() {
        return this.abz;
    }

    public final void cq(int i) {
        this.abz = i;
    }

    public final void setSpacing(int i) {
        this.abA = i;
    }

    public final void cr(int i) {
        this.abB = i;
    }

    public void cs(int i) {
        this.abC = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.abA > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.abA));
            }
            if (this.aby > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.aby));
            }
            if (this.abz > 0) {
                indicatorView.setSelector(resources.getDrawable(this.abz));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.abB > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.abB);
                }
                if (this.abC > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.abC);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
