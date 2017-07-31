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
    private static final Matrix.ScaleToFit[] CV = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter CW = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint CX = new Paint();
    protected Paint CY = new Paint();
    protected Matrix CZ = new Matrix();
    protected RectF Da = new RectF();
    protected RectF Db = new RectF();
    private RectF Dc = new RectF();
    private RectF Dd = new RectF();
    private RectF De = new RectF();
    protected e Df = new e();
    private float[] Dg = new float[9];
    private PointF Dh = new PointF();
    protected RectF Di = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.CX.setStyle(Paint.Style.STROKE);
        this.CX.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.CY.setAntiAlias(true);
        this.CY.setStyle(Paint.Style.FILL);
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
                this.Da.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.CZ.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.Da.set(0.0f, 0.0f, width2, height2);
            } else {
                this.Da.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.CZ.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.CZ.setScale(f, f);
                    this.CZ.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.CZ.setScale(min, min);
                    this.CZ.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.Dc.set(0.0f, 0.0f, width, height);
                    this.Dd.set(0.0f, 0.0f, width2, height2);
                    this.CZ.setRectToRect(this.Dc, this.Dd, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        iI();
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
        if (this.Df.DI != null) {
            canvas.concat(this.Df.DI);
        }
        if (dVar.Dz != null && dVar.Dz.le()) {
            if ((dVar.Dz.kX().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.Dz.kX().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.CZ != null) {
                canvas.concat(this.CZ);
            }
            this.De.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.Dz.a(canvas, this.De);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.Df.DG && this.Df.DH != null && dVar.isGif()) {
            if (!this.Df.DK) {
                this.Df.DH.setBounds(0, 0, this.Df.DH.getIntrinsicWidth(), this.Df.DH.getIntrinsicHeight());
                this.Df.DH.draw(canvas);
            } else {
                this.Df.DH.setBounds((right - 15) - this.Df.DH.getIntrinsicWidth(), (bottom - 15) - this.Df.DH.getIntrinsicHeight(), right - 15, bottom - 15);
                this.Df.DH.draw(canvas);
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
        this.Df = eVar;
    }

    public Matrix iG() {
        return this.CZ;
    }

    public void b(Matrix matrix) {
        this.CZ = matrix;
    }

    public RectF iH() {
        return this.Da;
    }

    private void iI() {
        this.mPaint.setAlpha((int) (255.0f * this.Df.mAlpha));
        if (this.Df.DE) {
            this.mPaint.setColorFilter(CW);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.CX.setColor(this.Df.DD);
        this.CX.setStrokeWidth(this.Df.DC);
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
        return CV[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.Dg);
        this.Dh.set((int) ((this.Dg[0] * f) + (this.Dg[1] * f2) + this.Dg[2]), (int) ((this.Dg[3] * f) + (this.Dg[4] * f2) + this.Dg[5]));
        return this.Dh;
    }
}
