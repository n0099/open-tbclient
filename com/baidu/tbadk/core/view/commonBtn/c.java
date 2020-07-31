package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private boolean emM;

    public c() {
        this.emy = R.color.cp_link_tip_a;
        this.emM = true;
    }

    public void mV(@ColorRes int i) {
        this.emy = i;
        this.emM = true;
        this.emJ = true;
        if (this.emL != null) {
            this.emL.bcO();
        }
    }

    public void mW(@ColorRes int i) {
        this.emy = i;
        this.emA = R.color.cp_btn_a;
        this.emM = false;
        this.emJ = true;
        if (this.emL != null) {
            this.emL.bcO();
        }
    }

    public void bcR() {
        this.emy = R.color.cp_cont_a;
        this.emA = R.color.cp_btn_j;
        this.emM = false;
        this.emJ = true;
        if (this.emL != null) {
            this.emL.bcO();
        }
    }

    public void mX(@ColorRes int i) {
        this.emy = i;
        this.emA = R.color.cp_btn_c;
        this.emM = false;
        if (this.emL != null) {
            this.emL.bcO();
        }
    }

    public void aT(@ColorRes int i, @ColorRes int i2) {
        this.emA = i;
        this.emy = i2;
        this.emM = false;
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
        if (this.emM) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(this.emJ ? ao.getColor(this.emy) : this.emy, 0.08f));
        } else {
            gradientDrawable.setColor(ao.getColor(this.emA));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
