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
    public static final Object vy = new Object();
    private Bitmap iI;
    public long timeStamp;
    private String url;
    public c vA;
    private volatile boolean vq;
    private boolean vr;
    private byte[] vs;
    private int vt;
    private int vu;
    private AtomicBoolean vv;
    private com.baidu.adp.gif.c vw;
    private boolean vx;
    public Rect vz;

    public a(Bitmap bitmap, boolean z) {
        this.iI = null;
        this.vq = false;
        this.vr = true;
        this.vs = null;
        this.vt = -1;
        this.vu = -1;
        this.vv = new AtomicBoolean(false);
        this.vx = false;
        this.timeStamp = -1L;
        this.vA = new c();
        this.iI = bitmap;
        this.vq = z;
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.iI = null;
        this.vq = false;
        this.vr = true;
        this.vs = null;
        this.vt = -1;
        this.vu = -1;
        this.vv = new AtomicBoolean(false);
        this.vx = false;
        this.timeStamp = -1L;
        this.vA = new c();
        this.iI = bitmap;
        this.vq = z;
        this.url = str;
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.iI = null;
        this.vq = false;
        this.vr = true;
        this.vs = null;
        this.vt = -1;
        this.vu = -1;
        this.vv = new AtomicBoolean(false);
        this.vx = false;
        this.timeStamp = -1L;
        this.vA = new c();
        this.iI = bitmap;
        this.vq = z;
        this.url = str;
        this.vz = rect;
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.iI = null;
        this.vq = false;
        this.vr = true;
        this.vs = null;
        this.vt = -1;
        this.vu = -1;
        this.vv = new AtomicBoolean(false);
        this.vx = false;
        this.timeStamp = -1L;
        this.vA = new c();
        this.iI = bitmap;
        this.vq = z;
        this.url = str;
        this.vs = bArr;
    }

    public a(com.baidu.adp.gif.c cVar) {
        this.iI = null;
        this.vq = false;
        this.vr = true;
        this.vs = null;
        this.vt = -1;
        this.vu = -1;
        this.vv = new AtomicBoolean(false);
        this.vx = false;
        this.timeStamp = -1L;
        this.vA = new c();
        this.vw = cVar;
        this.vx = true;
    }

    public boolean jh() {
        return this.vx;
    }

    public com.baidu.adp.gif.c getGif() {
        return this.vw;
    }

    public int getWidth() {
        if (this.iI == null) {
            return 0;
        }
        return this.iI.getWidth();
    }

    public int getHeight() {
        if (this.iI == null) {
            return 0;
        }
        return this.iI.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.iI != null) {
            this.vv.set(true);
            canvas.drawBitmap(this.iI, matrix, paint);
            this.vv.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.iI != null) {
            this.vv.set(true);
            canvas.drawBitmap(this.iI, f, f2, paint);
            this.vv.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.iI != null) {
            this.vv.set(true);
            canvas.drawBitmap(this.iI, rect, rectF, paint);
            this.vv.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.iI != null) {
            this.vr = false;
            imageView.setImageBitmap(this.iI);
        }
    }

    public boolean ck() {
        return this.vq;
    }

    public int size() {
        if (this.iI == null) {
            return 0;
        }
        return this.iI.getHeight() * this.iI.getRowBytes();
    }

    public boolean ji() {
        if (this.vr && !this.vv.get()) {
            if (this.iI != null) {
                Bitmap bitmap = this.iI;
                this.iI = null;
                bitmap.recycle();
            }
            if (this.vw != null) {
                com.baidu.adp.gif.c cVar = this.vw;
                this.vw = null;
                cVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap jj() {
        this.vr = false;
        return this.iI;
    }

    public boolean jk() {
        return this.iI != null;
    }

    public BitmapDrawable jl() {
        if (this.iI == null) {
            return null;
        }
        this.vr = false;
        return new b(this, this.iI);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] jm() {
        byte[] byteArray;
        if (this.iI == null) {
            return null;
        }
        synchronized (vy) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.iI.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect jn() {
        return this.vz;
    }

    public byte[] jo() {
        return this.vs;
    }

    public BitmapShader jp() {
        if (this.iI == null) {
            return null;
        }
        this.vr = false;
        return new BitmapShader(this.iI, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void P(boolean z) {
        this.vv.set(z);
    }
}
