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
    private boolean djN;

    public d() {
        this.djz = R.color.cp_link_tip_a;
        this.djN = false;
    }

    public void lv(@ColorInt int i) {
        this.djz = i;
        this.djN = false;
        this.djK = false;
        if (this.djL != null) {
            this.djL.aIo();
        }
    }

    public void aIs() {
        this.djz = R.color.cp_cont_a;
        this.djN = false;
        this.djK = true;
        if (this.djL != null) {
            this.djL.aIo();
        }
    }

    public void lu(@ColorRes int i) {
        this.djz = i;
        this.djA = R.color.cp_btn_b;
        this.djN = true;
        this.djK = true;
        if (this.djL != null) {
            this.djL.aIo();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable ak(float f) {
        return am(f);
    }

    private Drawable am(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.djN) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), am.getColor(this.djA));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.n(this.djK ? am.getColor(this.djz) : this.djz, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
