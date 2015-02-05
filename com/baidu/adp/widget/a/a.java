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
    public static final Object vv = new Object();
    private Bitmap iI;
    public long timeStamp;
    private String url;
    private volatile boolean vn;
    private boolean vo;
    private byte[] vp;
    private int vq;
    private int vr;
    private AtomicBoolean vs;
    private com.baidu.adp.gif.c vt;
    private boolean vu;
    public Rect vw;
    public c vx;

    public a(Bitmap bitmap, boolean z) {
        this.iI = null;
        this.vn = false;
        this.vo = true;
        this.vp = null;
        this.vq = -1;
        this.vr = -1;
        this.vs = new AtomicBoolean(false);
        this.vu = false;
        this.timeStamp = -1L;
        this.vx = new c();
        this.iI = bitmap;
        this.vn = z;
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.iI = null;
        this.vn = false;
        this.vo = true;
        this.vp = null;
        this.vq = -1;
        this.vr = -1;
        this.vs = new AtomicBoolean(false);
        this.vu = false;
        this.timeStamp = -1L;
        this.vx = new c();
        this.iI = bitmap;
        this.vn = z;
        this.url = str;
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.iI = null;
        this.vn = false;
        this.vo = true;
        this.vp = null;
        this.vq = -1;
        this.vr = -1;
        this.vs = new AtomicBoolean(false);
        this.vu = false;
        this.timeStamp = -1L;
        this.vx = new c();
        this.iI = bitmap;
        this.vn = z;
        this.url = str;
        this.vw = rect;
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.iI = null;
        this.vn = false;
        this.vo = true;
        this.vp = null;
        this.vq = -1;
        this.vr = -1;
        this.vs = new AtomicBoolean(false);
        this.vu = false;
        this.timeStamp = -1L;
        this.vx = new c();
        this.iI = bitmap;
        this.vn = z;
        this.url = str;
        this.vp = bArr;
    }

    public a(com.baidu.adp.gif.c cVar) {
        this.iI = null;
        this.vn = false;
        this.vo = true;
        this.vp = null;
        this.vq = -1;
        this.vr = -1;
        this.vs = new AtomicBoolean(false);
        this.vu = false;
        this.timeStamp = -1L;
        this.vx = new c();
        this.vt = cVar;
        this.vu = true;
    }

    public boolean ja() {
        return this.vu;
    }

    public com.baidu.adp.gif.c getGif() {
        return this.vt;
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
            this.vs.set(true);
            canvas.drawBitmap(this.iI, matrix, paint);
            this.vs.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.iI != null) {
            this.vs.set(true);
            canvas.drawBitmap(this.iI, f, f2, paint);
            this.vs.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.iI != null) {
            this.vs.set(true);
            canvas.drawBitmap(this.iI, rect, rectF, paint);
            this.vs.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.iI != null) {
            this.vo = false;
            imageView.setImageBitmap(this.iI);
        }
    }

    public boolean ck() {
        return this.vn;
    }

    public int size() {
        if (this.iI == null) {
            return 0;
        }
        return this.iI.getHeight() * this.iI.getRowBytes();
    }

    public boolean jb() {
        if (this.vo && !this.vs.get()) {
            if (this.iI != null) {
                Bitmap bitmap = this.iI;
                this.iI = null;
                bitmap.recycle();
            }
            if (this.vt != null) {
                com.baidu.adp.gif.c cVar = this.vt;
                this.vt = null;
                cVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap jc() {
        this.vo = false;
        return this.iI;
    }

    public boolean jd() {
        return this.iI != null;
    }

    public BitmapDrawable je() {
        if (this.iI == null) {
            return null;
        }
        this.vo = false;
        return new b(this, this.iI);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] jf() {
        byte[] byteArray;
        if (this.iI == null) {
            return null;
        }
        synchronized (vv) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.iI.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect jg() {
        return this.vw;
    }

    public byte[] jh() {
        return this.vp;
    }

    public BitmapShader ji() {
        if (this.iI == null) {
            return null;
        }
        this.vo = false;
        return new BitmapShader(this.iI, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void P(boolean z) {
        this.vs.set(z);
    }
}
