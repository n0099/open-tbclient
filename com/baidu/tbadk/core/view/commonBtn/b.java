package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends TBSpecificationButtonConfig {
    private boolean fpH;

    public b() {
        this.fpt = R.color.CAM_X0302;
        this.fpH = true;
    }

    public void rs(@ColorRes int i) {
        this.fpt = i;
        this.fpH = true;
        this.fpE = true;
        if (this.fpG != null) {
            this.fpG.byt();
        }
    }

    public void rt(@ColorRes int i) {
        this.fpt = i;
        this.fpv = R.color.CAM_X0211;
        this.fpH = false;
        this.fpE = true;
        if (this.fpG != null) {
            this.fpG.byt();
        }
    }

    public void byw() {
        this.fpt = R.color.CAM_X0101;
        this.fpv = R.color.CAM_X0904;
        this.fpH = false;
        this.fpE = true;
        if (this.fpG != null) {
            this.fpG.byt();
        }
    }

    public void ru(@ColorRes int i) {
        this.fpt = i;
        this.fpv = R.color.CAM_X0903;
        this.fpH = false;
        if (this.fpG != null) {
            this.fpG.byt();
        }
    }

    public void bb(@ColorRes int i, @ColorRes int i2) {
        this.fpv = i;
        this.fpt = i2;
        this.fpH = false;
        if (this.fpG != null) {
            this.fpG.byt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aj(float f) {
        return al(f);
    }

    private Drawable al(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.fpH) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(this.fpE ? ao.getColor(this.akW, this.fpt) : this.fpt, 0.08f));
        } else {
            gradientDrawable.setColor(ao.getColor(this.akW, this.fpv));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
