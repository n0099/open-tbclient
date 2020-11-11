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
        this.eZe = R.color.cp_cont_a;
        this.eZg = R.color.cp_link_tip_a;
    }

    public void qi(@ColorRes int i) {
        this.eZg = i;
        this.eZe = R.color.cp_cont_a;
        this.eZq = true;
        if (this.eZs != null) {
            this.eZs.btj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ag(float f) {
        return ah(f);
    }

    private Drawable ah(float f) {
        GradientDrawable gradientDrawable;
        if (!this.eZq) {
            this.eZe = ap.getColor(this.ajq, R.color.cp_cont_a);
        }
        int color = this.eZq ? ap.getColor(this.ajq, this.eZg) : this.eZg;
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
