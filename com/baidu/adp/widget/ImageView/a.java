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
    private byte[] LA;
    private int LB;
    private int LC;
    private int LD;
    private int LE;
    private AtomicBoolean LG;
    private com.baidu.adp.gif.b LH;
    private boolean LI;
    public Rect LJ;
    private boolean LK;
    private NinePatch LM;
    public C0025a LN;
    private Bitmap Ly;
    private boolean Lz;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0025a {
        public String LP;
        public long LQ;
        public boolean LR;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Ly = null;
        this.isGif = false;
        this.Lz = true;
        this.LA = null;
        this.LB = -1;
        this.LC = -1;
        this.LG = new AtomicBoolean(false);
        this.LI = false;
        this.timeStamp = -1L;
        this.LK = false;
        this.LN = new C0025a();
        this.Ly = bitmap;
        this.isGif = z;
        np();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Ly = null;
        this.isGif = false;
        this.Lz = true;
        this.LA = null;
        this.LB = -1;
        this.LC = -1;
        this.LG = new AtomicBoolean(false);
        this.LI = false;
        this.timeStamp = -1L;
        this.LK = false;
        this.LN = new C0025a();
        this.Ly = bitmap;
        this.isGif = z;
        this.url = str;
        np();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Ly = null;
        this.isGif = false;
        this.Lz = true;
        this.LA = null;
        this.LB = -1;
        this.LC = -1;
        this.LG = new AtomicBoolean(false);
        this.LI = false;
        this.timeStamp = -1L;
        this.LK = false;
        this.LN = new C0025a();
        this.Ly = bitmap;
        this.isGif = z;
        this.url = str;
        this.LJ = rect;
        np();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Ly = null;
        this.isGif = false;
        this.Lz = true;
        this.LA = null;
        this.LB = -1;
        this.LC = -1;
        this.LG = new AtomicBoolean(false);
        this.LI = false;
        this.timeStamp = -1L;
        this.LK = false;
        this.LN = new C0025a();
        this.Ly = bitmap;
        this.isGif = z;
        this.url = str;
        this.LA = bArr;
        np();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.Ly = null;
        this.isGif = false;
        this.Lz = true;
        this.LA = null;
        this.LB = -1;
        this.LC = -1;
        this.LG = new AtomicBoolean(false);
        this.LI = false;
        this.timeStamp = -1L;
        this.LK = false;
        this.LN = new C0025a();
        this.LH = bVar;
        this.Ly = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Ly = null;
        this.isGif = false;
        this.Lz = true;
        this.LA = null;
        this.LB = -1;
        this.LC = -1;
        this.LG = new AtomicBoolean(false);
        this.LI = false;
        this.timeStamp = -1L;
        this.LK = false;
        this.LN = new C0025a();
        this.LH = bVar;
        this.LI = true;
    }

    private void np() {
        byte[] ninePatchChunk;
        if (this.Ly != null && (ninePatchChunk = this.Ly.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.LK = true;
            this.LM = new NinePatch(this.Ly, ninePatchChunk, "image");
        }
    }

    public boolean nq() {
        return this.LI;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.LH;
    }

    public int getWidth() {
        if (this.Ly == null) {
            return 0;
        }
        return this.Ly.getWidth();
    }

    public int getHeight() {
        if (this.Ly == null) {
            return 0;
        }
        return this.Ly.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Ly != null) {
            this.LG.set(true);
            canvas.drawBitmap(this.Ly, matrix, paint);
            this.LG.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Ly != null) {
            this.LG.set(true);
            canvas.drawBitmap(this.Ly, f, f2, paint);
            this.LG.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Ly != null) {
            this.LG.set(true);
            canvas.drawBitmap(this.Ly, rect, rectF, paint);
            this.LG.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Ly != null) {
            this.Lz = false;
            imageView.setImageBitmap(this.Ly);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.LK && this.LM != null) {
            this.LM.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Ly == null) {
            return 0;
        }
        return this.Ly.getHeight() * this.Ly.getRowBytes();
    }

    public boolean nr() {
        if (this.Lz && !this.LG.get()) {
            if (this.Ly != null) {
                Bitmap bitmap = this.Ly;
                this.Ly = null;
                bitmap.recycle();
            }
            if (this.LH != null) {
                com.baidu.adp.gif.b bVar = this.LH;
                this.LH = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap ns() {
        this.Lz = false;
        return this.Ly;
    }

    public boolean nt() {
        return this.Ly != null;
    }

    public BitmapDrawable nu() {
        if (this.Ly == null) {
            return null;
        }
        this.Lz = false;
        return new BitmapDrawable(this.Ly) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Ly != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Ly, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] nv() {
        byte[] byteArray;
        if (this.Ly == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Ly.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect nw() {
        return this.LJ;
    }

    public byte[] nx() {
        return this.LA;
    }

    public BitmapShader ny() {
        if (this.Ly == null || this.Ly.isRecycled()) {
            return null;
        }
        this.Lz = false;
        return new BitmapShader(this.Ly, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void am(boolean z) {
        this.LG.set(z);
    }

    public boolean nz() {
        return this.LK;
    }

    public void aG(int i) {
        this.LD = i;
    }

    public void aH(int i) {
        this.LE = i;
    }
}
