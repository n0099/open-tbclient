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
import com.baidu.tbadk.TbConfig;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static final Object lockForSyncImageDecoder = new Object();
    private byte[] KA;
    private int KB;
    private int KC;
    private AtomicBoolean KD;
    private com.baidu.adp.gif.b KE;
    private boolean KF;
    public Rect KG;
    private boolean KH;
    private NinePatch KI;
    public C0023a KJ;
    private Bitmap Ky;
    private boolean Kz;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0023a {
        public String KL;
        public long KM;
        public boolean KN;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Ky = null;
        this.isGif = false;
        this.Kz = true;
        this.KA = null;
        this.KB = -1;
        this.KC = -1;
        this.KD = new AtomicBoolean(false);
        this.KF = false;
        this.timeStamp = -1L;
        this.KH = false;
        this.KJ = new C0023a();
        this.Ky = bitmap;
        this.isGif = z;
        mY();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Ky = null;
        this.isGif = false;
        this.Kz = true;
        this.KA = null;
        this.KB = -1;
        this.KC = -1;
        this.KD = new AtomicBoolean(false);
        this.KF = false;
        this.timeStamp = -1L;
        this.KH = false;
        this.KJ = new C0023a();
        this.Ky = bitmap;
        this.isGif = z;
        this.url = str;
        mY();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Ky = null;
        this.isGif = false;
        this.Kz = true;
        this.KA = null;
        this.KB = -1;
        this.KC = -1;
        this.KD = new AtomicBoolean(false);
        this.KF = false;
        this.timeStamp = -1L;
        this.KH = false;
        this.KJ = new C0023a();
        this.Ky = bitmap;
        this.isGif = z;
        this.url = str;
        this.KG = rect;
        mY();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Ky = null;
        this.isGif = false;
        this.Kz = true;
        this.KA = null;
        this.KB = -1;
        this.KC = -1;
        this.KD = new AtomicBoolean(false);
        this.KF = false;
        this.timeStamp = -1L;
        this.KH = false;
        this.KJ = new C0023a();
        this.Ky = bitmap;
        this.isGif = z;
        this.url = str;
        this.KA = bArr;
        mY();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.Ky = null;
        this.isGif = false;
        this.Kz = true;
        this.KA = null;
        this.KB = -1;
        this.KC = -1;
        this.KD = new AtomicBoolean(false);
        this.KF = false;
        this.timeStamp = -1L;
        this.KH = false;
        this.KJ = new C0023a();
        this.KE = bVar;
        this.Ky = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Ky = null;
        this.isGif = false;
        this.Kz = true;
        this.KA = null;
        this.KB = -1;
        this.KC = -1;
        this.KD = new AtomicBoolean(false);
        this.KF = false;
        this.timeStamp = -1L;
        this.KH = false;
        this.KJ = new C0023a();
        this.KE = bVar;
        this.KF = true;
    }

    private void mY() {
        byte[] ninePatchChunk;
        if (this.Ky != null && (ninePatchChunk = this.Ky.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.KH = true;
            this.KI = new NinePatch(this.Ky, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean mZ() {
        return this.KF;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.KE;
    }

    public int getWidth() {
        if (this.Ky == null) {
            return 0;
        }
        return this.Ky.getWidth();
    }

    public int getHeight() {
        if (this.Ky == null) {
            return 0;
        }
        return this.Ky.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Ky != null) {
            this.KD.set(true);
            canvas.drawBitmap(this.Ky, matrix, paint);
            this.KD.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Ky != null) {
            this.KD.set(true);
            canvas.drawBitmap(this.Ky, f, f2, paint);
            this.KD.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Ky != null) {
            this.KD.set(true);
            canvas.drawBitmap(this.Ky, rect, rectF, paint);
            this.KD.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Ky != null) {
            this.Kz = false;
            imageView.setImageBitmap(this.Ky);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.KH && this.KI != null) {
            this.KI.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Ky == null) {
            return 0;
        }
        return this.Ky.getHeight() * this.Ky.getRowBytes();
    }

    public boolean na() {
        if (this.Kz && !this.KD.get()) {
            if (this.Ky != null) {
                Bitmap bitmap = this.Ky;
                this.Ky = null;
                bitmap.recycle();
            }
            if (this.KE != null) {
                com.baidu.adp.gif.b bVar = this.KE;
                this.KE = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap nb() {
        this.Kz = false;
        return this.Ky;
    }

    public boolean nc() {
        return this.Ky != null;
    }

    public BitmapDrawable nd() {
        if (this.Ky == null) {
            return null;
        }
        this.Kz = false;
        return new BitmapDrawable(this.Ky) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Ky != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Ky, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] ne() {
        byte[] byteArray;
        if (this.Ky == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Ky.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect nf() {
        return this.KG;
    }

    public byte[] ng() {
        return this.KA;
    }

    public BitmapShader nh() {
        if (this.Ky == null || this.Ky.isRecycled()) {
            return null;
        }
        this.Kz = false;
        return new BitmapShader(this.Ky, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void W(boolean z) {
        this.KD.set(z);
    }

    public boolean ni() {
        return this.KH;
    }
}
