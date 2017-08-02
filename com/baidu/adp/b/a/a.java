package com.baidu.adp.b.a;

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
    private static final Matrix.ScaleToFit[] Bv = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter Bw = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint Bx = new Paint();
    protected Paint By = new Paint();
    protected Matrix Bz = new Matrix();
    protected RectF BA = new RectF();
    protected RectF BB = new RectF();
    private RectF BC = new RectF();
    private RectF BD = new RectF();
    private RectF BE = new RectF();
    protected e BF = new e();
    private float[] BG = new float[9];
    private PointF BH = new PointF();
    protected RectF BI = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.Bx.setStyle(Paint.Style.STROKE);
        this.Bx.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.By.setAntiAlias(true);
        this.By.setStyle(Paint.Style.FILL);
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
                this.BA.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.Bz.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.BA.set(0.0f, 0.0f, width2, height2);
            } else {
                this.BA.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.Bz.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.Bz.setScale(f, f);
                    this.Bz.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.Bz.setScale(min, min);
                    this.Bz.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.BC.set(0.0f, 0.0f, width, height);
                    this.BD.set(0.0f, 0.0f, width2, height2);
                    this.Bz.setRectToRect(this.BC, this.BD, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        iy();
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
        if (this.BF.Cj != null) {
            canvas.concat(this.BF.Cj);
        }
        if (dVar.Ca != null && dVar.Ca.kU()) {
            if ((dVar.Ca.kN().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.Ca.kN().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.Bz != null) {
                canvas.concat(this.Bz);
            }
            this.BE.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.Ca.a(canvas, this.BE);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.BF.Ch && this.BF.Ci != null && dVar.isGif()) {
            if (!this.BF.Cl) {
                this.BF.Ci.setBounds(0, 0, this.BF.Ci.getIntrinsicWidth(), this.BF.Ci.getIntrinsicHeight());
                this.BF.Ci.draw(canvas);
            } else {
                this.BF.Ci.setBounds((right - 15) - this.BF.Ci.getIntrinsicWidth(), (bottom - 15) - this.BF.Ci.getIntrinsicHeight(), right - 15, bottom - 15);
                this.BF.Ci.draw(canvas);
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
        this.BF = eVar;
    }

    public Matrix iw() {
        return this.Bz;
    }

    public void b(Matrix matrix) {
        this.Bz = matrix;
    }

    public RectF ix() {
        return this.BA;
    }

    private void iy() {
        this.mPaint.setAlpha((int) (255.0f * this.BF.mAlpha));
        if (this.BF.Cf) {
            this.mPaint.setColorFilter(Bw);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.Bx.setColor(this.BF.Ce);
        this.Bx.setStrokeWidth(this.BF.Cd);
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
        return Bv[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.BG);
        this.BH.set((int) ((this.BG[0] * f) + (this.BG[1] * f2) + this.BG[2]), (int) ((this.BG[3] * f) + (this.BG[4] * f2) + this.BG[5]));
        return this.BH;
    }
}
