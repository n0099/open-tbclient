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
    private static final Matrix.ScaleToFit[] qy = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter qz = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint qA = new Paint();
    protected Paint qB = new Paint();
    protected Matrix qC = new Matrix();
    protected RectF qD = new RectF();
    protected RectF qE = new RectF();
    private RectF qF = new RectF();
    private RectF qG = new RectF();
    protected e qH = new e();
    private float[] qI = new float[9];
    private PointF qJ = new PointF();
    protected RectF qK = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.qA.setStyle(Paint.Style.STROKE);
        this.qA.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.qB.setAntiAlias(true);
        this.qB.setStyle(Paint.Style.FILL);
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
                this.qD.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.qC.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.qD.set(0.0f, 0.0f, width2, height2);
            } else {
                this.qD.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.qC.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.qC.setScale(f, f);
                    this.qC.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.qC.setScale(min, min);
                    this.qC.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.qF.set(0.0f, 0.0f, width, height);
                    this.qG.set(0.0f, 0.0f, width2, height2);
                    this.qC.setRectToRect(this.qF, this.qG, a(scaleType));
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
        if (this.qH.rp != null) {
            canvas.concat(this.qH.rp);
        }
        b(canvas, dVar, imageView);
        canvas.restoreToCount(save2);
        if (this.qH.rm && this.qH.ro != null && dVar.cm()) {
            if (!this.qH.rr) {
                this.qH.ro.setBounds(0, 0, this.qH.ro.getIntrinsicWidth(), this.qH.ro.getIntrinsicHeight());
                this.qH.ro.draw(canvas);
            } else {
                this.qH.ro.setBounds((right - 15) - this.qH.ro.getIntrinsicWidth(), (bottom - 15) - this.qH.ro.getIntrinsicHeight(), right - 15, bottom - 15);
                this.qH.ro.draw(canvas);
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
        this.qH = eVar;
    }

    public Matrix gy() {
        return this.qC;
    }

    public void a(Matrix matrix) {
        this.qC = matrix;
    }

    public RectF gz() {
        return this.qD;
    }

    private void gA() {
        this.mPaint.setAlpha((int) (255.0f * this.qH.mAlpha));
        if (this.qH.rk) {
            this.mPaint.setColorFilter(qz);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.qA.setColor(this.qH.rj);
        this.qA.setStrokeWidth(this.qH.ri);
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
        return qy[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.qI);
        this.qJ.set((int) ((this.qI[0] * f) + (this.qI[1] * f2) + this.qI[2]), (int) ((this.qI[3] * f) + (this.qI[4] * f2) + this.qI[5]));
        return this.qJ;
    }
}
