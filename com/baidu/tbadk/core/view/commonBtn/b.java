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
        this.dJX = R.color.cp_cont_a;
        this.dJZ = R.color.cp_link_tip_a;
    }

    public void lG(@ColorRes int i) {
        this.dJZ = i;
        this.dJX = R.color.cp_cont_a;
        this.dKi = true;
        if (this.dKk != null) {
            this.dKk.aQO();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable U(float f) {
        return V(f);
    }

    private Drawable V(float f) {
        GradientDrawable gradientDrawable;
        if (!this.dKi) {
            this.dJX = am.getColor(R.color.cp_cont_a);
        }
        int color = this.dKi ? am.getColor(this.dJZ) : this.dJZ;
        int[] iArr = {com.baidu.tieba.tbadkCore.c.CY(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.dKj);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.dKj, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
