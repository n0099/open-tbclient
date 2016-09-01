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
    private static final Matrix.ScaleToFit[] uL = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter uM = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint uN = new Paint();
    protected Paint uO = new Paint();
    protected Matrix uP = new Matrix();
    protected RectF uQ = new RectF();
    protected RectF uR = new RectF();
    private RectF uS = new RectF();
    private RectF uT = new RectF();
    private RectF uU = new RectF();
    protected e uV = new e();
    private float[] uW = new float[9];
    private PointF uX = new PointF();
    protected RectF uY = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.uN.setStyle(Paint.Style.STROKE);
        this.uN.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.uO.setAntiAlias(true);
        this.uO.setStyle(Paint.Style.FILL);
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
                this.uQ.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.uP.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.uQ.set(0.0f, 0.0f, width2, height2);
            } else {
                this.uQ.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.uP.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.uP.setScale(f, f);
                    this.uP.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.uP.setScale(min, min);
                    this.uP.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.uS.set(0.0f, 0.0f, width, height);
                    this.uT.set(0.0f, 0.0f, width2, height2);
                    this.uP.setRectToRect(this.uS, this.uT, a(scaleType));
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
        if (this.uV.vz != null) {
            canvas.concat(this.uV.vz);
        }
        if (dVar.vq != null && dVar.vq.kc()) {
            if ((dVar.vq.jV().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.vq.jV().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.uP != null) {
                canvas.concat(this.uP);
            }
            this.uU.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.vq.a(canvas, this.uU);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.uV.vx && this.uV.vy != null && dVar.cY()) {
            if (!this.uV.vB) {
                this.uV.vy.setBounds(0, 0, this.uV.vy.getIntrinsicWidth(), this.uV.vy.getIntrinsicHeight());
                this.uV.vy.draw(canvas);
            } else {
                this.uV.vy.setBounds((right - 15) - this.uV.vy.getIntrinsicWidth(), (bottom - 15) - this.uV.vy.getIntrinsicHeight(), right - 15, bottom - 15);
                this.uV.vy.draw(canvas);
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
        this.uV = eVar;
    }

    public Matrix hD() {
        return this.uP;
    }

    public void b(Matrix matrix) {
        this.uP = matrix;
    }

    public RectF hE() {
        return this.uQ;
    }

    private void hF() {
        this.mPaint.setAlpha((int) (255.0f * this.uV.mAlpha));
        if (this.uV.vv) {
            this.mPaint.setColorFilter(uM);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.uN.setColor(this.uV.vu);
        this.uN.setStrokeWidth(this.uV.vt);
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
        return uL[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.uW);
        this.uX.set((int) ((this.uW[0] * f) + (this.uW[1] * f2) + this.uW[2]), (int) ((this.uW[3] * f) + (this.uW[4] * f2) + this.uW[5]));
        return this.uX;
    }
}
