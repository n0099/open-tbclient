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
    private boolean ePl;

    public d() {
        this.eYt = true;
        this.eYm = R.color.CAM_X0101;
        this.eYo = R.color.CAM_X0302;
        this.ePl = false;
        this.minWidth = this.minHeight;
        this.eYx = this.eYw;
    }

    public void qK(@ColorRes int i) {
        this.eYm = i;
        this.eYo = R.color.CAM_X0904;
        this.ePl = false;
        if (this.eYA != null) {
            this.eYA.bsz();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void a(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        a(i, iconType);
    }

    public void a(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        this.eYp[0] = i;
        this.eYq = iconType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ah(float f) {
        return ak(f);
    }

    private Drawable ak(float f) {
        return this.ePl ? ai(f) : al(f);
    }

    private Drawable al(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ap.getColor(this.ajv, this.eYo));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable ai(float f) {
        GradientDrawable gradientDrawable;
        int color = ap.getColor(this.ajv, this.eYo);
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
