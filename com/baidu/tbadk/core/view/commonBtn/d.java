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
    private boolean epK;

    public d() {
        this.eyT = true;
        this.eyM = R.color.cp_cont_a;
        this.eyO = R.color.cp_link_tip_a;
        this.epK = false;
        this.minWidth = this.minHeight;
        this.eyX = this.eyW;
    }

    public void pt(@ColorRes int i) {
        this.eyM = i;
        this.eyO = R.color.cp_btn_j;
        this.epK = false;
        if (this.eza != null) {
            this.eza.bmg();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void a(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        a(i, iconType);
    }

    public void a(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        this.eyP[0] = i;
        this.eyQ = iconType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aa(float f) {
        return ad(f);
    }

    private Drawable ad(float f) {
        return this.epK ? ab(f) : ae(f);
    }

    private Drawable ae(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ap.getColor(this.aiX, this.eyO));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable ab(float f) {
        GradientDrawable gradientDrawable;
        int color = ap.getColor(this.aiX, this.eyO);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.Ii(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.eyZ);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.eyZ, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
