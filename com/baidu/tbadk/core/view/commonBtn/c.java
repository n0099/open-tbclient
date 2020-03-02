package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private boolean djN;

    public c() {
        this.djA = R.color.cp_link_tip_a;
        this.djN = true;
    }

    public void ls(@ColorRes int i) {
        this.djA = i;
        this.djN = true;
        this.djL = true;
        if (this.djM != null) {
            this.djM.aIq();
        }
    }

    public void lt(@ColorRes int i) {
        this.djA = i;
        this.djC = R.color.cp_btn_a;
        this.djN = false;
        this.djL = true;
        if (this.djM != null) {
            this.djM.aIq();
        }
    }

    public void aIt() {
        this.djA = R.color.cp_cont_a;
        this.djC = R.color.cp_btn_j;
        this.djN = false;
        this.djL = true;
        if (this.djM != null) {
            this.djM.aIq();
        }
    }

    public void lu(@ColorRes int i) {
        this.djA = i;
        this.djC = R.color.cp_btn_c;
        this.djN = false;
        if (this.djM != null) {
            this.djM.aIq();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable ak(float f) {
        return am(f);
    }

    private Drawable am(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.djN) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.n(this.djL ? am.getColor(this.djA) : this.djA, 0.08f));
        } else {
            gradientDrawable.setColor(am.getColor(this.djC));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
