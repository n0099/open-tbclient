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
    private boolean dQC;

    public e() {
        this.dQC = false;
        this.dYt = true;
        this.dYn = R.color.cp_cont_a;
        this.dYp = R.color.cp_link_tip_a;
        this.dQC = false;
        this.dYx = this.bQI;
        this.dYw = this.dYv;
    }

    public void mo(@ColorRes int i) {
        this.dYn = i;
        this.dYp = R.color.cp_btn_j;
        this.dQC = false;
        if (this.dYA != null) {
            this.dYA.aWX();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.a
    @Deprecated
    public void k(int i, int i2, boolean z) {
        C(i, z);
    }

    public void C(@DrawableRes int i, boolean z) {
        this.dYq[0] = i;
        this.dIG = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable T(float f) {
        return W(f);
    }

    private Drawable W(float f) {
        return this.dQC ? U(f) : X(f);
    }

    private Drawable X(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(am.getColor(this.dYp));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable U(float f) {
        GradientDrawable gradientDrawable;
        int color = am.getColor(this.dYp);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.DK(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.dYz);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.dYz, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
