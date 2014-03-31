package com.baidu.adp.widget.ImageView;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.widget.ImageView;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.widget.q;
import com.baidu.adp.widget.r;
import com.baidu.adp.widget.s;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class b {
    public static final Object a = new Object();
    public long b;
    public Rect c;
    private String d;
    private Bitmap e;
    private boolean f;
    private boolean g;
    private q h;
    private int i;
    private Paint j;
    private RectF k;
    private int l;
    private int m;
    private int n;
    private AtomicBoolean o;
    private com.baidu.adp.gif.c p;
    private boolean q;

    public b(Bitmap bitmap, boolean z) {
        this.e = null;
        this.f = false;
        this.g = true;
        this.m = -1;
        this.n = -1;
        this.o = new AtomicBoolean(false);
        this.q = false;
        this.b = -1L;
        this.e = bitmap;
        this.f = z;
    }

    public b(Bitmap bitmap, boolean z, String str) {
        this.e = null;
        this.f = false;
        this.g = true;
        this.m = -1;
        this.n = -1;
        this.o = new AtomicBoolean(false);
        this.q = false;
        this.b = -1L;
        this.e = bitmap;
        this.f = z;
        this.d = str;
    }

    public b(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.e = null;
        this.f = false;
        this.g = true;
        this.m = -1;
        this.n = -1;
        this.o = new AtomicBoolean(false);
        this.q = false;
        this.b = -1L;
        this.e = bitmap;
        this.f = false;
        this.d = str;
        this.c = rect;
    }

    public b(com.baidu.adp.gif.c cVar) {
        this.e = null;
        this.f = false;
        this.g = true;
        this.m = -1;
        this.n = -1;
        this.o = new AtomicBoolean(false);
        this.q = false;
        this.b = -1L;
        this.p = cVar;
        this.q = true;
    }

    public final boolean a() {
        return this.q;
    }

    public final com.baidu.adp.gif.c b() {
        return this.p;
    }

    public final int c() {
        if (this.e == null) {
            return 0;
        }
        return this.e.getWidth();
    }

    public final int d() {
        if (this.e == null) {
            return 0;
        }
        return this.e.getHeight();
    }

    public final void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.e != null) {
            this.o.set(true);
            canvas.drawBitmap(this.e, matrix, paint);
            this.o.set(false);
        }
    }

    public final void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.e != null) {
            this.o.set(true);
            canvas.drawBitmap(this.e, 0.0f, 0.0f, paint);
            this.o.set(false);
        }
    }

    public final void a(Canvas canvas, Matrix matrix, Resources resources, ImageView imageView, int i, ColorFilter colorFilter) {
        if (this.e != null) {
            if (this.m != imageView.getMeasuredWidth() || this.n != imageView.getMeasuredHeight()) {
                this.h = null;
                this.m = imageView.getMeasuredWidth();
                this.n = imageView.getMeasuredHeight();
            }
            this.o.set(true);
            if (this.h == null || this.i != i) {
                this.i = i;
                if (Build.VERSION.SDK_INT < 11 && imageView.getMeasuredWidth() > i.a(imageView.getContext(), 100.0f)) {
                    this.h = new r(resources, imageView, this.e, this.i, colorFilter);
                } else {
                    this.h = new s(resources, matrix, imageView, this.e, this.i, colorFilter);
                }
                this.h.setBounds(0, 0, imageView.getMeasuredWidth(), imageView.getMeasuredHeight());
                this.k = new RectF();
                this.l = (int) ((resources.getDisplayMetrics().density * 1.0f) + 0.5d);
                int i2 = this.l >> 1;
                this.k.set(i2, i2, imageView.getMeasuredWidth() - i2, imageView.getMeasuredHeight() - i2);
                this.j = new Paint();
                this.j.setStyle(Paint.Style.STROKE);
                this.j.setAntiAlias(true);
                this.j.setColor(637534208);
                this.j.setStrokeWidth(this.l);
                if (colorFilter != null) {
                    this.j.setColorFilter(colorFilter);
                }
            } else {
                this.h.a(colorFilter);
                this.j.setColorFilter(colorFilter);
            }
            this.h.draw(canvas);
            canvas.drawRoundRect(this.k, this.i, this.i, this.j);
            this.o.set(false);
        }
    }

    public final void a(ImageView imageView) {
        if (imageView != null && this.e != null) {
            this.g = true;
            imageView.setImageBitmap(this.e);
        }
    }

    public final boolean e() {
        return this.f;
    }

    public final int f() {
        if (this.e == null) {
            return 0;
        }
        return this.e.getHeight() * this.e.getWidth() * 2;
    }

    public final boolean g() {
        if (this.g || this.o.get()) {
            return false;
        }
        if (this.e != null) {
            Bitmap bitmap = this.e;
            this.e = null;
            bitmap.recycle();
        }
        if (this.p != null) {
            com.baidu.adp.gif.c cVar = this.p;
            this.p = null;
            cVar.a();
        }
        return true;
    }

    public final Bitmap h() {
        this.g = true;
        return this.e;
    }

    public final BitmapDrawable i() {
        if (this.e == null) {
            return null;
        }
        this.g = true;
        return new c(this, this.e);
    }

    public final String j() {
        return this.d;
    }

    public final byte[] k() {
        byte[] byteArray;
        if (this.e == null) {
            return null;
        }
        synchronized (a) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.e.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public final Rect l() {
        return this.c;
    }
}
