package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class SmoothProgressBar extends RotateProgressBar {

    /* renamed from: i  reason: collision with root package name */
    public static final int f11279i;

    static {
        if (Build.VERSION.SDK_INT > 15) {
            f11279i = 36;
        } else {
            f11279i = 25;
        }
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        this.f11254h = (int) ((((this.f11254h * 12.0f) / f11279i) / 2.0f) + 0.5f);
    }

    @Override // com.baidu.swan.apps.res.ui.RotateProgressBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.f11252f;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.f11253g >= this.f11254h) {
                this.f11253g = SystemClock.uptimeMillis();
                int i2 = this.f11251e + (10000 / f11279i);
                this.f11251e = i2;
                if (i2 >= 10000) {
                    this.f11251e = i2 - 10000;
                }
                drawable.setLevel(this.f11251e);
                postInvalidateDelayed(this.f11254h);
            }
        }
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SmoothProgressBar(Context context) {
        super(context);
        a();
    }
}
