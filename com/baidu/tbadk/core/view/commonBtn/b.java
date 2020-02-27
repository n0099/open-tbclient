package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends a {
    public b() {
        this.djz = R.color.cp_cont_a;
        this.djB = R.color.cp_link_tip_a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable ak(float f) {
        return al(f);
    }

    private Drawable al(float f) {
        GradientDrawable gradientDrawable;
        if (!this.djK) {
            this.djz = am.getColor(R.color.cp_cont_a);
        }
        int color = this.djK ? am.getColor(this.djB) : this.djB;
        int[] iArr = {com.baidu.tieba.tbadkCore.c.Cm(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
