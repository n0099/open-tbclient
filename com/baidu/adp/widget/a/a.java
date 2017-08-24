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
    public Rect IA;
    private boolean IB;
    private NinePatch IC;
    public C0014a IE;
    private Bitmap Is;
    private boolean It;
    private byte[] Iu;
    private int Iv;
    private int Iw;
    private AtomicBoolean Ix;
    private b Iy;
    private boolean Iz;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014a {
        public String IG;
        public long IH;
        public boolean II;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Is = null;
        this.isGif = false;
        this.It = true;
        this.Iu = null;
        this.Iv = -1;
        this.Iw = -1;
        this.Ix = new AtomicBoolean(false);
        this.Iz = false;
        this.timeStamp = -1L;
        this.IB = false;
        this.IE = new C0014a();
        this.Is = bitmap;
        this.isGif = z;
        kT();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Is = null;
        this.isGif = false;
        this.It = true;
        this.Iu = null;
        this.Iv = -1;
        this.Iw = -1;
        this.Ix = new AtomicBoolean(false);
        this.Iz = false;
        this.timeStamp = -1L;
        this.IB = false;
        this.IE = new C0014a();
        this.Is = bitmap;
        this.isGif = z;
        this.url = str;
        kT();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Is = null;
        this.isGif = false;
        this.It = true;
        this.Iu = null;
        this.Iv = -1;
        this.Iw = -1;
        this.Ix = new AtomicBoolean(false);
        this.Iz = false;
        this.timeStamp = -1L;
        this.IB = false;
        this.IE = new C0014a();
        this.Is = bitmap;
        this.isGif = z;
        this.url = str;
        this.IA = rect;
        kT();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Is = null;
        this.isGif = false;
        this.It = true;
        this.Iu = null;
        this.Iv = -1;
        this.Iw = -1;
        this.Ix = new AtomicBoolean(false);
        this.Iz = false;
        this.timeStamp = -1L;
        this.IB = false;
        this.IE = new C0014a();
        this.Is = bitmap;
        this.isGif = z;
        this.url = str;
        this.Iu = bArr;
        kT();
    }

    public a(b bVar) {
        this.Is = null;
        this.isGif = false;
        this.It = true;
        this.Iu = null;
        this.Iv = -1;
        this.Iw = -1;
        this.Ix = new AtomicBoolean(false);
        this.Iz = false;
        this.timeStamp = -1L;
        this.IB = false;
        this.IE = new C0014a();
        this.Iy = bVar;
        this.Iz = true;
    }

    private void kT() {
        byte[] ninePatchChunk;
        if (this.Is != null && (ninePatchChunk = this.Is.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.IB = true;
            this.IC = new NinePatch(this.Is, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean kU() {
        return this.Iz;
    }

    public b getGif() {
        return this.Iy;
    }

    public int getWidth() {
        if (this.Is == null) {
            return 0;
        }
        return this.Is.getWidth();
    }

    public int getHeight() {
        if (this.Is == null) {
            return 0;
        }
        return this.Is.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Is != null) {
            this.Ix.set(true);
            canvas.drawBitmap(this.Is, matrix, paint);
            this.Ix.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Is != null) {
            this.Ix.set(true);
            canvas.drawBitmap(this.Is, f, f2, paint);
            this.Ix.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Is != null) {
            this.Ix.set(true);
            canvas.drawBitmap(this.Is, rect, rectF, paint);
            this.Ix.set(false);
        }
    }

    public void e(ImageView imageView) {
        if (imageView != null && this.Is != null) {
            this.It = false;
            imageView.setImageBitmap(this.Is);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.IB && this.IC != null) {
            this.IC.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Is == null) {
            return 0;
        }
        return this.Is.getHeight() * this.Is.getRowBytes();
    }

    public boolean kV() {
        if (this.It && !this.Ix.get()) {
            if (this.Is != null) {
                Bitmap bitmap = this.Is;
                this.Is = null;
                bitmap.recycle();
            }
            if (this.Iy != null) {
                b bVar = this.Iy;
                this.Iy = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap kW() {
        this.It = false;
        return this.Is;
    }

    public boolean kX() {
        return this.Is != null;
    }

    public BitmapDrawable kY() {
        if (this.Is == null) {
            return null;
        }
        this.It = false;
        return new BitmapDrawable(this.Is) { // from class: com.baidu.adp.widget.a.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Is != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Is, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] kZ() {
        byte[] byteArray;
        if (this.Is == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Is.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect la() {
        return this.IA;
    }

    public byte[] lb() {
        return this.Iu;
    }

    public BitmapShader lc() {
        if (this.Is == null) {
            return null;
        }
        this.It = false;
        return new BitmapShader(this.Is, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void R(boolean z) {
        this.Ix.set(z);
    }

    public boolean ld() {
        return this.IB;
    }
}
