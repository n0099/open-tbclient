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
import d.a.m0.a.c;
import d.a.m0.a.d;
import d.a.m0.a.e;
import d.a.m0.a.f;
import d.a.m0.a.g;
/* loaded from: classes3.dex */
public class CommonEmptyView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f11218e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11219f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f11220g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f11221h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f11222i;
    public FrameLayout j;
    public TextView k;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.g2.a {
        public a() {
        }
    }

    public CommonEmptyView(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(g.aiapps_common_empty_view, (ViewGroup) this, true);
        setBackground(context.getResources().getDrawable(c.aiapps_empty_layout_backgroud));
        this.f11218e = (ImageView) findViewById(f.emptyview_image);
        this.f11219f = (TextView) findViewById(f.emptyview_title);
        this.f11220g = (TextView) findViewById(f.emptyview_subtitle);
        this.f11221h = (TextView) findViewById(f.emptyview_link);
        this.f11222i = (TextView) findViewById(f.emptyview_btn);
        this.j = (FrameLayout) findViewById(f.emptyview_bottom_layout);
        this.k = (TextView) findViewById(f.emptyview_problem_feedback);
        setPageResources();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.a.m0.a.c1.a.H().f(this, new a());
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
        d.a.m0.a.c1.a.H().g(this);
    }

    public void setButtonText(String str) {
        this.f11222i.setText(str);
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        this.f11222i.setTextColor(colorStateList);
    }

    public void setIcon(Drawable drawable) {
        this.f11218e.setImageDrawable(drawable);
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        this.f11221h.setVisibility(0);
        this.f11221h.setOnClickListener(onClickListener);
    }

    public void setPageResources() {
        setBackgroundColor(-1);
        TextView textView = this.f11219f;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(c.aiapps_emptyview_title_text_color));
        }
        TextView textView2 = this.f11221h;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
        }
        TextView textView3 = this.f11222i;
        if (textView3 != null) {
            textView3.setBackground(getResources().getDrawable(e.aiapps_emptyview_btn_bg));
            this.f11222i.setTextColor(getResources().getColorStateList(c.swan_app_emptyview_btn_text_color));
        }
        TextView textView4 = this.f11220g;
        if (textView4 != null) {
            textView4.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
        }
    }

    public void setSubTitle(String str) {
        this.f11220g.setVisibility(0);
        this.f11220g.setText(str);
        this.f11220g.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        this.f11222i.setVisibility(0);
        this.f11222i.setOnClickListener(onClickListener);
    }

    public void setTitle(String str) {
        this.f11219f.setText(str);
    }

    public void setTitleColor(int i2) {
        this.f11219f.setTextColor(i2);
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setButtonText(int i2) {
        this.f11222i.setText(i2);
    }

    public void setIcon(int i2) {
        this.f11218e.setImageDrawable(getResources().getDrawable(i2));
    }

    public void setTitle(int i2) {
        this.f11219f.setText(i2);
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    public void setSubTitle(int i2) {
        this.f11220g.setVisibility(0);
        this.f11220g.setText(i2);
        this.f11220g.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
    }
}
