package com.baidu.searchbox.ui.imagezoom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public abstract class ImageViewTouchBase extends ImageView {
    public static final boolean LOG_ENABLED = false;
    public static final String LOG_TAG = "ImageViewTouchBase";
    public static final String VERSION = "1.0.3";
    public static final float ZOOM_INVALID = -1.0f;
    public Matrix mBaseMatrix;
    public boolean mBitmapChanged;
    public RectF mBitmapRect;
    public PointF mCenter;
    public RectF mCenterRect;
    public final int mDefaultAnimationDuration;
    public final Matrix mDisplayMatrix;
    public OnDrawableChangeListener mDrawableChangeListener;
    public Easing mEasing;
    public Handler mHandler;
    public Runnable mLayoutRunnable;
    public final float[] mMatrixValues;
    public float mMaxZoom;
    public boolean mMaxZoomDefined;
    public float mMinZoom;
    public boolean mMinZoomDefined;
    public Matrix mNextMatrix;
    public OnLayoutChangeListener mOnLayoutChangeListener;
    public DisplayType mScaleType;
    public boolean mScaleTypeChanged;
    public RectF mScrollRect;
    public Matrix mSuppMatrix;
    public int mThisHeight;
    public int mThisWidth;
    public boolean mUserScaled;

    /* loaded from: classes4.dex */
    public enum DisplayType {
        NONE,
        FIT_TO_SCREEN,
        FIT_IF_BIGGER
    }

    /* loaded from: classes4.dex */
    public interface OnDrawableChangeListener {
        void onDrawableChanged(Drawable drawable);
    }

    /* loaded from: classes4.dex */
    public interface OnLayoutChangeListener {
        void onLayoutChanged(boolean z, int i, int i2, int i3, int i4);
    }

    @Override // android.view.View
    @SuppressLint({"Override"})
    public float getRotation() {
        return 0.0f;
    }

    public void onImageMatrixChanged() {
    }

    public void onZoom(float f) {
    }

    public void onZoomAnimationCompleted(float f) {
    }

    public ImageViewTouchBase(Context context) {
        this(context, null);
    }

    public void fireOnDrawableChangeListener(Drawable drawable) {
        OnDrawableChangeListener onDrawableChangeListener = this.mDrawableChangeListener;
        if (onDrawableChangeListener != null) {
            onDrawableChangeListener.onDrawableChanged(drawable);
        }
    }

    public RectF getBitmapRect(Matrix matrix) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        Matrix imageViewMatrix = getImageViewMatrix(matrix);
        this.mBitmapRect.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        imageViewMatrix.mapRect(this.mBitmapRect);
        return this.mBitmapRect;
    }

    public float getDefaultScale(DisplayType displayType) {
        if (displayType == DisplayType.FIT_TO_SCREEN) {
            return 1.0f;
        }
        if (displayType == DisplayType.FIT_IF_BIGGER) {
            return Math.min(1.0f, 1.0f / getScale(this.mBaseMatrix));
        }
        return 1.0f / getScale(this.mBaseMatrix);
    }

    public Matrix getImageViewMatrix(Matrix matrix) {
        this.mDisplayMatrix.set(this.mBaseMatrix);
        this.mDisplayMatrix.postConcat(matrix);
        return this.mDisplayMatrix;
    }

    public float getScale(Matrix matrix) {
        return getValue(matrix, 0);
    }

    public void onDrawableChanged(Drawable drawable) {
        fireOnDrawableChangeListener(drawable);
    }

    public void printMatrix(Matrix matrix) {
        getValue(matrix, 0);
        getValue(matrix, 4);
        getValue(matrix, 2);
        getValue(matrix, 5);
    }

    public void setDisplayType(DisplayType displayType) {
        if (displayType != this.mScaleType) {
            this.mUserScaled = false;
            this.mScaleType = displayType;
            this.mScaleTypeChanged = true;
            requestLayout();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap, null, -1.0f, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        setImageDrawable(drawable, null, -1.0f, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        boolean z;
        Matrix imageMatrix = getImageMatrix();
        if ((matrix == null && !imageMatrix.isIdentity()) || (matrix != null && !imageMatrix.equals(matrix))) {
            z = true;
        } else {
            z = false;
        }
        super.setImageMatrix(matrix);
        if (z) {
            onImageMatrixChanged();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        setImageDrawable(getContext().getResources().getDrawable(i));
    }

    public void setMaxScale(float f) {
        this.mMaxZoom = f;
    }

    public void setMinScale(float f) {
        this.mMinZoom = f;
    }

    public void setOnDrawableChangedListener(OnDrawableChangeListener onDrawableChangeListener) {
        this.mDrawableChangeListener = onDrawableChangeListener;
    }

    public void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
        this.mOnLayoutChangeListener = onLayoutChangeListener;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w(LOG_TAG, "Unsupported scaletype. Only MATRIX can be used");
        }
    }

    public void zoomTo(float f) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        if (f < getMinScale()) {
            f = getMinScale();
        }
        PointF center = getCenter();
        zoomTo(f, center.x, center.y);
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void center(boolean z, boolean z2) {
        if (getDrawable() == null) {
            return;
        }
        RectF center = getCenter(this.mSuppMatrix, z, z2);
        if (center.left != 0.0f || center.top != 0.0f) {
            postTranslate(center.left, center.top);
        }
    }

    public void getProperBaseMatrix(Drawable drawable, Matrix matrix) {
        float f = this.mThisWidth;
        float f2 = this.mThisHeight;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        matrix.reset();
        float min = Math.min(f / intrinsicWidth, f2 / intrinsicHeight);
        matrix.postScale(min, min);
        matrix.postTranslate((f - (intrinsicWidth * min)) / 2.0f, (f2 - (intrinsicHeight * min)) / 2.0f);
    }

    public void getProperBaseMatrix2(Drawable drawable, Matrix matrix) {
        float f = this.mThisWidth;
        float f2 = this.mThisHeight;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        matrix.reset();
        float min = Math.min(f / intrinsicWidth, f2 / intrinsicHeight);
        matrix.postScale(min, min);
        matrix.postTranslate((f - (intrinsicWidth * min)) / 2.0f, (f2 - (intrinsicHeight * min)) / 2.0f);
    }

    public float getValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    public void panBy(double d, double d2) {
        RectF bitmapRect = getBitmapRect();
        this.mScrollRect.set((float) d, (float) d2, 0.0f, 0.0f);
        updateRect(bitmapRect, this.mScrollRect);
        RectF rectF = this.mScrollRect;
        postTranslate(rectF.left, rectF.top);
        center(true, true);
    }

    public void postTranslate(float f, float f2) {
        if (f != 0.0f || f2 != 0.0f) {
            this.mSuppMatrix.postTranslate(f, f2);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void scrollBy(float f, float f2) {
        panBy(f, f2);
    }

    public void zoomTo(float f, float f2) {
        PointF center = getCenter();
        zoomTo(f, center.x, center.y, f2);
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEasing = new Cubic();
        this.mBaseMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mHandler = new Handler();
        this.mLayoutRunnable = null;
        this.mUserScaled = false;
        this.mMaxZoom = -1.0f;
        this.mMinZoom = -1.0f;
        this.mDisplayMatrix = new Matrix();
        this.mMatrixValues = new float[9];
        this.mThisWidth = -1;
        this.mThisHeight = -1;
        this.mCenter = new PointF();
        this.mScaleType = DisplayType.NONE;
        this.mDefaultAnimationDuration = 200;
        this.mBitmapRect = new RectF();
        this.mCenterRect = new RectF();
        this.mScrollRect = new RectF();
        init(context, attributeSet, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
        if (r7 < r8) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RectF getCenter(Matrix matrix, boolean z, boolean z2) {
        float f;
        float f2;
        float f3;
        if (getDrawable() == null) {
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        this.mCenterRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        RectF bitmapRect = getBitmapRect(matrix);
        float height = bitmapRect.height();
        float width = bitmapRect.width();
        if (z2) {
            int i = this.mThisHeight;
            float f4 = i;
            if (height < f4) {
                f = ((f4 - height) / 2.0f) - bitmapRect.top;
            } else {
                float f5 = bitmapRect.top;
                if (f5 > 0.0f) {
                    f = -f5;
                } else {
                    float f6 = bitmapRect.bottom;
                    if (f6 < f4) {
                        f = i - f6;
                    }
                }
            }
            if (z) {
                float f7 = this.mThisWidth;
                if (width < f7) {
                    f7 = (f7 - width) / 2.0f;
                    f3 = bitmapRect.left;
                } else {
                    float f8 = bitmapRect.left;
                    if (f8 > 0.0f) {
                        f2 = -f8;
                        this.mCenterRect.set(f2, f, 0.0f, 0.0f);
                        return this.mCenterRect;
                    }
                    f3 = bitmapRect.right;
                }
                f2 = f7 - f3;
                this.mCenterRect.set(f2, f, 0.0f, 0.0f);
                return this.mCenterRect;
            }
            f2 = 0.0f;
            this.mCenterRect.set(f2, f, 0.0f, 0.0f);
            return this.mCenterRect;
        }
        f = 0.0f;
        if (z) {
        }
        f2 = 0.0f;
        this.mCenterRect.set(f2, f, 0.0f, 0.0f);
        return this.mCenterRect;
    }

    public void clear() {
        setImageBitmap(null);
    }

    public float computeMaxZoom() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return 1.0f;
        }
        return Math.max(drawable.getIntrinsicWidth() / this.mThisWidth, drawable.getIntrinsicHeight() / this.mThisHeight) * 8.0f;
    }

    public float computeMinZoom() {
        if (getDrawable() == null) {
            return 1.0f;
        }
        return Math.min(1.0f, 1.0f / getScale(this.mBaseMatrix));
    }

    public float getBaseScale() {
        return getScale(this.mBaseMatrix);
    }

    public RectF getBitmapRect() {
        return getBitmapRect(this.mSuppMatrix);
    }

    public PointF getCenter() {
        return this.mCenter;
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.mSuppMatrix);
    }

    public DisplayType getDisplayType() {
        return this.mScaleType;
    }

    public Matrix getImageViewMatrix() {
        return getImageViewMatrix(this.mSuppMatrix);
    }

    public float getMaxScale() {
        if (this.mMaxZoom == -1.0f) {
            this.mMaxZoom = computeMaxZoom();
        }
        return this.mMaxZoom;
    }

    public float getMinScale() {
        if (this.mMinZoom == -1.0f) {
            this.mMinZoom = computeMinZoom();
        }
        return this.mMinZoom;
    }

    public float getScale() {
        return getScale(this.mSuppMatrix);
    }

    public void resetDisplay() {
        this.mBitmapChanged = true;
        requestLayout();
    }

    public void resetMatrix() {
        this.mSuppMatrix = new Matrix();
        float defaultScale = getDefaultScale(this.mScaleType);
        setImageMatrix(getImageViewMatrix());
        if (defaultScale != getScale()) {
            zoomTo(defaultScale);
        }
        postInvalidate();
    }

    public void fireOnLayoutChangeListener(int i, int i2, int i3, int i4) {
        OnLayoutChangeListener onLayoutChangeListener = this.mOnLayoutChangeListener;
        if (onLayoutChangeListener != null) {
            onLayoutChangeListener.onLayoutChanged(true, i, i2, i3, i4);
        }
    }

    public void onLayoutChanged(int i, int i2, int i3, int i4) {
        fireOnLayoutChangeListener(i, i2, i3, i4);
    }

    public void setImageBitmap(Bitmap bitmap, Matrix matrix, float f, float f2) {
        if (bitmap != null) {
            setImageDrawable(new BitmapDrawable(bitmap), matrix, f, f2);
        } else {
            setImageDrawable(null, matrix, f, f2);
        }
    }

    public void setImageDrawable(final Drawable drawable, final Matrix matrix, final float f, final float f2) {
        if (getWidth() <= 0) {
            this.mLayoutRunnable = new Runnable() { // from class: com.baidu.searchbox.ui.imagezoom.ImageViewTouchBase.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageViewTouchBase.this.setImageDrawable(drawable, matrix, f, f2);
                }
            };
        } else {
            setImageDrawableSpecial(drawable, matrix, f, f2);
        }
    }

    public void init(Context context, AttributeSet attributeSet, int i) {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void postScale(float f, float f2, float f3) {
        this.mSuppMatrix.postScale(f, f, f2, f3);
        setImageMatrix(getImageViewMatrix());
    }

    public void scrollBy(float f, float f2, final double d) {
        final double d2 = f;
        final double d3 = f2;
        final long currentTimeMillis = System.currentTimeMillis();
        this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ui.imagezoom.ImageViewTouchBase.3
            public double oldX = 0.0d;
            public double oldY = 0.0d;

            @Override // java.lang.Runnable
            public void run() {
                double min = Math.min(d, System.currentTimeMillis() - currentTimeMillis);
                double easeOut = ImageViewTouchBase.this.mEasing.easeOut(min, 0.0d, d2, d);
                double easeOut2 = ImageViewTouchBase.this.mEasing.easeOut(min, 0.0d, d3, d);
                ImageViewTouchBase.this.panBy(easeOut - this.oldX, easeOut2 - this.oldY);
                this.oldX = easeOut;
                this.oldY = easeOut2;
                if (min < d) {
                    ImageViewTouchBase.this.mHandler.post(this);
                    return;
                }
                ImageViewTouchBase imageViewTouchBase = ImageViewTouchBase.this;
                RectF center = imageViewTouchBase.getCenter(imageViewTouchBase.mSuppMatrix, true, true);
                if (center.left != 0.0f || center.top != 0.0f) {
                    ImageViewTouchBase.this.scrollBy(center.left, center.top);
                }
            }
        });
    }

    public void zoomTo(float f, float f2, float f3) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        postScale(f / getScale(), f2, f3);
        onZoom(getScale());
        center(true, true);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        float defaultScale;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int i7 = this.mThisWidth;
            int i8 = this.mThisHeight;
            int i9 = i3 - i;
            this.mThisWidth = i9;
            int i10 = i4 - i2;
            this.mThisHeight = i10;
            i5 = i9 - i7;
            i6 = i10 - i8;
            PointF pointF = this.mCenter;
            pointF.x = i9 / 2.0f;
            pointF.y = i10 / 2.0f;
        } else {
            i5 = 0;
            i6 = 0;
        }
        Runnable runnable = this.mLayoutRunnable;
        if (runnable != null) {
            this.mLayoutRunnable = null;
            runnable.run();
        }
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (z || this.mScaleTypeChanged || this.mBitmapChanged) {
                float scale = getScale(this.mBaseMatrix);
                float scale2 = getScale();
                float f = 1.0f;
                float min = Math.min(1.0f, 1.0f / scale);
                getProperBaseMatrix(drawable, this.mBaseMatrix);
                float scale3 = getScale(this.mBaseMatrix);
                if (!this.mBitmapChanged && !this.mScaleTypeChanged) {
                    if (z) {
                        if (!this.mMinZoomDefined) {
                            this.mMinZoom = -1.0f;
                        }
                        if (!this.mMaxZoomDefined) {
                            this.mMaxZoom = -1.0f;
                        }
                        setImageMatrix(getImageViewMatrix());
                        postTranslate(-i5, -i6);
                        if (!this.mUserScaled) {
                            f = getDefaultScale(this.mScaleType);
                            zoomTo(f);
                        } else {
                            if (Math.abs(scale2 - min) > 0.001d) {
                                f = (scale / scale3) * scale2;
                            }
                            zoomTo(f);
                        }
                    }
                } else {
                    Matrix matrix = this.mNextMatrix;
                    if (matrix != null) {
                        this.mSuppMatrix.set(matrix);
                        this.mNextMatrix = null;
                        defaultScale = getScale();
                    } else {
                        this.mSuppMatrix.reset();
                        defaultScale = getDefaultScale(this.mScaleType);
                    }
                    f = defaultScale;
                    setImageMatrix(getImageViewMatrix());
                    if (f != getScale()) {
                        zoomTo(f);
                    }
                }
                this.mUserScaled = false;
                if (f > getMaxScale() || f < getMinScale()) {
                    zoomTo(f);
                }
                center(true, true);
                if (this.mBitmapChanged) {
                    onDrawableChanged(drawable);
                }
                if (z || this.mBitmapChanged || this.mScaleTypeChanged) {
                    onLayoutChanged(i, i2, i3, i4);
                }
                if (this.mScaleTypeChanged) {
                    this.mScaleTypeChanged = false;
                }
                if (this.mBitmapChanged) {
                    this.mBitmapChanged = false;
                    return;
                }
                return;
            }
            return;
        }
        if (z || this.mBitmapChanged || this.mScaleTypeChanged) {
            onLayoutChanged(i, i2, i3, i4);
        }
        if (this.mBitmapChanged) {
            this.mBitmapChanged = false;
        }
        if (this.mScaleTypeChanged) {
            this.mScaleTypeChanged = false;
        }
    }

    public void setImageDrawableSpecial(Drawable drawable, Matrix matrix, float f, float f2) {
        if (drawable != null) {
            super.setImageDrawable(drawable);
        } else {
            this.mBaseMatrix.reset();
            super.setImageDrawable(null);
        }
        if (f != -1.0f && f2 != -1.0f) {
            float min = Math.min(f, f2);
            float max = Math.max(min, f2);
            this.mMinZoom = min;
            this.mMaxZoom = max;
            this.mMinZoomDefined = true;
            this.mMaxZoomDefined = true;
            DisplayType displayType = this.mScaleType;
            if (displayType == DisplayType.FIT_TO_SCREEN || displayType == DisplayType.FIT_IF_BIGGER) {
                if (this.mMinZoom >= 1.0f) {
                    this.mMinZoomDefined = false;
                    this.mMinZoom = -1.0f;
                }
                if (this.mMaxZoom <= 1.0f) {
                    this.mMaxZoomDefined = true;
                    this.mMaxZoom = -1.0f;
                }
            }
        } else {
            this.mMinZoom = -1.0f;
            this.mMaxZoom = -1.0f;
            this.mMinZoomDefined = false;
            this.mMaxZoomDefined = false;
        }
        if (matrix != null) {
            this.mNextMatrix = new Matrix(matrix);
        }
        this.mBitmapChanged = true;
        requestLayout();
    }

    public void updateRect(RectF rectF, RectF rectF2) {
        if (rectF == null) {
            return;
        }
        if (rectF.top >= 0.0f && rectF.bottom <= this.mThisHeight) {
            rectF2.top = 0.0f;
        }
        if (rectF.left >= 0.0f && rectF.right <= this.mThisWidth) {
            rectF2.left = 0.0f;
        }
        float f = rectF.top;
        if (rectF2.top + f >= 0.0f && rectF.bottom > this.mThisHeight) {
            rectF2.top = (int) (0.0f - f);
        }
        float f2 = rectF.bottom;
        int i = this.mThisHeight;
        if (rectF2.top + f2 <= i + 0 && rectF.top < 0.0f) {
            rectF2.top = (int) ((i + 0) - f2);
        }
        float f3 = rectF.left;
        if (rectF2.left + f3 >= 0.0f) {
            rectF2.left = (int) (0.0f - f3);
        }
        float f4 = rectF.right;
        int i2 = this.mThisWidth;
        if (rectF2.left + f4 <= i2 + 0) {
            rectF2.left = (int) ((i2 + 0) - f4);
        }
    }

    public void zoomTo(float f, float f2, float f3, final float f4) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final float scale = getScale();
        final float f5 = f - scale;
        Matrix matrix = new Matrix(this.mSuppMatrix);
        matrix.postScale(f, f, f2, f3);
        RectF center = getCenter(matrix, true, true);
        final float f6 = f2 + (center.left * f);
        final float f7 = f3 + (center.top * f);
        this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ui.imagezoom.ImageViewTouchBase.2
            @Override // java.lang.Runnable
            public void run() {
                float min = Math.min(f4, (float) (System.currentTimeMillis() - currentTimeMillis));
                ImageViewTouchBase.this.zoomTo(scale + ((float) ImageViewTouchBase.this.mEasing.easeInOut(min, 0.0d, f5, f4)), f6, f7);
                if (min < f4) {
                    ImageViewTouchBase.this.mHandler.post(this);
                    return;
                }
                ImageViewTouchBase imageViewTouchBase = ImageViewTouchBase.this;
                imageViewTouchBase.onZoomAnimationCompleted(imageViewTouchBase.getScale());
                ImageViewTouchBase.this.center(true, true);
            }
        });
    }
}
