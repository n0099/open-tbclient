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
    private static final int bdY;

    static {
        if (Build.VERSION.SDK_INT > 15) {
            bdY = 36;
        } else {
            bdY = 25;
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
        this.bdy = (int) ((((this.bdy * 12.0f) / bdY) / 2.0f) + 0.5f);
    }

    @Override // com.baidu.swan.apps.res.ui.RotateProgressBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.bdw;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.bdx >= this.bdy) {
                this.bdx = SystemClock.uptimeMillis();
                this.mDegree += 10000 / bdY;
                if (this.mDegree >= 10000) {
                    this.mDegree += DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER;
                }
                drawable.setLevel(this.mDegree);
                postInvalidateDelayed(this.bdy);
            }
        }
    }
}
