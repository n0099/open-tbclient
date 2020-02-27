package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private boolean djM;

    public c() {
        this.djz = R.color.cp_link_tip_a;
        this.djM = true;
    }

    public void ls(@ColorRes int i) {
        this.djz = i;
        this.djM = true;
        this.djK = true;
        if (this.djL != null) {
            this.djL.aIo();
        }
    }

    public void lt(@ColorRes int i) {
        this.djz = i;
        this.djB = R.color.cp_btn_a;
        this.djM = false;
        this.djK = true;
        if (this.djL != null) {
            this.djL.aIo();
        }
    }

    public void aIr() {
        this.djz = R.color.cp_cont_a;
        this.djB = R.color.cp_btn_j;
        this.djM = false;
        this.djK = true;
        if (this.djL != null) {
            this.djL.aIo();
        }
    }

    public void lu(@ColorRes int i) {
        this.djz = i;
        this.djB = R.color.cp_btn_c;
        this.djM = false;
        if (this.djL != null) {
            this.djL.aIo();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable ak(float f) {
        return am(f);
    }

    private Drawable am(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.djM) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.n(this.djK ? am.getColor(this.djz) : this.djz, 0.08f));
        } else {
            gradientDrawable.setColor(am.getColor(this.djB));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
