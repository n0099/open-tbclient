package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int bNM;
    private int bNN;
    private int bNO;
    private int bNP;
    private int bNQ;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void hH(int i) {
        this.bNM = i;
    }

    public int agk() {
        return this.bNM;
    }

    public int agl() {
        return this.bNN;
    }

    public final void hI(int i) {
        this.bNN = i;
    }

    public final void setSpacing(int i) {
        this.bNO = i;
    }

    public final void hJ(int i) {
        this.bNP = i;
    }

    public void hK(int i) {
        this.bNQ = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.bNO > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.bNO));
            }
            if (this.bNM > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.bNM));
            }
            if (this.bNN > 0) {
                indicatorView.setSelector(resources.getDrawable(this.bNN));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.bNP > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.bNP);
                }
                if (this.bNQ > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.bNQ);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
