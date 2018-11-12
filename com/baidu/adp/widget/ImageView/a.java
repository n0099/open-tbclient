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
    private int NB;
    private AtomicBoolean NC;
    private com.baidu.adp.gif.b ND;
    private boolean NE;
    public Rect NF;
    private boolean NG;
    private NinePatch NH;
    public C0026a NI;
    private Bitmap Nu;
    private boolean Nv;
    private byte[] Nw;
    private int Nx;
    private int Ny;
    private int Nz;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0026a {
        public String NK;
        public long NL;
        public boolean NM;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Nu = null;
        this.isGif = false;
        this.Nv = true;
        this.Nw = null;
        this.Nx = -1;
        this.Ny = -1;
        this.NC = new AtomicBoolean(false);
        this.NE = false;
        this.timeStamp = -1L;
        this.NG = false;
        this.NI = new C0026a();
        this.Nu = bitmap;
        this.isGif = z;
        on();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Nu = null;
        this.isGif = false;
        this.Nv = true;
        this.Nw = null;
        this.Nx = -1;
        this.Ny = -1;
        this.NC = new AtomicBoolean(false);
        this.NE = false;
        this.timeStamp = -1L;
        this.NG = false;
        this.NI = new C0026a();
        this.Nu = bitmap;
        this.isGif = z;
        this.url = str;
        on();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Nu = null;
        this.isGif = false;
        this.Nv = true;
        this.Nw = null;
        this.Nx = -1;
        this.Ny = -1;
        this.NC = new AtomicBoolean(false);
        this.NE = false;
        this.timeStamp = -1L;
        this.NG = false;
        this.NI = new C0026a();
        this.Nu = bitmap;
        this.isGif = z;
        this.url = str;
        this.NF = rect;
        on();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Nu = null;
        this.isGif = false;
        this.Nv = true;
        this.Nw = null;
        this.Nx = -1;
        this.Ny = -1;
        this.NC = new AtomicBoolean(false);
        this.NE = false;
        this.timeStamp = -1L;
        this.NG = false;
        this.NI = new C0026a();
        this.Nu = bitmap;
        this.isGif = z;
        this.url = str;
        this.Nw = bArr;
        on();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.Nu = null;
        this.isGif = false;
        this.Nv = true;
        this.Nw = null;
        this.Nx = -1;
        this.Ny = -1;
        this.NC = new AtomicBoolean(false);
        this.NE = false;
        this.timeStamp = -1L;
        this.NG = false;
        this.NI = new C0026a();
        this.ND = bVar;
        this.Nu = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Nu = null;
        this.isGif = false;
        this.Nv = true;
        this.Nw = null;
        this.Nx = -1;
        this.Ny = -1;
        this.NC = new AtomicBoolean(false);
        this.NE = false;
        this.timeStamp = -1L;
        this.NG = false;
        this.NI = new C0026a();
        this.ND = bVar;
        this.NE = true;
    }

    private void on() {
        byte[] ninePatchChunk;
        if (this.Nu != null && (ninePatchChunk = this.Nu.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.NG = true;
            this.NH = new NinePatch(this.Nu, ninePatchChunk, "image");
        }
    }

    public boolean oo() {
        return this.NE;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.ND;
    }

    public int getWidth() {
        if (this.Nu == null) {
            return 0;
        }
        return this.Nu.getWidth();
    }

    public int getHeight() {
        if (this.Nu == null) {
            return 0;
        }
        return this.Nu.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Nu != null) {
            this.NC.set(true);
            canvas.drawBitmap(this.Nu, matrix, paint);
            this.NC.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Nu != null) {
            this.NC.set(true);
            canvas.drawBitmap(this.Nu, f, f2, paint);
            this.NC.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Nu != null) {
            this.NC.set(true);
            canvas.drawBitmap(this.Nu, rect, rectF, paint);
            this.NC.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Nu != null) {
            this.Nv = false;
            imageView.setImageBitmap(this.Nu);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.NG && this.NH != null) {
            this.NH.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Nu == null) {
            return 0;
        }
        return this.Nu.getHeight() * this.Nu.getRowBytes();
    }

    public boolean op() {
        if (this.Nv && !this.NC.get()) {
            if (this.Nu != null) {
                Bitmap bitmap = this.Nu;
                this.Nu = null;
                bitmap.recycle();
            }
            if (this.ND != null) {
                com.baidu.adp.gif.b bVar = this.ND;
                this.ND = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap oq() {
        this.Nv = false;
        return this.Nu;
    }

    public boolean or() {
        return this.Nu != null;
    }

    public BitmapDrawable os() {
        if (this.Nu == null) {
            return null;
        }
        this.Nv = false;
        return new BitmapDrawable(this.Nu) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Nu != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Nu, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] ot() {
        byte[] byteArray;
        if (this.Nu == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Nu.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect ou() {
        return this.NF;
    }

    public byte[] ov() {
        return this.Nw;
    }

    public BitmapShader ow() {
        if (this.Nu == null || this.Nu.isRecycled()) {
            return null;
        }
        this.Nv = false;
        return new BitmapShader(this.Nu, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void at(boolean z) {
        this.NC.set(z);
    }

    public boolean ox() {
        return this.NG;
    }

    public void be(int i) {
        this.Nz = i;
    }

    public void bf(int i) {
        this.NB = i;
    }
}
