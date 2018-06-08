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
    private boolean KA;
    private byte[] KC;
    private int KD;
    private int KE;
    private AtomicBoolean KF;
    private com.baidu.adp.gif.b KG;
    private boolean KH;
    public Rect KI;
    private boolean KJ;
    private NinePatch KK;
    public C0023a KL;
    private Bitmap Kz;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0023a {
        public String KN;
        public long KO;
        public boolean KP;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Kz = null;
        this.isGif = false;
        this.KA = true;
        this.KC = null;
        this.KD = -1;
        this.KE = -1;
        this.KF = new AtomicBoolean(false);
        this.KH = false;
        this.timeStamp = -1L;
        this.KJ = false;
        this.KL = new C0023a();
        this.Kz = bitmap;
        this.isGif = z;
        mW();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Kz = null;
        this.isGif = false;
        this.KA = true;
        this.KC = null;
        this.KD = -1;
        this.KE = -1;
        this.KF = new AtomicBoolean(false);
        this.KH = false;
        this.timeStamp = -1L;
        this.KJ = false;
        this.KL = new C0023a();
        this.Kz = bitmap;
        this.isGif = z;
        this.url = str;
        mW();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Kz = null;
        this.isGif = false;
        this.KA = true;
        this.KC = null;
        this.KD = -1;
        this.KE = -1;
        this.KF = new AtomicBoolean(false);
        this.KH = false;
        this.timeStamp = -1L;
        this.KJ = false;
        this.KL = new C0023a();
        this.Kz = bitmap;
        this.isGif = z;
        this.url = str;
        this.KI = rect;
        mW();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Kz = null;
        this.isGif = false;
        this.KA = true;
        this.KC = null;
        this.KD = -1;
        this.KE = -1;
        this.KF = new AtomicBoolean(false);
        this.KH = false;
        this.timeStamp = -1L;
        this.KJ = false;
        this.KL = new C0023a();
        this.Kz = bitmap;
        this.isGif = z;
        this.url = str;
        this.KC = bArr;
        mW();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.Kz = null;
        this.isGif = false;
        this.KA = true;
        this.KC = null;
        this.KD = -1;
        this.KE = -1;
        this.KF = new AtomicBoolean(false);
        this.KH = false;
        this.timeStamp = -1L;
        this.KJ = false;
        this.KL = new C0023a();
        this.KG = bVar;
        this.Kz = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Kz = null;
        this.isGif = false;
        this.KA = true;
        this.KC = null;
        this.KD = -1;
        this.KE = -1;
        this.KF = new AtomicBoolean(false);
        this.KH = false;
        this.timeStamp = -1L;
        this.KJ = false;
        this.KL = new C0023a();
        this.KG = bVar;
        this.KH = true;
    }

    private void mW() {
        byte[] ninePatchChunk;
        if (this.Kz != null && (ninePatchChunk = this.Kz.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.KJ = true;
            this.KK = new NinePatch(this.Kz, ninePatchChunk, "image");
        }
    }

    public boolean mX() {
        return this.KH;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.KG;
    }

    public int getWidth() {
        if (this.Kz == null) {
            return 0;
        }
        return this.Kz.getWidth();
    }

    public int getHeight() {
        if (this.Kz == null) {
            return 0;
        }
        return this.Kz.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Kz != null) {
            this.KF.set(true);
            canvas.drawBitmap(this.Kz, matrix, paint);
            this.KF.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Kz != null) {
            this.KF.set(true);
            canvas.drawBitmap(this.Kz, f, f2, paint);
            this.KF.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Kz != null) {
            this.KF.set(true);
            canvas.drawBitmap(this.Kz, rect, rectF, paint);
            this.KF.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Kz != null) {
            this.KA = false;
            imageView.setImageBitmap(this.Kz);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.KJ && this.KK != null) {
            this.KK.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Kz == null) {
            return 0;
        }
        return this.Kz.getHeight() * this.Kz.getRowBytes();
    }

    public boolean mY() {
        if (this.KA && !this.KF.get()) {
            if (this.Kz != null) {
                Bitmap bitmap = this.Kz;
                this.Kz = null;
                bitmap.recycle();
            }
            if (this.KG != null) {
                com.baidu.adp.gif.b bVar = this.KG;
                this.KG = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap mZ() {
        this.KA = false;
        return this.Kz;
    }

    public boolean na() {
        return this.Kz != null;
    }

    public BitmapDrawable nb() {
        if (this.Kz == null) {
            return null;
        }
        this.KA = false;
        return new BitmapDrawable(this.Kz) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Kz != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Kz, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] nc() {
        byte[] byteArray;
        if (this.Kz == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Kz.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect nd() {
        return this.KI;
    }

    public byte[] ne() {
        return this.KC;
    }

    public BitmapShader nf() {
        if (this.Kz == null || this.Kz.isRecycled()) {
            return null;
        }
        this.KA = false;
        return new BitmapShader(this.Kz, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void X(boolean z) {
        this.KF.set(z);
    }

    public boolean ng() {
        return this.KJ;
    }
}
