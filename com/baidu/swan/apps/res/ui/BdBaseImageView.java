package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import d.b.h0.a.i2.z;
/* loaded from: classes3.dex */
public class BdBaseImageView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f12090e;

    /* renamed from: f  reason: collision with root package name */
    public int f12091f;

    public BdBaseImageView(Context context) {
        super(context);
        this.f12090e = true;
        this.f12091f = 0;
    }

    public final boolean a() {
        return Color.alpha(z.d(getContext())) != 0;
    }

    public final boolean b() {
        return this.f12090e || this.f12091f != z.d(getContext());
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (b()) {
            z.b(getContext(), getDrawable());
            this.f12091f = z.d(getContext());
            this.f12090e = false;
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        if (a()) {
            z.c(getContext(), getDrawable(), i);
        } else {
            super.setImageAlpha(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.f12090e = true;
        super.setImageDrawable(drawable);
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12090e = true;
        this.f12091f = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12090e = true;
        this.f12091f = 0;
    }
}
