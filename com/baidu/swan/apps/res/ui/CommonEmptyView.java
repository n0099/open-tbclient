package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import d.a.i0.a.c;
import d.a.i0.a.d;
import d.a.i0.a.e;
import d.a.i0.a.f;
import d.a.i0.a.g;
/* loaded from: classes3.dex */
public class CommonEmptyView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f11173e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11174f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f11175g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f11176h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f11177i;
    public FrameLayout j;
    public TextView k;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.g2.a {
        public a() {
        }
    }

    public CommonEmptyView(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(g.aiapps_common_empty_view, (ViewGroup) this, true);
        setBackground(context.getResources().getDrawable(c.aiapps_empty_layout_backgroud));
        this.f11173e = (ImageView) findViewById(f.emptyview_image);
        this.f11174f = (TextView) findViewById(f.emptyview_title);
        this.f11175g = (TextView) findViewById(f.emptyview_subtitle);
        this.f11176h = (TextView) findViewById(f.emptyview_link);
        this.f11177i = (TextView) findViewById(f.emptyview_btn);
        this.j = (FrameLayout) findViewById(f.emptyview_bottom_layout);
        this.k = (TextView) findViewById(f.emptyview_problem_feedback);
        setPageResources();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.a.i0.a.c1.a.H().f(this, new a());
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FrameLayout frameLayout = this.j;
        if (frameLayout == null || frameLayout.getLayoutParams() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        int i2 = configuration.orientation;
        if (i2 == 1) {
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.aiapps_empty_view_bottom_margin_portrait);
        } else if (i2 == 2) {
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.aiapps_empty_view_bottom_margin_landscape);
        }
        this.j.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.a.i0.a.c1.a.H().g(this);
    }

    public void setButtonText(String str) {
        this.f11177i.setText(str);
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        this.f11177i.setTextColor(colorStateList);
    }

    public void setIcon(Drawable drawable) {
        this.f11173e.setImageDrawable(drawable);
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        this.f11176h.setVisibility(0);
        this.f11176h.setOnClickListener(onClickListener);
    }

    public void setPageResources() {
        setBackgroundColor(-1);
        TextView textView = this.f11174f;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(c.aiapps_emptyview_title_text_color));
        }
        TextView textView2 = this.f11176h;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
        }
        TextView textView3 = this.f11177i;
        if (textView3 != null) {
            textView3.setBackground(getResources().getDrawable(e.aiapps_emptyview_btn_bg));
            this.f11177i.setTextColor(getResources().getColorStateList(c.swan_app_emptyview_btn_text_color));
        }
        TextView textView4 = this.f11175g;
        if (textView4 != null) {
            textView4.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
        }
    }

    public void setSubTitle(String str) {
        this.f11175g.setVisibility(0);
        this.f11175g.setText(str);
        this.f11175g.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        this.f11177i.setVisibility(0);
        this.f11177i.setOnClickListener(onClickListener);
    }

    public void setTitle(String str) {
        this.f11174f.setText(str);
    }

    public void setTitleColor(int i2) {
        this.f11174f.setTextColor(i2);
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setButtonText(int i2) {
        this.f11177i.setText(i2);
    }

    public void setIcon(int i2) {
        this.f11173e.setImageDrawable(getResources().getDrawable(i2));
    }

    public void setTitle(int i2) {
        this.f11174f.setText(i2);
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    public void setSubTitle(int i2) {
        this.f11175g.setVisibility(0);
        this.f11175g.setText(i2);
        this.f11175g.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
    }
}
