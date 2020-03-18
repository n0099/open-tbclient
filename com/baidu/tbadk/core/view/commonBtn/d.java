package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends a {
    private boolean dko;

    public d() {
        this.dka = R.color.cp_link_tip_a;
        this.dko = false;
    }

    public void lx(@ColorInt int i) {
        this.dka = i;
        this.dko = false;
        this.dkl = false;
        if (this.dkm != null) {
            this.dkm.aIv();
        }
    }

    public void aIz() {
        this.dka = R.color.cp_cont_a;
        this.dko = false;
        this.dkl = true;
        if (this.dkm != null) {
            this.dkm.aIv();
        }
    }

    public void lw(@ColorRes int i) {
        this.dka = i;
        this.dkb = R.color.cp_btn_b;
        this.dko = true;
        this.dkl = true;
        if (this.dkm != null) {
            this.dkm.aIv();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable ak(float f) {
        return am(f);
    }

    private Drawable am(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dko) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), am.getColor(this.dkb));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.n(this.dkl ? am.getColor(this.dka) : this.dka, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
