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
    private boolean eKs;

    public d() {
        this.eTw = true;
        this.eTp = R.color.cp_cont_a;
        this.eTr = R.color.cp_link_tip_a;
        this.eKs = false;
        this.minWidth = this.minHeight;
        this.eTA = this.eTz;
    }

    public void qc(@ColorRes int i) {
        this.eTp = i;
        this.eTr = R.color.cp_btn_j;
        this.eKs = false;
        if (this.eTD != null) {
            this.eTD.bqJ();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void a(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        a(i, iconType);
    }

    public void a(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        this.eTs[0] = i;
        this.eTt = iconType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ae(float f) {
        return ah(f);
    }

    private Drawable ah(float f) {
        return this.eKs ? af(f) : ai(f);
    }

    private Drawable ai(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ap.getColor(this.ajq, this.eTr));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable af(float f) {
        GradientDrawable gradientDrawable;
        int color = ap.getColor(this.ajq, this.eTr);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.Jg(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.eTC);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.eTC, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
