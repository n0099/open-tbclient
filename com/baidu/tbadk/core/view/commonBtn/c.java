package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private boolean dfG;

    public c() {
        this.dft = R.color.cp_link_tip_a;
        this.dfG = true;
    }

    public void lb(@ColorRes int i) {
        this.dft = i;
        this.dfG = true;
        this.dfE = true;
        if (this.dfF != null) {
            this.dfF.aFZ();
        }
    }

    public void lc(@ColorRes int i) {
        this.dft = i;
        this.dfv = R.color.cp_btn_a;
        this.dfG = false;
        this.dfE = true;
        if (this.dfF != null) {
            this.dfF.aFZ();
        }
    }

    public void aGc() {
        this.dft = R.color.cp_cont_a;
        this.dfv = R.color.cp_btn_j;
        this.dfG = false;
        this.dfE = true;
        if (this.dfF != null) {
            this.dfF.aFZ();
        }
    }

    public void ld(@ColorRes int i) {
        this.dft = i;
        this.dfv = R.color.cp_btn_c;
        this.dfG = false;
        if (this.dfF != null) {
            this.dfF.aFZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable al(float f) {
        return an(f);
    }

    private Drawable an(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dfG) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.n(this.dfE ? am.getColor(this.dft) : this.dft, 0.08f));
        } else {
            gradientDrawable.setColor(am.getColor(this.dfv));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
