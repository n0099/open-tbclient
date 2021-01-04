package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
/* loaded from: classes9.dex */
public class SmoothProgressBar extends RotateProgressBar {
    private static final int dAj;

    static {
        if (Build.VERSION.SDK_INT > 15) {
            dAj = 36;
        } else {
            dAj = 25;
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
        this.dyZ = (int) ((((this.dyZ * 12.0f) / dAj) / 2.0f) + 0.5f);
    }

    @Override // com.baidu.swan.apps.res.ui.RotateProgressBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.dyX;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.dyY >= this.dyZ) {
                this.dyY = SystemClock.uptimeMillis();
                this.mDegree += 10000 / dAj;
                if (this.mDegree >= 10000) {
                    this.mDegree += DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER;
                }
                drawable.setLevel(this.mDegree);
                postInvalidateDelayed(this.dyZ);
            }
        }
    }
}
