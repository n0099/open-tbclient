package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private boolean dYB;

    public c() {
        this.dYn = R.color.cp_link_tip_a;
        this.dYB = true;
    }

    public void mk(@ColorRes int i) {
        this.dYn = i;
        this.dYB = true;
        this.dYy = true;
        if (this.dYA != null) {
            this.dYA.aWX();
        }
    }

    public void ml(@ColorRes int i) {
        this.dYn = i;
        this.dYp = R.color.cp_btn_a;
        this.dYB = false;
        this.dYy = true;
        if (this.dYA != null) {
            this.dYA.aWX();
        }
    }

    public void aXa() {
        this.dYn = R.color.cp_cont_a;
        this.dYp = R.color.cp_btn_j;
        this.dYB = false;
        this.dYy = true;
        if (this.dYA != null) {
            this.dYA.aWX();
        }
    }

    public void mm(@ColorRes int i) {
        this.dYn = i;
        this.dYp = R.color.cp_btn_c;
        this.dYB = false;
        if (this.dYA != null) {
            this.dYA.aWX();
        }
    }

    public void aO(@ColorRes int i, @ColorRes int i2) {
        this.dYp = i;
        this.dYn = i2;
        this.dYB = false;
        if (this.dYA != null) {
            this.dYA.aWX();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable T(float f) {
        return V(f);
    }

    private Drawable V(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dYB) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(this.dYy ? am.getColor(this.dYn) : this.dYn, 0.08f));
        } else {
            gradientDrawable.setColor(am.getColor(this.dYp));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
