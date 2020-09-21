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
    private boolean ezc;

    public c() {
        this.eyM = R.color.cp_link_tip_a;
        this.ezc = false;
    }

    public void pp(@ColorRes int i) {
        this.eyM = i;
        this.ezc = false;
        this.eyY = true;
        if (this.eza != null) {
            this.eza.bmg();
        }
    }

    public void ps(@ColorInt int i) {
        this.eyM = i;
        this.ezc = false;
        this.eyY = false;
        if (this.eza != null) {
            this.eza.bmg();
        }
    }

    public void bmk() {
        this.eyM = R.color.cp_cont_a;
        this.ezc = false;
        this.eyY = true;
        if (this.eza != null) {
            this.eza.bmg();
        }
    }

    public void pr(@ColorRes int i) {
        this.eyM = i;
        this.eyN = R.color.cp_btn_b;
        this.ezc = true;
        this.eyY = true;
        if (this.eza != null) {
            this.eza.bmg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aa(float f) {
        return ac(f);
    }

    private Drawable ac(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.ezc) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), ap.getColor(this.aiX, this.eyN));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(this.eyY ? ap.getColor(this.aiX, this.eyM) : this.eyM, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
