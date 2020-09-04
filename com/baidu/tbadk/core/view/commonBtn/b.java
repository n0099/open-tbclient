package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends TBSpecificationButtonConfig {
    private boolean ewU;

    public b() {
        this.ewF = R.color.cp_link_tip_a;
        this.ewU = true;
    }

    public void pb(@ColorRes int i) {
        this.ewF = i;
        this.ewU = true;
        this.ewR = true;
        if (this.ewT != null) {
            this.ewT.bll();
        }
    }

    public void pc(@ColorRes int i) {
        this.ewF = i;
        this.ewH = R.color.cp_btn_a;
        this.ewU = false;
        this.ewR = true;
        if (this.ewT != null) {
            this.ewT.bll();
        }
    }

    public void blo() {
        this.ewF = R.color.cp_cont_a;
        this.ewH = R.color.cp_btn_j;
        this.ewU = false;
        this.ewR = true;
        if (this.ewT != null) {
            this.ewT.bll();
        }
    }

    public void pd(@ColorRes int i) {
        this.ewF = i;
        this.ewH = R.color.cp_btn_c;
        this.ewU = false;
        if (this.ewT != null) {
            this.ewT.bll();
        }
    }

    public void bb(@ColorRes int i, @ColorRes int i2) {
        this.ewH = i;
        this.ewF = i2;
        this.ewU = false;
        if (this.ewT != null) {
            this.ewT.bll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aa(float f) {
        return ac(f);
    }

    private Drawable ac(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.ewU) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(this.ewR ? ap.getColor(this.aiD, this.ewF) : this.ewF, 0.08f));
        } else {
            gradientDrawable.setColor(ap.getColor(this.aiD, this.ewH));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
