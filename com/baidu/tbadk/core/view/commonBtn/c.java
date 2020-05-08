package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private boolean dKl;

    public c() {
        this.dJX = R.color.cp_link_tip_a;
        this.dKl = true;
    }

    public void lG(@ColorRes int i) {
        this.dJX = i;
        this.dKl = true;
        this.dKi = true;
        if (this.dKk != null) {
            this.dKk.aQO();
        }
    }

    public void lH(@ColorRes int i) {
        this.dJX = i;
        this.dJZ = R.color.cp_btn_a;
        this.dKl = false;
        this.dKi = true;
        if (this.dKk != null) {
            this.dKk.aQO();
        }
    }

    public void aQR() {
        this.dJX = R.color.cp_cont_a;
        this.dJZ = R.color.cp_btn_j;
        this.dKl = false;
        this.dKi = true;
        if (this.dKk != null) {
            this.dKk.aQO();
        }
    }

    public void lI(@ColorRes int i) {
        this.dJX = i;
        this.dJZ = R.color.cp_btn_c;
        this.dKl = false;
        if (this.dKk != null) {
            this.dKk.aQO();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable U(float f) {
        return W(f);
    }

    private Drawable W(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dKl) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(this.dKi ? am.getColor(this.dJX) : this.dJX, 0.08f));
        } else {
            gradientDrawable.setColor(am.getColor(this.dJZ));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
