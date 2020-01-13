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
    private boolean dfH;

    public d() {
        this.dft = R.color.cp_link_tip_a;
        this.dfH = false;
    }

    public void le(@ColorInt int i) {
        this.dft = i;
        this.dfH = false;
        this.dfE = false;
        if (this.dfF != null) {
            this.dfF.aFZ();
        }
    }

    public void aGd() {
        this.dft = R.color.cp_cont_a;
        this.dfH = false;
        this.dfE = true;
        if (this.dfF != null) {
            this.dfF.aFZ();
        }
    }

    public void ld(@ColorRes int i) {
        this.dft = i;
        this.dfu = R.color.cp_btn_b;
        this.dfH = true;
        this.dfE = true;
        if (this.dfF != null) {
            this.dfF.aFZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable al(float f) {
        return an(f);
    }

    private Drawable an(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dfH) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), am.getColor(this.dfu));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.n(this.dfE ? am.getColor(this.dft) : this.dft, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
