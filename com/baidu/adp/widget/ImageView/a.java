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
    private Bitmap NE;
    private boolean NF;
    private byte[] NG;
    private int NH;
    private int NI;
    private int NJ;
    private int NK;
    private AtomicBoolean NL;
    private com.baidu.adp.gif.b NM;
    private boolean NN;
    public Rect NP;
    private boolean NQ;
    private NinePatch NR;
    public C0026a NT;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0026a {
        public String NV;
        public long NW;
        public boolean NX;
    }

    public a(Bitmap bitmap, boolean z) {
        this.NE = null;
        this.isGif = false;
        this.NF = true;
        this.NG = null;
        this.NH = -1;
        this.NI = -1;
        this.NL = new AtomicBoolean(false);
        this.NN = false;
        this.timeStamp = -1L;
        this.NQ = false;
        this.NT = new C0026a();
        this.NE = bitmap;
        this.isGif = z;
        oq();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.NE = null;
        this.isGif = false;
        this.NF = true;
        this.NG = null;
        this.NH = -1;
        this.NI = -1;
        this.NL = new AtomicBoolean(false);
        this.NN = false;
        this.timeStamp = -1L;
        this.NQ = false;
        this.NT = new C0026a();
        this.NE = bitmap;
        this.isGif = z;
        this.url = str;
        oq();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.NE = null;
        this.isGif = false;
        this.NF = true;
        this.NG = null;
        this.NH = -1;
        this.NI = -1;
        this.NL = new AtomicBoolean(false);
        this.NN = false;
        this.timeStamp = -1L;
        this.NQ = false;
        this.NT = new C0026a();
        this.NE = bitmap;
        this.isGif = z;
        this.url = str;
        this.NP = rect;
        oq();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.NE = null;
        this.isGif = false;
        this.NF = true;
        this.NG = null;
        this.NH = -1;
        this.NI = -1;
        this.NL = new AtomicBoolean(false);
        this.NN = false;
        this.timeStamp = -1L;
        this.NQ = false;
        this.NT = new C0026a();
        this.NE = bitmap;
        this.isGif = z;
        this.url = str;
        this.NG = bArr;
        oq();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.NE = null;
        this.isGif = false;
        this.NF = true;
        this.NG = null;
        this.NH = -1;
        this.NI = -1;
        this.NL = new AtomicBoolean(false);
        this.NN = false;
        this.timeStamp = -1L;
        this.NQ = false;
        this.NT = new C0026a();
        this.NM = bVar;
        this.NE = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.NE = null;
        this.isGif = false;
        this.NF = true;
        this.NG = null;
        this.NH = -1;
        this.NI = -1;
        this.NL = new AtomicBoolean(false);
        this.NN = false;
        this.timeStamp = -1L;
        this.NQ = false;
        this.NT = new C0026a();
        this.NM = bVar;
        this.NN = true;
    }

    private void oq() {
        byte[] ninePatchChunk;
        if (this.NE != null && (ninePatchChunk = this.NE.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.NQ = true;
            this.NR = new NinePatch(this.NE, ninePatchChunk, "image");
        }
    }

    public boolean or() {
        return this.NN;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.NM;
    }

    public int getWidth() {
        if (this.NE == null) {
            return 0;
        }
        return this.NE.getWidth();
    }

    public int getHeight() {
        if (this.NE == null) {
            return 0;
        }
        return this.NE.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.NE != null) {
            this.NL.set(true);
            canvas.drawBitmap(this.NE, matrix, paint);
            this.NL.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.NE != null) {
            this.NL.set(true);
            canvas.drawBitmap(this.NE, f, f2, paint);
            this.NL.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.NE != null) {
            this.NL.set(true);
            canvas.drawBitmap(this.NE, rect, rectF, paint);
            this.NL.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.NE != null) {
            this.NF = false;
            imageView.setImageBitmap(this.NE);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.NQ && this.NR != null) {
            this.NR.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.NE == null) {
            return 0;
        }
        return this.NE.getHeight() * this.NE.getRowBytes();
    }

    public boolean os() {
        if (this.NF && !this.NL.get()) {
            if (this.NE != null) {
                Bitmap bitmap = this.NE;
                this.NE = null;
                bitmap.recycle();
            }
            if (this.NM != null) {
                com.baidu.adp.gif.b bVar = this.NM;
                this.NM = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap ot() {
        this.NF = false;
        return this.NE;
    }

    public boolean ou() {
        return this.NE != null;
    }

    public BitmapDrawable ov() {
        if (this.NE == null) {
            return null;
        }
        this.NF = false;
        return new BitmapDrawable(this.NE) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.NE != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.NE, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] ow() {
        byte[] byteArray;
        if (this.NE == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.NE.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect ox() {
        return this.NP;
    }

    public byte[] oy() {
        return this.NG;
    }

    public BitmapShader oz() {
        if (this.NE == null || this.NE.isRecycled()) {
            return null;
        }
        this.NF = false;
        return new BitmapShader(this.NE, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void at(boolean z) {
        this.NL.set(z);
    }

    public boolean oA() {
        return this.NQ;
    }

    public void be(int i) {
        this.NJ = i;
    }

    public void bf(int i) {
        this.NK = i;
    }
}
