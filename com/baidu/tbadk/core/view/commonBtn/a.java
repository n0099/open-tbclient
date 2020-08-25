package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends TBSpecificationButtonConfig {
    public a() {
        this.ewB = R.color.cp_cont_a;
        this.ewD = R.color.cp_link_tip_a;
    }

    public void pb(@ColorRes int i) {
        this.ewD = i;
        this.ewB = R.color.cp_cont_a;
        this.ewN = true;
        if (this.ewP != null) {
            this.ewP.bll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aa(float f) {
        return ab(f);
    }

    private Drawable ab(float f) {
        GradientDrawable gradientDrawable;
        if (!this.ewN) {
            this.ewB = ap.getColor(this.aiB, R.color.cp_cont_a);
        }
        int color = this.ewN ? ap.getColor(this.aiB, this.ewD) : this.ewD;
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
