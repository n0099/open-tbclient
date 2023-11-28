package com.baidu.searchbox.ui.pullrefresh;

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
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorRes;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.skin.NightModeHelper;
/* loaded from: classes4.dex */
public class RefreshingAnimView extends View {
    public static final long CIRCULAR_ROTATION_DURATION = 750;
    public static final boolean DEBUG_MONITOR_ANIM = true;
    public static final float DIV_15_75 = 0.2f;
    public static final float DIV_60_75 = 0.8f;
    public static final float MAGNIFIER_ANIM_CRITICAL_HANDLER = 0.625f;
    public static final float MAGNIFIER_ANIM_CRITICAL_INNER_CIRCLE = 0.5f;
    public static final float MAGNIFIER_INNER_CIRCLE_RADIUS_DP = 6.5f;
    public static final float MAGNIFIER_OUTER_CIRCLE_RADIUS_DP = 8.0f;
    public static final long MAGNIFIER_ROTATION_DURATION = 300;
    public static final float MAGNIFIER_STICKER_LENGTH_DP = 5.0f;
    public static final int PAINT_ALPHA = 76;
    public static final float PROGRESS_CIRCULAR_RADIUS_DP = 7.5f;
    public static final float START_ANGLE = -90.0f;
    public static final int STATE_CIRCULAR_ROTATION = 3;
    public static final int STATE_MAGNIFIER = 1;
    public static final int STATE_MAGNIFIER_ROTATION = 2;
    public static final float SWEEP_ANGLE = -360.0f;
    public static final String TAG = "RefreshingAnimView";
    @ColorRes
    public int mAnimViewColorRes;
    public int mAtLeastRounds;
    public Bitmap mBitmap;
    public Camera mCamera;
    public Canvas mCanvas;
    public PointF mCanvasCenterPt;
    public ValueAnimator mCircularRotateAnimator;
    public float mCircularRotation;
    public float mMagnifierAnimatedValue;
    public float mMagnifierCircleAnimPercent;
    public PointF mMagnifierCircleCenterPt;
    public float mMagnifierInnerCircleMaxRadius;
    public float mMagnifierInnerCircleRadius;
    public float mMagnifierOuterCircleRadius;
    public RectF mMagnifierOuterCircleRect;
    public ValueAnimator mMagnifierRotateAnimator;
    public float mMagnifierRotateFactor;
    public float mMagnifierStickAnimPercent;
    public Matrix mMatrix;
    public OnLoadingAnimationListener mOnLoadingAnimationListener;
    public Paint mPaint;
    public float mProgressCircularRadius;
    public int mRotationRounds;
    public int mState;
    public PointF mStickEndPt;
    public float mStickLength;
    public PointF mStickStartPt;
    public Paint mTransparentPaint;
    public float mWidth;
    public static final double SQRT_TWO = Math.sqrt(2.0d);
    public static final int DEFAULT_ANIM_VIEW_COLOR = com.baidu.tieba.R.color.obfuscated_res_0x7f060976;

    /* loaded from: classes4.dex */
    public interface OnLoadingAnimationListener {
        void notifyAtLeastRoundsFinished(boolean z);
    }

