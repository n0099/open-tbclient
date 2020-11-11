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
    private boolean eQh;

    public d() {
        this.eZl = true;
        this.eZe = R.color.cp_cont_a;
        this.eZg = R.color.cp_link_tip_a;
        this.eQh = false;
        this.minWidth = this.minHeight;
        this.eZp = this.eZo;
    }

    public void qm(@ColorRes int i) {
        this.eZe = i;
        this.eZg = R.color.cp_btn_j;
        this.eQh = false;
        if (this.eZs != null) {
            this.eZs.btj();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void a(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        a(i, iconType);
    }

    public void a(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        this.eZh[0] = i;
        this.eZi = iconType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ag(float f) {
        return aj(f);
    }

    private Drawable aj(float f) {
        return this.eQh ? ah(f) : ak(f);
    }

    private Drawable ak(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ap.getColor(this.ajq, this.eZg));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable ah(float f) {
        GradientDrawable gradientDrawable;
        int color = ap.getColor(this.ajq, this.eZg);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.Jt(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.eZr);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.eZr, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
