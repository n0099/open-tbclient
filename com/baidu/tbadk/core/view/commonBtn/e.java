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
    private boolean dcq;

    public e() {
        this.dcq = false;
        this.djG = true;
        this.djA = R.color.cp_cont_a;
        this.djC = R.color.cp_link_tip_a;
        this.dcq = false;
        this.djK = this.bjp;
        this.djJ = this.djI;
    }

    public void lw(@ColorRes int i) {
        this.djA = i;
        this.djC = R.color.cp_btn_j;
        this.dcq = false;
        if (this.djM != null) {
            this.djM.aIq();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.a
    @Deprecated
    public void k(int i, int i2, boolean z) {
        w(i, z);
    }

    public void w(@DrawableRes int i, boolean z) {
        this.djD[0] = i;
        this.cVi = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable ak(float f) {
        return an(f);
    }

    private Drawable an(float f) {
        return this.dcq ? al(f) : ao(f);
    }

    private Drawable ao(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(am.getColor(this.djC));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable al(float f) {
        GradientDrawable gradientDrawable;
        int color = am.getColor(this.djC);
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
