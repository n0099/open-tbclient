package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
/* loaded from: classes2.dex */
public class SmoothProgressBar extends RotateProgressBar {
    private static final int aHL;

    static {
        if (Build.VERSION.SDK_INT > 15) {
            aHL = 36;
        } else {
            aHL = 25;
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
        this.aHl = (int) ((((this.aHl * 12.0f) / aHL) / 2.0f) + 0.5f);
    }

    @Override // com.baidu.swan.apps.res.ui.RotateProgressBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.aHj;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.aHk >= this.aHl) {
                this.aHk = SystemClock.uptimeMillis();
                this.mDegree += 10000 / aHL;
                if (this.mDegree >= 10000) {
                    this.mDegree -= 10000;
                }
                drawable.setLevel(this.mDegree);
                postInvalidateDelayed(this.aHl);
            }
        }
    }
}
