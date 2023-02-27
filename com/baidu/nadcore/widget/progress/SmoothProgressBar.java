package com.baidu.nadcore.widget.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
/* loaded from: classes2.dex */
public class SmoothProgressBar extends RotateProgressBar {
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

    private void a() {
        this.d = (int) ((((this.d * 12.0f) / 36.0f) / 2.0f) + 0.5f);
    }

    @Override // com.baidu.nadcore.widget.progress.RotateProgressBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.c >= this.d) {
                this.c = SystemClock.uptimeMillis();
                int i = this.a + 277;
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
