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
    private boolean dfv;

    public d() {
        this.dfh = R.color.cp_link_tip_a;
        this.dfv = false;
    }

    public void le(@ColorInt int i) {
        this.dfh = i;
        this.dfv = false;
        this.dfs = false;
        if (this.dft != null) {
            this.dft.aFG();
        }
    }

    public void aFK() {
        this.dfh = R.color.cp_cont_a;
        this.dfv = false;
        this.dfs = true;
        if (this.dft != null) {
            this.dft.aFG();
        }
    }

    public void ld(@ColorRes int i) {
        this.dfh = i;
        this.dfi = R.color.cp_btn_b;
        this.dfv = true;
        this.dfs = true;
        if (this.dft != null) {
            this.dft.aFG();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable am(float f) {
        return ao(f);
    }

    private Drawable ao(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dfv) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), am.getColor(this.dfi));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.n(this.dfs ? am.getColor(this.dfh) : this.dfh, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
