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
        this.fkJ = R.color.CAM_X0101;
        this.fkL = R.color.CAM_X0302;
    }

    public void pM(@ColorRes int i) {
        this.fkL = i;
        this.fkJ = R.color.CAM_X0101;
        this.fkU = true;
        if (this.fkW != null) {
            this.fkW.buA();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aj(float f) {
        return ak(f);
    }

    private Drawable ak(float f) {
        GradientDrawable gradientDrawable;
        if (!this.fkU) {
            this.fkJ = ao.getColor(this.akf, R.color.CAM_X0101);
        }
        int color = this.fkU ? ao.getColor(this.akf, this.fkL) : this.fkL;
        int[] iArr = {com.baidu.tieba.tbadkCore.c.IZ(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.fkV);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.fkV, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
