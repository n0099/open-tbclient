package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends a {
    public b() {
        this.emy = R.color.cp_cont_a;
        this.emA = R.color.cp_link_tip_a;
    }

    public void mV(@ColorRes int i) {
        this.emA = i;
        this.emy = R.color.cp_cont_a;
        this.emJ = true;
        if (this.emL != null) {
            this.emL.bcO();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable V(float f) {
        return W(f);
    }

    private Drawable W(float f) {
        GradientDrawable gradientDrawable;
        if (!this.emJ) {
            this.emy = ao.getColor(R.color.cp_cont_a);
        }
        int color = this.emJ ? ao.getColor(this.emA) : this.emA;
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
