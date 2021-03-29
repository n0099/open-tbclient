package com.baidu.poly.a.l;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import d.b.c0.b;
import d.b.c0.f;
import d.b.c0.g;
/* loaded from: classes2.dex */
public class c extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f10428e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f10429f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f10430g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10431h;

    public c(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(g.view_toast_loading, (ViewGroup) this, true);
        this.f10428e = (ImageView) findViewById(f.toast_loading_view);
        this.f10429f = (TextView) findViewById(f.toast_text_view);
        this.f10430g = AnimationUtils.loadAnimation(context, b.loading_rotate);
        setClickable(true);
    }

    public final void b() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    public boolean getIsLoading() {
        return this.f10431h;
    }

    public void setLoading(boolean z) {
        b();
        this.f10431h = z;
        if (z) {
            setVisibility(0);
            this.f10428e.startAnimation(this.f10430g);
            return;
        }
        this.f10428e.clearAnimation();
        setVisibility(8);
    }

    public void setText(String str) {
        this.f10429f.setText(str);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
