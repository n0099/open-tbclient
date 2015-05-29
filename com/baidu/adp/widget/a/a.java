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
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static final Object Gk = new Object();
    private Bitmap Gb;
    private volatile boolean Gc;
    private boolean Gd;
    private byte[] Ge;
    private int Gf;
    private int Gg;
    private AtomicBoolean Gh;
    private com.baidu.adp.gif.c Gi;
    private boolean Gj;
    public Rect Gl;
    public c Gm;
    public long timeStamp;
    private String url;

    public a(Bitmap bitmap, boolean z) {
        this.Gb = null;
        this.Gc = false;
        this.Gd = true;
        this.Ge = null;
        this.Gf = -1;
        this.Gg = -1;
        this.Gh = new AtomicBoolean(false);
        this.Gj = false;
        this.timeStamp = -1L;
        this.Gm = new c();
        this.Gb = bitmap;
        this.Gc = z;
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Gb = null;
        this.Gc = false;
        this.Gd = true;
        this.Ge = null;
        this.Gf = -1;
        this.Gg = -1;
        this.Gh = new AtomicBoolean(false);
        this.Gj = false;
        this.timeStamp = -1L;
        this.Gm = new c();
        this.Gb = bitmap;
        this.Gc = z;
        this.url = str;
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Gb = null;
        this.Gc = false;
        this.Gd = true;
        this.Ge = null;
        this.Gf = -1;
        this.Gg = -1;
        this.Gh = new AtomicBoolean(false);
        this.Gj = false;
        this.timeStamp = -1L;
        this.Gm = new c();
        this.Gb = bitmap;
        this.Gc = z;
        this.url = str;
        this.Gl = rect;
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Gb = null;
        this.Gc = false;
        this.Gd = true;
        this.Ge = null;
        this.Gf = -1;
        this.Gg = -1;
        this.Gh = new AtomicBoolean(false);
        this.Gj = false;
        this.timeStamp = -1L;
        this.Gm = new c();
        this.Gb = bitmap;
        this.Gc = z;
        this.url = str;
        this.Ge = bArr;
    }

    public a(com.baidu.adp.gif.c cVar) {
        this.Gb = null;
        this.Gc = false;
        this.Gd = true;
        this.Ge = null;
        this.Gf = -1;
        this.Gg = -1;
        this.Gh = new AtomicBoolean(false);
        this.Gj = false;
        this.timeStamp = -1L;
        this.Gm = new c();
        this.Gi = cVar;
        this.Gj = true;
    }

    public boolean mQ() {
        return this.Gj;
    }

    public com.baidu.adp.gif.c getGif() {
        return this.Gi;
    }

    public int getWidth() {
        if (this.Gb == null) {
            return 0;
        }
        return this.Gb.getWidth();
    }

    public int getHeight() {
        if (this.Gb == null) {
            return 0;
        }
        return this.Gb.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Gb != null) {
            this.Gh.set(true);
            canvas.drawBitmap(this.Gb, matrix, paint);
            this.Gh.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Gb != null) {
            this.Gh.set(true);
            canvas.drawBitmap(this.Gb, f, f2, paint);
            this.Gh.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Gb != null) {
            this.Gh.set(true);
            canvas.drawBitmap(this.Gb, rect, rectF, paint);
            this.Gh.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Gb != null) {
            this.Gd = false;
            imageView.setImageBitmap(this.Gb);
        }
    }

    public boolean fN() {
        return this.Gc;
    }

    public int size() {
        if (this.Gb == null) {
            return 0;
        }
        return this.Gb.getHeight() * this.Gb.getRowBytes();
    }

    public boolean mR() {
        if (this.Gd && !this.Gh.get()) {
            if (this.Gb != null) {
                Bitmap bitmap = this.Gb;
                this.Gb = null;
                bitmap.recycle();
            }
            if (this.Gi != null) {
                com.baidu.adp.gif.c cVar = this.Gi;
                this.Gi = null;
                cVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap mS() {
        this.Gd = false;
        return this.Gb;
    }

    public boolean mT() {
        return this.Gb != null;
    }

    public BitmapDrawable mU() {
        if (this.Gb == null) {
            return null;
        }
        this.Gd = false;
        return new b(this, this.Gb);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] mV() {
        byte[] byteArray;
        if (this.Gb == null) {
            return null;
        }
        synchronized (Gk) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Gb.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect mW() {
        return this.Gl;
    }

    public byte[] mX() {
        return this.Ge;
    }

    public BitmapShader mY() {
        if (this.Gb == null) {
            return null;
        }
        this.Gd = false;
        return new BitmapShader(this.Gb, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void P(boolean z) {
        this.Gh.set(z);
    }
}
