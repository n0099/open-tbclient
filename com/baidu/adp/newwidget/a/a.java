package com.baidu.adp.newwidget.a;

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
    private static final Matrix.ScaleToFit[] BR = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter BS = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint BT = new Paint();
    protected Paint BU = new Paint();
    protected Matrix BV = new Matrix();
    protected RectF BW = new RectF();
    protected RectF BX = new RectF();
    private RectF BY = new RectF();
    private RectF BZ = new RectF();
    private RectF Ca = new RectF();
    protected e Cb = new e();
    private float[] Cc = new float[9];
    private PointF Cd = new PointF();
    protected RectF Ce = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.BT.setStyle(Paint.Style.STROKE);
        this.BT.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.BU.setAntiAlias(true);
        this.BU.setStyle(Paint.Style.FILL);
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
                this.BW.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.BV.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.BW.set(0.0f, 0.0f, width2, height2);
            } else {
                this.BW.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.BV.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.BV.setScale(f, f);
                    this.BV.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.BV.setScale(min, min);
                    this.BV.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.BY.set(0.0f, 0.0f, width, height);
                    this.BZ.set(0.0f, 0.0f, width2, height2);
                    this.BV.setRectToRect(this.BY, this.BZ, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        ix();
        int save = canvas.save();
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        int paddingLeft = imageView.getPaddingLeft();
        int paddingRight = imageView.getPaddingRight();
        int paddingTop = imageView.getPaddingTop();
        int paddingBottom = imageView.getPaddingBottom();
        int left = imageView.getLeft();
        int right = imageView.getRight();
        int top = imageView.getTop();
        int bottom = imageView.getBottom();
        canvas.clipRect(scrollX + paddingLeft, scrollY + paddingTop, ((scrollX + right) - left) - paddingRight, ((scrollY + bottom) - top) - paddingBottom);
        canvas.translate(paddingLeft, paddingTop);
        int save2 = canvas.save();
        if (this.Cb.CF != null) {
            canvas.concat(this.Cb.CF);
        }
        if (dVar.Cw != null && dVar.Cw.kU()) {
            if ((dVar.Cw.kN().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.Cw.kN().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.BV != null) {
                canvas.concat(this.BV);
            }
            this.Ca.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.Cw.a(canvas, this.Ca);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.Cb.CD && this.Cb.CE != null && dVar.ef()) {
            if (!this.Cb.CH) {
                this.Cb.CE.setBounds(0, 0, this.Cb.CE.getIntrinsicWidth(), this.Cb.CE.getIntrinsicHeight());
                this.Cb.CE.draw(canvas);
            } else {
                this.Cb.CE.setBounds((right - 15) - this.Cb.CE.getIntrinsicWidth(), (bottom - 15) - this.Cb.CE.getIntrinsicHeight(), right - 15, bottom - 15);
                this.Cb.CE.draw(canvas);
            }
        }
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
        this.Cb = eVar;
    }

    public Matrix iv() {
        return this.BV;
    }

    public void b(Matrix matrix) {
        this.BV = matrix;
    }

    public RectF iw() {
        return this.BW;
    }

    private void ix() {
        this.mPaint.setAlpha((int) (255.0f * this.Cb.mAlpha));
        if (this.Cb.CB) {
            this.mPaint.setColorFilter(BS);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.BT.setColor(this.Cb.CA);
        this.BT.setStrokeWidth(this.Cb.Cz);
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
        return BR[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.Cc);
        this.Cd.set((int) ((this.Cc[0] * f) + (this.Cc[1] * f2) + this.Cc[2]), (int) ((this.Cc[3] * f) + (this.Cc[4] * f2) + this.Cc[5]));
        return this.Cd;
    }
}
