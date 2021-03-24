package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
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
        this.f12472h = (int) ((((this.f12472h * 12.0f) / i) / 2.0f) + 0.5f);
    }

    @Override // com.baidu.swan.apps.res.ui.RotateProgressBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.f12470f;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.f12471g >= this.f12472h) {
                this.f12471g = SystemClock.uptimeMillis();
                int i2 = this.f12469e + (10000 / i);
                this.f12469e = i2;
                if (i2 >= 10000) {
                    this.f12469e = i2 - 10000;
                }
                drawable.setLevel(this.f12469e);
                postInvalidateDelayed(this.f12472h);
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
