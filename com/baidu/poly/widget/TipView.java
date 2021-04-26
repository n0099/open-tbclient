package com.baidu.poly.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import d.a.a0.b;
import d.a.a0.d;
import d.a.a0.f;
import d.a.a0.g;
/* loaded from: classes2.dex */
public class TipView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f10374e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f10375f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f10376g;

    public TipView(Context context) {
        this(context, null);
    }

    public void a(String str) {
        setVisibility(0);
        if (this.f10376g == null) {
            this.f10376g = AnimationUtils.loadAnimation(getContext(), b.loading_rotate);
        }
        this.f10375f.setText(str);
        ViewGroup.LayoutParams layoutParams = this.f10374e.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.channel_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.f10374e.startAnimation(this.f10376g);
    }

    public void b(String str, String str2) {
        setVisibility(0);
        this.f10374e.clearAnimation();
        ViewGroup.LayoutParams layoutParams = this.f10374e.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.pay_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        d.a.a0.k.d.b.c().b(this.f10374e, str);
        this.f10375f.setText(str2);
    }

    public final void c(Context context) {
        setOrientation(1);
        setGravity(17);
        LayoutInflater.from(context).inflate(g.view_tip, (ViewGroup) this, true);
        this.f10374e = (ImageView) findViewById(f.tip_loading_view);
        this.f10375f = (TextView) findViewById(f.tip_text_view);
    }

    public void d() {
        setVisibility(8);
        this.f10374e.clearAnimation();
    }

    public TipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context);
    }
}
