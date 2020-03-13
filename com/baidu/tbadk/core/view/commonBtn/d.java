package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends a {
    private boolean dkb;

    public d() {
        this.djN = R.color.cp_link_tip_a;
        this.dkb = false;
    }

    public void lv(@ColorInt int i) {
        this.djN = i;
        this.dkb = false;
        this.djY = false;
        if (this.djZ != null) {
            this.djZ.aIr();
        }
    }

    public void aIv() {
        this.djN = R.color.cp_cont_a;
        this.dkb = false;
        this.djY = true;
        if (this.djZ != null) {
            this.djZ.aIr();
        }
    }

    public void lu(@ColorRes int i) {
        this.djN = i;
        this.djO = R.color.cp_btn_b;
        this.dkb = true;
        this.djY = true;
        if (this.djZ != null) {
            this.djZ.aIr();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.core.view.commonBtn.a
    public Drawable ak(float f) {
        return am(f);
    }

    private Drawable am(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.dkb) {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), am.getColor(this.djO));
        } else {
            gradientDrawable.setStroke(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.n(this.djY ? am.getColor(this.djN) : this.djN, 0.5f));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
