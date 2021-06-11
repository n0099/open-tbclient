package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import d.a.l0.a.v2.b0;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class BdBaseImageView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f11112e;

    /* renamed from: f  reason: collision with root package name */
    public int f11113f;

    public BdBaseImageView(Context context) {
        super(context);
        this.f11112e = true;
        this.f11113f = 0;
    }

    public final boolean a() {
        return Color.alpha(b0.d(getContext())) != 0;
    }

    public final boolean b() {
        return this.f11112e || this.f11113f != b0.d(getContext());
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (b()) {
            b0.b(getContext(), getDrawable());
            this.f11113f = b0.d(getContext());
            this.f11112e = false;
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i2) {
        if (a()) {
            b0.c(getContext(), getDrawable(), i2);
        } else {
            super.setImageAlpha(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.f11112e = true;
        super.setImageDrawable(drawable);
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11112e = true;
        this.f11113f = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11112e = true;
        this.f11113f = 0;
    }
}
