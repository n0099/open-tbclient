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
    public int f12469e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f12470f;

    /* renamed from: g  reason: collision with root package name */
    public long f12471g;

    /* renamed from: h  reason: collision with root package name */
    public int f12472h;

    public RotateProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12469e = 0;
        a();
    }

    public final void a() {
        this.f12472h = 200;
        try {
            Field declaredField = ProgressBar.class.getDeclaredField("mDuration");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                this.f12472h = (int) ((declaredField.getInt(this) / 12.0f) + 0.5f);
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
        Drawable drawable = this.f12470f;
        if (drawable != null) {
            drawable.draw(canvas);
            long uptimeMillis = SystemClock.uptimeMillis() - this.f12471g;
            if (uptimeMillis < this.f12472h) {
                postInvalidateDelayed(this.f12472h - uptimeMillis);
            } else {
                this.f12471g = SystemClock.uptimeMillis();
                int i = this.f12469e + 30;
                this.f12469e = i;
                if (i >= 360) {
                    this.f12469e = 0;
                }
                drawable.setLevel((int) ((this.f12469e * 10000) / 360.0f));
                postInvalidateDelayed(this.f12472h);
            }
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        super.setIndeterminate(z);
        if (z) {
            this.f12470f = getIndeterminateDrawable();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminateDrawable(Drawable drawable) {
        super.setIndeterminateDrawable(drawable);
        if (isIndeterminate()) {
            this.f12470f = drawable;
        }
    }

    public RotateProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12469e = 0;
        a();
    }

    public RotateProgressBar(Context context) {
        super(context);
        this.f12469e = 0;
        a();
    }
}
