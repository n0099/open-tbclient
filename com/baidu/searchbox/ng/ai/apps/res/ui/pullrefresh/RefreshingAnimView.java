package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
/* loaded from: classes2.dex */
public class RefreshingAnimView extends View {
    public static final long CIRCULAR_ROTATION_DURATION = 750;
    private static final boolean DEBUG_MONITOR_ANIM = true;
    private static final float DIV_15_75 = 0.2f;
    private static final float DIV_60_75 = 0.8f;
    private static final float MAGNIFIER_ANIM_CRITICAL_HANDLER = 0.625f;
    private static final float MAGNIFIER_ANIM_CRITICAL_INNER_CIRCLE = 0.5f;
    private static final float MAGNIFIER_INNER_CIRCLE_RADIUS_DP = 6.5f;
    private static final float MAGNIFIER_OUTER_CIRCLE_RADIUS_DP = 8.0f;
    public static final long MAGNIFIER_ROTATION_DURATION = 300;
    private static final float MAGNIFIER_STICKER_LENGTH_DP = 5.0f;
    private static final int PAINT_ALPHA = 76;
    private static final float PROGRESS_CIRCULAR_RADIUS_DP = 7.5f;
    private static final double SQRT_TWO = Math.sqrt(2.0d);
    private static final float START_ANGLE = -90.0f;
    public static final int STATE_CIRCULAR_ROTATION = 3;
    public static final int STATE_MAGNIFIER = 1;
    public static final int STATE_MAGNIFIER_ROTATION = 2;
    private static final float SWEEP_ANGLE = -360.0f;
    private static final String TAG = "RefreshingAnimView";
    private int mAtLeastRounds;
    private Bitmap mBitmap;
    private Camera mCamera;
    private Canvas mCanvas;
    private PointF mCanvasCenterPt;
    private ValueAnimator mCircularRotateAnimator;
    private float mCircularRotation;
    private boolean mIsNightMode;
    float mMagnifierAnimatedValue;
    float mMagnifierCircleAnimPercent;
    private PointF mMagnifierCircleCenterPt;
    float mMagnifierInnerCircleMaxRadius;
    float mMagnifierInnerCircleRadius;
    float mMagnifierOuterCircleRadius;
    private RectF mMagnifierOuterCircleRect;
    private ValueAnimator mMagnifierRotateAnimator;
    private float mMagnifierRotateFactor;
    float mMagnifierStickAnimPercent;
    private Matrix mMatrix;
    private OnLoadingAnimationListener mOnLoadingAnimationListener;
    private Paint mPaint;
    float mProgressCircularRadius;
    private int mRotationRounds;
    private int mState;
    private PointF mStickEndPt;
    private float mStickLength;
    private PointF mStickStartPt;
    private Paint mTransparentPaint;
    private float mWidth;

    /* loaded from: classes2.dex */
    public interface OnLoadingAnimationListener {
        void notifyAtLeastRoundsFinished(boolean z);
    }

