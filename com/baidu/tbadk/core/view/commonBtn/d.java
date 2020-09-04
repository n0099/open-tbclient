package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends TBSpecificationButtonConfig {
    private boolean ens;

    public d() {
        this.ewM = true;
        this.ewF = R.color.cp_cont_a;
        this.ewH = R.color.cp_link_tip_a;
        this.ens = false;
        this.minWidth = this.minHeight;
        this.ewQ = this.ewP;
    }

    public void pf(@ColorRes int i) {
        this.ewF = i;
        this.ewH = R.color.cp_btn_j;
        this.ens = false;
        if (this.ewT != null) {
            this.ewT.bll();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void a(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        a(i, iconType);
    }

    public void a(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        this.ewI[0] = i;
        this.ewJ = iconType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aa(float f) {
        return ad(f);
    }

    private Drawable ad(float f) {
        return this.ens ? ab(f) : ae(f);
    }

    private Drawable ae(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ap.getColor(this.aiD, this.ewH));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable ab(float f) {
        GradientDrawable gradientDrawable;
        int color = ap.getColor(this.aiD, this.ewH);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.HF(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.ewS);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.ewS, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
