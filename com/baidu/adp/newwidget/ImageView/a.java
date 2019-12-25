package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class a {
    private InterfaceC0022a vZ;
    private static final Matrix.ScaleToFit[] sS2FArray = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter sColorFilterForSkin = new PorterDuffColorFilter(1409286144, PorterDuff.Mode.SRC_ATOP);
    public Paint mPaint = new Paint(6);
    public Paint mBorderPaint = new Paint();
    protected Paint mForegroundPaint = new Paint();
    protected Matrix mDrawMatrix = new Matrix();
    protected RectF mBounds = new RectF();
    protected RectF mBorderRect = new RectF();
    private RectF mTempSrc = new RectF();
    private RectF mTempDst = new RectF();
    private RectF mTempForNinePatch = new RectF();
    protected d wa = new d();
    private float[] mValues = new float[9];
    private PointF mPoint = new PointF();
    protected RectF mForegroundRect = new RectF();

    /* renamed from: com.baidu.adp.newwidget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0022a {
        boolean a(Canvas canvas, Drawable drawable);
    }

    public abstract void a(c cVar, ImageView imageView);

    public abstract void b(Canvas canvas, c cVar, ImageView imageView);

    public abstract void drawBorder(Canvas canvas, ImageView imageView);

    public abstract void drawForeground(Canvas canvas, ImageView imageView);

    public a() {
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
    }

    public void a(InterfaceC0022a interfaceC0022a) {
        this.vZ = interfaceC0022a;
    }

    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        float min;
        float f;
        float f2;
        float f3 = 0.0f;
        if (imageView.getWidth() != 0 && imageView.getHeight() != 0) {
            int width = cVar.getWidth();
            int height = cVar.getHeight();
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height2 = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            if (scaleType == ImageView.ScaleType.MATRIX) {
                this.mBounds.set(0.0f, 0.0f, width, height);
                a(cVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.mDrawMatrix.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.mBounds.set(0.0f, 0.0f, width2, height2);
            } else {
                this.mBounds.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.mDrawMatrix.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.mDrawMatrix.setScale(f, f);
                    this.mDrawMatrix.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.mDrawMatrix.setScale(min, min);
                    this.mDrawMatrix.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.mTempSrc.set(0.0f, 0.0f, width, height);
                    this.mTempDst.set(0.0f, 0.0f, width2, height2);
                    this.mDrawMatrix.setRectToRect(this.mTempSrc, this.mTempDst, scaleTypeToScaleToFit(scaleType));
                }
            }
            a(cVar, imageView);
        }
    }

    public void a(Canvas canvas, c cVar, ImageView imageView) {
        updatePaint();
        int save = canvas.save();
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        int paddingLeft = imageView.getPaddingLeft();
        int paddingRight = imageView.getPaddingRight();
        int paddingTop = imageView.getPaddingTop();
        int paddingBottom = imageView.getPaddingBottom();
        canvas.clipRect(scrollX + paddingLeft, scrollY + paddingTop, ((scrollX + imageView.getRight()) - imageView.getLeft()) - paddingRight, ((scrollY + imageView.getBottom()) - imageView.getTop()) - paddingBottom);
        canvas.translate(paddingLeft, paddingTop);
        int save2 = canvas.save();
        if (this.wa.mExtraMatrix != null) {
            canvas.concat(this.wa.mExtraMatrix);
        }
        if (cVar.we != null && cVar.we.isNinePatchBitmap()) {
            if ((cVar.we.getRawBitmap().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || cVar.we.getRawBitmap().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.mDrawMatrix != null) {
                canvas.concat(this.mDrawMatrix);
            }
            this.mTempForNinePatch.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            cVar.we.drawNinePatchImage(canvas, this.mTempForNinePatch);
        } else {
            b(canvas, cVar, imageView);
        }
        canvas.restoreToCount(save2);
        drawBorder(canvas, imageView);
        canvas.restoreToCount(save);
    }

    public void drawBackground(Canvas canvas, ImageView imageView, Drawable drawable) {
        if (drawable != null) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            drawable.setBounds(0, 0, imageView.getWidth(), imageView.getHeight());
            if ((scrollX | scrollY) == 0) {
                drawBackgroundReal(canvas, drawable);
                return;
            }
            canvas.translate(scrollX, scrollY);
            drawBackgroundReal(canvas, drawable);
            canvas.translate(-scrollX, -scrollY);
        }
    }

    protected void drawBackgroundReal(Canvas canvas, Drawable drawable) {
        if (this.vZ == null || !this.vZ.a(canvas, drawable)) {
            drawable.draw(canvas);
        }
    }

    public void a(d dVar) {
        this.wa = dVar;
    }

    public Matrix getDrawMatrix() {
        return this.mDrawMatrix;
    }

    public void setDrawMatrix(Matrix matrix) {
        this.mDrawMatrix = matrix;
    }

    public RectF getBounds() {
        return this.mBounds;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updatePaint() {
        this.mPaint.setAlpha((int) (255.0f * this.wa.mAlpha));
        if (this.wa.mIsNight) {
            this.mPaint.setColorFilter(sColorFilterForSkin);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.mBorderPaint.setColor(this.wa.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.wa.mBorderWidth);
    }

    private static Matrix.ScaleToFit scaleTypeToScaleToFit(ImageView.ScaleType scaleType) {
        int i = 1;
        if (scaleType != ImageView.ScaleType.FIT_XY) {
            if (scaleType == ImageView.ScaleType.FIT_START) {
                i = 2;
            } else if (scaleType == ImageView.ScaleType.FIT_CENTER) {
                i = 3;
            } else if (scaleType == ImageView.ScaleType.FIT_END) {
                i = 4;
            }
        }
        return sS2FArray[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF applyMatrix(float f, float f2, Matrix matrix) {
        matrix.getValues(this.mValues);
        this.mPoint.set((int) ((this.mValues[0] * f) + (this.mValues[1] * f2) + this.mValues[2]), (int) ((this.mValues[3] * f) + (this.mValues[4] * f2) + this.mValues[5]));
        return this.mPoint;
    }
}
