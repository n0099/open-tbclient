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
    public static final int f12040i;

    static {
        if (Build.VERSION.SDK_INT > 15) {
            f12040i = 36;
        } else {
            f12040i = 25;
        }
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        this.f11992h = (int) ((((this.f11992h * 12.0f) / f12040i) / 2.0f) + 0.5f);
    }

    @Override // com.baidu.swan.apps.res.ui.RotateProgressBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.f11990f;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.f11991g >= this.f11992h) {
                this.f11991g = SystemClock.uptimeMillis();
                int i2 = this.f11989e + (10000 / f12040i);
                this.f11989e = i2;
                if (i2 >= 10000) {
                    this.f11989e = i2 - 10000;
                }
                drawable.setLevel(this.f11989e);
                postInvalidateDelayed(this.f11992h);
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
