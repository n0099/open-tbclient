package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private boolean egD;

    public c() {
        this.ego = R.color.cp_link_tip_a;
        this.egD = true;
    }

    public void mC(@ColorRes int i) {
        this.ego = i;
        this.egD = true;
        this.egA = true;
        if (this.egC != null) {
            this.egC.aYR();
        }
    }

    public void mD(@ColorRes int i) {
        this.ego = i;
        this.egq = R.color.cp_btn_a;
        this.egD = false;
        this.egA = true;
        if (this.egC != null) {
            this.egC.aYR();
        }
    }

    public void aYU() {
        this.ego = R.color.cp_cont_a;
        this.egq = R.color.cp_btn_j;
        this.egD = false;
        this.egA = true;
        if (this.egC != null) {
            this.egC.aYR();
        }
    }

    public void mE(@ColorRes int i) {
        this.ego = i;
        this.egq = R.color.cp_btn_c;
        this.egD = false;
        if (this.egC != null) {
            this.egC.aYR();
        }
    }

    public void aS(@ColorRes int i, @ColorRes int i2) {
        this.egq = i;
        this.ego = i2;
        this.egD = false;
        if (this.egC != null) {
            this.egC.aYR();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable V(float f) {
        return X(f);
    }

    private Drawable X(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.egD) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(this.egA ? an.getColor(this.ego) : this.ego, 0.08f));
        } else {
            gradientDrawable.setColor(an.getColor(this.egq));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
