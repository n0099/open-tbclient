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
    private static final Matrix.ScaleToFit[] apb = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter apc = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint apd = new Paint();
    protected Paint ape = new Paint();
    protected Matrix apf = new Matrix();
    protected RectF apg = new RectF();
    protected RectF aph = new RectF();
    private RectF api = new RectF();
    private RectF apj = new RectF();
    private RectF apk = new RectF();
    protected e mArgs = new e();
    private float[] Bu = new float[9];
    private PointF apl = new PointF();
    protected RectF apm = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.apd.setStyle(Paint.Style.STROKE);
        this.apd.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.ape.setAntiAlias(true);
        this.ape.setStyle(Paint.Style.FILL);
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
                this.apg.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.apf.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.apg.set(0.0f, 0.0f, width2, height2);
            } else {
                this.apg.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.apf.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.apf.setScale(f, f);
                    this.apf.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.apf.setScale(min, min);
                    this.apf.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.api.set(0.0f, 0.0f, width, height);
                    this.apj.set(0.0f, 0.0f, width2, height2);
                    this.apf.setRectToRect(this.api, this.apj, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        pY();
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
        if (this.mArgs.apx != null) {
            canvas.concat(this.mArgs.apx);
        }
        if (dVar.apq != null && dVar.apq.sp()) {
            if ((dVar.apq.si().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.apq.si().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.apf != null) {
                canvas.concat(this.apf);
            }
            this.apk.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.apq.a(canvas, this.apk);
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

    public Matrix pW() {
        return this.apf;
    }

    public void b(Matrix matrix) {
        this.apf = matrix;
    }

    public RectF pX() {
        return this.apg;
    }

    private void pY() {
        this.mPaint.setAlpha((int) (255.0f * this.mArgs.mAlpha));
        if (this.mArgs.CM) {
            this.mPaint.setColorFilter(apc);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.apd.setColor(this.mArgs.apt);
        this.apd.setStrokeWidth(this.mArgs.ou);
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
        return apb[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.Bu);
        this.apl.set((int) ((this.Bu[0] * f) + (this.Bu[1] * f2) + this.Bu[2]), (int) ((this.Bu[3] * f) + (this.Bu[4] * f2) + this.Bu[5]));
        return this.apl;
    }
}
