package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends a {
    public b() {
        this.ego = R.color.cp_cont_a;
        this.egq = R.color.cp_link_tip_a;
    }

    public void mC(@ColorRes int i) {
        this.egq = i;
        this.ego = R.color.cp_cont_a;
        this.egA = true;
        if (this.egC != null) {
            this.egC.aYR();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable V(float f) {
        return W(f);
    }

    private Drawable W(float f) {
        GradientDrawable gradientDrawable;
        if (!this.egA) {
            this.ego = an.getColor(R.color.cp_cont_a);
        }
        int color = this.egA ? an.getColor(this.egq) : this.egq;
        int[] iArr = {com.baidu.tieba.tbadkCore.c.EM(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.egB);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.egB, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
