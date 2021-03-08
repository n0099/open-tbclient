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
        this.foB = R.color.CAM_X0101;
        this.foD = R.color.CAM_X0302;
    }

    public void pS(@ColorRes int i) {
        this.foD = i;
        this.foB = R.color.CAM_X0101;
        this.foM = true;
        if (this.foO != null) {
            this.foO.buX();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ao(float f) {
        return ap(f);
    }

    private Drawable ap(float f) {
        GradientDrawable gradientDrawable;
        if (!this.foM) {
            this.foB = ap.getColor(this.aln, R.color.CAM_X0101);
        }
        int color = this.foM ? ap.getColor(this.aln, this.foD) : this.foD;
        int[] iArr = {com.baidu.tieba.tbadkCore.c.Jx(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.foN);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.foN, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
