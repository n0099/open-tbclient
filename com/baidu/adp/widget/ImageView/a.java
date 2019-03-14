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
    private Bitmap NR;
    private boolean NT;
    private byte[] NU;
    private int NV;
    private int NW;
    private int NX;
    private int NY;
    private AtomicBoolean NZ;
    private com.baidu.adp.gif.b Oa;
    private boolean Ob;
    public Rect Oc;
    private boolean Od;
    private NinePatch Oe;
    public C0025a Of;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0025a {
        public String Oh;
        public long Oi;
        public boolean Oj;
    }

    public a(Bitmap bitmap, boolean z) {
        this.NR = null;
        this.isGif = false;
        this.NT = true;
        this.NU = null;
        this.NV = -1;
        this.NW = -1;
        this.NZ = new AtomicBoolean(false);
        this.Ob = false;
        this.timeStamp = -1L;
        this.Od = false;
        this.Of = new C0025a();
        this.NR = bitmap;
        this.isGif = z;
        ov();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.NR = null;
        this.isGif = false;
        this.NT = true;
        this.NU = null;
        this.NV = -1;
        this.NW = -1;
        this.NZ = new AtomicBoolean(false);
        this.Ob = false;
        this.timeStamp = -1L;
        this.Od = false;
        this.Of = new C0025a();
        this.NR = bitmap;
        this.isGif = z;
        this.url = str;
        ov();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.NR = null;
        this.isGif = false;
        this.NT = true;
        this.NU = null;
        this.NV = -1;
        this.NW = -1;
        this.NZ = new AtomicBoolean(false);
        this.Ob = false;
        this.timeStamp = -1L;
        this.Od = false;
        this.Of = new C0025a();
        this.NR = bitmap;
        this.isGif = z;
        this.url = str;
        this.Oc = rect;
        ov();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.NR = null;
        this.isGif = false;
        this.NT = true;
        this.NU = null;
        this.NV = -1;
        this.NW = -1;
        this.NZ = new AtomicBoolean(false);
        this.Ob = false;
        this.timeStamp = -1L;
        this.Od = false;
        this.Of = new C0025a();
        this.NR = bitmap;
        this.isGif = z;
        this.url = str;
        this.NU = bArr;
        ov();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.NR = null;
        this.isGif = false;
        this.NT = true;
        this.NU = null;
        this.NV = -1;
        this.NW = -1;
        this.NZ = new AtomicBoolean(false);
        this.Ob = false;
        this.timeStamp = -1L;
        this.Od = false;
        this.Of = new C0025a();
        this.Oa = bVar;
        this.NR = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.NR = null;
        this.isGif = false;
        this.NT = true;
        this.NU = null;
        this.NV = -1;
        this.NW = -1;
        this.NZ = new AtomicBoolean(false);
        this.Ob = false;
        this.timeStamp = -1L;
        this.Od = false;
        this.Of = new C0025a();
        this.Oa = bVar;
        this.Ob = true;
    }

    private void ov() {
        byte[] ninePatchChunk;
        if (this.NR != null && (ninePatchChunk = this.NR.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Od = true;
            this.Oe = new NinePatch(this.NR, ninePatchChunk, "image");
        }
    }

    public boolean ow() {
        return this.Ob;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.Oa;
    }

    public int getWidth() {
        if (this.NR == null) {
            return 0;
        }
        return this.NR.getWidth();
    }

    public int getHeight() {
        if (this.NR == null) {
            return 0;
        }
        return this.NR.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.NR != null) {
            this.NZ.set(true);
            canvas.drawBitmap(this.NR, matrix, paint);
            this.NZ.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.NR != null) {
            this.NZ.set(true);
            canvas.drawBitmap(this.NR, f, f2, paint);
            this.NZ.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.NR != null) {
            this.NZ.set(true);
            canvas.drawBitmap(this.NR, rect, rectF, paint);
            this.NZ.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.NR != null) {
            this.NT = false;
            imageView.setImageBitmap(this.NR);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Od && this.Oe != null) {
            this.Oe.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.NR == null) {
            return 0;
        }
        return this.NR.getHeight() * this.NR.getRowBytes();
    }

    public boolean ox() {
        if (this.NT && !this.NZ.get()) {
            if (this.NR != null) {
                Bitmap bitmap = this.NR;
                this.NR = null;
                bitmap.recycle();
            }
            if (this.Oa != null) {
                com.baidu.adp.gif.b bVar = this.Oa;
                this.Oa = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap oy() {
        this.NT = false;
        return this.NR;
    }

    public boolean oz() {
        return this.NR != null;
    }

    public BitmapDrawable oA() {
        if (this.NR == null) {
            return null;
        }
        this.NT = false;
        return new BitmapDrawable(this.NR) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.NR != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.NR, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] oB() {
        byte[] byteArray;
        if (this.NR == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.NR.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect oC() {
        return this.Oc;
    }

    public byte[] oD() {
        return this.NU;
    }

    public BitmapShader oE() {
        if (this.NR == null || this.NR.isRecycled()) {
            return null;
        }
        this.NT = false;
        return new BitmapShader(this.NR, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void au(boolean z) {
        this.NZ.set(z);
    }

    public boolean oF() {
        return this.Od;
    }

    public void aO(int i) {
        this.NX = i;
    }

    public void aP(int i) {
        this.NY = i;
    }
}