    private String stateToStr() {
        int i = this.mState;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return "None";
                }
                return "Radar";
            }
            return "Transitions";
        }
        return "Magnifier";
    }

    public boolean isCircleRotateAnimating() {
        ValueAnimator valueAnimator = this.mCircularRotateAnimator;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    public boolean isMagnifierRotateAnimating() {
        ValueAnimator valueAnimator = this.mMagnifierRotateAnimator;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    public void startCircularRotate() {
        startCircularRotate(750L);
    }

    public void startMagnifierRotate() {
        startMagnifierRotate(300L);
    }

    public void stopAnim() {
        resetAnimator();
        clearAnimation();
        this.mMagnifierAnimatedValue = 0.0f;
        this.mRotationRounds = 1;
        changeState(1);
        postInvalidate();
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
        this.mState = 0;
        this.mAnimViewColorRes = DEFAULT_ANIM_VIEW_COLOR;
        initPaint();
    }

    private void startMagnifierRotate(long j) {
        changeState(2);
        if (this.mMagnifierRotateAnimator != null) {
            resetAnimator();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mMagnifierRotateAnimator = ofFloat;
        ofFloat.setDuration(j);
        this.mMagnifierRotateAnimator.setInterpolator(new LinearInterpolator());
        this.mMagnifierRotateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ui.pullrefresh.RefreshingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.performMagnifierRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mMagnifierRotateAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ui.pullrefresh.RefreshingAnimView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RefreshingAnimView.this.startCircularRotate(750L);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
            }
        });
        if (!this.mMagnifierRotateAnimator.isRunning()) {
            this.mMagnifierRotateAnimator.start();
        }
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
        this.mState = 0;
        this.mAnimViewColorRes = DEFAULT_ANIM_VIEW_COLOR;
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
        this.mState = 0;
        this.mAnimViewColorRes = DEFAULT_ANIM_VIEW_COLOR;
        initPaint();
    }

    public static /* synthetic */ int access$308(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.mRotationRounds;
        refreshingAnimView.mRotationRounds = i + 1;
        return i;
    }

    private void changeState(int i) {
        this.mState = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performCircularRotation(float f) {
        if (f < 0.2f) {
            this.mCircularRotation = (f / 0.2f) * 0.5f;
        } else {
            this.mCircularRotation = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performMagnifierRotation(float f) {
        this.mMagnifierRotateFactor = f;
        postInvalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int i = this.mState;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    drawCircularRotation(canvas);
                }
            } else {
                drawMagnifierRotation(canvas);
            }
        } else {
            drawMagnifier(canvas);
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
        this.mMagnifierAnimatedValue = f;
        calculateMagnifierAnimFactor();
        postInvalidate();
    }

    public void setAnimViewColorRes(@ColorRes int i) {
        this.mAnimViewColorRes = i;
        this.mPaint.setColor(getResources().getColor(this.mAnimViewColorRes));
    }

    public void setAtLeastRotateRounds(int i) {
        this.mAtLeastRounds = i;
    }

    public void setOnLoadingAnimationListener(OnLoadingAnimationListener onLoadingAnimationListener) {
        this.mOnLoadingAnimationListener = onLoadingAnimationListener;
    }

    private void calculateMagnifierAnimFactor() {
        float f = this.mMagnifierAnimatedValue;
        this.mMagnifierCircleAnimPercent = f;
        if (f < 0.5f) {
            this.mMagnifierStickAnimPercent = 0.0f;
            this.mMagnifierInnerCircleRadius = 0.0f;
            return;
        }
        this.mMagnifierInnerCircleRadius = ((f - 0.5f) / 0.5f) * this.mMagnifierInnerCircleMaxRadius;
        if (f < 0.625f) {
            this.mMagnifierStickAnimPercent = 0.0f;
            return;
        }
        float f2 = (f - 0.625f) / 0.375f;
        this.mMagnifierStickAnimPercent = f2;
        PointF pointF = this.mStickStartPt;
        float f3 = pointF.x;
        float f4 = this.mStickLength;
        double d = SQRT_TWO;
        float f5 = pointF.y + ((float) ((f4 * f2) / d));
        this.mStickEndPt.set(f3 + ((float) ((f4 * f2) / d)), f5);
    }

    private void resetAnimator() {
        ValueAnimator valueAnimator = this.mMagnifierRotateAnimator;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(0);
            this.mMagnifierRotateAnimator.removeAllUpdateListeners();
            this.mMagnifierRotateAnimator.removeAllListeners();
            this.mMagnifierRotateAnimator.end();
            this.mMagnifierRotateAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mCircularRotateAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.setRepeatCount(0);
            this.mCircularRotateAnimator.removeAllUpdateListeners();
            this.mCircularRotateAnimator.removeAllListeners();
            this.mCircularRotateAnimator.end();
            this.mCircularRotateAnimator.cancel();
        }
    }

    private void drawCircularRotation(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && this.mCanvas != null) {
            bitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.mCircularRotation - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (NightModeHelper.getNightModeSwitcherState()) {
                abs = (int) ((((1.0d - (Math.abs(this.mCircularRotation - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.mPaint.setColor(getResources().getColor(this.mAnimViewColorRes));
            this.mPaint.setAlpha(abs);
            Canvas canvas2 = this.mCanvas;
            PointF pointF = this.mCanvasCenterPt;
            canvas2.drawCircle(pointF.x, pointF.y, this.mProgressCircularRadius, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY((this.mCircularRotation * 360.0f) + 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            Matrix matrix = this.mMatrix;
            PointF pointF2 = this.mCanvasCenterPt;
            matrix.preTranslate(-pointF2.x, -pointF2.y);
            Matrix matrix2 = this.mMatrix;
            PointF pointF3 = this.mCanvasCenterPt;
            matrix2.postTranslate(pointF3.x, pointF3.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    private void drawMagnifier(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && this.mCanvas != null) {
            bitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(getResources().getColor(this.mAnimViewColorRes));
            this.mPaint.setAlpha(76);
            RectF rectF = this.mMagnifierOuterCircleRect;
            PointF pointF = this.mCanvasCenterPt;
            float f = pointF.x;
            float f2 = this.mMagnifierOuterCircleRadius;
            float f3 = pointF.y;
            rectF.set(f - f2, f3 - f2, f + f2, f3 + f2);
            this.mCanvas.drawArc(this.mMagnifierOuterCircleRect, -90.0f, this.mMagnifierCircleAnimPercent * (-360.0f), true, this.mPaint);
            Canvas canvas2 = this.mCanvas;
            PointF pointF2 = this.mCanvasCenterPt;
            canvas2.drawCircle(pointF2.x, pointF2.y, this.mMagnifierInnerCircleRadius, this.mTransparentPaint);
            if (this.mMagnifierStickAnimPercent > 0.0f) {
                Canvas canvas3 = this.mCanvas;
                PointF pointF3 = this.mStickEndPt;
                canvas3.drawCircle(pointF3.x, pointF3.y, 0.75f, this.mPaint);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(DeviceUtil.ScreenInfo.dp2px(getContext(), 1.5f));
                Canvas canvas4 = this.mCanvas;
                PointF pointF4 = this.mStickStartPt;
                float f4 = pointF4.x;
                float f5 = pointF4.y;
                PointF pointF5 = this.mStickEndPt;
                canvas4.drawLine(f4, f5, pointF5.x, pointF5.y, this.mPaint);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void drawMagnifierRotation(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && this.mCanvas != null) {
            bitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            int i = (int) (((this.mMagnifierRotateFactor * 0.3d) + 0.3d) * 255.0d);
            this.mPaint.setColor(getResources().getColor(this.mAnimViewColorRes));
            this.mPaint.setAlpha(i);
            float f = this.mStickStartPt.x + ((float) (this.mStickLength / SQRT_TWO));
            Canvas canvas2 = this.mCanvas;
            PointF pointF = this.mCanvasCenterPt;
            canvas2.drawCircle(pointF.x, pointF.y, this.mMagnifierOuterCircleRadius, this.mPaint);
            Canvas canvas3 = this.mCanvas;
            PointF pointF2 = this.mCanvasCenterPt;
            canvas3.drawCircle(pointF2.x, pointF2.y, this.mMagnifierInnerCircleMaxRadius, this.mTransparentPaint);
            this.mCanvas.drawCircle(f, f, 0.75f, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(DeviceUtil.ScreenInfo.dp2px(getContext(), 1.5f));
            Canvas canvas4 = this.mCanvas;
            PointF pointF3 = this.mStickStartPt;
            canvas4.drawLine(pointF3.x, pointF3.y, f, f, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.mMagnifierRotateFactor * 90.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            Matrix matrix = this.mMatrix;
            PointF pointF4 = this.mCanvasCenterPt;
            matrix.preTranslate(-pointF4.x, -pointF4.y);
            Matrix matrix2 = this.mMatrix;
            PointF pointF5 = this.mCanvasCenterPt;
            matrix2.postTranslate(pointF5.x, pointF5.y);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(this.mAnimViewColorRes));
        Paint paint2 = new Paint();
        this.mTransparentPaint = paint2;
        paint2.setAntiAlias(true);
        this.mTransparentPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mCamera = new Camera();
        this.mMatrix = new Matrix();
        changeState(1);
        setId(com.baidu.tieba.R.id.obfuscated_res_0x7f091f8e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCircularRotate(long j) {
        changeState(3);
        if (this.mCircularRotateAnimator != null) {
            resetAnimator();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mCircularRotateAnimator = ofFloat;
        ofFloat.setDuration(j);
        this.mCircularRotateAnimator.setInterpolator(new LinearInterpolator());
        this.mCircularRotateAnimator.setRepeatCount(-1);
        this.mCircularRotateAnimator.setRepeatMode(1);
        this.mCircularRotateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ui.pullrefresh.RefreshingAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RefreshingAnimView.this.performCircularRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (this.mAtLeastRounds > 0) {
            this.mCircularRotateAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ui.pullrefresh.RefreshingAnimView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    RefreshingAnimView.access$308(RefreshingAnimView.this);
                    if (RefreshingAnimView.this.mRotationRounds > RefreshingAnimView.this.mAtLeastRounds && RefreshingAnimView.this.mOnLoadingAnimationListener != null) {
                        RefreshingAnimView.this.mOnLoadingAnimationListener.notifyAtLeastRoundsFinished(true);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                }
            });
        } else {
            OnLoadingAnimationListener onLoadingAnimationListener = this.mOnLoadingAnimationListener;
            if (onLoadingAnimationListener != null) {
                onLoadingAnimationListener.notifyAtLeastRoundsFinished(true);
            }
        }
        if (!this.mCircularRotateAnimator.isRunning()) {
            this.mCircularRotateAnimator.start();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.mWidth = getMeasuredHeight();
        } else {
            this.mWidth = getMeasuredWidth();
        }
        this.mMagnifierOuterCircleRadius = DeviceUtil.ScreenInfo.dp2px(getContext(), 8.0f);
        this.mMagnifierInnerCircleMaxRadius = DeviceUtil.ScreenInfo.dp2px(getContext(), 6.5f);
        this.mStickLength = DeviceUtil.ScreenInfo.dp2px(getContext(), 5.0f);
        this.mProgressCircularRadius = DeviceUtil.ScreenInfo.dp2px(getContext(), 7.5f);
        float f = this.mWidth / 2.0f;
        this.mCanvasCenterPt.set(f, f);
        float f2 = f + ((float) (this.mMagnifierOuterCircleRadius / SQRT_TWO));
        this.mStickStartPt.set(f2, f2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.mCanvas = new Canvas(this.mBitmap);
        }
    }
}
