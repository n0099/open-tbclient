package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends TBSpecificationButtonConfig {
    private boolean eLj;

    public c() {
        this.eKT = R.color.cp_link_tip_a;
        this.eLj = false;
    }

    public void pN(@ColorRes int i) {
        this.eKT = i;
        this.eLj = false;
        this.eLf = true;
        if (this.eLh != null) {
            this.eLh.boQ();
        }
    }

    public void pQ(@ColorInt int i) {
        this.eKT = i;
        this.eLj = false;
        this.eLf = false;
        if (this.eLh != null) {
            this.eLh.boQ();
        }
    }

    public void boU() {
        this.eKT = R.color.cp_cont_a;
        this.eLj = false;
        this.eLf = true;
        if (this.eLh != null) {
            this.eLh.boQ();
        }
    }

    public void pP(@ColorRes int i) {
        this.eKT = i;
        this.eKU = R.color.cp_btn_b;
        this.eLj = true;
        this.eLf = true;
        if (this.eLh != null) {
            this.eLh.boQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ac(float f) {
        return ae(f);
    }

    private Drawable ae(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.eLj) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), ap.getColor(this.ajp, this.eKU));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.m(this.eLf ? ap.getColor(this.ajp, this.eKT) : this.eKT, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
