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
    private static final Matrix.ScaleToFit[] uD = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter uE = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint uF = new Paint();
    protected Paint uG = new Paint();
    protected Matrix uH = new Matrix();
    protected RectF uI = new RectF();
    protected RectF uJ = new RectF();
    private RectF uK = new RectF();
    private RectF uL = new RectF();
    private RectF uM = new RectF();
    protected e uN = new e();
    private float[] uO = new float[9];
    private PointF uP = new PointF();
    protected RectF uQ = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.uF.setStyle(Paint.Style.STROKE);
        this.uF.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.uG.setAntiAlias(true);
        this.uG.setStyle(Paint.Style.FILL);
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
                this.uI.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.uH.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.uI.set(0.0f, 0.0f, width2, height2);
            } else {
                this.uI.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.uH.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.uH.setScale(f, f);
                    this.uH.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.uH.setScale(min, min);
                    this.uH.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.uK.set(0.0f, 0.0f, width, height);
                    this.uL.set(0.0f, 0.0f, width2, height2);
                    this.uH.setRectToRect(this.uK, this.uL, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        hD();
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
        if (this.uN.vr != null) {
            canvas.concat(this.uN.vr);
        }
        if (dVar.vi != null && dVar.vi.ka()) {
            if ((dVar.vi.jT().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.vi.jT().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.uH != null) {
                canvas.concat(this.uH);
            }
            this.uM.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.vi.a(canvas, this.uM);
        } else {
            b(canvas, dVar, imageView);
        }
        canvas.restoreToCount(save2);
        if (this.uN.vp && this.uN.vq != null && dVar.cW()) {
            if (!this.uN.vt) {
                this.uN.vq.setBounds(0, 0, this.uN.vq.getIntrinsicWidth(), this.uN.vq.getIntrinsicHeight());
                this.uN.vq.draw(canvas);
            } else {
                this.uN.vq.setBounds((right - 15) - this.uN.vq.getIntrinsicWidth(), (bottom - 15) - this.uN.vq.getIntrinsicHeight(), right - 15, bottom - 15);
                this.uN.vq.draw(canvas);
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
        this.uN = eVar;
    }

    public Matrix hB() {
        return this.uH;
    }

    public void b(Matrix matrix) {
        this.uH = matrix;
    }

    public RectF hC() {
        return this.uI;
    }

    private void hD() {
        this.mPaint.setAlpha((int) (255.0f * this.uN.mAlpha));
        if (this.uN.vn) {
            this.mPaint.setColorFilter(uE);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.uF.setColor(this.uN.vm);
        this.uF.setStrokeWidth(this.uN.vl);
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
        return uD[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.uO);
        this.uP.set((int) ((this.uO[0] * f) + (this.uO[1] * f2) + this.uO[2]), (int) ((this.uO[3] * f) + (this.uO[4] * f2) + this.uO[5]));
        return this.uP;
    }
}
