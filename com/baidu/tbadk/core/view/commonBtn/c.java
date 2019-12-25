package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private boolean dfu;

    public c() {
        this.dfh = R.color.cp_link_tip_a;
        this.dfu = true;
    }

    public void lb(@ColorRes int i) {
        this.dfh = i;
        this.dfu = true;
        this.dfs = true;
        if (this.dft != null) {
            this.dft.aFG();
        }
    }

    public void lc(@ColorRes int i) {
        this.dfh = i;
        this.dfj = R.color.cp_btn_a;
        this.dfu = false;
        this.dfs = true;
        if (this.dft != null) {
            this.dft.aFG();
        }
    }

    public void aFJ() {
        this.dfh = R.color.cp_cont_a;
        this.dfj = R.color.cp_btn_j;
        this.dfu = false;
        this.dfs = true;
        if (this.dft != null) {
            this.dft.aFG();
        }
    }

    public void ld(@ColorRes int i) {
        this.dfh = i;
        this.dfj = R.color.cp_btn_c;
        this.dfu = false;
        if (this.dft != null) {
            this.dft.aFG();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable am(float f) {
        return ao(f);
    }

    private Drawable ao(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dfu) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.n(this.dfs ? am.getColor(this.dfh) : this.dfh, 0.08f));
        } else {
            gradientDrawable.setColor(am.getColor(this.dfj));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
