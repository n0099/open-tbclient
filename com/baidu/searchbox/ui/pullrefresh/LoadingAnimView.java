package com.baidu.searchbox.ui.pullrefresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes4.dex */
public class LoadingAnimView extends View {
    public static final long ANIMATION_INTV = 750;
    public static final int CIRCULAR_RADIUS_DP = 6;
    public static final float DIV_15_75 = 0.2f;
    public static final float DIV_30_75 = 0.4f;
    public static final float DIV_45_75 = 0.6f;
    public static final int MAX_REPEAT_COUNT = 40;
    public float mAnimationFactor;
    public ValueAnimator mAnimator;
    public Bitmap mBitmap;
    public Camera mCamera;
    public Canvas mCanvas;
    public int mLoadingViewColor;
    public Matrix mMatrix;
    public Paint mPaint;

    public LoadingAnimView(Context context) {
        super(context);
        this.mAnimationFactor = 0.0f;
        init();
    }

    public void setLoadingViewColor(@ColorInt int i) {
        this.mLoadingViewColor = i;
    }

    public LoadingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAnimationFactor = 0.0f;
        init();
    }

    public LoadingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAnimationFactor = 0.0f;
        init();
    }

    private void resetAnimator() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(0);
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.removeAllListeners();
            this.mAnimator.end();
            this.mAnimator.cancel();
        }
    }

    public void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mCamera = new Camera();
        this.mMatrix = new Matrix();
        startAnim();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnim();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void stopAnim() {
        resetAnimator();
        clearAnimation();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mBitmap != null && this.mCanvas != null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int dp2px = DeviceUtil.ScreenInfo.dp2px(getContext(), 6.0f);
            this.mBitmap.eraseColor(0);
            this.mPaint.setStyle(Paint.Style.FILL);
            if (this.mLoadingViewColor == 0) {
                this.mLoadingViewColor = getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060964);
            }
            this.mPaint.setColor(this.mLoadingViewColor);
            this.mPaint.setAlpha((int) ((((1.0d - (Math.abs(this.mAnimationFactor - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d));
            float f = measuredWidth / 2.0f;
            float f2 = measuredHeight / 2.0f;
            this.mCanvas.drawCircle(f, f2, dp2px, this.mPaint);
            this.mMatrix.reset();
            this.mCamera.save();
            this.mCamera.setLocation(0.0f, 0.0f, -100.0f);
            this.mCamera.rotateY(this.mAnimationFactor * 360.0f);
            this.mCamera.getMatrix(this.mMatrix);
            this.mCamera.restore();
            this.mMatrix.preTranslate((-measuredWidth) / 2.0f, (-measuredHeight) / 2.0f);
            this.mMatrix.postTranslate(f, f2);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.mCanvas = new Canvas(this.mBitmap);
    }

    public void startAnim() {
        if (this.mAnimator != null) {
            resetAnimator();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnimator = ofFloat;
        ofFloat.setDuration(750L);
        this.mAnimator.setRepeatCount(40);
        this.mAnimator.setRepeatMode(1);
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ui.pullrefresh.LoadingAnimView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 0.4f) {
                    LoadingAnimView.this.mAnimationFactor = (floatValue / 0.4f) * 0.25f;
                } else if (floatValue < 0.6f) {
                    LoadingAnimView.this.mAnimationFactor = (((floatValue - 0.4f) / 0.2f) * 0.5f) + 0.25f;
                } else {
                    LoadingAnimView.this.mAnimationFactor = (((floatValue - 0.6f) / 0.4f) * 0.25f) + 0.75f;
                }
                LoadingAnimView.this.postInvalidate();
            }
        });
        if (!this.mAnimator.isRunning()) {
            this.mAnimator.start();
        }
    }
}
