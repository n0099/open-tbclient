package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
/* loaded from: classes2.dex */
public class SmoothProgressBar extends RotateProgressBar {
    private static final int aHI;

    static {
        if (Build.VERSION.SDK_INT > 15) {
            aHI = 36;
        } else {
            aHI = 25;
        }
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SmoothProgressBar(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.aHi = (int) ((((this.aHi * 12.0f) / aHI) / 2.0f) + 0.5f);
    }

    @Override // com.baidu.swan.apps.res.ui.RotateProgressBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.aHg;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.aHh >= this.aHi) {
                this.aHh = SystemClock.uptimeMillis();
                this.mDegree += 10000 / aHI;
                if (this.mDegree >= 10000) {
                    this.mDegree -= 10000;
                }
                drawable.setLevel(this.mDegree);
                postInvalidateDelayed(this.aHi);
            }
        }
    }
}
