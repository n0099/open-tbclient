package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import d.b.g0.a.i2.z;
/* loaded from: classes2.dex */
public class BdBaseImageView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f12082e;

    /* renamed from: f  reason: collision with root package name */
    public int f12083f;

    public BdBaseImageView(Context context) {
        super(context);
        this.f12082e = true;
        this.f12083f = 0;
    }

    public final boolean a() {
        return Color.alpha(z.d(getContext())) != 0;
    }

    public final boolean b() {
        return this.f12082e || this.f12083f != z.d(getContext());
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (b()) {
            z.b(getContext(), getDrawable());
            this.f12083f = z.d(getContext());
            this.f12082e = false;
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
        this.f12082e = true;
        super.setImageDrawable(drawable);
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12082e = true;
        this.f12083f = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12082e = true;
        this.f12083f = 0;
    }
}
