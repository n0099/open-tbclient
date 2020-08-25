package com.baidu.searchbox.suspensionwindow.cancelwindow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.text.DecimalFormat;
/* loaded from: classes6.dex */
public class SpreadView extends View {
    private static final Interpolator ACCELERATE = new AccelerateInterpolator();
    private static final Interpolator DECELERATE = new DecelerateInterpolator();
    public static final int STATE_EMPTY_FINISHED = 4;
    public static final int STATE_EMPTY_STARTED = 3;
    public static final int STATE_FILL_FINISHED = 2;
    public static final int STATE_FILL_STARTED = 1;
    public static final int STATE_NOT_STARTED = 0;
    private float mCurrentRadius;
    private int mDuration;
    private Paint mFillColor;
    private OnStateChangeListener mOnStateChangeListener;
    private float mRadius;
    private ObjectAnimator mSpreadAnimator;
    private int mStartLocationX;
    private int mStartLocationY;
    private int mState;

    /* loaded from: classes6.dex */
    public interface OnStateChangeListener {
        void onStateChange(int i);
    }

    public SpreadView(Context context) {
        super(context);
        this.mDuration = 400;
        this.mState = 0;
        init(context);
    }

    public SpreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDuration = 400;
        this.mState = 0;
        init(context);
    }

    public SpreadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDuration = 400;
        this.mState = 0;
        init(context);
    }

    @TargetApi(21)
    public SpreadView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mDuration = 400;
        this.mState = 0;
        init(context);
    }

    private void init(Context context) {
        this.mFillColor = new Paint();
        this.mFillColor.setStyle(Paint.Style.FILL);
        this.mFillColor.setColor(-1);
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        this.mRadius = Integer.valueOf(new DecimalFormat("0").format(StrictMath.pow(StrictMath.pow(i2, 2.0d) + StrictMath.pow(i, 2.0d), 0.5d))).intValue();
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setInterpolator() {
    }

    public void setFillColor(@ColorInt int i) {
        this.mFillColor.setColor(i);
    }

    public void startFromLocation(int[] iArr) {
        this.mStartLocationX = iArr[0];
        this.mStartLocationY = iArr[1];
        if (this.mSpreadAnimator != null) {
            this.mSpreadAnimator.cancel();
        }
        this.mSpreadAnimator = ObjectAnimator.ofFloat(this, "currentRadius", this.mCurrentRadius, this.mRadius).setDuration(this.mDuration);
        this.mSpreadAnimator.setInterpolator(ACCELERATE);
        this.mSpreadAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.suspensionwindow.cancelwindow.SpreadView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SpreadView.this.changeState(1);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SpreadView.this.changeState(2);
            }
        });
        this.mSpreadAnimator.start();
    }

    public void startToLocation() {
        if (this.mSpreadAnimator != null) {
            this.mSpreadAnimator.cancel();
        }
        this.mSpreadAnimator = ObjectAnimator.ofFloat(this, "currentRadius", this.mCurrentRadius, 0.0f).setDuration(this.mDuration);
        this.mSpreadAnimator.setInterpolator(DECELERATE);
        this.mSpreadAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.suspensionwindow.cancelwindow.SpreadView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SpreadView.this.changeState(3);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SpreadView.this.changeState(4);
            }
        });
        this.mSpreadAnimator.start();
    }

    public void setToFinishedFrame() {
        changeState(2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(this.mStartLocationX, this.mStartLocationY, this.mCurrentRadius, this.mFillColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeState(int i) {
        if (this.mState != i) {
            this.mState = i;
            if (this.mOnStateChangeListener != null) {
                this.mOnStateChangeListener.onStateChange(i);
            }
        }
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mOnStateChangeListener = onStateChangeListener;
    }

    public void setCurrentRadius(float f) {
        this.mCurrentRadius = f;
        invalidate();
    }
}
