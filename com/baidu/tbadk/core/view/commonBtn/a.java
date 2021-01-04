package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends TBSpecificationButtonConfig {
    public a() {
        this.fpt = R.color.CAM_X0101;
        this.fpv = R.color.CAM_X0302;
    }

    public void rs(@ColorRes int i) {
        this.fpv = i;
        this.fpt = R.color.CAM_X0101;
        this.fpE = true;
        if (this.fpG != null) {
            this.fpG.byt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aj(float f) {
        return ak(f);
    }

    private Drawable ak(float f) {
        GradientDrawable gradientDrawable;
        if (!this.fpE) {
            this.fpt = ao.getColor(this.akW, R.color.CAM_X0101);
        }
        int color = this.fpE ? ao.getColor(this.akW, this.fpv) : this.fpv;
        int[] iArr = {com.baidu.tieba.tbadkCore.c.KG(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.fpF);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.fpF, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
