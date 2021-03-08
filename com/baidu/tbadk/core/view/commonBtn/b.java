package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends TBSpecificationButtonConfig {
    private boolean foP;

    public b() {
        this.foB = R.color.CAM_X0302;
        this.foP = true;
    }

    public void pS(@ColorRes int i) {
        this.foB = i;
        this.foP = true;
        this.foM = true;
        if (this.foO != null) {
            this.foO.buX();
        }
    }

    public void pT(@ColorRes int i) {
        this.foB = i;
        this.foD = R.color.CAM_X0211;
        this.foP = false;
        this.foM = true;
        if (this.foO != null) {
            this.foO.buX();
        }
    }

    public void bva() {
        this.foB = R.color.CAM_X0101;
        this.foD = R.color.CAM_X0904;
        this.foP = false;
        this.foM = true;
        if (this.foO != null) {
            this.foO.buX();
        }
    }

    public void pU(@ColorRes int i) {
        this.foB = i;
        this.foD = R.color.CAM_X0903;
        this.foP = false;
        if (this.foO != null) {
            this.foO.buX();
        }
    }

    public void aY(@ColorRes int i, @ColorRes int i2) {
        this.foD = i;
        this.foB = i2;
        this.foP = false;
        if (this.foO != null) {
            this.foO.buX();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ao(float f) {
        return aq(f);
    }

    private Drawable aq(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.foP) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(this.foM ? ap.getColor(this.aln, this.foB) : this.foB, 0.08f));
        } else {
            gradientDrawable.setColor(ap.getColor(this.aln, this.foD));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
