package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends TBSpecificationButtonConfig {
    private boolean eWA;

    public d() {
        this.ffQ = true;
        this.ffJ = R.color.CAM_X0101;
        this.ffL = R.color.CAM_X0302;
        this.eWA = false;
        this.minWidth = this.minHeight;
        this.ffU = this.ffT;
    }

    public void rl(@ColorRes int i) {
        this.ffJ = i;
        this.ffL = R.color.CAM_X0904;
        this.eWA = false;
        if (this.ffX != null) {
            this.ffX.bvZ();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void a(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        a(i, iconType);
    }

    public void a(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        this.ffM[0] = i;
        this.ffN = iconType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ah(float f) {
        return ak(f);
    }

    private Drawable ak(float f) {
        return this.eWA ? ai(f) : al(f);
    }

    private Drawable al(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ap.getColor(this.aku, this.ffL));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable ai(float f) {
        GradientDrawable gradientDrawable;
        int color = ap.getColor(this.aku, this.ffL);
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
