package com.baidu.adp.widget.a;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.baidu.adp.gif.c;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static final Object a = new Object();
    public long b;
    public Rect c;
    private String d;
    private Bitmap e;
    private volatile boolean f;
    private boolean g;
    private int h;
    private int i;
    private AtomicBoolean j;
    private c k;
    private boolean l;

    public a(Bitmap bitmap, boolean z) {
        this.e = null;
        this.f = false;
        this.g = true;
        this.h = -1;
        this.i = -1;
        this.j = new AtomicBoolean(false);
        this.l = false;
        this.b = -1L;
        this.e = bitmap;
        this.f = z;
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.e = null;
        this.f = false;
        this.g = true;
        this.h = -1;
        this.i = -1;
        this.j = new AtomicBoolean(false);
        this.l = false;
        this.b = -1L;
        this.e = bitmap;
        this.f = z;
        this.d = str;
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.e = null;
        this.f = false;
        this.g = true;
        this.h = -1;
        this.i = -1;
        this.j = new AtomicBoolean(false);
        this.l = false;
        this.b = -1L;
        this.e = bitmap;
        this.f = z;
        this.d = str;
        this.c = rect;
    }

    public a(c cVar) {
        this.e = null;
        this.f = false;
        this.g = true;
        this.h = -1;
        this.i = -1;
        this.j = new AtomicBoolean(false);
        this.l = false;
        this.b = -1L;
        this.k = cVar;
        this.l = true;
    }

    public boolean a() {
        return this.l;
    }

    public c b() {
        return this.k;
    }

    public int c() {
        if (this.e == null) {
            return 0;
        }
        return this.e.getWidth();
    }

    public int d() {
        if (this.e == null) {
            return 0;
        }
        return this.e.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.e != null) {
            this.j.set(true);
            canvas.drawBitmap(this.e, matrix, paint);
            this.j.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.e != null) {
            this.j.set(true);
            canvas.drawBitmap(this.e, f, f2, paint);
            this.j.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.e != null) {
            this.j.set(true);
            canvas.drawBitmap(this.e, rect, rectF, paint);
            this.j.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.e != null) {
            this.g = true;
            imageView.setImageBitmap(this.e);
        }
    }

    public boolean e() {
        return this.f;
    }

    public int f() {
        if (this.e == null) {
            return 0;
        }
        return this.e.getHeight() * this.e.getWidth() * 2;
    }

    public boolean g() {
        if (this.g || this.j.get()) {
            return false;
        }
        if (this.e != null) {
            Bitmap bitmap = this.e;
            this.e = null;
            bitmap.recycle();
        }
        if (this.k != null) {
            c cVar = this.k;
            this.k = null;
            cVar.a();
        }
        return true;
    }

    public Bitmap h() {
        this.g = true;
        return this.e;
    }

    public boolean i() {
        return this.e != null;
    }

    public BitmapDrawable j() {
        if (this.e == null) {
            return null;
        }
        this.g = true;
        return new b(this, this.e);
    }

    public String k() {
        return this.d;
    }

    public byte[] l() {
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

    public Rect m() {
        return this.c;
    }

    public BitmapShader n() {
        if (this.e == null) {
            return null;
        }
        return new BitmapShader(this.e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void a(boolean z) {
        this.j.set(z);
    }
}
