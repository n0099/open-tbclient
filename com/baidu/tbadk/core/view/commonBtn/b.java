package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends TBSpecificationButtonConfig {
    private boolean fnp;

    public b() {
        this.fnb = R.color.CAM_X0302;
        this.fnp = true;
    }

    public void pR(@ColorRes int i) {
        this.fnb = i;
        this.fnp = true;
        this.fnm = true;
        if (this.fno != null) {
            this.fno.buU();
        }
    }

    public void pS(@ColorRes int i) {
        this.fnb = i;
        this.fnd = R.color.CAM_X0211;
        this.fnp = false;
        this.fnm = true;
        if (this.fno != null) {
            this.fno.buU();
        }
    }

    public void buX() {
        this.fnb = R.color.CAM_X0101;
        this.fnd = R.color.CAM_X0904;
        this.fnp = false;
        this.fnm = true;
        if (this.fno != null) {
            this.fno.buU();
        }
    }

    public void pT(@ColorRes int i) {
        this.fnb = i;
        this.fnd = R.color.CAM_X0903;
        this.fnp = false;
        if (this.fno != null) {
            this.fno.buU();
        }
    }

    public void aY(@ColorRes int i, @ColorRes int i2) {
        this.fnd = i;
        this.fnb = i2;
        this.fnp = false;
        if (this.fno != null) {
            this.fno.buU();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ak(float f) {
        return am(f);
    }

    private Drawable am(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.fnp) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(this.fnm ? ap.getColor(this.ajU, this.fnb) : this.fnb, 0.08f));
        } else {
            gradientDrawable.setColor(ap.getColor(this.ajU, this.fnd));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
