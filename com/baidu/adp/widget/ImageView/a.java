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
    private Bitmap LN;
    private boolean LO;
    private byte[] LP;
    private int LQ;
    private int LR;
    private int LS;
    private int LU;
    private AtomicBoolean LV;
    private com.baidu.adp.gif.b LW;
    private boolean LX;
    public Rect LY;
    private boolean LZ;
    private NinePatch Ma;
    public C0025a Mb;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0025a {
        public String Md;
        public long Me;
        public boolean Mf;
    }

    public a(Bitmap bitmap, boolean z) {
        this.LN = null;
        this.isGif = false;
        this.LO = true;
        this.LP = null;
        this.LQ = -1;
        this.LR = -1;
        this.LV = new AtomicBoolean(false);
        this.LX = false;
        this.timeStamp = -1L;
        this.LZ = false;
        this.Mb = new C0025a();
        this.LN = bitmap;
        this.isGif = z;
        nH();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.LN = null;
        this.isGif = false;
        this.LO = true;
        this.LP = null;
        this.LQ = -1;
        this.LR = -1;
        this.LV = new AtomicBoolean(false);
        this.LX = false;
        this.timeStamp = -1L;
        this.LZ = false;
        this.Mb = new C0025a();
        this.LN = bitmap;
        this.isGif = z;
        this.url = str;
        nH();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.LN = null;
        this.isGif = false;
        this.LO = true;
        this.LP = null;
        this.LQ = -1;
        this.LR = -1;
        this.LV = new AtomicBoolean(false);
        this.LX = false;
        this.timeStamp = -1L;
        this.LZ = false;
        this.Mb = new C0025a();
        this.LN = bitmap;
        this.isGif = z;
        this.url = str;
        this.LY = rect;
        nH();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.LN = null;
        this.isGif = false;
        this.LO = true;
        this.LP = null;
        this.LQ = -1;
        this.LR = -1;
        this.LV = new AtomicBoolean(false);
        this.LX = false;
        this.timeStamp = -1L;
        this.LZ = false;
        this.Mb = new C0025a();
        this.LN = bitmap;
        this.isGif = z;
        this.url = str;
        this.LP = bArr;
        nH();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.LN = null;
        this.isGif = false;
        this.LO = true;
        this.LP = null;
        this.LQ = -1;
        this.LR = -1;
        this.LV = new AtomicBoolean(false);
        this.LX = false;
        this.timeStamp = -1L;
        this.LZ = false;
        this.Mb = new C0025a();
        this.LW = bVar;
        this.LN = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.LN = null;
        this.isGif = false;
        this.LO = true;
        this.LP = null;
        this.LQ = -1;
        this.LR = -1;
        this.LV = new AtomicBoolean(false);
        this.LX = false;
        this.timeStamp = -1L;
        this.LZ = false;
        this.Mb = new C0025a();
        this.LW = bVar;
        this.LX = true;
    }

    private void nH() {
        byte[] ninePatchChunk;
        if (this.LN != null && (ninePatchChunk = this.LN.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.LZ = true;
            this.Ma = new NinePatch(this.LN, ninePatchChunk, "image");
        }
    }

    public boolean nI() {
        return this.LX;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.LW;
    }

    public int getWidth() {
        if (this.LN == null) {
            return 0;
        }
        return this.LN.getWidth();
    }

    public int getHeight() {
        if (this.LN == null) {
            return 0;
        }
        return this.LN.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.LN != null) {
            this.LV.set(true);
            canvas.drawBitmap(this.LN, matrix, paint);
            this.LV.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.LN != null) {
            this.LV.set(true);
            canvas.drawBitmap(this.LN, f, f2, paint);
            this.LV.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.LN != null) {
            this.LV.set(true);
            canvas.drawBitmap(this.LN, rect, rectF, paint);
            this.LV.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.LN != null) {
            this.LO = false;
            imageView.setImageBitmap(this.LN);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.LZ && this.Ma != null) {
            this.Ma.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.LN == null) {
            return 0;
        }
        return this.LN.getHeight() * this.LN.getRowBytes();
    }

    public boolean nJ() {
        if (this.LO && !this.LV.get()) {
            if (this.LN != null) {
                Bitmap bitmap = this.LN;
                this.LN = null;
                bitmap.recycle();
            }
            if (this.LW != null) {
                com.baidu.adp.gif.b bVar = this.LW;
                this.LW = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap nK() {
        this.LO = false;
        return this.LN;
    }

    public boolean nL() {
        return this.LN != null;
    }

    public BitmapDrawable nM() {
        if (this.LN == null) {
            return null;
        }
        this.LO = false;
        return new BitmapDrawable(this.LN) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.LN != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.LN, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] nN() {
        byte[] byteArray;
        if (this.LN == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.LN.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect nO() {
        return this.LY;
    }

    public byte[] nP() {
        return this.LP;
    }

    public BitmapShader nQ() {
        if (this.LN == null || this.LN.isRecycled()) {
            return null;
        }
        this.LO = false;
        return new BitmapShader(this.LN, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void ap(boolean z) {
        this.LV.set(z);
    }

    public boolean nR() {
        return this.LZ;
    }

    public void aG(int i) {
        this.LS = i;
    }

    public void aH(int i) {
        this.LU = i;
    }
}
