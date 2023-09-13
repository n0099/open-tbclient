package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.dr0;
import com.baidu.tieba.q61;
import com.baidu.tieba.zr0;
/* loaded from: classes3.dex */
public class NadExpressBigImgOperateView extends NadExpressNaBaseView {
    @Nullable
    public AdImageView m;

    public NadExpressBigImgOperateView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void k(Context context) {
        this.m = (AdImageView) findViewById(R.id.nad_feed_template_big_image_id);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void m(AdBaseModel adBaseModel) {
        if (adBaseModel == null) {
            setVisibility(8);
            return;
        }
        p();
        AdImageView adImageView = this.m;
        if (adImageView != null) {
            adImageView.setVisibility(0);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void n(AdBaseModel adBaseModel) {
        if (adBaseModel instanceof dr0) {
            dr0 dr0Var = (dr0) adBaseModel;
            setMaxTitleLine(2);
            AdImageView adImageView = this.m;
            if (adImageView != null) {
                adImageView.r(dr0Var.r.a);
            }
        }
    }

    public NadExpressBigImgOperateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void j(LayoutInflater layoutInflater, zr0 zr0Var) {
        int i;
        if (zr0Var != null && zr0Var.a(AdBaseModel.STYLE.BIG_IMAGE) != 0) {
            i = zr0Var.a(AdBaseModel.STYLE.BIG_IMAGE);
        } else {
            i = R.layout.nad_feed_big_image;
        }
        layoutInflater.inflate(i, this);
    }

    public NadExpressBigImgOperateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadExpressBigImgOperateView(Context context, AttributeSet attributeSet, int i, zr0 zr0Var) {
        super(context, attributeSet, i, zr0Var);
    }

    public final void p() {
        if (this.m == null) {
            return;
        }
        Resources resources = getContext().getResources();
        int e = q61.c.e(getContext()) - (resources.getDimensionPixelSize(R.dimen.NAD_F_M_W_X001) * 2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.width = e;
        layoutParams.height = Math.round((e / resources.getInteger(R.integer.nad_list_big_image_width)) * resources.getInteger(R.integer.nad_list_big_image_height));
        this.m.setLayoutParams(layoutParams);
    }
}
