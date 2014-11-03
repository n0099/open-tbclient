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
    public static final Object tg = new Object();
    private Bitmap iz;
    private volatile boolean sX;
    private boolean sY;
    private byte[] sZ;
    private int tb;
    private int tc;
    private AtomicBoolean td;
    private com.baidu.adp.gif.c te;
    private boolean tf;
    public long th;
    public Rect ti;
    public c tj;
    private String url;

    public a(Bitmap bitmap, boolean z) {
        this.iz = null;
        this.sX = false;
        this.sY = true;
        this.sZ = null;
        this.tb = -1;
        this.tc = -1;
        this.td = new AtomicBoolean(false);
        this.tf = false;
        this.th = -1L;
        this.tj = new c();
        this.iz = bitmap;
        this.sX = z;
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.iz = null;
        this.sX = false;
        this.sY = true;
        this.sZ = null;
        this.tb = -1;
        this.tc = -1;
        this.td = new AtomicBoolean(false);
        this.tf = false;
        this.th = -1L;
        this.tj = new c();
        this.iz = bitmap;
        this.sX = z;
        this.url = str;
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.iz = null;
        this.sX = false;
        this.sY = true;
        this.sZ = null;
        this.tb = -1;
        this.tc = -1;
        this.td = new AtomicBoolean(false);
        this.tf = false;
        this.th = -1L;
        this.tj = new c();
        this.iz = bitmap;
        this.sX = z;
        this.url = str;
        this.ti = rect;
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.iz = null;
        this.sX = false;
        this.sY = true;
        this.sZ = null;
        this.tb = -1;
        this.tc = -1;
        this.td = new AtomicBoolean(false);
        this.tf = false;
        this.th = -1L;
        this.tj = new c();
        this.iz = bitmap;
        this.sX = z;
        this.url = str;
        this.sZ = bArr;
    }

    public a(com.baidu.adp.gif.c cVar) {
        this.iz = null;
        this.sX = false;
        this.sY = true;
        this.sZ = null;
        this.tb = -1;
        this.tc = -1;
        this.td = new AtomicBoolean(false);
        this.tf = false;
        this.th = -1L;
        this.tj = new c();
        this.te = cVar;
        this.tf = true;
    }

    public boolean hj() {
        return this.tf;
    }

    public com.baidu.adp.gif.c getGif() {
        return this.te;
    }

    public int getWidth() {
        if (this.iz == null) {
            return 0;
        }
        return this.iz.getWidth();
    }

    public int getHeight() {
        if (this.iz == null) {
            return 0;
        }
        return this.iz.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.iz != null) {
            this.td.set(true);
            canvas.drawBitmap(this.iz, matrix, paint);
            this.td.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.iz != null) {
            this.td.set(true);
            canvas.drawBitmap(this.iz, f, f2, paint);
            this.td.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.iz != null) {
            this.td.set(true);
            canvas.drawBitmap(this.iz, rect, rectF, paint);
            this.td.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.iz != null) {
            this.sY = false;
            imageView.setImageBitmap(this.iz);
        }
    }

    public boolean bM() {
        return this.sX;
    }

    public int size() {
        if (this.iz == null) {
            return 0;
        }
        return this.iz.getHeight() * this.iz.getRowBytes();
    }

    public boolean hk() {
        if (this.sY && !this.td.get()) {
            if (this.iz != null) {
                Bitmap bitmap = this.iz;
                this.iz = null;
                bitmap.recycle();
            }
            if (this.te != null) {
                com.baidu.adp.gif.c cVar = this.te;
                this.te = null;
                cVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap hl() {
        this.sY = false;
        return this.iz;
    }

    public boolean hm() {
        return this.iz != null;
    }

    public BitmapDrawable hn() {
        if (this.iz == null) {
            return null;
        }
        this.sY = false;
        return new b(this, this.iz);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] ho() {
        byte[] byteArray;
        if (this.iz == null) {
            return null;
        }
        synchronized (tg) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.iz.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect hp() {
        return this.ti;
    }

    public byte[] hq() {
        return this.sZ;
    }

    public BitmapShader hr() {
        if (this.iz == null) {
            return null;
        }
        this.sY = false;
        return new BitmapShader(this.iz, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void D(boolean z) {
        this.td.set(z);
    }
}
