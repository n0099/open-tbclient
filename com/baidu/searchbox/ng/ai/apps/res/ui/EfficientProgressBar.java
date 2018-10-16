package com.baidu.searchbox.ng.ai.apps.res.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
/* loaded from: classes2.dex */
public class EfficientProgressBar extends View {
    private static final int FIRST_DURATION = 1500;
    private static final int FIRST_MAX = 66;
    private static final int MAX_PROGRESS = 10000;
    public static final int PROGRESS_MAX_VALUE = 100;
    private static final int REFRESH_DELAY = 50;
    private static final int SECOND_DURATION = 200;
    private static final int SECOND_MAX = 100;
    private static final long UN_INITIALED = -1;
    private AnimationSet mAnimation;
    private float mDrawableOffset;
    private int mDrawedProgress;
    private int mFirstProgressMax;
    private Interpolator mInterpolator;
    private long mLastUpdateTime;
    private int mRealProgress;
    private Drawable mThumb;
    private Transformation mTrans;

    public EfficientProgressBar(Context context) {
        super(context);
        this.mFirstProgressMax = resolveProgress(66);
        this.mLastUpdateTime = -1L;
        this.mTrans = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.mDrawableOffset = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFirstProgressMax = resolveProgress(66);
        this.mLastUpdateTime = -1L;
        this.mTrans = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.mDrawableOffset = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFirstProgressMax = resolveProgress(66);
        this.mLastUpdateTime = -1L;
        this.mTrans = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.mDrawableOffset = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || getProgress(this.mRealProgress) != 100) {
            this.mRealProgress = resolveProgress(i);
            if (i == 100) {
                if (this.mAnimation == null) {
                    hide(z);
                }
            } else if (this.mLastUpdateTime == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.mDrawedProgress = 0;
        this.mRealProgress = 0;
        this.mLastUpdateTime = -1L;
        this.mAnimation = null;
        setProgressInAnimation(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void offsetDrawable() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.mDrawedProgress) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.mDrawableOffset = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.mThumb == null ? 0 : this.mThumb.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.mThumb != null) {
            this.mThumb.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mThumb != null) {
            if (this.mAnimation != null) {
                if (this.mAnimation.getTransformation(getDrawingTime(), this.mTrans)) {
                    setProgressInAnimation((int) (this.mTrans.getAlpha() * 10000.0f), false);
                } else {
                    this.mAnimation = null;
                    reset();
                }
            } else if (this.mLastUpdateTime != -1 && this.mDrawedProgress < this.mFirstProgressMax) {
                long currentTimeMillis = System.currentTimeMillis();
                int increment = getIncrement(currentTimeMillis - this.mLastUpdateTime);
                this.mDrawedProgress += increment;
                if (increment != 0) {
                    this.mLastUpdateTime = currentTimeMillis;
                    setProgressInAnimation(this.mDrawedProgress, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.mDrawableOffset + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.mThumb.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void setProgressInAnimation(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.mDrawedProgress = i;
        offsetDrawable();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.mDrawedProgress = 0;
        this.mRealProgress = 0;
        this.mAnimation = null;
        this.mLastUpdateTime = System.currentTimeMillis();
        setProgressInAnimation(this.mDrawedProgress, false);
        setVisibility(0);
    }

    private void hide(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.mAnimation = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.mDrawedProgress / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.mAnimation.addAnimation(alphaAnimation);
                this.mTrans.clear();
                this.mAnimation.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int getIncrement(long j) {
        return (int) ((resolveProgress(66) / 1500.0f) * ((float) j));
    }

    private int resolveProgress(int i) {
        return i * 100;
    }

    private int getProgress(int i) {
        return i / 100;
    }
}
