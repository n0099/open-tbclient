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
    private static final Matrix.ScaleToFit[] uM = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter uN = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint uO = new Paint();
    protected Paint uP = new Paint();
    protected Matrix uQ = new Matrix();
    protected RectF uR = new RectF();
    protected RectF uS = new RectF();
    private RectF uT = new RectF();
    private RectF uU = new RectF();
    private RectF uV = new RectF();
    protected e uW = new e();
    private float[] uX = new float[9];
    private PointF uY = new PointF();
    protected RectF uZ = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.uO.setStyle(Paint.Style.STROKE);
        this.uO.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.uP.setAntiAlias(true);
        this.uP.setStyle(Paint.Style.FILL);
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
                this.uR.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.uQ.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.uR.set(0.0f, 0.0f, width2, height2);
            } else {
                this.uR.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.uQ.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.uQ.setScale(f, f);
                    this.uQ.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.uQ.setScale(min, min);
                    this.uQ.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.uT.set(0.0f, 0.0f, width, height);
                    this.uU.set(0.0f, 0.0f, width2, height2);
                    this.uQ.setRectToRect(this.uT, this.uU, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        hF();
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
        if (this.uW.vA != null) {
            canvas.concat(this.uW.vA);
        }
        if (dVar.vr != null && dVar.vr.kc()) {
            if ((dVar.vr.jV().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.vr.jV().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.uQ != null) {
                canvas.concat(this.uQ);
            }
            this.uV.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.vr.a(canvas, this.uV);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.uW.vy && this.uW.vz != null && dVar.cY()) {
            if (!this.uW.vC) {
                this.uW.vz.setBounds(0, 0, this.uW.vz.getIntrinsicWidth(), this.uW.vz.getIntrinsicHeight());
                this.uW.vz.draw(canvas);
            } else {
                this.uW.vz.setBounds((right - 15) - this.uW.vz.getIntrinsicWidth(), (bottom - 15) - this.uW.vz.getIntrinsicHeight(), right - 15, bottom - 15);
                this.uW.vz.draw(canvas);
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
        this.uW = eVar;
    }

    public Matrix hD() {
        return this.uQ;
    }

    public void b(Matrix matrix) {
        this.uQ = matrix;
    }

    public RectF hE() {
        return this.uR;
    }

    private void hF() {
        this.mPaint.setAlpha((int) (255.0f * this.uW.mAlpha));
        if (this.uW.vw) {
            this.mPaint.setColorFilter(uN);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.uO.setColor(this.uW.vv);
        this.uO.setStrokeWidth(this.uW.vu);
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
        return uM[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.uX);
        this.uY.set((int) ((this.uX[0] * f) + (this.uX[1] * f2) + this.uX[2]), (int) ((this.uX[3] * f) + (this.uX[4] * f2) + this.uX[5]));
        return this.uY;
    }
}
