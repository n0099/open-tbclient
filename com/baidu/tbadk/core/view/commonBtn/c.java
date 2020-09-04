package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends TBSpecificationButtonConfig {
    private boolean ewV;

    public c() {
        this.ewF = R.color.cp_link_tip_a;
        this.ewV = false;
    }

    public void pb(@ColorRes int i) {
        this.ewF = i;
        this.ewV = false;
        this.ewR = true;
        if (this.ewT != null) {
            this.ewT.bll();
        }
    }

    public void pe(@ColorInt int i) {
        this.ewF = i;
        this.ewV = false;
        this.ewR = false;
        if (this.ewT != null) {
            this.ewT.bll();
        }
    }

    public void blp() {
        this.ewF = R.color.cp_cont_a;
        this.ewV = false;
        this.ewR = true;
        if (this.ewT != null) {
            this.ewT.bll();
        }
    }

    public void pd(@ColorRes int i) {
        this.ewF = i;
        this.ewG = R.color.cp_btn_b;
        this.ewV = true;
        this.ewR = true;
        if (this.ewT != null) {
            this.ewT.bll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aa(float f) {
        return ac(f);
    }

    private Drawable ac(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.ewV) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), ap.getColor(this.aiD, this.ewG));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(this.ewR ? ap.getColor(this.aiD, this.ewF) : this.ewF, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
