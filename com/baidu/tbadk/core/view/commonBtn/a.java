package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends TBSpecificationButtonConfig {
    public a() {
        this.ffJ = R.color.CAM_X0101;
        this.ffL = R.color.CAM_X0302;
    }

    public void rh(@ColorRes int i) {
        this.ffL = i;
        this.ffJ = R.color.CAM_X0101;
        this.ffV = true;
        if (this.ffX != null) {
            this.ffX.bvZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ah(float f) {
        return ai(f);
    }

    private Drawable ai(float f) {
        GradientDrawable gradientDrawable;
        if (!this.ffV) {
            this.ffJ = ap.getColor(this.aku, R.color.CAM_X0101);
        }
        int color = this.ffV ? ap.getColor(this.aku, this.ffL) : this.ffL;
        int[] iArr = {com.baidu.tieba.tbadkCore.c.KL(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.ffW);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.ffW, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
