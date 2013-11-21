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
import com.baidu.adp.widget.u;
import com.baidu.adp.widget.v;
import com.baidu.adp.widget.w;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f560a = new Object();
    private String b;
    private Bitmap c;
    private boolean d;
    private u f;
    private int g;
    private Paint h;
    private RectF i;
    private int j;
    private boolean e = true;
    private int k = -1;
    private int l = -1;
    private AtomicBoolean m = new AtomicBoolean(false);

    public e(Bitmap bitmap, boolean z) {
        this.c = null;
        this.d = false;
        this.c = bitmap;
        this.d = z;
    }

    public e(Bitmap bitmap, boolean z, String str) {
        this.c = null;
        this.d = false;
        this.c = bitmap;
        this.d = z;
        this.b = str;
    }

    public int a() {
        if (this.c == null) {
            return 0;
        }
        return this.c.getWidth();
    }

    public int b() {
        if (this.c == null) {
            return 0;
        }
        return this.c.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.c != null) {
            this.m.set(true);
            canvas.drawBitmap(this.c, matrix, paint);
            this.m.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.c != null) {
            this.m.set(true);
            canvas.drawBitmap(this.c, f, f2, paint);
            this.m.set(false);
        }
    }

    public void a(Canvas canvas, Matrix matrix, Resources resources, ImageView imageView, int i, ColorFilter colorFilter) {
        if (this.c != null) {
            if (this.k != imageView.getMeasuredWidth() || this.l != imageView.getMeasuredHeight()) {
                this.f = null;
                this.k = imageView.getMeasuredWidth();
                this.l = imageView.getMeasuredHeight();
            }
            this.m.set(true);
            if (this.f == null || this.g != i) {
                this.g = i;
                if (Build.VERSION.SDK_INT < 11 && imageView.getMeasuredWidth() > com.baidu.adp.lib.h.f.a(imageView.getContext(), 100.0f)) {
                    this.f = new v(resources, matrix, imageView, this.c, this.g, colorFilter);
                } else {
                    this.f = new w(resources, matrix, imageView, this.c, this.g, colorFilter);
                }
                this.f.setBounds(0, 0, imageView.getMeasuredWidth(), imageView.getMeasuredHeight());
                this.i = new RectF();
                this.j = (int) ((resources.getDisplayMetrics().density * 1.0f) + 0.5d);
                int i2 = this.j >> 1;
                this.i.set(i2, i2, imageView.getMeasuredWidth() - i2, imageView.getMeasuredHeight() - i2);
                this.h = new Paint();
                this.h.setStyle(Paint.Style.STROKE);
                this.h.setAntiAlias(true);
                this.h.setColor(637534208);
                this.h.setStrokeWidth(this.j);
                if (colorFilter != null) {
                    this.h.setColorFilter(colorFilter);
                }
            } else {
                this.f.a(colorFilter);
                this.h.setColorFilter(colorFilter);
            }
            this.f.draw(canvas);
            canvas.drawRoundRect(this.i, this.g, this.g, this.h);
            this.m.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.c != null) {
            this.e = true;
            imageView.setImageBitmap(this.c);
        }
    }

    public boolean c() {
        return this.d;
    }

    public int d() {
        if (this.c == null) {
            return 0;
        }
        return this.c.getHeight() * this.c.getWidth() * 2;
    }

    public boolean e() {
        if (this.e || this.m.get()) {
            return false;
        }
        if (this.c != null) {
            Bitmap bitmap = this.c;
            this.c = null;
            bitmap.recycle();
        }
        return true;
    }

    public Bitmap f() {
        this.e = true;
        return this.c;
    }

    public BitmapDrawable g() {
        if (this.c == null) {
            return null;
        }
        this.e = true;
        return new f(this, this.c);
    }

    public String h() {
        return this.b;
    }

    public byte[] i() {
        byte[] byteArray;
        if (this.c == null) {
            return null;
        }
        synchronized (f560a) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.c.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }
}
