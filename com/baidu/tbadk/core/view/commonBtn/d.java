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
    private boolean dKi;

    public d() {
        this.dJT = R.color.cp_link_tip_a;
        this.dKi = false;
    }

    public void lJ(@ColorInt int i) {
        this.dJT = i;
        this.dKi = false;
        this.dKe = false;
        if (this.dKg != null) {
            this.dKg.aQR();
        }
    }

    public void aQV() {
        this.dJT = R.color.cp_cont_a;
        this.dKi = false;
        this.dKe = true;
        if (this.dKg != null) {
            this.dKg.aQR();
        }
    }

    public void lI(@ColorRes int i) {
        this.dJT = i;
        this.dJU = R.color.cp_btn_b;
        this.dKi = true;
        this.dKe = true;
        if (this.dKg != null) {
            this.dKg.aQR();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable U(float f) {
        return W(f);
    }

    private Drawable W(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dKi) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), am.getColor(this.dJU));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(this.dKe ? am.getColor(this.dJT) : this.dJT, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
