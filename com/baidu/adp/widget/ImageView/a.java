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
    private com.baidu.adp.gif.b EA;
    private boolean EB;
    public Rect EC;
    private boolean ED;
    private NinePatch EE;
    public C0015a EF;
    private Bitmap Eu;
    private boolean Ev;
    private byte[] Ew;
    private int Ex;
    private int Ey;
    private AtomicBoolean Ez;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a {
        public String EH;
        public long EI;
        public boolean EJ;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Eu = null;
        this.isGif = false;
        this.Ev = true;
        this.Ew = null;
        this.Ex = -1;
        this.Ey = -1;
        this.Ez = new AtomicBoolean(false);
        this.EB = false;
        this.timeStamp = -1L;
        this.ED = false;
        this.EF = new C0015a();
        this.Eu = bitmap;
        this.isGif = z;
        kj();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Eu = null;
        this.isGif = false;
        this.Ev = true;
        this.Ew = null;
        this.Ex = -1;
        this.Ey = -1;
        this.Ez = new AtomicBoolean(false);
        this.EB = false;
        this.timeStamp = -1L;
        this.ED = false;
        this.EF = new C0015a();
        this.Eu = bitmap;
        this.isGif = z;
        this.url = str;
        kj();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Eu = null;
        this.isGif = false;
        this.Ev = true;
        this.Ew = null;
        this.Ex = -1;
        this.Ey = -1;
        this.Ez = new AtomicBoolean(false);
        this.EB = false;
        this.timeStamp = -1L;
        this.ED = false;
        this.EF = new C0015a();
        this.Eu = bitmap;
        this.isGif = z;
        this.url = str;
        this.EC = rect;
        kj();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Eu = null;
        this.isGif = false;
        this.Ev = true;
        this.Ew = null;
        this.Ex = -1;
        this.Ey = -1;
        this.Ez = new AtomicBoolean(false);
        this.EB = false;
        this.timeStamp = -1L;
        this.ED = false;
        this.EF = new C0015a();
        this.Eu = bitmap;
        this.isGif = z;
        this.url = str;
        this.Ew = bArr;
        kj();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.Eu = null;
        this.isGif = false;
        this.Ev = true;
        this.Ew = null;
        this.Ex = -1;
        this.Ey = -1;
        this.Ez = new AtomicBoolean(false);
        this.EB = false;
        this.timeStamp = -1L;
        this.ED = false;
        this.EF = new C0015a();
        this.EA = bVar;
        this.Eu = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Eu = null;
        this.isGif = false;
        this.Ev = true;
        this.Ew = null;
        this.Ex = -1;
        this.Ey = -1;
        this.Ez = new AtomicBoolean(false);
        this.EB = false;
        this.timeStamp = -1L;
        this.ED = false;
        this.EF = new C0015a();
        this.EA = bVar;
        this.EB = true;
    }

    private void kj() {
        byte[] ninePatchChunk;
        if (this.Eu != null && (ninePatchChunk = this.Eu.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.ED = true;
            this.EE = new NinePatch(this.Eu, ninePatchChunk, "image");
        }
    }

    public boolean kk() {
        return this.EB;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.EA;
    }

    public int getWidth() {
        if (this.Eu == null) {
            return 0;
        }
        return this.Eu.getWidth();
    }

    public int getHeight() {
        if (this.Eu == null) {
            return 0;
        }
        return this.Eu.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Eu != null) {
            this.Ez.set(true);
            canvas.drawBitmap(this.Eu, matrix, paint);
            this.Ez.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Eu != null) {
            this.Ez.set(true);
            canvas.drawBitmap(this.Eu, f, f2, paint);
            this.Ez.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Eu != null) {
            this.Ez.set(true);
            canvas.drawBitmap(this.Eu, rect, rectF, paint);
            this.Ez.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Eu != null) {
            this.Ev = false;
            imageView.setImageBitmap(this.Eu);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.ED && this.EE != null) {
            this.EE.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Eu == null) {
            return 0;
        }
        return this.Eu.getHeight() * this.Eu.getRowBytes();
    }

    public boolean kl() {
        if (this.Ev && !this.Ez.get()) {
            if (this.Eu != null) {
                Bitmap bitmap = this.Eu;
                this.Eu = null;
                bitmap.recycle();
            }
            if (this.EA != null) {
                com.baidu.adp.gif.b bVar = this.EA;
                this.EA = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap km() {
        this.Ev = false;
        return this.Eu;
    }

    public boolean kn() {
        return this.Eu != null;
    }

    public BitmapDrawable ko() {
        if (this.Eu == null) {
            return null;
        }
        this.Ev = false;
        return new BitmapDrawable(this.Eu) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Eu != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Eu, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] kp() {
        byte[] byteArray;
        if (this.Eu == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Eu.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect kq() {
        return this.EC;
    }

    public byte[] kr() {
        return this.Ew;
    }

    public BitmapShader ks() {
        if (this.Eu == null || this.Eu.isRecycled()) {
            return null;
        }
        this.Ev = false;
        return new BitmapShader(this.Eu, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void V(boolean z) {
        this.Ez.set(z);
    }

    public boolean kt() {
        return this.ED;
    }
}
