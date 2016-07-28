package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int Ua;
    private int Ub;
    private int Uc;
    private int Ud;
    private int Ue;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void ce(int i) {
        this.Ua = i;
    }

    public int sn() {
        return this.Ua;
    }

    public int so() {
        return this.Ub;
    }

    public final void cf(int i) {
        this.Ub = i;
    }

    public final void setSpacing(int i) {
        this.Uc = i;
    }

    public final void cg(int i) {
        this.Ud = i;
    }

    public void ch(int i) {
        this.Ue = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.Uc > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.Uc));
            }
            if (this.Ua > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.Ua));
            }
            if (this.Ub > 0) {
                indicatorView.setSelector(resources.getDrawable(this.Ub));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.Ud > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.Ud);
                }
                if (this.Ue > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.Ue);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
