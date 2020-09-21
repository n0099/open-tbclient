package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
/* loaded from: classes3.dex */
public class SmoothProgressBar extends RotateProgressBar {
    private static final int FRAME_RATE;

    static {
        if (Build.VERSION.SDK_INT > 15) {
            FRAME_RATE = 36;
        } else {
            FRAME_RATE = 25;
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
        this.mFrameDuration = (int) ((((this.mFrameDuration * 12.0f) / FRAME_RATE) / 2.0f) + 0.5f);
    }

    @Override // com.baidu.swan.apps.res.ui.RotateProgressBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.mCurrentDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.mLastDrawTime >= this.mFrameDuration) {
                this.mLastDrawTime = SystemClock.uptimeMillis();
                this.mDegree += 10000 / FRAME_RATE;
                if (this.mDegree >= 10000) {
                    this.mDegree += DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER;
                }
                drawable.setLevel(this.mDegree);
                postInvalidateDelayed(this.mFrameDuration);
            }
        }
    }
}
