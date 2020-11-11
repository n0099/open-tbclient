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
    private boolean eZu;

    public c() {
        this.eZe = R.color.cp_link_tip_a;
        this.eZu = false;
    }

    public void qi(@ColorRes int i) {
        this.eZe = i;
        this.eZu = false;
        this.eZq = true;
        if (this.eZs != null) {
            this.eZs.btj();
        }
    }

    public void ql(@ColorInt int i) {
        this.eZe = i;
        this.eZu = false;
        this.eZq = false;
        if (this.eZs != null) {
            this.eZs.btj();
        }
    }

    public void btn() {
        this.eZe = R.color.cp_cont_a;
        this.eZu = false;
        this.eZq = true;
        if (this.eZs != null) {
            this.eZs.btj();
        }
    }

    public void qk(@ColorRes int i) {
        this.eZe = i;
        this.eZf = R.color.cp_btn_b;
        this.eZu = true;
        this.eZq = true;
        if (this.eZs != null) {
            this.eZs.btj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ag(float f) {
        return ai(f);
    }

    private Drawable ai(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.eZu) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), ap.getColor(this.ajq, this.eZf));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.m(this.eZq ? ap.getColor(this.ajq, this.eZe) : this.eZe, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
