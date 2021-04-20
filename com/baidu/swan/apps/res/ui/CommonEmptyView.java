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
import d.b.g0.a.c;
import d.b.g0.a.d;
import d.b.g0.a.e;
import d.b.g0.a.f;
import d.b.g0.a.g;
/* loaded from: classes2.dex */
public class CommonEmptyView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f12103e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12104f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12105g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12106h;
    public TextView i;
    public FrameLayout j;
    public TextView k;

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.x1.a {
        public a() {
        }
    }

    public CommonEmptyView(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(g.aiapps_common_empty_view, (ViewGroup) this, true);
        setBackground(context.getResources().getDrawable(c.aiapps_empty_layout_backgroud));
        this.f12103e = (ImageView) findViewById(f.emptyview_image);
        this.f12104f = (TextView) findViewById(f.emptyview_title);
        this.f12105g = (TextView) findViewById(f.emptyview_subtitle);
        this.f12106h = (TextView) findViewById(f.emptyview_link);
        this.i = (TextView) findViewById(f.emptyview_btn);
        this.j = (FrameLayout) findViewById(f.emptyview_bottom_layout);
        this.k = (TextView) findViewById(f.emptyview_problem_feedback);
        setPageResources();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.b.g0.a.w0.a.z().f(this, new a());
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FrameLayout frameLayout = this.j;
        if (frameLayout == null || frameLayout.getLayoutParams() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        int i = configuration.orientation;
        if (i == 1) {
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.aiapps_empty_view_bottom_margin_portrait);
        } else if (i == 2) {
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.aiapps_empty_view_bottom_margin_landscape);
        }
        this.j.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.b.g0.a.w0.a.z().g(this);
    }

    public void setButtonText(String str) {
        this.i.setText(str);
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        this.i.setTextColor(colorStateList);
    }

    public void setIcon(Drawable drawable) {
        this.f12103e.setImageDrawable(drawable);
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        this.f12106h.setVisibility(0);
        this.f12106h.setOnClickListener(onClickListener);
    }

    public void setPageResources() {
        setBackgroundColor(getResources().getColor(c.aiapps_white));
        TextView textView = this.f12104f;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(c.aiapps_emptyview_title_text_color));
        }
        TextView textView2 = this.f12106h;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
        }
        TextView textView3 = this.i;
        if (textView3 != null) {
            textView3.setBackground(getResources().getDrawable(e.aiapps_emptyview_btn_bg));
            this.i.setTextColor(getResources().getColorStateList(c.swan_app_emptyview_btn_text_color));
        }
        TextView textView4 = this.f12105g;
        if (textView4 != null) {
            textView4.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
        }
    }

    public void setSubTitle(String str) {
        this.f12105g.setVisibility(0);
        this.f12105g.setText(str);
        this.f12105g.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        this.i.setVisibility(0);
        this.i.setOnClickListener(onClickListener);
    }

    public void setTitle(String str) {
        this.f12104f.setText(str);
    }

    public void setTitleColor(int i) {
        this.f12104f.setTextColor(i);
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setButtonText(int i) {
        this.i.setText(i);
    }

    public void setIcon(int i) {
        this.f12103e.setImageDrawable(getResources().getDrawable(i));
    }

    public void setTitle(int i) {
        this.f12104f.setText(i);
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void setSubTitle(int i) {
        this.f12105g.setVisibility(0);
        this.f12105g.setText(i);
        this.f12105g.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
    }
}
