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
    private Bitmap Gn;
    private boolean Go;
    private byte[] Gp;
    private int Gq;
    private int Gr;
    private AtomicBoolean Gs;
    private com.baidu.adp.gif.b Gt;
    private boolean Gu;
    public Rect Gv;
    private boolean Gw;
    private NinePatch Gx;
    public C0013a Gy;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a {
        public String GA;
        public long GB;
        public boolean GC;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Gn = null;
        this.isGif = false;
        this.Go = true;
        this.Gp = null;
        this.Gq = -1;
        this.Gr = -1;
        this.Gs = new AtomicBoolean(false);
        this.Gu = false;
        this.timeStamp = -1L;
        this.Gw = false;
        this.Gy = new C0013a();
        this.Gn = bitmap;
        this.isGif = z;
        kK();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Gn = null;
        this.isGif = false;
        this.Go = true;
        this.Gp = null;
        this.Gq = -1;
        this.Gr = -1;
        this.Gs = new AtomicBoolean(false);
        this.Gu = false;
        this.timeStamp = -1L;
        this.Gw = false;
        this.Gy = new C0013a();
        this.Gn = bitmap;
        this.isGif = z;
        this.url = str;
        kK();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Gn = null;
        this.isGif = false;
        this.Go = true;
        this.Gp = null;
        this.Gq = -1;
        this.Gr = -1;
        this.Gs = new AtomicBoolean(false);
        this.Gu = false;
        this.timeStamp = -1L;
        this.Gw = false;
        this.Gy = new C0013a();
        this.Gn = bitmap;
        this.isGif = z;
        this.url = str;
        this.Gv = rect;
        kK();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Gn = null;
        this.isGif = false;
        this.Go = true;
        this.Gp = null;
        this.Gq = -1;
        this.Gr = -1;
        this.Gs = new AtomicBoolean(false);
        this.Gu = false;
        this.timeStamp = -1L;
        this.Gw = false;
        this.Gy = new C0013a();
        this.Gn = bitmap;
        this.isGif = z;
        this.url = str;
        this.Gp = bArr;
        kK();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Gn = null;
        this.isGif = false;
        this.Go = true;
        this.Gp = null;
        this.Gq = -1;
        this.Gr = -1;
        this.Gs = new AtomicBoolean(false);
        this.Gu = false;
        this.timeStamp = -1L;
        this.Gw = false;
        this.Gy = new C0013a();
        this.Gt = bVar;
        this.Gu = true;
    }

    private void kK() {
        byte[] ninePatchChunk;
        if (this.Gn != null && (ninePatchChunk = this.Gn.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Gw = true;
            this.Gx = new NinePatch(this.Gn, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean kL() {
        return this.Gu;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.Gt;
    }

    public int getWidth() {
        if (this.Gn == null) {
            return 0;
        }
        return this.Gn.getWidth();
    }

    public int getHeight() {
        if (this.Gn == null) {
            return 0;
        }
        return this.Gn.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Gn != null) {
            this.Gs.set(true);
            canvas.drawBitmap(this.Gn, matrix, paint);
            this.Gs.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Gn != null) {
            this.Gs.set(true);
            canvas.drawBitmap(this.Gn, f, f2, paint);
            this.Gs.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Gn != null) {
            this.Gs.set(true);
            canvas.drawBitmap(this.Gn, rect, rectF, paint);
            this.Gs.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Gn != null) {
            this.Go = false;
            imageView.setImageBitmap(this.Gn);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Gw && this.Gx != null) {
            this.Gx.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Gn == null) {
            return 0;
        }
        return this.Gn.getHeight() * this.Gn.getRowBytes();
    }

    public boolean kM() {
        if (this.Go && !this.Gs.get()) {
            if (this.Gn != null) {
                Bitmap bitmap = this.Gn;
                this.Gn = null;
                bitmap.recycle();
            }
            if (this.Gt != null) {
                com.baidu.adp.gif.b bVar = this.Gt;
                this.Gt = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap kN() {
        this.Go = false;
        return this.Gn;
    }

    public boolean kO() {
        return this.Gn != null;
    }

    public BitmapDrawable kP() {
        if (this.Gn == null) {
            return null;
        }
        this.Go = false;
        return new BitmapDrawable(this.Gn) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Gn != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Gn, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] kQ() {
        byte[] byteArray;
        if (this.Gn == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Gn.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect kR() {
        return this.Gv;
    }

    public byte[] kS() {
        return this.Gp;
    }

    public BitmapShader kT() {
        if (this.Gn == null) {
            return null;
        }
        this.Go = false;
        return new BitmapShader(this.Gn, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void S(boolean z) {
        this.Gs.set(z);
    }

    public boolean kU() {
        return this.Gw;
    }
}
