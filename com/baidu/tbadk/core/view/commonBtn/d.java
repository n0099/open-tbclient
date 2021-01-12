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
    private boolean fbs;

    public d() {
        this.fkP = true;
        this.fkJ = R.color.CAM_X0101;
        this.fkL = R.color.CAM_X0302;
        this.fbs = false;
        this.minWidth = this.minHeight;
        this.fkT = this.fkS;
    }

    public void pQ(@ColorRes int i) {
        this.fkJ = i;
        this.fkL = R.color.CAM_X0904;
        this.fbs = false;
        if (this.fkW != null) {
            this.fkW.buA();
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void a(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        a(i, iconType);
    }

    public void a(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        this.fkM[0] = i;
        this.fkN = iconType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable aj(float f) {
        return am(f);
    }

    private Drawable am(float f) {
        return this.fbs ? ak(f) : an(f);
    }

    private Drawable an(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ao.getColor(this.akf, this.fkL));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private Drawable ak(float f) {
        GradientDrawable gradientDrawable;
        int color = ao.getColor(this.akf, this.fkL);
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
