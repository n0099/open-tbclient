package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int Yt;
    private int Yu;
    private int Yv;
    private int Yw;
    private int Yx;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setDrawableId(int i) {
        this.Yt = i;
    }

    public int tR() {
        return this.Yt;
    }

    public int getSelectedId() {
        return this.Yu;
    }

    public final void cf(int i) {
        this.Yu = i;
    }

    public final void setSpacing(int i) {
        this.Yv = i;
    }

    public final void cg(int i) {
        this.Yw = i;
    }

    public void ch(int i) {
        this.Yx = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.Yv > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.Yv));
            }
            if (this.Yt > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.Yt));
            }
            if (this.Yu > 0) {
                indicatorView.setSelector(resources.getDrawable(this.Yu));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.Yw > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.Yw);
                }
                if (this.Yx > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.Yx);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
