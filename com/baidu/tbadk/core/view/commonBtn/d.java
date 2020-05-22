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
    private boolean dYC;

    public d() {
        this.dYn = R.color.cp_link_tip_a;
        this.dYC = false;
    }

    public void ml(@ColorInt int i) {
        this.dYn = i;
        this.dYC = false;
        this.dYy = false;
        if (this.dYA != null) {
            this.dYA.aWW();
        }
    }

    public void aXa() {
        this.dYn = R.color.cp_cont_a;
        this.dYC = false;
        this.dYy = true;
        if (this.dYA != null) {
            this.dYA.aWW();
        }
    }

    public void mk(@ColorRes int i) {
        this.dYn = i;
        this.dYo = R.color.cp_btn_b;
        this.dYC = true;
        this.dYy = true;
        if (this.dYA != null) {
            this.dYA.aWW();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable T(float f) {
        return V(f);
    }

    private Drawable V(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dYC) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), am.getColor(this.dYo));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(this.dYy ? am.getColor(this.dYn) : this.dYn, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
