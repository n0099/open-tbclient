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
    private Bitmap KC;
    private boolean KD;
    private byte[] KE;
    private int KF;
    private int KG;
    private AtomicBoolean KH;
    private com.baidu.adp.gif.b KI;
    private boolean KJ;
    public Rect KK;
    private boolean KL;
    private NinePatch KM;
    public C0023a KN;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0023a {
        public String KP;
        public long KQ;
        public boolean KR;
    }

    public a(Bitmap bitmap, boolean z) {
        this.KC = null;
        this.isGif = false;
        this.KD = true;
        this.KE = null;
        this.KF = -1;
        this.KG = -1;
        this.KH = new AtomicBoolean(false);
        this.KJ = false;
        this.timeStamp = -1L;
        this.KL = false;
        this.KN = new C0023a();
        this.KC = bitmap;
        this.isGif = z;
        mW();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.KC = null;
        this.isGif = false;
        this.KD = true;
        this.KE = null;
        this.KF = -1;
        this.KG = -1;
        this.KH = new AtomicBoolean(false);
        this.KJ = false;
        this.timeStamp = -1L;
        this.KL = false;
        this.KN = new C0023a();
        this.KC = bitmap;
        this.isGif = z;
        this.url = str;
        mW();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.KC = null;
        this.isGif = false;
        this.KD = true;
        this.KE = null;
        this.KF = -1;
        this.KG = -1;
        this.KH = new AtomicBoolean(false);
        this.KJ = false;
        this.timeStamp = -1L;
        this.KL = false;
        this.KN = new C0023a();
        this.KC = bitmap;
        this.isGif = z;
        this.url = str;
        this.KK = rect;
        mW();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.KC = null;
        this.isGif = false;
        this.KD = true;
        this.KE = null;
        this.KF = -1;
        this.KG = -1;
        this.KH = new AtomicBoolean(false);
        this.KJ = false;
        this.timeStamp = -1L;
        this.KL = false;
        this.KN = new C0023a();
        this.KC = bitmap;
        this.isGif = z;
        this.url = str;
        this.KE = bArr;
        mW();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.KC = null;
        this.isGif = false;
        this.KD = true;
        this.KE = null;
        this.KF = -1;
        this.KG = -1;
        this.KH = new AtomicBoolean(false);
        this.KJ = false;
        this.timeStamp = -1L;
        this.KL = false;
        this.KN = new C0023a();
        this.KI = bVar;
        this.KC = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.KC = null;
        this.isGif = false;
        this.KD = true;
        this.KE = null;
        this.KF = -1;
        this.KG = -1;
        this.KH = new AtomicBoolean(false);
        this.KJ = false;
        this.timeStamp = -1L;
        this.KL = false;
        this.KN = new C0023a();
        this.KI = bVar;
        this.KJ = true;
    }

    private void mW() {
        byte[] ninePatchChunk;
        if (this.KC != null && (ninePatchChunk = this.KC.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.KL = true;
            this.KM = new NinePatch(this.KC, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean mX() {
        return this.KJ;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.KI;
    }

    public int getWidth() {
        if (this.KC == null) {
            return 0;
        }
        return this.KC.getWidth();
    }

    public int getHeight() {
        if (this.KC == null) {
            return 0;
        }
        return this.KC.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.KC != null) {
            this.KH.set(true);
            canvas.drawBitmap(this.KC, matrix, paint);
            this.KH.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.KC != null) {
            this.KH.set(true);
            canvas.drawBitmap(this.KC, f, f2, paint);
            this.KH.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.KC != null) {
            this.KH.set(true);
            canvas.drawBitmap(this.KC, rect, rectF, paint);
            this.KH.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.KC != null) {
            this.KD = false;
            imageView.setImageBitmap(this.KC);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.KL && this.KM != null) {
            this.KM.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.KC == null) {
            return 0;
        }
        return this.KC.getHeight() * this.KC.getRowBytes();
    }

    public boolean mY() {
        if (this.KD && !this.KH.get()) {
            if (this.KC != null) {
                Bitmap bitmap = this.KC;
                this.KC = null;
                bitmap.recycle();
            }
            if (this.KI != null) {
                com.baidu.adp.gif.b bVar = this.KI;
                this.KI = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap mZ() {
        this.KD = false;
        return this.KC;
    }

    public boolean na() {
        return this.KC != null;
    }

    public BitmapDrawable nb() {
        if (this.KC == null) {
            return null;
        }
        this.KD = false;
        return new BitmapDrawable(this.KC) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.KC != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.KC, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] nc() {
        byte[] byteArray;
        if (this.KC == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.KC.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect nd() {
        return this.KK;
    }

    public byte[] ne() {
        return this.KE;
    }

    public BitmapShader nf() {
        if (this.KC == null || this.KC.isRecycled()) {
            return null;
        }
        this.KD = false;
        return new BitmapShader(this.KC, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void X(boolean z) {
        this.KH.set(z);
    }

    public boolean ng() {
        return this.KL;
    }
}