    static /* synthetic */ int access$308(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.mRotationRounds;
        refreshingAnimView.mRotationRounds = i + 1;
        return i;
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.mMagnifierAnimatedValue = 0.0f;
        this.mMagnifierCircleAnimPercent = 0.0f;
        this.mMagnifierStickAnimPercent = 0.0f;
        this.mMagnifierOuterCircleRadius = 0.0f;
        this.mMagnifierInnerCircleRadius = 0.0f;
        this.mMagnifierInnerCircleMaxRadius = 0.0f;
        this.mProgressCircularRadius = 0.0f;
        this.mWidth = 0.0f;
        this.mCanvasCenterPt = new PointF();
        this.mMagnifierOuterCircleRect = new RectF();
        this.mMagnifierCircleCenterPt = new PointF();
        this.mStickStartPt = new PointF();
        this.mStickEndPt = new PointF();
        this.mStickLength = 0.0f;
        this.mAtLeastRounds = 0;
        this.mRotationRounds = 1;
        this.mCircularRotateAnimator = null;
        this.mCircularRotation = 0.0f;
        this.mMagnifierRotateFactor = 0.0f;
        this.mMagnifierRotateAnimator = null;
        this.mIsNightMode = false;
        this.mState = 0;
        initPaint();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMagnifierAnimatedValue = 0.0f;
        this.mMagnifierCircleAnimPercent = 0.0f;
        this.mMagnifierStickAnimPercent = 0.0f;
        this.mMagnifierOuterCircleRadius = 0.0f;
        this.mMagnifierInnerCircleRadius = 0.0f;
        this.mMagnifierInnerCircleMaxRadius = 0.0f;
        this.mProgressCircularRadius = 0.0f;
        this.mWidth = 0.0f;
        this.mCanvasCenterPt = new PointF();
        this.mMagnifierOuterCircleRect = new RectF();
        this.mMagnifierCircleCenterPt = new PointF();
        this.mStickStartPt = new PointF();
        this.mStickEndPt = new PointF();
        this.mStickLength = 0.0f;
        this.mAtLeastRounds = 0;
        this.mRotationRounds = 1;
        this.mCircularRotateAnimator = null;
        this.mCircularRotation = 0.0f;
        this.mMagnifierRotateFactor = 0.0f;
        this.mMagnifierRotateAnimator = null;
        this.mIsNightMode = false;
        this.mState = 0;
        initPaint();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMagnifierAnimatedValue = 0.0f;
        this.mMagnifierCircleAnimPercent = 0.0f;
        this.mMagnifierStickAnimPercent = 0.0f;
        this.mMagnifierOuterCircleRadius = 0.0f;
        this.mMagnifierInnerCircleRadius = 0.0f;
        this.mMagnifierInnerCircleMaxRadius = 0.0f;
        this.mProgressCircularRadius = 0.0f;
        this.mWidth = 0.0f;
        this.mCanvasCenterPt = new PointF();
        this.mMagnifierOuterCircleRect = new RectF();
        this.mMagnifierCircleCenterPt = new PointF();
        this.mStickStartPt = new PointF();
        this.mStickEndPt = new PointF();
        this.mStickLength = 0.0f;
        this.mAtLeastRounds = 0;
        this.mRotationRounds = 1;
        this.mCircularRotateAnimator = null;
        this.mCircularRotation = 0.0f;
        this.mMagnifierRotateFactor = 0.0f;
        this.mMagnifierRotateAnimator = null;
        this.mIsNightMode = false;
        this.mState = 0;
        initPaint();
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        this.mMagnifierAnimatedValue = f2 <= 1.0f ? f2 : 1.0f;
        calculateMagnifierAnimFactor();
        postInvalidate();
    }

    public void startMagnifierRotate() {
        startMagnifierRotate(300L);
    }

