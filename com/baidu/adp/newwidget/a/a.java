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
    private static final Matrix.ScaleToFit[] Ba = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter Bb = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint Bc = new Paint();
    protected Paint Bd = new Paint();
    protected Matrix Be = new Matrix();
    protected RectF Bf = new RectF();
    protected RectF Bg = new RectF();
    private RectF Bh = new RectF();
    private RectF Bi = new RectF();
    private RectF Bj = new RectF();
    protected e Bk = new e();
    private float[] Bl = new float[9];
    private PointF Bm = new PointF();
    protected RectF Bn = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.Bc.setStyle(Paint.Style.STROKE);
        this.Bc.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.Bd.setAntiAlias(true);
        this.Bd.setStyle(Paint.Style.FILL);
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
                this.Bf.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.Be.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.Bf.set(0.0f, 0.0f, width2, height2);
            } else {
                this.Bf.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.Be.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.Be.setScale(f, f);
                    this.Be.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.Be.setScale(min, min);
                    this.Be.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.Bh.set(0.0f, 0.0f, width, height);
                    this.Bi.set(0.0f, 0.0f, width2, height2);
                    this.Be.setRectToRect(this.Bh, this.Bi, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        kg();
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
        if (this.Bk.BO != null) {
            canvas.concat(this.Bk.BO);
        }
        if (dVar.BF != null && dVar.BF.mL()) {
            if ((dVar.BF.mE().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.BF.mE().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.Be != null) {
                canvas.concat(this.Be);
            }
            this.Bj.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.BF.a(canvas, this.Bj);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.Bk.BM && this.Bk.BN != null && dVar.fF()) {
            if (!this.Bk.BQ) {
                this.Bk.BN.setBounds(0, 0, this.Bk.BN.getIntrinsicWidth(), this.Bk.BN.getIntrinsicHeight());
                this.Bk.BN.draw(canvas);
            } else {
                this.Bk.BN.setBounds((right - 15) - this.Bk.BN.getIntrinsicWidth(), (bottom - 15) - this.Bk.BN.getIntrinsicHeight(), right - 15, bottom - 15);
                this.Bk.BN.draw(canvas);
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
        this.Bk = eVar;
    }

    public Matrix ke() {
        return this.Be;
    }

    public void a(Matrix matrix) {
        this.Be = matrix;
    }

    public RectF kf() {
        return this.Bf;
    }

    private void kg() {
        this.mPaint.setAlpha((int) (255.0f * this.Bk.mAlpha));
        if (this.Bk.BK) {
            this.mPaint.setColorFilter(Bb);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.Bc.setColor(this.Bk.BJ);
        this.Bc.setStrokeWidth(this.Bk.BI);
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
        return Ba[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.Bl);
        this.Bm.set((int) ((this.Bl[0] * f) + (this.Bl[1] * f2) + this.Bl[2]), (int) ((this.Bl[3] * f) + (this.Bl[4] * f2) + this.Bl[5]));
        return this.Bm;
    }
}
