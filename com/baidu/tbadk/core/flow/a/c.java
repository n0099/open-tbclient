package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int bOM;
    private int bON;
    private int bOO;
    private int bOP;
    private int bOQ;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void hN(int i) {
        this.bOM = i;
    }

    public int ahm() {
        return this.bOM;
    }

    public int ahn() {
        return this.bON;
    }

    public final void hO(int i) {
        this.bON = i;
    }

    public final void setSpacing(int i) {
        this.bOO = i;
    }

    public final void hP(int i) {
        this.bOP = i;
    }

    public void hQ(int i) {
        this.bOQ = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.bOO > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.bOO));
            }
            if (this.bOM > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.bOM));
            }
            if (this.bON > 0) {
                indicatorView.setSelector(resources.getDrawable(this.bON));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.bOP > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.bOP);
                }
                if (this.bOQ > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.bOQ);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
