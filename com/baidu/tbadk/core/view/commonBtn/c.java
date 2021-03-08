package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends TBSpecificationButtonConfig {
    private boolean foQ;

    public c() {
        this.foB = R.color.CAM_X0302;
        this.foQ = false;
    }

    public void pS(@ColorRes int i) {
        this.foB = i;
        this.foQ = false;
        this.foM = true;
        if (this.foO != null) {
            this.foO.buX();
        }
    }

    public void pV(@ColorInt int i) {
        this.foB = i;
        this.foQ = false;
        this.foM = false;
        if (this.foO != null) {
            this.foO.buX();
        }
    }

    public void bvb() {
        this.foB = R.color.CAM_X0101;
        this.foQ = false;
        this.foM = true;
        if (this.foO != null) {
            this.foO.buX();
        }
    }

    public void pU(@ColorRes int i) {
        this.foB = i;
        this.foC = R.color.CAM_X0902;
        this.foQ = true;
        this.foM = true;
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
        if (this.foQ) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), ap.getColor(this.aln, this.foC));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(this.foM ? ap.getColor(this.aln, this.foB) : this.foB, com.baidu.tbadk.core.elementsMaven.a.nN(R.string.A_X07)));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
