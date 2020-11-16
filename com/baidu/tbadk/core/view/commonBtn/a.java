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
        this.eYm = R.color.CAM_X0101;
        this.eYo = R.color.CAM_X0302;
    }

    public void qG(@ColorRes int i) {
        this.eYo = i;
        this.eYm = R.color.CAM_X0101;
        this.eYy = true;
        if (this.eYA != null) {
            this.eYA.bsz();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ah(float f) {
        return ai(f);
    }

    private Drawable ai(float f) {
        GradientDrawable gradientDrawable;
        if (!this.eYy) {
            this.eYm = ap.getColor(this.ajv, R.color.CAM_X0101);
        }
        int color = this.eYy ? ap.getColor(this.ajv, this.eYo) : this.eYo;
        int[] iArr = {com.baidu.tieba.tbadkCore.c.JV(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.eYz);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.eYz, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
