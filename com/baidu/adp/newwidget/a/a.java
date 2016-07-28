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
    private static final Matrix.ScaleToFit[] sv = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter sw = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint sx = new Paint();
    protected Paint sy = new Paint();
    protected Matrix sz = new Matrix();
    protected RectF sA = new RectF();
    protected RectF sB = new RectF();
    private RectF sC = new RectF();
    private RectF sD = new RectF();
    private RectF sE = new RectF();
    protected e sF = new e();
    private float[] sG = new float[9];
    private PointF sH = new PointF();
    protected RectF sI = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.sx.setStyle(Paint.Style.STROKE);
        this.sx.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.sy.setAntiAlias(true);
        this.sy.setStyle(Paint.Style.FILL);
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
                this.sA.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.sz.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.sA.set(0.0f, 0.0f, width2, height2);
            } else {
                this.sA.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.sz.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.sz.setScale(f, f);
                    this.sz.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.sz.setScale(min, min);
                    this.sz.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.sC.set(0.0f, 0.0f, width, height);
                    this.sD.set(0.0f, 0.0f, width2, height2);
                    this.sz.setRectToRect(this.sC, this.sD, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        gK();
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
        if (this.sF.tk != null) {
            canvas.concat(this.sF.tk);
        }
        if (dVar.tb != null && dVar.tb.jh()) {
            if ((dVar.tb.ja().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.tb.ja().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.sz != null) {
                canvas.concat(this.sz);
            }
            this.sE.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.tb.a(canvas, this.sE);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.sF.ti && this.sF.tj != null && dVar.cd()) {
            if (!this.sF.tm) {
                this.sF.tj.setBounds(0, 0, this.sF.tj.getIntrinsicWidth(), this.sF.tj.getIntrinsicHeight());
                this.sF.tj.draw(canvas);
            } else {
                this.sF.tj.setBounds((right - 15) - this.sF.tj.getIntrinsicWidth(), (bottom - 15) - this.sF.tj.getIntrinsicHeight(), right - 15, bottom - 15);
                this.sF.tj.draw(canvas);
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
        this.sF = eVar;
    }

    public Matrix gI() {
        return this.sz;
    }

    public void b(Matrix matrix) {
        this.sz = matrix;
    }

    public RectF gJ() {
        return this.sA;
    }

    private void gK() {
        this.mPaint.setAlpha((int) (255.0f * this.sF.mAlpha));
        if (this.sF.tg) {
            this.mPaint.setColorFilter(sw);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.sx.setColor(this.sF.tf);
        this.sx.setStrokeWidth(this.sF.te);
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
        return sv[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.sG);
        this.sH.set((int) ((this.sG[0] * f) + (this.sG[1] * f2) + this.sG[2]), (int) ((this.sG[3] * f) + (this.sG[4] * f2) + this.sG[5]));
        return this.sH;
    }
}