    private void startMagnifierRotate(long j) {
        changeState(2);
        if (this.mMagnifierRotateAnimator != null) {
            resetAnimator();
        }
        this.mMagnifierRotateAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mMagnifierRotateAnimator.setDuration(j);
        this.mMagnifierRotateAnimator.setInterpolator(new LinearInterpolator());
        this.mMagnifierRotateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.performMagnifierRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mMagnifierRotateAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.startCircularRotate(750L);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
            }
        });
        if (!this.mMagnifierRotateAnimator.isRunning()) {
            this.mMagnifierRotateAnimator.start();
        }
    }

    public boolean isCircleRotateAnimating() {
        if (this.mCircularRotateAnimator != null) {
            return this.mCircularRotateAnimator.isRunning();
        }
        return false;
    }

    public boolean isMagnifierRotateAnimating() {
        if (this.mMagnifierRotateAnimator != null) {
            return this.mMagnifierRotateAnimator.isRunning();
        }
        return false;
    }

    public void startCircularRotate() {
        startCircularRotate(750L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCircularRotate(long j) {
        changeState(3);
        if (this.mCircularRotateAnimator != null) {
            resetAnimator();
        }
        this.mCircularRotateAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mCircularRotateAnimator.setDuration(j);
        this.mCircularRotateAnimator.setInterpolator(new LinearInterpolator());
        this.mCircularRotateAnimator.setRepeatCount(-1);
        this.mCircularRotateAnimator.setRepeatMode(1);
        this.mCircularRotateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.performCircularRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.mAtLeastRounds > 0) {
            this.mCircularRotateAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.RefreshingAnimView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    RefreshingAnimView.access$308(RefreshingAnimView.this);
                    if (RefreshingAnimView.this.mRotationRounds > RefreshingAnimView.this.mAtLeastRounds && RefreshingAnimView.this.mOnLoadingAnimationListener != null) {
                        RefreshingAnimView.this.mOnLoadingAnimationListener.notifyAtLeastRoundsFinished(true);
                    }
                }
            });
        } else if (this.mOnLoadingAnimationListener != null) {
            this.mOnLoadingAnimationListener.notifyAtLeastRoundsFinished(true);
        }
        if (!this.mCircularRotateAnimator.isRunning()) {
            this.mCircularRotateAnimator.start();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        this.mAtLeastRounds = i;
    }

    public void setOnLoadingAnimationListener(OnLoadingAnimationListener onLoadingAnimationListener) {
        this.mOnLoadingAnimationListener = onLoadingAnimationListener;
    }

    public void stopAnim() {
        resetAnimator();
        clearAnimation();
        this.mMagnifierAnimatedValue = 0.0f;
        this.mRotationRounds = 1;
        changeState(1);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.mWidth = getMeasuredHeight();
        } else {
            this.mWidth = getMeasuredWidth();
        }
        this.mMagnifierOuterCircleRadius = AiAppsUIUtils.dip2px(getContext(), MAGNIFIER_OUTER_CIRCLE_RADIUS_DP);
        this.mMagnifierInnerCircleMaxRadius = AiAppsUIUtils.dip2px(getContext(), MAGNIFIER_INNER_CIRCLE_RADIUS_DP);
        this.mStickLength = AiAppsUIUtils.dip2px(getContext(), MAGNIFIER_STICKER_LENGTH_DP);
        this.mProgressCircularRadius = AiAppsUIUtils.dip2px(getContext(), PROGRESS_CIRCULAR_RADIUS_DP);
        float f = this.mWidth / 2.0f;
        this.mCanvasCenterPt.set(f, f);
        float f2 = f + ((float) (this.mMagnifierOuterCircleRadius / SQRT_TWO));
        this.mStickStartPt.set(f2, f2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        switch (this.mState) {
            case 1:
                drawMagnifier(canvas);
                break;
            case 2:
                drawMagnifierRotation(canvas);
                break;
            case 3:
                drawCircularRotation(canvas);
                break;
        }
        canvas.restore();
        Log.w(TAG, "onDraw->mState:" + stateToStr() + ";AnimValue:" + this.mMagnifierAnimatedValue);
    }

    private void drawMagnifier(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.mIsNightMode != AiAppNightModeHelper.getNightModeSwitcherState()) {
                this.mPaint.setColor(getResources().getColor(R.color.aiapps_pull_loading_refresh_anim_color));
                this.mIsNightMode = AiAppNightModeHelper.getNightModeSwitcherState();
            }
            this.mPaint.setAlpha(76);
            this.mMagnifierOuterCircleRect.set(this.mCanvasCenterPt.x - this.mMagnifierOuterCircleRadius, this.mCanvasCenterPt.y - this.mMagnifierOuterCircleRadius, this.mCanvasCenterPt.x + this.mMagnifierOuterCircleRadius, this.mCanvasCenterPt.y + this.mMagnifierOuterCircleRadius);
            this.mCanvas.drawArc(this.mMagnifierOuterCircleRect, START_ANGLE, SWEEP_ANGLE * this.mMagnifierCircleAnimPercent, true, this.mPaint);
            this.mCanvas.drawCircle(this.mCanvasCenterPt.x, this.mCanvasCenterPt.y, this.mMagnifierInnerCircleRadius, this.mTransparentPaint);
            if (this.mMagnifierStickAnimPercent > 0.0f) {
                this.mCanvas.drawCircle(this.mStickEndPt.x, this.mStickEndPt.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(AiAppsUIUtils.dip2px(getContext(), 1.5f));
                this.mCanvas.drawLine(this.mStickStartPt.x, this.mStickStartPt.y, this.mStickEndPt.x, this.mStickEndPt.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void calculateMagnifierAnimFactor() {
        this.mMagnifierCircleAnimPercent = this.mMagnifierAnimatedValue;
        if (this.mMagnifierAnimatedValue < 0.5f) {
            this.mMagnifierStickAnimPercent = 0.0f;
            this.mMagnifierInnerCircleRadius = 0.0f;
            return;
        }
        this.mMagnifierInnerCircleRadius = ((this.mMagnifierAnimatedValue - 0.5f) / 0.5f) * this.mMagnifierInnerCircleMaxRadius;
        if (this.mMagnifierAnimatedValue < MAGNIFIER_ANIM_CRITICAL_HANDLER) {
            this.mMagnifierStickAnimPercent = 0.0f;
            return;
        }
        this.mMagnifierStickAnimPercent = (this.mMagnifierAnimatedValue - MAGNIFIER_ANIM_CRITICAL_HANDLER) / 0.375f;
        this.mStickEndPt.set(this.mStickStartPt.x + ((float) ((this.mStickLength * this.mMagnifierStickAnimPercent) / SQRT_TWO)), this.mStickStartPt.y + ((float) ((this.mStickLength * this.mMagnifierStickAnimPercent) / SQRT_TWO)));
    }

    private void drawMagnifierRotation(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setAlpha((int) (255.0d * ((this.mMagnifierRotateFactor * 0.3d) + 0.3d)));
            float f = this.mStickStartPt.x + ((float) (this.mStickLength / SQRT_TWO));
            this.mCanvas.drawCircle(this.mCanvasCenterPt.x, this.mCanvasCenterPt.y, this.mMagnifierOuterCircleRadius, this.mPaint);
            this.mCanvas.drawCircle(this.mCanvasCenterPt.x, this.mCanvasCenterPt.y, this.mMagnifierInnerCircleMaxRadius, this.mTransparentPaint);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(AiAppsUIUtils.dip2px(getContext(), 1.5f));
            this.mCanvas.drawLine(this.mStickStartPt.x, this.mStickStartPt.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.mMagnifierRotateFactor * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.mCanvasCenterPt.x, -this.mCanvasCenterPt.y);
            this.mMatrix.postTranslate(this.mCanvasCenterPt.x, this.mCanvasCenterPt.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performMagnifierRotation(float f) {
        this.mMagnifierRotateFactor = f;
        postInvalidate();
    }

    private void drawCircularRotation(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.mCircularRotation - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.mIsNightMode) {
                abs = (int) ((((1.0d - (Math.abs(this.mCircularRotation - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setAlpha(abs);
            this.mCanvas.drawCircle(this.mCanvasCenterPt.x, this.mCanvasCenterPt.y, this.mProgressCircularRadius, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.mCircularRotation * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate(-this.mCanvasCenterPt.x, -this.mCanvasCenterPt.y);
            this.mMatrix.postTranslate(this.mCanvasCenterPt.x, this.mCanvasCenterPt.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performCircularRotation(float f) {
        if (f < DIV_15_75) {
            this.mCircularRotation = (f / DIV_15_75) * 0.5f;
        } else {
            this.mCircularRotation = (((f - DIV_15_75) / DIV_60_75) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    private void initPaint() {
        this.mIsNightMode = AiAppNightModeHelper.getNightModeSwitcherState();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(R.color.aiapps_pull_loading_refresh_anim_color));
        this.mTransparentPaint = new Paint();
        this.mTransparentPaint.setAntiAlias(true);
        this.mTransparentPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mCamera = new Camera();
        this.mMatrix = new Matrix();
        changeState(1);
    }

    private void changeState(int i) {
        this.mState = i;
    }

    private String stateToStr() {
        switch (this.mState) {
            case 1:
                return "Magnifier";
            case 2:
                return "Transitions";
            case 3:
                return "Radar";
            default:
                return "None";
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.mCanvas = new Canvas(this.mBitmap);
        }
    }

    private void resetAnimator() {
        if (this.mMagnifierRotateAnimator != null) {
            this.mMagnifierRotateAnimator.setRepeatCount(0);
            this.mMagnifierRotateAnimator.removeAllUpdateListeners();
            this.mMagnifierRotateAnimator.removeAllListeners();
            this.mMagnifierRotateAnimator.end();
            this.mMagnifierRotateAnimator.cancel();
        }
        if (this.mCircularRotateAnimator != null) {
            this.mCircularRotateAnimator.setRepeatCount(0);
            this.mCircularRotateAnimator.removeAllUpdateListeners();
            this.mCircularRotateAnimator.removeAllListeners();
            this.mCircularRotateAnimator.end();
            this.mCircularRotateAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetAnimator();
    }
}
