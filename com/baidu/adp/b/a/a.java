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
    private static final Matrix.ScaleToFit[] apc = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter apd = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint ape = new Paint();
    protected Paint apf = new Paint();
    protected Matrix apg = new Matrix();
    protected RectF aph = new RectF();
    protected RectF api = new RectF();
    private RectF apj = new RectF();
    private RectF apk = new RectF();
    private RectF apl = new RectF();
    protected e mArgs = new e();
    private float[] Bt = new float[9];
    private PointF apm = new PointF();
    protected RectF apn = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.ape.setStyle(Paint.Style.STROKE);
        this.ape.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.apf.setAntiAlias(true);
        this.apf.setStyle(Paint.Style.FILL);
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
                this.aph.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.apg.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.aph.set(0.0f, 0.0f, width2, height2);
            } else {
                this.aph.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.apg.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.apg.setScale(f, f);
                    this.apg.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.apg.setScale(min, min);
                    this.apg.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.apj.set(0.0f, 0.0f, width, height);
                    this.apk.set(0.0f, 0.0f, width2, height2);
                    this.apg.setRectToRect(this.apj, this.apk, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        pZ();
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
        if (this.mArgs.apy != null) {
            canvas.concat(this.mArgs.apy);
        }
        if (dVar.apr != null && dVar.apr.so()) {
            if ((dVar.apr.sh().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.apr.sh().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.apg != null) {
                canvas.concat(this.apg);
            }
            this.apl.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.apr.a(canvas, this.apl);
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

    public Matrix pX() {
        return this.apg;
    }

    public void b(Matrix matrix) {
        this.apg = matrix;
    }

    public RectF pY() {
        return this.aph;
    }

    private void pZ() {
        this.mPaint.setAlpha((int) (255.0f * this.mArgs.mAlpha));
        if (this.mArgs.CL) {
            this.mPaint.setColorFilter(apd);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.ape.setColor(this.mArgs.apu);
        this.ape.setStrokeWidth(this.mArgs.ou);
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
        return apc[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.Bt);
        this.apm.set((int) ((this.Bt[0] * f) + (this.Bt[1] * f2) + this.Bt[2]), (int) ((this.Bt[3] * f) + (this.Bt[4] * f2) + this.Bt[5]));
        return this.apm;
    }
}
