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
    private boolean fkY;

    public c() {
        this.fkJ = R.color.CAM_X0302;
        this.fkY = false;
    }

    public void pM(@ColorRes int i) {
        this.fkJ = i;
        this.fkY = false;
        this.fkU = true;
        if (this.fkW != null) {
            this.fkW.buA();
        }
    }

    public void pP(@ColorInt int i) {
        this.fkJ = i;
        this.fkY = false;
        this.fkU = false;
        if (this.fkW != null) {
            this.fkW.buA();
        }
    }

    public void buE() {
        this.fkJ = R.color.CAM_X0101;
        this.fkY = false;
        this.fkU = true;
        if (this.fkW != null) {
            this.fkW.buA();
        }
    }

    public void pO(@ColorRes int i) {
        this.fkJ = i;
        this.fkK = R.color.CAM_X0902;
        this.fkY = true;
        this.fkU = true;
        if (this.fkW != null) {
            this.fkW.buA();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aj(float f) {
        return al(f);
    }

    private Drawable al(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.fkY) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), ao.getColor(this.akf, this.fkK));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.m(this.fkU ? ao.getColor(this.akf, this.fkJ) : this.fkJ, com.baidu.tbadk.core.elementsMaven.a.nJ(R.string.A_X07)));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
