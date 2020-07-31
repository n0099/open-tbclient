package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e extends a {
    private boolean edO;

    public e() {
        this.edO = false;
        this.emE = true;
        this.emy = R.color.cp_cont_a;
        this.emA = R.color.cp_link_tip_a;
        this.edO = false;
        this.minWidth = this.minHeight;
        this.emI = this.emH;
    }

    public void mZ(@ColorRes int i) {
        this.emy = i;
        this.emA = R.color.cp_btn_j;
        this.edO = false;
        if (this.emL != null) {
            this.emL.bcO();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.a
    @Deprecated
    public void k(int i, int i2, boolean z) {
        D(i, z);
    }

    public void D(@DrawableRes int i, boolean z) {
        this.emB[0] = i;
        this.dVO = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable V(float f) {
        return Y(f);
    }

    private Drawable Y(float f) {
        return this.edO ? W(f) : Z(f);
    }

    private Drawable Z(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ao.getColor(this.emA));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable W(float f) {
        GradientDrawable gradientDrawable;
        int color = ao.getColor(this.emA);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.Fi(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.emK);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.emK, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
