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
import com.baidu.tieba.cr0;
import com.baidu.tieba.d31;
import com.baidu.tieba.m61;
import com.baidu.tieba.qr0;
import com.baidu.tieba.vr0;
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
    public void j(LayoutInflater layoutInflater, vr0 vr0Var) {
        int i = R.layout.nad_tpl_triple_image;
        if (vr0Var != null) {
            if (vr0Var.a(AdBaseModel.STYLE.THREE_IMAGE) != 0) {
                i = vr0Var.a(AdBaseModel.STYLE.THREE_IMAGE);
            }
            vr0.a aVar = vr0Var.j;
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

    public NadExpressThreeImgOperateView(Context context, AttributeSet attributeSet, int i, vr0 vr0Var) {
        super(context, attributeSet, i, vr0Var);
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
        this.t = (((((m61.c.e(context) - m61.c.a(getContext(), this.m)) - m61.c.a(getContext(), this.n)) - m61.c.a(getContext(), this.o)) - m61.c.a(getContext(), this.p)) - (resources.getDimensionPixelSize(R.dimen.NAD_F_M_W_X024) * 2)) / 3;
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
        if (!(adBaseModel instanceof qr0)) {
            return;
        }
        List<cr0> list = ((qr0) adBaseModel).f.k;
        if (!d31.g(list) && d31.l(list) >= 3) {
            cr0 cr0Var = (cr0) d31.d(list, 0);
            cr0 cr0Var2 = (cr0) d31.d(list, 1);
            cr0 cr0Var3 = (cr0) d31.d(list, 2);
            if (cr0Var != null && (adImageView3 = this.q) != null) {
                adImageView3.b(cr0Var.a);
            }
            if (cr0Var2 != null && (adImageView2 = this.r) != null) {
                adImageView2.b(cr0Var2.a);
            }
            if (cr0Var3 != null && (adImageView = this.s) != null) {
                adImageView.b(cr0Var3.a);
            }
        }
    }
}
