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
    private boolean djO;

    public d() {
        this.djA = R.color.cp_link_tip_a;
        this.djO = false;
    }

    public void lv(@ColorInt int i) {
        this.djA = i;
        this.djO = false;
        this.djL = false;
        if (this.djM != null) {
            this.djM.aIq();
        }
    }

    public void aIu() {
        this.djA = R.color.cp_cont_a;
        this.djO = false;
        this.djL = true;
        if (this.djM != null) {
            this.djM.aIq();
        }
    }

    public void lu(@ColorRes int i) {
        this.djA = i;
        this.djB = R.color.cp_btn_b;
        this.djO = true;
        this.djL = true;
        if (this.djM != null) {
            this.djM.aIq();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable ak(float f) {
        return am(f);
    }

    private Drawable am(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.djO) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), am.getColor(this.djB));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.n(this.djL ? am.getColor(this.djA) : this.djA, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
