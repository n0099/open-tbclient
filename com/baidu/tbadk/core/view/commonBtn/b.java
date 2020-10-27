package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends TBSpecificationButtonConfig {
    private boolean eTE;

    public b() {
        this.eTp = R.color.cp_link_tip_a;
        this.eTE = true;
    }

    public void pY(@ColorRes int i) {
        this.eTp = i;
        this.eTE = true;
        this.eTB = true;
        if (this.eTD != null) {
            this.eTD.bqJ();
        }
    }

    public void pZ(@ColorRes int i) {
        this.eTp = i;
        this.eTr = R.color.cp_btn_a;
        this.eTE = false;
        this.eTB = true;
        if (this.eTD != null) {
            this.eTD.bqJ();
        }
    }

    public void bqM() {
        this.eTp = R.color.cp_cont_a;
        this.eTr = R.color.cp_btn_j;
        this.eTE = false;
        this.eTB = true;
        if (this.eTD != null) {
            this.eTD.bqJ();
        }
    }

    public void qa(@ColorRes int i) {
        this.eTp = i;
        this.eTr = R.color.cp_btn_c;
        this.eTE = false;
        if (this.eTD != null) {
            this.eTD.bqJ();
        }
    }

    public void bb(@ColorRes int i, @ColorRes int i2) {
        this.eTr = i;
        this.eTp = i2;
        this.eTE = false;
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
        if (this.eTE) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(this.eTB ? ap.getColor(this.ajq, this.eTp) : this.eTp, 0.08f));
        } else {
            gradientDrawable.setColor(ap.getColor(this.ajq, this.eTr));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
