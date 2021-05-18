package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import d.a.j0.r.q.i1;
import d.a.j0.r.u.c;
import d.a.k0.d3.q0.d;
/* loaded from: classes3.dex */
public class PublishProgressView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public PublishProgressBar f12408e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12409f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12410g;

    /* renamed from: h  reason: collision with root package name */
    public i1 f12411h;

    public PublishProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void setProgress(int i2) {
        this.f12409f.setText(String.format(getResources().getString(R.string.publish_progress_prefix), Integer.valueOf(this.f12408e.c(i2))));
    }

    public final void a(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.publish_progress_view, this);
        this.f12408e = (PublishProgressBar) inflate.findViewById(R.id.progress_bar);
        this.f12409f = (TextView) inflate.findViewById(R.id.progress_text);
        TextView textView = (TextView) inflate.findViewById(R.id.progress_close_btn);
        this.f12410g = textView;
        textView.setOnClickListener(this);
        this.f12408e.setOnClickListener(this);
        b();
    }

    public void b() {
        this.f12408e.b();
        c d2 = c.d(this.f12409f);
        d2.q(R.color.CAM_X0101);
        d2.u(R.dimen.T_X06);
        d2.v(R.string.F_X01);
        c d3 = c.d(this.f12410g);
        d3.q(R.color.CAM_X0101);
        d3.u(R.dimen.T_X09);
        d3.v(R.string.F_X01);
    }

    public void c(@NonNull i1 i1Var) {
        if (i1Var.equals(this.f12411h)) {
            this.f12411h.f(i1Var);
            d();
            return;
        }
        this.f12411h = i1Var;
        d();
    }

    public final void d() {
        i1 i1Var = this.f12411h;
        if (i1Var == null) {
            return;
        }
        if (i1Var.d()) {
            setProgress(this.f12411h.a());
            setVisibility(0);
            return;
        }
        setVisibility(8);
        setProgress(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.progress_close_btn) {
            i1 i1Var = this.f12411h;
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
