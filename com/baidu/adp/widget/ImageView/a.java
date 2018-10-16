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
    private boolean NB;
    public Rect NC;
    private boolean ND;
    private NinePatch NE;
    public C0026a NF;
    private Bitmap Nr;
    private boolean Ns;
    private byte[] Nt;
    private int Nu;
    private int Nv;
    private int Nw;
    private int Nx;
    private AtomicBoolean Ny;
    private com.baidu.adp.gif.b Nz;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0026a {
        public String NH;
        public long NI;
        public boolean NJ;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Nr = null;
        this.isGif = false;
        this.Ns = true;
        this.Nt = null;
        this.Nu = -1;
        this.Nv = -1;
        this.Ny = new AtomicBoolean(false);
        this.NB = false;
        this.timeStamp = -1L;
        this.ND = false;
        this.NF = new C0026a();
        this.Nr = bitmap;
        this.isGif = z;
        op();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Nr = null;
        this.isGif = false;
        this.Ns = true;
        this.Nt = null;
        this.Nu = -1;
        this.Nv = -1;
        this.Ny = new AtomicBoolean(false);
        this.NB = false;
        this.timeStamp = -1L;
        this.ND = false;
        this.NF = new C0026a();
        this.Nr = bitmap;
        this.isGif = z;
        this.url = str;
        op();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Nr = null;
        this.isGif = false;
        this.Ns = true;
        this.Nt = null;
        this.Nu = -1;
        this.Nv = -1;
        this.Ny = new AtomicBoolean(false);
        this.NB = false;
        this.timeStamp = -1L;
        this.ND = false;
        this.NF = new C0026a();
        this.Nr = bitmap;
        this.isGif = z;
        this.url = str;
        this.NC = rect;
        op();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Nr = null;
        this.isGif = false;
        this.Ns = true;
        this.Nt = null;
        this.Nu = -1;
        this.Nv = -1;
        this.Ny = new AtomicBoolean(false);
        this.NB = false;
        this.timeStamp = -1L;
        this.ND = false;
        this.NF = new C0026a();
        this.Nr = bitmap;
        this.isGif = z;
        this.url = str;
        this.Nt = bArr;
        op();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.Nr = null;
        this.isGif = false;
        this.Ns = true;
        this.Nt = null;
        this.Nu = -1;
        this.Nv = -1;
        this.Ny = new AtomicBoolean(false);
        this.NB = false;
        this.timeStamp = -1L;
        this.ND = false;
        this.NF = new C0026a();
        this.Nz = bVar;
        this.Nr = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Nr = null;
        this.isGif = false;
        this.Ns = true;
        this.Nt = null;
        this.Nu = -1;
        this.Nv = -1;
        this.Ny = new AtomicBoolean(false);
        this.NB = false;
        this.timeStamp = -1L;
        this.ND = false;
        this.NF = new C0026a();
        this.Nz = bVar;
        this.NB = true;
    }

    private void op() {
        byte[] ninePatchChunk;
        if (this.Nr != null && (ninePatchChunk = this.Nr.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.ND = true;
            this.NE = new NinePatch(this.Nr, ninePatchChunk, "image");
        }
    }

    public boolean oq() {
        return this.NB;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.Nz;
    }

    public int getWidth() {
        if (this.Nr == null) {
            return 0;
        }
        return this.Nr.getWidth();
    }

    public int getHeight() {
        if (this.Nr == null) {
            return 0;
        }
        return this.Nr.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Nr != null) {
            this.Ny.set(true);
            canvas.drawBitmap(this.Nr, matrix, paint);
            this.Ny.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Nr != null) {
            this.Ny.set(true);
            canvas.drawBitmap(this.Nr, f, f2, paint);
            this.Ny.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Nr != null) {
            this.Ny.set(true);
            canvas.drawBitmap(this.Nr, rect, rectF, paint);
            this.Ny.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Nr != null) {
            this.Ns = false;
            imageView.setImageBitmap(this.Nr);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.ND && this.NE != null) {
            this.NE.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Nr == null) {
            return 0;
        }
        return this.Nr.getHeight() * this.Nr.getRowBytes();
    }

    public boolean or() {
        if (this.Ns && !this.Ny.get()) {
            if (this.Nr != null) {
                Bitmap bitmap = this.Nr;
                this.Nr = null;
                bitmap.recycle();
            }
            if (this.Nz != null) {
                com.baidu.adp.gif.b bVar = this.Nz;
                this.Nz = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap os() {
        this.Ns = false;
        return this.Nr;
    }

    public boolean ot() {
        return this.Nr != null;
    }

    public BitmapDrawable ou() {
        if (this.Nr == null) {
            return null;
        }
        this.Ns = false;
        return new BitmapDrawable(this.Nr) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Nr != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Nr, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] ov() {
        byte[] byteArray;
        if (this.Nr == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Nr.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect ow() {
        return this.NC;
    }

    public byte[] ox() {
        return this.Nt;
    }

    public BitmapShader oy() {
        if (this.Nr == null || this.Nr.isRecycled()) {
            return null;
        }
        this.Ns = false;
        return new BitmapShader(this.Nr, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void af(boolean z) {
        this.Ny.set(z);
    }

    public boolean oz() {
        return this.ND;
    }

    public void aN(int i) {
        this.Nw = i;
    }

    public void aO(int i) {
        this.Nx = i;
    }
}
