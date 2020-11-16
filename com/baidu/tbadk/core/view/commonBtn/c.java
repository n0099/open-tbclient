package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends TBSpecificationButtonConfig {
    private boolean eYC;

    public c() {
        this.eYm = R.color.CAM_X0302;
        this.eYC = false;
    }

    public void qG(@ColorRes int i) {
        this.eYm = i;
        this.eYC = false;
        this.eYy = true;
        if (this.eYA != null) {
            this.eYA.bsz();
        }
    }

    public void qJ(@ColorInt int i) {
        this.eYm = i;
        this.eYC = false;
        this.eYy = false;
        if (this.eYA != null) {
            this.eYA.bsz();
        }
    }

    public void bsD() {
        this.eYm = R.color.CAM_X0101;
        this.eYC = false;
        this.eYy = true;
        if (this.eYA != null) {
            this.eYA.bsz();
        }
    }

    public void qI(@ColorRes int i) {
        this.eYm = i;
        this.eYn = R.color.CAM_X0902;
        this.eYC = true;
        this.eYy = true;
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
        if (this.eYC) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), ap.getColor(this.ajv, this.eYn));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.m(this.eYy ? ap.getColor(this.ajv, this.eYm) : this.eYm, com.baidu.tbadk.core.elementsMaven.a.oH(R.string.A_X07)));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
