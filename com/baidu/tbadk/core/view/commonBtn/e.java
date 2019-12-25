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
    private boolean cYc;

    public e() {
        this.cYc = false;
        this.dfn = true;
        this.dfh = R.color.cp_cont_a;
        this.dfj = R.color.cp_link_tip_a;
        this.cYc = false;
        this.dfr = this.bek;
        this.dfq = this.dfp;
    }

    public void lf(@ColorRes int i) {
        this.dfh = i;
        this.dfj = R.color.cp_btn_j;
        this.cYc = false;
        if (this.dft != null) {
            this.dft.aFG();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.a
    @Deprecated
    public void j(int i, int i2, boolean z) {
        w(i, z);
    }

    public void w(@DrawableRes int i, boolean z) {
        this.dfk[0] = i;
        this.cQV = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable am(float f) {
        return ap(f);
    }

    private Drawable ap(float f) {
        return this.cYc ? an(f) : aq(f);
    }

    private Drawable aq(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(am.getColor(this.dfj));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable an(float f) {
        GradientDrawable gradientDrawable;
        int color = am.getColor(this.dfj);
        int[] iArr = {com.baidu.tieba.tbadkCore.c.Ca(color), color};
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
