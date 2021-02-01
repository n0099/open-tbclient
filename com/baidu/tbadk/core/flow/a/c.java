package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int eWv;
    private int eXq;
    private int eXr;
    private int eXs;
    private int eXt;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void op(int i) {
        this.eWv = i;
    }

    public int bro() {
        return this.eWv;
    }

    public int brp() {
        return this.eXq;
    }

    public final void oq(int i) {
        this.eXq = i;
    }

    public final void setSpacing(int i) {
        this.eXr = i;
    }

    public final void or(int i) {
        this.eXs = i;
    }

    public void os(int i) {
        this.eXt = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.eXr > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.eXr));
            }
            if (this.eWv > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.eWv));
            }
            if (this.eXq > 0) {
                indicatorView.setSelector(resources.getDrawable(this.eXq));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.eXs > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.eXs);
                }
                if (this.eXt > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.eXt);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
