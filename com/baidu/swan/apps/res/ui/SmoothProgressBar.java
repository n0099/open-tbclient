package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class SmoothProgressBar extends RotateProgressBar {
    public static final int e;

    static {
        if (Build.VERSION.SDK_INT > 15) {
            e = 36;
        } else {
            e = 25;
        }
    }

    private void a() {
        this.d = (int) ((((this.d * 12.0f) / e) / 2.0f) + 0.5f);
    }

    public SmoothProgressBar(Context context) {
        super(context);
        a();
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    @Override // com.baidu.swan.apps.res.ui.RotateProgressBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.c >= this.d) {
                this.c = SystemClock.uptimeMillis();
                int i = this.a + (10000 / e);
                this.a = i;
                if (i >= 10000) {
                    this.a = i - 10000;
                }
                drawable.setLevel(this.a);
                postInvalidateDelayed(this.d);
            }
        }
    }
}
