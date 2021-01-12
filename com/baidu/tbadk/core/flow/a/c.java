package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int eUf;
    private int eVa;
    private int eVb;
    private int eVc;
    private int eVd;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void ok(int i) {
        this.eUf = i;
    }

    public int bqV() {
        return this.eUf;
    }

    public int bqW() {
        return this.eVa;
    }

    public final void ol(int i) {
        this.eVa = i;
    }

    public final void setSpacing(int i) {
        this.eVb = i;
    }

    public final void om(int i) {
        this.eVc = i;
    }

    public void on(int i) {
        this.eVd = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.eVb > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.eVb));
            }
            if (this.eUf > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.eUf));
            }
            if (this.eVa > 0) {
                indicatorView.setSelector(resources.getDrawable(this.eVa));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.eVc > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.eVc);
                }
                if (this.eVd > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.eVd);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
