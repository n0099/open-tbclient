package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
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
    private static final Matrix.ScaleToFit[] aoW = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter aoX = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint mBorderPaint = new Paint();
    protected Paint aoY = new Paint();
    protected Matrix aoZ = new Matrix();
    protected RectF apa = new RectF();
    protected RectF mBorderRect = new RectF();
    private RectF apb = new RectF();
    private RectF apc = new RectF();
    private RectF apd = new RectF();
    protected e mArgs = new e();
    private float[] Bo = new float[9];
    private PointF ape = new PointF();
    protected RectF apf = new RectF();
    private ColorFilter apg = null;

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.aoY.setAntiAlias(true);
        this.aoY.setStyle(Paint.Style.FILL);
    }

    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        float min;
        float f;
        float f2;
        float f3 = 0.0f;
        if (imageView.getWidth() != 0 && imageView.getHeight() != 0) {
            int width = dVar.getWidth();
            int height = dVar.getHeight();
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height2 = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            if (scaleType == ImageView.ScaleType.MATRIX) {
                this.apa.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.aoZ.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.apa.set(0.0f, 0.0f, width2, height2);
            } else {
                this.apa.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.aoZ.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.aoZ.setScale(f, f);
                    this.aoZ.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.aoZ.setScale(min, min);
                    this.aoZ.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.apb.set(0.0f, 0.0f, width, height);
                    this.apc.set(0.0f, 0.0f, width2, height2);
                    this.aoZ.setRectToRect(this.apb, this.apc, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        pZ();
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
        if (this.mArgs.apq != null) {
            canvas.concat(this.mArgs.apq);
        }
        if (dVar.apj != null && dVar.apj.so()) {
            if ((dVar.apj.sh().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.apj.sh().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.aoZ != null) {
                canvas.concat(this.aoZ);
            }
            this.apd.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.apj.a(canvas, this.apd);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        b(canvas, imageView);
        canvas.restoreToCount(save);
    }

    public void a(Canvas canvas, ImageView imageView, Drawable drawable) {
        if (drawable != null) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            drawable.setBounds(0, 0, imageView.getWidth(), imageView.getHeight());
            if ((scrollX | scrollY) == 0) {
                a(canvas, drawable);
                return;
            }
            canvas.translate(scrollX, scrollY);
            a(canvas, drawable);
            canvas.translate(-scrollX, -scrollY);
        }
    }

    protected void a(Canvas canvas, Drawable drawable) {
        drawable.draw(canvas);
    }

    public void a(e eVar) {
        this.mArgs = eVar;
    }

    public Matrix pX() {
        return this.aoZ;
    }

    public void b(Matrix matrix) {
        this.aoZ = matrix;
    }

    public RectF pY() {
        return this.apa;
    }

    private void pZ() {
        this.mPaint.setAlpha((int) (255.0f * this.mArgs.mAlpha));
        if (this.apg == null) {
            if (this.mArgs.CG) {
                this.mPaint.setColorFilter(aoX);
            } else {
                this.mPaint.setColorFilter(null);
            }
        } else {
            this.mPaint.setColorFilter(this.apg);
        }
        this.mBorderPaint.setColor(this.mArgs.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mArgs.mBorderWidth);
    }

    private static Matrix.ScaleToFit a(ImageView.ScaleType scaleType) {
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
        return aoW[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.Bo);
        this.ape.set((int) ((this.Bo[0] * f) + (this.Bo[1] * f2) + this.Bo[2]), (int) ((this.Bo[3] * f) + (this.Bo[4] * f2) + this.Bo[5]));
        return this.ape;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.apg = colorFilter;
    }
}
