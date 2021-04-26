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
import d.a.i0.r.f0.m.b;
import d.a.i0.r.q.a2;
/* loaded from: classes.dex */
public class ExtraLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f4518e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4519f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4520g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f4521h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f4522i;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ExtraLayout.this.f4521h != null) {
                ExtraLayout.this.f4521h.onClick(view);
            }
        }
    }

    public ExtraLayout(Context context) {
        super(context);
        this.f4522i = new a();
        b(context);
    }

    public final void b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_extra_item, (ViewGroup) this, true);
        TextView textView = (TextView) inflate.findViewById(R.id.extra_text);
        this.f4519f = textView;
        textView.setCompoundDrawablePadding(l.g(context, R.dimen.tbds10));
        this.f4520g = (TextView) inflate.findViewById(R.id.extra_tag);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.extra_btn);
        this.f4518e = tBSpecificationBtn;
        tBSpecificationBtn.setOnClickListener(this.f4522i);
        b bVar = new b();
        bVar.q(R.color.CAM_X0302);
        this.f4518e.setConfig(bVar);
        this.f4518e.setText(getResources().getString(R.string.download_just_now));
    }

    public void setData(d.a.i0.r.q.a aVar) {
        boolean z;
        a2 m = aVar.m();
        boolean z2 = true;
        if (!TextUtils.isEmpty(m.w2)) {
            this.f4519f.setVisibility(0);
            this.f4519f.setText(m.w2);
            this.f4519f.setOnClickListener(null);
            z = true;
        } else {
            this.f4519f.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(m.x2)) {
            this.f4520g.setVisibility(0);
            this.f4520g.setText(m.x2);
            this.f4520g.setOnClickListener(null);
            z = true;
        } else {
            this.f4520g.setVisibility(8);
        }
        if (!TextUtils.isEmpty(m.y2)) {
            this.f4518e.setVisibility(0);
            this.f4518e.setText(m.y2);
        } else {
            this.f4518e.setVisibility(4);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.f4521h = onClickListener;
    }

    public ExtraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4522i = new a();
        b(context);
    }

    public ExtraLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4522i = new a();
        b(context);
    }
}
