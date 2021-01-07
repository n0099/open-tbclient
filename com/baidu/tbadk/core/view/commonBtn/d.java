package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends TBSpecificationButtonConfig {
    private boolean fgb;

    public d() {
        this.fpz = true;
        this.fpt = R.color.CAM_X0101;
        this.fpv = R.color.CAM_X0302;
        this.fgb = false;
        this.minWidth = this.minHeight;
        this.fpD = this.fpC;
    }

    public void rw(@ColorRes int i) {
        this.fpt = i;
        this.fpv = R.color.CAM_X0904;
        this.fgb = false;
        if (this.fpG != null) {
            this.fpG.byu();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void a(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        a(i, iconType);
    }

    public void a(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        this.fpw[0] = i;
        this.fpx = iconType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aj(float f) {
        return am(f);
    }

    private Drawable am(float f) {
        return this.fgb ? ak(f) : an(f);
    }

    private Drawable an(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ao.getColor(this.akW, this.fpv));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable ak(float f) {
        GradientDrawable gradientDrawable;
        int color = ao.getColor(this.akW, this.fpv);
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
