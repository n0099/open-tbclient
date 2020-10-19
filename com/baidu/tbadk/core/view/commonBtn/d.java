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
    private boolean eBW;

    public d() {
        this.eLa = true;
        this.eKT = R.color.cp_cont_a;
        this.eKV = R.color.cp_link_tip_a;
        this.eBW = false;
        this.minWidth = this.minHeight;
        this.eLe = this.eLd;
    }

    public void pR(@ColorRes int i) {
        this.eKT = i;
        this.eKV = R.color.cp_btn_j;
        this.eBW = false;
        if (this.eLh != null) {
            this.eLh.boQ();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void a(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        a(i, iconType);
    }

    public void a(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        this.eKW[0] = i;
        this.eKX = iconType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ac(float f) {
        return af(f);
    }

    private Drawable af(float f) {
        return this.eBW ? ad(f) : ag(f);
    }

    private Drawable ag(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ap.getColor(this.ajp, this.eKV));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable ad(float f) {
        GradientDrawable gradientDrawable;
        int color = ap.getColor(this.ajp, this.eKV);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.IO(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.eLg);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.eLg, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
