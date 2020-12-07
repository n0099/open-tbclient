package com.baidu.searchbox.ui.animview.base;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
/* loaded from: classes6.dex */
public abstract class BaseAnimatedElement implements IAnimatedElement {
    protected static final int DEBUG_PAINT_COLOR = -16776961;
    protected static final int DEBUG_PAINT_STROKE_WIDTH = 10;
    private static final Matrix.ScaleToFit[] sS2FArray = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    protected Paint mDebugPaint;
    private Matrix mDrawMatrix;
    protected Drawable.Callback mDrawableCallback;
    protected int mHeight;
    protected Interpolator mInterpolator;
    protected int mLeft;
    private int mPivotX;
    private int mPivotY;
    protected IResourceProvider mResourceProvider;
    protected ScaleType mScaleType;
    protected int mTop;
    protected int mWidth;
    protected boolean mDrawDebugRect = false;
    protected boolean mVisibility = true;
    private float mRotateAngle = 0.0f;

    protected abstract void onDispatchAnimate(Canvas canvas, float f, long j);

    /* loaded from: classes6.dex */
    public enum ScaleType {
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4);
        
        final int nativeInt;

        ScaleType(int i) {
            this.nativeInt = i;
        }
    }

    public BaseAnimatedElement(Drawable.Callback callback, ScaleType scaleType) {
        this.mDrawableCallback = callback;
        this.mScaleType = scaleType;
        setDrawableCallback(callback);
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

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public int getHeight() {
        return this.mHeight;
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

    protected void onInit(Object... objArr) {
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void setDrawableCallback(Drawable.Callback callback) {
        this.mDrawableCallback = callback;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void setRotate(float f, float f2, float f3) {
        this.mRotateAngle = f;
        this.mPivotX = (int) (this.mWidth * f2);
        this.mPivotY = (int) (this.mHeight * f3);
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
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void setVisibility(boolean z) {
        this.mVisibility = z;
    }

    private void initDebugPaint() {
        if (this.mDebugPaint == null) {
            this.mDebugPaint = new Paint();
            this.mDebugPaint.setAntiAlias(true);
            this.mDebugPaint.setStyle(Paint.Style.STROKE);
            this.mDebugPaint.setStrokeWidth(10.0f);
            this.mDebugPaint.setColor(DEBUG_PAINT_COLOR);
        }
    }

    public void enableDrawDebugBound(boolean z, int i) {
        this.mDrawDebugRect = z;
        if (z) {
            initDebugPaint();
            this.mDebugPaint.setColor(i);
        }
    }

    protected void setScaleType(ScaleType scaleType, Drawable drawable) {
        this.mScaleType = scaleType;
        configureBounds(drawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setScaleType(Drawable drawable) {
        setScaleType(this.mScaleType, drawable);
    }

    protected void performCanvasDrawMatrix(Canvas canvas) {
        if (canvas != null && this.mDrawMatrix != null) {
            canvas.concat(this.mDrawMatrix);
        }
    }

    private void configureBounds(Drawable drawable) {
        if (drawable == null || this.mScaleType == null) {
            this.mDrawMatrix = null;
            return;
        }
        int width = drawable.getBounds().width();
        int height = drawable.getBounds().height();
        int i = this.mWidth;
        int i2 = this.mHeight;
        boolean z = (width < 0 || i == width) && (height < 0 || i2 == height);
        if (width <= 0 || height <= 0) {
            drawable.setBounds(0, 0, i, i2);
            this.mDrawMatrix = null;
        } else if (z) {
            this.mDrawMatrix = null;
        } else {
            this.mDrawMatrix = new Matrix();
            RectF rectF = new RectF();
            RectF rectF2 = new RectF();
            rectF.set(0.0f, 0.0f, width, height);
            rectF2.set(0.0f, 0.0f, i, i2);
            this.mDrawMatrix.setRectToRect(rectF, rectF2, scaleTypeToScaleToFit(this.mScaleType));
        }
    }

    private static Matrix.ScaleToFit scaleTypeToScaleToFit(ScaleType scaleType) {
        return sS2FArray[scaleType.nativeInt - 1];
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public BaseAnimatedElement cloneInstance() {
        return null;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void copyAttribute(BaseAnimatedElement baseAnimatedElement) {
    }
}
