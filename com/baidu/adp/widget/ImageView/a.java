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
    private Bitmap Go;
    private boolean Gp;
    private byte[] Gq;
    private int Gr;
    private int Gs;
    private AtomicBoolean Gt;
    private com.baidu.adp.gif.b Gu;
    private boolean Gv;
    public Rect Gw;
    private boolean Gx;
    private NinePatch Gy;
    public C0013a Gz;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a {
        public String GB;
        public long GC;
        public boolean GD;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Go = null;
        this.isGif = false;
        this.Gp = true;
        this.Gq = null;
        this.Gr = -1;
        this.Gs = -1;
        this.Gt = new AtomicBoolean(false);
        this.Gv = false;
        this.timeStamp = -1L;
        this.Gx = false;
        this.Gz = new C0013a();
        this.Go = bitmap;
        this.isGif = z;
        kK();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Go = null;
        this.isGif = false;
        this.Gp = true;
        this.Gq = null;
        this.Gr = -1;
        this.Gs = -1;
        this.Gt = new AtomicBoolean(false);
        this.Gv = false;
        this.timeStamp = -1L;
        this.Gx = false;
        this.Gz = new C0013a();
        this.Go = bitmap;
        this.isGif = z;
        this.url = str;
        kK();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Go = null;
        this.isGif = false;
        this.Gp = true;
        this.Gq = null;
        this.Gr = -1;
        this.Gs = -1;
        this.Gt = new AtomicBoolean(false);
        this.Gv = false;
        this.timeStamp = -1L;
        this.Gx = false;
        this.Gz = new C0013a();
        this.Go = bitmap;
        this.isGif = z;
        this.url = str;
        this.Gw = rect;
        kK();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Go = null;
        this.isGif = false;
        this.Gp = true;
        this.Gq = null;
        this.Gr = -1;
        this.Gs = -1;
        this.Gt = new AtomicBoolean(false);
        this.Gv = false;
        this.timeStamp = -1L;
        this.Gx = false;
        this.Gz = new C0013a();
        this.Go = bitmap;
        this.isGif = z;
        this.url = str;
        this.Gq = bArr;
        kK();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Go = null;
        this.isGif = false;
        this.Gp = true;
        this.Gq = null;
        this.Gr = -1;
        this.Gs = -1;
        this.Gt = new AtomicBoolean(false);
        this.Gv = false;
        this.timeStamp = -1L;
        this.Gx = false;
        this.Gz = new C0013a();
        this.Gu = bVar;
        this.Gv = true;
    }

    private void kK() {
        byte[] ninePatchChunk;
        if (this.Go != null && (ninePatchChunk = this.Go.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Gx = true;
            this.Gy = new NinePatch(this.Go, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean kL() {
        return this.Gv;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.Gu;
    }

    public int getWidth() {
        if (this.Go == null) {
            return 0;
        }
        return this.Go.getWidth();
    }

    public int getHeight() {
        if (this.Go == null) {
            return 0;
        }
        return this.Go.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Go != null) {
            this.Gt.set(true);
            canvas.drawBitmap(this.Go, matrix, paint);
            this.Gt.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Go != null) {
            this.Gt.set(true);
            canvas.drawBitmap(this.Go, f, f2, paint);
            this.Gt.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Go != null) {
            this.Gt.set(true);
            canvas.drawBitmap(this.Go, rect, rectF, paint);
            this.Gt.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Go != null) {
            this.Gp = false;
            imageView.setImageBitmap(this.Go);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Gx && this.Gy != null) {
            this.Gy.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Go == null) {
            return 0;
        }
        return this.Go.getHeight() * this.Go.getRowBytes();
    }

    public boolean kM() {
        if (this.Gp && !this.Gt.get()) {
            if (this.Go != null) {
                Bitmap bitmap = this.Go;
                this.Go = null;
                bitmap.recycle();
            }
            if (this.Gu != null) {
                com.baidu.adp.gif.b bVar = this.Gu;
                this.Gu = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap kN() {
        this.Gp = false;
        return this.Go;
    }

    public boolean kO() {
        return this.Go != null;
    }

    public BitmapDrawable kP() {
        if (this.Go == null) {
            return null;
        }
        this.Gp = false;
        return new BitmapDrawable(this.Go) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Go != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Go, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] kQ() {
        byte[] byteArray;
        if (this.Go == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Go.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect kR() {
        return this.Gw;
    }

    public byte[] kS() {
        return this.Gq;
    }

    public BitmapShader kT() {
        if (this.Go == null) {
            return null;
        }
        this.Gp = false;
        return new BitmapShader(this.Go, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void S(boolean z) {
        this.Gt.set(z);
    }

    public boolean kU() {
        return this.Gx;
    }
}
