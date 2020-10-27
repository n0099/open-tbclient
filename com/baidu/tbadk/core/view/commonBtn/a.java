package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends TBSpecificationButtonConfig {
    public a() {
        this.eTp = R.color.cp_cont_a;
        this.eTr = R.color.cp_link_tip_a;
    }

    public void pY(@ColorRes int i) {
        this.eTr = i;
        this.eTp = R.color.cp_cont_a;
        this.eTB = true;
        if (this.eTD != null) {
            this.eTD.bqJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ae(float f) {
        return af(f);
    }

    private Drawable af(float f) {
        GradientDrawable gradientDrawable;
        if (!this.eTB) {
            this.eTp = ap.getColor(this.ajq, R.color.cp_cont_a);
        }
        int color = this.eTB ? ap.getColor(this.ajq, this.eTr) : this.eTr;
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
