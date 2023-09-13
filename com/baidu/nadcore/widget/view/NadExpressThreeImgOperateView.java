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
import com.baidu.tieba.gr0;
import com.baidu.tieba.h31;
import com.baidu.tieba.q61;
import com.baidu.tieba.ur0;
import com.baidu.tieba.zr0;
import java.util.List;
/* loaded from: classes3.dex */
public class NadExpressThreeImgOperateView extends NadExpressNaBaseView {
    public int m;
    public int n;
    public int o;
    public int p;
    @Nullable
    public AdImageView q;
    @Nullable
    public AdImageView r;
    @Nullable
    public AdImageView s;
    public int t;
    public int u;

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void m(AdBaseModel adBaseModel) {
    }

    public NadExpressThreeImgOperateView(Context context) {
        this(context, null);
    }

    public NadExpressThreeImgOperateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void j(LayoutInflater layoutInflater, zr0 zr0Var) {
        int i = R.layout.nad_tpl_triple_image;
        if (zr0Var != null) {
            if (zr0Var.a(AdBaseModel.STYLE.THREE_IMAGE) != 0) {
                i = zr0Var.a(AdBaseModel.STYLE.THREE_IMAGE);
            }
            zr0.a aVar = zr0Var.j;
            if (aVar != null) {
                this.m = aVar.a;
                this.n = aVar.b;
                this.o = aVar.c;
                this.p = aVar.d;
            }
        }
        layoutInflater.inflate(i, this);
    }

    public NadExpressThreeImgOperateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadExpressThreeImgOperateView(Context context, AttributeSet attributeSet, int i, zr0 zr0Var) {
        super(context, attributeSet, i, zr0Var);
        this.m = 15;
        this.n = 15;
        this.o = 0;
        this.p = 0;
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void k(Context context) {
        this.q = (AdImageView) findViewById(R.id.nad_feed_template_tripe_image_one_id);
        this.r = (AdImageView) findViewById(R.id.nad_feed_template_tripe_image_two_id);
        this.s = (AdImageView) findViewById(R.id.nad_feed_template_tripe_image_three_id);
        Resources resources = context.getResources();
        this.t = (((((q61.c.e(context) - q61.c.a(getContext(), this.m)) - q61.c.a(getContext(), this.n)) - q61.c.a(getContext(), this.o)) - q61.c.a(getContext(), this.p)) - (resources.getDimensionPixelSize(R.dimen.NAD_F_M_W_X024) * 2)) / 3;
        this.u = Math.round((this.t / ((int) resources.getDimension(R.dimen.nad_template_p1_w))) * ((int) resources.getDimension(R.dimen.nad_template_p1_h)));
        AdImageView adImageView = this.q;
        if (adImageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) adImageView.getLayoutParams();
            layoutParams.width = this.t;
            layoutParams.height = this.u;
            this.q.setLayoutParams(layoutParams);
        }
        AdImageView adImageView2 = this.r;
        if (adImageView2 != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) adImageView2.getLayoutParams();
            layoutParams2.width = this.t;
            layoutParams2.height = this.u;
            this.r.setLayoutParams(layoutParams2);
        }
        AdImageView adImageView3 = this.s;
        if (adImageView3 != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) adImageView3.getLayoutParams();
            layoutParams3.width = this.t;
            layoutParams3.height = this.u;
            this.s.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void n(AdBaseModel adBaseModel) {
        AdImageView adImageView;
        AdImageView adImageView2;
        AdImageView adImageView3;
        if (!(adBaseModel instanceof ur0)) {
            return;
        }
        List<gr0> list = ((ur0) adBaseModel).f.k;
        if (!h31.g(list) && h31.l(list) >= 3) {
            gr0 gr0Var = (gr0) h31.d(list, 0);
            gr0 gr0Var2 = (gr0) h31.d(list, 1);
            gr0 gr0Var3 = (gr0) h31.d(list, 2);
            if (gr0Var != null && (adImageView3 = this.q) != null) {
                adImageView3.r(gr0Var.a);
            }
            if (gr0Var2 != null && (adImageView2 = this.r) != null) {
                adImageView2.r(gr0Var2.a);
            }
            if (gr0Var3 != null && (adImageView = this.s) != null) {
                adImageView.r(gr0Var3.a);
            }
        }
    }
}
