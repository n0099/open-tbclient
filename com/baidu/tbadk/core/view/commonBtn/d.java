package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class d extends TBSpecificationButtonConfig {
    private boolean eno;

    public d() {
        this.ewI = true;
        this.ewB = R.color.cp_cont_a;
        this.ewD = R.color.cp_link_tip_a;
        this.eno = false;
        this.minWidth = this.minHeight;
        this.ewM = this.ewL;
    }

    public void pf(@ColorRes int i) {
        this.ewB = i;
        this.ewD = R.color.cp_btn_j;
        this.eno = false;
        if (this.ewP != null) {
            this.ewP.bll();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void a(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        a(i, iconType);
    }

    public void a(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        this.ewE[0] = i;
        this.ewF = iconType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aa(float f) {
        return ad(f);
    }

    private Drawable ad(float f) {
        return this.eno ? ab(f) : ae(f);
    }

    private Drawable ae(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ap.getColor(this.aiB, this.ewD));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable ab(float f) {
        GradientDrawable gradientDrawable;
        int color = ap.getColor(this.aiB, this.ewD);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.HF(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.ewO);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.ewO, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
