package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.dp0;
import com.baidu.tieba.xp0;
import com.baidu.tieba.z31;
/* loaded from: classes2.dex */
public class NadExpressSingleImgOperateView extends NadExpressNaBaseView {
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    @Nullable
    public AdImageView r;
    public dp0 s;

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void m(AdBaseModel adBaseModel) {
    }

    public NadExpressSingleImgOperateView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void n(AdBaseModel adBaseModel) {
        if (!(adBaseModel instanceof dp0)) {
            return;
        }
        dp0 dp0Var = (dp0) adBaseModel;
        this.s = dp0Var;
        AdImageView adImageView = this.r;
        if (adImageView != null) {
            adImageView.o(dp0Var.r.a);
        }
    }

    public NadExpressSingleImgOperateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void j(LayoutInflater layoutInflater, xp0 xp0Var) {
        int i = R.layout.nad_single_image;
        if (xp0Var != null) {
            int a = xp0Var.a(AdBaseModel.STYLE.SMALL_IMAGE);
            if (a != 0) {
                i = a;
            } else if (xp0Var.b) {
                i = R.layout.nad_single_image_for_img_right;
            }
            xp0.a aVar = xp0Var.j;
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

    public NadExpressSingleImgOperateView(Context context, AttributeSet attributeSet, int i, xp0 xp0Var) {
        super(context, attributeSet, i, xp0Var);
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
            e = z31.c.a(getContext(), this.q);
        } else {
            e = (((((z31.c.e(context) - z31.c.a(getContext(), this.m)) - z31.c.a(getContext(), this.n)) - z31.c.a(getContext(), this.o)) - z31.c.a(getContext(), this.p)) - (z31.c.a(getContext(), 6.0f) * 2)) / 3;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        layoutParams.width = e;
        layoutParams.height = Math.round((e / getResources().getInteger(R.integer.nad_list_small_image_width)) * getResources().getInteger(R.integer.nad_list_small_image_height));
        this.r.setLayoutParams(layoutParams);
    }
}
