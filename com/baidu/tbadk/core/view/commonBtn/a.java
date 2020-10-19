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
        this.eKT = R.color.cp_cont_a;
        this.eKV = R.color.cp_link_tip_a;
    }

    public void pN(@ColorRes int i) {
        this.eKV = i;
        this.eKT = R.color.cp_cont_a;
        this.eLf = true;
        if (this.eLh != null) {
            this.eLh.boQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ac(float f) {
        return ad(f);
    }

    private Drawable ad(float f) {
        GradientDrawable gradientDrawable;
        if (!this.eLf) {
            this.eKT = ap.getColor(this.ajp, R.color.cp_cont_a);
        }
        int color = this.eLf ? ap.getColor(this.ajp, this.eKV) : this.eKV;
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
