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
    private static final Matrix.ScaleToFit[] Bi = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter Bj = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint Bk = new Paint();
    protected Paint Bl = new Paint();
    protected Matrix Bm = new Matrix();
    protected RectF Bn = new RectF();
    protected RectF Bo = new RectF();
    private RectF Bp = new RectF();
    private RectF Bq = new RectF();
    private RectF Br = new RectF();
    protected e Bs = new e();
    private float[] Bt = new float[9];
    private PointF Bu = new PointF();
    protected RectF Bv = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.Bk.setStyle(Paint.Style.STROKE);
        this.Bk.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.Bl.setAntiAlias(true);
        this.Bl.setStyle(Paint.Style.FILL);
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
                this.Bn.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.Bm.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.Bn.set(0.0f, 0.0f, width2, height2);
            } else {
                this.Bn.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.Bm.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.Bm.setScale(f, f);
                    this.Bm.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.Bm.setScale(min, min);
                    this.Bm.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.Bp.set(0.0f, 0.0f, width, height);
                    this.Bq.set(0.0f, 0.0f, width2, height2);
                    this.Bm.setRectToRect(this.Bp, this.Bq, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        kq();
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
        if (this.Bs.BW != null) {
            canvas.concat(this.Bs.BW);
        }
        if (dVar.BN != null && dVar.BN.mZ()) {
            if ((dVar.BN.mS().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.BN.mS().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.Bm != null) {
                canvas.concat(this.Bm);
            }
            this.Br.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.BN.a(canvas, this.Br);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.Bs.BU && this.Bs.BV != null && dVar.fN()) {
            if (!this.Bs.BY) {
                this.Bs.BV.setBounds(0, 0, this.Bs.BV.getIntrinsicWidth(), this.Bs.BV.getIntrinsicHeight());
                this.Bs.BV.draw(canvas);
            } else {
                this.Bs.BV.setBounds((right - 15) - this.Bs.BV.getIntrinsicWidth(), (bottom - 15) - this.Bs.BV.getIntrinsicHeight(), right - 15, bottom - 15);
                this.Bs.BV.draw(canvas);
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
        this.Bs = eVar;
    }

    public Matrix ko() {
        return this.Bm;
    }

    public void a(Matrix matrix) {
        this.Bm = matrix;
    }

    public RectF kp() {
        return this.Bn;
    }

    private void kq() {
        this.mPaint.setAlpha((int) (255.0f * this.Bs.mAlpha));
        if (this.Bs.BS) {
            this.mPaint.setColorFilter(Bj);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.Bk.setColor(this.Bs.BR);
        this.Bk.setStrokeWidth(this.Bs.BQ);
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
        return Bi[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.Bt);
        this.Bu.set((int) ((this.Bt[0] * f) + (this.Bt[1] * f2) + this.Bt[2]), (int) ((this.Bt[3] * f) + (this.Bt[4] * f2) + this.Bt[5]));
        return this.Bu;
    }
}
