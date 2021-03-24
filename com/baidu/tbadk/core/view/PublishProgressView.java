package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import d.b.h0.r.q.i1;
import d.b.h0.r.u.c;
import d.b.i0.c3.q0.d;
/* loaded from: classes3.dex */
public class PublishProgressView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public PublishProgressBar f13460e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13461f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13462g;

    /* renamed from: h  reason: collision with root package name */
    public i1 f13463h;

    public PublishProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void setProgress(int i) {
        this.f13461f.setText(String.format(getResources().getString(R.string.publish_progress_prefix), Integer.valueOf(this.f13460e.c(i))));
    }

    public final void a(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.publish_progress_view, this);
        this.f13460e = (PublishProgressBar) inflate.findViewById(R.id.progress_bar);
        this.f13461f = (TextView) inflate.findViewById(R.id.progress_text);
        TextView textView = (TextView) inflate.findViewById(R.id.progress_close_btn);
        this.f13462g = textView;
        textView.setOnClickListener(this);
        this.f13460e.setOnClickListener(this);
        b();
    }

    public void b() {
        this.f13460e.b();
        c a2 = c.a(this.f13461f);
        a2.n(R.color.CAM_X0101);
        a2.r(R.dimen.T_X06);
        a2.s(R.string.F_X01);
        c a3 = c.a(this.f13462g);
        a3.n(R.color.CAM_X0101);
        a3.r(R.dimen.T_X09);
        a3.s(R.string.F_X01);
    }

    public void c(@NonNull i1 i1Var) {
        if (i1Var.equals(this.f13463h)) {
            this.f13463h.f(i1Var);
            d();
            return;
        }
        this.f13463h = i1Var;
        d();
    }

    public final void d() {
        i1 i1Var = this.f13463h;
        if (i1Var == null) {
            return;
        }
        if (i1Var.d()) {
            setProgress(this.f13463h.a());
            setVisibility(0);
            return;
        }
        setVisibility(8);
        setProgress(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.progress_close_btn) {
            i1 i1Var = this.f13463h;
            if (i1Var != null) {
                i1Var.b();
                d();
            }
            d.c();
        }
    }

    public PublishProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public PublishProgressView(Context context) {
        super(context);
        a(context, null);
    }
}
