package com.baidu.adp.newwidget.ImageView;

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
    private static final Matrix.ScaleToFit[] GD = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter GE = new PorterDuffColorFilter(1409286144, PorterDuff.Mode.SRC_ATOP);
    private InterfaceC0020a GC;
    public Paint mPaint = new Paint(6);
    public Paint GF = new Paint();
    protected Paint GG = new Paint();
    protected Matrix GH = new Matrix();
    protected RectF GI = new RectF();
    protected RectF GJ = new RectF();
    private RectF GK = new RectF();
    private RectF GL = new RectF();
    private RectF GM = new RectF();
    protected d mArgs = new d();
    private float[] mValues = new float[9];
    private PointF GN = new PointF();
    protected RectF GO = new RectF();

    /* renamed from: com.baidu.adp.newwidget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0020a {
        boolean b(Canvas canvas, Drawable drawable);
    }

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(c cVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, c cVar, ImageView imageView);

    public a() {
        this.GF.setStyle(Paint.Style.STROKE);
        this.GF.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.GG.setAntiAlias(true);
        this.GG.setStyle(Paint.Style.FILL);
    }

    public void a(InterfaceC0020a interfaceC0020a) {
        this.GC = interfaceC0020a;
    }

    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        float min;
        float f;
        float f2;
        float f3 = 0.0f;
        if (imageView.getWidth() != 0 && imageView.getHeight() != 0) {
            int width = cVar.getWidth();
            int height = cVar.getHeight();
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height2 = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            if (scaleType == ImageView.ScaleType.MATRIX) {
                this.GI.set(0.0f, 0.0f, width, height);
                a(cVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.GH.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.GI.set(0.0f, 0.0f, width2, height2);
            } else {
                this.GI.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.GH.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.GH.setScale(f, f);
                    this.GH.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.GH.setScale(min, min);
                    this.GH.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.GK.set(0.0f, 0.0f, width, height);
                    this.GL.set(0.0f, 0.0f, width2, height2);
                    this.GH.setRectToRect(this.GK, this.GL, a(scaleType));
                }
            }
            a(cVar, imageView);
        }
    }

    public void a(Canvas canvas, c cVar, ImageView imageView) {
        lw();
        int save = canvas.save();
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        int paddingLeft = imageView.getPaddingLeft();
        int paddingRight = imageView.getPaddingRight();
        int paddingTop = imageView.getPaddingTop();
        int paddingBottom = imageView.getPaddingBottom();
        canvas.clipRect(scrollX + paddingLeft, scrollY + paddingTop, ((scrollX + imageView.getRight()) - imageView.getLeft()) - paddingRight, ((scrollY + imageView.getBottom()) - imageView.getTop()) - paddingBottom);
        canvas.translate(paddingLeft, paddingTop);
        int save2 = canvas.save();
        if (this.mArgs.Hb != null) {
            canvas.concat(this.mArgs.Hb);
        }
        if (cVar.GR != null && cVar.GR.nR()) {
            if ((cVar.GR.nK().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || cVar.GR.nK().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.GH != null) {
                canvas.concat(this.GH);
            }
            this.GM.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            cVar.GR.a(canvas, this.GM);
        } else {
            b(canvas, cVar, imageView);
        }
        canvas.restoreToCount(save2);
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
        if (this.GC == null || !this.GC.b(canvas, drawable)) {
            drawable.draw(canvas);
        }
    }

    public void a(d dVar) {
        this.mArgs = dVar;
    }

    public Matrix lu() {
        return this.GH;
    }

    public void d(Matrix matrix) {
        this.GH = matrix;
    }

    public RectF lv() {
        return this.GI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lw() {
        this.mPaint.setAlpha((int) (255.0f * this.mArgs.Ha));
        if (this.mArgs.mIsNight) {
            this.mPaint.setColorFilter(GE);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.GF.setColor(this.mArgs.GW);
        this.GF.setStrokeWidth(this.mArgs.mBorderWidth);
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
        return GD[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.mValues);
        this.GN.set((int) ((this.mValues[0] * f) + (this.mValues[1] * f2) + this.mValues[2]), (int) ((this.mValues[3] * f) + (this.mValues[4] * f2) + this.mValues[5]));
        return this.GN;
    }
}
