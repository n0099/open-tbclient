package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int ama;
    private int amb;
    private int amc;
    private int amd;
    private int ame;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void cw(int i) {
        this.ama = i;
    }

    public int xy() {
        return this.ama;
    }

    public int xz() {
        return this.amb;
    }

    public final void cx(int i) {
        this.amb = i;
    }

    public final void setSpacing(int i) {
        this.amc = i;
    }

    public final void cy(int i) {
        this.amd = i;
    }

    public void cz(int i) {
        this.ame = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.amc > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.amc));
            }
            if (this.ama > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.ama));
            }
            if (this.amb > 0) {
                indicatorView.setSelector(resources.getDrawable(this.amb));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.amd > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.amd);
                }
                if (this.ame > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.ame);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
