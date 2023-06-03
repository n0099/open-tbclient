package com.baidu.searchbox.ui.pullrefresh;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
/* loaded from: classes4.dex */
public class NeutralRefreshAnimView extends View {
    public static final int ALPHA_ANIM_DURATION = 300;
    public static final int BALL_RADIUS = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 3.5f);
    public static final int COLOR_OF_BALLS = Color.parseColor("#000000");
    public static final String CREATEBITMAP_RUNNABLE_NAME = "CreateBitmapOnSizeChanged";
    public static final boolean DEBUG = false;
    public static final float FIFTY_PERCENT = 0.5f;
    public static final int HALF_MAX_DISTANCE;
    public static final int LEFT_BALL_ALPHA_THREAD = 26;
    public static final int MAX_DISTANCE;
    public static final int RIGHT_BALL_ALPHA_THREAD = 77;
    public static final int STATE_KEEP_POSITION = 4;
    public static final int STATE_ON_REFRESHING = 2;
    public static final int STATE_PULL_TO_REFRESH = 1;
    public static final int STATE_REFRESH_COMPLETE = 3;
    public static final String TAG = "NeutralRefreshAnimView";
    public static final int TRANSLATE_ANIM_DURATION = 480;
    public float mAnimPercent;
    public AnimatorSet mAnimatorSet;
    public Bitmap mBitmap;
    public Canvas mCanvas;
    public PointF mCenterPos;
    public int mHeight;
    public int mLeftAlpha;
    public ValueAnimator mLeftAlphaAnimator;
    public ValueAnimator mLeftBallAnimator;
    public float mLeftBallXPosi;
    public Paint mLeftPaint;
    public int mRightAlpha;
    public ValueAnimator mRightAlphaAnimator;
    public ValueAnimator mRightBallAnimator;
    public float mRightBallXPosi;
    public Paint mRightPaint;
    public int mState;
    public int mWidth;

    private int checkAlphaValue(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    static {
        int dp2px = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 18.0f);
        MAX_DISTANCE = dp2px;
        HALF_MAX_DISTANCE = dp2px >> 1;
    }

    private void init() {
        this.mCenterPos = new PointF();
        this.mLeftPaint = new Paint(1);
        this.mRightPaint = new Paint(1);
        this.mLeftPaint.setColor(COLOR_OF_BALLS);
        this.mRightPaint.setColor(COLOR_OF_BALLS);
    }

    private void resetAnimator() {
        resetAnimator(this.mLeftBallAnimator, true);
        resetAnimator(this.mRightBallAnimator, true);
        resetAnimator(this.mLeftAlphaAnimator, false);
        resetAnimator(this.mRightAlphaAnimator, false);
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
    }

    public void onRefreshCompleteAnim() {
        stopAnim();
        changeState(3);
        performRefreshCompleteAnim();
    }

    public void onRefreshingAnim() {
        changeState(2);
        performRefreshingAnim();
    }

    public void stopAnim() {
        resetAnimator();
        clearAnimation();
        changeState(1);
        postInvalidate();
    }

    public NeutralRefreshAnimView(Context context) {
        super(context);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeState(int i) {
        this.mState = i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int i = this.mState;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        performOnRefreshingAnim(canvas);
                    }
                } else {
                    performRefreshCompleteAnim(canvas);
                }
            } else {
                performOnRefreshingAnim(canvas);
            }
        } else {
            performPullToRefreshAnim(canvas);
        }
        canvas.restore();
    }

    public void setAnimPercent(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.mAnimPercent = f;
        changeState(1);
        postInvalidate();
    }

    public NeutralRefreshAnimView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void resetAnimator(ValueAnimator valueAnimator, boolean z) {
        if (valueAnimator != null) {
            if (z) {
                valueAnimator.setRepeatCount(0);
            }
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.end();
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mHeight = measuredHeight;
        this.mCenterPos.set(this.mWidth >> 1, measuredHeight >> 1);
    }

    private void performOnRefreshingAnim(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && this.mCanvas != null) {
            bitmap.eraseColor(0);
            this.mRightPaint.setAlpha(77);
            Canvas canvas2 = this.mCanvas;
            PointF pointF = this.mCenterPos;
            canvas2.drawCircle(pointF.x + this.mRightBallXPosi, pointF.y, BALL_RADIUS, this.mRightPaint);
            this.mLeftPaint.setAlpha(26);
            Canvas canvas3 = this.mCanvas;
            PointF pointF2 = this.mCenterPos;
            canvas3.drawCircle(pointF2.x + this.mLeftBallXPosi, pointF2.y, BALL_RADIUS, this.mLeftPaint);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void performRefreshCompleteAnim(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && this.mCanvas != null) {
            bitmap.eraseColor(0);
            this.mLeftAlpha = checkAlphaValue(this.mLeftAlpha);
            int checkAlphaValue = checkAlphaValue(this.mRightAlpha);
            this.mRightAlpha = checkAlphaValue;
            this.mRightPaint.setAlpha(checkAlphaValue);
            this.mLeftPaint.setAlpha(this.mLeftAlpha);
            Canvas canvas2 = this.mCanvas;
            PointF pointF = this.mCenterPos;
            canvas2.drawCircle(pointF.x + this.mRightBallXPosi, pointF.y, BALL_RADIUS, this.mRightPaint);
            this.mLeftPaint.setAlpha(this.mLeftAlpha);
            Canvas canvas3 = this.mCanvas;
            PointF pointF2 = this.mCenterPos;
            canvas3.drawCircle(pointF2.x + this.mLeftBallXPosi, pointF2.y, BALL_RADIUS, this.mLeftPaint);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void performPullToRefreshAnim(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && this.mCanvas != null) {
            bitmap.eraseColor(0);
            float f = this.mAnimPercent;
            if (f == 0.0f) {
                this.mRightPaint.setAlpha(0);
                Canvas canvas2 = this.mCanvas;
                PointF pointF = this.mCenterPos;
                canvas2.drawCircle(pointF.x, pointF.y, BALL_RADIUS, this.mRightPaint);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (f <= 0.5f) {
                this.mRightPaint.setAlpha((int) (f * 77.0f));
                Canvas canvas3 = this.mCanvas;
                PointF pointF2 = this.mCenterPos;
                canvas3.drawCircle(pointF2.x, pointF2.y, BALL_RADIUS, this.mRightPaint);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (f < 1.0f) {
                this.mRightPaint.setAlpha(checkAlphaValue((int) (f * 77.0f)));
                float f2 = (this.mAnimPercent - 0.5f) * 2.0f;
                this.mLeftPaint.setAlpha(checkAlphaValue((int) (26.0f * f2)));
                Canvas canvas4 = this.mCanvas;
                PointF pointF3 = this.mCenterPos;
                canvas4.drawCircle(pointF3.x + (HALF_MAX_DISTANCE * f2), pointF3.y, BALL_RADIUS, this.mRightPaint);
                Canvas canvas5 = this.mCanvas;
                PointF pointF4 = this.mCenterPos;
                canvas5.drawCircle(pointF4.x - (HALF_MAX_DISTANCE * f2), pointF4.y, BALL_RADIUS, this.mLeftPaint);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (f == 1.0f) {
                this.mLeftPaint.setAlpha(26);
                this.mRightPaint.setAlpha(77);
                Canvas canvas6 = this.mCanvas;
                PointF pointF5 = this.mCenterPos;
                canvas6.drawCircle(pointF5.x + HALF_MAX_DISTANCE, pointF5.y, BALL_RADIUS, this.mRightPaint);
                Canvas canvas7 = this.mCanvas;
                PointF pointF6 = this.mCenterPos;
                canvas7.drawCircle(pointF6.x - HALF_MAX_DISTANCE, pointF6.y, BALL_RADIUS, this.mLeftPaint);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            }
        }
    }

    private void performRefreshCompleteAnim() {
        ValueAnimator ofInt = ValueAnimator.ofInt(26, 0);
        this.mLeftAlphaAnimator = ofInt;
        ofInt.setDuration(300L);
        this.mLeftAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.mLeftAlpha = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.mLeftAlphaAnimator.isRunning()) {
            this.mLeftAlphaAnimator.start();
        }
        ValueAnimator ofInt2 = ValueAnimator.ofInt(77, 0);
        this.mRightAlphaAnimator = ofInt2;
        ofInt2.setDuration(300L);
        this.mRightAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.mRightAlpha = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.mRightAlphaAnimator.isRunning()) {
            this.mRightAlphaAnimator.start();
        }
    }

    private void performRefreshingAnim() {
        resetAnimator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.mRightBallAnimator = ofFloat;
        ofFloat.setDuration(480L);
        this.mRightBallAnimator.setRepeatMode(2);
        this.mRightBallAnimator.setRepeatCount(-1);
        this.mRightBallAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mRightBallAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.mRightBallXPosi = floatValue * NeutralRefreshAnimView.HALF_MAX_DISTANCE;
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.mLeftBallAnimator = ofFloat2;
        ofFloat2.setDuration(480L);
        this.mLeftBallAnimator.setRepeatMode(2);
        this.mLeftBallAnimator.setRepeatCount(-1);
        this.mLeftBallAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mLeftBallAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.mLeftBallXPosi = floatValue * NeutralRefreshAnimView.HALF_MAX_DISTANCE;
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.mAnimatorSet = animatorSet;
        animatorSet.playTogether(this.mLeftBallAnimator, this.mRightBallAnimator);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.changeState(4);
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.mAnimatorSet.isRunning()) {
            this.mAnimatorSet.start();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    NeutralRefreshAnimView.this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    NeutralRefreshAnimView.this.mCanvas = new Canvas(NeutralRefreshAnimView.this.mBitmap);
                }
            }, CREATEBITMAP_RUNNABLE_NAME, 2);
        }
    }
}
