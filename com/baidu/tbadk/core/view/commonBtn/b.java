package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends TBSpecificationButtonConfig {
    private boolean ffY;

    public b() {
        this.ffJ = R.color.CAM_X0302;
        this.ffY = true;
    }

    public void rh(@ColorRes int i) {
        this.ffJ = i;
        this.ffY = true;
        this.ffV = true;
        if (this.ffX != null) {
            this.ffX.bvZ();
        }
    }

    public void ri(@ColorRes int i) {
        this.ffJ = i;
        this.ffL = R.color.CAM_X0211;
        this.ffY = false;
        this.ffV = true;
        if (this.ffX != null) {
            this.ffX.bvZ();
        }
    }

    public void bwc() {
        this.ffJ = R.color.CAM_X0101;
        this.ffL = R.color.CAM_X0904;
        this.ffY = false;
        this.ffV = true;
        if (this.ffX != null) {
            this.ffX.bvZ();
        }
    }

    public void rj(@ColorRes int i) {
        this.ffJ = i;
        this.ffL = R.color.CAM_X0903;
        this.ffY = false;
        if (this.ffX != null) {
            this.ffX.bvZ();
        }
    }

    public void bd(@ColorRes int i, @ColorRes int i2) {
        this.ffL = i;
        this.ffJ = i2;
        this.ffY = false;
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
        if (this.ffY) {
            gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(this.ffV ? ap.getColor(this.aku, this.ffJ) : this.ffJ, 0.08f));
        } else {
            gradientDrawable.setColor(ap.getColor(this.aku, this.ffL));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
