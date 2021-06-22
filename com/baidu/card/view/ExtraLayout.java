package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.r.f0.m.b;
import d.a.n0.r.q.a2;
/* loaded from: classes.dex */
public class ExtraLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f4391e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4392f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4393g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f4394h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f4395i;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ExtraLayout.this.f4394h != null) {
                ExtraLayout.this.f4394h.onClick(view);
            }
        }
    }

    public ExtraLayout(Context context) {
        super(context);
        this.f4395i = new a();
        b(context);
    }

    public final void b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_extra_item, (ViewGroup) this, true);
        TextView textView = (TextView) inflate.findViewById(R.id.extra_text);
        this.f4392f = textView;
        textView.setCompoundDrawablePadding(l.g(context, R.dimen.tbds10));
        this.f4393g = (TextView) inflate.findViewById(R.id.extra_tag);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.extra_btn);
        this.f4391e = tBSpecificationBtn;
        tBSpecificationBtn.setOnClickListener(this.f4395i);
        b bVar = new b();
        bVar.q(R.color.CAM_X0302);
        this.f4391e.setConfig(bVar);
        this.f4391e.setText(getResources().getString(R.string.download_just_now));
    }

    public void setData(d.a.n0.r.q.a aVar) {
        boolean z;
        a2 i2 = aVar.i();
        boolean z2 = true;
        if (!TextUtils.isEmpty(i2.z2)) {
            this.f4392f.setVisibility(0);
            this.f4392f.setText(i2.z2);
            this.f4392f.setOnClickListener(null);
            z = true;
        } else {
            this.f4392f.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(i2.A2)) {
            this.f4393g.setVisibility(0);
            this.f4393g.setText(i2.A2);
            this.f4393g.setOnClickListener(null);
            z = true;
        } else {
            this.f4393g.setVisibility(8);
        }
        if (!TextUtils.isEmpty(i2.B2)) {
            this.f4391e.setVisibility(0);
            this.f4391e.setText(i2.B2);
        } else {
            this.f4391e.setVisibility(4);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.f4394h = onClickListener;
    }

    public ExtraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4395i = new a();
        b(context);
    }

    public ExtraLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4395i = new a();
        b(context);
    }
}
