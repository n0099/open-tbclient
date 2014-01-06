package com.baidu.adp.widget.ImageView;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.widget.ImageView;
import com.baidu.adp.lib.h.g;
import com.baidu.adp.widget.v;
import com.baidu.adp.widget.w;
import com.baidu.adp.widget.x;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class d {
    public static final Object a = new Object();
    public long b;
    private String c;
    private Bitmap d;
    private boolean e;
    private boolean f;
    private v g;
    private int h;
    private Paint i;
    private RectF j;
    private int k;
    private int l;
    private int m;
    private AtomicBoolean n;
    private com.baidu.adp.gif.c o;
    private boolean p;

    public d(Bitmap bitmap, boolean z) {
        this.d = null;
        this.e = false;
        this.f = true;
        this.l = -1;
        this.m = -1;
        this.n = new AtomicBoolean(false);
        this.p = false;
        this.b = -1L;
        this.d = bitmap;
        this.e = z;
    }

    public d(Bitmap bitmap, boolean z, String str) {
        this.d = null;
        this.e = false;
        this.f = true;
        this.l = -1;
        this.m = -1;
        this.n = new AtomicBoolean(false);
        this.p = false;
        this.b = -1L;
        this.d = bitmap;
        this.e = z;
        this.c = str;
    }

    public d(com.baidu.adp.gif.c cVar) {
        this.d = null;
        this.e = false;
        this.f = true;
        this.l = -1;
        this.m = -1;
        this.n = new AtomicBoolean(false);
        this.p = false;
        this.b = -1L;
        this.o = cVar;
        this.p = true;
    }

    public boolean a() {
        return this.p;
    }

    public com.baidu.adp.gif.c b() {
        return this.o;
    }

    public int c() {
        if (this.d == null) {
            return 0;
        }
        return this.d.getWidth();
    }

    public int d() {
        if (this.d == null) {
            return 0;
        }
        return this.d.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.d != null) {
            this.n.set(true);
            canvas.drawBitmap(this.d, matrix, paint);
            this.n.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.d != null) {
            this.n.set(true);
            canvas.drawBitmap(this.d, f, f2, paint);
            this.n.set(false);
        }
    }

    public void a(Canvas canvas, Matrix matrix, Resources resources, ImageView imageView, int i, ColorFilter colorFilter) {
        if (this.d != null) {
            if (this.l != imageView.getMeasuredWidth() || this.m != imageView.getMeasuredHeight()) {
                this.g = null;
                this.l = imageView.getMeasuredWidth();
                this.m = imageView.getMeasuredHeight();
            }
            this.n.set(true);
            if (this.g == null || this.h != i) {
                this.h = i;
                if (Build.VERSION.SDK_INT < 11 && imageView.getMeasuredWidth() > g.a(imageView.getContext(), 100.0f)) {
                    this.g = new w(resources, matrix, imageView, this.d, this.h, colorFilter);
                } else {
                    this.g = new x(resources, matrix, imageView, this.d, this.h, colorFilter);
                }
                this.g.setBounds(0, 0, imageView.getMeasuredWidth(), imageView.getMeasuredHeight());
                this.j = new RectF();
                this.k = (int) ((resources.getDisplayMetrics().density * 1.0f) + 0.5d);
                int i2 = this.k >> 1;
                this.j.set(i2, i2, imageView.getMeasuredWidth() - i2, imageView.getMeasuredHeight() - i2);
                this.i = new Paint();
                this.i.setStyle(Paint.Style.STROKE);
                this.i.setAntiAlias(true);
                this.i.setColor(637534208);
                this.i.setStrokeWidth(this.k);
                if (colorFilter != null) {
                    this.i.setColorFilter(colorFilter);
                }
            } else {
                this.g.a(colorFilter);
                this.i.setColorFilter(colorFilter);
            }
            this.g.draw(canvas);
            canvas.drawRoundRect(this.j, this.h, this.h, this.i);
            this.n.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.d != null) {
            this.f = true;
            imageView.setImageBitmap(this.d);
        }
    }

    public boolean e() {
        return this.e;
    }

    public int f() {
        if (this.d == null) {
            return 0;
        }
        return this.d.getHeight() * this.d.getWidth() * 2;
    }

    public boolean g() {
        if (this.f || this.n.get()) {
            return false;
        }
        if (this.d != null) {
            Bitmap bitmap = this.d;
            this.d = null;
            bitmap.recycle();
        }
        if (this.o != null) {
            com.baidu.adp.gif.c cVar = this.o;
            this.o = null;
            cVar.a();
        }
        return true;
    }

    public Bitmap h() {
        this.f = true;
        return this.d;
    }

    public BitmapDrawable i() {
        if (this.d == null) {
            return null;
        }
        this.f = true;
        return new e(this, this.d);
    }

    public String j() {
        return this.c;
    }

    public byte[] k() {
        byte[] byteArray;
        if (this.d == null) {
            return null;
        }
        synchronized (a) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.d.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }
}
