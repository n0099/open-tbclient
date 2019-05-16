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
    private boolean LA;
    private byte[] LB;
    private int LC;
    private int LD;
    private int LE;
    private int LG;
    private AtomicBoolean LH;
    private com.baidu.adp.gif.b LI;
    private boolean LJ;
    public Rect LK;
    private boolean LM;
    private NinePatch LN;
    public C0025a LO;
    private Bitmap Lz;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0025a {
        public String LQ;
        public long LR;
        public boolean LS;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Lz = null;
        this.isGif = false;
        this.LA = true;
        this.LB = null;
        this.LC = -1;
        this.LD = -1;
        this.LH = new AtomicBoolean(false);
        this.LJ = false;
        this.timeStamp = -1L;
        this.LM = false;
        this.LO = new C0025a();
        this.Lz = bitmap;
        this.isGif = z;
        np();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Lz = null;
        this.isGif = false;
        this.LA = true;
        this.LB = null;
        this.LC = -1;
        this.LD = -1;
        this.LH = new AtomicBoolean(false);
        this.LJ = false;
        this.timeStamp = -1L;
        this.LM = false;
        this.LO = new C0025a();
        this.Lz = bitmap;
        this.isGif = z;
        this.url = str;
        np();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Lz = null;
        this.isGif = false;
        this.LA = true;
        this.LB = null;
        this.LC = -1;
        this.LD = -1;
        this.LH = new AtomicBoolean(false);
        this.LJ = false;
        this.timeStamp = -1L;
        this.LM = false;
        this.LO = new C0025a();
        this.Lz = bitmap;
        this.isGif = z;
        this.url = str;
        this.LK = rect;
        np();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Lz = null;
        this.isGif = false;
        this.LA = true;
        this.LB = null;
        this.LC = -1;
        this.LD = -1;
        this.LH = new AtomicBoolean(false);
        this.LJ = false;
        this.timeStamp = -1L;
        this.LM = false;
        this.LO = new C0025a();
        this.Lz = bitmap;
        this.isGif = z;
        this.url = str;
        this.LB = bArr;
        np();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.Lz = null;
        this.isGif = false;
        this.LA = true;
        this.LB = null;
        this.LC = -1;
        this.LD = -1;
        this.LH = new AtomicBoolean(false);
        this.LJ = false;
        this.timeStamp = -1L;
        this.LM = false;
        this.LO = new C0025a();
        this.LI = bVar;
        this.Lz = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Lz = null;
        this.isGif = false;
        this.LA = true;
        this.LB = null;
        this.LC = -1;
        this.LD = -1;
        this.LH = new AtomicBoolean(false);
        this.LJ = false;
        this.timeStamp = -1L;
        this.LM = false;
        this.LO = new C0025a();
        this.LI = bVar;
        this.LJ = true;
    }

    private void np() {
        byte[] ninePatchChunk;
        if (this.Lz != null && (ninePatchChunk = this.Lz.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.LM = true;
            this.LN = new NinePatch(this.Lz, ninePatchChunk, "image");
        }
    }

    public boolean nq() {
        return this.LJ;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.LI;
    }

    public int getWidth() {
        if (this.Lz == null) {
            return 0;
        }
        return this.Lz.getWidth();
    }

    public int getHeight() {
        if (this.Lz == null) {
            return 0;
        }
        return this.Lz.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Lz != null) {
            this.LH.set(true);
            canvas.drawBitmap(this.Lz, matrix, paint);
            this.LH.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Lz != null) {
            this.LH.set(true);
            canvas.drawBitmap(this.Lz, f, f2, paint);
            this.LH.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Lz != null) {
            this.LH.set(true);
            canvas.drawBitmap(this.Lz, rect, rectF, paint);
            this.LH.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Lz != null) {
            this.LA = false;
            imageView.setImageBitmap(this.Lz);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.LM && this.LN != null) {
            this.LN.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Lz == null) {
            return 0;
        }
        return this.Lz.getHeight() * this.Lz.getRowBytes();
    }

    public boolean nr() {
        if (this.LA && !this.LH.get()) {
            if (this.Lz != null) {
                Bitmap bitmap = this.Lz;
                this.Lz = null;
                bitmap.recycle();
            }
            if (this.LI != null) {
                com.baidu.adp.gif.b bVar = this.LI;
                this.LI = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap ns() {
        this.LA = false;
        return this.Lz;
    }

    public boolean nt() {
        return this.Lz != null;
    }

    public BitmapDrawable nu() {
        if (this.Lz == null) {
            return null;
        }
        this.LA = false;
        return new BitmapDrawable(this.Lz) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Lz != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Lz, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] nv() {
        byte[] byteArray;
        if (this.Lz == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Lz.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect nw() {
        return this.LK;
    }

    public byte[] nx() {
        return this.LB;
    }

    public BitmapShader ny() {
        if (this.Lz == null || this.Lz.isRecycled()) {
            return null;
        }
        this.LA = false;
        return new BitmapShader(this.Lz, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void am(boolean z) {
        this.LH.set(z);
    }

    public boolean nz() {
        return this.LM;
    }

    public void aG(int i) {
        this.LE = i;
    }

    public void aH(int i) {
        this.LG = i;
    }
}
