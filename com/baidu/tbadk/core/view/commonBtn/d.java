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
    private boolean ffh;

    public d() {
        this.foH = true;
        this.foB = R.color.CAM_X0101;
        this.foD = R.color.CAM_X0302;
        this.ffh = false;
        this.minWidth = this.minHeight;
        this.foL = this.foK;
    }

    public void pW(@ColorRes int i) {
        this.foB = i;
        this.foD = R.color.CAM_X0904;
        this.ffh = false;
        if (this.foO != null) {
            this.foO.buX();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void a(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        a(i, iconType);
    }

    public void a(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        this.foE[0] = i;
        this.foF = iconType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable ao(float f) {
        return ar(f);
    }

    private Drawable ar(float f) {
        return this.ffh ? ap(f) : as(f);
    }

    private Drawable as(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ap.getColor(this.aln, this.foD));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable ap(float f) {
        GradientDrawable gradientDrawable;
        int color = ap.getColor(this.aln, this.foD);
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
