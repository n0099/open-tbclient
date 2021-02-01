package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends TBSpecificationButtonConfig {
    public a() {
        this.fnb = R.color.CAM_X0101;
        this.fnd = R.color.CAM_X0302;
    }

    public void pR(@ColorRes int i) {
        this.fnd = i;
        this.fnb = R.color.CAM_X0101;
        this.fnm = true;
        if (this.fno != null) {
            this.fno.buU();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ak(float f) {
        return al(f);
    }

    private Drawable al(float f) {
        GradientDrawable gradientDrawable;
        if (!this.fnm) {
            this.fnb = ap.getColor(this.ajU, R.color.CAM_X0101);
        }
        int color = this.fnm ? ap.getColor(this.ajU, this.fnd) : this.fnd;
        int[] iArr = {com.baidu.tieba.tbadkCore.c.Jt(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.fnn);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.fnn, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
