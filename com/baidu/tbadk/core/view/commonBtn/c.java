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
    private boolean ffZ;

    public c() {
        this.ffJ = R.color.CAM_X0302;
        this.ffZ = false;
    }

    public void rh(@ColorRes int i) {
        this.ffJ = i;
        this.ffZ = false;
        this.ffV = true;
        if (this.ffX != null) {
            this.ffX.bvZ();
        }
    }

    public void rk(@ColorInt int i) {
        this.ffJ = i;
        this.ffZ = false;
        this.ffV = false;
        if (this.ffX != null) {
            this.ffX.bvZ();
        }
    }

    public void bwd() {
        this.ffJ = R.color.CAM_X0101;
        this.ffZ = false;
        this.ffV = true;
        if (this.ffX != null) {
            this.ffX.bvZ();
        }
    }

    public void rj(@ColorRes int i) {
        this.ffJ = i;
        this.ffK = R.color.CAM_X0902;
        this.ffZ = true;
        this.ffV = true;
        if (this.ffX != null) {
            this.ffX.bvZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ah(float f) {
        return aj(f);
    }

    private Drawable aj(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.ffZ) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), ap.getColor(this.aku, this.ffK));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.m(this.ffV ? ap.getColor(this.aku, this.ffJ) : this.ffJ, com.baidu.tbadk.core.elementsMaven.a.pf(R.string.A_X07)));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
