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
        this.ewF = R.color.cp_cont_a;
        this.ewH = R.color.cp_link_tip_a;
    }

    public void pb(@ColorRes int i) {
        this.ewH = i;
        this.ewF = R.color.cp_cont_a;
        this.ewR = true;
        if (this.ewT != null) {
            this.ewT.bll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aa(float f) {
        return ab(f);
    }

    private Drawable ab(float f) {
        GradientDrawable gradientDrawable;
        if (!this.ewR) {
            this.ewF = ap.getColor(this.aiD, R.color.cp_cont_a);
        }
        int color = this.ewR ? ap.getColor(this.aiD, this.ewH) : this.ewH;
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
