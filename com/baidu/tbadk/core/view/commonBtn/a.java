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
        this.eyM = R.color.cp_cont_a;
        this.eyO = R.color.cp_link_tip_a;
    }

    public void pp(@ColorRes int i) {
        this.eyO = i;
        this.eyM = R.color.cp_cont_a;
        this.eyY = true;
        if (this.eza != null) {
            this.eza.bmg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aa(float f) {
        return ab(f);
    }

    private Drawable ab(float f) {
        GradientDrawable gradientDrawable;
        if (!this.eyY) {
            this.eyM = ap.getColor(this.aiX, R.color.cp_cont_a);
        }
        int color = this.eyY ? ap.getColor(this.aiX, this.eyO) : this.eyO;
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
