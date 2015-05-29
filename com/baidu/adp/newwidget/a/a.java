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
    private static final Matrix.ScaleToFit[] Bg = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter Bh = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint Bi = new Paint();
    protected Paint Bj = new Paint();
    protected Matrix Bk = new Matrix();
    protected RectF Bl = new RectF();
    protected RectF Bm = new RectF();
    private RectF Bn = new RectF();
    private RectF Bo = new RectF();
    protected e Bp = new e();
    private float[] Bq = new float[9];
    private PointF Br = new PointF();
    protected RectF Bs = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.Bi.setStyle(Paint.Style.STROKE);
        this.Bi.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.Bj.setAntiAlias(true);
        this.Bj.setStyle(Paint.Style.FILL);
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
                this.Bl.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.Bk.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.Bl.set(0.0f, 0.0f, width2, height2);
            } else {
                this.Bl.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.Bk.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.Bk.setScale(f, f);
                    this.Bk.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.Bk.setScale(min, min);
                    this.Bk.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.Bn.set(0.0f, 0.0f, width, height);
                    this.Bo.set(0.0f, 0.0f, width2, height2);
                    this.Bk.setRectToRect(this.Bn, this.Bo, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        km();
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
        if (this.Bp.BW != null) {
            canvas.concat(this.Bp.BW);
        }
        b(canvas, dVar, imageView);
        canvas.restoreToCount(save2);
        if (this.Bp.BU && this.Bp.BV != null && dVar.fN()) {
            if (!this.Bp.BY) {
                this.Bp.BV.setBounds(0, 0, this.Bp.BV.getIntrinsicWidth(), this.Bp.BV.getIntrinsicHeight());
                this.Bp.BV.draw(canvas);
            } else {
                this.Bp.BV.setBounds((right - 15) - this.Bp.BV.getIntrinsicWidth(), (bottom - 15) - this.Bp.BV.getIntrinsicHeight(), right - 15, bottom - 15);
                this.Bp.BV.draw(canvas);
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
        this.Bp = eVar;
    }

    public Matrix kk() {
        return this.Bk;
    }

    public void a(Matrix matrix) {
        this.Bk = matrix;
    }

    public RectF kl() {
        return this.Bl;
    }

    private void km() {
        this.mPaint.setAlpha((int) (255.0f * this.Bp.mAlpha));
        if (this.Bp.BS) {
            this.mPaint.setColorFilter(Bh);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.Bi.setColor(this.Bp.BR);
        this.Bi.setStrokeWidth(this.Bp.BQ);
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
        return Bg[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.Bq);
        this.Br.set((int) ((this.Bq[0] * f) + (this.Bq[1] * f2) + this.Bq[2]), (int) ((this.Bq[3] * f) + (this.Bq[4] * f2) + this.Bq[5]));
        return this.Br;
    }
}
