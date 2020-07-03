package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends a {
    private boolean egE;

    public d() {
        this.ego = R.color.cp_link_tip_a;
        this.egE = false;
    }

    public void mF(@ColorInt int i) {
        this.ego = i;
        this.egE = false;
        this.egA = false;
        if (this.egC != null) {
            this.egC.aYR();
        }
    }

    public void aYV() {
        this.ego = R.color.cp_cont_a;
        this.egE = false;
        this.egA = true;
        if (this.egC != null) {
            this.egC.aYR();
        }
    }

    public void mE(@ColorRes int i) {
        this.ego = i;
        this.egp = R.color.cp_btn_b;
        this.egE = true;
        this.egA = true;
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
        if (this.egE) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), an.getColor(this.egp));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(this.egA ? an.getColor(this.ego) : this.ego, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
