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
    private Bitmap NQ;
    private boolean NR;
    private byte[] NT;
    private int NU;
    private int NV;
    private int NW;
    private int NX;
    private AtomicBoolean NY;
    private com.baidu.adp.gif.b NZ;
    private boolean Oa;
    public Rect Ob;
    private boolean Oc;
    private NinePatch Od;
    public C0025a Oe;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0025a {
        public String Og;
        public long Oh;
        public boolean Oi;
    }

    public a(Bitmap bitmap, boolean z) {
        this.NQ = null;
        this.isGif = false;
        this.NR = true;
        this.NT = null;
        this.NU = -1;
        this.NV = -1;
        this.NY = new AtomicBoolean(false);
        this.Oa = false;
        this.timeStamp = -1L;
        this.Oc = false;
        this.Oe = new C0025a();
        this.NQ = bitmap;
        this.isGif = z;
        ov();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.NQ = null;
        this.isGif = false;
        this.NR = true;
        this.NT = null;
        this.NU = -1;
        this.NV = -1;
        this.NY = new AtomicBoolean(false);
        this.Oa = false;
        this.timeStamp = -1L;
        this.Oc = false;
        this.Oe = new C0025a();
        this.NQ = bitmap;
        this.isGif = z;
        this.url = str;
        ov();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.NQ = null;
        this.isGif = false;
        this.NR = true;
        this.NT = null;
        this.NU = -1;
        this.NV = -1;
        this.NY = new AtomicBoolean(false);
        this.Oa = false;
        this.timeStamp = -1L;
        this.Oc = false;
        this.Oe = new C0025a();
        this.NQ = bitmap;
        this.isGif = z;
        this.url = str;
        this.Ob = rect;
        ov();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.NQ = null;
        this.isGif = false;
        this.NR = true;
        this.NT = null;
        this.NU = -1;
        this.NV = -1;
        this.NY = new AtomicBoolean(false);
        this.Oa = false;
        this.timeStamp = -1L;
        this.Oc = false;
        this.Oe = new C0025a();
        this.NQ = bitmap;
        this.isGif = z;
        this.url = str;
        this.NT = bArr;
        ov();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.NQ = null;
        this.isGif = false;
        this.NR = true;
        this.NT = null;
        this.NU = -1;
        this.NV = -1;
        this.NY = new AtomicBoolean(false);
        this.Oa = false;
        this.timeStamp = -1L;
        this.Oc = false;
        this.Oe = new C0025a();
        this.NZ = bVar;
        this.NQ = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.NQ = null;
        this.isGif = false;
        this.NR = true;
        this.NT = null;
        this.NU = -1;
        this.NV = -1;
        this.NY = new AtomicBoolean(false);
        this.Oa = false;
        this.timeStamp = -1L;
        this.Oc = false;
        this.Oe = new C0025a();
        this.NZ = bVar;
        this.Oa = true;
    }

    private void ov() {
        byte[] ninePatchChunk;
        if (this.NQ != null && (ninePatchChunk = this.NQ.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Oc = true;
            this.Od = new NinePatch(this.NQ, ninePatchChunk, "image");
        }
    }

    public boolean ow() {
        return this.Oa;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.NZ;
    }

    public int getWidth() {
        if (this.NQ == null) {
            return 0;
        }
        return this.NQ.getWidth();
    }

    public int getHeight() {
        if (this.NQ == null) {
            return 0;
        }
        return this.NQ.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.NQ != null) {
            this.NY.set(true);
            canvas.drawBitmap(this.NQ, matrix, paint);
            this.NY.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.NQ != null) {
            this.NY.set(true);
            canvas.drawBitmap(this.NQ, f, f2, paint);
            this.NY.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.NQ != null) {
            this.NY.set(true);
            canvas.drawBitmap(this.NQ, rect, rectF, paint);
            this.NY.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.NQ != null) {
            this.NR = false;
            imageView.setImageBitmap(this.NQ);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Oc && this.Od != null) {
            this.Od.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.NQ == null) {
            return 0;
        }
        return this.NQ.getHeight() * this.NQ.getRowBytes();
    }

    public boolean ox() {
        if (this.NR && !this.NY.get()) {
            if (this.NQ != null) {
                Bitmap bitmap = this.NQ;
                this.NQ = null;
                bitmap.recycle();
            }
            if (this.NZ != null) {
                com.baidu.adp.gif.b bVar = this.NZ;
                this.NZ = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap oy() {
        this.NR = false;
        return this.NQ;
    }

    public boolean oz() {
        return this.NQ != null;
    }

    public BitmapDrawable oA() {
        if (this.NQ == null) {
            return null;
        }
        this.NR = false;
        return new BitmapDrawable(this.NQ) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.NQ != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.NQ, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] oB() {
        byte[] byteArray;
        if (this.NQ == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.NQ.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect oC() {
        return this.Ob;
    }

    public byte[] oD() {
        return this.NT;
    }

    public BitmapShader oE() {
        if (this.NQ == null || this.NQ.isRecycled()) {
            return null;
        }
        this.NR = false;
        return new BitmapShader(this.NQ, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void au(boolean z) {
        this.NY.set(z);
    }

    public boolean oF() {
        return this.Oc;
    }

    public void aO(int i) {
        this.NW = i;
    }

    public void aP(int i) {
        this.NX = i;
    }
}
