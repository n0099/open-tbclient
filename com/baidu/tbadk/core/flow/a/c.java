package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int SG;
    private int SH;
    private int SI;
    private int SJ;
    private int SL;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setDrawableId(int i) {
        this.SG = i;
    }

    public final void bM(int i) {
        this.SH = i;
    }

    public final void setSpacing(int i) {
        this.SI = i;
    }

    public final void bN(int i) {
        this.SJ = i;
    }

    public void bO(int i) {
        this.SL = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.SI > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.SI));
            }
            if (this.SG > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.SG));
            }
            if (this.SH > 0) {
                indicatorView.setSelector(resources.getDrawable(this.SH));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.SJ > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.SJ);
                }
                if (this.SL > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.SL);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
