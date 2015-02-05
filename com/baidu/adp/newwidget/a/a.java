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
    private static final Matrix.ScaleToFit[] qD = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter qE = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint qF = new Paint();
    protected Paint qG = new Paint();
    protected Matrix qH = new Matrix();
    protected RectF qI = new RectF();
    protected RectF qJ = new RectF();
    private RectF qK = new RectF();
    private RectF qL = new RectF();
    protected e qM = new e();
    private float[] qN = new float[9];
    private PointF qO = new PointF();
    protected RectF qP = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.qF.setStyle(Paint.Style.STROKE);
        this.qF.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.qG.setAntiAlias(true);
        this.qG.setStyle(Paint.Style.FILL);
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
                this.qI.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.qH.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.qI.set(0.0f, 0.0f, width2, height2);
            } else {
                this.qI.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.qH.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.qH.setScale(f, f);
                    this.qH.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.qH.setScale(min, min);
                    this.qH.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.qK.set(0.0f, 0.0f, width, height);
                    this.qL.set(0.0f, 0.0f, width2, height2);
                    this.qH.setRectToRect(this.qK, this.qL, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        gA();
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
        if (this.qM.ru != null) {
            canvas.concat(this.qM.ru);
        }
        b(canvas, dVar, imageView);
        canvas.restoreToCount(save2);
        if (this.qM.rs && this.qM.rt != null && dVar.ck()) {
            if (!this.qM.rw) {
                this.qM.rt.setBounds(0, 0, this.qM.rt.getIntrinsicWidth(), this.qM.rt.getIntrinsicHeight());
                this.qM.rt.draw(canvas);
            } else {
                this.qM.rt.setBounds((right - 15) - this.qM.rt.getIntrinsicWidth(), (bottom - 15) - this.qM.rt.getIntrinsicHeight(), right - 15, bottom - 15);
                this.qM.rt.draw(canvas);
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
        this.qM = eVar;
    }

    public Matrix gy() {
        return this.qH;
    }

    public void a(Matrix matrix) {
        this.qH = matrix;
    }

    public RectF gz() {
        return this.qI;
    }

    private void gA() {
        this.mPaint.setAlpha((int) (255.0f * this.qM.mAlpha));
        if (this.qM.rq) {
            this.mPaint.setColorFilter(qE);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.qF.setColor(this.qM.rp);
        this.qF.setStrokeWidth(this.qM.ro);
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
        return qD[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.qN);
        this.qO.set((int) ((this.qN[0] * f) + (this.qN[1] * f2) + this.qN[2]), (int) ((this.qN[3] * f) + (this.qN[4] * f2) + this.qN[5]));
        return this.qO;
    }
}
