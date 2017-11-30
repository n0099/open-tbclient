package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int acU;
    private int acV;
    private int acW;
    private int acX;
    private int acY;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cv(int i) {
        this.acU = i;
    }

    public int tF() {
        return this.acU;
    }

    public int tG() {
        return this.acV;
    }

    public final void cw(int i) {
        this.acV = i;
    }

    public final void setSpacing(int i) {
        this.acW = i;
    }

    public final void cx(int i) {
        this.acX = i;
    }

    public void cy(int i) {
        this.acY = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.acW > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.acW));
            }
            if (this.acU > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.acU));
            }
            if (this.acV > 0) {
                indicatorView.setSelector(resources.getDrawable(this.acV));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.acX > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.acX);
                }
                if (this.acY > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.acY);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
