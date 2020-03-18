package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends a {
    public b() {
        this.dka = R.color.cp_cont_a;
        this.dkc = R.color.cp_link_tip_a;
    }

    public void lu(@ColorRes int i) {
        this.dkc = i;
        this.dka = R.color.cp_cont_a;
        this.dkl = true;
        if (this.dkm != null) {
            this.dkm.aIv();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable ak(float f) {
        return al(f);
    }

    private Drawable al(float f) {
        GradientDrawable gradientDrawable;
        if (!this.dkl) {
            this.dka = am.getColor(R.color.cp_cont_a);
        }
        int color = this.dkl ? am.getColor(this.dkc) : this.dkc;
        int[] iArr = {com.baidu.tieba.tbadkCore.c.Cu(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
