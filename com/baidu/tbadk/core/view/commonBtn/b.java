package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends TBSpecificationButtonConfig {
    private boolean eYB;

    public b() {
        this.eYm = R.color.CAM_X0302;
        this.eYB = true;
    }

    public void qG(@ColorRes int i) {
        this.eYm = i;
        this.eYB = true;
        this.eYy = true;
        if (this.eYA != null) {
            this.eYA.bsz();
        }
    }

    public void qH(@ColorRes int i) {
        this.eYm = i;
        this.eYo = R.color.CAM_X0211;
        this.eYB = false;
        this.eYy = true;
        if (this.eYA != null) {
            this.eYA.bsz();
        }
    }

    public void bsC() {
        this.eYm = R.color.CAM_X0101;
        this.eYo = R.color.CAM_X0904;
        this.eYB = false;
        this.eYy = true;
        if (this.eYA != null) {
            this.eYA.bsz();
        }
    }

    public void qI(@ColorRes int i) {
        this.eYm = i;
        this.eYo = R.color.CAM_X0903;
        this.eYB = false;
        if (this.eYA != null) {
            this.eYA.bsz();
        }
    }

    public void bb(@ColorRes int i, @ColorRes int i2) {
        this.eYo = i;
        this.eYm = i2;
        this.eYB = false;
        if (this.eYA != null) {
            this.eYA.bsz();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ah(float f) {
        return aj(f);
    }

    private Drawable aj(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.eYB) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(this.eYy ? ap.getColor(this.ajv, this.eYm) : this.eYm, 0.08f));
        } else {
            gradientDrawable.setColor(ap.getColor(this.ajv, this.eYo));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
