package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private boolean dka;

    public c() {
        this.djN = R.color.cp_link_tip_a;
        this.dka = true;
    }

    public void ls(@ColorRes int i) {
        this.djN = i;
        this.dka = true;
        this.djY = true;
        if (this.djZ != null) {
            this.djZ.aIr();
        }
    }

    public void lt(@ColorRes int i) {
        this.djN = i;
        this.djP = R.color.cp_btn_a;
        this.dka = false;
        this.djY = true;
        if (this.djZ != null) {
            this.djZ.aIr();
        }
    }

    public void aIu() {
        this.djN = R.color.cp_cont_a;
        this.djP = R.color.cp_btn_j;
        this.dka = false;
        this.djY = true;
        if (this.djZ != null) {
            this.djZ.aIr();
        }
    }

    public void lu(@ColorRes int i) {
        this.djN = i;
        this.djP = R.color.cp_btn_c;
        this.dka = false;
        if (this.djZ != null) {
            this.djZ.aIr();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable ak(float f) {
        return am(f);
    }

    private Drawable am(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dka) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.n(this.djY ? am.getColor(this.djN) : this.djN, 0.08f));
        } else {
            gradientDrawable.setColor(am.getColor(this.djP));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
