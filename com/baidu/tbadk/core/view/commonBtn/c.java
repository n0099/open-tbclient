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
    private boolean eTF;

    public c() {
        this.eTp = R.color.cp_link_tip_a;
        this.eTF = false;
    }

    public void pY(@ColorRes int i) {
        this.eTp = i;
        this.eTF = false;
        this.eTB = true;
        if (this.eTD != null) {
            this.eTD.bqJ();
        }
    }

    public void qb(@ColorInt int i) {
        this.eTp = i;
        this.eTF = false;
        this.eTB = false;
        if (this.eTD != null) {
            this.eTD.bqJ();
        }
    }

    public void bqN() {
        this.eTp = R.color.cp_cont_a;
        this.eTF = false;
        this.eTB = true;
        if (this.eTD != null) {
            this.eTD.bqJ();
        }
    }

    public void qa(@ColorRes int i) {
        this.eTp = i;
        this.eTq = R.color.cp_btn_b;
        this.eTF = true;
        this.eTB = true;
        if (this.eTD != null) {
            this.eTD.bqJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ae(float f) {
        return ag(f);
    }

    private Drawable ag(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.eTF) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), ap.getColor(this.ajq, this.eTq));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.m(this.eTB ? ap.getColor(this.ajq, this.eTp) : this.eTp, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
