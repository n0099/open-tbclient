package com.baidu.sapi2.views;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes2.dex */
public class ClipBoxView extends View {
    private static final int BORDER_WIDTH = 1;
    private static final int BOX_BOTTOM_EDGE = 8;
    private static final int BOX_LEFT_EDGE = 6;
    private static final int BOX_RIGHT_EDGE = 7;
    private static final int BOX_TOP_EDGE = 5;
    public static int CLIP_IMAGE_FREEDOM = 0;
    public static int CLIP_IMAGE_SQUARE = 1;
    private static final int CORNER_LEFT_BOTTOM = 3;
    private static final int CORNER_LEFT_TOP = 1;
    private static final int CORNER_LINE_LENGTH = 20;
    private static final int CORNER_LINE_WIDTH = 4;
    private static final int CORNER_RIGHT_BOTTOM = 4;
    private static final int CORNER_RIGHT_TOP = 2;
    private static final int CORNER_UNKOWN = -1;
    private static final float MIN_CLIPPING_BOX_HEIGHT = 50.0f;
    private static final float MIN_CLIPPING_BOX_WIDTH = 50.0f;
    private static ClipBoxView mInstance;
    private float dBottom;
    private float dLeft;
    private float dRight;
    private float dTop;
    private int mCornerLineLength;
    private int mCornerLineWidth;
    private int mCurrentPosition;
    public boolean mDrawGuideLines;
    private Paint mEraser;
    private RectF mFrameRectF;
    private int mHorizontalPadding;
    private int mMargin;
    private float mMinClippingBoxHeight;
    private float mMinClippingBoxWidth;
    private int mOffAntiAliasing;
    private float mOffX;
    private float mOffY;
    private Paint mPaint;
    private float mPreCheckBottom;
    private float mPreCheckLeft;
    private float mPreCheckRight;
    private float mPreCheckTop;
    private float mProcess;
    private float mScale;
    private float mScaleX;
    private float mScaleY;
    private boolean mStartAnimator;
    private RectF mTouchRectF;
    public int mType;
    private ValueAnimator mValueAnimator;
    private int mVerticalPadding;

    public ClipBoxView(Context context) {
        this(context, null);
    }

