package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class a {
    private InterfaceC0025a Ss;
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
    protected e St = new e();
    private float[] mValues = new float[9];
    private PointF mPoint = new PointF();
    protected RectF mForegroundRect = new RectF();

    /* renamed from: com.baidu.adp.newwidget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0025a {
        boolean a(Canvas canvas, Drawable drawable);
    }

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public abstract void drawBorder(Canvas canvas, ImageView imageView);

    public abstract void drawForeground(Canvas canvas, ImageView imageView);

    public a() {
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
    }

    public void a(InterfaceC0025a interfaceC0025a) {
        this.Ss = interfaceC0025a;
    }

    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        float f;
        float f2;
        float f3;
        if (imageView.getWidth() != 0 && imageView.getHeight() != 0) {
            int width = dVar.getWidth();
            int height = dVar.getHeight();
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height2 = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            if (scaleType == ImageView.ScaleType.MATRIX) {
                this.mBounds.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
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
                        float f4 = height2 / height;
                        f2 = f4;
                        f3 = (width2 - (width * f4)) * 0.5f;
                        f = 0.0f;
                    } else {
                        float f5 = width2 / width;
                        f = (height2 - (height * f5)) * 0.5f;
                        f2 = f5;
                        f3 = 0.0f;
                    }
                    this.mDrawMatrix.setScale(f2, f2);
                    this.mDrawMatrix.postTranslate(f3, f);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    float min = (width > width2 || height > height2) ? Math.min(width2 / width, height2 / height) : 1.0f;
                    this.mDrawMatrix.setScale(min, min);
                    this.mDrawMatrix.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.mTempSrc.set(0.0f, 0.0f, width, height);
                    this.mTempDst.set(0.0f, 0.0f, width2, height2);
                    this.mDrawMatrix.setRectToRect(this.mTempSrc, this.mTempDst, scaleTypeToScaleToFit(scaleType));
                }
            }
            int length = this.St.mRadius.length;
            for (int i = 0; i < length; i++) {
                if (this.St.mRadius[i] > 0.0f && this.St.mRadius[i] < 1.0f) {
                    this.St.mRadius[i] = this.St.mRadius[i] * this.mBounds.height();
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
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
        if (this.St.mExtraMatrix != null) {
            canvas.concat(this.St.mExtraMatrix);
        }
        if (dVar.Sy != null && dVar.Sy.isNinePatchBitmap()) {
            if ((dVar.Sy.getRawBitmap().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.Sy.getRawBitmap().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.mDrawMatrix != null) {
                canvas.concat(this.mDrawMatrix);
            }
            this.mTempForNinePatch.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.Sy.drawNinePatchImage(canvas, this.mTempForNinePatch);
        } else {
            b(canvas, dVar, imageView);
        }
        if (save2 >= 1 && save2 <= canvas.getSaveCount()) {
            canvas.restoreToCount(save2);
        }
        drawBorder(canvas, imageView);
        if (save >= 1 && save <= canvas.getSaveCount()) {
            canvas.restoreToCount(save);
        }
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
        if (this.Ss == null || !this.Ss.a(canvas, drawable)) {
            drawable.draw(canvas);
        }
    }

    public void a(e eVar) {
        this.St = eVar;
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
        this.mPaint.setAlpha((int) (255.0f * this.St.mAlpha));
        if (this.St.mIsNight) {
            this.mPaint.setColorFilter(sColorFilterForSkin);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.mBorderPaint.setColor(this.St.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.St.mBorderWidth);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public Path a(RectF rectF, float[] fArr) {
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        return path;
    }
}
