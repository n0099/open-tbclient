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
import d.b.a0.b;
import d.b.a0.f;
import d.b.a0.g;
/* loaded from: classes2.dex */
public class c extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f9986e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9987f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f9988g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9989h;

    public c(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(g.view_toast_loading, (ViewGroup) this, true);
        this.f9986e = (ImageView) findViewById(f.toast_loading_view);
        this.f9987f = (TextView) findViewById(f.toast_text_view);
        this.f9988g = AnimationUtils.loadAnimation(context, b.loading_rotate);
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
        return this.f9989h;
    }

    public void setLoading(boolean z) {
        b();
        this.f9989h = z;
        if (z) {
            setVisibility(0);
            this.f9986e.startAnimation(this.f9988g);
            return;
        }
        this.f9986e.clearAnimation();
        setVisibility(8);
    }

    public void setText(String str) {
        this.f9987f.setText(str);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
