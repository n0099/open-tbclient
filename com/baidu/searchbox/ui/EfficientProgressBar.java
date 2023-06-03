package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
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
/* loaded from: classes4.dex */
public class EfficientProgressBar extends View {
    public static final int FIRST_DURATION = 1500;
    public static final int FIRST_MAX = 66;
    public static final int MAX_PROGRESS = 10000;
    public static final int PROGRESS_MAX_VALUE = 100;
    public static final int REFRESH_DELAY = 50;
    public static final int SECOND_DURATION = 200;
    public static final int SECOND_MAX = 100;
    public static final long UN_INITIALED = -1;
    public AnimationSet mAnimation;
    public float mDrawableOffset;
    public int mDrawedProgress;
    public int mFirstProgressMax;
    public Interpolator mInterpolator;
    public long mLastUpdateTime;
    public int mRealProgress;
    public Drawable mThumb;
    public Transformation mTrans;

    private void init() {
    }

    private int resolveProgress(int i) {
        return i * 100;
    }

    public EfficientProgressBar(Context context) {
        super(context);
        this.mFirstProgressMax = resolveProgress(66);
        this.mLastUpdateTime = -1L;
        this.mTrans = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.mDrawableOffset = -1.0f;
        init();
    }

    private int getIncrement(long j) {
        return (int) ((resolveProgress(66) / 1500.0f) * ((float) j));
    }

    private int getProgress(int i) {
        return i / 100;
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
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

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int intrinsicHeight;
        int size = View.MeasureSpec.getSize(i);
        Drawable drawable = this.mThumb;
        if (drawable == null) {
            intrinsicHeight = 0;
        } else {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        setMeasuredDimension(size, intrinsicHeight + getPaddingBottom() + getPaddingTop());
    }

    public void setProgress(int i, boolean z) {
        if (i == 100 && getProgress(this.mRealProgress) == 100) {
            return;
        }
        this.mRealProgress = resolveProgress(i);
        if (i == 100) {
            if (this.mAnimation == null) {
                hide(z);
            }
        } else if (this.mLastUpdateTime == -1) {
            start();
        }
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

    @SuppressLint({"ObsoleteSdkInt"})
    @TargetApi(11)
    private void offsetDrawable() {
        float f;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (width > 0) {
            f = ((10000 - this.mDrawedProgress) / 10000.0f) * width;
        } else {
            f = -1.0f;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.mDrawableOffset = f;
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

    public void reset() {
        this.mDrawedProgress = 0;
        this.mRealProgress = 0;
        this.mLastUpdateTime = -1L;
        this.mAnimation = null;
        setProgressInAnimation(0, false);
        setVisibility(4);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mThumb != null) {
            AnimationSet animationSet = this.mAnimation;
            if (animationSet != null) {
                if (animationSet.getTransformation(getDrawingTime(), this.mTrans)) {
                    setProgressInAnimation((int) (this.mTrans.getAlpha() * 10000.0f), false);
                } else {
                    this.mAnimation = null;
                    reset();
                }
            } else if (this.mLastUpdateTime != -1 && this.mDrawedProgress < this.mFirstProgressMax) {
                long currentTimeMillis = System.currentTimeMillis();
                int increment = getIncrement(currentTimeMillis - this.mLastUpdateTime);
                int i = this.mDrawedProgress + increment;
                this.mDrawedProgress = i;
                if (increment != 0) {
                    this.mLastUpdateTime = currentTimeMillis;
                    setProgressInAnimation(i, true);
                }
            }
            int i2 = -1;
            if (getPaddingLeft() > 0) {
                i2 = canvas.save();
                canvas.clipRect(this.mDrawableOffset + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.mThumb.draw(canvas);
            if (i2 >= 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        if (z && (drawable = this.mThumb) != null) {
            drawable.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }
}
