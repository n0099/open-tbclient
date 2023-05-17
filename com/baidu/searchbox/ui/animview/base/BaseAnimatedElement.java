package com.baidu.searchbox.ui.animview.base;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public abstract class BaseAnimatedElement implements IAnimatedElement {
    public static final int DEBUG_PAINT_COLOR = -16776961;
    public static final int DEBUG_PAINT_STROKE_WIDTH = 10;
    public static final Matrix.ScaleToFit[] SS2FARRAY = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    public Paint mDebugPaint;
    public Matrix mDrawMatrix;
    public WeakReference<Drawable.Callback> mDrawableCallback;
    public int mHeight;
    public Interpolator mInterpolator;
    public int mLeft;
    public int mPivotX;
    public int mPivotY;
    public IResourceProvider mResourceProvider;
    public ScaleType mScaleType;
    public int mTop;
    public int mWidth;
    public boolean mDrawDebugRect = false;
    public boolean mVisibility = true;
    public float mRotateAngle = 0.0f;

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public BaseAnimatedElement cloneInstance() {
        return null;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void copyAttribute(BaseAnimatedElement baseAnimatedElement) {
    }

    public abstract void onDispatchAnimate(Canvas canvas, float f, long j);

    public void onInit(Object... objArr) {
    }

    private void initDebugPaint() {
        if (this.mDebugPaint != null) {
            return;
        }
        Paint paint = new Paint();
        this.mDebugPaint = paint;
        paint.setAntiAlias(true);
        this.mDebugPaint.setStyle(Paint.Style.STROKE);
        this.mDebugPaint.setStrokeWidth(10.0f);
        this.mDebugPaint.setColor(DEBUG_PAINT_COLOR);
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public final int getLeft() {
        return this.mLeft;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public final int getTop() {
        return this.mTop;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public int getWidth() {
        return this.mWidth;
    }

    /* loaded from: classes4.dex */
    public enum ScaleType {
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4);
        
        public final int nativeInt;

        ScaleType(int i) {
            this.nativeInt = i;
        }
    }

    public BaseAnimatedElement(Drawable.Callback callback, ScaleType scaleType) {
        this.mScaleType = scaleType;
        setDrawableCallback(callback);
    }

    public void enableDrawDebugBound(boolean z, int i) {
        this.mDrawDebugRect = z;
        if (z) {
            initDebugPaint();
            this.mDebugPaint.setColor(i);
        }
    }

    public void setScaleType(ScaleType scaleType, Drawable drawable) {
        this.mScaleType = scaleType;
        configureBounds(drawable);
    }

    private void configureBounds(Drawable drawable) {
        boolean z;
        if (drawable != null && this.mScaleType != null) {
            int width = drawable.getBounds().width();
            int height = drawable.getBounds().height();
            int i = this.mWidth;
            int i2 = this.mHeight;
            if ((width >= 0 && i != width) || (height >= 0 && i2 != height)) {
                z = false;
            } else {
                z = true;
            }
            if (width > 0 && height > 0) {
                if (z) {
                    this.mDrawMatrix = null;
                    return;
                }
                this.mDrawMatrix = new Matrix();
                RectF rectF = new RectF();
                RectF rectF2 = new RectF();
                rectF.set(0.0f, 0.0f, width, height);
                rectF2.set(0.0f, 0.0f, i, i2);
                this.mDrawMatrix.setRectToRect(rectF, rectF2, scaleTypeToScaleToFit(this.mScaleType));
                return;
            }
            drawable.setBounds(0, 0, i, i2);
            this.mDrawMatrix = null;
            return;
        }
        this.mDrawMatrix = null;
    }

    public static Matrix.ScaleToFit scaleTypeToScaleToFit(ScaleType scaleType) {
        return SS2FARRAY[scaleType.nativeInt - 1];
    }

    public void performCanvasDrawMatrix(Canvas canvas) {
        Matrix matrix;
        if (canvas != null && (matrix = this.mDrawMatrix) != null) {
            canvas.concat(matrix);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void setDrawableCallback(Drawable.Callback callback) {
        this.mDrawableCallback = new WeakReference<>(callback);
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setScaleType(Drawable drawable) {
        setScaleType(this.mScaleType, drawable);
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void setVisibility(boolean z) {
        this.mVisibility = z;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void dispatchAnimate(Canvas canvas, float f, long j) {
        if (this.mDrawDebugRect) {
            canvas.save();
            canvas.translate(this.mLeft, this.mTop);
            canvas.rotate(this.mRotateAngle, this.mPivotX, this.mPivotY);
            canvas.drawRect(0.0f, 0.0f, this.mWidth, this.mHeight, this.mDebugPaint);
            canvas.restore();
        }
        canvas.save();
        canvas.translate(this.mLeft, this.mTop);
        canvas.rotate(this.mRotateAngle, this.mPivotX, this.mPivotY);
        if (this.mVisibility) {
            performCanvasDrawMatrix(canvas);
            if (this.mInterpolator == null) {
                this.mInterpolator = new LinearInterpolator();
            }
            onDispatchAnimate(canvas, this.mInterpolator.getInterpolation(f), j);
        }
        canvas.restore();
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public final void init(int i, int i2, int i3, int i4, IResourceProvider iResourceProvider, Object... objArr) {
        this.mLeft = i;
        this.mTop = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        this.mResourceProvider = iResourceProvider;
        this.mDrawMatrix = null;
        onInit(objArr);
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void setRotate(float f, float f2, float f3) {
        this.mRotateAngle = f;
        this.mPivotX = (int) (f2 * this.mWidth);
        this.mPivotY = (int) (f3 * this.mHeight);
    }
}
