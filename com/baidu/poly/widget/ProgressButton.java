package com.baidu.poly.widget;

import android.content.Context;
import android.content.res.TypedArray;
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
import d.b.c0.j;
/* loaded from: classes2.dex */
public class ProgressButton extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f10436e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f10437f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f10438g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10439h;

    public ProgressButton(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(g.button_progress, (ViewGroup) this, true);
        this.f10436e = (TextView) findViewById(f.text_view);
        this.f10437f = (ImageView) findViewById(f.progress_bar);
        this.f10438g = AnimationUtils.loadAnimation(context, b.loading_rotate);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ProgressButton);
        this.f10436e.setTextColor(obtainStyledAttributes.getColor(j.ProgressButton_textColor, -1));
        obtainStyledAttributes.recycle();
    }

    public void b() {
        this.f10437f.setVisibility(0);
        this.f10437f.startAnimation(this.f10438g);
        this.f10436e.setVisibility(4);
    }

    public void setEnable(boolean z) {
        super.setEnabled(z);
        this.f10439h = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        if (this.f10439h) {
            setAlpha(z ? 0.2f : 1.0f);
        } else {
            setAlpha(0.2f);
        }
    }

    public void setText(String str) {
        this.f10436e.setText(str);
        this.f10437f.setVisibility(4);
        this.f10436e.setVisibility(0);
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
