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
    private static final Matrix.ScaleToFit[] BD = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter BE = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint BF = new Paint();
    protected Paint BG = new Paint();
    protected Matrix BH = new Matrix();
    protected RectF BI = new RectF();
    protected RectF BJ = new RectF();
    private RectF BK = new RectF();
    private RectF BL = new RectF();
    private RectF BM = new RectF();
    protected e BN = new e();
    private float[] BO = new float[9];
    private PointF BP = new PointF();
    protected RectF BQ = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.BF.setStyle(Paint.Style.STROKE);
        this.BF.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.BG.setAntiAlias(true);
        this.BG.setStyle(Paint.Style.FILL);
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
                this.BI.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.BH.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.BI.set(0.0f, 0.0f, width2, height2);
            } else {
                this.BI.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.BH.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.BH.setScale(f, f);
                    this.BH.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.BH.setScale(min, min);
                    this.BH.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.BK.set(0.0f, 0.0f, width, height);
                    this.BL.set(0.0f, 0.0f, width2, height2);
                    this.BH.setRectToRect(this.BK, this.BL, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        kw();
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
        if (this.BN.Cr != null) {
            canvas.concat(this.BN.Cr);
        }
        if (dVar.Ci != null && dVar.Ci.mR()) {
            if ((dVar.Ci.mK().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.Ci.mK().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.BH != null) {
                canvas.concat(this.BH);
            }
            this.BM.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.Ci.a(canvas, this.BM);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.BN.Cp && this.BN.Cq != null && dVar.fO()) {
            if (!this.BN.Ct) {
                this.BN.Cq.setBounds(0, 0, this.BN.Cq.getIntrinsicWidth(), this.BN.Cq.getIntrinsicHeight());
                this.BN.Cq.draw(canvas);
            } else {
                this.BN.Cq.setBounds((right - 15) - this.BN.Cq.getIntrinsicWidth(), (bottom - 15) - this.BN.Cq.getIntrinsicHeight(), right - 15, bottom - 15);
                this.BN.Cq.draw(canvas);
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
        this.BN = eVar;
    }

    public Matrix ku() {
        return this.BH;
    }

    public void a(Matrix matrix) {
        this.BH = matrix;
    }

    public RectF kv() {
        return this.BI;
    }

    private void kw() {
        this.mPaint.setAlpha((int) (255.0f * this.BN.mAlpha));
        if (this.BN.Cn) {
            this.mPaint.setColorFilter(BE);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.BF.setColor(this.BN.Cm);
        this.BF.setStrokeWidth(this.BN.Cl);
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
        return BD[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.BO);
        this.BP.set((int) ((this.BO[0] * f) + (this.BO[1] * f2) + this.BO[2]), (int) ((this.BO[3] * f) + (this.BO[4] * f2) + this.BO[5]));
        return this.BP;
    }
}
