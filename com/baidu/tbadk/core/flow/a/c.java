package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int RW;
    private int RX;
    private int RY;
    private int RZ;
    private int Sa;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setDrawableId(int i) {
        this.RW = i;
    }

    public final void bI(int i) {
        this.RX = i;
    }

    public final void setSpacing(int i) {
        this.RY = i;
    }

    public final void bJ(int i) {
        this.RZ = i;
    }

    public void bK(int i) {
        this.Sa = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.RY > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.RY));
            }
            if (this.RW > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.RW));
            }
            if (this.RX > 0) {
                indicatorView.setSelector(resources.getDrawable(this.RX));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.RZ > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.RZ);
                }
                if (this.Sa > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.Sa);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
