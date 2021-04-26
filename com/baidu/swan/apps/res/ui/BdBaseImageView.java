package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import d.a.h0.a.i2.z;
/* loaded from: classes3.dex */
public class BdBaseImageView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f11932e;

    /* renamed from: f  reason: collision with root package name */
    public int f11933f;

    public BdBaseImageView(Context context) {
        super(context);
        this.f11932e = true;
        this.f11933f = 0;
    }

    public final boolean a() {
        return Color.alpha(z.d(getContext())) != 0;
    }

    public final boolean b() {
        return this.f11932e || this.f11933f != z.d(getContext());
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (b()) {
            z.b(getContext(), getDrawable());
            this.f11933f = z.d(getContext());
            this.f11932e = false;
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i2) {
        if (a()) {
            z.c(getContext(), getDrawable(), i2);
        } else {
            super.setImageAlpha(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.f11932e = true;
        super.setImageDrawable(drawable);
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11932e = true;
        this.f11933f = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11932e = true;
        this.f11933f = 0;
    }
}
