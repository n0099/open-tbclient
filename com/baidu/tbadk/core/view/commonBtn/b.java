package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends TBSpecificationButtonConfig {
    private boolean eZt;

    public b() {
        this.eZe = R.color.cp_link_tip_a;
        this.eZt = true;
    }

    public void qi(@ColorRes int i) {
        this.eZe = i;
        this.eZt = true;
        this.eZq = true;
        if (this.eZs != null) {
            this.eZs.btj();
        }
    }

    public void qj(@ColorRes int i) {
        this.eZe = i;
        this.eZg = R.color.cp_btn_a;
        this.eZt = false;
        this.eZq = true;
        if (this.eZs != null) {
            this.eZs.btj();
        }
    }

    public void btm() {
        this.eZe = R.color.cp_cont_a;
        this.eZg = R.color.cp_btn_j;
        this.eZt = false;
        this.eZq = true;
        if (this.eZs != null) {
            this.eZs.btj();
        }
    }

    public void qk(@ColorRes int i) {
        this.eZe = i;
        this.eZg = R.color.cp_btn_c;
        this.eZt = false;
        if (this.eZs != null) {
            this.eZs.btj();
        }
    }

    public void bb(@ColorRes int i, @ColorRes int i2) {
        this.eZg = i;
        this.eZe = i2;
        this.eZt = false;
        if (this.eZs != null) {
            this.eZs.btj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ag(float f) {
        return ai(f);
    }

    private Drawable ai(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.eZt) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(this.eZq ? ap.getColor(this.ajq, this.eZe) : this.eZe, 0.08f));
        } else {
            gradientDrawable.setColor(ap.getColor(this.ajq, this.eZg));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
