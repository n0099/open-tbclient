package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends TBSpecificationButtonConfig {
    private boolean ewR;

    public c() {
        this.ewB = R.color.cp_link_tip_a;
        this.ewR = false;
    }

    public void pb(@ColorRes int i) {
        this.ewB = i;
        this.ewR = false;
        this.ewN = true;
        if (this.ewP != null) {
            this.ewP.bll();
        }
    }

    public void pe(@ColorInt int i) {
        this.ewB = i;
        this.ewR = false;
        this.ewN = false;
        if (this.ewP != null) {
            this.ewP.bll();
        }
    }

    public void blp() {
        this.ewB = R.color.cp_cont_a;
        this.ewR = false;
        this.ewN = true;
        if (this.ewP != null) {
            this.ewP.bll();
        }
    }

    public void pd(@ColorRes int i) {
        this.ewB = i;
        this.ewC = R.color.cp_btn_b;
        this.ewR = true;
        this.ewN = true;
        if (this.ewP != null) {
            this.ewP.bll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aa(float f) {
        return ac(f);
    }

    private Drawable ac(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.ewR) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), ap.getColor(this.aiB, this.ewC));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(this.ewN ? ap.getColor(this.aiB, this.ewB) : this.ewB, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
