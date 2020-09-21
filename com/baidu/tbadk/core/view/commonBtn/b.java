package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends TBSpecificationButtonConfig {
    private boolean ezb;

    public b() {
        this.eyM = R.color.cp_link_tip_a;
        this.ezb = true;
    }

    public void pp(@ColorRes int i) {
        this.eyM = i;
        this.ezb = true;
        this.eyY = true;
        if (this.eza != null) {
            this.eza.bmg();
        }
    }

    public void pq(@ColorRes int i) {
        this.eyM = i;
        this.eyO = R.color.cp_btn_a;
        this.ezb = false;
        this.eyY = true;
        if (this.eza != null) {
            this.eza.bmg();
        }
    }

    public void bmj() {
        this.eyM = R.color.cp_cont_a;
        this.eyO = R.color.cp_btn_j;
        this.ezb = false;
        this.eyY = true;
        if (this.eza != null) {
            this.eza.bmg();
        }
    }

    public void pr(@ColorRes int i) {
        this.eyM = i;
        this.eyO = R.color.cp_btn_c;
        this.ezb = false;
        if (this.eza != null) {
            this.eza.bmg();
        }
    }

    public void bb(@ColorRes int i, @ColorRes int i2) {
        this.eyO = i;
        this.eyM = i2;
        this.ezb = false;
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
        if (this.ezb) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(this.eyY ? ap.getColor(this.aiX, this.eyM) : this.eyM, 0.08f));
        } else {
            gradientDrawable.setColor(ap.getColor(this.aiX, this.eyO));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
