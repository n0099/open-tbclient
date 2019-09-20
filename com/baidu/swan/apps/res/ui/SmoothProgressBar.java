package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
/* loaded from: classes2.dex */
public class SmoothProgressBar extends RotateProgressBar {
    private static final int aKL;

    static {
        if (Build.VERSION.SDK_INT > 15) {
            aKL = 36;
        } else {
            aKL = 25;
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
        this.aKl = (int) ((((this.aKl * 12.0f) / aKL) / 2.0f) + 0.5f);
    }

    @Override // com.baidu.swan.apps.res.ui.RotateProgressBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.aKj;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.aKk >= this.aKl) {
                this.aKk = SystemClock.uptimeMillis();
                this.mDegree += 10000 / aKL;
                if (this.mDegree >= 10000) {
                    this.mDegree += DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER;
                }
                drawable.setLevel(this.mDegree);
                postInvalidateDelayed(this.aKl);
            }
        }
    }
}
