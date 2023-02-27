package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hr0;
import com.baidu.tieba.j51;
import com.baidu.tieba.nq0;
/* loaded from: classes2.dex */
public class NadExpressSingleImgOperateView extends NadExpressNaBaseView {
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    @Nullable
    public AdImageView r;
    public nq0 s;

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void m(AdBaseModel adBaseModel) {
    }

    public NadExpressSingleImgOperateView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void n(AdBaseModel adBaseModel) {
        if (!(adBaseModel instanceof nq0)) {
            return;
        }
        nq0 nq0Var = (nq0) adBaseModel;
        this.s = nq0Var;
        AdImageView adImageView = this.r;
        if (adImageView != null) {
            adImageView.g(nq0Var.r.a);
        }
    }

    public NadExpressSingleImgOperateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void j(LayoutInflater layoutInflater, hr0 hr0Var) {
        int i = R.layout.nad_single_image;
        if (hr0Var != null) {
            int a = hr0Var.a(AdBaseModel.STYLE.SMALL_IMAGE);
            if (a != 0) {
                i = a;
            } else if (hr0Var.b) {
                i = R.layout.nad_single_image_for_img_right;
            }
            hr0.a aVar = hr0Var.j;
            if (aVar != null) {
                this.m = aVar.a;
                this.n = aVar.b;
                this.o = aVar.c;
                this.p = aVar.d;
                this.q = aVar.e;
            }
        }
        layoutInflater.inflate(i, this);
    }

    public NadExpressSingleImgOperateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadExpressSingleImgOperateView(Context context, AttributeSet attributeSet, int i, hr0 hr0Var) {
        super(context, attributeSet, i, hr0Var);
        this.m = 15;
        this.n = 15;
        this.o = 0;
        this.p = 0;
        this.q = 0;
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void k(Context context) {
        int e;
        AdImageView adImageView = (AdImageView) findViewById(R.id.nad_feed_template_single_image_id);
        this.r = adImageView;
        if (adImageView == null) {
            return;
        }
        if (this.q > 0) {
            e = j51.c.a(getContext(), this.q);
        } else {
            e = (((((j51.c.e(context) - j51.c.a(getContext(), this.m)) - j51.c.a(getContext(), this.n)) - j51.c.a(getContext(), this.o)) - j51.c.a(getContext(), this.p)) - (j51.c.a(getContext(), 6.0f) * 2)) / 3;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        layoutParams.width = e;
        layoutParams.height = Math.round((e / getResources().getInteger(R.integer.nad_list_small_image_width)) * getResources().getInteger(R.integer.nad_list_small_image_height));
        this.r.setLayoutParams(layoutParams);
    }
}
