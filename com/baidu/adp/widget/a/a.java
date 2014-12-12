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
    public static final Object vs = new Object();
    private Bitmap iG;
    public long timeStamp;
    private String url;
    private volatile boolean vk;
    private boolean vl;
    private byte[] vm;
    private int vn;
    private int vo;
    private AtomicBoolean vp;
    private com.baidu.adp.gif.c vq;
    private boolean vr;
    public Rect vt;
    public c vu;

    public a(Bitmap bitmap, boolean z) {
        this.iG = null;
        this.vk = false;
        this.vl = true;
        this.vm = null;
        this.vn = -1;
        this.vo = -1;
        this.vp = new AtomicBoolean(false);
        this.vr = false;
        this.timeStamp = -1L;
        this.vu = new c();
        this.iG = bitmap;
        this.vk = z;
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.iG = null;
        this.vk = false;
        this.vl = true;
        this.vm = null;
        this.vn = -1;
        this.vo = -1;
        this.vp = new AtomicBoolean(false);
        this.vr = false;
        this.timeStamp = -1L;
        this.vu = new c();
        this.iG = bitmap;
        this.vk = z;
        this.url = str;
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.iG = null;
        this.vk = false;
        this.vl = true;
        this.vm = null;
        this.vn = -1;
        this.vo = -1;
        this.vp = new AtomicBoolean(false);
        this.vr = false;
        this.timeStamp = -1L;
        this.vu = new c();
        this.iG = bitmap;
        this.vk = z;
        this.url = str;
        this.vt = rect;
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.iG = null;
        this.vk = false;
        this.vl = true;
        this.vm = null;
        this.vn = -1;
        this.vo = -1;
        this.vp = new AtomicBoolean(false);
        this.vr = false;
        this.timeStamp = -1L;
        this.vu = new c();
        this.iG = bitmap;
        this.vk = z;
        this.url = str;
        this.vm = bArr;
    }

    public a(com.baidu.adp.gif.c cVar) {
        this.iG = null;
        this.vk = false;
        this.vl = true;
        this.vm = null;
        this.vn = -1;
        this.vo = -1;
        this.vp = new AtomicBoolean(false);
        this.vr = false;
        this.timeStamp = -1L;
        this.vu = new c();
        this.vq = cVar;
        this.vr = true;
    }

    public boolean jg() {
        return this.vr;
    }

    public com.baidu.adp.gif.c getGif() {
        return this.vq;
    }

    public int getWidth() {
        if (this.iG == null) {
            return 0;
        }
        return this.iG.getWidth();
    }

    public int getHeight() {
        if (this.iG == null) {
            return 0;
        }
        return this.iG.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.iG != null) {
            this.vp.set(true);
            canvas.drawBitmap(this.iG, matrix, paint);
            this.vp.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.iG != null) {
            this.vp.set(true);
            canvas.drawBitmap(this.iG, f, f2, paint);
            this.vp.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.iG != null) {
            this.vp.set(true);
            canvas.drawBitmap(this.iG, rect, rectF, paint);
            this.vp.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.iG != null) {
            this.vl = false;
            imageView.setImageBitmap(this.iG);
        }
    }

    public boolean cm() {
        return this.vk;
    }

    public int size() {
        if (this.iG == null) {
            return 0;
        }
        return this.iG.getHeight() * this.iG.getRowBytes();
    }

    public boolean jh() {
        if (this.vl && !this.vp.get()) {
            if (this.iG != null) {
                Bitmap bitmap = this.iG;
                this.iG = null;
                bitmap.recycle();
            }
            if (this.vq != null) {
                com.baidu.adp.gif.c cVar = this.vq;
                this.vq = null;
                cVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap ji() {
        this.vl = false;
        return this.iG;
    }

    public boolean jj() {
        return this.iG != null;
    }

    public BitmapDrawable jk() {
        if (this.iG == null) {
            return null;
        }
        this.vl = false;
        return new b(this, this.iG);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] jl() {
        byte[] byteArray;
        if (this.iG == null) {
            return null;
        }
        synchronized (vs) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.iG.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect jm() {
        return this.vt;
    }

    public byte[] jn() {
        return this.vm;
    }

    public BitmapShader jo() {
        if (this.iG == null) {
            return null;
        }
        this.vl = false;
        return new BitmapShader(this.iG, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void P(boolean z) {
        this.vp.set(z);
    }
}
