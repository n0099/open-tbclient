package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class SmoothProgressBar extends RotateProgressBar {
    public static final int FRAME_RATE = 36;

    public SmoothProgressBar(Context context) {
        super(context);
        init();
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mFrameDuration = (int) ((((this.mFrameDuration * 12.0f) / 36.0f) / 2.0f) + 0.5f);
    }

    @Override // com.baidu.searchbox.ui.RotateProgressBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.mCurrentDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.mLastDrawTime >= this.mFrameDuration) {
                this.mLastDrawTime = SystemClock.uptimeMillis();
                int i = this.mDegree + 277;
                this.mDegree = i;
                if (i >= 10000) {
                    this.mDegree = i - 10000;
                }
                drawable.setLevel(this.mDegree);
                postInvalidateDelayed(this.mFrameDuration);
            }
        }
    }
}
