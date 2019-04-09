package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int bGl;
    private int bGm;
    private int bGn;
    private int bGo;
    private int bGp;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void gT(int i) {
        this.bGl = i;
    }

    public int abs() {
        return this.bGl;
    }

    public int abt() {
        return this.bGm;
    }

    public final void gU(int i) {
        this.bGm = i;
    }

    public final void setSpacing(int i) {
        this.bGn = i;
    }

    public final void gV(int i) {
        this.bGo = i;
    }

    public void gW(int i) {
        this.bGp = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.bGn > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.bGn));
            }
            if (this.bGl > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.bGl));
            }
            if (this.bGm > 0) {
                indicatorView.setSelector(resources.getDrawable(this.bGm));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.bGo > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.bGo);
                }
                if (this.bGp > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.bGp);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
