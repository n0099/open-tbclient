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
import d.b.b.e.p.l;
import d.b.h0.r.f0.m.b;
import d.b.h0.r.q.a2;
/* loaded from: classes2.dex */
public class ExtraLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f4398e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4399f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4400g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f4401h;
    public final View.OnClickListener i;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ExtraLayout.this.f4401h != null) {
                ExtraLayout.this.f4401h.onClick(view);
            }
        }
    }

    public ExtraLayout(Context context) {
        super(context);
        this.i = new a();
        b(context);
    }

    public final void b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_extra_item, (ViewGroup) this, true);
        TextView textView = (TextView) inflate.findViewById(R.id.extra_text);
        this.f4399f = textView;
        textView.setCompoundDrawablePadding(l.g(context, R.dimen.tbds10));
        this.f4400g = (TextView) inflate.findViewById(R.id.extra_tag);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.extra_btn);
        this.f4398e = tBSpecificationBtn;
        tBSpecificationBtn.setOnClickListener(this.i);
        b bVar = new b();
        bVar.q(R.color.CAM_X0302);
        this.f4398e.setConfig(bVar);
        this.f4398e.setText(getResources().getString(R.string.download_just_now));
    }

    public void setData(d.b.h0.r.q.a aVar) {
        boolean z;
        a2 n = aVar.n();
        boolean z2 = true;
        if (!TextUtils.isEmpty(n.w2)) {
            this.f4399f.setVisibility(0);
            this.f4399f.setText(n.w2);
            this.f4399f.setOnClickListener(null);
            z = true;
        } else {
            this.f4399f.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(n.x2)) {
            this.f4400g.setVisibility(0);
            this.f4400g.setText(n.x2);
            this.f4400g.setOnClickListener(null);
            z = true;
        } else {
            this.f4400g.setVisibility(8);
        }
        if (!TextUtils.isEmpty(n.y2)) {
            this.f4398e.setVisibility(0);
            this.f4398e.setText(n.y2);
        } else {
            this.f4398e.setVisibility(4);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.f4401h = onClickListener;
    }

    public ExtraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new a();
        b(context);
    }

    public ExtraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new a();
        b(context);
    }
}
