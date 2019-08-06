package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int bOS;
    private int bOT;
    private int bOU;
    private int bOV;
    private int bOW;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void hN(int i) {
        this.bOS = i;
    }

    public int aho() {
        return this.bOS;
    }

    public int ahp() {
        return this.bOT;
    }

    public final void hO(int i) {
        this.bOT = i;
    }

    public final void setSpacing(int i) {
        this.bOU = i;
    }

    public final void hP(int i) {
        this.bOV = i;
    }

    public void hQ(int i) {
        this.bOW = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.bOU > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.bOU));
            }
            if (this.bOS > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.bOS));
            }
            if (this.bOT > 0) {
                indicatorView.setSelector(resources.getDrawable(this.bOT));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.bOV > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.bOV);
                }
                if (this.bOW > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.bOW);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
