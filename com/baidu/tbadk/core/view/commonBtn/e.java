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
    private boolean dCv;

    public e() {
        this.dCv = false;
        this.dKd = true;
        this.dJX = R.color.cp_cont_a;
        this.dJZ = R.color.cp_link_tip_a;
        this.dCv = false;
        this.dKh = this.bHQ;
        this.dKg = this.dKf;
    }

    public void lK(@ColorRes int i) {
        this.dJX = i;
        this.dJZ = R.color.cp_btn_j;
        this.dCv = false;
        if (this.dKk != null) {
            this.dKk.aQO();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.a
    @Deprecated
    public void k(int i, int i2, boolean z) {
        z(i, z);
    }

    public void z(@DrawableRes int i, boolean z) {
        this.dKa[0] = i;
        this.duL = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable U(float f) {
        return X(f);
    }

    private Drawable X(float f) {
        return this.dCv ? V(f) : Y(f);
    }

    private Drawable Y(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(am.getColor(this.dJZ));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable V(float f) {
        GradientDrawable gradientDrawable;
        int color = am.getColor(this.dJZ);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.CY(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.dKj);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.dKj, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
