package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends TBSpecificationButtonConfig {
    private boolean fpI;

    public c() {
        this.fpt = R.color.CAM_X0302;
        this.fpI = false;
    }

    public void rs(@ColorRes int i) {
        this.fpt = i;
        this.fpI = false;
        this.fpE = true;
        if (this.fpG != null) {
            this.fpG.byt();
        }
    }

    public void rv(@ColorInt int i) {
        this.fpt = i;
        this.fpI = false;
        this.fpE = false;
        if (this.fpG != null) {
            this.fpG.byt();
        }
    }

    public void byx() {
        this.fpt = R.color.CAM_X0101;
        this.fpI = false;
        this.fpE = true;
        if (this.fpG != null) {
            this.fpG.byt();
        }
    }

    public void ru(@ColorRes int i) {
        this.fpt = i;
        this.fpu = R.color.CAM_X0902;
        this.fpI = true;
        this.fpE = true;
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
        if (this.fpI) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), ao.getColor(this.akW, this.fpu));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.m(this.fpE ? ao.getColor(this.akW, this.fpt) : this.fpt, com.baidu.tbadk.core.elementsMaven.a.pq(R.string.A_X07)));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
