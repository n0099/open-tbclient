package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import d.a.m0.r.q.i1;
import d.a.m0.r.u.c;
import d.a.n0.e3.q0.d;
/* loaded from: classes3.dex */
public class PublishProgressView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public PublishProgressBar f12378e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12379f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12380g;

    /* renamed from: h  reason: collision with root package name */
    public i1 f12381h;

    public PublishProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void setProgress(int i2) {
        this.f12379f.setText(String.format(getResources().getString(R.string.publish_progress_prefix), Integer.valueOf(this.f12378e.c(i2))));
    }

    public final void a(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.publish_progress_view, this);
        this.f12378e = (PublishProgressBar) inflate.findViewById(R.id.progress_bar);
        this.f12379f = (TextView) inflate.findViewById(R.id.progress_text);
        TextView textView = (TextView) inflate.findViewById(R.id.progress_close_btn);
        this.f12380g = textView;
        textView.setOnClickListener(this);
        this.f12378e.setOnClickListener(this);
        b();
    }

    public void b() {
        this.f12378e.b();
        c d2 = c.d(this.f12379f);
        d2.s(R.color.CAM_X0101);
        d2.w(R.dimen.T_X06);
        d2.x(R.string.F_X01);
        c d3 = c.d(this.f12380g);
        d3.s(R.color.CAM_X0101);
        d3.w(R.dimen.T_X09);
        d3.x(R.string.F_X01);
    }

    public void c(@NonNull i1 i1Var) {
        if (i1Var.equals(this.f12381h)) {
            this.f12381h.f(i1Var);
            d();
            return;
        }
        this.f12381h = i1Var;
        d();
    }

    public final void d() {
        i1 i1Var = this.f12381h;
        if (i1Var == null) {
            return;
        }
        if (i1Var.d()) {
            setProgress(this.f12381h.a());
            setVisibility(0);
            return;
        }
        setVisibility(8);
        setProgress(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.progress_close_btn) {
            i1 i1Var = this.f12381h;
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
