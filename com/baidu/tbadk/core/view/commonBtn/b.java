package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends TBSpecificationButtonConfig {
    private boolean fkX;

    public b() {
        this.fkJ = R.color.CAM_X0302;
        this.fkX = true;
    }

    public void pM(@ColorRes int i) {
        this.fkJ = i;
        this.fkX = true;
        this.fkU = true;
        if (this.fkW != null) {
            this.fkW.buA();
        }
    }

    public void pN(@ColorRes int i) {
        this.fkJ = i;
        this.fkL = R.color.CAM_X0211;
        this.fkX = false;
        this.fkU = true;
        if (this.fkW != null) {
            this.fkW.buA();
        }
    }

    public void buD() {
        this.fkJ = R.color.CAM_X0101;
        this.fkL = R.color.CAM_X0904;
        this.fkX = false;
        this.fkU = true;
        if (this.fkW != null) {
            this.fkW.buA();
        }
    }

    public void pO(@ColorRes int i) {
        this.fkJ = i;
        this.fkL = R.color.CAM_X0903;
        this.fkX = false;
        if (this.fkW != null) {
            this.fkW.buA();
        }
    }

    public void bb(@ColorRes int i, @ColorRes int i2) {
        this.fkL = i;
        this.fkJ = i2;
        this.fkX = false;
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
        if (this.fkX) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(this.fkU ? ao.getColor(this.akf, this.fkJ) : this.fkJ, 0.08f));
        } else {
            gradientDrawable.setColor(ao.getColor(this.akf, this.fkL));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
