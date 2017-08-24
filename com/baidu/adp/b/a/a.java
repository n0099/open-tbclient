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
    private static final Matrix.ScaleToFit[] CX = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter CY = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint CZ = new Paint();
    protected Paint Da = new Paint();
    protected Matrix Db = new Matrix();
    protected RectF Dc = new RectF();
    protected RectF Dd = new RectF();
    private RectF De = new RectF();
    private RectF Df = new RectF();
    private RectF Dg = new RectF();
    protected e Dh = new e();
    private float[] Di = new float[9];
    private PointF Dj = new PointF();
    protected RectF Dk = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.CZ.setStyle(Paint.Style.STROKE);
        this.CZ.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.Da.setAntiAlias(true);
        this.Da.setStyle(Paint.Style.FILL);
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
                this.Dc.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.Db.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.Dc.set(0.0f, 0.0f, width2, height2);
            } else {
                this.Dc.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.Db.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.Db.setScale(f, f);
                    this.Db.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.Db.setScale(min, min);
                    this.Db.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.De.set(0.0f, 0.0f, width, height);
                    this.Df.set(0.0f, 0.0f, width2, height2);
                    this.Db.setRectToRect(this.De, this.Df, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        iI();
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
        if (this.Dh.DK != null) {
            canvas.concat(this.Dh.DK);
        }
        if (dVar.DB != null && dVar.DB.ld()) {
            if ((dVar.DB.kW().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.DB.kW().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.Db != null) {
                canvas.concat(this.Db);
            }
            this.Dg.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.DB.a(canvas, this.Dg);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.Dh.DI && this.Dh.DJ != null && dVar.isGif()) {
            if (!this.Dh.DM) {
                this.Dh.DJ.setBounds(0, 0, this.Dh.DJ.getIntrinsicWidth(), this.Dh.DJ.getIntrinsicHeight());
                this.Dh.DJ.draw(canvas);
            } else {
                this.Dh.DJ.setBounds((right - 15) - this.Dh.DJ.getIntrinsicWidth(), (bottom - 15) - this.Dh.DJ.getIntrinsicHeight(), right - 15, bottom - 15);
                this.Dh.DJ.draw(canvas);
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
        this.Dh = eVar;
    }

    public Matrix iG() {
        return this.Db;
    }

    public void b(Matrix matrix) {
        this.Db = matrix;
    }

    public RectF iH() {
        return this.Dc;
    }

    private void iI() {
        this.mPaint.setAlpha((int) (255.0f * this.Dh.mAlpha));
        if (this.Dh.DG) {
            this.mPaint.setColorFilter(CY);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.CZ.setColor(this.Dh.DF);
        this.CZ.setStrokeWidth(this.Dh.DE);
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
        return CX[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.Di);
        this.Dj.set((int) ((this.Di[0] * f) + (this.Di[1] * f2) + this.Di[2]), (int) ((this.Di[3] * f) + (this.Di[4] * f2) + this.Di[5]));
        return this.Dj;
    }
}
