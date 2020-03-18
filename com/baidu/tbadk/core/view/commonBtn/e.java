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
    private boolean dcR;

    public e() {
        this.dcR = false;
        this.dkg = true;
        this.dka = R.color.cp_cont_a;
        this.dkc = R.color.cp_link_tip_a;
        this.dcR = false;
        this.dkk = this.bjD;
        this.dkj = this.dki;
    }

    public void ly(@ColorRes int i) {
        this.dka = i;
        this.dkc = R.color.cp_btn_j;
        this.dcR = false;
        if (this.dkm != null) {
            this.dkm.aIv();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.a
    @Deprecated
    public void k(int i, int i2, boolean z) {
        w(i, z);
    }

    public void w(@DrawableRes int i, boolean z) {
        this.dkd[0] = i;
        this.cVw = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable ak(float f) {
        return an(f);
    }

    private Drawable an(float f) {
        return this.dcR ? al(f) : ao(f);
    }

    private Drawable ao(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(am.getColor(this.dkc));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable al(float f) {
        GradientDrawable gradientDrawable;
        int color = am.getColor(this.dkc);
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
