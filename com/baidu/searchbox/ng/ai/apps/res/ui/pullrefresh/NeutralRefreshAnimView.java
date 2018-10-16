package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
/* loaded from: classes2.dex */
public class NeutralRefreshAnimView extends View {
    private static final int ALPHA_ANIM_DURATION = 300;
    private static final boolean DEBUG = false;
    private static final float FIFTY_PERCENT = 0.5f;
    private static final int LEFT_BALL_ALPHA_THREAD = 26;
    private static final int RIGHT_BALL_ALPHA_THREAD = 77;
    private static final int STATE_KEEP_POSITION = 4;
    private static final int STATE_ON_REFRESHING = 2;
    private static final int STATE_PULL_TO_REFRESH = 1;
    private static final int STATE_REFRESH_COMPLETE = 3;
    private static final String TAG = "NeutralRefreshAnimView";
    private static final int TRANSLATE_ANIM_DURATION = 480;
    private float mAnimPercent;
    private AnimatorSet mAnimatorSet;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private PointF mCenterPos;
    private int mHeight;
    private int mLeftAlpha;
    private ValueAnimator mLeftAlphaAnimator;
    private ValueAnimator mLeftBallAnimator;
    private float mLeftBallXPosi;
    private Paint mLeftPaint;
    private int mRightAlpha;
    private ValueAnimator mRightAlphaAnimator;
    private ValueAnimator mRightBallAnimator;
    private float mRightBallXPosi;
    private Paint mRightPaint;
    private int mState;
    private int mWidth;
    private static final int BALL_RADIUS = AiAppsUIUtils.dp2px(3.5f);
    private static final int COLOR_OF_BALLS = Color.parseColor("#000000");
    private static final int MAX_DISTANCE = AiAppsUIUtils.dp2px(18.0f);
    private static final int HALF_MAX_DISTANCE = MAX_DISTANCE >> 1;

    public NeutralRefreshAnimView(Context context) {
        super(context);
        init();
    }

    public NeutralRefreshAnimView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mCenterPos = new PointF();
        this.mLeftPaint = new Paint(1);
        this.mRightPaint = new Paint(1);
        this.mLeftPaint.setColor(COLOR_OF_BALLS);
        this.mRightPaint.setColor(COLOR_OF_BALLS);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.mAnimPercent = f2 <= 1.0f ? f2 : 1.0f;
        changeState(1);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.mCenterPos.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.mCanvas = new Canvas(this.mBitmap);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        switch (this.mState) {
            case 1:
                performPullToRefreshAnim(canvas);
                break;
            case 2:
                performOnRefreshingAnim(canvas);
                break;
            case 3:
                performRefreshCompleteAnim(canvas);
                break;
            case 4:
                performOnRefreshingAnim(canvas);
                break;
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeState(int i) {
        this.mState = i;
    }

    private void performPullToRefreshAnim(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            if (this.mAnimPercent == 0.0f) {
                this.mRightPaint.setAlpha(0);
                this.mCanvas.drawCircle(this.mCenterPos.x, this.mCenterPos.y, BALL_RADIUS, this.mRightPaint);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.mAnimPercent <= 0.5f) {
                this.mRightPaint.setAlpha((int) (this.mAnimPercent * 77.0f));
                this.mCanvas.drawCircle(this.mCenterPos.x, this.mCenterPos.y, BALL_RADIUS, this.mRightPaint);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.mAnimPercent < 1.0f) {
                this.mRightPaint.setAlpha(checkAlphaValue((int) (this.mAnimPercent * 77.0f)));
                float f = (this.mAnimPercent - 0.5f) * 2.0f;
                this.mLeftPaint.setAlpha(checkAlphaValue((int) (26.0f * f)));
                this.mCanvas.drawCircle(this.mCenterPos.x + (HALF_MAX_DISTANCE * f), this.mCenterPos.y, BALL_RADIUS, this.mRightPaint);
                this.mCanvas.drawCircle(this.mCenterPos.x - (f * HALF_MAX_DISTANCE), this.mCenterPos.y, BALL_RADIUS, this.mLeftPaint);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.mAnimPercent == 1.0f) {
                this.mLeftPaint.setAlpha(26);
                this.mRightPaint.setAlpha(77);
                this.mCanvas.drawCircle(this.mCenterPos.x + HALF_MAX_DISTANCE, this.mCenterPos.y, BALL_RADIUS, this.mRightPaint);
                this.mCanvas.drawCircle(this.mCenterPos.x - HALF_MAX_DISTANCE, this.mCenterPos.y, BALL_RADIUS, this.mLeftPaint);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            }
        }
    }

