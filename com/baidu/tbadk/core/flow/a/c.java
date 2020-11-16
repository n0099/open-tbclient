package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int eHH;
    private int eIB;
    private int eIC;
    private int eID;
    private int eIE;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void pg(int i) {
        this.eHH = i;
    }

    public int boS() {
        return this.eHH;
    }

    public int boT() {
        return this.eIB;
    }

    public final void ph(int i) {
        this.eIB = i;
    }

    public final void setSpacing(int i) {
        this.eIC = i;
    }

    public final void pi(int i) {
        this.eID = i;
    }

    public void pj(int i) {
        this.eIE = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.eIC > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.eIC));
            }
            if (this.eHH > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.eHH));
            }
            if (this.eIB > 0) {
                indicatorView.setSelector(resources.getDrawable(this.eIB));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.eID > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.eID);
                }
                if (this.eIE > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.eIE);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
