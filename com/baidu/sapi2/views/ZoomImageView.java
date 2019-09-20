package com.baidu.sapi2.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
@TargetApi(8)
/* loaded from: classes2.dex */
public class ZoomImageView extends ImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static final float MAX_SCALE = 4.0f;
    private static ZoomImageView mInstance;
    public float initScale;
    private int mHorizontalPadding;
    private boolean mIsDrag;
    private boolean mIsLongerLeftAndRight;
    private boolean mIsLongerTopAndBottom;
    private int mLastPointerCount;
    private float mLastX;
    private float mLastY;
    private ScaleGestureDetector mScaleGestureDetector;
    public final Matrix mScaleMatrix;
    private double mTouchSlop;
    private int mVerticalPadding;
    private final float[] matrixValues;
    private boolean once;

    public ZoomImageView(Context context) {
        this(context, null);
    }

    public ZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.initScale = 1.0f;
        this.matrixValues = new float[9];
        this.once = true;
        this.mScaleMatrix = new Matrix();
        this.mLastPointerCount = 0;
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
        this.mHorizontalPadding = 22;
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setOnTouchListener(this);
        if (mInstance == null) {
            mInstance = this;
        }
    }

    public static ZoomImageView getInstance() {
        if (mInstance != null) {
            return mInstance;
        }
        return null;
    }

    public static void clearInstance() {
        mInstance = null;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scale = getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (getDrawable() != null && ((scale < 4.0f && scaleFactor > 1.0f) || scaleFactor < 1.0f)) {
            if (scaleFactor * scale > 4.0f) {
                scaleFactor = 4.0f / scale;
            }
            this.mScaleMatrix.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            checkBorderAndCenterWhenScale(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            setImageMatrix(this.mScaleMatrix);
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float f;
        float f2;
        this.mScaleGestureDetector.onTouchEvent(motionEvent);
        float f3 = 0.0f;
        float f4 = 0.0f;
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            f3 += motionEvent.getX(i);
            f4 += motionEvent.getY(i);
        }
        float f5 = f3 / pointerCount;
        float f6 = f4 / pointerCount;
        if (pointerCount != this.mLastPointerCount) {
            this.mIsDrag = false;
            this.mLastX = f5;
            this.mLastY = f6;
        }
        this.mLastPointerCount = pointerCount;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                this.mLastPointerCount = 0;
                return true;
            case 2:
                float f7 = f5 - this.mLastX;
                float f8 = f6 - this.mLastY;
                if (!this.mIsDrag) {
                    this.mIsDrag = Math.sqrt((double) ((f7 * f7) + (f8 * f8))) >= this.mTouchSlop;
                }
                if (this.mIsDrag) {
                    RectF matrixRectF = getMatrixRectF();
                    if (getDrawable() != null) {
                        this.mIsLongerLeftAndRight = true;
                        this.mIsLongerTopAndBottom = true;
                        Rect rect = ClipBoxView.getInstance().getmFrameRectF();
                        if (matrixRectF.width() < rect.right - rect.left) {
                            f = 0.0f;
                            this.mIsLongerLeftAndRight = false;
                        } else {
                            f = f7;
                        }
                        if (matrixRectF.height() < rect.bottom - rect.top) {
                            f2 = 0.0f;
                            this.mIsLongerTopAndBottom = false;
                        } else {
                            f2 = f8;
                        }
                        this.mScaleMatrix.postTranslate(f, f2);
                        checkMatrixBounds();
                        setImageMatrix(this.mScaleMatrix);
                    }
                }
                this.mLastX = f5;
                this.mLastY = f6;
                return true;
            default:
                return true;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Drawable drawable;
        float max;
        if (this.once && (drawable = getDrawable()) != null) {
            this.mHorizontalPadding = (int) TypedValue.applyDimension(1, this.mHorizontalPadding, getResources().getDisplayMetrics());
            this.mVerticalPadding = (getHeight() - (getWidth() - (this.mHorizontalPadding * 2))) / 2;
            int width = getWidth();
            int height = getHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth < getWidth() - (this.mHorizontalPadding * 2) && intrinsicHeight > getHeight() - (this.mVerticalPadding * 2)) {
                max = ((getWidth() * 1.0f) - (this.mHorizontalPadding * 2)) / intrinsicWidth;
            } else if (intrinsicHeight < getHeight() - (this.mVerticalPadding * 2) && intrinsicWidth > getWidth() - (this.mHorizontalPadding * 2)) {
                max = ((getHeight() * 1.0f) - (this.mVerticalPadding * 2)) / intrinsicHeight;
            } else {
                max = Math.max(((getWidth() * 1.0f) - (this.mHorizontalPadding * 2)) / intrinsicWidth, ((getHeight() * 1.0f) - (this.mVerticalPadding * 2)) / intrinsicHeight);
            }
            this.initScale = max;
            this.mScaleMatrix.postTranslate((width - intrinsicWidth) / 2, (height - intrinsicHeight) / 2);
            this.mScaleMatrix.postScale(max, max, width / 2, height / 2);
            setImageMatrix(this.mScaleMatrix);
            this.once = false;
        }
    }

    public final float getScale() {
        this.mScaleMatrix.getValues(this.matrixValues);
        return this.matrixValues[0];
    }

    public void checkBorderAndCenterWhenScale(float f, float f2) {
        float f3;
        RectF matrixRectF = getMatrixRectF();
        Rect rect = ClipBoxView.getInstance().getmFrameRectF();
        int i = rect.right - rect.left;
        int i2 = rect.bottom - rect.top;
        if (matrixRectF.width() >= i) {
            f3 = matrixRectF.left > ((float) rect.left) ? -(matrixRectF.left - rect.left) : 0.0f;
            if (matrixRectF.right < rect.right) {
                f3 = rect.right - matrixRectF.right;
            }
        } else {
            f3 = 0.0f;
        }
        if (matrixRectF.height() >= i2) {
            r1 = matrixRectF.top > ((float) rect.top) ? -(matrixRectF.top - rect.top) : 0.0f;
            if (matrixRectF.bottom < rect.bottom) {
                r1 = rect.bottom - matrixRectF.bottom;
            }
        }
        this.mScaleMatrix.postTranslate(f3, r1);
        if (matrixRectF.width() < i || matrixRectF.height() < i2) {
            float max = Math.max(i / matrixRectF.width(), i2 / matrixRectF.height());
            this.mScaleMatrix.postScale(max, max, f, f2);
        }
    }

    public RectF getMatrixRectF() {
        Matrix matrix = this.mScaleMatrix;
        RectF rectF = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    private void checkMatrixBounds() {
        float f = 0.0f;
        RectF matrixRectF = getMatrixRectF();
        Rect rect = ClipBoxView.getInstance().getmFrameRectF();
        getWidth();
        getHeight();
        float f2 = (matrixRectF.top <= ((float) rect.top) || !this.mIsLongerTopAndBottom) ? 0.0f : -(matrixRectF.top - rect.top);
        if (matrixRectF.bottom < rect.bottom && this.mIsLongerTopAndBottom) {
            f2 = rect.bottom - matrixRectF.bottom;
        }
        if (matrixRectF.left > rect.left && this.mIsLongerLeftAndRight) {
            f = -(matrixRectF.left - rect.left);
        }
        if (matrixRectF.right < rect.right && this.mIsLongerLeftAndRight) {
            f = rect.right - matrixRectF.right;
        }
        this.mScaleMatrix.postTranslate(f, f2);
    }

    public Bitmap cropImage() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        draw(new Canvas(createBitmap));
        Rect rect = ClipBoxView.getInstance().getmFrameRectF();
        return Bitmap.createBitmap(createBitmap, rect.left, rect.top, rect.width(), rect.height());
    }
}
