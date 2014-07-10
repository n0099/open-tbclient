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
    private static final Matrix.ScaleToFit[] i = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private static final PorterDuffColorFilter j = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    protected Paint a = new Paint(6);
    protected Paint b = new Paint();
    protected Paint c = new Paint();
    protected Matrix d = new Matrix();
    protected RectF e = new RectF();
    protected RectF f = new RectF();
    private RectF k = new RectF();
    private RectF l = new RectF();
    protected e g = new e();
    private float[] m = new float[9];
    private PointF n = new PointF();
    protected RectF h = new RectF();

    public abstract void a(d dVar, ImageView imageView);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(Canvas canvas, ImageView imageView);

    public abstract void b(Canvas canvas, d dVar, ImageView imageView);

    public abstract void c(Canvas canvas, ImageView imageView);

    public a() {
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setAntiAlias(true);
        this.a.setAntiAlias(true);
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.FILL);
    }

    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        float min;
        float f;
        float f2;
        float f3 = 0.0f;
        if (imageView.getWidth() != 0 && imageView.getHeight() != 0) {
            int d = dVar.d();
            int e = dVar.e();
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            if (scaleType == ImageView.ScaleType.MATRIX) {
                this.e.set(0.0f, 0.0f, d, e);
                a(dVar, imageView);
                return;
            }
            boolean z = (d <= 0 || width == d) && (e <= 0 || height == e);
            this.d.reset();
            if (ImageView.ScaleType.FIT_XY == scaleType || z) {
                this.e.set(0.0f, 0.0f, width, height);
            } else {
                this.e.set(0.0f, 0.0f, d, e);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.d.setTranslate((width - d) * 0.5f, (height - e) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (d * height > width * e) {
                        f = height / e;
                        f3 = (width - (d * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width / d;
                        f2 = (height - (e * f)) * 0.5f;
                    }
                    this.d.setScale(f, f);
                    this.d.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (d <= width && e <= height) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width / d, height / e);
                    }
                    this.d.setScale(min, min);
                    this.d.postTranslate((width - (d * min)) * 0.5f, (height - (e * min)) * 0.5f);
                } else {
                    this.k.set(0.0f, 0.0f, d, e);
                    this.l.set(0.0f, 0.0f, width, height);
                    this.d.setRectToRect(this.k, this.l, a(scaleType));
                }
            }
            a(dVar, imageView);
        }
    }

    public void a(Canvas canvas, d dVar, ImageView imageView) {
        c();
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
        if (this.g.k != null) {
            canvas.concat(this.g.k);
        }
        b(canvas, dVar, imageView);
        canvas.restoreToCount(save2);
        if (this.g.h && this.g.i != null && dVar.g()) {
            this.g.i.setBounds(0, 0, this.g.i.getIntrinsicWidth(), this.g.i.getIntrinsicHeight());
            this.g.i.draw(canvas);
        }
        c(canvas, imageView);
        canvas.restoreToCount(save);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Canvas canvas, ImageView imageView) {
        Drawable background = imageView.getBackground();
        if (background != null) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            background.setBounds(0, 0, imageView.getWidth(), imageView.getHeight());
            if ((scrollX | scrollY) == 0) {
                background.draw(canvas);
                return;
            }
            canvas.translate(scrollX, scrollY);
            background.draw(canvas);
            canvas.translate(-scrollX, -scrollY);
        }
    }

    public void a(e eVar) {
        this.g = eVar;
    }

    public Matrix a() {
        return this.d;
    }

    public void a(Matrix matrix) {
        this.d = matrix;
    }

    public RectF b() {
        return this.e;
    }

    private void c() {
        this.a.setAlpha((int) (255.0f * this.g.j));
        if (this.g.f) {
            this.a.setColorFilter(j);
        } else {
            this.a.setColorFilter(null);
        }
        this.b.setColor(this.g.e);
        this.b.setStrokeWidth(this.g.d);
    }

    private static Matrix.ScaleToFit a(ImageView.ScaleType scaleType) {
        int i2 = 1;
        if (scaleType != ImageView.ScaleType.FIT_XY) {
            if (scaleType == ImageView.ScaleType.FIT_START) {
                i2 = 2;
            } else if (scaleType == ImageView.ScaleType.FIT_CENTER) {
                i2 = 3;
            } else if (scaleType == ImageView.ScaleType.FIT_END) {
                i2 = 4;
            }
        }
        return i[i2 - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF a(float f, float f2, Matrix matrix) {
        matrix.getValues(this.m);
        this.n.set((int) ((this.m[0] * f) + (this.m[1] * f2) + this.m[2]), (int) ((this.m[3] * f) + (this.m[4] * f2) + this.m[5]));
        return this.n;
    }
}
