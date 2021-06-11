package com.baidu.swan.apps.res.widget.loadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.swan.apps.res.ui.SmoothProgressBar;
import d.a.l0.a.c;
import d.a.l0.a.e;
import d.a.l0.a.f;
import d.a.l0.a.g;
import d.a.l0.a.z1.b.d.b;
/* loaded from: classes3.dex */
public class LoadingView extends FrameLayout implements b<LoadingView> {

    /* renamed from: e  reason: collision with root package name */
    public View f11303e;

    /* renamed from: f  reason: collision with root package name */
    public SmoothProgressBar f11304f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f11305g;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.g2.a {
        public a() {
        }
    }

    public LoadingView(Context context) {
        super(context);
        a();
    }

    public void a() {
        LayoutInflater.from(getContext()).inflate(g.aiapps_loading_layout, (ViewGroup) this, true);
        this.f11303e = findViewById(f.root_container);
        this.f11304f = (SmoothProgressBar) findViewById(f.loading_bar);
        this.f11305g = (TextView) findViewById(f.message);
        setPageResources();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.z1.b.d.b
    public LoadingView getLoadingView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.a.l0.a.c1.a.H().f(this, new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.a.l0.a.c1.a.H().g(this);
    }

    public void setMsg(int i2) {
        this.f11305g.setText(i2);
    }

    public void setPageResources() {
        View view = this.f11303e;
        if (view != null) {
            view.setBackground(view.getResources().getDrawable(e.aiapps_loading_bg));
        }
        SmoothProgressBar smoothProgressBar = this.f11304f;
        if (smoothProgressBar != null) {
            smoothProgressBar.setIndeterminateDrawable(smoothProgressBar.getResources().getDrawable(e.aiapps_loading_progress_animation));
        }
        TextView textView = this.f11305g;
        if (textView != null) {
            textView.setTextColor(textView.getResources().getColor(c.aiapps_loading_text_color));
        }
    }

    public void setMsg(String str) {
        this.f11305g.setText(str);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
