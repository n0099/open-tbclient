package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends TBSpecificationButtonConfig {
    private boolean eLi;

    public b() {
        this.eKT = R.color.cp_link_tip_a;
        this.eLi = true;
    }

    public void pN(@ColorRes int i) {
        this.eKT = i;
        this.eLi = true;
        this.eLf = true;
        if (this.eLh != null) {
            this.eLh.boQ();
        }
    }

    public void pO(@ColorRes int i) {
        this.eKT = i;
        this.eKV = R.color.cp_btn_a;
        this.eLi = false;
        this.eLf = true;
        if (this.eLh != null) {
            this.eLh.boQ();
        }
    }

    public void boT() {
        this.eKT = R.color.cp_cont_a;
        this.eKV = R.color.cp_btn_j;
        this.eLi = false;
        this.eLf = true;
        if (this.eLh != null) {
            this.eLh.boQ();
        }
    }

    public void pP(@ColorRes int i) {
        this.eKT = i;
        this.eKV = R.color.cp_btn_c;
        this.eLi = false;
        if (this.eLh != null) {
            this.eLh.boQ();
        }
    }

    public void ba(@ColorRes int i, @ColorRes int i2) {
        this.eKV = i;
        this.eKT = i2;
        this.eLi = false;
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
        if (this.eLi) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(this.eLf ? ap.getColor(this.ajp, this.eKT) : this.eKT, 0.08f));
        } else {
            gradientDrawable.setColor(ap.getColor(this.ajp, this.eKV));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
