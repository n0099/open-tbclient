package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
/* loaded from: classes2.dex */
public class SmoothProgressBar extends RotateProgressBar {
    public static final int i;

    static {
        if (Build.VERSION.SDK_INT > 15) {
            i = 36;
        } else {
            i = 25;
        }
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        this.f12134h = (int) ((((this.f12134h * 12.0f) / i) / 2.0f) + 0.5f);
    }

    @Override // com.baidu.swan.apps.res.ui.RotateProgressBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.f12132f;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.f12133g >= this.f12134h) {
                this.f12133g = SystemClock.uptimeMillis();
                int i2 = this.f12131e + (10000 / i);
                this.f12131e = i2;
                if (i2 >= 10000) {
                    this.f12131e = i2 - 10000;
                }
                drawable.setLevel(this.f12131e);
                postInvalidateDelayed(this.f12134h);
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
