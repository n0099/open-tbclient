package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int Zt;
    private int Zu;
    private int Zv;
    private int Zw;
    private int Zx;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setDrawableId(int i) {
        this.Zt = i;
    }

    public int uF() {
        return this.Zt;
    }

    public int uG() {
        return this.Zu;
    }

    public final void cr(int i) {
        this.Zu = i;
    }

    public final void setSpacing(int i) {
        this.Zv = i;
    }

    public final void cs(int i) {
        this.Zw = i;
    }

    public void ct(int i) {
        this.Zx = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.Zv > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.Zv));
            }
            if (this.Zt > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.Zt));
            }
            if (this.Zu > 0) {
                indicatorView.setSelector(resources.getDrawable(this.Zu));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.Zw > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.Zw);
                }
                if (this.Zx > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.Zx);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
