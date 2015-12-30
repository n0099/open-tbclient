package com.baidu.tbadk.core.flow.a;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class c {
    private int YW;
    private int YX;
    private int YY;
    private int YZ;
    private int Za;
    private int gravity;

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setDrawableId(int i) {
        this.YW = i;
    }

    public int tB() {
        return this.YW;
    }

    public int getSelectedId() {
        return this.YX;
    }

    public final void bY(int i) {
        this.YX = i;
    }

    public final void setSpacing(int i) {
        this.YY = i;
    }

    public final void bZ(int i) {
        this.YZ = i;
    }

    public void ca(int i) {
        this.Za = i;
    }

    public void g(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView != null && (resources = indicatorView.getResources()) != null) {
            if (this.YY > 0) {
                indicatorView.setSpacing(resources.getDimensionPixelSize(this.YY));
            }
            if (this.YW > 0) {
                indicatorView.setDrawable(resources.getDrawable(this.YW));
            }
            if (this.YX > 0) {
                indicatorView.setSelector(resources.getDrawable(this.YX));
            }
            ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = this.gravity;
                if (this.YZ > 0) {
                    layoutParams2.bottomMargin = resources.getDimensionPixelSize(this.YZ);
                }
                if (this.Za > 0) {
                    layoutParams2.rightMargin = resources.getDimensionPixelSize(this.Za);
                }
                indicatorView.setLayoutParams(layoutParams);
            }
        }
    }
}
