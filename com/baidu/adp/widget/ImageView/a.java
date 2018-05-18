package com.baidu.adp.widget.ImageView;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.NinePatch;
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
    public static final Object lockForSyncImageDecoder = new Object();
    private NinePatch EA;
    public C0015a EB;
    private Bitmap Eq;
    private boolean Er;
    private byte[] Es;
    private int Et;
    private int Eu;
    private AtomicBoolean Ev;
    private com.baidu.adp.gif.b Ew;
    private boolean Ex;
    public Rect Ey;
    private boolean Ez;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a {
        public String ED;
        public long EE;
        public boolean EF;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Eq = null;
        this.isGif = false;
        this.Er = true;
        this.Es = null;
        this.Et = -1;
        this.Eu = -1;
        this.Ev = new AtomicBoolean(false);
        this.Ex = false;
        this.timeStamp = -1L;
        this.Ez = false;
        this.EB = new C0015a();
        this.Eq = bitmap;
        this.isGif = z;
        ki();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Eq = null;
        this.isGif = false;
        this.Er = true;
        this.Es = null;
        this.Et = -1;
        this.Eu = -1;
        this.Ev = new AtomicBoolean(false);
        this.Ex = false;
        this.timeStamp = -1L;
        this.Ez = false;
        this.EB = new C0015a();
        this.Eq = bitmap;
        this.isGif = z;
        this.url = str;
        ki();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Eq = null;
        this.isGif = false;
        this.Er = true;
        this.Es = null;
        this.Et = -1;
        this.Eu = -1;
        this.Ev = new AtomicBoolean(false);
        this.Ex = false;
        this.timeStamp = -1L;
        this.Ez = false;
        this.EB = new C0015a();
        this.Eq = bitmap;
        this.isGif = z;
        this.url = str;
        this.Ey = rect;
        ki();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Eq = null;
        this.isGif = false;
        this.Er = true;
        this.Es = null;
        this.Et = -1;
        this.Eu = -1;
        this.Ev = new AtomicBoolean(false);
        this.Ex = false;
        this.timeStamp = -1L;
        this.Ez = false;
        this.EB = new C0015a();
        this.Eq = bitmap;
        this.isGif = z;
        this.url = str;
        this.Es = bArr;
        ki();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.Eq = null;
        this.isGif = false;
        this.Er = true;
        this.Es = null;
        this.Et = -1;
        this.Eu = -1;
        this.Ev = new AtomicBoolean(false);
        this.Ex = false;
        this.timeStamp = -1L;
        this.Ez = false;
        this.EB = new C0015a();
        this.Ew = bVar;
        this.Eq = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Eq = null;
        this.isGif = false;
        this.Er = true;
        this.Es = null;
        this.Et = -1;
        this.Eu = -1;
        this.Ev = new AtomicBoolean(false);
        this.Ex = false;
        this.timeStamp = -1L;
        this.Ez = false;
        this.EB = new C0015a();
        this.Ew = bVar;
        this.Ex = true;
    }

    private void ki() {
        byte[] ninePatchChunk;
        if (this.Eq != null && (ninePatchChunk = this.Eq.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Ez = true;
            this.EA = new NinePatch(this.Eq, ninePatchChunk, "image");
        }
    }

    public boolean kj() {
        return this.Ex;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.Ew;
    }

    public int getWidth() {
        if (this.Eq == null) {
            return 0;
        }
        return this.Eq.getWidth();
    }

    public int getHeight() {
        if (this.Eq == null) {
            return 0;
        }
        return this.Eq.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Eq != null) {
            this.Ev.set(true);
            canvas.drawBitmap(this.Eq, matrix, paint);
            this.Ev.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Eq != null) {
            this.Ev.set(true);
            canvas.drawBitmap(this.Eq, f, f2, paint);
            this.Ev.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Eq != null) {
            this.Ev.set(true);
            canvas.drawBitmap(this.Eq, rect, rectF, paint);
            this.Ev.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Eq != null) {
            this.Er = false;
            imageView.setImageBitmap(this.Eq);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Ez && this.EA != null) {
            this.EA.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Eq == null) {
            return 0;
        }
        return this.Eq.getHeight() * this.Eq.getRowBytes();
    }

    public boolean kk() {
        if (this.Er && !this.Ev.get()) {
            if (this.Eq != null) {
                Bitmap bitmap = this.Eq;
                this.Eq = null;
                bitmap.recycle();
            }
            if (this.Ew != null) {
                com.baidu.adp.gif.b bVar = this.Ew;
                this.Ew = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap kl() {
        this.Er = false;
        return this.Eq;
    }

    public boolean km() {
        return this.Eq != null;
    }

    public BitmapDrawable kn() {
        if (this.Eq == null) {
            return null;
        }
        this.Er = false;
        return new BitmapDrawable(this.Eq) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Eq != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Eq, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] ko() {
        byte[] byteArray;
        if (this.Eq == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Eq.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect kp() {
        return this.Ey;
    }

    public byte[] kq() {
        return this.Es;
    }

    public BitmapShader kr() {
        if (this.Eq == null || this.Eq.isRecycled()) {
            return null;
        }
        this.Er = false;
        return new BitmapShader(this.Eq, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void V(boolean z) {
        this.Ev.set(z);
    }

    public boolean ks() {
        return this.Ez;
    }
}
