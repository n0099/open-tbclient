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
import com.baidu.tieba.nn0;
import com.baidu.tieba.u11;
/* loaded from: classes3.dex */
public class NadExpressThreeImgOperateView extends NadExpressNaBaseView {
    public int k;
    public int l;
    public int m;
    public int n;
    @Nullable
    public AdImageView o;
    @Nullable
    public AdImageView p;
    @Nullable
    public AdImageView q;
    public int r;
    public int s;

    public NadExpressThreeImgOperateView(Context context) {
        this(context, null);
    }

    public NadExpressThreeImgOperateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void g(LayoutInflater layoutInflater, nn0 nn0Var) {
        int i = R.layout.nad_tpl_triple_image;
        if (nn0Var != null) {
            if (nn0Var.a(AdBaseModel.STYLE.THREE_IMAGE) != 0) {
                i = nn0Var.a(AdBaseModel.STYLE.THREE_IMAGE);
            }
            nn0.a aVar = nn0Var.e;
            if (aVar != null) {
                this.k = aVar.a;
                this.l = aVar.b;
                this.m = aVar.c;
                this.n = aVar.d;
            }
        }
        layoutInflater.inflate(i, this);
    }

    public NadExpressThreeImgOperateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadExpressThreeImgOperateView(Context context, AttributeSet attributeSet, int i, nn0 nn0Var) {
        super(context, attributeSet, i, nn0Var);
        this.k = 15;
        this.l = 15;
        this.m = 0;
        this.n = 0;
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void h(Context context) {
        this.o = (AdImageView) findViewById(R.id.nad_feed_template_tripe_image_one_id);
        this.p = (AdImageView) findViewById(R.id.nad_feed_template_tripe_image_two_id);
        this.q = (AdImageView) findViewById(R.id.nad_feed_template_tripe_image_three_id);
        Resources resources = context.getResources();
        this.r = (((((u11.c.e(context) - u11.c.a(getContext(), this.k)) - u11.c.a(getContext(), this.l)) - u11.c.a(getContext(), this.m)) - u11.c.a(getContext(), this.n)) - (resources.getDimensionPixelSize(R.dimen.NAD_F_M_W_X024) * 2)) / 3;
        this.s = Math.round((this.r / ((int) resources.getDimension(R.dimen.nad_template_p1_w))) * ((int) resources.getDimension(R.dimen.nad_template_p1_h)));
        AdImageView adImageView = this.o;
        if (adImageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) adImageView.getLayoutParams();
            layoutParams.width = this.r;
            layoutParams.height = this.s;
            this.o.setLayoutParams(layoutParams);
        }
        AdImageView adImageView2 = this.p;
        if (adImageView2 != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) adImageView2.getLayoutParams();
            layoutParams2.width = this.r;
            layoutParams2.height = this.s;
            this.p.setLayoutParams(layoutParams2);
        }
        AdImageView adImageView3 = this.q;
        if (adImageView3 != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) adImageView3.getLayoutParams();
            layoutParams3.width = this.r;
            layoutParams3.height = this.s;
            this.q.setLayoutParams(layoutParams3);
        }
    }
}
