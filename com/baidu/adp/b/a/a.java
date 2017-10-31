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
    private static final Matrix.ScaleToFit[] AT = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter AU = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint mPaint = new Paint(6);
    protected Paint AV = new Paint();
    protected Paint AW = new Paint();
    protected Matrix AX = new Matrix();
    protected RectF AY = new RectF();
    protected RectF AZ = new RectF();
    private RectF Ba = new RectF();
    private RectF Bb = new RectF();
    private RectF Bc = new RectF();
    protected e mArgs = new e();
    private float[] Bd = new float[9];
    private PointF Be = new PointF();
    protected RectF Bf = new RectF();

    public abstract void a(Canvas canvas, ImageView imageView);

    public abstract void a(d dVar, ImageView imageView);

    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public a() {
        this.AV.setStyle(Paint.Style.STROKE);
        this.AV.setAntiAlias(true);
        this.mPaint.setAntiAlias(true);
        this.AW.setAntiAlias(true);
        this.AW.setStyle(Paint.Style.FILL);
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
                this.AY.set(0.0f, 0.0f, width, height);
                a(dVar, imageView);
                return;
            }
            boolean z = (width <= 0 || width2 == width) && (height <= 0 || height2 == height);
            this.AX.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.AY.set(0.0f, 0.0f, width2, height2);
            } else {
                this.AY.set(0.0f, 0.0f, width, height);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.AX.setTranslate((width2 - width) * 0.5f, (height2 - height) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (width * height2 > width2 * height) {
                        f = height2 / height;
                        f3 = (width2 - (width * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width2 / width;
                        f2 = (height2 - (height * f)) * 0.5f;
                    }
                    this.AX.setScale(f, f);
                    this.AX.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (width <= width2 && height <= height2) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width2 / width, height2 / height);
                    }
                    this.AX.setScale(min, min);
                    this.AX.postTranslate((width2 - (width * min)) * 0.5f, (height2 - (height * min)) * 0.5f);
                } else {
                    this.Ba.set(0.0f, 0.0f, width, height);
                    this.Bb.set(0.0f, 0.0f, width2, height2);
                    this.AX.setRectToRect(this.Ba, this.Bb, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        iz();
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
        if (this.mArgs.Br != null) {
            canvas.concat(this.mArgs.Br);
        }
        if (dVar.Bi != null && dVar.Bi.kR()) {
            if ((dVar.Bi.kK().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.Bi.kK().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && this.AX != null) {
                canvas.concat(this.AX);
            }
            this.Bc.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.Bi.a(canvas, this.Bc);
        } else {
            b(canvas, dVar, imageView);
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
        drawable.draw(canvas);
    }

    public void a(e eVar) {
        this.mArgs = eVar;
    }

    public Matrix ix() {
        return this.AX;
    }

    public void a(Matrix matrix) {
        this.AX = matrix;
    }

    public RectF iy() {
        return this.AY;
    }

    private void iz() {
        this.mPaint.setAlpha((int) (255.0f * this.mArgs.mAlpha));
        if (this.mArgs.Bn) {
            this.mPaint.setColorFilter(AU);
        } else {
            this.mPaint.setColorFilter(null);
        }
        this.AV.setColor(this.mArgs.Bm);
        this.AV.setStrokeWidth(this.mArgs.Bl);
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
        return AT[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.Bd);
        this.Be.set((int) ((this.Bd[0] * f) + (this.Bd[1] * f2) + this.Bd[2]), (int) ((this.Bd[3] * f) + (this.Bd[4] * f2) + this.Bd[5]));
        return this.Be;
    }
}
