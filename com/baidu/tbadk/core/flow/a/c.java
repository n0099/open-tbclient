package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int cgA;
    private int cgw;
    private int cgx;
    private int cgy;
    private int cgz;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void ii(int i) {
        this.cgw = i;
    }

    public int alp() {
        return this.cgw;
    }

    public int alq() {
        return this.cgx;
    }

    public final void ij(int i) {
        this.cgx = i;
    }

    public final void setSpacing(int i) {
        this.cgy = i;
    }

    public final void ik(int i) {
        this.cgz = i;
    }

    public void il(int i) {
        this.cgA = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.cgy > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.cgy));
            }
            if (this.cgw > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.cgw));
            }
            if (this.cgx > 0) {
                indicatorView.setSelector(resources.getDrawable(this.cgx));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.cgz > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.cgz);
                }
                if (this.cgA > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.cgA);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
