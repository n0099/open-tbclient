package com.baidu.swan.apps.res.widget.loadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.swan.apps.res.ui.SmoothProgressBar;
import d.b.h0.a.c;
import d.b.h0.a.e;
import d.b.h0.a.f;
import d.b.h0.a.g;
import d.b.h0.a.q1.b.d.b;
/* loaded from: classes3.dex */
public class LoadingView extends FrameLayout implements b<LoadingView> {

    /* renamed from: e  reason: collision with root package name */
    public View f12278e;

    /* renamed from: f  reason: collision with root package name */
    public SmoothProgressBar f12279f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12280g;

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.x1.a {
        public a() {
        }
    }

    public LoadingView(Context context) {
        super(context);
        a();
    }

    public void a() {
        LayoutInflater.from(getContext()).inflate(g.aiapps_loading_layout, (ViewGroup) this, true);
        this.f12278e = findViewById(f.root_container);
        this.f12279f = (SmoothProgressBar) findViewById(f.loading_bar);
        this.f12280g = (TextView) findViewById(f.message);
        setPageResources();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.q1.b.d.b
    public LoadingView getLoadingView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.b.h0.a.w0.a.z().f(this, new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.b.h0.a.w0.a.z().g(this);
    }

    public void setMsg(int i) {
        this.f12280g.setText(i);
    }

    public void setPageResources() {
        View view = this.f12278e;
        if (view != null) {
            view.setBackground(view.getResources().getDrawable(e.aiapps_loading_bg));
        }
        SmoothProgressBar smoothProgressBar = this.f12279f;
        if (smoothProgressBar != null) {
            smoothProgressBar.setIndeterminateDrawable(smoothProgressBar.getResources().getDrawable(e.aiapps_loading_progress_animation));
        }
        TextView textView = this.f12280g;
        if (textView != null) {
            textView.setTextColor(textView.getResources().getColor(c.aiapps_loading_text_color));
        }
    }

    public void setMsg(String str) {
        this.f12280g.setText(str);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
