package com.baidu.adp.widget.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.baidu.adp.widget.p;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f503a;
    private Bitmap b;
    private boolean c;
    private p e;
    private int f;
    private Paint g;
    private RectF h;
    private int i;
    private boolean d = true;
    private AtomicBoolean j = new AtomicBoolean(false);

    public b(Bitmap bitmap, boolean z, String str) {
        this.b = null;
        this.c = false;
        this.b = bitmap;
        this.c = z;
        this.f503a = str;
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

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.b != null) {
            this.j.set(true);
            canvas.drawBitmap(this.b, matrix, paint);
            this.j.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.b != null) {
            this.j.set(true);
            canvas.drawBitmap(this.b, f, f2, paint);
            this.j.set(false);
        }
    }

    public void a(Canvas canvas, Matrix matrix, Resources resources, ImageView imageView, int i) {
        if (this.b != null) {
            this.j.set(true);
            if (this.e == null || this.f != i) {
                this.f = i;
                this.e = new p(resources, matrix, imageView, this.b, this.f);
                this.e.setBounds(0, 0, imageView.getMeasuredWidth(), imageView.getMeasuredHeight());
                this.h = new RectF();
                this.i = (int) ((resources.getDisplayMetrics().density * 1.0f) + 0.5d);
                int i2 = this.i >> 1;
                this.h.set(i2, i2, imageView.getMeasuredWidth() - i2, imageView.getMeasuredHeight() - i2);
                this.g = new Paint();
                this.g.setStyle(Paint.Style.STROKE);
                this.g.setAntiAlias(true);
                this.g.setColor(637534208);
                this.g.setStrokeWidth(this.i);
            }
            this.e.draw(canvas);
            canvas.drawRoundRect(this.h, this.f, this.f, this.g);
            this.j.set(false);
        }
    }

    public void a(ImageView imageView) {
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
        if (this.d || this.j.get()) {
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

    public BitmapDrawable g() {
        if (this.b == null) {
            return null;
        }
        this.d = true;
        return new c(this, this.b);
    }

    public String h() {
        return this.f503a;
    }
}
