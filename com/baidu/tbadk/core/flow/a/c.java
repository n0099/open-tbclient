package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int bNL;
    private int bNM;
    private int bNN;
    private int bNO;
    private int bNP;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void hH(int i) {
        this.bNL = i;
    }

    public int agk() {
        return this.bNL;
    }

    public int agl() {
        return this.bNM;
    }

    public final void hI(int i) {
        this.bNM = i;
    }

    public final void setSpacing(int i) {
        this.bNN = i;
    }

    public final void hJ(int i) {
        this.bNO = i;
    }

    public void hK(int i) {
        this.bNP = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.bNN > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.bNN));
            }
            if (this.bNL > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.bNL));
            }
            if (this.bNM > 0) {
                indicatorView.setSelector(resources.getDrawable(this.bNM));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.bNO > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.bNO);
                }
                if (this.bNP > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.bNP);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
