package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.qg1;
/* loaded from: classes3.dex */
public class CircleImageView extends ImageView {
    public static final ImageView.ScaleType p = ImageView.ScaleType.CENTER_CROP;
    public static final Bitmap.Config q = Bitmap.Config.ARGB_8888;
    public static final int r = 1;
    public static final int s = 0;
    public static final int t = -16777216;
    public final RectF a;
    public final RectF b;
    public final Matrix c;
    public final Paint d;
    public final Paint e;
    public int f;
    public int g;
    public Bitmap h;
    public BitmapShader i;
    public int j;
    public int k;
    public float l;
    public float m;
    public boolean n;
    public boolean o;

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
    }

    private void a() {
        super.setScaleType(p);
        this.n = true;
        if (this.o) {
            b();
            this.o = false;
        }
    }

    public int getBorderColor() {
        return this.f;
    }

    public int getBorderWidth() {
        return this.g;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return p;
    }

    public CircleImageView(Context context) {
        super(context);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = -16777216;
        this.g = 0;
        a();
    }

    public void setBorderColor(int i) {
        if (i == this.f) {
            return;
        }
        this.f = i;
        this.e.setColor(i);
        invalidate();
    }

    public void setBorderWidth(int i) {
        if (i == this.g) {
            return;
        }
        this.g = i;
        b();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.h = bitmap;
        b();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.h = a(drawable);
        b();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        this.h = a(getDrawable());
        b();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.h = a(getDrawable());
        b();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = -16777216;
        this.g = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, qg1.sapi_sdk_circle_image_view, i, 0);
        this.g = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f = obtainStyledAttributes.getColor(0, -16777216);
        obtainStyledAttributes.recycle();
        a();
    }

    private Bitmap a(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(1, 1, q);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), q);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.l, this.d);
        if (this.g != 0) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.m, this.e);
        }
    }

    private void b() {
        if (!this.n) {
            this.o = true;
            return;
        }
        Bitmap bitmap = this.h;
        if (bitmap == null) {
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.i = new BitmapShader(bitmap, tileMode, tileMode);
        this.d.setAntiAlias(true);
        this.d.setShader(this.i);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setAntiAlias(true);
        this.e.setColor(this.f);
        this.e.setStrokeWidth(this.g);
        this.k = this.h.getHeight();
        this.j = this.h.getWidth();
        this.b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.m = Math.min((this.b.height() - this.g) / 2.0f, (this.b.width() - this.g) / 2.0f);
        RectF rectF = this.a;
        float f = this.g;
        rectF.set(f, f, this.b.width() - this.g, this.b.height() - this.g);
        this.l = Math.min(this.a.height() / 2.0f, this.a.width() / 2.0f);
        c();
        invalidate();
    }

    private void c() {
        float width;
        float height;
        this.c.set(null);
        float f = 0.0f;
        if (this.j * this.a.height() > this.a.width() * this.k) {
            width = this.a.height() / this.k;
            f = (this.a.width() - (this.j * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.a.width() / this.j;
            height = (this.a.height() - (this.k * width)) * 0.5f;
        }
        this.c.setScale(width, width);
        Matrix matrix = this.c;
        int i = this.g;
        matrix.postTranslate(((int) (f + 0.5f)) + i, ((int) (height + 0.5f)) + i);
        this.i.setLocalMatrix(this.c);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b();
    }
}
