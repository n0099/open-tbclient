package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int RY;
    private int RZ;
    private int Sa;
    private int Sb;
    private int Sc;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setDrawableId(int i) {
        this.RY = i;
    }

    public final void bI(int i) {
        this.RZ = i;
    }

    public final void setSpacing(int i) {
        this.Sa = i;
    }

    public final void bJ(int i) {
        this.Sb = i;
    }

    public void bK(int i) {
        this.Sc = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.Sa > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.Sa));
            }
            if (this.RY > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.RY));
            }
            if (this.RZ > 0) {
                indicatorView.setSelector(resources.getDrawable(this.RZ));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.Sb > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.Sb);
                }
                if (this.Sc > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.Sc);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
