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
    private static final Matrix.ScaleToFit[] rQ = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter rR = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint rS = new Paint();
    protected Paint rT = new Paint();
    protected Matrix rU = new Matrix();
    protected RectF rV = new RectF();
    protected RectF rW = new RectF();
    private RectF rX = new RectF();
    private RectF rY = new RectF();
    private RectF rZ = new RectF();
    protected e sa = new e();
    private float[] sb = new float[9];
    private PointF sc = new PointF();
    protected RectF sd = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.rS.setStyle(Paint.Style.STROKE);
        this.rS.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.rT.setAntiAlias(true);
        this.rT.setStyle(Paint.Style.FILL);
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
                this.rV.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.rU.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.rV.set(0.0f, 0.0f, width2, height2);
            } else {
                this.rV.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.rU.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.rU.setScale(f, f);
                    this.rU.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.rU.setScale(min, min);
                    this.rU.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.rX.set(0.0f, 0.0f, width, height);
                    this.rY.set(0.0f, 0.0f, width2, height2);
                    this.rU.setRectToRect(this.rX, this.rY, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        gJ();
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
        if (this.sa.sG != null) {
            canvas.concat(this.sa.sG);
        }
        if (dVar.sx != null && dVar.sx.jf()) {
            if ((dVar.sx.iY().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.sx.iY().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.rU != null) {
                canvas.concat(this.rU);
            }
            this.rZ.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.sx.a(canvas, this.rZ);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.sa.sE && this.sa.sF != null && dVar.cd()) {
            if (!this.sa.sI) {
                this.sa.sF.setBounds(0, 0, this.sa.sF.getIntrinsicWidth(), this.sa.sF.getIntrinsicHeight());
                this.sa.sF.draw(canvas);
            } else {
                this.sa.sF.setBounds((right - 15) - this.sa.sF.getIntrinsicWidth(), (bottom - 15) - this.sa.sF.getIntrinsicHeight(), right - 15, bottom - 15);
                this.sa.sF.draw(canvas);
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
        this.sa = eVar;
    }

    public Matrix gH() {
        return this.rU;
    }

    public void a(Matrix matrix) {
        this.rU = matrix;
    }

    public RectF gI() {
        return this.rV;
    }

    private void gJ() {
        this.mPaint.setAlpha((int) (255.0f * this.sa.mAlpha));
        if (this.sa.sC) {
            this.mPaint.setColorFilter(rR);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.rS.setColor(this.sa.sB);
        this.rS.setStrokeWidth(this.sa.sA);
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
        return rQ[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.sb);
        this.sc.set((int) ((this.sb[0] * f) + (this.sb[1] * f2) + this.sb[2]), (int) ((this.sb[3] * f) + (this.sb[4] * f2) + this.sb[5]));
        return this.sc;
    }
}
