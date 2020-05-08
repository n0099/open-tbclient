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
    private boolean dKm;

    public d() {
        this.dJX = R.color.cp_link_tip_a;
        this.dKm = false;
    }

    public void lJ(@ColorInt int i) {
        this.dJX = i;
        this.dKm = false;
        this.dKi = false;
        if (this.dKk != null) {
            this.dKk.aQO();
        }
    }

    public void aQS() {
        this.dJX = R.color.cp_cont_a;
        this.dKm = false;
        this.dKi = true;
        if (this.dKk != null) {
            this.dKk.aQO();
        }
    }

    public void lI(@ColorRes int i) {
        this.dJX = i;
        this.dJY = R.color.cp_btn_b;
        this.dKm = true;
        this.dKi = true;
        if (this.dKk != null) {
            this.dKk.aQO();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable U(float f) {
        return W(f);
    }

    private Drawable W(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dKm) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), am.getColor(this.dJY));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(this.dKi ? am.getColor(this.dJX) : this.dJX, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