    public void onRefreshingAnim() {
        changeState(2);
        performRefreshingAnim();
    }

    private void performRefreshingAnim() {
        resetAnimator();
        this.mRightBallAnimator = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.mRightBallAnimator.setDuration(480L);
        this.mRightBallAnimator.setRepeatMode(2);
        this.mRightBallAnimator.setRepeatCount(-1);
        this.mRightBallAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mRightBallAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.mRightBallXPosi = floatValue * NeutralRefreshAnimView.HALF_MAX_DISTANCE;
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mLeftBallAnimator = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.mLeftBallAnimator.setDuration(480L);
        this.mLeftBallAnimator.setRepeatMode(2);
        this.mLeftBallAnimator.setRepeatCount(-1);
        this.mLeftBallAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mLeftBallAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.mLeftBallXPosi = floatValue * NeutralRefreshAnimView.HALF_MAX_DISTANCE;
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.mLeftBallAnimator, this.mRightBallAnimator);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.changeState(4);
                NeutralRefreshAnimView.this.postInvalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        if (!this.mAnimatorSet.isRunning()) {
            this.mAnimatorSet.start();
        }
    }

    private void performOnRefreshingAnim(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mRightPaint.setAlpha(77);
            this.mCanvas.drawCircle(this.mCenterPos.x + this.mRightBallXPosi, this.mCenterPos.y, BALL_RADIUS, this.mRightPaint);
            this.mLeftPaint.setAlpha(26);
            this.mCanvas.drawCircle(this.mCenterPos.x + this.mLeftBallXPosi, this.mCenterPos.y, BALL_RADIUS, this.mLeftPaint);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    public void onRefreshCompleteAnim() {
        stopAnim();
        changeState(3);
        performRefreshCompleteAnim();
    }

    private void performRefreshCompleteAnim() {
        this.mLeftAlphaAnimator = ValueAnimator.ofInt(26, 0);
        this.mLeftAlphaAnimator.setDuration(300L);
        this.mLeftAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.mLeftAlpha = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.mLeftAlphaAnimator.isRunning()) {
            this.mLeftAlphaAnimator.start();
        }
        this.mRightAlphaAnimator = ValueAnimator.ofInt(77, 0);
        this.mRightAlphaAnimator.setDuration(300L);
        this.mRightAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
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

    private void performRefreshCompleteAnim(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mLeftAlpha = checkAlphaValue(this.mLeftAlpha);
            this.mRightAlpha = checkAlphaValue(this.mRightAlpha);
            this.mRightPaint.setAlpha(this.mRightAlpha);
            this.mLeftPaint.setAlpha(this.mLeftAlpha);
            this.mCanvas.drawCircle(this.mCenterPos.x + this.mRightBallXPosi, this.mCenterPos.y, BALL_RADIUS, this.mRightPaint);
            this.mLeftPaint.setAlpha(this.mLeftAlpha);
            this.mCanvas.drawCircle(this.mCenterPos.x + this.mLeftBallXPosi, this.mCenterPos.y, BALL_RADIUS, this.mLeftPaint);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    public void stopAnim() {
        resetAnimator();
        clearAnimation();
        changeState(1);
        postInvalidate();
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

    private void resetAnimator() {
        resetAnimator(this.mLeftBallAnimator, true);
        resetAnimator(this.mRightBallAnimator, true);
        resetAnimator(this.mLeftAlphaAnimator, false);
        resetAnimator(this.mRightAlphaAnimator, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
    }

    private int checkAlphaValue(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
