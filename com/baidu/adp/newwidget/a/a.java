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
    private static final Matrix.ScaleToFit[] AY = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter AZ = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint Ba = new Paint();
    protected Paint Bb = new Paint();
    protected Matrix Bc = new Matrix();
    protected RectF Bd = new RectF();
    protected RectF Be = new RectF();
    private RectF Bf = new RectF();
    private RectF Bg = new RectF();
    private RectF Bh = new RectF();
    protected e Bi = new e();
    private float[] Bj = new float[9];
    private PointF Bk = new PointF();
    protected RectF Bl = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.Ba.setStyle(Paint.Style.STROKE);
        this.Ba.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.Bb.setAntiAlias(true);
        this.Bb.setStyle(Paint.Style.FILL);
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
                this.Bd.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.Bc.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.Bd.set(0.0f, 0.0f, width2, height2);
            } else {
                this.Bd.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.Bc.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.Bc.setScale(f, f);
                    this.Bc.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.Bc.setScale(min, min);
                    this.Bc.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.Bf.set(0.0f, 0.0f, width, height);
                    this.Bg.set(0.0f, 0.0f, width2, height2);
                    this.Bc.setRectToRect(this.Bf, this.Bg, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        kf();
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
        if (this.Bi.BM != null) {
            canvas.concat(this.Bi.BM);
        }
        if (dVar.BD != null && dVar.BD.nn()) {
            if ((dVar.BD.ng().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.BD.ng().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.Bc != null) {
                canvas.concat(this.Bc);
            }
            this.Bh.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.BD.a(canvas, this.Bh);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.Bi.BK && this.Bi.BL != null && dVar.fF()) {
            if (!this.Bi.BO) {
                this.Bi.BL.setBounds(0, 0, this.Bi.BL.getIntrinsicWidth(), this.Bi.BL.getIntrinsicHeight());
                this.Bi.BL.draw(canvas);
            } else {
                this.Bi.BL.setBounds((right - 15) - this.Bi.BL.getIntrinsicWidth(), (bottom - 15) - this.Bi.BL.getIntrinsicHeight(), right - 15, bottom - 15);
                this.Bi.BL.draw(canvas);
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
        this.Bi = eVar;
    }

    public Matrix kd() {
        return this.Bc;
    }

    public void a(Matrix matrix) {
        this.Bc = matrix;
    }

    public RectF ke() {
        return this.Bd;
    }

    private void kf() {
        this.mPaint.setAlpha((int) (255.0f * this.Bi.mAlpha));
        if (this.Bi.BI) {
            this.mPaint.setColorFilter(AZ);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.Ba.setColor(this.Bi.BH);
        this.Ba.setStrokeWidth(this.Bi.BG);
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
        return AY[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.Bj);
        this.Bk.set((int) ((this.Bj[0] * f) + (this.Bj[1] * f2) + this.Bj[2]), (int) ((this.Bj[3] * f) + (this.Bj[4] * f2) + this.Bj[5]));
        return this.Bk;
    }
}
