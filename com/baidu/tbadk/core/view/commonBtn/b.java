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
        this.dYn = R.color.cp_cont_a;
        this.dYp = R.color.cp_link_tip_a;
    }

    public void mk(@ColorRes int i) {
        this.dYp = i;
        this.dYn = R.color.cp_cont_a;
        this.dYy = true;
        if (this.dYA != null) {
            this.dYA.aWX();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable T(float f) {
        return U(f);
    }

    private Drawable U(float f) {
        GradientDrawable gradientDrawable;
        if (!this.dYy) {
            this.dYn = am.getColor(R.color.cp_cont_a);
        }
        int color = this.dYy ? am.getColor(this.dYp) : this.dYp;
        int[] iArr = {com.baidu.tieba.tbadkCore.c.DK(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.dYz);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.dYz, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
