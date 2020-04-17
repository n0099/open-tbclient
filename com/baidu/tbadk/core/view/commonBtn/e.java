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
    private boolean dCr;

    public e() {
        this.dCr = false;
        this.dJZ = true;
        this.dJT = R.color.cp_cont_a;
        this.dJV = R.color.cp_link_tip_a;
        this.dCr = false;
        this.dKd = this.bHL;
        this.dKc = this.dKb;
    }

    public void lK(@ColorRes int i) {
        this.dJT = i;
        this.dJV = R.color.cp_btn_j;
        this.dCr = false;
        if (this.dKg != null) {
            this.dKg.aQR();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.a
    @Deprecated
    public void k(int i, int i2, boolean z) {
        z(i, z);
    }

    public void z(@DrawableRes int i, boolean z) {
        this.dJW[0] = i;
        this.duH = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable U(float f) {
        return X(f);
    }

    private Drawable X(float f) {
        return this.dCr ? V(f) : Y(f);
    }

    private Drawable Y(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(am.getColor(this.dJV));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable V(float f) {
        GradientDrawable gradientDrawable;
        int color = am.getColor(this.dJV);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.CY(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.dKf);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.dKf, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
