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
    private static final Matrix.ScaleToFit[] qE = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter qF = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint gs = new Paint(6);
    protected Paint qG = new Paint();
    protected Paint qH = new Paint();
    protected Matrix qI = new Matrix();
    protected RectF qJ = new RectF();
    protected RectF qK = new RectF();
    private RectF qL = new RectF();
    private RectF qM = new RectF();
    protected e qN = new e();
    private float[] qO = new float[9];
    private PointF qP = new PointF();
    protected RectF qQ = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.qG.setStyle(Paint.Style.STROKE);
        this.qG.setAntiAlias(true);
        this.gs.setAntiAlias(true);
        this.qH.setAntiAlias(true);
        this.qH.setStyle(Paint.Style.FILL);
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
                this.qJ.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.qI.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.qJ.set(0.0f, 0.0f, width2, height2);
            } else {
                this.qJ.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.qI.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.qI.setScale(f, f);
                    this.qI.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.qI.setScale(min, min);
                    this.qI.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.qL.set(0.0f, 0.0f, width, height);
                    this.qM.set(0.0f, 0.0f, width2, height2);
                    this.qI.setRectToRect(this.qL, this.qM, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        gz();
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
        if (this.qN.rv != null) {
            canvas.concat(this.qN.rv);
        }
        b(canvas, dVar, imageView);
        canvas.restoreToCount(save2);
        if (this.qN.rt && this.qN.ru != null && dVar.bM()) {
            this.qN.ru.setBounds(0, 0, this.qN.ru.getIntrinsicWidth(), this.qN.ru.getIntrinsicHeight());
            this.qN.ru.draw(canvas);
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
        this.qN = eVar;
    }

    public Matrix gx() {
        return this.qI;
    }

    public void a(Matrix matrix) {
        this.qI = matrix;
    }

    public RectF gy() {
        return this.qJ;
    }

    private void gz() {
        this.gs.setAlpha((int) (255.0f * this.qN.mAlpha));
        if (this.qN.rr) {
            this.gs.setColorFilter(qF);
        } else {
            this.gs.setColorFilter(null);
        }
        this.qG.setColor(this.qN.rq);
        this.qG.setStrokeWidth(this.qN.rp);
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
        return qE[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.qO);
        this.qP.set((int) ((this.qO[0] * f) + (this.qO[1] * f2) + this.qO[2]), (int) ((this.qO[3] * f) + (this.qO[4] * f2) + this.qO[5]));
        return this.qP;
    }
}
