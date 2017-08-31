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
    private static final Matrix.ScaleToFit[] AQ = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter AR = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint AS = new Paint();
    protected Paint AT = new Paint();
    protected Matrix AU = new Matrix();
    protected RectF AV = new RectF();
    protected RectF AW = new RectF();
    private RectF AX = new RectF();
    private RectF AY = new RectF();
    private RectF AZ = new RectF();
    protected e Ba = new e();
    private float[] Bb = new float[9];
    private PointF Bc = new PointF();
    protected RectF Bd = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.AS.setStyle(Paint.Style.STROKE);
        this.AS.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.AT.setAntiAlias(true);
        this.AT.setStyle(Paint.Style.FILL);
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
                this.AV.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.AU.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.AV.set(0.0f, 0.0f, width2, height2);
            } else {
                this.AV.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.AU.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.AU.setScale(f, f);
                    this.AU.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.AU.setScale(min, min);
                    this.AU.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.AX.set(0.0f, 0.0f, width, height);
                    this.AY.set(0.0f, 0.0f, width2, height2);
                    this.AU.setRectToRect(this.AX, this.AY, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        iA();
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
        if (this.Ba.BE != null) {
            canvas.concat(this.Ba.BE);
        }
        if (dVar.Bv != null && dVar.Bv.kV()) {
            if ((dVar.Bv.kO().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.Bv.kO().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.AU != null) {
                canvas.concat(this.AU);
            }
            this.AZ.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.Bv.a(canvas, this.AZ);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.Ba.BC && this.Ba.BD != null && dVar.isGif()) {
            if (!this.Ba.BG) {
                this.Ba.BD.setBounds(0, 0, this.Ba.BD.getIntrinsicWidth(), this.Ba.BD.getIntrinsicHeight());
                this.Ba.BD.draw(canvas);
            } else {
                this.Ba.BD.setBounds((right - 15) - this.Ba.BD.getIntrinsicWidth(), (bottom - 15) - this.Ba.BD.getIntrinsicHeight(), right - 15, bottom - 15);
                this.Ba.BD.draw(canvas);
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
        this.Ba = eVar;
    }

    public Matrix iy() {
        return this.AU;
    }

    public void a(Matrix matrix) {
        this.AU = matrix;
    }

    public RectF iz() {
        return this.AV;
    }

    private void iA() {
        this.mPaint.setAlpha((int) (255.0f * this.Ba.mAlpha));
        if (this.Ba.BA) {
            this.mPaint.setColorFilter(AR);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.AS.setColor(this.Ba.Bz);
        this.AS.setStrokeWidth(this.Ba.By);
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
        return AQ[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.Bb);
        this.Bc.set((int) ((this.Bb[0] * f) + (this.Bb[1] * f2) + this.Bb[2]), (int) ((this.Bb[3] * f) + (this.Bb[4] * f2) + this.Bb[5]));
        return this.Bc;
    }
}
