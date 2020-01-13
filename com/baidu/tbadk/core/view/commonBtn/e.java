package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e extends a {
    private boolean cYm;

    public e() {
        this.cYm = false;
        this.dfz = true;
        this.dft = R.color.cp_cont_a;
        this.dfv = R.color.cp_link_tip_a;
        this.cYm = false;
        this.dfD = this.beZ;
        this.dfC = this.dfB;
    }

    public void lf(@ColorRes int i) {
        this.dft = i;
        this.dfv = R.color.cp_btn_j;
        this.cYm = false;
        if (this.dfF != null) {
            this.dfF.aFZ();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.a
    @Deprecated
    public void j(int i, int i2, boolean z) {
        w(i, z);
    }

    public void w(@DrawableRes int i, boolean z) {
        this.dfw[0] = i;
        this.cRf = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable al(float f) {
        return ao(f);
    }

    private Drawable ao(float f) {
        return this.cYm ? am(f) : ap(f);
    }

    private Drawable ap(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(am.getColor(this.dfv));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable am(float f) {
        GradientDrawable gradientDrawable;
        int color = am.getColor(this.dfv);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.Cf(color), color};
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