    public ClipBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClipBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHorizontalPadding = 22;
        this.mOffAntiAliasing = 2;
        this.mCurrentPosition = -1;
        this.mMargin = 20;
        this.mProcess = 0.0f;
        this.dLeft = 0.0f;
        this.dTop = 0.0f;
        this.dRight = 0.0f;
        this.dBottom = 0.0f;
        this.mStartAnimator = false;
        this.mPreCheckTop = 0.0f;
        this.mPreCheckBottom = 0.0f;
        this.mPreCheckLeft = 0.0f;
        this.mPreCheckRight = 0.0f;
        this.mDrawGuideLines = false;
        if (mInstance == null) {
            mInstance = this;
        }
        init();
    }

    public static ClipBoxView getInstance() {
        if (mInstance != null) {
            return mInstance;
        }
        return null;
    }

    public static void clearInstance() {
        mInstance = null;
    }

    @TargetApi(11)
    private void init() {
        setLayerType(1, null);
        this.mPaint = new Paint();
        this.mEraser = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(dp2px(1));
        this.mPaint.setAntiAlias(true);
        this.mEraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mEraser.setAntiAlias(true);
        this.mCornerLineLength = dp2px(20);
        this.mCornerLineWidth = dp2px(4);
        this.mHorizontalPadding = dp2px(this.mHorizontalPadding);
        this.mOffAntiAliasing = dp2px(this.mOffAntiAliasing);
        this.mMargin = dp2px(this.mMargin);
        this.mFrameRectF = new RectF();
        this.mTouchRectF = new RectF();
        this.mType = CLIP_IMAGE_SQUARE;
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.sapi2.views.ClipBoxView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClipBoxView.this.mProcess = Float.parseFloat(String.valueOf(valueAnimator.getAnimatedValue()));
                ClipBoxView.this.invalidate();
                ClipBoxView.this.customImageAnimation();
            }
        });
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mVerticalPadding = (i2 - (i - (this.mHorizontalPadding * 2))) / 2;
        this.mFrameRectF.left = this.mHorizontalPadding;
        this.mFrameRectF.top = this.mVerticalPadding;
        this.mFrameRectF.right = this.mFrameRectF.left + (i - (this.mHorizontalPadding * 2));
        this.mFrameRectF.bottom = this.mFrameRectF.top + (i - (this.mHorizontalPadding * 2));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mDrawGuideLines = true;
                this.mTouchRectF.set(motionEvent.getX() - this.mCornerLineLength, motionEvent.getY() - this.mCornerLineLength, motionEvent.getX() + this.mCornerLineLength, motionEvent.getY() + this.mCornerLineLength);
                if (this.mTouchRectF.contains(this.mFrameRectF.left, this.mFrameRectF.top)) {
                    this.mCurrentPosition = 1;
                    return true;
                } else if (this.mTouchRectF.contains(this.mFrameRectF.right, this.mFrameRectF.top)) {
                    this.mCurrentPosition = 2;
                    return true;
                } else if (this.mTouchRectF.contains(this.mFrameRectF.left, this.mFrameRectF.bottom)) {
                    this.mCurrentPosition = 3;
                    return true;
                } else if (this.mTouchRectF.contains(this.mFrameRectF.right, this.mFrameRectF.bottom)) {
                    this.mCurrentPosition = 4;
                    return true;
                } else if (this.mTouchRectF.intersect(this.mFrameRectF.left, this.mFrameRectF.top, this.mFrameRectF.right, this.mFrameRectF.top)) {
                    this.mCurrentPosition = 5;
                    return true;
                } else if (this.mTouchRectF.intersect(this.mFrameRectF.left, this.mFrameRectF.top, this.mFrameRectF.left, this.mFrameRectF.bottom)) {
                    this.mCurrentPosition = 6;
                    return true;
                } else if (this.mTouchRectF.intersect(this.mFrameRectF.right, this.mFrameRectF.top, this.mFrameRectF.right, this.mFrameRectF.bottom)) {
                    this.mCurrentPosition = 7;
                    return true;
                } else if (this.mTouchRectF.intersect(this.mFrameRectF.left, this.mFrameRectF.bottom, this.mFrameRectF.right, this.mFrameRectF.bottom)) {
                    this.mCurrentPosition = 8;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                if (this.mCurrentPosition >= 1 && this.mCurrentPosition <= 4) {
                    calculateZoomAnimationCoordinate();
                } else {
                    this.mDrawGuideLines = false;
                    invalidate();
                }
                this.mCurrentPosition = -1;
                break;
            case 2:
                if (this.mType == CLIP_IMAGE_FREEDOM) {
                    return handleScale(motionEvent);
                }
                return handleScaleKeepSquare(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int argb = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.mPaint.setStrokeWidth(dp2px(1));
        canvas.drawColor(argb);
        drawBoxWithAnimation(canvas);
        if (this.mProcess == 1.0f) {
            this.mStartAnimator = false;
            this.mDrawGuideLines = false;
            this.mProcess = 0.0f;
        }
        canvas.drawRect(this.mFrameRectF, this.mEraser);
        if (this.mDrawGuideLines) {
            drawGuideLines(canvas);
        }
        drawCorners(canvas);
    }

    private boolean handleScale(MotionEvent motionEvent) {
        switch (this.mCurrentPosition) {
            case 1:
                scaleTo(motionEvent.getX(), motionEvent.getY(), this.mFrameRectF.right, this.mFrameRectF.bottom);
                break;
            case 2:
                scaleTo(this.mFrameRectF.left, motionEvent.getY(), motionEvent.getX(), this.mFrameRectF.bottom);
                break;
            case 3:
                scaleTo(motionEvent.getX(), this.mFrameRectF.top, this.mFrameRectF.right, motionEvent.getY());
                break;
            case 4:
                scaleTo(this.mFrameRectF.left, this.mFrameRectF.top, motionEvent.getX(), motionEvent.getY());
                break;
            case 5:
                scaleTo(this.mFrameRectF.left, motionEvent.getY(), this.mFrameRectF.right, this.mFrameRectF.bottom);
                break;
            case 6:
                scaleTo(motionEvent.getX(), this.mFrameRectF.top, this.mFrameRectF.right, this.mFrameRectF.bottom);
                break;
            case 7:
                scaleTo(this.mFrameRectF.left, this.mFrameRectF.top, motionEvent.getX(), this.mFrameRectF.bottom);
                break;
            case 8:
                scaleTo(this.mFrameRectF.left, this.mFrameRectF.top, this.mFrameRectF.right, motionEvent.getY());
                break;
            default:
                return false;
        }
        return true;
    }

    private boolean handleScaleKeepSquare(MotionEvent motionEvent) {
        if (checkSquareBoxIsMaxWhenScale(motionEvent)) {
            return true;
        }
        switch (this.mCurrentPosition) {
            case 1:
                float x = ((motionEvent.getX() - this.mFrameRectF.left) + (motionEvent.getY() - this.mFrameRectF.top)) / 2.0f;
                scaleTo(this.mFrameRectF.left + x, x + this.mFrameRectF.top, this.mFrameRectF.right, this.mFrameRectF.bottom);
                return true;
            case 2:
                float x2 = ((this.mFrameRectF.right - motionEvent.getX()) + (motionEvent.getY() - this.mFrameRectF.top)) / 2.0f;
                scaleTo(this.mFrameRectF.left, this.mFrameRectF.top + x2, this.mFrameRectF.right - x2, this.mFrameRectF.bottom);
                return true;
            case 3:
                float x3 = ((motionEvent.getX() - this.mFrameRectF.left) + (this.mFrameRectF.bottom - motionEvent.getY())) / 2.0f;
                scaleTo(this.mFrameRectF.left + x3, this.mFrameRectF.top, this.mFrameRectF.right, this.mFrameRectF.bottom - x3);
                return true;
            case 4:
                float x4 = ((this.mFrameRectF.right - motionEvent.getX()) + (this.mFrameRectF.bottom - motionEvent.getY())) / 2.0f;
                scaleTo(this.mFrameRectF.left, this.mFrameRectF.top, this.mFrameRectF.right - x4, this.mFrameRectF.bottom - x4);
                return true;
            default:
                return false;
        }
    }

    private void scaleTo(float f, float f2, float f3, float f4) {
        if (f4 - f2 < 50.0f) {
            f2 = this.mFrameRectF.top;
            f4 = this.mFrameRectF.bottom;
        }
        if (f3 - f < 50.0f) {
            f = this.mFrameRectF.left;
            f3 = this.mFrameRectF.right;
        }
        checkBoxBorder(f, f2, f3, f4);
        invalidate();
    }

    private void drawCorners(Canvas canvas) {
        this.mPaint.setStrokeWidth(this.mCornerLineWidth);
        canvas.drawLine(this.mFrameRectF.left - this.mOffAntiAliasing, this.mFrameRectF.top, this.mCornerLineLength + this.mFrameRectF.left, this.mFrameRectF.top, this.mPaint);
        canvas.drawLine(this.mFrameRectF.left, this.mFrameRectF.top, this.mFrameRectF.left, this.mCornerLineLength + this.mFrameRectF.top, this.mPaint);
        canvas.drawLine(this.mOffAntiAliasing + this.mFrameRectF.right, this.mFrameRectF.top, this.mFrameRectF.right - this.mCornerLineLength, this.mFrameRectF.top, this.mPaint);
        canvas.drawLine(this.mFrameRectF.right, this.mFrameRectF.top, this.mFrameRectF.right, this.mCornerLineLength + this.mFrameRectF.top, this.mPaint);
        canvas.drawLine(this.mFrameRectF.left - this.mOffAntiAliasing, this.mFrameRectF.bottom, this.mCornerLineLength + this.mFrameRectF.left, this.mFrameRectF.bottom, this.mPaint);
        canvas.drawLine(this.mFrameRectF.left, this.mFrameRectF.bottom, this.mFrameRectF.left, this.mFrameRectF.bottom - this.mCornerLineLength, this.mPaint);
        canvas.drawLine(this.mOffAntiAliasing + this.mFrameRectF.right, this.mFrameRectF.bottom, this.mFrameRectF.right - this.mCornerLineLength, this.mFrameRectF.bottom, this.mPaint);
        canvas.drawLine(this.mFrameRectF.right, this.mFrameRectF.bottom, this.mFrameRectF.right, this.mFrameRectF.bottom - this.mCornerLineLength, this.mPaint);
    }

    public void drawGuideLines(Canvas canvas) {
        float f = this.mFrameRectF.left;
        float f2 = this.mFrameRectF.top;
        float f3 = this.mFrameRectF.right;
        float f4 = this.mFrameRectF.bottom;
        canvas.drawLine(f, f2 + ((f4 - f2) / 3.0f), f3, f2 + ((f4 - f2) / 3.0f), this.mPaint);
        canvas.drawLine(f, f2 + (((f4 - f2) / 3.0f) * 2.0f), f3, f2 + (((f4 - f2) / 3.0f) * 2.0f), this.mPaint);
        canvas.drawLine(f + ((f3 - f) / 3.0f), f2, f + ((f3 - f) / 3.0f), f4, this.mPaint);
        canvas.drawLine(f + (((f3 - f) / 3.0f) * 2.0f), f2, f + (((f3 - f) / 3.0f) * 2.0f), f4, this.mPaint);
    }

    private void drawBoxWithAnimation(Canvas canvas) {
        if (this.mStartAnimator) {
            this.mFrameRectF.left = this.mPreCheckLeft - (this.mProcess * this.dLeft);
            this.mFrameRectF.top = this.mPreCheckTop - (this.mProcess * this.dTop);
            this.mFrameRectF.right = this.mPreCheckRight + (this.mProcess * this.dRight);
            this.mFrameRectF.bottom = this.mPreCheckBottom + (this.mProcess * this.dBottom);
            canvas.drawRect(this.mFrameRectF, this.mPaint);
            return;
        }
        canvas.drawRect(this.mFrameRectF, this.mPaint);
    }

    private void checkBoxBorder(float f, float f2, float f3, float f4) {
        ZoomImageView zoomImageView = ZoomImageView.getInstance();
        if (zoomImageView != null) {
            RectF matrixRectF = zoomImageView.getMatrixRectF();
            f = Math.max(Math.max(this.mMargin, f), matrixRectF.left);
            f2 = Math.max(Math.max(this.mMargin, f2), matrixRectF.top);
            f3 = Math.min(Math.min(getWidth() - this.mMargin, f3), matrixRectF.right);
            f4 = Math.min(Math.min(getHeight() - this.mMargin, f4), matrixRectF.bottom);
        }
        this.dTop = this.mPreCheckTop - f2;
        this.dBottom = f4 - this.mPreCheckBottom;
        this.dLeft = this.mPreCheckLeft - f;
        this.dRight = f3 - this.mPreCheckRight;
        this.mFrameRectF.set(f, f2, f3, f4);
    }

    @TargetApi(11)
    private void calculateZoomAnimationCoordinate() {
        int width = getWidth() - (this.mHorizontalPadding * 2);
        if (this.mFrameRectF.right - this.mFrameRectF.left < width) {
            this.mPreCheckTop = this.mFrameRectF.top;
            this.mPreCheckBottom = this.mFrameRectF.bottom;
            this.mPreCheckLeft = this.mFrameRectF.left;
            this.mPreCheckRight = this.mFrameRectF.right;
            this.mScaleX = width / (this.mFrameRectF.right - this.mFrameRectF.left);
            this.mScaleY = (getHeight() - (this.mMargin * 2)) / (this.mFrameRectF.bottom - this.mFrameRectF.top);
            this.mScale = Math.min(this.mScaleX, this.mScaleY);
            float f = this.mScale - 1.0f <= 1.0f ? this.mScale - 1.0f : 1.0f;
            this.mOffX = ((getWidth() / 2) - ((this.mFrameRectF.left + this.mFrameRectF.right) / 2.0f)) * f;
            this.mOffY = f * ((getHeight() / 2) - ((this.mFrameRectF.top + this.mFrameRectF.bottom) / 2.0f));
            this.mFrameRectF.left /= this.mScale;
            this.mFrameRectF.top /= this.mScale;
            this.mFrameRectF.right *= this.mScale;
            this.mFrameRectF.bottom *= this.mScale;
            if (this.mType == CLIP_IMAGE_FREEDOM) {
                checkBoxBorder(this.mFrameRectF.left, this.mFrameRectF.top, this.mFrameRectF.right, this.mFrameRectF.bottom);
            } else {
                checkBoxBorder(this.mHorizontalPadding, this.mVerticalPadding, this.mHorizontalPadding + width, width + this.mVerticalPadding);
            }
            this.mValueAnimator.setDuration(500L).start();
            this.mStartAnimator = true;
            return;
        }
        this.mDrawGuideLines = false;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void customImageAnimation() {
        ZoomImageView zoomImageView = ZoomImageView.getInstance();
        if (this.mStartAnimator && zoomImageView.getScale() <= 4.0f) {
            float f = ((this.mScale - 1.0f) / 20.0f) + 1.0f;
            zoomImageView.mScaleMatrix.postTranslate(this.mOffX / 20.0f, this.mOffY / 20.0f);
            zoomImageView.mScaleMatrix.postScale(f, f, (this.mFrameRectF.left + this.mFrameRectF.right) / 2.0f, (this.mFrameRectF.top + this.mFrameRectF.bottom) / 2.0f);
            zoomImageView.checkBorderAndCenterWhenScale((this.mFrameRectF.left + this.mFrameRectF.right) / 2.0f, (this.mFrameRectF.top + this.mFrameRectF.bottom) / 2.0f);
            zoomImageView.setImageMatrix(zoomImageView.mScaleMatrix);
        }
    }

    private boolean checkSquareBoxIsMaxWhenScale(MotionEvent motionEvent) {
        int width = getWidth() - (this.mHorizontalPadding * 2);
        return this.mFrameRectF.right - this.mFrameRectF.left >= ((float) width) && this.mFrameRectF.bottom - this.mFrameRectF.top >= ((float) width) && (motionEvent.getX() < ((float) this.mHorizontalPadding) || motionEvent.getX() > ((float) (this.mHorizontalPadding + width)) || motionEvent.getY() < ((float) this.mVerticalPadding) || motionEvent.getY() > ((float) (width + this.mVerticalPadding)));
    }

    public Rect getmFrameRectF() {
        Rect rect = new Rect();
        rect.left = (int) this.mFrameRectF.left;
        rect.right = (int) this.mFrameRectF.right;
        rect.top = (int) this.mFrameRectF.top;
        rect.bottom = (int) this.mFrameRectF.bottom;
        return rect;
    }

    private int dp2px(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }
}
