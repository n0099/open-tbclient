package com.baidu.adp.widget.a;

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
import com.baidu.adp.gif.b;
import com.baidu.tbadk.TbConfig;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static final Object lockForSyncImageDecoder = new Object();
    private NinePatch IA;
    public C0015a IB;
    private Bitmap Iq;
    private boolean Ir;
    private byte[] Is;
    private int It;
    private int Iu;
    private AtomicBoolean Iv;
    private b Iw;
    private boolean Ix;
    public Rect Iy;
    private boolean Iz;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a {
        public String IE;
        public long IF;
        public boolean IG;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Iq = null;
        this.isGif = false;
        this.Ir = true;
        this.Is = null;
        this.It = -1;
        this.Iu = -1;
        this.Iv = new AtomicBoolean(false);
        this.Ix = false;
        this.timeStamp = -1L;
        this.Iz = false;
        this.IB = new C0015a();
        this.Iq = bitmap;
        this.isGif = z;
        kU();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Iq = null;
        this.isGif = false;
        this.Ir = true;
        this.Is = null;
        this.It = -1;
        this.Iu = -1;
        this.Iv = new AtomicBoolean(false);
        this.Ix = false;
        this.timeStamp = -1L;
        this.Iz = false;
        this.IB = new C0015a();
        this.Iq = bitmap;
        this.isGif = z;
        this.url = str;
        kU();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Iq = null;
        this.isGif = false;
        this.Ir = true;
        this.Is = null;
        this.It = -1;
        this.Iu = -1;
        this.Iv = new AtomicBoolean(false);
        this.Ix = false;
        this.timeStamp = -1L;
        this.Iz = false;
        this.IB = new C0015a();
        this.Iq = bitmap;
        this.isGif = z;
        this.url = str;
        this.Iy = rect;
        kU();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Iq = null;
        this.isGif = false;
        this.Ir = true;
        this.Is = null;
        this.It = -1;
        this.Iu = -1;
        this.Iv = new AtomicBoolean(false);
        this.Ix = false;
        this.timeStamp = -1L;
        this.Iz = false;
        this.IB = new C0015a();
        this.Iq = bitmap;
        this.isGif = z;
        this.url = str;
        this.Is = bArr;
        kU();
    }

    public a(b bVar) {
        this.Iq = null;
        this.isGif = false;
        this.Ir = true;
        this.Is = null;
        this.It = -1;
        this.Iu = -1;
        this.Iv = new AtomicBoolean(false);
        this.Ix = false;
        this.timeStamp = -1L;
        this.Iz = false;
        this.IB = new C0015a();
        this.Iw = bVar;
        this.Ix = true;
    }

    private void kU() {
        byte[] ninePatchChunk;
        if (this.Iq != null && (ninePatchChunk = this.Iq.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Iz = true;
            this.IA = new NinePatch(this.Iq, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean kV() {
        return this.Ix;
    }

    public b getGif() {
        return this.Iw;
    }

    public int getWidth() {
        if (this.Iq == null) {
            return 0;
        }
        return this.Iq.getWidth();
    }

    public int getHeight() {
        if (this.Iq == null) {
            return 0;
        }
        return this.Iq.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Iq != null) {
            this.Iv.set(true);
            canvas.drawBitmap(this.Iq, matrix, paint);
            this.Iv.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Iq != null) {
            this.Iv.set(true);
            canvas.drawBitmap(this.Iq, f, f2, paint);
            this.Iv.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Iq != null) {
            this.Iv.set(true);
            canvas.drawBitmap(this.Iq, rect, rectF, paint);
            this.Iv.set(false);
        }
    }

    public void e(ImageView imageView) {
        if (imageView != null && this.Iq != null) {
            this.Ir = false;
            imageView.setImageBitmap(this.Iq);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Iz && this.IA != null) {
            this.IA.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Iq == null) {
            return 0;
        }
        return this.Iq.getHeight() * this.Iq.getRowBytes();
    }

    public boolean kW() {
        if (this.Ir && !this.Iv.get()) {
            if (this.Iq != null) {
                Bitmap bitmap = this.Iq;
                this.Iq = null;
                bitmap.recycle();
            }
            if (this.Iw != null) {
                b bVar = this.Iw;
                this.Iw = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap kX() {
        this.Ir = false;
        return this.Iq;
    }

    public boolean kY() {
        return this.Iq != null;
    }

    public BitmapDrawable kZ() {
        if (this.Iq == null) {
            return null;
        }
        this.Ir = false;
        return new BitmapDrawable(this.Iq) { // from class: com.baidu.adp.widget.a.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Iq != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Iq, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] la() {
        byte[] byteArray;
        if (this.Iq == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Iq.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect lb() {
        return this.Iy;
    }

    public byte[] lc() {
        return this.Is;
    }

    public BitmapShader ld() {
        if (this.Iq == null) {
            return null;
        }
        this.Ir = false;
        return new BitmapShader(this.Iq, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void R(boolean z) {
        this.Iv.set(z);
    }

    public boolean le() {
        return this.Iz;
    }
}
