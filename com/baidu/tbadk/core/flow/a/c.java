package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int bGg;
    private int bGh;
    private int bGi;
    private int bGj;
    private int bGk;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void gU(int i) {
        this.bGg = i;
    }

    public int abv() {
        return this.bGg;
    }

    public int abw() {
        return this.bGh;
    }

    public final void gV(int i) {
        this.bGh = i;
    }

    public final void setSpacing(int i) {
        this.bGi = i;
    }

    public final void gW(int i) {
        this.bGj = i;
    }

    public void gX(int i) {
        this.bGk = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.bGi > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.bGi));
            }
            if (this.bGg > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.bGg));
            }
            if (this.bGh > 0) {
                indicatorView.setSelector(resources.getDrawable(this.bGh));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.bGj > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.bGj);
                }
                if (this.bGk > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.bGk);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
