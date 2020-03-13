package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e extends a {
    private boolean dcE;

    public e() {
        this.dcE = false;
        this.djT = true;
        this.djN = R.color.cp_cont_a;
        this.djP = R.color.cp_link_tip_a;
        this.dcE = false;
        this.djX = this.bjq;
        this.djW = this.djV;
    }

    public void lw(@ColorRes int i) {
        this.djN = i;
        this.djP = R.color.cp_btn_j;
        this.dcE = false;
        if (this.djZ != null) {
            this.djZ.aIr();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.a
    @Deprecated
    public void k(int i, int i2, boolean z) {
        w(i, z);
    }

    public void w(@DrawableRes int i, boolean z) {
        this.djQ[0] = i;
        this.cVj = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable ak(float f) {
        return an(f);
    }

    private Drawable an(float f) {
        return this.dcE ? al(f) : ao(f);
    }

    private Drawable ao(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(am.getColor(this.djP));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable al(float f) {
        GradientDrawable gradientDrawable;
        int color = am.getColor(this.djP);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.Cm(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
