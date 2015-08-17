package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int XA;
    private int XB;
    private int XC;
    private int XD;
    private int XE;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setDrawableId(int i) {
        this.XA = i;
    }

    public int tk() {
        return this.XA;
    }

    public int getSelectedId() {
        return this.XB;
    }

    public final void bU(int i) {
        this.XB = i;
    }

    public final void setSpacing(int i) {
        this.XC = i;
    }

    public final void bV(int i) {
        this.XD = i;
    }

    public void bW(int i) {
        this.XE = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.XC > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.XC));
            }
            if (this.XA > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.XA));
            }
            if (this.XB > 0) {
                indicatorView.setSelector(resources.getDrawable(this.XB));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.XD > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.XD);
                }
                if (this.XE > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.XE);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
