package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private boolean dkn;

    public c() {
        this.dka = R.color.cp_link_tip_a;
        this.dkn = true;
    }

    public void lu(@ColorRes int i) {
        this.dka = i;
        this.dkn = true;
        this.dkl = true;
        if (this.dkm != null) {
            this.dkm.aIv();
        }
    }

    public void lv(@ColorRes int i) {
        this.dka = i;
        this.dkc = R.color.cp_btn_a;
        this.dkn = false;
        this.dkl = true;
        if (this.dkm != null) {
            this.dkm.aIv();
        }
    }

    public void aIy() {
        this.dka = R.color.cp_cont_a;
        this.dkc = R.color.cp_btn_j;
        this.dkn = false;
        this.dkl = true;
        if (this.dkm != null) {
            this.dkm.aIv();
        }
    }

    public void lw(@ColorRes int i) {
        this.dka = i;
        this.dkc = R.color.cp_btn_c;
        this.dkn = false;
        if (this.dkm != null) {
            this.dkm.aIv();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable ak(float f) {
        return am(f);
    }

    private Drawable am(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dkn) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.n(this.dkl ? am.getColor(this.dka) : this.dka, 0.08f));
        } else {
            gradientDrawable.setColor(am.getColor(this.dkc));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
