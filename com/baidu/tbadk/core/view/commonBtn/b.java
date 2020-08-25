package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b extends TBSpecificationButtonConfig {
    private boolean ewQ;

    public b() {
        this.ewB = R.color.cp_link_tip_a;
        this.ewQ = true;
    }

    public void pb(@ColorRes int i) {
        this.ewB = i;
        this.ewQ = true;
        this.ewN = true;
        if (this.ewP != null) {
            this.ewP.bll();
        }
    }

    public void pc(@ColorRes int i) {
        this.ewB = i;
        this.ewD = R.color.cp_btn_a;
        this.ewQ = false;
        this.ewN = true;
        if (this.ewP != null) {
            this.ewP.bll();
        }
    }

    public void blo() {
        this.ewB = R.color.cp_cont_a;
        this.ewD = R.color.cp_btn_j;
        this.ewQ = false;
        this.ewN = true;
        if (this.ewP != null) {
            this.ewP.bll();
        }
    }

    public void pd(@ColorRes int i) {
        this.ewB = i;
        this.ewD = R.color.cp_btn_c;
        this.ewQ = false;
        if (this.ewP != null) {
            this.ewP.bll();
        }
    }

    public void bb(@ColorRes int i, @ColorRes int i2) {
        this.ewD = i;
        this.ewB = i2;
        this.ewQ = false;
        if (this.ewP != null) {
            this.ewP.bll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aa(float f) {
        return ac(f);
    }

    private Drawable ac(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.ewQ) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(this.ewN ? ap.getColor(this.aiB, this.ewB) : this.ewB, 0.08f));
        } else {
            gradientDrawable.setColor(ap.getColor(this.aiB, this.ewD));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
