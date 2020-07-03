package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e extends a {
    private boolean dXu;

    public e() {
        this.dXu = false;
        this.egu = true;
        this.ego = R.color.cp_cont_a;
        this.egq = R.color.cp_link_tip_a;
        this.dXu = false;
        this.egz = this.bVw;
        this.egy = this.egx;
    }

    public void mG(@ColorRes int i) {
        this.ego = i;
        this.egq = R.color.cp_btn_j;
        this.dXu = false;
        if (this.egC != null) {
            this.egC.aYR();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.a
    @Deprecated
    public void k(int i, int i2, boolean z) {
        D(i, z);
    }

    public void D(@DrawableRes int i, boolean z) {
        this.egr[0] = i;
        this.dPw = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable V(float f) {
        return Y(f);
    }

    private Drawable Y(float f) {
        return this.dXu ? W(f) : Z(f);
    }

    private Drawable Z(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(an.getColor(this.egq));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable W(float f) {
        GradientDrawable gradientDrawable;
        int color = an.getColor(this.egq);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.EM(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.egB);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.egB, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
