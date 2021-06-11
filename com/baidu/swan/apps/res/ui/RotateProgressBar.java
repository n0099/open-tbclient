package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class RotateProgressBar extends ProgressBar {

    /* renamed from: e  reason: collision with root package name */
    public int f11169e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f11170f;

    /* renamed from: g  reason: collision with root package name */
    public long f11171g;

    /* renamed from: h  reason: collision with root package name */
    public int f11172h;

    public RotateProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11169e = 0;
        a();
    }

    public final void a() {
        this.f11172h = 200;
        try {
            Field declaredField = ProgressBar.class.getDeclaredField("mDuration");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                this.f11172h = (int) ((declaredField.getInt(this) / 12.0f) + 0.5f);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.f11170f;
        if (drawable != null) {
            drawable.draw(canvas);
            long uptimeMillis = SystemClock.uptimeMillis() - this.f11171g;
            if (uptimeMillis < this.f11172h) {
                postInvalidateDelayed(this.f11172h - uptimeMillis);
            } else {
                this.f11171g = SystemClock.uptimeMillis();
                int i2 = this.f11169e + 30;
                this.f11169e = i2;
                if (i2 >= 360) {
                    this.f11169e = 0;
                }
                drawable.setLevel((int) ((this.f11169e * 10000) / 360.0f));
                postInvalidateDelayed(this.f11172h);
            }
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        super.setIndeterminate(z);
        if (z) {
            this.f11170f = getIndeterminateDrawable();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminateDrawable(Drawable drawable) {
        super.setIndeterminateDrawable(drawable);
        if (isIndeterminate()) {
            this.f11170f = drawable;
        }
    }

    public RotateProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11169e = 0;
        a();
    }

    public RotateProgressBar(Context context) {
        super(context);
        this.f11169e = 0;
        a();
    }
}
