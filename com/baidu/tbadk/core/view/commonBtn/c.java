package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private boolean dKh;

    public c() {
        this.dJT = R.color.cp_link_tip_a;
        this.dKh = true;
    }

    public void lG(@ColorRes int i) {
        this.dJT = i;
        this.dKh = true;
        this.dKe = true;
        if (this.dKg != null) {
            this.dKg.aQR();
        }
    }

    public void lH(@ColorRes int i) {
        this.dJT = i;
        this.dJV = R.color.cp_btn_a;
        this.dKh = false;
        this.dKe = true;
        if (this.dKg != null) {
            this.dKg.aQR();
        }
    }

    public void aQU() {
        this.dJT = R.color.cp_cont_a;
        this.dJV = R.color.cp_btn_j;
        this.dKh = false;
        this.dKe = true;
        if (this.dKg != null) {
            this.dKg.aQR();
        }
    }

    public void lI(@ColorRes int i) {
        this.dJT = i;
        this.dJV = R.color.cp_btn_c;
        this.dKh = false;
        if (this.dKg != null) {
            this.dKg.aQR();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable U(float f) {
        return W(f);
    }

    private Drawable W(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dKh) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(this.dKe ? am.getColor(this.dJT) : this.dJT, 0.08f));
        } else {
            gradientDrawable.setColor(am.getColor(this.dJV));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
