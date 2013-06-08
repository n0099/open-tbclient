package com.baidu.adp.widget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class b {
    private String a;
    private Bitmap b;
    private boolean c;
    private boolean d = true;
    private AtomicBoolean e = new AtomicBoolean(false);

    public b(Bitmap bitmap, boolean z) {
        this.b = null;
        this.c = false;
        this.b = bitmap;
        this.c = z;
    }

    public b(Bitmap bitmap, boolean z, String str) {
        this.b = null;
        this.c = false;
        this.b = bitmap;
        this.c = z;
        this.a = str;
    }

    public int a() {
        if (this.b == null) {
            return 0;
        }
        return this.b.getWidth();
    }

    public int b() {
        if (this.b == null) {
            return 0;
        }
        return this.b.getHeight();
    }

    public void a(ImageView imageView) {
        if (this.b != null) {
            this.d = true;
            imageView.setBackgroundDrawable(new BitmapDrawable(this.b));
        }
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.b != null) {
            this.e.set(true);
            canvas.drawBitmap(this.b, matrix, paint);
            this.e.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.b != null) {
            this.e.set(true);
            canvas.drawBitmap(this.b, f, f2, paint);
            this.e.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, Rect rect2, Paint paint) {
        if (this.b != null) {
            this.e.set(true);
            canvas.drawBitmap(this.b, rect, rect2, paint);
            this.e.set(false);
        }
    }

    public void b(ImageView imageView) {
        if (imageView != null && this.b != null) {
            this.d = true;
            imageView.setImageBitmap(this.b);
        }
    }

    public boolean c() {
        return this.c;
    }

    public int d() {
        if (this.b == null) {
            return 0;
        }
        return this.b.getHeight() * this.b.getWidth() * 2;
    }

    public boolean e() {
        if (this.d || this.e.get()) {
            return false;
        }
        if (this.b != null) {
            Bitmap bitmap = this.b;
            this.b = null;
            bitmap.recycle();
        }
        return true;
    }

    public Bitmap f() {
        this.d = true;
        return this.b;
    }

    public boolean g() {
        return this.b != null;
    }

    public BitmapDrawable h() {
        if (this.b == null) {
            return null;
        }
        this.d = true;
        return new c(this, this.b);
    }

    public String i() {
        return this.a;
    }
}
