package com.baidu.nadcore.widget.view;

import android.content.Context;
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
public class NadExpressSingleImgOperateView extends NadExpressNaBaseView {
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    @Nullable
    public AdImageView p;

    public NadExpressSingleImgOperateView(Context context) {
        this(context, null);
    }

    public NadExpressSingleImgOperateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void g(LayoutInflater layoutInflater, nn0 nn0Var) {
        int i = R.layout.nad_single_image;
        if (nn0Var != null) {
            int a = nn0Var.a(AdBaseModel.STYLE.SMALL_IMAGE);
            if (a != 0) {
                i = a;
            } else if (nn0Var.b) {
                i = R.layout.nad_single_image_for_img_right;
            }
            nn0.a aVar = nn0Var.e;
            if (aVar != null) {
                this.k = aVar.a;
                this.l = aVar.b;
                this.m = aVar.c;
                this.n = aVar.d;
                this.o = aVar.e;
            }
        }
        layoutInflater.inflate(i, this);
    }

    public NadExpressSingleImgOperateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadExpressSingleImgOperateView(Context context, AttributeSet attributeSet, int i, nn0 nn0Var) {
        super(context, attributeSet, i, nn0Var);
        this.k = 15;
        this.l = 15;
        this.m = 0;
        this.n = 0;
        this.o = 0;
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void h(Context context) {
        int e;
        AdImageView adImageView = (AdImageView) findViewById(R.id.nad_feed_template_single_image_id);
        this.p = adImageView;
        if (adImageView == null) {
            return;
        }
        if (this.o > 0) {
            e = u11.c.a(getContext(), this.o);
        } else {
            e = (((((u11.c.e(context) - u11.c.a(getContext(), this.k)) - u11.c.a(getContext(), this.l)) - u11.c.a(getContext(), this.m)) - u11.c.a(getContext(), this.n)) - (u11.c.a(getContext(), 6.0f) * 2)) / 3;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
        layoutParams.width = e;
        layoutParams.height = Math.round((e / getResources().getInteger(R.integer.nad_list_small_image_width)) * getResources().getInteger(R.integer.nad_list_small_image_height));
        this.p.setLayoutParams(layoutParams);
    }
}
