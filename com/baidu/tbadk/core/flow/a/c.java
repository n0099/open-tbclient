package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int adX;
    private int adY;
    private int adZ;
    private int aea;
    private int aeb;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cr(int i) {
        this.adX = i;
    }

    public int tW() {
        return this.adX;
    }

    public int tX() {
        return this.adY;
    }

    public final void cs(int i) {
        this.adY = i;
    }

    public final void setSpacing(int i) {
        this.adZ = i;
    }

    public final void ct(int i) {
        this.aea = i;
    }

    public void cu(int i) {
        this.aeb = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.adZ > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.adZ));
            }
            if (this.adX > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.adX));
            }
            if (this.adY > 0) {
                indicatorView.setSelector(resources.getDrawable(this.adY));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.aea > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.aea);
                }
                if (this.aeb > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.aeb);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
