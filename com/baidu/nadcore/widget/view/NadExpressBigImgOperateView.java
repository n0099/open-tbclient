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
import com.baidu.tieba.a41;
import com.baidu.tieba.ep0;
import com.baidu.tieba.yp0;
/* loaded from: classes2.dex */
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
        if (adBaseModel instanceof ep0) {
            ep0 ep0Var = (ep0) adBaseModel;
            setMaxTitleLine(2);
            AdImageView adImageView = this.m;
            if (adImageView != null) {
                adImageView.o(ep0Var.r.a);
            }
        }
    }

    public NadExpressBigImgOperateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void j(LayoutInflater layoutInflater, yp0 yp0Var) {
        int i;
        if (yp0Var != null && yp0Var.a(AdBaseModel.STYLE.BIG_IMAGE) != 0) {
            i = yp0Var.a(AdBaseModel.STYLE.BIG_IMAGE);
        } else {
            i = R.layout.nad_feed_big_image;
        }
        layoutInflater.inflate(i, this);
    }

    public NadExpressBigImgOperateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadExpressBigImgOperateView(Context context, AttributeSet attributeSet, int i, yp0 yp0Var) {
        super(context, attributeSet, i, yp0Var);
    }

    public final void p() {
        if (this.m == null) {
            return;
        }
        Resources resources = getContext().getResources();
        int e = a41.c.e(getContext()) - (resources.getDimensionPixelSize(R.dimen.NAD_F_M_W_X001) * 2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.width = e;
        layoutParams.height = Math.round((e / resources.getInteger(R.integer.nad_list_big_image_width)) * resources.getInteger(R.integer.nad_list_big_image_height));
        this.m.setLayoutParams(layoutParams);
    }
}
