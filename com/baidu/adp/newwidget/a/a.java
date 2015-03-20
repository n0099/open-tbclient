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
    private static final Matrix.ScaleToFit[] Br = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter Bs = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint Bt = new Paint();
    protected Paint Bu = new Paint();
    protected Matrix Bv = new Matrix();
    protected RectF Bw = new RectF();
    protected RectF Bx = new RectF();
    private RectF By = new RectF();
    private RectF Bz = new RectF();
    protected e BA = new e();
    private float[] BB = new float[9];
    private PointF BC = new PointF();
    protected RectF BD = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.Bt.setStyle(Paint.Style.STROKE);
        this.Bt.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.Bu.setAntiAlias(true);
        this.Bu.setStyle(Paint.Style.FILL);
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
                this.Bw.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.Bv.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.Bw.set(0.0f, 0.0f, width2, height2);
            } else {
                this.Bw.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.Bv.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.Bv.setScale(f, f);
                    this.Bv.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.Bv.setScale(min, min);
                    this.Bv.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.By.set(0.0f, 0.0f, width, height);
                    this.Bz.set(0.0f, 0.0f, width2, height2);
                    this.Bv.setRectToRect(this.By, this.Bz, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        jV();
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
        if (this.BA.Ch != null) {
            canvas.concat(this.BA.Ch);
        }
        b(canvas, dVar, imageView);
        canvas.restoreToCount(save2);
        if (this.BA.Cf && this.BA.Cg != null && dVar.fI()) {
            if (!this.BA.Cj) {
                this.BA.Cg.setBounds(0, 0, this.BA.Cg.getIntrinsicWidth(), this.BA.Cg.getIntrinsicHeight());
                this.BA.Cg.draw(canvas);
            } else {
                this.BA.Cg.setBounds((right - 15) - this.BA.Cg.getIntrinsicWidth(), (bottom - 15) - this.BA.Cg.getIntrinsicHeight(), right - 15, bottom - 15);
                this.BA.Cg.draw(canvas);
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
        this.BA = eVar;
    }

    public Matrix jT() {
        return this.Bv;
    }

    public void a(Matrix matrix) {
        this.Bv = matrix;
    }

    public RectF jU() {
        return this.Bw;
    }

    private void jV() {
        this.mPaint.setAlpha((int) (255.0f * this.BA.mAlpha));
        if (this.BA.Cd) {
            this.mPaint.setColorFilter(Bs);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.Bt.setColor(this.BA.Cc);
        this.Bt.setStrokeWidth(this.BA.Cb);
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
        return Br[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.BB);
        this.BC.set((int) ((this.BB[0] * f) + (this.BB[1] * f2) + this.BB[2]), (int) ((this.BB[3] * f) + (this.BB[4] * f2) + this.BB[5]));
        return this.BC;
    }
}
