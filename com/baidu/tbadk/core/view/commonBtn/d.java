package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends a {
    private boolean emN;

    public d() {
        this.emy = R.color.cp_link_tip_a;
        this.emN = false;
    }

    public void mV(@ColorRes int i) {
        this.emy = i;
        this.emN = false;
        this.emJ = true;
        if (this.emL != null) {
            this.emL.bcO();
        }
    }

    public void mY(@ColorInt int i) {
        this.emy = i;
        this.emN = false;
        this.emJ = false;
        if (this.emL != null) {
            this.emL.bcO();
        }
    }

    public void bcS() {
        this.emy = R.color.cp_cont_a;
        this.emN = false;
        this.emJ = true;
        if (this.emL != null) {
            this.emL.bcO();
        }
    }

    public void mX(@ColorRes int i) {
        this.emy = i;
        this.emz = R.color.cp_btn_b;
        this.emN = true;
        this.emJ = true;
        if (this.emL != null) {
            this.emL.bcO();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable V(float f) {
        return X(f);
    }

    private Drawable X(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.emN) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), ao.getColor(this.emz));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(this.emJ ? ao.getColor(this.emy) : this.emy, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
