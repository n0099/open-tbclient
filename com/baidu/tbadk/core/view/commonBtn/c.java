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
    private boolean fnq;

    public c() {
        this.fnb = R.color.CAM_X0302;
        this.fnq = false;
    }

    public void pR(@ColorRes int i) {
        this.fnb = i;
        this.fnq = false;
        this.fnm = true;
        if (this.fno != null) {
            this.fno.buU();
        }
    }

    public void pU(@ColorInt int i) {
        this.fnb = i;
        this.fnq = false;
        this.fnm = false;
        if (this.fno != null) {
            this.fno.buU();
        }
    }

    public void buY() {
        this.fnb = R.color.CAM_X0101;
        this.fnq = false;
        this.fnm = true;
        if (this.fno != null) {
            this.fno.buU();
        }
    }

    public void pT(@ColorRes int i) {
        this.fnb = i;
        this.fnc = R.color.CAM_X0902;
        this.fnq = true;
        this.fnm = true;
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
        if (this.fnq) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), ap.getColor(this.ajU, this.fnc));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(this.fnm ? ap.getColor(this.ajU, this.fnb) : this.fnb, com.baidu.tbadk.core.elementsMaven.a.nM(R.string.A_X07)));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
