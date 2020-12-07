package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import java.lang.reflect.Field;
/* loaded from: classes10.dex */
public class RotateProgressBar extends ProgressBar {
    protected static final int ANIMATION_RESOLUTION = 200;
    protected static final int INCREMENT = 30;
    protected static final int MAX_DEGREE = 360;
    protected static final int MAX_LEVEL = 10000;
    protected Drawable mCurrentDrawable;
    protected int mDegree;
    protected int mFrameDuration;
    protected long mLastDrawTime;

    public RotateProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDegree = 0;
        init();
    }

    public RotateProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDegree = 0;
        init();
    }

    public RotateProgressBar(Context context) {
        super(context);
        this.mDegree = 0;
        init();
    }

    private void init() {
        this.mFrameDuration = 200;
        try {
            Field declaredField = ProgressBar.class.getDeclaredField("mDuration");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                this.mFrameDuration = (int) ((declaredField.getInt(this) / 12.0f) + 0.5f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.mCurrentDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            long uptimeMillis = SystemClock.uptimeMillis() - this.mLastDrawTime;
            if (uptimeMillis < this.mFrameDuration) {
                postInvalidateDelayed(this.mFrameDuration - uptimeMillis);
            } else {
                this.mLastDrawTime = SystemClock.uptimeMillis();
                this.mDegree += 30;
                if (this.mDegree >= 360) {
                    this.mDegree = 0;
                }
                drawable.setLevel((int) ((this.mDegree * 10000) / 360.0f));
                postInvalidateDelayed(this.mFrameDuration);
            }
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminateDrawable(Drawable drawable) {
        super.setIndeterminateDrawable(drawable);
        if (isIndeterminate()) {
            this.mCurrentDrawable = drawable;
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        super.setIndeterminate(z);
        if (z) {
            this.mCurrentDrawable = getIndeterminateDrawable();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
    }
}
