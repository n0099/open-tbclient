package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int aoF;
    private int aoG;
    private int aoH;
    private int aoI;
    private int aoJ;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cG(int i) {
        this.aoF = i;
    }

    public int yF() {
        return this.aoF;
    }

    public int yG() {
        return this.aoG;
    }

    public final void cH(int i) {
        this.aoG = i;
    }

    public final void setSpacing(int i) {
        this.aoH = i;
    }

    public final void cI(int i) {
        this.aoI = i;
    }

    public void cJ(int i) {
        this.aoJ = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.aoH > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.aoH));
            }
            if (this.aoF > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.aoF));
            }
            if (this.aoG > 0) {
                indicatorView.setSelector(resources.getDrawable(this.aoG));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.aoI > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.aoI);
                }
                if (this.aoJ > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.aoJ);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
