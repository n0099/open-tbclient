package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int adg;
    private int adh;
    private int adi;
    private int adj;
    private int adk;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cv(int i) {
        this.adg = i;
    }

    public int tL() {
        return this.adg;
    }

    public int tM() {
        return this.adh;
    }

    public final void cw(int i) {
        this.adh = i;
    }

    public final void setSpacing(int i) {
        this.adi = i;
    }

    public final void cx(int i) {
        this.adj = i;
    }

    public void cy(int i) {
        this.adk = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.adi > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.adi));
            }
            if (this.adg > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.adg));
            }
            if (this.adh > 0) {
                indicatorView.setSelector(resources.getDrawable(this.adh));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.adj > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.adj);
                }
                if (this.adk > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.adk);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
