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
    private static final Matrix.ScaleToFit[] Bs = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter Bt = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint Bu = new Paint();
    protected Paint Bv = new Paint();
    protected Matrix Bw = new Matrix();
    protected RectF Bx = new RectF();
    protected RectF By = new RectF();
    private RectF Bz = new RectF();
    private RectF BA = new RectF();
    private RectF BB = new RectF();
    protected e BC = new e();
    private float[] BD = new float[9];
    private PointF BE = new PointF();
    protected RectF BF = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.Bu.setStyle(Paint.Style.STROKE);
        this.Bu.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.Bv.setAntiAlias(true);
        this.Bv.setStyle(Paint.Style.FILL);
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
                this.Bx.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.Bw.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.Bx.set(0.0f, 0.0f, width2, height2);
            } else {
                this.Bx.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.Bw.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.Bw.setScale(f, f);
                    this.Bw.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.Bw.setScale(min, min);
                    this.Bw.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.Bz.set(0.0f, 0.0f, width, height);
                    this.BA.set(0.0f, 0.0f, width2, height2);
                    this.Bw.setRectToRect(this.Bz, this.BA, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        iB();
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
        if (this.BC.Cg != null) {
            canvas.concat(this.BC.Cg);
        }
        if (dVar.BX != null && dVar.BX.kY()) {
            if ((dVar.BX.kR().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.BX.kR().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.Bw != null) {
                canvas.concat(this.Bw);
            }
            this.BB.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.BX.a(canvas, this.BB);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.BC.Ce && this.BC.Cf != null && dVar.ee()) {
            if (!this.BC.Ci) {
                this.BC.Cf.setBounds(0, 0, this.BC.Cf.getIntrinsicWidth(), this.BC.Cf.getIntrinsicHeight());
                this.BC.Cf.draw(canvas);
            } else {
                this.BC.Cf.setBounds((right - 15) - this.BC.Cf.getIntrinsicWidth(), (bottom - 15) - this.BC.Cf.getIntrinsicHeight(), right - 15, bottom - 15);
                this.BC.Cf.draw(canvas);
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
        this.BC = eVar;
    }

    public Matrix iz() {
        return this.Bw;
    }

    public void b(Matrix matrix) {
        this.Bw = matrix;
    }

    public RectF iA() {
        return this.Bx;
    }

    private void iB() {
        this.mPaint.setAlpha((int) (255.0f * this.BC.mAlpha));
        if (this.BC.Cc) {
            this.mPaint.setColorFilter(Bt);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.Bu.setColor(this.BC.Cb);
        this.Bu.setStrokeWidth(this.BC.Ca);
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
        return Bs[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.BD);
        this.BE.set((int) ((this.BD[0] * f) + (this.BD[1] * f2) + this.BD[2]), (int) ((this.BD[3] * f) + (this.BD[4] * f2) + this.BD[5]));
        return this.BE;
    }
}
