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
    private static final Matrix.ScaleToFit[] apd = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter ape = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint apf = new Paint();
    protected Paint apg = new Paint();
    protected Matrix aph = new Matrix();
    protected RectF api = new RectF();
    protected RectF apj = new RectF();
    private RectF apk = new RectF();
    private RectF apl = new RectF();
    private RectF apm = new RectF();
    protected e mArgs = new e();
    private float[] Bu = new float[9];
    private PointF apn = new PointF();
    protected RectF apo = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.apf.setStyle(Paint.Style.STROKE);
        this.apf.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.apg.setAntiAlias(true);
        this.apg.setStyle(Paint.Style.FILL);
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
                this.api.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.aph.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.api.set(0.0f, 0.0f, width2, height2);
            } else {
                this.api.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.aph.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.aph.setScale(f, f);
                    this.aph.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.aph.setScale(min, min);
                    this.aph.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.apk.set(0.0f, 0.0f, width, height);
                    this.apl.set(0.0f, 0.0f, width2, height2);
                    this.aph.setRectToRect(this.apk, this.apl, a(scaleType));
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
        if (this.mArgs.apz != null) {
            canvas.concat(this.mArgs.apz);
        }
        if (dVar.aps != null && dVar.aps.sq()) {
            if ((dVar.aps.sj().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.aps.sj().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.aph != null) {
                canvas.concat(this.aph);
            }
            this.apm.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.aps.a(canvas, this.apm);
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
        return this.aph;
    }

    public void b(Matrix matrix) {
        this.aph = matrix;
    }

    public RectF pY() {
        return this.api;
    }

    private void pZ() {
        this.mPaint.setAlpha((int) (255.0f * this.mArgs.mAlpha));
        if (this.mArgs.CM) {
            this.mPaint.setColorFilter(ape);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.apf.setColor(this.mArgs.apv);
        this.apf.setStrokeWidth(this.mArgs.ou);
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
        return apd[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.Bu);
        this.apn.set((int) ((this.Bu[0] * f) + (this.Bu[1] * f2) + this.Bu[2]), (int) ((this.Bu[3] * f) + (this.Bu[4] * f2) + this.Bu[5]));
        return this.apn;
    }
}
