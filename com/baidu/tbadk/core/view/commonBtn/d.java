package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends TBSpecificationButtonConfig {
    private boolean fdI;

    public d() {
        this.fnh = true;
        this.fnb = R.color.CAM_X0101;
        this.fnd = R.color.CAM_X0302;
        this.fdI = false;
        this.minWidth = this.minHeight;
        this.fnl = this.fnk;
    }

    public void pV(@ColorRes int i) {
        this.fnb = i;
        this.fnd = R.color.CAM_X0904;
        this.fdI = false;
        if (this.fno != null) {
            this.fno.buU();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void a(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        a(i, iconType);
    }

    public void a(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        this.fne[0] = i;
        this.fnf = iconType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ak(float f) {
        return an(f);
    }

    private Drawable an(float f) {
        return this.fdI ? al(f) : ao(f);
    }

    private Drawable ao(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ap.getColor(this.ajU, this.fnd));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable al(float f) {
        GradientDrawable gradientDrawable;
        int color = ap.getColor(this.ajU, this.fnd);
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
